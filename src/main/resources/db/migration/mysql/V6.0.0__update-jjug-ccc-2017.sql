UPDATE conference
SET
  conf_cfp_note  = '2017年5月20日(土)に行われるJJUG CCC 2016 SpringのCfPを下記フォームをご入力の上、ご提出ください。  \n提出にはGitHubによるログインが必須です。  \n \n#### 締め切り  \n \n2017年2月26日(日) 23:59 GMT \n#### CfP作成方法  \n \nフォーム入力後に"Submit CFP"ボタンクリックで提出完了です。"Save as Draft"ボタンをクリックした場合は提出とみなされません。  \nGitHubで[ログイン](/)後、応募済みのCfPを編集可能です。  \nCfPを取り下げたい場合は"Withdraw CFP"ボタンをクリックしてください。  \n \n#### 重要  \n \nCfPは募集終了後に公開し、投票により希望セッションのアンケートを実施いたします。  \n**CfPは投票開始日までは公開されません。** なお、最終的には3月の幹事会にて、投票結果を参考にセッションを決めさせていただきます。  \n \n投票は2月27日(月) ~ 3月1日(水)の間に受け付ける予定です。 投票数が多いから必ずしも確実に採択されるわけではない旨、ご理解のほどよろしくお願いいたします。 ',
  conf_vote_note = '投票は何セッション分行っても構いません。 投票は![like](/images/like-16x16.png)ボタンをクリックすることで行えます。 \n1セッション毎に1票投票できます。  \n投票数が多いからといって必ずしも確実に採択されるわけではない旨、ご理解のほどよろしくお願いいたします。  \n \n#### 投票期間  \n \n2017年2月27日(月) ~ 3月1日(水)'
WHERE conf_id = 0x00000000000000000000000020170520;