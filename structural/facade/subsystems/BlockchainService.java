package structural.facade.subsystems;

/**
 * A service that handles broadcasting approved transactions to the blockchain.
 * This class represents a complex, external system interaction.
 */
public class BlockchainService {
    /**
     * Broadcasts an approved transaction to the blockchain network.
     *
     * @param transaction The transaction to be broadcasted.
     */
    public void broadcastTransaction(Transaction transaction) {
        if (transaction.isApproved()) {
            System.out.println("Transaction " + transaction.getId() + " is approved and broadcasting to the blockchain.");
            // In a real-world scenario, this would involve sending the transaction to a network node.
            System.out.println("Transaction details: Recipient " + transaction.getRecipient() + ", Amount " + transaction.getAmount());
        } else {
            System.out.println("Transaction " + transaction.getId() + " is not yet approved. Missing " +
                    (transaction.getRequiredSignatures() - transaction.getSignedBy().size()) + " signature(s).");
        }
    }
}