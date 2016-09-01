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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.NotasCreditosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.NotasCreditosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.NotasCreditosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NotasCreditosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="NotasCreditos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NotasCreditos"+NotasCreditosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NotasCreditosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NotasCreditosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NotasCreditosConstantesFunciones.SCHEMA+"_"+NotasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NotasCreditosConstantesFunciones.SCHEMA+"_"+NotasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NotasCreditosConstantesFunciones.SCHEMA+"_"+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NotasCreditosConstantesFunciones.SCHEMA+"_"+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NotasCreditosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NotasCreditosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NotasCreditosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NotasCreditosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Notas Creditoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Notas Creditos";
	public static final String SCLASSWEBTITULO_LOWER="Notas Creditos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NotasCreditos";
	public static final String OBJECTNAME="notascreditos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="notas_creditos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select notascreditos from "+NotasCreditosConstantesFunciones.SPERSISTENCENAME+" notascreditos";
	public static String QUERYSELECTNATIVE="select "+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".id,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".version_row,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".id_empresa,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".numero_pre_impreso,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".fecha_emision,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".fecha_vencimiento,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".iva,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".descuento_valor,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".otro_valor,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".sub_total,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".total,"+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME+".nombre_estado_nota_credito from "+NotasCreditosConstantesFunciones.SCHEMA+"."+NotasCreditosConstantesFunciones.TABLENAME;//+" as "+NotasCreditosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IVA= "iva";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String OTROVALOR= "otro_valor";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String NOMBREESTADONOTACREDITO= "nombre_estado_nota_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_OTROVALOR= "Otro Valor";
		public static final String LABEL_OTROVALOR_LOWER= "Otro Valor";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_NOMBREESTADONOTACREDITO= "Nombre Estado Nota Credito";
		public static final String LABEL_NOMBREESTADONOTACREDITO_LOWER= "Nombre Estado Nota Credito";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_ESTADO_NOTA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ESTADO_NOTA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNotasCreditosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.IDEMPRESA)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.FECHAEMISION)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.IVA)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.OTROVALOR)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_OTROVALOR;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.SUBTOTAL)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.TOTAL)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO)) {sLabelColumna=NotasCreditosConstantesFunciones.LABEL_NOMBREESTADONOTACREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNotasCreditosDescripcion(NotasCreditos notascreditos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(notascreditos !=null/* && notascreditos.getId()!=0*/) {
			sDescripcion=notascreditos.getfecha_emision_hasta().toString();//notascreditosnotascreditos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNotasCreditosDescripcionDetallado(NotasCreditos notascreditos) {
		String sDescripcion="";
			
		sDescripcion+=NotasCreditosConstantesFunciones.ID+"=";
		sDescripcion+=notascreditos.getId().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=notascreditos.getVersionRow().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=notascreditos.getid_empresa().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=notascreditos.getfecha_emision_desde().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=notascreditos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=notascreditos.getnombre_completo_cliente()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=notascreditos.getnumero_pre_impreso_factura()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=notascreditos.getnumero_pre_impreso()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=notascreditos.getfecha_emision().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=notascreditos.getfecha_vencimiento().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.IVA+"=";
		sDescripcion+=notascreditos.getiva().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=notascreditos.getdescuento_valor().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.OTROVALOR+"=";
		sDescripcion+=notascreditos.getotro_valor().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=notascreditos.getsub_total().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.TOTAL+"=";
		sDescripcion+=notascreditos.gettotal().toString()+",";
		sDescripcion+=NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO+"=";
		sDescripcion+=notascreditos.getnombre_estado_nota_credito()+",";
			
		return sDescripcion;
	}
	
	public static void setNotasCreditosDescripcion(NotasCreditos notascreditos,String sValor) throws Exception {			
		if(notascreditos !=null) {
			//notascreditosnotascreditos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaNotasCreditos")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaNotasCreditos(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNotasCreditos(NotasCreditos notascreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		notascreditos.setnombre_completo_cliente(notascreditos.getnombre_completo_cliente().trim());
		notascreditos.setnumero_pre_impreso_factura(notascreditos.getnumero_pre_impreso_factura().trim());
		notascreditos.setnumero_pre_impreso(notascreditos.getnumero_pre_impreso().trim());
		notascreditos.setnombre_estado_nota_credito(notascreditos.getnombre_estado_nota_credito().trim());
	}
	
	public static void quitarEspaciosNotasCreditoss(List<NotasCreditos> notascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NotasCreditos notascreditos: notascreditoss) {
			notascreditos.setnombre_completo_cliente(notascreditos.getnombre_completo_cliente().trim());
			notascreditos.setnumero_pre_impreso_factura(notascreditos.getnumero_pre_impreso_factura().trim());
			notascreditos.setnumero_pre_impreso(notascreditos.getnumero_pre_impreso().trim());
			notascreditos.setnombre_estado_nota_credito(notascreditos.getnombre_estado_nota_credito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotasCreditos(NotasCreditos notascreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && notascreditos.getConCambioAuxiliar()) {
			notascreditos.setIsDeleted(notascreditos.getIsDeletedAuxiliar());	
			notascreditos.setIsNew(notascreditos.getIsNewAuxiliar());	
			notascreditos.setIsChanged(notascreditos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			notascreditos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			notascreditos.setIsDeletedAuxiliar(false);	
			notascreditos.setIsNewAuxiliar(false);	
			notascreditos.setIsChangedAuxiliar(false);
			
			notascreditos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotasCreditoss(List<NotasCreditos> notascreditoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NotasCreditos notascreditos : notascreditoss) {
			if(conAsignarBase && notascreditos.getConCambioAuxiliar()) {
				notascreditos.setIsDeleted(notascreditos.getIsDeletedAuxiliar());	
				notascreditos.setIsNew(notascreditos.getIsNewAuxiliar());	
				notascreditos.setIsChanged(notascreditos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				notascreditos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				notascreditos.setIsDeletedAuxiliar(false);	
				notascreditos.setIsNewAuxiliar(false);	
				notascreditos.setIsChangedAuxiliar(false);
				
				notascreditos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNotasCreditos(NotasCreditos notascreditos,Boolean conEnteros) throws Exception  {
		notascreditos.setiva(0.0);
		notascreditos.setdescuento_valor(0.0);
		notascreditos.setotro_valor(0.0);
		notascreditos.setsub_total(0.0);
		notascreditos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNotasCreditoss(List<NotasCreditos> notascreditoss,Boolean conEnteros) throws Exception  {
		
		for(NotasCreditos notascreditos: notascreditoss) {
			notascreditos.setiva(0.0);
			notascreditos.setdescuento_valor(0.0);
			notascreditos.setotro_valor(0.0);
			notascreditos.setsub_total(0.0);
			notascreditos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNotasCreditos(List<NotasCreditos> notascreditoss,NotasCreditos notascreditosAux) throws Exception  {
		NotasCreditosConstantesFunciones.InicializarValoresNotasCreditos(notascreditosAux,true);
		
		for(NotasCreditos notascreditos: notascreditoss) {
			if(notascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			notascreditosAux.setiva(notascreditosAux.getiva()+notascreditos.getiva());			
			notascreditosAux.setdescuento_valor(notascreditosAux.getdescuento_valor()+notascreditos.getdescuento_valor());			
			notascreditosAux.setotro_valor(notascreditosAux.getotro_valor()+notascreditos.getotro_valor());			
			notascreditosAux.setsub_total(notascreditosAux.getsub_total()+notascreditos.getsub_total());			
			notascreditosAux.settotal(notascreditosAux.gettotal()+notascreditos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NotasCreditosConstantesFunciones.getArrayColumnasGlobalesNotasCreditos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotasCreditosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotasCreditosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NotasCreditos> notascreditoss,NotasCreditos notascreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NotasCreditos notascreditosAux: notascreditoss) {
			if(notascreditosAux!=null && notascreditos!=null) {
				if((notascreditosAux.getId()==null && notascreditos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(notascreditosAux.getId()!=null && notascreditos.getId()!=null){
					if(notascreditosAux.getId().equals(notascreditos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNotasCreditos(List<NotasCreditos> notascreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double otro_valorTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(NotasCreditos notascreditos: notascreditoss) {			
			if(notascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=notascreditos.getiva();
			descuento_valorTotal+=notascreditos.getdescuento_valor();
			otro_valorTotal+=notascreditos.getotro_valor();
			sub_totalTotal+=notascreditos.getsub_total();
			totalTotal+=notascreditos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.OTROVALOR);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_OTROVALOR);
		datoGeneral.setdValorDouble(otro_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNotasCreditos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_ID, NotasCreditosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_VERSIONROW, NotasCreditosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESO, NotasCreditosConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_FECHAEMISION, NotasCreditosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_FECHAVENCIMIENTO, NotasCreditosConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_IVA, NotasCreditosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR, NotasCreditosConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_OTROVALOR, NotasCreditosConstantesFunciones.OTROVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_SUBTOTAL, NotasCreditosConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_TOTAL, NotasCreditosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotasCreditosConstantesFunciones.LABEL_NOMBREESTADONOTACREDITO, NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNotasCreditos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.OTROVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotasCreditos() throws Exception  {
		return NotasCreditosConstantesFunciones.getTiposSeleccionarNotasCreditos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotasCreditos(Boolean conFk) throws Exception  {
		return NotasCreditosConstantesFunciones.getTiposSeleccionarNotasCreditos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotasCreditos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_OTROVALOR);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_OTROVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotasCreditosConstantesFunciones.LABEL_NOMBREESTADONOTACREDITO);
			reporte.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_NOMBREESTADONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNotasCreditos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNotasCreditos(NotasCreditos notascreditosAux) throws Exception {
		
			notascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notascreditosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNotasCreditos(List<NotasCreditos> notascreditossTemp) throws Exception {
		for(NotasCreditos notascreditosAux:notascreditossTemp) {
			
			notascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notascreditosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotasCreditosConstantesFunciones.getClassesRelationshipsOfNotasCreditos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotasCreditosConstantesFunciones.getClassesRelationshipsFromStringsOfNotasCreditos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NotasCreditos notascreditos,List<NotasCreditos> notascreditoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(NotasCreditos notascreditos,List<NotasCreditos> notascreditoss) throws Exception {
		try	{			
			for(NotasCreditos notascreditosLocal:notascreditoss) {
				if(notascreditosLocal.getId().equals(notascreditos.getId())) {
					notascreditosLocal.setIsSelected(notascreditos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNotasCreditos(List<NotasCreditos> notascreditossAux) throws Exception {
		//this.notascreditossAux=notascreditossAux;
		
		for(NotasCreditos notascreditosAux:notascreditossAux) {
			if(notascreditosAux.getIsChanged()) {
				notascreditosAux.setIsChanged(false);
			}		
			
			if(notascreditosAux.getIsNew()) {
				notascreditosAux.setIsNew(false);
			}	
			
			if(notascreditosAux.getIsDeleted()) {
				notascreditosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNotasCreditos(NotasCreditos notascreditosAux) throws Exception {
		//this.notascreditosAux=notascreditosAux;
		
			if(notascreditosAux.getIsChanged()) {
				notascreditosAux.setIsChanged(false);
			}		
			
			if(notascreditosAux.getIsNew()) {
				notascreditosAux.setIsNew(false);
			}	
			
			if(notascreditosAux.getIsDeleted()) {
				notascreditosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NotasCreditos notascreditosAsignar,NotasCreditos notascreditos) throws Exception {
		notascreditosAsignar.setId(notascreditos.getId());	
		notascreditosAsignar.setVersionRow(notascreditos.getVersionRow());	
		notascreditosAsignar.setnombre_completo_cliente(notascreditos.getnombre_completo_cliente());	
		notascreditosAsignar.setnumero_pre_impreso_factura(notascreditos.getnumero_pre_impreso_factura());	
		notascreditosAsignar.setnumero_pre_impreso(notascreditos.getnumero_pre_impreso());	
		notascreditosAsignar.setfecha_emision(notascreditos.getfecha_emision());	
		notascreditosAsignar.setfecha_vencimiento(notascreditos.getfecha_vencimiento());	
		notascreditosAsignar.setiva(notascreditos.getiva());	
		notascreditosAsignar.setdescuento_valor(notascreditos.getdescuento_valor());	
		notascreditosAsignar.setotro_valor(notascreditos.getotro_valor());	
		notascreditosAsignar.setsub_total(notascreditos.getsub_total());	
		notascreditosAsignar.settotal(notascreditos.gettotal());	
		notascreditosAsignar.setnombre_estado_nota_credito(notascreditos.getnombre_estado_nota_credito());	
	}
	
	public static void inicializarNotasCreditos(NotasCreditos notascreditos) throws Exception {
		try {
				notascreditos.setId(0L);	
					
				notascreditos.setnombre_completo_cliente("");	
				notascreditos.setnumero_pre_impreso_factura("");	
				notascreditos.setnumero_pre_impreso("");	
				notascreditos.setfecha_emision(new Date());	
				notascreditos.setfecha_vencimiento(new Date());	
				notascreditos.setiva(0.0);	
				notascreditos.setdescuento_valor(0.0);	
				notascreditos.setotro_valor(0.0);	
				notascreditos.setsub_total(0.0);	
				notascreditos.settotal(0.0);	
				notascreditos.setnombre_estado_nota_credito("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNotasCreditos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_OTROVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotasCreditosConstantesFunciones.LABEL_NOMBREESTADONOTACREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNotasCreditos(String sTipo,Row row,Workbook workbook,NotasCreditos notascreditos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getotro_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notascreditos.getnombre_estado_nota_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNotasCreditos="";
	
	public String getsFinalQueryNotasCreditos() {
		return this.sFinalQueryNotasCreditos;
	}
	
	public void setsFinalQueryNotasCreditos(String sFinalQueryNotasCreditos) {
		this.sFinalQueryNotasCreditos= sFinalQueryNotasCreditos;
	}
	
	public Border resaltarSeleccionarNotasCreditos=null;
	
	public Border setResaltarSeleccionarNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNotasCreditos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNotasCreditos() {
		return this.resaltarSeleccionarNotasCreditos;
	}
	
	public void setResaltarSeleccionarNotasCreditos(Border borderResaltarSeleccionarNotasCreditos) {
		this.resaltarSeleccionarNotasCreditos= borderResaltarSeleccionarNotasCreditos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNotasCreditos=null;
	public Boolean mostraridNotasCreditos=true;
	public Boolean activaridNotasCreditos=true;

	public Border resaltarid_empresaNotasCreditos=null;
	public Boolean mostrarid_empresaNotasCreditos=true;
	public Boolean activarid_empresaNotasCreditos=true;
	public Boolean cargarid_empresaNotasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNotasCreditos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeNotasCreditos=null;
	public Boolean mostrarfecha_emision_desdeNotasCreditos=true;
	public Boolean activarfecha_emision_desdeNotasCreditos=true;

	public Border resaltarfecha_emision_hastaNotasCreditos=null;
	public Boolean mostrarfecha_emision_hastaNotasCreditos=true;
	public Boolean activarfecha_emision_hastaNotasCreditos=true;

	public Border resaltarnombre_completo_clienteNotasCreditos=null;
	public Boolean mostrarnombre_completo_clienteNotasCreditos=true;
	public Boolean activarnombre_completo_clienteNotasCreditos=true;

	public Border resaltarnumero_pre_impreso_facturaNotasCreditos=null;
	public Boolean mostrarnumero_pre_impreso_facturaNotasCreditos=true;
	public Boolean activarnumero_pre_impreso_facturaNotasCreditos=true;

	public Border resaltarnumero_pre_impresoNotasCreditos=null;
	public Boolean mostrarnumero_pre_impresoNotasCreditos=true;
	public Boolean activarnumero_pre_impresoNotasCreditos=true;

	public Border resaltarfecha_emisionNotasCreditos=null;
	public Boolean mostrarfecha_emisionNotasCreditos=true;
	public Boolean activarfecha_emisionNotasCreditos=true;

	public Border resaltarfecha_vencimientoNotasCreditos=null;
	public Boolean mostrarfecha_vencimientoNotasCreditos=true;
	public Boolean activarfecha_vencimientoNotasCreditos=true;

	public Border resaltarivaNotasCreditos=null;
	public Boolean mostrarivaNotasCreditos=true;
	public Boolean activarivaNotasCreditos=true;

	public Border resaltardescuento_valorNotasCreditos=null;
	public Boolean mostrardescuento_valorNotasCreditos=true;
	public Boolean activardescuento_valorNotasCreditos=true;

	public Border resaltarotro_valorNotasCreditos=null;
	public Boolean mostrarotro_valorNotasCreditos=true;
	public Boolean activarotro_valorNotasCreditos=true;

	public Border resaltarsub_totalNotasCreditos=null;
	public Boolean mostrarsub_totalNotasCreditos=true;
	public Boolean activarsub_totalNotasCreditos=true;

	public Border resaltartotalNotasCreditos=null;
	public Boolean mostrartotalNotasCreditos=true;
	public Boolean activartotalNotasCreditos=true;

	public Border resaltarnombre_estado_nota_creditoNotasCreditos=null;
	public Boolean mostrarnombre_estado_nota_creditoNotasCreditos=true;
	public Boolean activarnombre_estado_nota_creditoNotasCreditos=true;

	
	

	public Border setResaltaridNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltaridNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNotasCreditos() {
		return this.resaltaridNotasCreditos;
	}

	public void setResaltaridNotasCreditos(Border borderResaltar) {
		this.resaltaridNotasCreditos= borderResaltar;
	}

	public Boolean getMostraridNotasCreditos() {
		return this.mostraridNotasCreditos;
	}

	public void setMostraridNotasCreditos(Boolean mostraridNotasCreditos) {
		this.mostraridNotasCreditos= mostraridNotasCreditos;
	}

	public Boolean getActivaridNotasCreditos() {
		return this.activaridNotasCreditos;
	}

	public void setActivaridNotasCreditos(Boolean activaridNotasCreditos) {
		this.activaridNotasCreditos= activaridNotasCreditos;
	}

	public Border setResaltarid_empresaNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_empresaNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNotasCreditos() {
		return this.resaltarid_empresaNotasCreditos;
	}

	public void setResaltarid_empresaNotasCreditos(Border borderResaltar) {
		this.resaltarid_empresaNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_empresaNotasCreditos() {
		return this.mostrarid_empresaNotasCreditos;
	}

	public void setMostrarid_empresaNotasCreditos(Boolean mostrarid_empresaNotasCreditos) {
		this.mostrarid_empresaNotasCreditos= mostrarid_empresaNotasCreditos;
	}

	public Boolean getActivarid_empresaNotasCreditos() {
		return this.activarid_empresaNotasCreditos;
	}

	public void setActivarid_empresaNotasCreditos(Boolean activarid_empresaNotasCreditos) {
		this.activarid_empresaNotasCreditos= activarid_empresaNotasCreditos;
	}

	public Boolean getCargarid_empresaNotasCreditos() {
		return this.cargarid_empresaNotasCreditos;
	}

	public void setCargarid_empresaNotasCreditos(Boolean cargarid_empresaNotasCreditos) {
		this.cargarid_empresaNotasCreditos= cargarid_empresaNotasCreditos;
	}

	public Border setResaltarfecha_emision_desdeNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeNotasCreditos() {
		return this.resaltarfecha_emision_desdeNotasCreditos;
	}

	public void setResaltarfecha_emision_desdeNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeNotasCreditos() {
		return this.mostrarfecha_emision_desdeNotasCreditos;
	}

	public void setMostrarfecha_emision_desdeNotasCreditos(Boolean mostrarfecha_emision_desdeNotasCreditos) {
		this.mostrarfecha_emision_desdeNotasCreditos= mostrarfecha_emision_desdeNotasCreditos;
	}

	public Boolean getActivarfecha_emision_desdeNotasCreditos() {
		return this.activarfecha_emision_desdeNotasCreditos;
	}

	public void setActivarfecha_emision_desdeNotasCreditos(Boolean activarfecha_emision_desdeNotasCreditos) {
		this.activarfecha_emision_desdeNotasCreditos= activarfecha_emision_desdeNotasCreditos;
	}

	public Border setResaltarfecha_emision_hastaNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaNotasCreditos() {
		return this.resaltarfecha_emision_hastaNotasCreditos;
	}

	public void setResaltarfecha_emision_hastaNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaNotasCreditos() {
		return this.mostrarfecha_emision_hastaNotasCreditos;
	}

	public void setMostrarfecha_emision_hastaNotasCreditos(Boolean mostrarfecha_emision_hastaNotasCreditos) {
		this.mostrarfecha_emision_hastaNotasCreditos= mostrarfecha_emision_hastaNotasCreditos;
	}

	public Boolean getActivarfecha_emision_hastaNotasCreditos() {
		return this.activarfecha_emision_hastaNotasCreditos;
	}

	public void setActivarfecha_emision_hastaNotasCreditos(Boolean activarfecha_emision_hastaNotasCreditos) {
		this.activarfecha_emision_hastaNotasCreditos= activarfecha_emision_hastaNotasCreditos;
	}

	public Border setResaltarnombre_completo_clienteNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteNotasCreditos() {
		return this.resaltarnombre_completo_clienteNotasCreditos;
	}

	public void setResaltarnombre_completo_clienteNotasCreditos(Border borderResaltar) {
		this.resaltarnombre_completo_clienteNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteNotasCreditos() {
		return this.mostrarnombre_completo_clienteNotasCreditos;
	}

	public void setMostrarnombre_completo_clienteNotasCreditos(Boolean mostrarnombre_completo_clienteNotasCreditos) {
		this.mostrarnombre_completo_clienteNotasCreditos= mostrarnombre_completo_clienteNotasCreditos;
	}

	public Boolean getActivarnombre_completo_clienteNotasCreditos() {
		return this.activarnombre_completo_clienteNotasCreditos;
	}

	public void setActivarnombre_completo_clienteNotasCreditos(Boolean activarnombre_completo_clienteNotasCreditos) {
		this.activarnombre_completo_clienteNotasCreditos= activarnombre_completo_clienteNotasCreditos;
	}

	public Border setResaltarnumero_pre_impreso_facturaNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaNotasCreditos() {
		return this.resaltarnumero_pre_impreso_facturaNotasCreditos;
	}

	public void setResaltarnumero_pre_impreso_facturaNotasCreditos(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaNotasCreditos() {
		return this.mostrarnumero_pre_impreso_facturaNotasCreditos;
	}

	public void setMostrarnumero_pre_impreso_facturaNotasCreditos(Boolean mostrarnumero_pre_impreso_facturaNotasCreditos) {
		this.mostrarnumero_pre_impreso_facturaNotasCreditos= mostrarnumero_pre_impreso_facturaNotasCreditos;
	}

	public Boolean getActivarnumero_pre_impreso_facturaNotasCreditos() {
		return this.activarnumero_pre_impreso_facturaNotasCreditos;
	}

	public void setActivarnumero_pre_impreso_facturaNotasCreditos(Boolean activarnumero_pre_impreso_facturaNotasCreditos) {
		this.activarnumero_pre_impreso_facturaNotasCreditos= activarnumero_pre_impreso_facturaNotasCreditos;
	}

	public Border setResaltarnumero_pre_impresoNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoNotasCreditos() {
		return this.resaltarnumero_pre_impresoNotasCreditos;
	}

	public void setResaltarnumero_pre_impresoNotasCreditos(Border borderResaltar) {
		this.resaltarnumero_pre_impresoNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoNotasCreditos() {
		return this.mostrarnumero_pre_impresoNotasCreditos;
	}

	public void setMostrarnumero_pre_impresoNotasCreditos(Boolean mostrarnumero_pre_impresoNotasCreditos) {
		this.mostrarnumero_pre_impresoNotasCreditos= mostrarnumero_pre_impresoNotasCreditos;
	}

	public Boolean getActivarnumero_pre_impresoNotasCreditos() {
		return this.activarnumero_pre_impresoNotasCreditos;
	}

	public void setActivarnumero_pre_impresoNotasCreditos(Boolean activarnumero_pre_impresoNotasCreditos) {
		this.activarnumero_pre_impresoNotasCreditos= activarnumero_pre_impresoNotasCreditos;
	}

	public Border setResaltarfecha_emisionNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionNotasCreditos() {
		return this.resaltarfecha_emisionNotasCreditos;
	}

	public void setResaltarfecha_emisionNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_emisionNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionNotasCreditos() {
		return this.mostrarfecha_emisionNotasCreditos;
	}

	public void setMostrarfecha_emisionNotasCreditos(Boolean mostrarfecha_emisionNotasCreditos) {
		this.mostrarfecha_emisionNotasCreditos= mostrarfecha_emisionNotasCreditos;
	}

	public Boolean getActivarfecha_emisionNotasCreditos() {
		return this.activarfecha_emisionNotasCreditos;
	}

	public void setActivarfecha_emisionNotasCreditos(Boolean activarfecha_emisionNotasCreditos) {
		this.activarfecha_emisionNotasCreditos= activarfecha_emisionNotasCreditos;
	}

	public Border setResaltarfecha_vencimientoNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoNotasCreditos() {
		return this.resaltarfecha_vencimientoNotasCreditos;
	}

	public void setResaltarfecha_vencimientoNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_vencimientoNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoNotasCreditos() {
		return this.mostrarfecha_vencimientoNotasCreditos;
	}

	public void setMostrarfecha_vencimientoNotasCreditos(Boolean mostrarfecha_vencimientoNotasCreditos) {
		this.mostrarfecha_vencimientoNotasCreditos= mostrarfecha_vencimientoNotasCreditos;
	}

	public Boolean getActivarfecha_vencimientoNotasCreditos() {
		return this.activarfecha_vencimientoNotasCreditos;
	}

	public void setActivarfecha_vencimientoNotasCreditos(Boolean activarfecha_vencimientoNotasCreditos) {
		this.activarfecha_vencimientoNotasCreditos= activarfecha_vencimientoNotasCreditos;
	}

	public Border setResaltarivaNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarivaNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaNotasCreditos() {
		return this.resaltarivaNotasCreditos;
	}

	public void setResaltarivaNotasCreditos(Border borderResaltar) {
		this.resaltarivaNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarivaNotasCreditos() {
		return this.mostrarivaNotasCreditos;
	}

	public void setMostrarivaNotasCreditos(Boolean mostrarivaNotasCreditos) {
		this.mostrarivaNotasCreditos= mostrarivaNotasCreditos;
	}

	public Boolean getActivarivaNotasCreditos() {
		return this.activarivaNotasCreditos;
	}

	public void setActivarivaNotasCreditos(Boolean activarivaNotasCreditos) {
		this.activarivaNotasCreditos= activarivaNotasCreditos;
	}

	public Border setResaltardescuento_valorNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltardescuento_valorNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorNotasCreditos() {
		return this.resaltardescuento_valorNotasCreditos;
	}

	public void setResaltardescuento_valorNotasCreditos(Border borderResaltar) {
		this.resaltardescuento_valorNotasCreditos= borderResaltar;
	}

	public Boolean getMostrardescuento_valorNotasCreditos() {
		return this.mostrardescuento_valorNotasCreditos;
	}

	public void setMostrardescuento_valorNotasCreditos(Boolean mostrardescuento_valorNotasCreditos) {
		this.mostrardescuento_valorNotasCreditos= mostrardescuento_valorNotasCreditos;
	}

	public Boolean getActivardescuento_valorNotasCreditos() {
		return this.activardescuento_valorNotasCreditos;
	}

	public void setActivardescuento_valorNotasCreditos(Boolean activardescuento_valorNotasCreditos) {
		this.activardescuento_valorNotasCreditos= activardescuento_valorNotasCreditos;
	}

	public Border setResaltarotro_valorNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarotro_valorNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotro_valorNotasCreditos() {
		return this.resaltarotro_valorNotasCreditos;
	}

	public void setResaltarotro_valorNotasCreditos(Border borderResaltar) {
		this.resaltarotro_valorNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarotro_valorNotasCreditos() {
		return this.mostrarotro_valorNotasCreditos;
	}

	public void setMostrarotro_valorNotasCreditos(Boolean mostrarotro_valorNotasCreditos) {
		this.mostrarotro_valorNotasCreditos= mostrarotro_valorNotasCreditos;
	}

	public Boolean getActivarotro_valorNotasCreditos() {
		return this.activarotro_valorNotasCreditos;
	}

	public void setActivarotro_valorNotasCreditos(Boolean activarotro_valorNotasCreditos) {
		this.activarotro_valorNotasCreditos= activarotro_valorNotasCreditos;
	}

	public Border setResaltarsub_totalNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarsub_totalNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalNotasCreditos() {
		return this.resaltarsub_totalNotasCreditos;
	}

	public void setResaltarsub_totalNotasCreditos(Border borderResaltar) {
		this.resaltarsub_totalNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarsub_totalNotasCreditos() {
		return this.mostrarsub_totalNotasCreditos;
	}

	public void setMostrarsub_totalNotasCreditos(Boolean mostrarsub_totalNotasCreditos) {
		this.mostrarsub_totalNotasCreditos= mostrarsub_totalNotasCreditos;
	}

	public Boolean getActivarsub_totalNotasCreditos() {
		return this.activarsub_totalNotasCreditos;
	}

	public void setActivarsub_totalNotasCreditos(Boolean activarsub_totalNotasCreditos) {
		this.activarsub_totalNotasCreditos= activarsub_totalNotasCreditos;
	}

	public Border setResaltartotalNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltartotalNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalNotasCreditos() {
		return this.resaltartotalNotasCreditos;
	}

	public void setResaltartotalNotasCreditos(Border borderResaltar) {
		this.resaltartotalNotasCreditos= borderResaltar;
	}

	public Boolean getMostrartotalNotasCreditos() {
		return this.mostrartotalNotasCreditos;
	}

	public void setMostrartotalNotasCreditos(Boolean mostrartotalNotasCreditos) {
		this.mostrartotalNotasCreditos= mostrartotalNotasCreditos;
	}

	public Boolean getActivartotalNotasCreditos() {
		return this.activartotalNotasCreditos;
	}

	public void setActivartotalNotasCreditos(Boolean activartotalNotasCreditos) {
		this.activartotalNotasCreditos= activartotalNotasCreditos;
	}

	public Border setResaltarnombre_estado_nota_creditoNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notascreditosBeanSwingJInternalFrame.jTtoolBarNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarnombre_estado_nota_creditoNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_estado_nota_creditoNotasCreditos() {
		return this.resaltarnombre_estado_nota_creditoNotasCreditos;
	}

	public void setResaltarnombre_estado_nota_creditoNotasCreditos(Border borderResaltar) {
		this.resaltarnombre_estado_nota_creditoNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarnombre_estado_nota_creditoNotasCreditos() {
		return this.mostrarnombre_estado_nota_creditoNotasCreditos;
	}

	public void setMostrarnombre_estado_nota_creditoNotasCreditos(Boolean mostrarnombre_estado_nota_creditoNotasCreditos) {
		this.mostrarnombre_estado_nota_creditoNotasCreditos= mostrarnombre_estado_nota_creditoNotasCreditos;
	}

	public Boolean getActivarnombre_estado_nota_creditoNotasCreditos() {
		return this.activarnombre_estado_nota_creditoNotasCreditos;
	}

	public void setActivarnombre_estado_nota_creditoNotasCreditos(Boolean activarnombre_estado_nota_creditoNotasCreditos) {
		this.activarnombre_estado_nota_creditoNotasCreditos= activarnombre_estado_nota_creditoNotasCreditos;
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
		
		
		this.setMostraridNotasCreditos(esInicial);
		this.setMostrarid_empresaNotasCreditos(esInicial);
		this.setMostrarfecha_emision_desdeNotasCreditos(esInicial);
		this.setMostrarfecha_emision_hastaNotasCreditos(esInicial);
		this.setMostrarnombre_completo_clienteNotasCreditos(esInicial);
		this.setMostrarnumero_pre_impreso_facturaNotasCreditos(esInicial);
		this.setMostrarnumero_pre_impresoNotasCreditos(esInicial);
		this.setMostrarfecha_emisionNotasCreditos(esInicial);
		this.setMostrarfecha_vencimientoNotasCreditos(esInicial);
		this.setMostrarivaNotasCreditos(esInicial);
		this.setMostrardescuento_valorNotasCreditos(esInicial);
		this.setMostrarotro_valorNotasCreditos(esInicial);
		this.setMostrarsub_totalNotasCreditos(esInicial);
		this.setMostrartotalNotasCreditos(esInicial);
		this.setMostrarnombre_estado_nota_creditoNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotasCreditosConstantesFunciones.ID)) {
				this.setMostraridNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IVA)) {
				this.setMostrarivaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.OTROVALOR)) {
				this.setMostrarotro_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.TOTAL)) {
				this.setMostrartotalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO)) {
				this.setMostrarnombre_estado_nota_creditoNotasCreditos(esAsigna);
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
		
		
		this.setActivaridNotasCreditos(esInicial);
		this.setActivarid_empresaNotasCreditos(esInicial);
		this.setActivarfecha_emision_desdeNotasCreditos(esInicial);
		this.setActivarfecha_emision_hastaNotasCreditos(esInicial);
		this.setActivarnombre_completo_clienteNotasCreditos(esInicial);
		this.setActivarnumero_pre_impreso_facturaNotasCreditos(esInicial);
		this.setActivarnumero_pre_impresoNotasCreditos(esInicial);
		this.setActivarfecha_emisionNotasCreditos(esInicial);
		this.setActivarfecha_vencimientoNotasCreditos(esInicial);
		this.setActivarivaNotasCreditos(esInicial);
		this.setActivardescuento_valorNotasCreditos(esInicial);
		this.setActivarotro_valorNotasCreditos(esInicial);
		this.setActivarsub_totalNotasCreditos(esInicial);
		this.setActivartotalNotasCreditos(esInicial);
		this.setActivarnombre_estado_nota_creditoNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotasCreditosConstantesFunciones.ID)) {
				this.setActivaridNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IVA)) {
				this.setActivarivaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.OTROVALOR)) {
				this.setActivarotro_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.TOTAL)) {
				this.setActivartotalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO)) {
				this.setActivarnombre_estado_nota_creditoNotasCreditos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNotasCreditos(esInicial);
		this.setResaltarid_empresaNotasCreditos(esInicial);
		this.setResaltarfecha_emision_desdeNotasCreditos(esInicial);
		this.setResaltarfecha_emision_hastaNotasCreditos(esInicial);
		this.setResaltarnombre_completo_clienteNotasCreditos(esInicial);
		this.setResaltarnumero_pre_impreso_facturaNotasCreditos(esInicial);
		this.setResaltarnumero_pre_impresoNotasCreditos(esInicial);
		this.setResaltarfecha_emisionNotasCreditos(esInicial);
		this.setResaltarfecha_vencimientoNotasCreditos(esInicial);
		this.setResaltarivaNotasCreditos(esInicial);
		this.setResaltardescuento_valorNotasCreditos(esInicial);
		this.setResaltarotro_valorNotasCreditos(esInicial);
		this.setResaltarsub_totalNotasCreditos(esInicial);
		this.setResaltartotalNotasCreditos(esInicial);
		this.setResaltarnombre_estado_nota_creditoNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotasCreditosConstantesFunciones.ID)) {
				this.setResaltaridNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.IVA)) {
				this.setResaltarivaNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.OTROVALOR)) {
				this.setResaltarotro_valorNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.TOTAL)) {
				this.setResaltartotalNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotasCreditosConstantesFunciones.NOMBREESTADONOTACREDITO)) {
				this.setResaltarnombre_estado_nota_creditoNotasCreditos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaNotasCreditosNotasCreditos=true;

	public Boolean getMostrarBusquedaNotasCreditosNotasCreditos() {
		return this.mostrarBusquedaNotasCreditosNotasCreditos;
	}

	public void setMostrarBusquedaNotasCreditosNotasCreditos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaNotasCreditosNotasCreditos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaNotasCreditosNotasCreditos=true;

	public Boolean getActivarBusquedaNotasCreditosNotasCreditos() {
		return this.activarBusquedaNotasCreditosNotasCreditos;
	}

	public void setActivarBusquedaNotasCreditosNotasCreditos(Boolean habilitarResaltar) {
		this.activarBusquedaNotasCreditosNotasCreditos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaNotasCreditosNotasCreditos=null;

	public Border getResaltarBusquedaNotasCreditosNotasCreditos() {
		return this.resaltarBusquedaNotasCreditosNotasCreditos;
	}

	public void setResaltarBusquedaNotasCreditosNotasCreditos(Border borderResaltar) {
		this.resaltarBusquedaNotasCreditosNotasCreditos= borderResaltar;
	}

	public void setResaltarBusquedaNotasCreditosNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*NotasCreditosBeanSwingJInternalFrame notascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaNotasCreditosNotasCreditos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}