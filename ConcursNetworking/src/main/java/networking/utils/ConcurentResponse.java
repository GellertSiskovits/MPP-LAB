package networking.utils;

import networking.dto.ConcurentDTO;

public class ConcurentResponse implements UpdateResponse{
    private ConcurentDTO concurentDTO;

    public ConcurentResponse(ConcurentDTO concurentDTO){
        this.concurentDTO = concurentDTO;
    }

    public ConcurentDTO getConcurentDTO() {
        return concurentDTO;
    }
}
