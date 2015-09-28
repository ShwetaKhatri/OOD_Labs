package com.ood.lab3.MailSystem;
import java.util.ArrayList;

/**
   A system of voice mail boxes.
*/
public class MailSystem
{
   /**
      Constructs a mail system with a given number of mailboxes
      @param mailboxCount the number of mailboxes
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList<Mailbox>();

      // Initialize mail boxes.

      for (int i = 0; i < mailboxCount; i++)
      {
         String passcode = "" + (i + 1);
         String greeting = "You have reached mailbox " + (i + 1)
               + ". \nPlease leave a message now.";
         mailboxes.add(new Mailbox(passcode, greeting));
      }
   }

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox index or NO_SUCH_MAILBOX if not found
   */
   public int findMailbox(String ext)
   {
      int i = Integer.parseInt(ext);
      if (1 <= i && i <= mailboxes.size())
         return  i - 1;
      else return NO_SUCH_MAILBOX;
   }
   
   public String getGreeting(int mailboxIndex) {
	   currentMailbox = mailboxes.get(mailboxIndex);
	   return currentMailbox.getGreeting();
   }
   // New methods added to support Law of Demeter   
   public boolean checkPasscode(int currentMailboxIndex, String passcode) {
	    currentMailbox = mailboxes.get(currentMailboxIndex);
	    return currentMailbox.checkPasscode(passcode);
	}
   
   public void addMessage(int currentMailbox, Message message) {
		mailboxes.get(currentMailbox).addMessage(message);
	}
   
   public void setPasscode(int currentMailboxIndex, String passcode) {
	   currentMailbox = mailboxes.get(currentMailboxIndex);
	   currentMailbox.setPasscode(passcode);
	}

   public void setGreeting(int currentMailboxIndex, String greeting) {
	   currentMailbox = mailboxes.get(currentMailboxIndex);
	   currentMailbox.setGreeting(greeting);
	}
   
   public Message getCurrentMessage(int currentMailboxIndex) {
		currentMailbox = mailboxes.get(currentMailboxIndex);
		return currentMailbox.getCurrentMessage();
	}
   
   public void saveCurrentMessage(int currentMailboxIndex) {
		currentMailbox = mailboxes.get(currentMailboxIndex);
        currentMailbox.saveCurrentMessage();		
	}
   
   public void removeCurrentMessage(int currentMailboxIndex) {
		currentMailbox = mailboxes.get(currentMailboxIndex);
        currentMailbox.removeCurrentMessage();		
	}
   
   private ArrayList<Mailbox> mailboxes;
   private Mailbox currentMailbox;
   public final static int NO_SUCH_MAILBOX = -1;


}
