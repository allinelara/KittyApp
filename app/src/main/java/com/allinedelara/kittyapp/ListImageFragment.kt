package com.allinedelara.kittyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list_image.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListImageFragment : Fragment() {

    private lateinit var adapter: ImageAdapter
    private val viewModel by viewModel<ImageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllImages()

        adapter = ImageAdapter {
            recycler_view.smoothScrollToPosition(0)
        }

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)

        viewModel.images.observe(viewLifecycleOwner) {
            if (it == null || it?.isEmpty() == true) {
                showSnackBar(view)
            } else {
                progress.isVisible = false
                recycler_view.isVisible = true
                adapter.submitList(it)
            }
        }
    }

    private fun showSnackBar(view: View) {
        val snackbar: Snackbar =
            Snackbar.make(view, R.string.error, Snackbar.LENGTH_SHORT)
        snackbar.setAction(R.string.retry,
            View.OnClickListener {
                getAllImages()
            })
        snackbar.show()
    }

    private fun getAllImages() {
        viewModel.getImages()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list_image, container, false)
    }
}