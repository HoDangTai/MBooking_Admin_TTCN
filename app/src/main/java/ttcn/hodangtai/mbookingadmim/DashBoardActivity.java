package ttcn.hodangtai.mbookingadmim;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoardActivity extends AppCompatActivity {

    private TextView totalTicketsCount;
    private TextView moviesShowingCount;
    private TextView todaysRevenueAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dashboard); // Đảm bảo layout file được đặt tên chính xác

        // Kết nối với các thành phần trong layout
        totalTicketsCount = findViewById(R.id.totalTicketsCount);
        moviesShowingCount = findViewById(R.id.moviesShowingCount);
        todaysRevenueAmount = findViewById(R.id.todaysRevenueAmount);

        // Dữ liệu giả lập (có thể thay thế bằng dữ liệu từ API)
        loadDashboardData();
    }

    // Phương thức giả lập để tải dữ liệu Dashboard
    private void loadDashboardData() {
        // Dữ liệu từ server/API
        int totalTickets = 1234;
        int moviesShowing = 25;
        double todaysRevenue = 12345.67;

        // Hiển thị dữ liệu trên giao diện
        totalTicketsCount.setText(String.valueOf(totalTickets));
        moviesShowingCount.setText(String.valueOf(moviesShowing));
        todaysRevenueAmount.setText("$" + todaysRevenue);

        // Thông báo cho người dùng (nếu cần)
        Toast.makeText(this, "Dashboard Data Loaded", Toast.LENGTH_SHORT).show();
    }
}
