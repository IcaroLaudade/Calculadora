package icaro.metodista.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private double valor;
    private double total;
    private String operacao;
    public TextView resultado(){
        TextView resultado=((TextView)findViewById(R.id.resultado));
        return resultado;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resultado();
    }
    public void adicionarNumero(View view){
    String numero=((Button) view).getText().toString();
    resultado().setText(resultado().getText()+numero);
    }
    public void setOperacao(View view){
        try {
            operacao = ((TextView) view).getText().toString();
            total = Double.parseDouble(resultado().getText().toString().trim());
            resultado().setText("");
        }catch (Exception e){
           // operacao = ((Button) view).getText().toString();
            //total=0.0;
            resultado().setText("");
        }
    }
    public void limpar(View view){
        resultado().setText("");
        total=0.0;
    }
    public void calcular(View view){
        try {
            valor = Double.parseDouble(resultado().getText().toString());
            if(valor==0 && operacao.equals("/")){
                String erro="ERRO";
                resultado().setText(erro);
            }
            else {
                if (operacao.equals("+")) {
                    System.out.println(total);
                    total = total + valor;
                    valor=0.0;
                    System.out.println(valor);
                } else if (operacao.equals("-")) {
                    total = total - valor;
                    System.out.println(valor);
                } else if (operacao.equals("*")) {
                    total = total * valor;
                } else if (operacao.equals("/")) {
                    System.out.println(total);
                        total = total / valor;


                    System.out.println(valor);
                    System.out.println(operacao);
                }
                resultado().setText(String.valueOf(total));
            }
        }
        catch(Exception e){


                //a

               resultado().setText(String.valueOf(total));

        }
        }
}
