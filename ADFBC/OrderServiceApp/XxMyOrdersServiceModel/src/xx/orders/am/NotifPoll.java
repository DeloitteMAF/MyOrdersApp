package xx.orders.am;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import xx.orders.am.XxMyOrdersAMImpl;
import oracle.jbo.client.Configuration;
public class NotifPoll implements Job {
    public NotifPoll() {
        super();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("In exec");
        // TODO Implement this method
        XxMyOrdersAMImpl am =(XxMyOrdersAMImpl) Configuration.createRootApplicationModule("xx.orders.am.XxMyOrdersAM", "XxMyOrdersAMLocal");
        am.pushNotifications();
        Configuration.releaseRootApplicationModule(am, true);
    }
}
