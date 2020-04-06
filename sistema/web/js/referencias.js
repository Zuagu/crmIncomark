//==============================================================================
function insert_referencias(_id_xxyyzz, ) {
    var params = {
        accion: "insert_referencias",
        id_xxyyzz: _id_xxyyzz,
        xxyyzz: _xxyyzz
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageReferencias",
        data: params,
        dataType: "json",
        success: function (dataRes) {
            alert(dataRes);
            select_xxyyzz_tabla(_id_caja);
            select_xxyyzz_combo(_id_caja);
        }
    });
}
;
//==============================================================================
