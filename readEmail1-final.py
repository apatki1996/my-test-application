from googleapiclient.discovery import build
from httplib2 import Http
from oauth2client import file, client, tools

SCOPES = 'https://www.googleapis.com/auth/gmail.readonly'

def categorise():
   
    store = file.Storage('token.json')
    creds = store.get()
    if not creds or creds.invalid:
        flow = client.flow_from_clientsecrets('client_secret_514215414527-hhhruimjvtvtjpru4c8uai2o5uc4ujsa.apps.googleusercontent.com.json', SCOPES)
        creds = tools.run_flow(flow, store)
    service = build('gmail', 'v1', http=creds.authorize(Http()))
    
    # Call the Gmail API to fetch INBOX for REJECTS
    possible_rejects = service.users().messages().list(userId='me',labelIds = ['INBOX','CATEGORY_UPDATES'], q = 'unfortunately' or 'regret').execute()
    messages = possible_rejects.get('messages', [])
    rejects_ids = []
    a_i_ids = []
    reject_subject = []
    a_i_subject = []
    userInfo = service.users().getProfile(userId='me').execute()
    print(userInfo)
    

    if not messages:
        print ("No messages found.")
    else:
        print ("Message snippets:")
        for message in messages:
            msg = service.users().messages().get(userId='me', id=message['id'], format='metadata', metadataHeaders="Subject").execute()
            #print ('\nEmail Snippet:- ',msg['snippet'])
            print('\n\n\n',msg)
            rejects_ids.append(msg['id'])
            msg = str(msg)
            #print(type(msg))
            msg = msg.rsplit("'Subject', 'value': ")
            msg = msg[1]
            msg = msg.rsplit("}]},")
            final1 = msg[0]
            print('\n\nSubject:- ',final1)
            reject_subject.append(final1)
            
            #print('\nEmail Subject:- ',msg['payload']['headers'][var]['value'])
            #print('\n\n\n\n\n\n',msg['labelIds'][0])
            
            
            
     
    
    # Call the Gmail API to fetch INBOX for ACCEPTANCE/INTERVIEW INVITATIONS
    print('\n\n\n\n\n\n\n\n\n')
    possible_accepts = service.users().messages().list(userId='me',labelIds = ['INBOX','CATEGORY_UPDATES'], q = 'assessment' or 'congratulations' or 'interview' or 'coding' or 'phone' or 'video' or 'call').execute()
    messages2 = possible_accepts.get('messages', [])

    #userInfo = service.users().getProfile(userId='me').execute()
    #print(userInfo)
    

    if not messages2:
        print ("No messages found.")
    else:
        print ("Message snippets:")
        for message in messages2:
            msg2 = service.users().messages().get(userId='me', id=message['id'], format='metadata', metadataHeaders="Subject").execute()
            #print ('\nEmail Snippet:- ',msg2['snippet'])
            #print('\n\n\n',msg2)
            a_i_ids.append(msg2['id'])
            msg2 = str(msg2)
            #print(type(msg2))
            msg2 = msg2.rsplit("'Subject', 'value': ")
            msg2 = msg2[1]
            msg2 = msg2.rsplit("}]},")
            final2 = msg2[0]
            print('\n\nSubject:- ',final2)
            a_i_subject.append(final2)
            #print('\nEmail Subject:- ',msg2['payload']['headers'][var]['value'])
            #print('\n\n\n\n\n\n',msg2['labelIds'][0])
            
    return rejects_ids, a_i_ids, reject_subject, a_i_subject

#if __name__ == '__main__':
#    main()


rejects_ids, a_i_ids, reject_subject, a_i_subject = categorise()

print(rejects_ids, '\n\n\n', reject_subject, '\n\n\n', a_i_ids, '\n\n\n', a_i_subject)
