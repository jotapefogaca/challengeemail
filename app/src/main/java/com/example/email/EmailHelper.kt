package com.example.email

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

class EmailHelper {

    fun sendEmail(
        context: Context,
        recipients: Array<String>,
        subject: String,
        message: String,
        attachments: List<File>? = null
    ) {
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE).apply {
            type = "message/rfc822" // MIME type for email
            putExtra(Intent.EXTRA_EMAIL, recipients) // recipients
            putExtra(Intent.EXTRA_SUBJECT, subject) // email subject
            putExtra(Intent.EXTRA_TEXT, message) // email body
            if (attachments != null) {
                val uris = ArrayList<Uri>()
                attachments.forEach { file ->
                    val uri = FileProvider.getUriForFile(
                        context,
                        "${context.applicationContext.packageName}.fileprovider",
                        file
                    )
                    uris.add(uri)
                }
                putExtra(Intent.EXTRA_STREAM, uris) // Attachments
            }
        }

        // Start email client
        val chooser = Intent.createChooser(intent, "Choose an email client")
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(chooser)
        } else {
            // Handle the case where no email client is installed
            // Optional: Prompt user to install an email client
        }
    }
}