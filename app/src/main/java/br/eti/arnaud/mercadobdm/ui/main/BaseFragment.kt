package br.eti.arnaud.mercadobdm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.eti.arnaud.mercadobdm.App
import br.eti.arnaud.mercadobdm.BaseViewModel
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

abstract class BaseFragment(@LayoutRes val layout: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        start()
        listeners()
        observers()

        (vm as BaseViewModel).message.observe(viewLifecycleOwner){
            Snackbar.make(view, getString(it), Snackbar.LENGTH_LONG)
        }
    }


    fun <T> o(observable: LiveData<T>, observer: Observer<T>){
        observable.observe(viewLifecycleOwner, observer)
    }

    fun l(v: View, listener: () -> Unit){
        v.setOnClickListener{
            listener()
        }
    }

    fun foo(entityClass: Class<BaseViewModel>) {
        var entity: BaseViewModel = entityClass.newInstance()
    }


    abstract val vm: BaseViewModel
    abstract fun setupView()
    abstract fun start()
    abstract fun listeners()
    abstract fun observers()

}
