package networking.utils;

import concurs.model.Concurent;
import networking.dto.ConcurentDTO;

public class ConcurentRequest implements Request {
    private ConcurentDTO concurentDTO;

    public ConcurentRequest(ConcurentDTO concurentDTO){
        this.concurentDTO=concurentDTO;
    }

    public ConcurentDTO getConcurentDTO() {
        return concurentDTO;
    }
}
