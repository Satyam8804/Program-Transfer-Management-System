package com.example.ptms

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class Guidelines : AppCompatActivity() {
    private lateinit var prog_selected:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guidelines)

        val guidelines: TextView = findViewById(R.id.guidelinesView)
        val para: String = "1. A student currently studying in a program will normally not be allowed to change his/her program. However, under exceptional circumstances, a student may be allowed to change his/her program after approval.\n" +
                "\n" +
                "2. Kindly upload the parent’s consent letter with the online request.\n" +
                "\n" +
                "3. Change of Program will be done only once during the entire program.\n" +
                "\n" +
                "4. A student will be eligible to apply for change of program, only if:\n" +
                "       a) There are seats available in the program to which transfer is sought.\n" +
                "       b) The student fulfills all the requirements of admission including the marks requirement prescribed by the University relating to the program to which he/she wishes to transfer.\n" +
                "       c) The student is not or has never been under disciplinary probation.\n" +
                "       d) It does not involve the change of mode of education. Explanation: Change of mode from regular full time to ODL / Regular part -time or vice versa is not allowed.\n" +
                "       e) The student is not an advanced standing student (Migration).\n" +
                "       f) The student is not a lateral entry student admitted in standalone regular program. Explanation:\n" +
                "\n" +
                "5. The online application of the student will be forwarded to HOS(Head of School) of the concerned school (to which the student is seeking the change) by DOE (Division of Examination)\n" +
                "\n" +
                "6. The Equivalence Committee will verify the similarity/equivalence of the courses/syllabus studied by the applicant till date in the current program. The academic contents of the program in respect of the syllabus of previous years should not be materially different.\n" +
                "\n" +
                "7. The Equivalence Committee will use the Program Mapping Form available online for verifying the equivalence. The committee may reject or recommend the change of program with or without conditions as deemed fit.\n" +
                "\n" +
                "8. The total number of students per program entitled for change of program should not exceed 1% of the total strength of the program from which the transfer is being sought. If the number exceeds 1%, then a special approval for the same should be taken by DOE from the competent authorities.\n" +
                "\n" +
                "9. Change of program may lead to extension in the time taken to complete the requirements for the award of degree for the program.\n" +
                "\n" +
                "10. A non-refundable application processing fee of Rs. 1000/- will be payable along with the online request. On approval of the program change request a program change fess of Rs. 4000/- shall be required to be paid by the student.\n" +
                "\n" +
                "11. If the term fee for the new program is more than that of the current program, the cumulative fee difference (between new program and current program, for all the term(s) till the change of program is sought) is to be paid by the student at the time of depositing the “Change of Program Fee” and in future such student will continue to pay the fee as applicable to the new program.\n" +
                "\n" +
                "12. If the term fee for the current program is more than that of the new program, the cumulative fee difference (between current program and new program) for all the future terms is to be paid by the student at the time of depositing the “Change of Program Fee” and fee of the new program shall be applicable (for all future terms) to such students in their new program.\n" +
                "\n" +
                "13. Number of terms/years spent in the previous program will be considered for the calculation of maximum duration for the completion of new program.\n" +
                "\n" +
                "14. Change of program may lead to extension in the time taken to complete the requirements for the award of degree for the program.\n" +
                "\n" +
                "25. The opted Minor Elective area as per old program is subjected to verification for continuation in New Program for approved cases.\n";

        guidelines.text = para;
        guidelines.movementMethod = ScrollingMovementMethod();
        prog_selected = intent.getStringExtra("selected_program").toString();

        val changeBtn: Button = findViewById(R.id.button)
        val checkbox:CheckBox = findViewById(R.id.checkBox)

        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeBtn.isEnabled = isChecked
                changeBtn.setBackgroundColor(Color.parseColor("#8692f7"))

                changeBtn.setOnClickListener{
                    // notification should be added here
                    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val channel = NotificationChannel("channelId", "channelName", NotificationManager.IMPORTANCE_DEFAULT)
                        notificationManager.createNotificationChannel(channel)
                    }

                    val builder = NotificationCompat.Builder(this, "channelId")
                        .setSmallIcon(R.drawable.ic_logo)
                        .setContentTitle("Program Transfer Request")
                        .setContentText("We have received your application and will process it as soon as possible.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                    notificationManager.notify(0, builder.build())

                    val int:Intent = Intent(this,LastPage::class.java)
                    int.putExtra("selected_program",prog_selected)
                    startActivity(int)
                }
            } else {
                changeBtn.isEnabled = false
                changeBtn.setBackgroundColor(Color.parseColor("grey"))
            }
        }

    }
}