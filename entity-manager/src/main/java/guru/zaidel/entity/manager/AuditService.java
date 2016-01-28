package guru.zaidel.entity.manager;

/**
 * Created by Alexander on 25.01.2016.
 */
interface AuditService {
    public void logTransaction(int empId, String action);
}
