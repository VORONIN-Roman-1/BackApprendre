<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>

    <div>
        <@l.logout/>
        <span><a href="/user">Userlist</a></span>
    </div>
    <div>
        <form method="post">
            <label> Cooбщение
                <input type="text" name="text" placeholder="Введите сообщение"/>
            </label>
            <label> Тэг
                <input type="text" name="tag" placeholder="Тэг"/>
            </label>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <label> Фильтр
            <input type="text" name="filter">
        </label>
        <button type="submit">Найти</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        No messages
        </
    </#list>


</@c.page>
