package inspire2connect.inspire2connect.quiz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import inspire2connect.inspire2connect.R;

class questionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<questionObject> questions = quizActivity.selected_questions;
    TextView question, option1_text, option2_text, option3_text, option4_text;
    ConstraintLayout[] options = new ConstraintLayout[4];

    public questionAdapter(Context context, ArrayList<questionObject> arrayList) {
        this.context = context;
        this.questions = arrayList;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.quiz_row, parent, false);
        question = convertView.findViewById(R.id.question_text);
        option1_text = convertView.findViewById(R.id.option_1_text);
        option2_text = convertView.findViewById(R.id.option_2_text);
        option3_text = convertView.findViewById(R.id.option_3_text);
        option4_text = convertView.findViewById(R.id.option_4_text);

        options[0] = convertView.findViewById(R.id.option_1_tile);
        options[1] = convertView.findViewById(R.id.option_2_tile);
        options[2] = convertView.findViewById(R.id.option_3_tile);
        options[3] = convertView.findViewById(R.id.option_4_tile);

        question.setText(questions.get(position).getQuestion());
        option1_text.setText(questions.get(position).getOption1());
        option2_text.setText(questions.get(position).getOption2());
        option3_text.setText(questions.get(position).getOption3());
        option4_text.setText(questions.get(position).getOption4());

        switch (questions.get(position).getAnswer()) {
            case 1:
                options[0].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                break;
            case 2:
                options[1].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                break;
            case 3:
                options[2].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                break;
            case 4:
                options[3].setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                break;

        }

        return convertView;
    }
}
