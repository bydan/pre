/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.tesoreria.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraConstantesFunciones;
import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AutoriPagoOrdenCompraConstantesFunciones extends AutoriPagoOrdenCompraConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="AutoriPagoOrdenCompra";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutoriPagoOrdenCompra"+AutoriPagoOrdenCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutoriPagoOrdenCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutoriPagoOrdenCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"_"+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutoriPagoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"_"+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"_"+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutoriPagoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"_"+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriPagoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriPagoOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutoriPagoOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutoriPagoOrdenCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutoriPagoOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutoriPagoOrdenCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autori Pago Orden Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Autori Pago Orden Compra";
	public static final String SCLASSWEBTITULO_LOWER="Autori Pago Orden Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutoriPagoOrdenCompra";
	public static final String OBJECTNAME="autoripagoordencompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="autori_pago_orden_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autoripagoordencompra from "+AutoriPagoOrdenCompraConstantesFunciones.SPERSISTENCENAME+" autoripagoordencompra";
	public static String QUERYSELECTNATIVE="select "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_moneda,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_cliente,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_transaccion,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_modulo,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_usuario,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_banco,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_cuenta_banco,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_autori,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".total,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_servidor,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".codigo_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".valor_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".total_saldo from "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;//+" as "+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AutoriPagoOrdenCompraConstantesFuncionesAdditional autoripagoordencompraConstantesFuncionesAdditional=null;
	
	public AutoriPagoOrdenCompraConstantesFuncionesAdditional getAutoriPagoOrdenCompraConstantesFuncionesAdditional() {
		return this.autoripagoordencompraConstantesFuncionesAdditional;
	}
	
	public void setAutoriPagoOrdenCompraConstantesFuncionesAdditional(AutoriPagoOrdenCompraConstantesFuncionesAdditional autoripagoordencompraConstantesFuncionesAdditional) {
		try {
			this.autoripagoordencompraConstantesFuncionesAdditional=autoripagoordencompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDORDENCOMPRA= "id_orden_compra";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDBANCO= "id_banco";
    public static final String IDCUENTABANCO= "id_cuenta_banco";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
    public static final String FECHAAUTORI= "fecha_autori";
    public static final String TOTAL= "total";
    public static final String FECHASERVIDOR= "fecha_servidor";
    public static final String CODIGOASIENTO= "codigo_asiento";
    public static final String FECHAASIENTO= "fecha_asiento";
    public static final String VALORASIENTO= "valor_asiento";
    public static final String TOTALSALDO= "total_saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDORDENCOMPRA= "Orden Compra";
		public static final String LABEL_IDORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDCUENTABANCO= "Cuenta Banco";
		public static final String LABEL_IDCUENTABANCO_LOWER= "Cuenta Banco";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAAUTORI= "Fecha Autori";
		public static final String LABEL_FECHAAUTORI_LOWER= "Fecha Autori";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHASERVIDOR= "Fecha Servidor";
		public static final String LABEL_FECHASERVIDOR_LOWER= "Fecha Servidor";
    	public static final String LABEL_CODIGOASIENTO= "Codigo Asiento";
		public static final String LABEL_CODIGOASIENTO_LOWER= "Codigo Asiento";
    	public static final String LABEL_FECHAASIENTO= "Fecha Asiento";
		public static final String LABEL_FECHAASIENTO_LOWER= "Fecha Asiento";
    	public static final String LABEL_VALORASIENTO= "Valor Asiento";
		public static final String LABEL_VALORASIENTO_LOWER= "Valor Asiento";
    	public static final String LABEL_TOTALSALDO= "Total Saldo";
		public static final String LABEL_TOTALSALDO_LOWER= "Total Saldo";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXCODIGO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getAutoriPagoOrdenCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDBANCO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCUENTABANCO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHA)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAAUTORI;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTAL)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHASERVIDOR;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_CODIGOASIENTO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAASIENTO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO;}
		if(sNombreColumna.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO)) {sLabelColumna=AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAutoriPagoOrdenCompraDescripcion(AutoriPagoOrdenCompra autoripagoordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autoripagoordencompra !=null/* && autoripagoordencompra.getId()!=0*/) {
			if(autoripagoordencompra.getId()!=null) {
				sDescripcion=autoripagoordencompra.getId().toString();
			}//autoripagoordencompraautoripagoordencompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAutoriPagoOrdenCompraDescripcionDetallado(AutoriPagoOrdenCompra autoripagoordencompra) {
		String sDescripcion="";
			
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.ID+"=";
		sDescripcion+=autoripagoordencompra.getId().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autoripagoordencompra.getVersionRow().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=autoripagoordencompra.getid_tipo_cambio().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=autoripagoordencompra.getid_moneda().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=autoripagoordencompra.getid_cliente().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autoripagoordencompra.getid_empresa().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=autoripagoordencompra.getid_sucursal().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA+"=";
		sDescripcion+=autoripagoordencompra.getid_orden_compra().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=autoripagoordencompra.getid_transaccion().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=autoripagoordencompra.getid_modulo().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=autoripagoordencompra.getid_ejercicio().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=autoripagoordencompra.getid_usuario().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=autoripagoordencompra.getid_asiento_contable().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDBANCO+"=";
		sDescripcion+=autoripagoordencompra.getid_banco().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO+"=";
		sDescripcion+=autoripagoordencompra.getid_cuenta_banco().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=autoripagoordencompra.getnumero_comprobante()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.FECHA+"=";
		sDescripcion+=autoripagoordencompra.getfecha().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI+"=";
		sDescripcion+=autoripagoordencompra.getfecha_autori().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.TOTAL+"=";
		sDescripcion+=autoripagoordencompra.gettotal().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR+"=";
		sDescripcion+=autoripagoordencompra.getfecha_servidor().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO+"=";
		sDescripcion+=autoripagoordencompra.getcodigo_asiento()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO+"=";
		sDescripcion+=autoripagoordencompra.getfecha_asiento().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO+"=";
		sDescripcion+=autoripagoordencompra.getvalor_asiento().toString()+",";
		sDescripcion+=AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO+"=";
		sDescripcion+=autoripagoordencompra.gettotal_saldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAutoriPagoOrdenCompraDescripcion(AutoriPagoOrdenCompra autoripagoordencompra,String sValor) throws Exception {			
		if(autoripagoordencompra !=null) {
			//autoripagoordencompraautoripagoordencompra.getId().toString();
		}		
	}
	
		

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getOrdenCompraDescripcion(OrdenCompra ordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordencompra!=null/*&&ordencompra.getId()>0*/) {
			sDescripcion=OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompra);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabanco!=null/*&&cuentabanco.getId()>0*/) {
			sDescripcion=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(cuentabanco);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdCuentaBanco")) {
			sNombreIndice="Tipo=  Por Cuenta Banco";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdOrdenCompra")) {
			sNombreIndice="Tipo=  Por Orden Compra";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaBanco(Long id_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco="+id_cuenta_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdOrdenCompra(Long id_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Orden Compra="+id_orden_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autoripagoordencompra.setnumero_comprobante(autoripagoordencompra.getnumero_comprobante().trim());
		autoripagoordencompra.setcodigo_asiento(autoripagoordencompra.getcodigo_asiento().trim());
	}
	
	public static void quitarEspaciosAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutoriPagoOrdenCompra autoripagoordencompra: autoripagoordencompras) {
			autoripagoordencompra.setnumero_comprobante(autoripagoordencompra.getnumero_comprobante().trim());
			autoripagoordencompra.setcodigo_asiento(autoripagoordencompra.getcodigo_asiento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autoripagoordencompra.getConCambioAuxiliar()) {
			autoripagoordencompra.setIsDeleted(autoripagoordencompra.getIsDeletedAuxiliar());	
			autoripagoordencompra.setIsNew(autoripagoordencompra.getIsNewAuxiliar());	
			autoripagoordencompra.setIsChanged(autoripagoordencompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autoripagoordencompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autoripagoordencompra.setIsDeletedAuxiliar(false);	
			autoripagoordencompra.setIsNewAuxiliar(false);	
			autoripagoordencompra.setIsChangedAuxiliar(false);
			
			autoripagoordencompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutoriPagoOrdenCompra autoripagoordencompra : autoripagoordencompras) {
			if(conAsignarBase && autoripagoordencompra.getConCambioAuxiliar()) {
				autoripagoordencompra.setIsDeleted(autoripagoordencompra.getIsDeletedAuxiliar());	
				autoripagoordencompra.setIsNew(autoripagoordencompra.getIsNewAuxiliar());	
				autoripagoordencompra.setIsChanged(autoripagoordencompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autoripagoordencompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autoripagoordencompra.setIsDeletedAuxiliar(false);	
				autoripagoordencompra.setIsNewAuxiliar(false);	
				autoripagoordencompra.setIsChangedAuxiliar(false);
				
				autoripagoordencompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra,Boolean conEnteros) throws Exception  {
		autoripagoordencompra.settotal(0.0);
		autoripagoordencompra.setvalor_asiento(0.0);
		autoripagoordencompra.settotal_saldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras,Boolean conEnteros) throws Exception  {
		
		for(AutoriPagoOrdenCompra autoripagoordencompra: autoripagoordencompras) {
			autoripagoordencompra.settotal(0.0);
			autoripagoordencompra.setvalor_asiento(0.0);
			autoripagoordencompra.settotal_saldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompra autoripagoordencompraAux) throws Exception  {
		AutoriPagoOrdenCompraConstantesFunciones.InicializarValoresAutoriPagoOrdenCompra(autoripagoordencompraAux,true);
		
		for(AutoriPagoOrdenCompra autoripagoordencompra: autoripagoordencompras) {
			if(autoripagoordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			autoripagoordencompraAux.settotal(autoripagoordencompraAux.gettotal()+autoripagoordencompra.gettotal());			
			autoripagoordencompraAux.setvalor_asiento(autoripagoordencompraAux.getvalor_asiento()+autoripagoordencompra.getvalor_asiento());			
			autoripagoordencompraAux.settotal_saldo(autoripagoordencompraAux.gettotal_saldo()+autoripagoordencompra.gettotal_saldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriPagoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutoriPagoOrdenCompraConstantesFunciones.getArrayColumnasGlobalesAutoriPagoOrdenCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriPagoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutoriPagoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompra autoripagoordencompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutoriPagoOrdenCompra autoripagoordencompraAux: autoripagoordencompras) {
			if(autoripagoordencompraAux!=null && autoripagoordencompra!=null) {
				if((autoripagoordencompraAux.getId()==null && autoripagoordencompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autoripagoordencompraAux.getId()!=null && autoripagoordencompra.getId()!=null){
					if(autoripagoordencompraAux.getId().equals(autoripagoordencompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> autoripagoordencompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double valor_asientoTotal=0.0;
		Double total_saldoTotal=0.0;
	
		for(AutoriPagoOrdenCompra autoripagoordencompra: autoripagoordencompras) {			
			if(autoripagoordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=autoripagoordencompra.gettotal();
			valor_asientoTotal+=autoripagoordencompra.getvalor_asiento();
			total_saldoTotal+=autoripagoordencompra.gettotal_saldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO);
		datoGeneral.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO);
		datoGeneral.setdValorDouble(valor_asientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO);
		datoGeneral.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO);
		datoGeneral.setdValorDouble(total_saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutoriPagoOrdenCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_ID, AutoriPagoOrdenCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_VERSIONROW, AutoriPagoOrdenCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO, AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMONEDA, AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCLIENTE, AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEMPRESA, AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL, AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA, AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTRANSACCION, AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMODULO, AutoriPagoOrdenCompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO, AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDUSUARIO, AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE, AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDBANCO, AutoriPagoOrdenCompraConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCUENTABANCO, AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE, AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHA, AutoriPagoOrdenCompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAAUTORI, AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL, AutoriPagoOrdenCompraConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHASERVIDOR, AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_CODIGOASIENTO, AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAASIENTO, AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO, AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO, AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutoriPagoOrdenCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPagoOrdenCompra() throws Exception  {
		return AutoriPagoOrdenCompraConstantesFunciones.getTiposSeleccionarAutoriPagoOrdenCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPagoOrdenCompra(Boolean conFk) throws Exception  {
		return AutoriPagoOrdenCompraConstantesFunciones.getTiposSeleccionarAutoriPagoOrdenCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPagoOrdenCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCUENTABANCO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAAUTORI);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAAUTORI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHASERVIDOR);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHASERVIDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_CODIGOASIENTO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_CODIGOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAASIENTO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO);
			reporte.setsDescripcion(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutoriPagoOrdenCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompraAux) throws Exception {
		
			autoripagoordencompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(autoripagoordencompraAux.getTipoCambio()));
			autoripagoordencompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(autoripagoordencompraAux.getMoneda()));
			autoripagoordencompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoripagoordencompraAux.getCliente()));
			autoripagoordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoripagoordencompraAux.getEmpresa()));
			autoripagoordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoripagoordencompraAux.getSucursal()));
			autoripagoordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(autoripagoordencompraAux.getOrdenCompra()));
			autoripagoordencompraAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(autoripagoordencompraAux.getTransaccion()));
			autoripagoordencompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(autoripagoordencompraAux.getModulo()));
			autoripagoordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(autoripagoordencompraAux.getEjercicio()));
			autoripagoordencompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoripagoordencompraAux.getUsuario()));
			autoripagoordencompraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(autoripagoordencompraAux.getAsientoContable()));
			autoripagoordencompraAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(autoripagoordencompraAux.getBanco()));
			autoripagoordencompraAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(autoripagoordencompraAux.getCuentaBanco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> autoripagoordencomprasTemp) throws Exception {
		for(AutoriPagoOrdenCompra autoripagoordencompraAux:autoripagoordencomprasTemp) {
			
			autoripagoordencompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(autoripagoordencompraAux.getTipoCambio()));
			autoripagoordencompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(autoripagoordencompraAux.getMoneda()));
			autoripagoordencompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoripagoordencompraAux.getCliente()));
			autoripagoordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoripagoordencompraAux.getEmpresa()));
			autoripagoordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoripagoordencompraAux.getSucursal()));
			autoripagoordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(autoripagoordencompraAux.getOrdenCompra()));
			autoripagoordencompraAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(autoripagoordencompraAux.getTransaccion()));
			autoripagoordencompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(autoripagoordencompraAux.getModulo()));
			autoripagoordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(autoripagoordencompraAux.getEjercicio()));
			autoripagoordencompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoripagoordencompraAux.getUsuario()));
			autoripagoordencompraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(autoripagoordencompraAux.getAsientoContable()));
			autoripagoordencompraAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(autoripagoordencompraAux.getBanco()));
			autoripagoordencompraAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(autoripagoordencompraAux.getCuentaBanco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriPagoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(CuentaBanco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutoriPagoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPagoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriPagoOrdenCompraConstantesFunciones.getClassesRelationshipsOfAutoriPagoOrdenCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPagoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriPagoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriPagoOrdenCompraConstantesFunciones.getClassesRelationshipsFromStringsOfAutoriPagoOrdenCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriPagoOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(AutoriPagoOrdenCompra autoripagoordencompra,List<AutoriPagoOrdenCompra> autoripagoordencompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AutoriPagoOrdenCompra autoripagoordencompraEncontrado=null;
			
			for(AutoriPagoOrdenCompra autoripagoordencompraLocal:autoripagoordencompras) {
				if(autoripagoordencompraLocal.getId().equals(autoripagoordencompra.getId())) {
					autoripagoordencompraEncontrado=autoripagoordencompraLocal;
					
					autoripagoordencompraLocal.setIsChanged(autoripagoordencompra.getIsChanged());
					autoripagoordencompraLocal.setIsNew(autoripagoordencompra.getIsNew());
					autoripagoordencompraLocal.setIsDeleted(autoripagoordencompra.getIsDeleted());
					
					autoripagoordencompraLocal.setGeneralEntityOriginal(autoripagoordencompra.getGeneralEntityOriginal());
					
					autoripagoordencompraLocal.setId(autoripagoordencompra.getId());	
					autoripagoordencompraLocal.setVersionRow(autoripagoordencompra.getVersionRow());	
					autoripagoordencompraLocal.setid_tipo_cambio(autoripagoordencompra.getid_tipo_cambio());	
					autoripagoordencompraLocal.setid_moneda(autoripagoordencompra.getid_moneda());	
					autoripagoordencompraLocal.setid_cliente(autoripagoordencompra.getid_cliente());	
					autoripagoordencompraLocal.setid_empresa(autoripagoordencompra.getid_empresa());	
					autoripagoordencompraLocal.setid_sucursal(autoripagoordencompra.getid_sucursal());	
					autoripagoordencompraLocal.setid_orden_compra(autoripagoordencompra.getid_orden_compra());	
					autoripagoordencompraLocal.setid_transaccion(autoripagoordencompra.getid_transaccion());	
					autoripagoordencompraLocal.setid_modulo(autoripagoordencompra.getid_modulo());	
					autoripagoordencompraLocal.setid_ejercicio(autoripagoordencompra.getid_ejercicio());	
					autoripagoordencompraLocal.setid_usuario(autoripagoordencompra.getid_usuario());	
					autoripagoordencompraLocal.setid_asiento_contable(autoripagoordencompra.getid_asiento_contable());	
					autoripagoordencompraLocal.setid_banco(autoripagoordencompra.getid_banco());	
					autoripagoordencompraLocal.setid_cuenta_banco(autoripagoordencompra.getid_cuenta_banco());	
					autoripagoordencompraLocal.setnumero_comprobante(autoripagoordencompra.getnumero_comprobante());	
					autoripagoordencompraLocal.setfecha(autoripagoordencompra.getfecha());	
					autoripagoordencompraLocal.setfecha_autori(autoripagoordencompra.getfecha_autori());	
					autoripagoordencompraLocal.settotal(autoripagoordencompra.gettotal());	
					autoripagoordencompraLocal.setfecha_servidor(autoripagoordencompra.getfecha_servidor());	
					autoripagoordencompraLocal.setcodigo_asiento(autoripagoordencompra.getcodigo_asiento());	
					autoripagoordencompraLocal.setfecha_asiento(autoripagoordencompra.getfecha_asiento());	
					autoripagoordencompraLocal.setvalor_asiento(autoripagoordencompra.getvalor_asiento());	
					autoripagoordencompraLocal.settotal_saldo(autoripagoordencompra.gettotal_saldo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!autoripagoordencompra.getIsDeleted()) {
				if(!existe) {
					autoripagoordencompras.add(autoripagoordencompra);
				}
			} else {
				if(autoripagoordencompraEncontrado!=null && permiteQuitar)  {
					autoripagoordencompras.remove(autoripagoordencompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AutoriPagoOrdenCompra autoripagoordencompra,List<AutoriPagoOrdenCompra> autoripagoordencompras) throws Exception {
		try	{			
			for(AutoriPagoOrdenCompra autoripagoordencompraLocal:autoripagoordencompras) {
				if(autoripagoordencompraLocal.getId().equals(autoripagoordencompra.getId())) {
					autoripagoordencompraLocal.setIsSelected(autoripagoordencompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> autoripagoordencomprasAux) throws Exception {
		//this.autoripagoordencomprasAux=autoripagoordencomprasAux;
		
		for(AutoriPagoOrdenCompra autoripagoordencompraAux:autoripagoordencomprasAux) {
			if(autoripagoordencompraAux.getIsChanged()) {
				autoripagoordencompraAux.setIsChanged(false);
			}		
			
			if(autoripagoordencompraAux.getIsNew()) {
				autoripagoordencompraAux.setIsNew(false);
			}	
			
			if(autoripagoordencompraAux.getIsDeleted()) {
				autoripagoordencompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompraAux) throws Exception {
		//this.autoripagoordencompraAux=autoripagoordencompraAux;
		
			if(autoripagoordencompraAux.getIsChanged()) {
				autoripagoordencompraAux.setIsChanged(false);
			}		
			
			if(autoripagoordencompraAux.getIsNew()) {
				autoripagoordencompraAux.setIsNew(false);
			}	
			
			if(autoripagoordencompraAux.getIsDeleted()) {
				autoripagoordencompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutoriPagoOrdenCompra autoripagoordencompraAsignar,AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {
		autoripagoordencompraAsignar.setId(autoripagoordencompra.getId());	
		autoripagoordencompraAsignar.setVersionRow(autoripagoordencompra.getVersionRow());	
		autoripagoordencompraAsignar.setid_tipo_cambio(autoripagoordencompra.getid_tipo_cambio());
		autoripagoordencompraAsignar.settipocambio_descripcion(autoripagoordencompra.gettipocambio_descripcion());	
		autoripagoordencompraAsignar.setid_moneda(autoripagoordencompra.getid_moneda());
		autoripagoordencompraAsignar.setmoneda_descripcion(autoripagoordencompra.getmoneda_descripcion());	
		autoripagoordencompraAsignar.setid_cliente(autoripagoordencompra.getid_cliente());
		autoripagoordencompraAsignar.setcliente_descripcion(autoripagoordencompra.getcliente_descripcion());	
		autoripagoordencompraAsignar.setid_empresa(autoripagoordencompra.getid_empresa());
		autoripagoordencompraAsignar.setempresa_descripcion(autoripagoordencompra.getempresa_descripcion());	
		autoripagoordencompraAsignar.setid_sucursal(autoripagoordencompra.getid_sucursal());
		autoripagoordencompraAsignar.setsucursal_descripcion(autoripagoordencompra.getsucursal_descripcion());	
		autoripagoordencompraAsignar.setid_orden_compra(autoripagoordencompra.getid_orden_compra());
		autoripagoordencompraAsignar.setordencompra_descripcion(autoripagoordencompra.getordencompra_descripcion());	
		autoripagoordencompraAsignar.setid_transaccion(autoripagoordencompra.getid_transaccion());
		autoripagoordencompraAsignar.settransaccion_descripcion(autoripagoordencompra.gettransaccion_descripcion());	
		autoripagoordencompraAsignar.setid_modulo(autoripagoordencompra.getid_modulo());
		autoripagoordencompraAsignar.setmodulo_descripcion(autoripagoordencompra.getmodulo_descripcion());	
		autoripagoordencompraAsignar.setid_ejercicio(autoripagoordencompra.getid_ejercicio());
		autoripagoordencompraAsignar.setejercicio_descripcion(autoripagoordencompra.getejercicio_descripcion());	
		autoripagoordencompraAsignar.setid_usuario(autoripagoordencompra.getid_usuario());
		autoripagoordencompraAsignar.setusuario_descripcion(autoripagoordencompra.getusuario_descripcion());	
		autoripagoordencompraAsignar.setid_asiento_contable(autoripagoordencompra.getid_asiento_contable());
		autoripagoordencompraAsignar.setasientocontable_descripcion(autoripagoordencompra.getasientocontable_descripcion());	
		autoripagoordencompraAsignar.setid_banco(autoripagoordencompra.getid_banco());
		autoripagoordencompraAsignar.setbanco_descripcion(autoripagoordencompra.getbanco_descripcion());	
		autoripagoordencompraAsignar.setid_cuenta_banco(autoripagoordencompra.getid_cuenta_banco());
		autoripagoordencompraAsignar.setcuentabanco_descripcion(autoripagoordencompra.getcuentabanco_descripcion());	
		autoripagoordencompraAsignar.setnumero_comprobante(autoripagoordencompra.getnumero_comprobante());	
		autoripagoordencompraAsignar.setfecha(autoripagoordencompra.getfecha());	
		autoripagoordencompraAsignar.setfecha_autori(autoripagoordencompra.getfecha_autori());	
		autoripagoordencompraAsignar.settotal(autoripagoordencompra.gettotal());	
		autoripagoordencompraAsignar.setfecha_servidor(autoripagoordencompra.getfecha_servidor());	
		autoripagoordencompraAsignar.setcodigo_asiento(autoripagoordencompra.getcodigo_asiento());	
		autoripagoordencompraAsignar.setfecha_asiento(autoripagoordencompra.getfecha_asiento());	
		autoripagoordencompraAsignar.setvalor_asiento(autoripagoordencompra.getvalor_asiento());	
		autoripagoordencompraAsignar.settotal_saldo(autoripagoordencompra.gettotal_saldo());	
	}
	
	public static void inicializarAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {
		try {
				autoripagoordencompra.setId(0L);	
					
				autoripagoordencompra.setid_tipo_cambio(null);	
				autoripagoordencompra.setid_moneda(-1L);	
				autoripagoordencompra.setid_cliente(-1L);	
				autoripagoordencompra.setid_empresa(-1L);	
				autoripagoordencompra.setid_sucursal(-1L);	
				autoripagoordencompra.setid_orden_compra(-1L);	
				autoripagoordencompra.setid_transaccion(-1L);	
				autoripagoordencompra.setid_modulo(-1L);	
				autoripagoordencompra.setid_ejercicio(-1L);	
				autoripagoordencompra.setid_usuario(-1L);	
				autoripagoordencompra.setid_asiento_contable(-1L);	
				autoripagoordencompra.setid_banco(-1L);	
				autoripagoordencompra.setid_cuenta_banco(-1L);	
				autoripagoordencompra.setnumero_comprobante("");	
				autoripagoordencompra.setfecha(new Date());	
				autoripagoordencompra.setfecha_autori(new Date());	
				autoripagoordencompra.settotal(0.0);	
				autoripagoordencompra.setfecha_servidor(new Date());	
				autoripagoordencompra.setcodigo_asiento("");	
				autoripagoordencompra.setfecha_asiento(new Date());	
				autoripagoordencompra.setvalor_asiento(0.0);	
				autoripagoordencompra.settotal_saldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutoriPagoOrdenCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_IDCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAAUTORI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHASERVIDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_CODIGOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_FECHAASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_VALORASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoOrdenCompraConstantesFunciones.LABEL_TOTALSALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutoriPagoOrdenCompra(String sTipo,Row row,Workbook workbook,AutoriPagoOrdenCompra autoripagoordencompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getcuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getfecha_autori());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getfecha_servidor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getcodigo_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getfecha_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.getvalor_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripagoordencompra.gettotal_saldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutoriPagoOrdenCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAutoriPagoOrdenCompra() {
		return this.sFinalQueryAutoriPagoOrdenCompra;
	}
	
	public void setsFinalQueryAutoriPagoOrdenCompra(String sFinalQueryAutoriPagoOrdenCompra) {
		this.sFinalQueryAutoriPagoOrdenCompra= sFinalQueryAutoriPagoOrdenCompra;
	}
	
	public Border resaltarSeleccionarAutoriPagoOrdenCompra=null;
	
	public Border setResaltarSeleccionarAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutoriPagoOrdenCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutoriPagoOrdenCompra() {
		return this.resaltarSeleccionarAutoriPagoOrdenCompra;
	}
	
	public void setResaltarSeleccionarAutoriPagoOrdenCompra(Border borderResaltarSeleccionarAutoriPagoOrdenCompra) {
		this.resaltarSeleccionarAutoriPagoOrdenCompra= borderResaltarSeleccionarAutoriPagoOrdenCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutoriPagoOrdenCompra=null;
	public Boolean mostraridAutoriPagoOrdenCompra=true;
	public Boolean activaridAutoriPagoOrdenCompra=true;

	public Border resaltarid_tipo_cambioAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_tipo_cambioAutoriPagoOrdenCompra=true;
	public Boolean activarid_tipo_cambioAutoriPagoOrdenCompra=true;
	public Boolean cargarid_tipo_cambioAutoriPagoOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_monedaAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_monedaAutoriPagoOrdenCompra=true;
	public Boolean activarid_monedaAutoriPagoOrdenCompra=true;
	public Boolean cargarid_monedaAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_clienteAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_clienteAutoriPagoOrdenCompra=true;
	public Boolean activarid_clienteAutoriPagoOrdenCompra=true;
	public Boolean cargarid_clienteAutoriPagoOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_empresaAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_empresaAutoriPagoOrdenCompra=true;
	public Boolean activarid_empresaAutoriPagoOrdenCompra=true;
	public Boolean cargarid_empresaAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_sucursalAutoriPagoOrdenCompra=true;
	public Boolean activarid_sucursalAutoriPagoOrdenCompra=true;
	public Boolean cargarid_sucursalAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_orden_compraAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_orden_compraAutoriPagoOrdenCompra=true;
	public Boolean activarid_orden_compraAutoriPagoOrdenCompra=true;
	public Boolean cargarid_orden_compraAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_compraAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_transaccionAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_transaccionAutoriPagoOrdenCompra=true;
	public Boolean activarid_transaccionAutoriPagoOrdenCompra=true;
	public Boolean cargarid_transaccionAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_moduloAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_moduloAutoriPagoOrdenCompra=true;
	public Boolean activarid_moduloAutoriPagoOrdenCompra=true;
	public Boolean cargarid_moduloAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_ejercicioAutoriPagoOrdenCompra=true;
	public Boolean activarid_ejercicioAutoriPagoOrdenCompra=true;
	public Boolean cargarid_ejercicioAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_usuarioAutoriPagoOrdenCompra=true;
	public Boolean activarid_usuarioAutoriPagoOrdenCompra=true;
	public Boolean cargarid_usuarioAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_asiento_contableAutoriPagoOrdenCompra=true;
	public Boolean activarid_asiento_contableAutoriPagoOrdenCompra=true;
	public Boolean cargarid_asiento_contableAutoriPagoOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_bancoAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_bancoAutoriPagoOrdenCompra=true;
	public Boolean activarid_bancoAutoriPagoOrdenCompra=true;
	public Boolean cargarid_bancoAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_cuenta_bancoAutoriPagoOrdenCompra=null;
	public Boolean mostrarid_cuenta_bancoAutoriPagoOrdenCompra=true;
	public Boolean activarid_cuenta_bancoAutoriPagoOrdenCompra=true;
	public Boolean cargarid_cuenta_bancoAutoriPagoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_bancoAutoriPagoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteAutoriPagoOrdenCompra=null;
	public Boolean mostrarnumero_comprobanteAutoriPagoOrdenCompra=true;
	public Boolean activarnumero_comprobanteAutoriPagoOrdenCompra=true;

	public Border resaltarfechaAutoriPagoOrdenCompra=null;
	public Boolean mostrarfechaAutoriPagoOrdenCompra=true;
	public Boolean activarfechaAutoriPagoOrdenCompra=false;

	public Border resaltarfecha_autoriAutoriPagoOrdenCompra=null;
	public Boolean mostrarfecha_autoriAutoriPagoOrdenCompra=true;
	public Boolean activarfecha_autoriAutoriPagoOrdenCompra=false;

	public Border resaltartotalAutoriPagoOrdenCompra=null;
	public Boolean mostrartotalAutoriPagoOrdenCompra=true;
	public Boolean activartotalAutoriPagoOrdenCompra=true;

	public Border resaltarfecha_servidorAutoriPagoOrdenCompra=null;
	public Boolean mostrarfecha_servidorAutoriPagoOrdenCompra=true;
	public Boolean activarfecha_servidorAutoriPagoOrdenCompra=true;

	public Border resaltarcodigo_asientoAutoriPagoOrdenCompra=null;
	public Boolean mostrarcodigo_asientoAutoriPagoOrdenCompra=true;
	public Boolean activarcodigo_asientoAutoriPagoOrdenCompra=true;

	public Border resaltarfecha_asientoAutoriPagoOrdenCompra=null;
	public Boolean mostrarfecha_asientoAutoriPagoOrdenCompra=true;
	public Boolean activarfecha_asientoAutoriPagoOrdenCompra=false;

	public Border resaltarvalor_asientoAutoriPagoOrdenCompra=null;
	public Boolean mostrarvalor_asientoAutoriPagoOrdenCompra=true;
	public Boolean activarvalor_asientoAutoriPagoOrdenCompra=true;

	public Border resaltartotal_saldoAutoriPagoOrdenCompra=null;
	public Boolean mostrartotal_saldoAutoriPagoOrdenCompra=true;
	public Boolean activartotal_saldoAutoriPagoOrdenCompra=true;

	
	

	public Border setResaltaridAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltaridAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutoriPagoOrdenCompra() {
		return this.resaltaridAutoriPagoOrdenCompra;
	}

	public void setResaltaridAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltaridAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostraridAutoriPagoOrdenCompra() {
		return this.mostraridAutoriPagoOrdenCompra;
	}

	public void setMostraridAutoriPagoOrdenCompra(Boolean mostraridAutoriPagoOrdenCompra) {
		this.mostraridAutoriPagoOrdenCompra= mostraridAutoriPagoOrdenCompra;
	}

	public Boolean getActivaridAutoriPagoOrdenCompra() {
		return this.activaridAutoriPagoOrdenCompra;
	}

	public void setActivaridAutoriPagoOrdenCompra(Boolean activaridAutoriPagoOrdenCompra) {
		this.activaridAutoriPagoOrdenCompra= activaridAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_tipo_cambioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioAutoriPagoOrdenCompra() {
		return this.resaltarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public void setResaltarid_tipo_cambioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_tipo_cambioAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioAutoriPagoOrdenCompra() {
		return this.mostrarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public void setMostrarid_tipo_cambioAutoriPagoOrdenCompra(Boolean mostrarid_tipo_cambioAutoriPagoOrdenCompra) {
		this.mostrarid_tipo_cambioAutoriPagoOrdenCompra= mostrarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_tipo_cambioAutoriPagoOrdenCompra() {
		return this.activarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public void setActivarid_tipo_cambioAutoriPagoOrdenCompra(Boolean activarid_tipo_cambioAutoriPagoOrdenCompra) {
		this.activarid_tipo_cambioAutoriPagoOrdenCompra= activarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_tipo_cambioAutoriPagoOrdenCompra() {
		return this.cargarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public void setCargarid_tipo_cambioAutoriPagoOrdenCompra(Boolean cargarid_tipo_cambioAutoriPagoOrdenCompra) {
		this.cargarid_tipo_cambioAutoriPagoOrdenCompra= cargarid_tipo_cambioAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_monedaAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_monedaAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaAutoriPagoOrdenCompra() {
		return this.resaltarid_monedaAutoriPagoOrdenCompra;
	}

	public void setResaltarid_monedaAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_monedaAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_monedaAutoriPagoOrdenCompra() {
		return this.mostrarid_monedaAutoriPagoOrdenCompra;
	}

	public void setMostrarid_monedaAutoriPagoOrdenCompra(Boolean mostrarid_monedaAutoriPagoOrdenCompra) {
		this.mostrarid_monedaAutoriPagoOrdenCompra= mostrarid_monedaAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_monedaAutoriPagoOrdenCompra() {
		return this.activarid_monedaAutoriPagoOrdenCompra;
	}

	public void setActivarid_monedaAutoriPagoOrdenCompra(Boolean activarid_monedaAutoriPagoOrdenCompra) {
		this.activarid_monedaAutoriPagoOrdenCompra= activarid_monedaAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_monedaAutoriPagoOrdenCompra() {
		return this.cargarid_monedaAutoriPagoOrdenCompra;
	}

	public void setCargarid_monedaAutoriPagoOrdenCompra(Boolean cargarid_monedaAutoriPagoOrdenCompra) {
		this.cargarid_monedaAutoriPagoOrdenCompra= cargarid_monedaAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_clienteAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_clienteAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteAutoriPagoOrdenCompra() {
		return this.resaltarid_clienteAutoriPagoOrdenCompra;
	}

	public void setResaltarid_clienteAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_clienteAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_clienteAutoriPagoOrdenCompra() {
		return this.mostrarid_clienteAutoriPagoOrdenCompra;
	}

	public void setMostrarid_clienteAutoriPagoOrdenCompra(Boolean mostrarid_clienteAutoriPagoOrdenCompra) {
		this.mostrarid_clienteAutoriPagoOrdenCompra= mostrarid_clienteAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_clienteAutoriPagoOrdenCompra() {
		return this.activarid_clienteAutoriPagoOrdenCompra;
	}

	public void setActivarid_clienteAutoriPagoOrdenCompra(Boolean activarid_clienteAutoriPagoOrdenCompra) {
		this.activarid_clienteAutoriPagoOrdenCompra= activarid_clienteAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_clienteAutoriPagoOrdenCompra() {
		return this.cargarid_clienteAutoriPagoOrdenCompra;
	}

	public void setCargarid_clienteAutoriPagoOrdenCompra(Boolean cargarid_clienteAutoriPagoOrdenCompra) {
		this.cargarid_clienteAutoriPagoOrdenCompra= cargarid_clienteAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_empresaAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutoriPagoOrdenCompra() {
		return this.resaltarid_empresaAutoriPagoOrdenCompra;
	}

	public void setResaltarid_empresaAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_empresaAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutoriPagoOrdenCompra() {
		return this.mostrarid_empresaAutoriPagoOrdenCompra;
	}

	public void setMostrarid_empresaAutoriPagoOrdenCompra(Boolean mostrarid_empresaAutoriPagoOrdenCompra) {
		this.mostrarid_empresaAutoriPagoOrdenCompra= mostrarid_empresaAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_empresaAutoriPagoOrdenCompra() {
		return this.activarid_empresaAutoriPagoOrdenCompra;
	}

	public void setActivarid_empresaAutoriPagoOrdenCompra(Boolean activarid_empresaAutoriPagoOrdenCompra) {
		this.activarid_empresaAutoriPagoOrdenCompra= activarid_empresaAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_empresaAutoriPagoOrdenCompra() {
		return this.cargarid_empresaAutoriPagoOrdenCompra;
	}

	public void setCargarid_empresaAutoriPagoOrdenCompra(Boolean cargarid_empresaAutoriPagoOrdenCompra) {
		this.cargarid_empresaAutoriPagoOrdenCompra= cargarid_empresaAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_sucursalAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAutoriPagoOrdenCompra() {
		return this.resaltarid_sucursalAutoriPagoOrdenCompra;
	}

	public void setResaltarid_sucursalAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_sucursalAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAutoriPagoOrdenCompra() {
		return this.mostrarid_sucursalAutoriPagoOrdenCompra;
	}

	public void setMostrarid_sucursalAutoriPagoOrdenCompra(Boolean mostrarid_sucursalAutoriPagoOrdenCompra) {
		this.mostrarid_sucursalAutoriPagoOrdenCompra= mostrarid_sucursalAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_sucursalAutoriPagoOrdenCompra() {
		return this.activarid_sucursalAutoriPagoOrdenCompra;
	}

	public void setActivarid_sucursalAutoriPagoOrdenCompra(Boolean activarid_sucursalAutoriPagoOrdenCompra) {
		this.activarid_sucursalAutoriPagoOrdenCompra= activarid_sucursalAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_sucursalAutoriPagoOrdenCompra() {
		return this.cargarid_sucursalAutoriPagoOrdenCompra;
	}

	public void setCargarid_sucursalAutoriPagoOrdenCompra(Boolean cargarid_sucursalAutoriPagoOrdenCompra) {
		this.cargarid_sucursalAutoriPagoOrdenCompra= cargarid_sucursalAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_orden_compraAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_orden_compraAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_compraAutoriPagoOrdenCompra() {
		return this.resaltarid_orden_compraAutoriPagoOrdenCompra;
	}

	public void setResaltarid_orden_compraAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_orden_compraAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_orden_compraAutoriPagoOrdenCompra() {
		return this.mostrarid_orden_compraAutoriPagoOrdenCompra;
	}

	public void setMostrarid_orden_compraAutoriPagoOrdenCompra(Boolean mostrarid_orden_compraAutoriPagoOrdenCompra) {
		this.mostrarid_orden_compraAutoriPagoOrdenCompra= mostrarid_orden_compraAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_orden_compraAutoriPagoOrdenCompra() {
		return this.activarid_orden_compraAutoriPagoOrdenCompra;
	}

	public void setActivarid_orden_compraAutoriPagoOrdenCompra(Boolean activarid_orden_compraAutoriPagoOrdenCompra) {
		this.activarid_orden_compraAutoriPagoOrdenCompra= activarid_orden_compraAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_orden_compraAutoriPagoOrdenCompra() {
		return this.cargarid_orden_compraAutoriPagoOrdenCompra;
	}

	public void setCargarid_orden_compraAutoriPagoOrdenCompra(Boolean cargarid_orden_compraAutoriPagoOrdenCompra) {
		this.cargarid_orden_compraAutoriPagoOrdenCompra= cargarid_orden_compraAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_transaccionAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_transaccionAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionAutoriPagoOrdenCompra() {
		return this.resaltarid_transaccionAutoriPagoOrdenCompra;
	}

	public void setResaltarid_transaccionAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_transaccionAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_transaccionAutoriPagoOrdenCompra() {
		return this.mostrarid_transaccionAutoriPagoOrdenCompra;
	}

	public void setMostrarid_transaccionAutoriPagoOrdenCompra(Boolean mostrarid_transaccionAutoriPagoOrdenCompra) {
		this.mostrarid_transaccionAutoriPagoOrdenCompra= mostrarid_transaccionAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_transaccionAutoriPagoOrdenCompra() {
		return this.activarid_transaccionAutoriPagoOrdenCompra;
	}

	public void setActivarid_transaccionAutoriPagoOrdenCompra(Boolean activarid_transaccionAutoriPagoOrdenCompra) {
		this.activarid_transaccionAutoriPagoOrdenCompra= activarid_transaccionAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_transaccionAutoriPagoOrdenCompra() {
		return this.cargarid_transaccionAutoriPagoOrdenCompra;
	}

	public void setCargarid_transaccionAutoriPagoOrdenCompra(Boolean cargarid_transaccionAutoriPagoOrdenCompra) {
		this.cargarid_transaccionAutoriPagoOrdenCompra= cargarid_transaccionAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_moduloAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloAutoriPagoOrdenCompra() {
		return this.resaltarid_moduloAutoriPagoOrdenCompra;
	}

	public void setResaltarid_moduloAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_moduloAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloAutoriPagoOrdenCompra() {
		return this.mostrarid_moduloAutoriPagoOrdenCompra;
	}

	public void setMostrarid_moduloAutoriPagoOrdenCompra(Boolean mostrarid_moduloAutoriPagoOrdenCompra) {
		this.mostrarid_moduloAutoriPagoOrdenCompra= mostrarid_moduloAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_moduloAutoriPagoOrdenCompra() {
		return this.activarid_moduloAutoriPagoOrdenCompra;
	}

	public void setActivarid_moduloAutoriPagoOrdenCompra(Boolean activarid_moduloAutoriPagoOrdenCompra) {
		this.activarid_moduloAutoriPagoOrdenCompra= activarid_moduloAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_moduloAutoriPagoOrdenCompra() {
		return this.cargarid_moduloAutoriPagoOrdenCompra;
	}

	public void setCargarid_moduloAutoriPagoOrdenCompra(Boolean cargarid_moduloAutoriPagoOrdenCompra) {
		this.cargarid_moduloAutoriPagoOrdenCompra= cargarid_moduloAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_ejercicioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioAutoriPagoOrdenCompra() {
		return this.resaltarid_ejercicioAutoriPagoOrdenCompra;
	}

	public void setResaltarid_ejercicioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_ejercicioAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioAutoriPagoOrdenCompra() {
		return this.mostrarid_ejercicioAutoriPagoOrdenCompra;
	}

	public void setMostrarid_ejercicioAutoriPagoOrdenCompra(Boolean mostrarid_ejercicioAutoriPagoOrdenCompra) {
		this.mostrarid_ejercicioAutoriPagoOrdenCompra= mostrarid_ejercicioAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_ejercicioAutoriPagoOrdenCompra() {
		return this.activarid_ejercicioAutoriPagoOrdenCompra;
	}

	public void setActivarid_ejercicioAutoriPagoOrdenCompra(Boolean activarid_ejercicioAutoriPagoOrdenCompra) {
		this.activarid_ejercicioAutoriPagoOrdenCompra= activarid_ejercicioAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_ejercicioAutoriPagoOrdenCompra() {
		return this.cargarid_ejercicioAutoriPagoOrdenCompra;
	}

	public void setCargarid_ejercicioAutoriPagoOrdenCompra(Boolean cargarid_ejercicioAutoriPagoOrdenCompra) {
		this.cargarid_ejercicioAutoriPagoOrdenCompra= cargarid_ejercicioAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_usuarioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAutoriPagoOrdenCompra() {
		return this.resaltarid_usuarioAutoriPagoOrdenCompra;
	}

	public void setResaltarid_usuarioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_usuarioAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAutoriPagoOrdenCompra() {
		return this.mostrarid_usuarioAutoriPagoOrdenCompra;
	}

	public void setMostrarid_usuarioAutoriPagoOrdenCompra(Boolean mostrarid_usuarioAutoriPagoOrdenCompra) {
		this.mostrarid_usuarioAutoriPagoOrdenCompra= mostrarid_usuarioAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_usuarioAutoriPagoOrdenCompra() {
		return this.activarid_usuarioAutoriPagoOrdenCompra;
	}

	public void setActivarid_usuarioAutoriPagoOrdenCompra(Boolean activarid_usuarioAutoriPagoOrdenCompra) {
		this.activarid_usuarioAutoriPagoOrdenCompra= activarid_usuarioAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_usuarioAutoriPagoOrdenCompra() {
		return this.cargarid_usuarioAutoriPagoOrdenCompra;
	}

	public void setCargarid_usuarioAutoriPagoOrdenCompra(Boolean cargarid_usuarioAutoriPagoOrdenCompra) {
		this.cargarid_usuarioAutoriPagoOrdenCompra= cargarid_usuarioAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_asiento_contableAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableAutoriPagoOrdenCompra() {
		return this.resaltarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public void setResaltarid_asiento_contableAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_asiento_contableAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableAutoriPagoOrdenCompra() {
		return this.mostrarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public void setMostrarid_asiento_contableAutoriPagoOrdenCompra(Boolean mostrarid_asiento_contableAutoriPagoOrdenCompra) {
		this.mostrarid_asiento_contableAutoriPagoOrdenCompra= mostrarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_asiento_contableAutoriPagoOrdenCompra() {
		return this.activarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public void setActivarid_asiento_contableAutoriPagoOrdenCompra(Boolean activarid_asiento_contableAutoriPagoOrdenCompra) {
		this.activarid_asiento_contableAutoriPagoOrdenCompra= activarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_asiento_contableAutoriPagoOrdenCompra() {
		return this.cargarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public void setCargarid_asiento_contableAutoriPagoOrdenCompra(Boolean cargarid_asiento_contableAutoriPagoOrdenCompra) {
		this.cargarid_asiento_contableAutoriPagoOrdenCompra= cargarid_asiento_contableAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_bancoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_bancoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoAutoriPagoOrdenCompra() {
		return this.resaltarid_bancoAutoriPagoOrdenCompra;
	}

	public void setResaltarid_bancoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_bancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_bancoAutoriPagoOrdenCompra() {
		return this.mostrarid_bancoAutoriPagoOrdenCompra;
	}

	public void setMostrarid_bancoAutoriPagoOrdenCompra(Boolean mostrarid_bancoAutoriPagoOrdenCompra) {
		this.mostrarid_bancoAutoriPagoOrdenCompra= mostrarid_bancoAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_bancoAutoriPagoOrdenCompra() {
		return this.activarid_bancoAutoriPagoOrdenCompra;
	}

	public void setActivarid_bancoAutoriPagoOrdenCompra(Boolean activarid_bancoAutoriPagoOrdenCompra) {
		this.activarid_bancoAutoriPagoOrdenCompra= activarid_bancoAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_bancoAutoriPagoOrdenCompra() {
		return this.cargarid_bancoAutoriPagoOrdenCompra;
	}

	public void setCargarid_bancoAutoriPagoOrdenCompra(Boolean cargarid_bancoAutoriPagoOrdenCompra) {
		this.cargarid_bancoAutoriPagoOrdenCompra= cargarid_bancoAutoriPagoOrdenCompra;
	}

	public Border setResaltarid_cuenta_bancoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_bancoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_bancoAutoriPagoOrdenCompra() {
		return this.resaltarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public void setResaltarid_cuenta_bancoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarid_cuenta_bancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_bancoAutoriPagoOrdenCompra() {
		return this.mostrarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public void setMostrarid_cuenta_bancoAutoriPagoOrdenCompra(Boolean mostrarid_cuenta_bancoAutoriPagoOrdenCompra) {
		this.mostrarid_cuenta_bancoAutoriPagoOrdenCompra= mostrarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public Boolean getActivarid_cuenta_bancoAutoriPagoOrdenCompra() {
		return this.activarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public void setActivarid_cuenta_bancoAutoriPagoOrdenCompra(Boolean activarid_cuenta_bancoAutoriPagoOrdenCompra) {
		this.activarid_cuenta_bancoAutoriPagoOrdenCompra= activarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public Boolean getCargarid_cuenta_bancoAutoriPagoOrdenCompra() {
		return this.cargarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public void setCargarid_cuenta_bancoAutoriPagoOrdenCompra(Boolean cargarid_cuenta_bancoAutoriPagoOrdenCompra) {
		this.cargarid_cuenta_bancoAutoriPagoOrdenCompra= cargarid_cuenta_bancoAutoriPagoOrdenCompra;
	}

	public Border setResaltarnumero_comprobanteAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteAutoriPagoOrdenCompra() {
		return this.resaltarnumero_comprobanteAutoriPagoOrdenCompra;
	}

	public void setResaltarnumero_comprobanteAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarnumero_comprobanteAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteAutoriPagoOrdenCompra() {
		return this.mostrarnumero_comprobanteAutoriPagoOrdenCompra;
	}

	public void setMostrarnumero_comprobanteAutoriPagoOrdenCompra(Boolean mostrarnumero_comprobanteAutoriPagoOrdenCompra) {
		this.mostrarnumero_comprobanteAutoriPagoOrdenCompra= mostrarnumero_comprobanteAutoriPagoOrdenCompra;
	}

	public Boolean getActivarnumero_comprobanteAutoriPagoOrdenCompra() {
		return this.activarnumero_comprobanteAutoriPagoOrdenCompra;
	}

	public void setActivarnumero_comprobanteAutoriPagoOrdenCompra(Boolean activarnumero_comprobanteAutoriPagoOrdenCompra) {
		this.activarnumero_comprobanteAutoriPagoOrdenCompra= activarnumero_comprobanteAutoriPagoOrdenCompra;
	}

	public Border setResaltarfechaAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfechaAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAutoriPagoOrdenCompra() {
		return this.resaltarfechaAutoriPagoOrdenCompra;
	}

	public void setResaltarfechaAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarfechaAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfechaAutoriPagoOrdenCompra() {
		return this.mostrarfechaAutoriPagoOrdenCompra;
	}

	public void setMostrarfechaAutoriPagoOrdenCompra(Boolean mostrarfechaAutoriPagoOrdenCompra) {
		this.mostrarfechaAutoriPagoOrdenCompra= mostrarfechaAutoriPagoOrdenCompra;
	}

	public Boolean getActivarfechaAutoriPagoOrdenCompra() {
		return this.activarfechaAutoriPagoOrdenCompra;
	}

	public void setActivarfechaAutoriPagoOrdenCompra(Boolean activarfechaAutoriPagoOrdenCompra) {
		this.activarfechaAutoriPagoOrdenCompra= activarfechaAutoriPagoOrdenCompra;
	}

	public Border setResaltarfecha_autoriAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_autoriAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autoriAutoriPagoOrdenCompra() {
		return this.resaltarfecha_autoriAutoriPagoOrdenCompra;
	}

	public void setResaltarfecha_autoriAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarfecha_autoriAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_autoriAutoriPagoOrdenCompra() {
		return this.mostrarfecha_autoriAutoriPagoOrdenCompra;
	}

	public void setMostrarfecha_autoriAutoriPagoOrdenCompra(Boolean mostrarfecha_autoriAutoriPagoOrdenCompra) {
		this.mostrarfecha_autoriAutoriPagoOrdenCompra= mostrarfecha_autoriAutoriPagoOrdenCompra;
	}

	public Boolean getActivarfecha_autoriAutoriPagoOrdenCompra() {
		return this.activarfecha_autoriAutoriPagoOrdenCompra;
	}

	public void setActivarfecha_autoriAutoriPagoOrdenCompra(Boolean activarfecha_autoriAutoriPagoOrdenCompra) {
		this.activarfecha_autoriAutoriPagoOrdenCompra= activarfecha_autoriAutoriPagoOrdenCompra;
	}

	public Border setResaltartotalAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltartotalAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalAutoriPagoOrdenCompra() {
		return this.resaltartotalAutoriPagoOrdenCompra;
	}

	public void setResaltartotalAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltartotalAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrartotalAutoriPagoOrdenCompra() {
		return this.mostrartotalAutoriPagoOrdenCompra;
	}

	public void setMostrartotalAutoriPagoOrdenCompra(Boolean mostrartotalAutoriPagoOrdenCompra) {
		this.mostrartotalAutoriPagoOrdenCompra= mostrartotalAutoriPagoOrdenCompra;
	}

	public Boolean getActivartotalAutoriPagoOrdenCompra() {
		return this.activartotalAutoriPagoOrdenCompra;
	}

	public void setActivartotalAutoriPagoOrdenCompra(Boolean activartotalAutoriPagoOrdenCompra) {
		this.activartotalAutoriPagoOrdenCompra= activartotalAutoriPagoOrdenCompra;
	}

	public Border setResaltarfecha_servidorAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_servidorAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_servidorAutoriPagoOrdenCompra() {
		return this.resaltarfecha_servidorAutoriPagoOrdenCompra;
	}

	public void setResaltarfecha_servidorAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarfecha_servidorAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_servidorAutoriPagoOrdenCompra() {
		return this.mostrarfecha_servidorAutoriPagoOrdenCompra;
	}

	public void setMostrarfecha_servidorAutoriPagoOrdenCompra(Boolean mostrarfecha_servidorAutoriPagoOrdenCompra) {
		this.mostrarfecha_servidorAutoriPagoOrdenCompra= mostrarfecha_servidorAutoriPagoOrdenCompra;
	}

	public Boolean getActivarfecha_servidorAutoriPagoOrdenCompra() {
		return this.activarfecha_servidorAutoriPagoOrdenCompra;
	}

	public void setActivarfecha_servidorAutoriPagoOrdenCompra(Boolean activarfecha_servidorAutoriPagoOrdenCompra) {
		this.activarfecha_servidorAutoriPagoOrdenCompra= activarfecha_servidorAutoriPagoOrdenCompra;
	}

	public Border setResaltarcodigo_asientoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarcodigo_asientoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asientoAutoriPagoOrdenCompra() {
		return this.resaltarcodigo_asientoAutoriPagoOrdenCompra;
	}

	public void setResaltarcodigo_asientoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarcodigo_asientoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcodigo_asientoAutoriPagoOrdenCompra() {
		return this.mostrarcodigo_asientoAutoriPagoOrdenCompra;
	}

	public void setMostrarcodigo_asientoAutoriPagoOrdenCompra(Boolean mostrarcodigo_asientoAutoriPagoOrdenCompra) {
		this.mostrarcodigo_asientoAutoriPagoOrdenCompra= mostrarcodigo_asientoAutoriPagoOrdenCompra;
	}

	public Boolean getActivarcodigo_asientoAutoriPagoOrdenCompra() {
		return this.activarcodigo_asientoAutoriPagoOrdenCompra;
	}

	public void setActivarcodigo_asientoAutoriPagoOrdenCompra(Boolean activarcodigo_asientoAutoriPagoOrdenCompra) {
		this.activarcodigo_asientoAutoriPagoOrdenCompra= activarcodigo_asientoAutoriPagoOrdenCompra;
	}

	public Border setResaltarfecha_asientoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_asientoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_asientoAutoriPagoOrdenCompra() {
		return this.resaltarfecha_asientoAutoriPagoOrdenCompra;
	}

	public void setResaltarfecha_asientoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarfecha_asientoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_asientoAutoriPagoOrdenCompra() {
		return this.mostrarfecha_asientoAutoriPagoOrdenCompra;
	}

	public void setMostrarfecha_asientoAutoriPagoOrdenCompra(Boolean mostrarfecha_asientoAutoriPagoOrdenCompra) {
		this.mostrarfecha_asientoAutoriPagoOrdenCompra= mostrarfecha_asientoAutoriPagoOrdenCompra;
	}

	public Boolean getActivarfecha_asientoAutoriPagoOrdenCompra() {
		return this.activarfecha_asientoAutoriPagoOrdenCompra;
	}

	public void setActivarfecha_asientoAutoriPagoOrdenCompra(Boolean activarfecha_asientoAutoriPagoOrdenCompra) {
		this.activarfecha_asientoAutoriPagoOrdenCompra= activarfecha_asientoAutoriPagoOrdenCompra;
	}

	public Border setResaltarvalor_asientoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarvalor_asientoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_asientoAutoriPagoOrdenCompra() {
		return this.resaltarvalor_asientoAutoriPagoOrdenCompra;
	}

	public void setResaltarvalor_asientoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarvalor_asientoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarvalor_asientoAutoriPagoOrdenCompra() {
		return this.mostrarvalor_asientoAutoriPagoOrdenCompra;
	}

	public void setMostrarvalor_asientoAutoriPagoOrdenCompra(Boolean mostrarvalor_asientoAutoriPagoOrdenCompra) {
		this.mostrarvalor_asientoAutoriPagoOrdenCompra= mostrarvalor_asientoAutoriPagoOrdenCompra;
	}

	public Boolean getActivarvalor_asientoAutoriPagoOrdenCompra() {
		return this.activarvalor_asientoAutoriPagoOrdenCompra;
	}

	public void setActivarvalor_asientoAutoriPagoOrdenCompra(Boolean activarvalor_asientoAutoriPagoOrdenCompra) {
		this.activarvalor_asientoAutoriPagoOrdenCompra= activarvalor_asientoAutoriPagoOrdenCompra;
	}

	public Border setResaltartotal_saldoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoordencompraBeanSwingJInternalFrame.jTtoolBarAutoriPagoOrdenCompra.setBorder(borderResaltar);
		
		this.resaltartotal_saldoAutoriPagoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_saldoAutoriPagoOrdenCompra() {
		return this.resaltartotal_saldoAutoriPagoOrdenCompra;
	}

	public void setResaltartotal_saldoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltartotal_saldoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrartotal_saldoAutoriPagoOrdenCompra() {
		return this.mostrartotal_saldoAutoriPagoOrdenCompra;
	}

	public void setMostrartotal_saldoAutoriPagoOrdenCompra(Boolean mostrartotal_saldoAutoriPagoOrdenCompra) {
		this.mostrartotal_saldoAutoriPagoOrdenCompra= mostrartotal_saldoAutoriPagoOrdenCompra;
	}

	public Boolean getActivartotal_saldoAutoriPagoOrdenCompra() {
		return this.activartotal_saldoAutoriPagoOrdenCompra;
	}

	public void setActivartotal_saldoAutoriPagoOrdenCompra(Boolean activartotal_saldoAutoriPagoOrdenCompra) {
		this.activartotal_saldoAutoriPagoOrdenCompra= activartotal_saldoAutoriPagoOrdenCompra;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_tipo_cambioAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_monedaAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_clienteAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_empresaAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_sucursalAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_orden_compraAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_transaccionAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_moduloAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_ejercicioAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_usuarioAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_asiento_contableAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_bancoAutoriPagoOrdenCompra(esInicial);
		this.setMostrarid_cuenta_bancoAutoriPagoOrdenCompra(esInicial);
		this.setMostrarnumero_comprobanteAutoriPagoOrdenCompra(esInicial);
		this.setMostrarfechaAutoriPagoOrdenCompra(esInicial);
		this.setMostrarfecha_autoriAutoriPagoOrdenCompra(esInicial);
		this.setMostrartotalAutoriPagoOrdenCompra(esInicial);
		this.setMostrarfecha_servidorAutoriPagoOrdenCompra(esInicial);
		this.setMostrarcodigo_asientoAutoriPagoOrdenCompra(esInicial);
		this.setMostrarfecha_asientoAutoriPagoOrdenCompra(esInicial);
		this.setMostrarvalor_asientoAutoriPagoOrdenCompra(esInicial);
		this.setMostrartotal_saldoAutoriPagoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.ID)) {
				this.setMostraridAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setMostrarid_orden_compraAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO)) {
				this.setMostrarid_cuenta_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI)) {
				this.setMostrarfecha_autoriAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTAL)) {
				this.setMostrartotalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR)) {
				this.setMostrarfecha_servidorAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO)) {
				this.setMostrarcodigo_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO)) {
				this.setMostrarfecha_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO)) {
				this.setMostrarvalor_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO)) {
				this.setMostrartotal_saldoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_tipo_cambioAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_monedaAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_clienteAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_empresaAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_sucursalAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_orden_compraAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_transaccionAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_moduloAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_ejercicioAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_usuarioAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_asiento_contableAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_bancoAutoriPagoOrdenCompra(esInicial);
		this.setActivarid_cuenta_bancoAutoriPagoOrdenCompra(esInicial);
		this.setActivarnumero_comprobanteAutoriPagoOrdenCompra(esInicial);
		this.setActivarfechaAutoriPagoOrdenCompra(esInicial);
		this.setActivarfecha_autoriAutoriPagoOrdenCompra(esInicial);
		this.setActivartotalAutoriPagoOrdenCompra(esInicial);
		this.setActivarfecha_servidorAutoriPagoOrdenCompra(esInicial);
		this.setActivarcodigo_asientoAutoriPagoOrdenCompra(esInicial);
		this.setActivarfecha_asientoAutoriPagoOrdenCompra(esInicial);
		this.setActivarvalor_asientoAutoriPagoOrdenCompra(esInicial);
		this.setActivartotal_saldoAutoriPagoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.ID)) {
				this.setActivaridAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setActivarid_orden_compraAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO)) {
				this.setActivarid_cuenta_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHA)) {
				this.setActivarfechaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI)) {
				this.setActivarfecha_autoriAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTAL)) {
				this.setActivartotalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR)) {
				this.setActivarfecha_servidorAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO)) {
				this.setActivarcodigo_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO)) {
				this.setActivarfecha_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO)) {
				this.setActivarvalor_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO)) {
				this.setActivartotal_saldoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_tipo_cambioAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_monedaAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_clienteAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_empresaAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_sucursalAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_orden_compraAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_transaccionAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_moduloAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_ejercicioAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_usuarioAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_asiento_contableAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_bancoAutoriPagoOrdenCompra(esInicial);
		this.setResaltarid_cuenta_bancoAutoriPagoOrdenCompra(esInicial);
		this.setResaltarnumero_comprobanteAutoriPagoOrdenCompra(esInicial);
		this.setResaltarfechaAutoriPagoOrdenCompra(esInicial);
		this.setResaltarfecha_autoriAutoriPagoOrdenCompra(esInicial);
		this.setResaltartotalAutoriPagoOrdenCompra(esInicial);
		this.setResaltarfecha_servidorAutoriPagoOrdenCompra(esInicial);
		this.setResaltarcodigo_asientoAutoriPagoOrdenCompra(esInicial);
		this.setResaltarfecha_asientoAutoriPagoOrdenCompra(esInicial);
		this.setResaltarvalor_asientoAutoriPagoOrdenCompra(esInicial);
		this.setResaltartotal_saldoAutoriPagoOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.ID)) {
				this.setResaltaridAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setResaltarid_orden_compraAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO)) {
				this.setResaltarid_cuenta_bancoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI)) {
				this.setResaltarfecha_autoriAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTAL)) {
				this.setResaltartotalAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR)) {
				this.setResaltarfecha_servidorAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO)) {
				this.setResaltarcodigo_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO)) {
				this.setResaltarfecha_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO)) {
				this.setResaltarvalor_asientoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO)) {
				this.setResaltartotal_saldoAutoriPagoOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdAsientoContableAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdAsientoContableAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdAsientoContableAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdBancoAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdBancoAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdBancoAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdClienteAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdClienteAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdClienteAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaBancoAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdCuentaBancoAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdCuentaBancoAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdCuentaBancoAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaBancoAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdEjercicioAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdEjercicioAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdEjercicioAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdEmpresaAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdEmpresaAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdEmpresaAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdModuloAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdModuloAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdModuloAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdMonedaAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdMonedaAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdMonedaAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenCompraAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdOrdenCompraAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdOrdenCompraAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdOrdenCompraAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenCompraAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdSucursalAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdSucursalAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdSucursalAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdTipoCambioAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdTipoCambioAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdTipoCambioAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdTransaccionAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdTransaccionAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdTransaccionAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionAutoriPagoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioAutoriPagoOrdenCompra=true;

	public Boolean getMostrarFK_IdUsuarioAutoriPagoOrdenCompra() {
		return this.mostrarFK_IdUsuarioAutoriPagoOrdenCompra;
	}

	public void setMostrarFK_IdUsuarioAutoriPagoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioAutoriPagoOrdenCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdAsientoContableAutoriPagoOrdenCompra() {
		return this.activarFK_IdAsientoContableAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdAsientoContableAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdBancoAutoriPagoOrdenCompra() {
		return this.activarFK_IdBancoAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdBancoAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBancoAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdClienteAutoriPagoOrdenCompra() {
		return this.activarFK_IdClienteAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdClienteAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaBancoAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdCuentaBancoAutoriPagoOrdenCompra() {
		return this.activarFK_IdCuentaBancoAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdCuentaBancoAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaBancoAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdEjercicioAutoriPagoOrdenCompra() {
		return this.activarFK_IdEjercicioAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdEjercicioAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdEmpresaAutoriPagoOrdenCompra() {
		return this.activarFK_IdEmpresaAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdEmpresaAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdModuloAutoriPagoOrdenCompra() {
		return this.activarFK_IdModuloAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdModuloAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdMonedaAutoriPagoOrdenCompra() {
		return this.activarFK_IdMonedaAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdMonedaAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenCompraAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdOrdenCompraAutoriPagoOrdenCompra() {
		return this.activarFK_IdOrdenCompraAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdOrdenCompraAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenCompraAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdSucursalAutoriPagoOrdenCompra() {
		return this.activarFK_IdSucursalAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdSucursalAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdTipoCambioAutoriPagoOrdenCompra() {
		return this.activarFK_IdTipoCambioAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdTipoCambioAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdTransaccionAutoriPagoOrdenCompra() {
		return this.activarFK_IdTransaccionAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdTransaccionAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionAutoriPagoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioAutoriPagoOrdenCompra=true;

	public Boolean getActivarFK_IdUsuarioAutoriPagoOrdenCompra() {
		return this.activarFK_IdUsuarioAutoriPagoOrdenCompra;
	}

	public void setActivarFK_IdUsuarioAutoriPagoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioAutoriPagoOrdenCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdAsientoContableAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdAsientoContableAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdAsientoContableAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdBancoAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdBancoAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdBancoAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdBancoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdBancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdBancoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdClienteAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdClienteAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdClienteAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdClienteAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdClienteAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdClienteAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdCuentaBancoAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdCuentaBancoAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdCuentaBancoAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdCuentaBancoAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdCuentaBancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdCuentaBancoAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaBancoAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdEjercicioAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdEjercicioAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdEjercicioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdEmpresaAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdEmpresaAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdEmpresaAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdModuloAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdModuloAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdModuloAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdMonedaAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdMonedaAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdMonedaAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdMonedaAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdMonedaAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdMonedaAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdOrdenCompraAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdOrdenCompraAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdOrdenCompraAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdOrdenCompraAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdOrdenCompraAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdOrdenCompraAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenCompraAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdSucursalAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdSucursalAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdSucursalAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdTipoCambioAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdTipoCambioAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdTipoCambioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdTransaccionAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdTransaccionAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdTransaccionAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdTransaccionAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionAutoriPagoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioAutoriPagoOrdenCompra=null;

	public Border getResaltarFK_IdUsuarioAutoriPagoOrdenCompra() {
		return this.resaltarFK_IdUsuarioAutoriPagoOrdenCompra;
	}

	public void setResaltarFK_IdUsuarioAutoriPagoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioAutoriPagoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioAutoriPagoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoOrdenCompraBeanSwingJInternalFrame autoripagoordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioAutoriPagoOrdenCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}