package whz.pti.praktikum_08.payment.dto;

public class TransferDTO {

    String userId;
    int amount;

    public TransferDTO() {
    }

    public TransferDTO(String to, int amount) {
        this.userId = to;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }
}
