package co.tiagoaguiar.fitnesstracker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.ic_baseline_wb_sunny_24,
                textStringId = R.string.label_imc,
                color = Color.GREEN
            ),
        )

        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.ic_baseline_wb_sunny_24,
                textStringId = R.string.label_imc,
                color = Color.GREEN
            ),
        )

        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rv_main)

        // esse código vai permitir que a recycler renderize um layout especifico.
        rvMain.adapter = adapter

        // vai gerenciar o layout e definir o camportamento desse layout
        rvMain.layoutManager = LinearLayoutManager(this)
    }

    // Essa classe vai adaptar os itens da celula que vão ficar hospedados na MainViewHolder
    private inner class MainAdapter(private val mainItems: List<MainItem>): RecyclerView.Adapter<MainViewHolder>() {

        // 1 - Ele é responsável para informar para a recycler view, qual o layout XML da célula especifica. (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            // pega a view do main_item
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // 2 - Método que vai ser disparado toda vez que houver uma rolagem na tela e for necessário trocar o conteúdo da celula.
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        // 3 - informar quantas células essa listagem vai ter.
        override fun getItemCount(): Int {
            return mainItems.size
        }

    }

    // A classe MainViewHolder é a classe da celula em si, é onde vamos conseguir buscar a referência da celula do xml
    private class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item :MainItem) {
            val buttonTest: Button = itemView.findViewById(R.id.btn_item)
            buttonTest.setText(item.textStringId)
         }
    }
}