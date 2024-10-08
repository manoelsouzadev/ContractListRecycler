package br.edu.scl.ifsp.sdm.contactlist.adapter

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.edu.scl.ifsp.sdm.contactlist.R
import br.edu.scl.ifsp.sdm.contactlist.databinding.TileContactBinding
import br.edu.scl.ifsp.sdm.contactlist.model.Contact

class ContactAdapter(context: Context, private val contactList: MutableList<Contact>): ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = contactList[position]

        var contactTileView = convertView
        if(convertView == null) {
            val tcb = TileContactBinding.inflate(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false
            )
            contactTileView = tcb.root

            val tileContactHolder = TileContactHolder(tcb.nameTv, tcb.emailTv, tcb.phoneTv)
            contactTileView.tag = tileContactHolder
       }

        val holder = contactTileView?.tag as TileContactHolder
        holder.nameTv.text = contact.name
        holder.emailTv.text = contact.email
        holder.phoneTv.text = contact.phone

        return contactTileView
    }

    private data class TileContactHolder(
        val nameTv: TextView,
        val emailTv: TextView,
        val phoneTv: TextView
    ){

    }
}