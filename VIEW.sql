create or replace view vwBookStatus
as
select
    i.bookSeq as bookSeq,
    bp.id as id,
    i.list as list,
    bp.learncheck as learncheck
from tblBookprgByUser bp
    inner join tblIndex i
        on bp.indexSeq = i.indexSeq;
        
commit;


