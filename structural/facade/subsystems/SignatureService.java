package structural.facade.subsystems;

public class SignatureService {
    public boolean signTransaction(Transaction transaction, String signer) {
        System.out.println("User " + signer + " is cryptographically signing transaction " + transaction.getId());
        // In a real-world scenario, this would involve complex cryptographic operations.
        transaction.addSignature(signer);
        return true;
    }
}