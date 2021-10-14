package unit.grupo3.Biolab.utils;

public enum ProtocolsStatus {
    PENDING(1), ANALYSING(2), APPROVED(3), REPROVED(4);

    private final Integer current;

    ProtocolsStatus(Integer current) {
        this.current = current;
    }

    public Integer getCurrentStatus() {
        return current;
    }
}
