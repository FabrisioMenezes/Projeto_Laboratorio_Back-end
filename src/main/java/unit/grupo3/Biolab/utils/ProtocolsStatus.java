package unit.grupo3.Biolab.utils;

public enum ProtocolsStatus {
    PENDING(0), ANALYSING(1), APPROVED(2), REPROVED(3);

    private final Integer current;

    ProtocolsStatus(Integer current) {
        this.current = current;
    }

    public Integer getCurrentStatus() {
        return current;
    }
}
