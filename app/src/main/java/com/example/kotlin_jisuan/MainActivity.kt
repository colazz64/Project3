package com.example.kotlin_jisuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlin_jisuan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),RadioGroup.OnCheckedChangeListener {
    var binding:ActivityMainBinding? =null;
    var mode = 0;
    var way = "+";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding?.radioGroup?.setOnCheckedChangeListener(this)
        binding?.rgOperation?.setOnCheckedChangeListener(this)
    }

    fun jian(view: View?){
        var currentNum:Int = binding?.tvNumber?.text.toString().toInt()
        if (currentNum.toInt() <= 0){
            Toast.makeText(applicationContext,"Must be greater than 0",Toast.LENGTH_SHORT).show()
            return
        }
        currentNum-=1;
        binding?.tvNumber?.text = currentNum.toString();
    }

    fun jia(view: View?){
        var currentNum:Int = binding?.tvNumber?.text.toString().toInt()
        when(mode){
            0->{
                if (currentNum >= 10){
                    Toast.makeText(applicationContext,"Must be less than 10",Toast.LENGTH_SHORT).show()
                    return
                }
                currentNum+=1;
                binding?.tvNumber?.text = currentNum.toString();
            }
            1->{
                if (currentNum >= 25){
                    Toast.makeText(applicationContext,"Must be less than 25",Toast.LENGTH_SHORT).show()
                    return
                }
                currentNum+=1;
                binding?.tvNumber?.text = currentNum.toString();
            }
            2->{
                if (currentNum >= 50){
                    Toast.makeText(applicationContext,"Must be less than 50",Toast.LENGTH_SHORT).show()
                    return
                }
                currentNum+=1;
                binding?.tvNumber?.text = currentNum.toString();
            }
        }

    }

    fun start(view: View?){
        var currentNum:Int = binding?.tvNumber?.text.toString().toInt()
        when(mode){
            0->{
                if(currentNum > 10){
                    Toast.makeText(applicationContext,"Must be less than 10",Toast.LENGTH_SHORT).show()
                    return
                }
                val intent = Intent(this@MainActivity,StartActivity::class.java);
                intent.putExtra("way",way)
                intent.putExtra("currentNum",currentNum)
                startActivity(intent)
            }
            1->{
                if(currentNum > 25){
                    Toast.makeText(applicationContext,"Must be less than 25",Toast.LENGTH_SHORT).show()
                    return
                }
                val intent = Intent(this@MainActivity,StartActivity::class.java);
                intent.putExtra("way",way)
                intent.putExtra("currentNum",currentNum)
                startActivity(intent)
            }
            2->{
                if(currentNum > 50){
                    Toast.makeText(applicationContext,"Must be less than 50",Toast.LENGTH_SHORT).show()
                    return
                }
                val intent = Intent(this@MainActivity,StartActivity::class.java);
                intent.putExtra("way",way)
                intent.putExtra("currentNum",currentNum)
                startActivity(intent)
            }
        }

    }
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.addition->{
                way="+";
            }
            R.id.subtraction->{
                way="-";
            }
            R.id.multiplication->{
                way="*";
            }
            R.id.division->{
                way="/";
            }
            R.id.easy->{
                mode = 0;
            }
            R.id.medium->{
                mode = 1;
            }
            R.id.hard->{
                mode = 2;
            }
        }
    }
}