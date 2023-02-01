package com.example.android.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.quiz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);
    }
    public boolean firstQuestionVerify(RadioButton radioButton) {

        boolean firstResult;

        // Check which radio button was clicked
        firstResult = radioButton.isChecked();
        return firstResult;
    }
    public boolean secondQuestionVerify(RadioButton radioButton) {

        boolean secondResult;

        // Check which radio button was clicked
        secondResult = radioButton.isChecked();
        return secondResult;
    }


    public boolean thirdQuestionVerify(EditText userInput) {

        boolean thirdResult;

        // Check if the input answer is correct
        String userInputAnswer = userInput.getText().toString();
        thirdResult = userInputAnswer.contains("radiogroup") ||
                userInputAnswer.contains("Radiogroup") ||
                userInputAnswer.contains("Radio Group") ||
                userInputAnswer.contains("Radio group");
        return thirdResult;
    }
    public boolean fourthQuestionVerify() {

        boolean fourthResult;

        // Check if the correct checkboxes are all checked
        if (binding.fourthCheckbox1.isChecked() &&
                binding.fourthCheckbox2.isChecked() &&
                binding.fourthCheckbox3.isChecked() &&
                binding.fourthCheckbox4.isChecked() &&
                binding.fourthCheckbox5.isChecked()) {
            fourthResult = false;
        } else if (binding.fourthCheckbox1.isChecked() &&
                binding.fourthCheckbox2.isChecked() &&
                binding.fourthCheckbox4.isChecked() &&
                binding.fourthCheckbox5.isChecked()) {
            fourthResult = true;
        } else {
            fourthResult = false;
        }
        return fourthResult;
    }

    /**
     * This method is called when the submit answer button is clicked.
     */
    public void submitAnswer(View view) {

        int correctCount = 0;
        String toastMessageHeader = getString(R.string.Toast_message_header);
        String toastMessageTail = getString(R.string.toastMessageTail);

        if (firstQuestionVerify(binding.radioButton)) {
            correctCount += 1;
        }
        if (secondQuestionVerify(binding.secondRadioButton4)) {
            correctCount += 1;
        }
        if (thirdQuestionVerify(binding.thirdQuestionUserInput)) {
            correctCount += 1;
        }
        if (fourthQuestionVerify()) {
            correctCount += 1;
        }
        // Show an message to let user know the score
        Toast.makeText(this, toastMessageHeader + correctCount + toastMessageTail, Toast.LENGTH_SHORT).show();
    }
}