package networking.utils;

import concurs.model.Angajat;
import concurs.model.Concurent;
import concurs.model.Inscris;
import concurs.services.ConcursException;
import concurs.services.IConcursObserver;
import concurs.services.IConcursServer;
import networking.dto.ConcurentDTO;
import networking.dto.DTOUtils;
import networking.dto.UserDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConcursClientObjectWorker implements Runnable, IConcursObserver{
    private IConcursServer server;
    private Socket connection;

    private ObjectInputStream input;
    private ObjectOutputStream output;

    private volatile boolean connected;

    public ConcursClientObjectWorker(IConcursServer server, Socket connection){
        this.server=server;
        this.connection = connection;
        try{
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            connected = true;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (connected){
            try {
                Object request = input.readObject();
                Object response = handleRequest((Request) request);
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            input.close();
            output.close();
            connection.close();
        }catch (IOException e){
            System.out.print("Error"+e);
        }
    }

    private Response handleRequest(Request request){
        Response response=null;
        if (request instanceof LoginRequest){
            System.out.println("Login request ...");
            LoginRequest logReq=(LoginRequest)request;
            UserDTO udto=logReq.getUser();
            Angajat user= DTOUtils.getFromDTO(udto);
            try {
                server.login(user, this);
                return new OkResponse();
            } catch (ConcursException e) {
                connected=false;
                return new ErrorResponse(e.getMessage());
            }
        }
        if (request instanceof LogoutRequest){
            System.out.println("Logout request");
            LogoutRequest logReq=(LogoutRequest)request;
            UserDTO udto=logReq.getUser();
            Angajat user= DTOUtils.getFromDTO(udto);
            try {
                server.logout(user, this);
                connected=false;
                return new OkResponse();

            } catch (ConcursException e) {
                return new ErrorResponse(e.getMessage());
            }
        }
        if (request instanceof ConcurentRequest){
            System.out.println("RezervareRequest ...");
            ConcurentRequest rezervareRequest=(ConcurentRequest) request;
            ConcurentDTO concurentDTO=rezervareRequest.getConcurentDTO();
            Concurent concurent= DTOUtils.getFromDTO(concurentDTO);
            try {
                server.create(concurent,"desen");
                return new OkResponse();
            } catch (ConcursException e) {
                return new ErrorResponse(e.getMessage());
            }
        }

        return response;
    }


    public  void sendResponse(Response response)throws IOException{
        System.out.println("sending response "+response);
        output.writeObject(response);
        output.flush();
    }
    @Override
    public void contestantAdded(Concurent concurent) throws ConcursException {
        ConcurentDTO concurentDTO = DTOUtils.getDTO(concurent);
        System.out.print("Contestant registere");

        try{
            sendResponse(new ConcurentResponse(concurentDTO));
        }catch (IOException e){
            throw  new ConcursException("Sending errr"+e);
        }
    }


}
