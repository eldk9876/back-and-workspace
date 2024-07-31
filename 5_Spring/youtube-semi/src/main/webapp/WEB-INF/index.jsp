<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>YouTube</title>

    <link
      rel="icon"
      href="https://www.youtube.com/s/desktop/ae4ecf92/img/favicon_144x144.png"
    />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" />
     <!--  사용하게 되면 한가지만 사용
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
     -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <script
      src="https://kit.fontawesome.com/ef885bd654.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <div class="progress-bar-container">
      <div class="progress-bar"></div>
    </div>
    <header>
      <div class="header-start">
        <i class="fa-solid fa-bars"></i>
        <a href="">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            id="yt-logo-updated-svg_yt1"
            class="external-icon"
            viewBox="0 0 90 20"
            focusable="false"
            style="
              pointer-events: none;
              display: inherit;
              width: 100%;
              height: 100%;
            "
          >
            <svg
              id="yt-logo-updated_yt1"
              viewBox="0 0 90 20"
              preserveAspectRatio="xMidYMid meet"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g>
                <path
                  d="M27.9727 3.12324C27.6435 1.89323 26.6768 0.926623 25.4468 0.597366C23.2197 2.24288e-07 14.285 0 14.285 0C14.285 0 5.35042 2.24288e-07 3.12323 0.597366C1.89323 0.926623 0.926623 1.89323 0.597366 3.12324C2.24288e-07 5.35042 0 10 0 10C0 10 2.24288e-07 14.6496 0.597366 16.8768C0.926623 18.1068 1.89323 19.0734 3.12323 19.4026C5.35042 20 14.285 20 14.285 20C14.285 20 23.2197 20 25.4468 19.4026C26.6768 19.0734 27.6435 18.1068 27.9727 16.8768C28.5701 14.6496 28.5701 10 28.5701 10C28.5701 10 28.5677 5.35042 27.9727 3.12324Z"
                  fill="#FF0000"
                ></path>
                <path
                  d="M11.4253 14.2854L18.8477 10.0004L11.4253 5.71533V14.2854Z"
                  fill="white"
                ></path>
              </g>
              <g>
                <g id="youtube-paths_yt1">
                  <path
                    d="M34.6024 13.0036L31.3945 1.41846H34.1932L35.3174 6.6701C35.6043 7.96361 35.8136 9.06662 35.95 9.97913H36.0323C36.1264 9.32532 36.3381 8.22937 36.665 6.68892L37.8291 1.41846H40.6278L37.3799 13.0036V18.561H34.6001V13.0036H34.6024Z"
                  ></path>
                  <path
                    d="M41.4697 18.1937C40.9053 17.8127 40.5031 17.22 40.2632 16.4157C40.0257 15.6114 39.9058 14.5437 39.9058 13.2078V11.3898C39.9058 10.0422 40.0422 8.95805 40.315 8.14196C40.5878 7.32588 41.0135 6.72851 41.592 6.35457C42.1706 5.98063 42.9302 5.79248 43.871 5.79248C44.7976 5.79248 45.5384 5.98298 46.0981 6.36398C46.6555 6.74497 47.0647 7.34234 47.3234 8.15137C47.5821 8.96275 47.7115 10.0422 47.7115 11.3898V13.2078C47.7115 14.5437 47.5845 15.6161 47.3329 16.4251C47.0812 17.2365 46.672 17.8292 46.1075 18.2031C45.5431 18.5771 44.7764 18.7652 43.8098 18.7652C42.8126 18.7675 42.0342 18.5747 41.4697 18.1937ZM44.6353 16.2323C44.7905 15.8231 44.8705 15.1575 44.8705 14.2309V10.3292C44.8705 9.43077 44.7929 8.77225 44.6353 8.35833C44.4777 7.94206 44.2026 7.7351 43.8074 7.7351C43.4265 7.7351 43.156 7.94206 43.0008 8.35833C42.8432 8.77461 42.7656 9.43077 42.7656 10.3292V14.2309C42.7656 15.1575 42.8408 15.8254 42.9914 16.2323C43.1419 16.6415 43.4123 16.8461 43.8074 16.8461C44.2026 16.8461 44.4777 16.6415 44.6353 16.2323Z"
                  ></path>
                  <path
                    d="M56.8154 18.5634H54.6094L54.3648 17.03H54.3037C53.7039 18.1871 52.8055 18.7656 51.6061 18.7656C50.7759 18.7656 50.1621 18.4928 49.767 17.9496C49.3719 17.4039 49.1743 16.5526 49.1743 15.3955V6.03751H51.9942V15.2308C51.9942 15.7906 52.0553 16.188 52.1776 16.4256C52.2999 16.6631 52.5045 16.783 52.7914 16.783C53.036 16.783 53.2712 16.7078 53.497 16.5573C53.7228 16.4067 53.8874 16.2162 53.9979 15.9858V6.03516H56.8154V18.5634Z"
                  ></path>
                  <path
                    d="M64.4755 3.68758H61.6768V18.5629H58.9181V3.68758H56.1194V1.42041H64.4755V3.68758Z"
                  ></path>
                  <path
                    d="M71.2768 18.5634H69.0708L68.8262 17.03H68.7651C68.1654 18.1871 67.267 18.7656 66.0675 18.7656C65.2373 18.7656 64.6235 18.4928 64.2284 17.9496C63.8333 17.4039 63.6357 16.5526 63.6357 15.3955V6.03751H66.4556V15.2308C66.4556 15.7906 66.5167 16.188 66.639 16.4256C66.7613 16.6631 66.9659 16.783 67.2529 16.783C67.4974 16.783 67.7326 16.7078 67.9584 16.5573C68.1842 16.4067 68.3488 16.2162 68.4593 15.9858V6.03516H71.2768V18.5634Z"
                  ></path>
                  <path
                    d="M80.609 8.0387C80.4373 7.24849 80.1621 6.67699 79.7812 6.32186C79.4002 5.96674 78.8757 5.79035 78.2078 5.79035C77.6904 5.79035 77.2059 5.93616 76.7567 6.23014C76.3075 6.52412 75.9594 6.90747 75.7148 7.38489H75.6937V0.785645H72.9773V18.5608H75.3056L75.5925 17.3755H75.6537C75.8724 17.7988 76.1993 18.1304 76.6344 18.3774C77.0695 18.622 77.554 18.7443 78.0855 18.7443C79.038 18.7443 79.7412 18.3045 80.1904 17.4272C80.6396 16.5476 80.8653 15.1765 80.8653 13.3092V11.3266C80.8653 9.92722 80.7783 8.82892 80.609 8.0387ZM78.0243 13.1492C78.0243 14.0617 77.9867 14.7767 77.9114 15.2941C77.8362 15.8115 77.7115 16.1808 77.5328 16.3971C77.3564 16.6158 77.1165 16.724 76.8178 16.724C76.585 16.724 76.371 16.6699 76.1734 16.5594C75.9759 16.4512 75.816 16.2866 75.6937 16.0702V8.96062C75.7877 8.6196 75.9524 8.34209 76.1852 8.12337C76.4157 7.90465 76.6697 7.79646 76.9401 7.79646C77.2271 7.79646 77.4481 7.90935 77.6034 8.13278C77.7609 8.35855 77.8691 8.73485 77.9303 9.26636C77.9914 9.79787 78.022 10.5528 78.022 11.5335V13.1492H78.0243Z"
                  ></path>
                  <path
                    d="M84.8657 13.8712C84.8657 14.6755 84.8892 15.2776 84.9363 15.6798C84.9833 16.0819 85.0821 16.3736 85.2326 16.5594C85.3831 16.7428 85.6136 16.8345 85.9264 16.8345C86.3474 16.8345 86.639 16.6699 86.7942 16.343C86.9518 16.0161 87.0365 15.4705 87.0506 14.7085L89.4824 14.8519C89.4965 14.9601 89.5035 15.1106 89.5035 15.3011C89.5035 16.4582 89.186 17.3237 88.5534 17.8952C87.9208 18.4667 87.0247 18.7536 85.8676 18.7536C84.4777 18.7536 83.504 18.3185 82.9466 17.446C82.3869 16.5735 82.1094 15.2259 82.1094 13.4008V11.2136C82.1094 9.33452 82.3987 7.96105 82.9772 7.09558C83.5558 6.2301 84.5459 5.79736 85.9499 5.79736C86.9165 5.79736 87.6597 5.97375 88.1771 6.32888C88.6945 6.684 89.059 7.23433 89.2707 7.98457C89.4824 8.7348 89.5882 9.76961 89.5882 11.0913V13.2362H84.8657V13.8712ZM85.2232 7.96811C85.0797 8.14449 84.9857 8.43377 84.9363 8.83593C84.8892 9.2381 84.8657 9.84722 84.8657 10.6657V11.5641H86.9283V10.6657C86.9283 9.86133 86.9001 9.25221 86.846 8.83593C86.7919 8.41966 86.6931 8.12803 86.5496 7.95635C86.4062 7.78702 86.1851 7.7 85.8864 7.7C85.5854 7.70235 85.3643 7.79172 85.2232 7.96811Z"
                  ></path>
                </g>
              </g>
            </svg>
          </svg>
        </a>
      </div>
      <div class="header-center">
        <input type="text" placeholder="검색" />
        <button type="button">
          <i class="fa-solid fa-magnifying-glass"></i>
        </button>
      </div>
      <div class="header-end">
        <button type="button"><i class="fa-solid fa-user"></i></button>
      </div>
    </header>

    <main>
      <aside>
        <a href="">
          <i class="fa-solid fa-house"></i>
          <span>홈</span>
        </a>
        <a href="">
          <i class="fa-solid fa-folder"></i>
          <span>구독</span>
        </a>
      </aside>

      <a href=""></a>

      <div class="main-content">
        <nav>
          <a href="" class="active">전체</a>
          <a href="">음악</a>
          <a href="">게임</a>
          <a href="">뉴스</a>
          <a href="">라이브</a>
          <a href="">야생생물</a>
        </nav>

        <section>
          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ab
            quisquam alias voluptate magni expedita ex eveniet doloribus amet
            autem rerum! Assumenda ipsum recusandae non sit id reprehenderit
            consequatur iure deserunt. Illum, iusto ipsam. Impedit repudiandae
            debitis nisi, rem minus corporis ipsa nostrum veritatis commodi,
            aperiam ea earum esse culpa excepturi velit dolore sed temporibus
            placeat quae odit soluta rerum. Nulla. Odio qui voluptate placeat
            sed veniam repudiandae incidunt facere quam, tenetur commodi
            obcaecati quidem nisi possimus aspernatur quibusdam nemo sint? Natus
            at consectetur, molestias animi voluptatem ipsam reprehenderit nobis
            dolorum! Quis atque iusto esse cumque labore mollitia possimus
            laborum ut pariatur voluptas! Obcaecati animi nam pariatur quos.
            Enim, unde nisi suscipit eligendi nobis vero, totam numquam dolor
            est libero consequatur. Voluptate, explicabo. Eligendi voluptates
            iste consequuntur saepe nemo maiores. Necessitatibus asperiores
            voluptatem, unde, possimus deleniti aspernatur nam quis hic fuga
            maiores nulla adipisci. Rerum deleniti amet mollitia maiores. In,
            molestias. Voluptas ad voluptatem dignissimos aspernatur sapiente
            fugiat error? Deserunt, temporibus recusandae! Sit quasi debitis
            cumque? Obcaecati libero ut voluptate nesciunt velit ipsam autem!
            Beatae placeat voluptate soluta suscipit molestias quas? Doloribus,
            natus dolores. Optio temporibus in reiciendis laboriosam autem
            voluptatem, dolorem itaque ipsa totam provident error nobis est, eos
            harum eligendi veniam dignissimos ipsum nisi ad ratione quisquam
            voluptatum quas. Nesciunt eum adipisci reprehenderit optio velit,
            error nam numquam deserunt. Rerum, ratione dolorem? Ea dicta odio
            voluptas exercitationem, rem maxime iure nesciunt eveniet assumenda
            voluptatem recusandae, explicabo, suscipit et! Tenetur! Laboriosam
            amet nostrum consectetur recusandae doloribus, voluptatem libero
            quis ipsa molestiae nemo qui quo labore, modi quibusdam eveniet
            voluptates sapiente. Fuga commodi fugiat, unde culpa corrupti sit.
            Ipsam, neque maxime. Exercitationem aliquid voluptatem animi
            recusandae, fugiat eaque? Minima commodi dolorem perspiciatis cumque
            sed rem perferendis necessitatibus, repudiandae illum vitae amet
            quas aliquam tenetur ad molestiae possimus nihil corrupti obcaecati
            temporibus. Alias soluta ad vitae ratione fugit, inventore labore
            nulla pariatur sapiente illo, blanditiis voluptatum beatae amet qui
            provident facilis quos! Vel animi mollitia assumenda maxime eum?
            Nulla eius nostrum debitis. Voluptate possimus repellat deserunt
            eius error nulla eos repudiandae quae dolores aliquam animi velit
            atque, saepe rem labore consectetur corporis. Placeat a pariatur
            repellendus sunt dolore dignissimos vel obcaecati vitae. Possimus
            voluptatibus iusto maiores quas explicabo quod culpa quisquam qui?
            Nemo, minus amet corporis nobis perspiciatis, assumenda culpa a
            dolorem provident nam ratione. Explicabo et voluptatem accusamus
            quod praesentium unde! Quo nobis odit sunt laborum, similique esse
            modi incidunt ullam enim optio cupiditate! Id esse, voluptatem qui
            excepturi maxime minus, aperiam nulla consectetur in animi adipisci
            voluptatibus quis accusantium rem. Vel fugit animi, ex aliquid
            labore ad explicabo repellat numquam, eaque ratione laborum iure
            quam, iste est voluptatibus aperiam dignissimos odit! Repellendus
            dignissimos ullam iste culpa omnis cumque qui similique. Voluptas
            debitis minima pariatur a? Alias magni velit cumque quasi,
            perferendis omnis aliquid eaque beatae! Cupiditate vitae, commodi
            provident ducimus harum nihil! Soluta sit deleniti quas earum vero.
            Facere, debitis. Earum et vero saepe recusandae, dolor aspernatur
            similique, dignissimos illo voluptatibus deleniti quod laboriosam
            ipsum esse nesciunt nisi voluptate, labore minima quae! Mollitia
            architecto saepe voluptatem accusantium quod qui ullam. Amet placeat
            accusantium dignissimos praesentium facere ex itaque ut, repudiandae
            libero deserunt dolorum! Esse maxime non expedita harum eveniet,
            rerum provident facilis veniam voluptas odio aperiam cupiditate
            repellendus beatae aliquam! Eaque maiores minima quas, sit vero ut
            impedit. Sequi voluptate deleniti dicta eum corrupti maiores ut
            doloremque mollitia quidem, tempore fuga architecto provident
            itaque! Non tempore sunt veritatis beatae provident. Suscipit,
            maiores! Doloribus temporibus facere error perspiciatis nihil
            mollitia, deserunt fuga quisquam laboriosam, illum iure sunt vitae
            atque ipsam praesentium nulla officia asperiores? Excepturi, ut
            velit labore recusandae quis reiciendis. Illum, deserunt sit?
            Cupiditate nostrum fuga delectus eos nesciunt. Ex dolor voluptatem
            suscipit harum aspernatur qui, itaque necessitatibus! Perferendis
            corporis sit veniam suscipit optio nemo qui, debitis totam similique
            rem! Natus ducimus voluptates cumque tempore, voluptatibus quisquam
            dolore possimus facilis totam, non, eveniet reprehenderit pariatur
            repellendus incidunt. Ipsa, expedita, et, dolore rem numquam
            asperiores magnam eos ad sapiente illo cupiditate. Distinctio animi
            ipsa eum quas ullam voluptatum labore iure, veniam tempora non
            rerum, rem officia eligendi vel enim vitae deserunt cumque aliquam
            quisquam, aperiam quis. Quasi repellat molestiae iusto repudiandae.
            Veniam voluptatibus non distinctio quibusdam magnam quas, eaque
            molestiae vero quos earum corrupti iure tempora nemo delectus quae
            placeat provident laborum similique officiis voluptatum soluta.
            Inventore corporis minus deserunt recusandae! Et perspiciatis
            reiciendis quos, velit voluptas neque blanditiis. Debitis
            reprehenderit, non unde culpa, sapiente recusandae aspernatur
            suscipit earum beatae voluptatem atque sed modi mollitia nam
            cupiditate sint repellat laboriosam. Optio. Ullam fugit nisi ab
            officia corporis exercitationem minus distinctio expedita quisquam
            totam. Ex similique nihil sunt repudiandae maiores molestiae
            architecto consequatur distinctio facilis necessitatibus quae dicta,
            perspiciatis quaerat, eum tempore? Quasi dolor neque beatae animi
            aut perferendis commodi. Nesciunt praesentium, eveniet fuga ea,
            quaerat provident fugit, quasi adipisci modi saepe fugiat eligendi
            odio facilis eius est dolor nulla ratione. Pariatur? Magnam
            accusamus non unde recusandae esse, a ad soluta quo quod, repellat
            atque ea ipsam laborum molestias dicta dignissimos placeat corporis
            omnis est. Rem assumenda adipisci nobis, iste fugiat quis! Omnis
            quas, ipsa consectetur culpa vitae quibusdam quidem sunt perferendis
            distinctio veritatis aspernatur delectus aperiam modi, vel itaque
            animi doloribus obcaecati eum. Pariatur ab assumenda, sint officiis
            blanditiis necessitatibus perspiciatis? Fuga veritatis iure
            doloremque. Numquam, eum labore, modi repellendus quis
            exercitationem aspernatur aliquid accusamus sit voluptatibus ratione
            eius nobis beatae at fugiat, distinctio laboriosam sequi placeat
            aliquam adipisci autem tenetur! Necessitatibus impedit nemo et vel
            dolore magni optio inventore in minus, quod blanditiis fugiat
            deleniti ullam ipsum natus? Officia, facere maiores? Animi
            laudantium omnis minima, non ea corrupti nemo eligendi. Velit libero
            voluptatibus pariatur natus dolore asperiores blanditiis dolorum
            ducimus quia modi. Ducimus itaque harum fugiat nam, sed odio
            voluptatum veniam numquam eos reiciendis ratione voluptates commodi
            iste! Tempora, voluptatum! Iure sapiente delectus illum incidunt
            ipsa nesciunt ratione quidem nobis pariatur laboriosam illo,
            maiores, sit modi quibusdam corrupti? Aspernatur cum autem totam
            cupiditate nesciunt architecto dolore esse officiis, nihil tempore.
            Aperiam dolore accusamus cumque, nisi eaque illum labore facere
            itaque? Iusto accusamus rerum molestiae maiores asperiores placeat
            corrupti! Non veniam illo nobis suscipit cum ut corporis expedita
            cupiditate voluptatum quos. Commodi cum animi enim quisquam
            aspernatur. Fuga, consequuntur. Fugit animi dicta porro!
            Necessitatibus harum, maiores facilis molestiae ea tenetur nemo quos
            ipsum blanditiis, laudantium repellendus, atque dolor ut eligendi
            nesciunt? Unde harum sapiente quis perspiciatis quia, repellendus
            aperiam, temporibus distinctio consectetur officiis velit cum! Eum
            culpa, sunt saepe adipisci autem minus dolore aliquam odit
            doloremque iusto repellendus voluptatem consequuntur fugiat? Quae
            suscipit eos minus molestiae eum at vero, neque expedita deleniti
            placeat illo rem magni rerum, sequi veritatis quia consectetur
            doloribus commodi velit a. Dolorum, debitis veritatis! Temporibus,
            totam saepe? Quo, cupiditate sequi modi quia quas, cumque impedit,
            quam tenetur voluptas quae asperiores. Earum, minus recusandae
            sapiente impedit consequatur temporibus eos nisi, veniam optio, quo
            laudantium sint iure quaerat. Rem. Provident alias et autem ipsam
            consequatur culpa officia placeat odio earum harum? Perspiciatis
            ipsam quam excepturi vero modi unde alias? Eius quia recusandae quam
            modi deleniti, laborum nobis minima aut? Autem odio enim dolorem
            veniam recusandae. Itaque sit expedita accusantium libero, totam, a
            at vitae voluptatibus vel ex aperiam eveniet eligendi fuga minima,
            molestiae nesciunt neque. Fuga, quisquam! Facilis, dolores? Modi vel
            perspiciatis neque magni a amet earum laboriosam. Quae vitae
            eligendi tempore placeat quis, explicabo inventore voluptate
            repudiandae minima itaque magni ullam at aliquid reprehenderit
            provident cumque excepturi vero! Praesentium, ullam ipsam? Modi,
            iusto fugit est nisi cum earum minima veritatis consectetur, et
            deserunt iure esse minus culpa voluptates asperiores amet facilis
            provident possimus, magnam quis a blanditiis distinctio? Libero sunt
            illo, ipsa cumque nemo optio tempore doloribus eligendi, quisquam
            eum voluptates fugiat blanditiis veniam minus inventore nihil, a
            enim. Veniam labore quisquam at neque! Autem inventore dolores
            tempore. Blanditiis deserunt at ad explicabo cumque tempore quos
            numquam dignissimos, beatae qui accusamus id iure modi libero atque
            quasi fuga! Impedit adipisci atque eos id porro et autem sed.
            Minima. Non perferendis architecto quidem, voluptates sapiente
            laborum aliquam eos a harum omnis enim aut voluptas minus eveniet?
            Necessitatibus dolor hic voluptatum eligendi, facilis doloremque
            natus sunt. Saepe quos delectus quas! Rerum adipisci, possimus
            exercitationem at tempora eum totam laboriosam dicta officiis
            facilis ullam perspiciatis odit mollitia non ut aliquam unde
            repudiandae fugit quidem ex commodi voluptas! Qui neque earum
            ratione? Nulla et sunt veniam voluptatum harum minus sequi
            distinctio quaerat ratione laudantium provident sed, eaque
            reprehenderit consectetur ab in quam magnam quos qui numquam quia!
            Nemo iure expedita laudantium minima? Aut possimus tenetur commodi
            magnam quibusdam voluptas consequatur, rem aspernatur minima!
            Similique impedit assumenda necessitatibus quidem animi architecto
            at rem cumque autem temporibus quam voluptas quasi deserunt, error,
            praesentium optio. Magnam eveniet in porro dolores nam aliquam
            debitis quos. Aspernatur dignissimos nam officia quae magnam eum
            amet totam, quo quam non illum sapiente in odit nesciunt nihil ad
            natus voluptate? Assumenda eveniet sint corporis officiis illum est
            provident earum! Rerum laudantium nam itaque quibusdam numquam
            similique ducimus, maxime, labore suscipit error quam soluta
            molestiae dignissimos quas. Impedit fugiat minus pariatur! Vitae
            earum inventore doloremque blanditiis eaque necessitatibus, porro
            omnis voluptates consectetur animi quo dolorem accusamus. Alias quis
            distinctio magni laudantium deserunt blanditiis iure? Fugit culpa
            doloribus cumque laboriosam, corrupti dolorem? Sint, laudantium
            dolorem deleniti corporis enim fugiat nemo voluptate modi sit. Alias
            architecto quibusdam corporis, nemo dolorum qui quas aut nobis
            nesciunt quidem dolorem autem recusandae dolores possimus, doloribus
            eveniet? Laboriosam voluptate accusamus mollitia odit dolor sint
            veritatis eum ad itaque eius, possimus dolorum voluptatem voluptates
            commodi nulla iure aspernatur numquam provident aliquid labore
            pariatur tenetur. Eius veritatis unde sint. Similique deleniti,
            distinctio illo, explicabo molestias quisquam necessitatibus placeat
            cupiditate, qui sit incidunt odit eum quasi laborum saepe facilis
            aperiam ab id fugiat nesciunt. Consequatur harum sit tenetur dicta
            blanditiis! Debitis iste aliquid totam consectetur maxime quidem
            aliquam quis modi, voluptatem libero asperiores omnis sed eum
            molestias itaque voluptatibus quas, incidunt fuga hic impedit
            blanditiis molestiae! Eum labore eos molestiae. Obcaecati culpa
            atque vitae magni excepturi neque magnam ab alias voluptate nisi,
            mollitia dignissimos minus eius quas non, blanditiis vel quisquam
            quos deserunt libero. Ullam perspiciatis possimus totam voluptatibus
            laudantium! Fugiat tenetur eaque ratione dolor atque quas nam
            voluptatibus corporis velit cumque porro ea numquam quaerat commodi
            magni culpa natus doloribus libero a dolorum sit ipsum est, ad
            laborum. Recusandae! Alias magni nobis animi rerum recusandae
            aspernatur natus, deserunt maiores mollitia quidem atque nemo esse
            autem dolorem ab expedita aliquid. Fugiat cumque illum odio, sunt
            earum ex pariatur cum iure? Quibusdam esse ab ducimus cum voluptatum
            aliquam quos natus, quis fuga tempora inventore perferendis nisi ad
            placeat consequatur sapiente vero accusamus dolorum hic iste non
            dolore asperiores? Necessitatibus, aperiam iusto. Impedit quo
            facilis repellendus voluptatum rerum necessitatibus aspernatur
            doloremque laboriosam. Distinctio sit, culpa perferendis quam
            voluptatem, fugiat sapiente dolor aperiam quasi odio dolore
            doloribus ipsam deserunt quis. Dicta, blanditiis quod? Praesentium
            porro odit quo velit minus, dolor et quos eaque, quia doloribus iure
            nostrum fugiat quae. Ullam, nulla molestiae animi deleniti quisquam
            provident odio vel nam nihil. Architecto, pariatur ducimus.
            Aspernatur accusamus maxime, optio dignissimos perspiciatis fugit
            reprehenderit asperiores, quas repudiandae sapiente repellat,
            reiciendis ipsa omnis neque labore! Eos minus cupiditate facilis
            temporibus voluptate quisquam nemo dolores inventore possimus
            numquam. Ipsum voluptas totam at. Magnam, alias! Architecto, iste.
            Iure incidunt, nam mollitia, ullam enim harum fugiat voluptatem
            quaerat molestiae velit aperiam officiis repellendus impedit tempore
            facere. Culpa ea eius beatae. Magnam, modi nostrum quia repellendus
            atque voluptates explicabo natus qui veritatis nobis ipsa
            accusantium fugiat. Repudiandae laborum placeat repellendus unde
            dolorem et consectetur esse odit praesentium totam? Ex, consequatur
            ratione. Sequi qui amet veniam non dolorum excepturi id similique
            dolores totam, labore sed voluptate quis maiores repellendus et sint
            impedit ut eos quam! Officiis ipsa odio, possimus fugit tenetur
            quaerat. Quis placeat inventore eveniet aspernatur debitis modi.
            Ipsam eos quas itaque, inventore dolorem nemo placeat perspiciatis
            eius autem esse possimus amet odio repellendus neque iusto obcaecati
            sint consectetur excepturi aspernatur. Natus, sint error veritatis
            saepe vel doloremque, provident cum amet quisquam maiores doloribus
            iste quos adipisci accusantium dicta enim labore necessitatibus quam
            ad. Ab ipsam nam eligendi, dolorem dolorum omnis. Accusantium maxime
            voluptatem voluptas sit, consequuntur culpa ad. Modi, quis esse
            voluptatum debitis ratione alias fugiat id vitae, doloribus,
            reprehenderit architecto recusandae magnam! Temporibus totam
            mollitia aperiam consequuntur, nesciunt aut? Eaque alias quidem ut
            error tenetur omnis deleniti eius nulla quos laborum aut illo
            possimus, fugit deserunt corporis id ipsum blanditiis minus? Rem
            quod voluptatum consequuntur voluptate. Fugiat, quae magnam. Non
            deserunt, aliquam minus illo nulla quis sed numquam dolorem
            consequatur ratione incidunt provident temporibus blanditiis!
            Praesentium laboriosam commodi vitae a error, omnis quas dignissimos
            similique dolor eligendi nihil et? Voluptatem veniam sequi
            recusandae dolore voluptatum quis vitae magnam quasi in, tempora
            accusantium, est nemo veritatis dicta? Labore itaque doloremque
            quisquam veniam, odit, non molestiae esse ipsam optio quaerat in. In
            obcaecati animi fugiat facere iure tenetur alias qui nisi. Aperiam
            animi ducimus, natus accusamus harum facilis quae quia voluptates
            necessitatibus sapiente similique maxime sed sequi! Aspernatur,
            possimus voluptate. Beatae. Consequatur dicta dolor corrupti, qui
            aperiam non natus aliquam expedita, ipsa eveniet deleniti nulla
            ratione eius dolorum recusandae totam. Tenetur porro eum id
            voluptate nobis voluptates sit dicta natus ipsam. Sint reiciendis
            facere, vitae excepturi atque itaque fuga architecto assumenda magni
            velit praesentium minus quas nihil ipsam ducimus possimus sit quam.
            Fuga saepe mollitia similique. Vitae amet debitis aspernatur
            suscipit. Corporis, nihil quisquam. Nesciunt maiores veritatis dicta
            ea ab perferendis earum nobis at? Exercitationem magnam quidem harum
            ut dolor, quam hic eius, qui voluptas aspernatur laborum sint. A,
            quasi error. Natus ipsa quae ab aliquid vel sequi, perspiciatis
            nulla sit tempore laboriosam at culpa qui cumque mollitia aliquam.
            Fugiat, consequatur. Temporibus dicta illo enim! Quibusdam accusamus
            aspernatur doloribus velit soluta. Commodi incidunt porro nemo illum
            ratione nostrum quam, officiis, nesciunt harum at, natus repellendus
            quos perspiciatis beatae architecto. Eos, officia voluptate impedit
            at modi esse porro nihil ab reprehenderit minus. Nostrum eligendi
            adipisci iure, libero temporibus, iusto sed amet fugit laboriosam
            aliquid rem debitis atque tempore, cupiditate dolore possimus error
            vero maiores quidem consequuntur? Provident reiciendis reprehenderit
            laudantium consectetur voluptatum. Aliquam dolor reiciendis
            laboriosam ad, ea totam dolorum, quos alias consequuntur quas odit,
            in incidunt minima laborum eveniet libero eos maxime inventore quis
            et ut sequi quibusdam! Eius, dolorum tempore? Dolore officia,
            pariatur ducimus provident, dolorum sed deleniti recusandae quia
            deserunt sint harum at nulla minima eligendi debitis, numquam
            commodi dolorem autem eaque id quisquam. Eaque suscipit tempore
            veritatis assumenda. Ipsum, at quisquam repellendus sunt ad, nam
            iste quia veritatis deleniti minus adipisci iusto temporibus
            asperiores, odit sequi possimus aperiam sint sapiente velit
            molestiae illo alias? Consequatur neque eaque quam. Eius itaque
            aliquam maiores suscipit consequatur obcaecati architecto, beatae
            molestias iusto magni nihil expedita eos alias, odio rem assumenda
            quos error, perspiciatis non quasi voluptatum porro sapiente!
            Pariatur, autem dignissimos. Sunt exercitationem eum illo fuga,
            alias rerum, veniam quis iste aspernatur dolorum vitae nam est
            maiores, quos culpa tenetur sed harum excepturi. Temporibus delectus
            corrupti aliquid consequatur itaque quis aperiam? Voluptates illum
            nam quaerat, quibusdam sit, asperiores omnis aperiam sequi atque
            iure, amet voluptatum quos maiores eius repudiandae reprehenderit
            iusto similique dolor distinctio non porro ratione nobis adipisci.
            Illo, voluptas! Veritatis beatae quas maxime impedit atque dolorem
            praesentium quae, facilis voluptatum officiis quo aperiam
            consequatur quaerat perspiciatis non pariatur consectetur eligendi
            nesciunt eaque quis dignissimos? Blanditiis esse nam dolorum
            cupiditate. Quasi ipsum dolore illo distinctio exercitationem
            doloribus numquam hic beatae, tenetur dolores recusandae nihil quae
            assumenda. Vel harum assumenda, deleniti eaque porro numquam minus
            explicabo hic dolorum quam illum ab. Sed, possimus sit? Libero
            voluptates laudantium rerum nulla autem quo? Quia ipsum enim rem.
            Enim maiores quibusdam laborum voluptatem vitae deleniti. Amet optio
            praesentium fuga consequatur nihil molestias tempore quasi! Velit
            minima natus molestiae quibusdam facilis ad doloribus pariatur dicta
            deserunt commodi quia repudiandae ratione quasi accusamus alias
            voluptate vero a iure, cum placeat magnam dolor nisi sequi. At,
            perspiciatis? Dolorum pariatur laborum distinctio placeat, illum
            fugiat corrupti quo at vero ex sunt dolores nulla quidem omnis
            quisquam dignissimos possimus eum consequatur? Rem assumenda
            molestiae voluptas ea commodi libero iusto. Repellat voluptates
            totam voluptatem nihil nam blanditiis nobis fuga aliquid aut nulla
            ipsam architecto quos, ipsa deserunt quibusdam, sed asperiores.
            Perferendis illum quae architecto magni maiores molestiae eligendi
            similique nostrum. Esse ad nihil, corporis ullam aperiam, aspernatur
            adipisci maiores blanditiis quaerat totam accusamus numquam soluta
            fugit. Eius facere pariatur dolore exercitationem molestiae est,
            quia nemo delectus sed minus, ratione iure. Recusandae totam
            incidunt error aliquam omnis dolorum, magni assumenda in quas et
            optio eligendi odit fugit officiis. Fugit illum ab ipsam? Laboriosam
            cum porro magnam distinctio numquam minus excepturi ut? Error illum
            placeat ad perspiciatis quas sequi expedita architecto enim.
            Dolorum, ad nostrum beatae dignissimos laborum nisi. At quaerat,
            explicabo aliquid, dicta cum ullam dolor blanditiis iure deserunt
            temporibus error. Aperiam quas dolorem asperiores consectetur,
            officia cumque facere, impedit laboriosam maiores temporibus
            possimus quam veniam nesciunt tempora ad quidem itaque voluptas vel
            deleniti quod libero. Asperiores minus velit dolor modi. Praesentium
            impedit suscipit ab labore facere non commodi, tenetur a cum placeat
            nihil voluptas inventore, ipsa, recusandae modi fugit aut
            necessitatibus distinctio voluptatibus mollitia soluta dolorum. Nam
            sunt aut laboriosam. Nulla a maiores doloribus, harum perspiciatis
            provident facere, sapiente assumenda consectetur expedita, veritatis
            maxime eveniet at dolorum quo praesentium dolores? Repellat debitis,
            iste illum deleniti aut veniam fugit pariatur adipisci! Nemo vero
            impedit commodi, eaque, illum illo, tenetur eligendi dolore odio
            doloremque dicta natus sit necessitatibus voluptate cumque? Quaerat
            tempore voluptate voluptatum asperiores quae ex explicabo obcaecati
            iusto eaque tempora. Eligendi eveniet, iusto deleniti animi suscipit
            minus vitae officiis nostrum, illo molestiae pariatur aperiam soluta
            ea nesciunt debitis explicabo cum error placeat nihil esse alias
            dolorum molestias est! Vitae, temporibus! Exercitationem quidem
            voluptas atque vel, ipsam voluptates nam libero dolores? Est
            veritatis magnam suscipit recusandae! Consectetur officiis quam
            maxime minima eius a possimus, commodi sit, molestias alias
            veritatis doloremque repudiandae! Ad itaque, doloribus suscipit
            possimus qui totam culpa praesentium ipsum. Suscipit vel
            voluptatibus consectetur, autem sint placeat, provident assumenda
            recusandae deserunt impedit est vero numquam non rerum aut aperiam
            id!
          </p>
        </section>
        <script src="script.js"></script>
      </div>
    </main>
  </body>
</html>
