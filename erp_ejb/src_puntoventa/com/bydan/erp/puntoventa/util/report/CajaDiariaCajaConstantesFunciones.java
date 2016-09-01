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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaDiariaCajaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CajaDiariaCaja";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaDiariaCaja"+CajaDiariaCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaDiariaCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaDiariaCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaDiariaCajaConstantesFunciones.SCHEMA+"_"+CajaDiariaCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaDiariaCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaDiariaCajaConstantesFunciones.SCHEMA+"_"+CajaDiariaCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaDiariaCajaConstantesFunciones.SCHEMA+"_"+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaDiariaCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaDiariaCajaConstantesFunciones.SCHEMA+"_"+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaDiariaCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaDiariaCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaDiariaCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaDiariaCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaDiariaCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaDiariaCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaDiariaCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Diaria Cajas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Diaria Caja";
	public static final String SCLASSWEBTITULO_LOWER="Caja Diaria Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaDiariaCaja";
	public static final String OBJECTNAME="cajadiariacaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajadiariacaja from "+CajaDiariaCajaConstantesFunciones.SPERSISTENCENAME+" cajadiariacaja";
	public static String QUERYSELECTNATIVE="select "+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".id,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".version_row,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".id_empresa,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".id_caja,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".id_cliente,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".fecha_inicio,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".fecha_fin,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".nombre_caja,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".secuencial,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".codigo_cliente,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".nombre_cliente,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".subtotal,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".iva,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".descuento,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".financiamiento,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".flete,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".ice,"+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME+".total from "+CajaDiariaCajaConstantesFunciones.SCHEMA+"."+CajaDiariaCajaConstantesFunciones.TABLENAME;//+" as "+CajaDiariaCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCAJA= "id_caja";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String SECUENCIAL= "secuencial";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String SUBTOTAL= "subtotal";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getCajaDiariaCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.IDCAJA)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.IDCLIENTE)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.FECHAINICIO)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.FECHAFIN)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.NOMBRECAJA)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.SECUENCIAL)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.SUBTOTAL)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.IVA)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.DESCUENTO)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.FLETE)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.ICE)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(CajaDiariaCajaConstantesFunciones.TOTAL)) {sLabelColumna=CajaDiariaCajaConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajaDiariaCajaDescripcion(CajaDiariaCaja cajadiariacaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajadiariacaja !=null/* && cajadiariacaja.getId()!=0*/) {
			sDescripcion=cajadiariacaja.getsecuencial();//cajadiariacajacajadiariacaja.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaDiariaCajaDescripcionDetallado(CajaDiariaCaja cajadiariacaja) {
		String sDescripcion="";
			
		sDescripcion+=CajaDiariaCajaConstantesFunciones.ID+"=";
		sDescripcion+=cajadiariacaja.getId().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajadiariacaja.getVersionRow().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajadiariacaja.getid_empresa().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajadiariacaja.getid_caja().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cajadiariacaja.getid_cliente().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=cajadiariacaja.getfecha_inicio().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=cajadiariacaja.getfecha_fin().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=cajadiariacaja.getnombre_caja()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=cajadiariacaja.getsecuencial()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=cajadiariacaja.getcodigo_cliente()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=cajadiariacaja.getnombre_cliente()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=cajadiariacaja.getsubtotal().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.IVA+"=";
		sDescripcion+=cajadiariacaja.getiva().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=cajadiariacaja.getdescuento().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=cajadiariacaja.getfinanciamiento().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.FLETE+"=";
		sDescripcion+=cajadiariacaja.getflete().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.ICE+"=";
		sDescripcion+=cajadiariacaja.getice().toString()+",";
		sDescripcion+=CajaDiariaCajaConstantesFunciones.TOTAL+"=";
		sDescripcion+=cajadiariacaja.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaDiariaCajaDescripcion(CajaDiariaCaja cajadiariacaja,String sValor) throws Exception {			
		if(cajadiariacaja !=null) {
			cajadiariacaja.setsecuencial(sValor);;//cajadiariacajacajadiariacaja.getsecuencial().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCajaDiariaCaja")) {
			sNombreIndice="Tipo=  Por Caja Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCajaDiariaCaja(Long id_caja,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaDiariaCaja(CajaDiariaCaja cajadiariacaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajadiariacaja.setnombre_caja(cajadiariacaja.getnombre_caja().trim());
		cajadiariacaja.setsecuencial(cajadiariacaja.getsecuencial().trim());
		cajadiariacaja.setcodigo_cliente(cajadiariacaja.getcodigo_cliente().trim());
		cajadiariacaja.setnombre_cliente(cajadiariacaja.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosCajaDiariaCajas(List<CajaDiariaCaja> cajadiariacajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {
			cajadiariacaja.setnombre_caja(cajadiariacaja.getnombre_caja().trim());
			cajadiariacaja.setsecuencial(cajadiariacaja.getsecuencial().trim());
			cajadiariacaja.setcodigo_cliente(cajadiariacaja.getcodigo_cliente().trim());
			cajadiariacaja.setnombre_cliente(cajadiariacaja.getnombre_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaDiariaCaja(CajaDiariaCaja cajadiariacaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajadiariacaja.getConCambioAuxiliar()) {
			cajadiariacaja.setIsDeleted(cajadiariacaja.getIsDeletedAuxiliar());	
			cajadiariacaja.setIsNew(cajadiariacaja.getIsNewAuxiliar());	
			cajadiariacaja.setIsChanged(cajadiariacaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajadiariacaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajadiariacaja.setIsDeletedAuxiliar(false);	
			cajadiariacaja.setIsNewAuxiliar(false);	
			cajadiariacaja.setIsChangedAuxiliar(false);
			
			cajadiariacaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaDiariaCajas(List<CajaDiariaCaja> cajadiariacajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaDiariaCaja cajadiariacaja : cajadiariacajas) {
			if(conAsignarBase && cajadiariacaja.getConCambioAuxiliar()) {
				cajadiariacaja.setIsDeleted(cajadiariacaja.getIsDeletedAuxiliar());	
				cajadiariacaja.setIsNew(cajadiariacaja.getIsNewAuxiliar());	
				cajadiariacaja.setIsChanged(cajadiariacaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajadiariacaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajadiariacaja.setIsDeletedAuxiliar(false);	
				cajadiariacaja.setIsNewAuxiliar(false);	
				cajadiariacaja.setIsChangedAuxiliar(false);
				
				cajadiariacaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaDiariaCaja(CajaDiariaCaja cajadiariacaja,Boolean conEnteros) throws Exception  {
		cajadiariacaja.setsubtotal(0.0);
		cajadiariacaja.setiva(0.0);
		cajadiariacaja.setdescuento(0.0);
		cajadiariacaja.setfinanciamiento(0.0);
		cajadiariacaja.setflete(0.0);
		cajadiariacaja.setice(0.0);
		cajadiariacaja.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaDiariaCajas(List<CajaDiariaCaja> cajadiariacajas,Boolean conEnteros) throws Exception  {
		
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {
			cajadiariacaja.setsubtotal(0.0);
			cajadiariacaja.setiva(0.0);
			cajadiariacaja.setdescuento(0.0);
			cajadiariacaja.setfinanciamiento(0.0);
			cajadiariacaja.setflete(0.0);
			cajadiariacaja.setice(0.0);
			cajadiariacaja.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaDiariaCaja(List<CajaDiariaCaja> cajadiariacajas,CajaDiariaCaja cajadiariacajaAux) throws Exception  {
		CajaDiariaCajaConstantesFunciones.InicializarValoresCajaDiariaCaja(cajadiariacajaAux,true);
		
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {
			if(cajadiariacaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajadiariacajaAux.setsubtotal(cajadiariacajaAux.getsubtotal()+cajadiariacaja.getsubtotal());			
			cajadiariacajaAux.setiva(cajadiariacajaAux.getiva()+cajadiariacaja.getiva());			
			cajadiariacajaAux.setdescuento(cajadiariacajaAux.getdescuento()+cajadiariacaja.getdescuento());			
			cajadiariacajaAux.setfinanciamiento(cajadiariacajaAux.getfinanciamiento()+cajadiariacaja.getfinanciamiento());			
			cajadiariacajaAux.setflete(cajadiariacajaAux.getflete()+cajadiariacaja.getflete());			
			cajadiariacajaAux.setice(cajadiariacajaAux.getice()+cajadiariacaja.getice());			
			cajadiariacajaAux.settotal(cajadiariacajaAux.gettotal()+cajadiariacaja.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaDiariaCajaConstantesFunciones.getArrayColumnasGlobalesCajaDiariaCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaDiariaCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaDiariaCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaDiariaCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaDiariaCaja> cajadiariacajas,CajaDiariaCaja cajadiariacaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaDiariaCaja cajadiariacajaAux: cajadiariacajas) {
			if(cajadiariacajaAux!=null && cajadiariacaja!=null) {
				if((cajadiariacajaAux.getId()==null && cajadiariacaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajadiariacajaAux.getId()!=null && cajadiariacaja.getId()!=null){
					if(cajadiariacajaAux.getId().equals(cajadiariacaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaDiariaCaja(List<CajaDiariaCaja> cajadiariacajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
	
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {			
			if(cajadiariacaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=cajadiariacaja.getsubtotal();
			ivaTotal+=cajadiariacaja.getiva();
			descuentoTotal+=cajadiariacaja.getdescuento();
			financiamientoTotal+=cajadiariacaja.getfinanciamiento();
			fleteTotal+=cajadiariacaja.getflete();
			iceTotal+=cajadiariacaja.getice();
			totalTotal+=cajadiariacaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaDiariaCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_ID, CajaDiariaCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_VERSIONROW, CajaDiariaCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_IDCAJA, CajaDiariaCajaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_IDCLIENTE, CajaDiariaCajaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECAJA, CajaDiariaCajaConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_SECUENCIAL, CajaDiariaCajaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_CODIGOCLIENTE, CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECLIENTE, CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL, CajaDiariaCajaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_IVA, CajaDiariaCajaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO, CajaDiariaCajaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO, CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_FLETE, CajaDiariaCajaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_ICE, CajaDiariaCajaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaDiariaCajaConstantesFunciones.LABEL_TOTAL, CajaDiariaCajaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaDiariaCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaDiariaCajaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaCaja() throws Exception  {
		return CajaDiariaCajaConstantesFunciones.getTiposSeleccionarCajaDiariaCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaCaja(Boolean conFk) throws Exception  {
		return CajaDiariaCajaConstantesFunciones.getTiposSeleccionarCajaDiariaCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaDiariaCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaDiariaCajaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaDiariaCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaDiariaCaja(CajaDiariaCaja cajadiariacajaAux) throws Exception {
		
			cajadiariacajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajadiariacajaAux.getEmpresa()));
			cajadiariacajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajadiariacajaAux.getCaja()));
			cajadiariacajaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajadiariacajaAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaDiariaCaja(List<CajaDiariaCaja> cajadiariacajasTemp) throws Exception {
		for(CajaDiariaCaja cajadiariacajaAux:cajadiariacajasTemp) {
			
			cajadiariacajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajadiariacajaAux.getEmpresa()));
			cajadiariacajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajadiariacajaAux.getCaja()));
			cajadiariacajaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajadiariacajaAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaDiariaCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaDiariaCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaDiariaCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaDiariaCajaConstantesFunciones.getClassesRelationshipsOfCajaDiariaCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaDiariaCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaDiariaCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaDiariaCajaConstantesFunciones.getClassesRelationshipsFromStringsOfCajaDiariaCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaDiariaCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajaDiariaCaja cajadiariacaja,List<CajaDiariaCaja> cajadiariacajas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CajaDiariaCaja cajadiariacaja,List<CajaDiariaCaja> cajadiariacajas) throws Exception {
		try	{			
			for(CajaDiariaCaja cajadiariacajaLocal:cajadiariacajas) {
				if(cajadiariacajaLocal.getId().equals(cajadiariacaja.getId())) {
					cajadiariacajaLocal.setIsSelected(cajadiariacaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaDiariaCaja(List<CajaDiariaCaja> cajadiariacajasAux) throws Exception {
		//this.cajadiariacajasAux=cajadiariacajasAux;
		
		for(CajaDiariaCaja cajadiariacajaAux:cajadiariacajasAux) {
			if(cajadiariacajaAux.getIsChanged()) {
				cajadiariacajaAux.setIsChanged(false);
			}		
			
			if(cajadiariacajaAux.getIsNew()) {
				cajadiariacajaAux.setIsNew(false);
			}	
			
			if(cajadiariacajaAux.getIsDeleted()) {
				cajadiariacajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaDiariaCaja(CajaDiariaCaja cajadiariacajaAux) throws Exception {
		//this.cajadiariacajaAux=cajadiariacajaAux;
		
			if(cajadiariacajaAux.getIsChanged()) {
				cajadiariacajaAux.setIsChanged(false);
			}		
			
			if(cajadiariacajaAux.getIsNew()) {
				cajadiariacajaAux.setIsNew(false);
			}	
			
			if(cajadiariacajaAux.getIsDeleted()) {
				cajadiariacajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaDiariaCaja cajadiariacajaAsignar,CajaDiariaCaja cajadiariacaja) throws Exception {
		cajadiariacajaAsignar.setId(cajadiariacaja.getId());	
		cajadiariacajaAsignar.setVersionRow(cajadiariacaja.getVersionRow());	
		cajadiariacajaAsignar.setid_caja(cajadiariacaja.getid_caja());
		cajadiariacajaAsignar.setcaja_descripcion(cajadiariacaja.getcaja_descripcion());	
		cajadiariacajaAsignar.setid_cliente(cajadiariacaja.getid_cliente());
		cajadiariacajaAsignar.setcliente_descripcion(cajadiariacaja.getcliente_descripcion());	
		cajadiariacajaAsignar.setnombre_caja(cajadiariacaja.getnombre_caja());	
		cajadiariacajaAsignar.setsecuencial(cajadiariacaja.getsecuencial());	
		cajadiariacajaAsignar.setcodigo_cliente(cajadiariacaja.getcodigo_cliente());	
		cajadiariacajaAsignar.setnombre_cliente(cajadiariacaja.getnombre_cliente());	
		cajadiariacajaAsignar.setsubtotal(cajadiariacaja.getsubtotal());	
		cajadiariacajaAsignar.setiva(cajadiariacaja.getiva());	
		cajadiariacajaAsignar.setdescuento(cajadiariacaja.getdescuento());	
		cajadiariacajaAsignar.setfinanciamiento(cajadiariacaja.getfinanciamiento());	
		cajadiariacajaAsignar.setflete(cajadiariacaja.getflete());	
		cajadiariacajaAsignar.setice(cajadiariacaja.getice());	
		cajadiariacajaAsignar.settotal(cajadiariacaja.gettotal());	
	}
	
	public static void inicializarCajaDiariaCaja(CajaDiariaCaja cajadiariacaja) throws Exception {
		try {
				cajadiariacaja.setId(0L);	
					
				cajadiariacaja.setid_caja(-1L);	
				cajadiariacaja.setid_cliente(-1L);	
				cajadiariacaja.setnombre_caja("");	
				cajadiariacaja.setsecuencial("");	
				cajadiariacaja.setcodigo_cliente("");	
				cajadiariacaja.setnombre_cliente("");	
				cajadiariacaja.setsubtotal(0.0);	
				cajadiariacaja.setiva(0.0);	
				cajadiariacaja.setdescuento(0.0);	
				cajadiariacaja.setfinanciamiento(0.0);	
				cajadiariacaja.setflete(0.0);	
				cajadiariacaja.setice(0.0);	
				cajadiariacaja.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaDiariaCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaDiariaCajaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaDiariaCaja(String sTipo,Row row,Workbook workbook,CajaDiariaCaja cajadiariacaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajadiariacaja.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaDiariaCaja="";
	
	public String getsFinalQueryCajaDiariaCaja() {
		return this.sFinalQueryCajaDiariaCaja;
	}
	
	public void setsFinalQueryCajaDiariaCaja(String sFinalQueryCajaDiariaCaja) {
		this.sFinalQueryCajaDiariaCaja= sFinalQueryCajaDiariaCaja;
	}
	
	public Border resaltarSeleccionarCajaDiariaCaja=null;
	
	public Border setResaltarSeleccionarCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaDiariaCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaDiariaCaja() {
		return this.resaltarSeleccionarCajaDiariaCaja;
	}
	
	public void setResaltarSeleccionarCajaDiariaCaja(Border borderResaltarSeleccionarCajaDiariaCaja) {
		this.resaltarSeleccionarCajaDiariaCaja= borderResaltarSeleccionarCajaDiariaCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaDiariaCaja=null;
	public Boolean mostraridCajaDiariaCaja=true;
	public Boolean activaridCajaDiariaCaja=true;

	public Border resaltarid_empresaCajaDiariaCaja=null;
	public Boolean mostrarid_empresaCajaDiariaCaja=true;
	public Boolean activarid_empresaCajaDiariaCaja=true;
	public Boolean cargarid_empresaCajaDiariaCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaDiariaCaja=false;//ConEventDepend=true

	public Border resaltarid_cajaCajaDiariaCaja=null;
	public Boolean mostrarid_cajaCajaDiariaCaja=true;
	public Boolean activarid_cajaCajaDiariaCaja=false;
	public Boolean cargarid_cajaCajaDiariaCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajaDiariaCaja=false;//ConEventDepend=true

	public Border resaltarid_clienteCajaDiariaCaja=null;
	public Boolean mostrarid_clienteCajaDiariaCaja=true;
	public Boolean activarid_clienteCajaDiariaCaja=false;
	public Boolean cargarid_clienteCajaDiariaCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCajaDiariaCaja=false;//ConEventDepend=true

	public Border resaltarfecha_inicioCajaDiariaCaja=null;
	public Boolean mostrarfecha_inicioCajaDiariaCaja=true;
	public Boolean activarfecha_inicioCajaDiariaCaja=true;

	public Border resaltarfecha_finCajaDiariaCaja=null;
	public Boolean mostrarfecha_finCajaDiariaCaja=true;
	public Boolean activarfecha_finCajaDiariaCaja=true;

	public Border resaltarnombre_cajaCajaDiariaCaja=null;
	public Boolean mostrarnombre_cajaCajaDiariaCaja=true;
	public Boolean activarnombre_cajaCajaDiariaCaja=true;

	public Border resaltarsecuencialCajaDiariaCaja=null;
	public Boolean mostrarsecuencialCajaDiariaCaja=true;
	public Boolean activarsecuencialCajaDiariaCaja=true;

	public Border resaltarcodigo_clienteCajaDiariaCaja=null;
	public Boolean mostrarcodigo_clienteCajaDiariaCaja=true;
	public Boolean activarcodigo_clienteCajaDiariaCaja=true;

	public Border resaltarnombre_clienteCajaDiariaCaja=null;
	public Boolean mostrarnombre_clienteCajaDiariaCaja=true;
	public Boolean activarnombre_clienteCajaDiariaCaja=true;

	public Border resaltarsubtotalCajaDiariaCaja=null;
	public Boolean mostrarsubtotalCajaDiariaCaja=true;
	public Boolean activarsubtotalCajaDiariaCaja=true;

	public Border resaltarivaCajaDiariaCaja=null;
	public Boolean mostrarivaCajaDiariaCaja=true;
	public Boolean activarivaCajaDiariaCaja=true;

	public Border resaltardescuentoCajaDiariaCaja=null;
	public Boolean mostrardescuentoCajaDiariaCaja=true;
	public Boolean activardescuentoCajaDiariaCaja=true;

	public Border resaltarfinanciamientoCajaDiariaCaja=null;
	public Boolean mostrarfinanciamientoCajaDiariaCaja=true;
	public Boolean activarfinanciamientoCajaDiariaCaja=true;

	public Border resaltarfleteCajaDiariaCaja=null;
	public Boolean mostrarfleteCajaDiariaCaja=true;
	public Boolean activarfleteCajaDiariaCaja=true;

	public Border resaltariceCajaDiariaCaja=null;
	public Boolean mostrariceCajaDiariaCaja=true;
	public Boolean activariceCajaDiariaCaja=true;

	public Border resaltartotalCajaDiariaCaja=null;
	public Boolean mostrartotalCajaDiariaCaja=true;
	public Boolean activartotalCajaDiariaCaja=true;

	
	

	public Border setResaltaridCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltaridCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaDiariaCaja() {
		return this.resaltaridCajaDiariaCaja;
	}

	public void setResaltaridCajaDiariaCaja(Border borderResaltar) {
		this.resaltaridCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostraridCajaDiariaCaja() {
		return this.mostraridCajaDiariaCaja;
	}

	public void setMostraridCajaDiariaCaja(Boolean mostraridCajaDiariaCaja) {
		this.mostraridCajaDiariaCaja= mostraridCajaDiariaCaja;
	}

	public Boolean getActivaridCajaDiariaCaja() {
		return this.activaridCajaDiariaCaja;
	}

	public void setActivaridCajaDiariaCaja(Boolean activaridCajaDiariaCaja) {
		this.activaridCajaDiariaCaja= activaridCajaDiariaCaja;
	}

	public Border setResaltarid_empresaCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaDiariaCaja() {
		return this.resaltarid_empresaCajaDiariaCaja;
	}

	public void setResaltarid_empresaCajaDiariaCaja(Border borderResaltar) {
		this.resaltarid_empresaCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaDiariaCaja() {
		return this.mostrarid_empresaCajaDiariaCaja;
	}

	public void setMostrarid_empresaCajaDiariaCaja(Boolean mostrarid_empresaCajaDiariaCaja) {
		this.mostrarid_empresaCajaDiariaCaja= mostrarid_empresaCajaDiariaCaja;
	}

	public Boolean getActivarid_empresaCajaDiariaCaja() {
		return this.activarid_empresaCajaDiariaCaja;
	}

	public void setActivarid_empresaCajaDiariaCaja(Boolean activarid_empresaCajaDiariaCaja) {
		this.activarid_empresaCajaDiariaCaja= activarid_empresaCajaDiariaCaja;
	}

	public Boolean getCargarid_empresaCajaDiariaCaja() {
		return this.cargarid_empresaCajaDiariaCaja;
	}

	public void setCargarid_empresaCajaDiariaCaja(Boolean cargarid_empresaCajaDiariaCaja) {
		this.cargarid_empresaCajaDiariaCaja= cargarid_empresaCajaDiariaCaja;
	}

	public Border setResaltarid_cajaCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajaDiariaCaja() {
		return this.resaltarid_cajaCajaDiariaCaja;
	}

	public void setResaltarid_cajaCajaDiariaCaja(Border borderResaltar) {
		this.resaltarid_cajaCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajaDiariaCaja() {
		return this.mostrarid_cajaCajaDiariaCaja;
	}

	public void setMostrarid_cajaCajaDiariaCaja(Boolean mostrarid_cajaCajaDiariaCaja) {
		this.mostrarid_cajaCajaDiariaCaja= mostrarid_cajaCajaDiariaCaja;
	}

	public Boolean getActivarid_cajaCajaDiariaCaja() {
		return this.activarid_cajaCajaDiariaCaja;
	}

	public void setActivarid_cajaCajaDiariaCaja(Boolean activarid_cajaCajaDiariaCaja) {
		this.activarid_cajaCajaDiariaCaja= activarid_cajaCajaDiariaCaja;
	}

	public Boolean getCargarid_cajaCajaDiariaCaja() {
		return this.cargarid_cajaCajaDiariaCaja;
	}

	public void setCargarid_cajaCajaDiariaCaja(Boolean cargarid_cajaCajaDiariaCaja) {
		this.cargarid_cajaCajaDiariaCaja= cargarid_cajaCajaDiariaCaja;
	}

	public Border setResaltarid_clienteCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarid_clienteCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCajaDiariaCaja() {
		return this.resaltarid_clienteCajaDiariaCaja;
	}

	public void setResaltarid_clienteCajaDiariaCaja(Border borderResaltar) {
		this.resaltarid_clienteCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarid_clienteCajaDiariaCaja() {
		return this.mostrarid_clienteCajaDiariaCaja;
	}

	public void setMostrarid_clienteCajaDiariaCaja(Boolean mostrarid_clienteCajaDiariaCaja) {
		this.mostrarid_clienteCajaDiariaCaja= mostrarid_clienteCajaDiariaCaja;
	}

	public Boolean getActivarid_clienteCajaDiariaCaja() {
		return this.activarid_clienteCajaDiariaCaja;
	}

	public void setActivarid_clienteCajaDiariaCaja(Boolean activarid_clienteCajaDiariaCaja) {
		this.activarid_clienteCajaDiariaCaja= activarid_clienteCajaDiariaCaja;
	}

	public Boolean getCargarid_clienteCajaDiariaCaja() {
		return this.cargarid_clienteCajaDiariaCaja;
	}

	public void setCargarid_clienteCajaDiariaCaja(Boolean cargarid_clienteCajaDiariaCaja) {
		this.cargarid_clienteCajaDiariaCaja= cargarid_clienteCajaDiariaCaja;
	}

	public Border setResaltarfecha_inicioCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioCajaDiariaCaja() {
		return this.resaltarfecha_inicioCajaDiariaCaja;
	}

	public void setResaltarfecha_inicioCajaDiariaCaja(Border borderResaltar) {
		this.resaltarfecha_inicioCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioCajaDiariaCaja() {
		return this.mostrarfecha_inicioCajaDiariaCaja;
	}

	public void setMostrarfecha_inicioCajaDiariaCaja(Boolean mostrarfecha_inicioCajaDiariaCaja) {
		this.mostrarfecha_inicioCajaDiariaCaja= mostrarfecha_inicioCajaDiariaCaja;
	}

	public Boolean getActivarfecha_inicioCajaDiariaCaja() {
		return this.activarfecha_inicioCajaDiariaCaja;
	}

	public void setActivarfecha_inicioCajaDiariaCaja(Boolean activarfecha_inicioCajaDiariaCaja) {
		this.activarfecha_inicioCajaDiariaCaja= activarfecha_inicioCajaDiariaCaja;
	}

	public Border setResaltarfecha_finCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_finCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finCajaDiariaCaja() {
		return this.resaltarfecha_finCajaDiariaCaja;
	}

	public void setResaltarfecha_finCajaDiariaCaja(Border borderResaltar) {
		this.resaltarfecha_finCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_finCajaDiariaCaja() {
		return this.mostrarfecha_finCajaDiariaCaja;
	}

	public void setMostrarfecha_finCajaDiariaCaja(Boolean mostrarfecha_finCajaDiariaCaja) {
		this.mostrarfecha_finCajaDiariaCaja= mostrarfecha_finCajaDiariaCaja;
	}

	public Boolean getActivarfecha_finCajaDiariaCaja() {
		return this.activarfecha_finCajaDiariaCaja;
	}

	public void setActivarfecha_finCajaDiariaCaja(Boolean activarfecha_finCajaDiariaCaja) {
		this.activarfecha_finCajaDiariaCaja= activarfecha_finCajaDiariaCaja;
	}

	public Border setResaltarnombre_cajaCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaCajaDiariaCaja() {
		return this.resaltarnombre_cajaCajaDiariaCaja;
	}

	public void setResaltarnombre_cajaCajaDiariaCaja(Border borderResaltar) {
		this.resaltarnombre_cajaCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaCajaDiariaCaja() {
		return this.mostrarnombre_cajaCajaDiariaCaja;
	}

	public void setMostrarnombre_cajaCajaDiariaCaja(Boolean mostrarnombre_cajaCajaDiariaCaja) {
		this.mostrarnombre_cajaCajaDiariaCaja= mostrarnombre_cajaCajaDiariaCaja;
	}

	public Boolean getActivarnombre_cajaCajaDiariaCaja() {
		return this.activarnombre_cajaCajaDiariaCaja;
	}

	public void setActivarnombre_cajaCajaDiariaCaja(Boolean activarnombre_cajaCajaDiariaCaja) {
		this.activarnombre_cajaCajaDiariaCaja= activarnombre_cajaCajaDiariaCaja;
	}

	public Border setResaltarsecuencialCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarsecuencialCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialCajaDiariaCaja() {
		return this.resaltarsecuencialCajaDiariaCaja;
	}

	public void setResaltarsecuencialCajaDiariaCaja(Border borderResaltar) {
		this.resaltarsecuencialCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarsecuencialCajaDiariaCaja() {
		return this.mostrarsecuencialCajaDiariaCaja;
	}

	public void setMostrarsecuencialCajaDiariaCaja(Boolean mostrarsecuencialCajaDiariaCaja) {
		this.mostrarsecuencialCajaDiariaCaja= mostrarsecuencialCajaDiariaCaja;
	}

	public Boolean getActivarsecuencialCajaDiariaCaja() {
		return this.activarsecuencialCajaDiariaCaja;
	}

	public void setActivarsecuencialCajaDiariaCaja(Boolean activarsecuencialCajaDiariaCaja) {
		this.activarsecuencialCajaDiariaCaja= activarsecuencialCajaDiariaCaja;
	}

	public Border setResaltarcodigo_clienteCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteCajaDiariaCaja() {
		return this.resaltarcodigo_clienteCajaDiariaCaja;
	}

	public void setResaltarcodigo_clienteCajaDiariaCaja(Border borderResaltar) {
		this.resaltarcodigo_clienteCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteCajaDiariaCaja() {
		return this.mostrarcodigo_clienteCajaDiariaCaja;
	}

	public void setMostrarcodigo_clienteCajaDiariaCaja(Boolean mostrarcodigo_clienteCajaDiariaCaja) {
		this.mostrarcodigo_clienteCajaDiariaCaja= mostrarcodigo_clienteCajaDiariaCaja;
	}

	public Boolean getActivarcodigo_clienteCajaDiariaCaja() {
		return this.activarcodigo_clienteCajaDiariaCaja;
	}

	public void setActivarcodigo_clienteCajaDiariaCaja(Boolean activarcodigo_clienteCajaDiariaCaja) {
		this.activarcodigo_clienteCajaDiariaCaja= activarcodigo_clienteCajaDiariaCaja;
	}

	public Border setResaltarnombre_clienteCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteCajaDiariaCaja() {
		return this.resaltarnombre_clienteCajaDiariaCaja;
	}

	public void setResaltarnombre_clienteCajaDiariaCaja(Border borderResaltar) {
		this.resaltarnombre_clienteCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteCajaDiariaCaja() {
		return this.mostrarnombre_clienteCajaDiariaCaja;
	}

	public void setMostrarnombre_clienteCajaDiariaCaja(Boolean mostrarnombre_clienteCajaDiariaCaja) {
		this.mostrarnombre_clienteCajaDiariaCaja= mostrarnombre_clienteCajaDiariaCaja;
	}

	public Boolean getActivarnombre_clienteCajaDiariaCaja() {
		return this.activarnombre_clienteCajaDiariaCaja;
	}

	public void setActivarnombre_clienteCajaDiariaCaja(Boolean activarnombre_clienteCajaDiariaCaja) {
		this.activarnombre_clienteCajaDiariaCaja= activarnombre_clienteCajaDiariaCaja;
	}

	public Border setResaltarsubtotalCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarsubtotalCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalCajaDiariaCaja() {
		return this.resaltarsubtotalCajaDiariaCaja;
	}

	public void setResaltarsubtotalCajaDiariaCaja(Border borderResaltar) {
		this.resaltarsubtotalCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarsubtotalCajaDiariaCaja() {
		return this.mostrarsubtotalCajaDiariaCaja;
	}

	public void setMostrarsubtotalCajaDiariaCaja(Boolean mostrarsubtotalCajaDiariaCaja) {
		this.mostrarsubtotalCajaDiariaCaja= mostrarsubtotalCajaDiariaCaja;
	}

	public Boolean getActivarsubtotalCajaDiariaCaja() {
		return this.activarsubtotalCajaDiariaCaja;
	}

	public void setActivarsubtotalCajaDiariaCaja(Boolean activarsubtotalCajaDiariaCaja) {
		this.activarsubtotalCajaDiariaCaja= activarsubtotalCajaDiariaCaja;
	}

	public Border setResaltarivaCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarivaCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaCajaDiariaCaja() {
		return this.resaltarivaCajaDiariaCaja;
	}

	public void setResaltarivaCajaDiariaCaja(Border borderResaltar) {
		this.resaltarivaCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarivaCajaDiariaCaja() {
		return this.mostrarivaCajaDiariaCaja;
	}

	public void setMostrarivaCajaDiariaCaja(Boolean mostrarivaCajaDiariaCaja) {
		this.mostrarivaCajaDiariaCaja= mostrarivaCajaDiariaCaja;
	}

	public Boolean getActivarivaCajaDiariaCaja() {
		return this.activarivaCajaDiariaCaja;
	}

	public void setActivarivaCajaDiariaCaja(Boolean activarivaCajaDiariaCaja) {
		this.activarivaCajaDiariaCaja= activarivaCajaDiariaCaja;
	}

	public Border setResaltardescuentoCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltardescuentoCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoCajaDiariaCaja() {
		return this.resaltardescuentoCajaDiariaCaja;
	}

	public void setResaltardescuentoCajaDiariaCaja(Border borderResaltar) {
		this.resaltardescuentoCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrardescuentoCajaDiariaCaja() {
		return this.mostrardescuentoCajaDiariaCaja;
	}

	public void setMostrardescuentoCajaDiariaCaja(Boolean mostrardescuentoCajaDiariaCaja) {
		this.mostrardescuentoCajaDiariaCaja= mostrardescuentoCajaDiariaCaja;
	}

	public Boolean getActivardescuentoCajaDiariaCaja() {
		return this.activardescuentoCajaDiariaCaja;
	}

	public void setActivardescuentoCajaDiariaCaja(Boolean activardescuentoCajaDiariaCaja) {
		this.activardescuentoCajaDiariaCaja= activardescuentoCajaDiariaCaja;
	}

	public Border setResaltarfinanciamientoCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoCajaDiariaCaja() {
		return this.resaltarfinanciamientoCajaDiariaCaja;
	}

	public void setResaltarfinanciamientoCajaDiariaCaja(Border borderResaltar) {
		this.resaltarfinanciamientoCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoCajaDiariaCaja() {
		return this.mostrarfinanciamientoCajaDiariaCaja;
	}

	public void setMostrarfinanciamientoCajaDiariaCaja(Boolean mostrarfinanciamientoCajaDiariaCaja) {
		this.mostrarfinanciamientoCajaDiariaCaja= mostrarfinanciamientoCajaDiariaCaja;
	}

	public Boolean getActivarfinanciamientoCajaDiariaCaja() {
		return this.activarfinanciamientoCajaDiariaCaja;
	}

	public void setActivarfinanciamientoCajaDiariaCaja(Boolean activarfinanciamientoCajaDiariaCaja) {
		this.activarfinanciamientoCajaDiariaCaja= activarfinanciamientoCajaDiariaCaja;
	}

	public Border setResaltarfleteCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltarfleteCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteCajaDiariaCaja() {
		return this.resaltarfleteCajaDiariaCaja;
	}

	public void setResaltarfleteCajaDiariaCaja(Border borderResaltar) {
		this.resaltarfleteCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrarfleteCajaDiariaCaja() {
		return this.mostrarfleteCajaDiariaCaja;
	}

	public void setMostrarfleteCajaDiariaCaja(Boolean mostrarfleteCajaDiariaCaja) {
		this.mostrarfleteCajaDiariaCaja= mostrarfleteCajaDiariaCaja;
	}

	public Boolean getActivarfleteCajaDiariaCaja() {
		return this.activarfleteCajaDiariaCaja;
	}

	public void setActivarfleteCajaDiariaCaja(Boolean activarfleteCajaDiariaCaja) {
		this.activarfleteCajaDiariaCaja= activarfleteCajaDiariaCaja;
	}

	public Border setResaltariceCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltariceCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceCajaDiariaCaja() {
		return this.resaltariceCajaDiariaCaja;
	}

	public void setResaltariceCajaDiariaCaja(Border borderResaltar) {
		this.resaltariceCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrariceCajaDiariaCaja() {
		return this.mostrariceCajaDiariaCaja;
	}

	public void setMostrariceCajaDiariaCaja(Boolean mostrariceCajaDiariaCaja) {
		this.mostrariceCajaDiariaCaja= mostrariceCajaDiariaCaja;
	}

	public Boolean getActivariceCajaDiariaCaja() {
		return this.activariceCajaDiariaCaja;
	}

	public void setActivariceCajaDiariaCaja(Boolean activariceCajaDiariaCaja) {
		this.activariceCajaDiariaCaja= activariceCajaDiariaCaja;
	}

	public Border setResaltartotalCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajadiariacajaBeanSwingJInternalFrame.jTtoolBarCajaDiariaCaja.setBorder(borderResaltar);
		
		this.resaltartotalCajaDiariaCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCajaDiariaCaja() {
		return this.resaltartotalCajaDiariaCaja;
	}

	public void setResaltartotalCajaDiariaCaja(Border borderResaltar) {
		this.resaltartotalCajaDiariaCaja= borderResaltar;
	}

	public Boolean getMostrartotalCajaDiariaCaja() {
		return this.mostrartotalCajaDiariaCaja;
	}

	public void setMostrartotalCajaDiariaCaja(Boolean mostrartotalCajaDiariaCaja) {
		this.mostrartotalCajaDiariaCaja= mostrartotalCajaDiariaCaja;
	}

	public Boolean getActivartotalCajaDiariaCaja() {
		return this.activartotalCajaDiariaCaja;
	}

	public void setActivartotalCajaDiariaCaja(Boolean activartotalCajaDiariaCaja) {
		this.activartotalCajaDiariaCaja= activartotalCajaDiariaCaja;
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
		
		
		this.setMostraridCajaDiariaCaja(esInicial);
		this.setMostrarid_empresaCajaDiariaCaja(esInicial);
		this.setMostrarid_cajaCajaDiariaCaja(esInicial);
		this.setMostrarid_clienteCajaDiariaCaja(esInicial);
		this.setMostrarfecha_inicioCajaDiariaCaja(esInicial);
		this.setMostrarfecha_finCajaDiariaCaja(esInicial);
		this.setMostrarnombre_cajaCajaDiariaCaja(esInicial);
		this.setMostrarsecuencialCajaDiariaCaja(esInicial);
		this.setMostrarcodigo_clienteCajaDiariaCaja(esInicial);
		this.setMostrarnombre_clienteCajaDiariaCaja(esInicial);
		this.setMostrarsubtotalCajaDiariaCaja(esInicial);
		this.setMostrarivaCajaDiariaCaja(esInicial);
		this.setMostrardescuentoCajaDiariaCaja(esInicial);
		this.setMostrarfinanciamientoCajaDiariaCaja(esInicial);
		this.setMostrarfleteCajaDiariaCaja(esInicial);
		this.setMostrariceCajaDiariaCaja(esInicial);
		this.setMostrartotalCajaDiariaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ID)) {
				this.setMostraridCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IVA)) {
				this.setMostrarivaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FLETE)) {
				this.setMostrarfleteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ICE)) {
				this.setMostrariceCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.TOTAL)) {
				this.setMostrartotalCajaDiariaCaja(esAsigna);
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
		
		
		this.setActivaridCajaDiariaCaja(esInicial);
		this.setActivarid_empresaCajaDiariaCaja(esInicial);
		this.setActivarid_cajaCajaDiariaCaja(esInicial);
		this.setActivarid_clienteCajaDiariaCaja(esInicial);
		this.setActivarfecha_inicioCajaDiariaCaja(esInicial);
		this.setActivarfecha_finCajaDiariaCaja(esInicial);
		this.setActivarnombre_cajaCajaDiariaCaja(esInicial);
		this.setActivarsecuencialCajaDiariaCaja(esInicial);
		this.setActivarcodigo_clienteCajaDiariaCaja(esInicial);
		this.setActivarnombre_clienteCajaDiariaCaja(esInicial);
		this.setActivarsubtotalCajaDiariaCaja(esInicial);
		this.setActivarivaCajaDiariaCaja(esInicial);
		this.setActivardescuentoCajaDiariaCaja(esInicial);
		this.setActivarfinanciamientoCajaDiariaCaja(esInicial);
		this.setActivarfleteCajaDiariaCaja(esInicial);
		this.setActivariceCajaDiariaCaja(esInicial);
		this.setActivartotalCajaDiariaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ID)) {
				this.setActivaridCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IVA)) {
				this.setActivarivaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FLETE)) {
				this.setActivarfleteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ICE)) {
				this.setActivariceCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.TOTAL)) {
				this.setActivartotalCajaDiariaCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaDiariaCaja(esInicial);
		this.setResaltarid_empresaCajaDiariaCaja(esInicial);
		this.setResaltarid_cajaCajaDiariaCaja(esInicial);
		this.setResaltarid_clienteCajaDiariaCaja(esInicial);
		this.setResaltarfecha_inicioCajaDiariaCaja(esInicial);
		this.setResaltarfecha_finCajaDiariaCaja(esInicial);
		this.setResaltarnombre_cajaCajaDiariaCaja(esInicial);
		this.setResaltarsecuencialCajaDiariaCaja(esInicial);
		this.setResaltarcodigo_clienteCajaDiariaCaja(esInicial);
		this.setResaltarnombre_clienteCajaDiariaCaja(esInicial);
		this.setResaltarsubtotalCajaDiariaCaja(esInicial);
		this.setResaltarivaCajaDiariaCaja(esInicial);
		this.setResaltardescuentoCajaDiariaCaja(esInicial);
		this.setResaltarfinanciamientoCajaDiariaCaja(esInicial);
		this.setResaltarfleteCajaDiariaCaja(esInicial);
		this.setResaltariceCajaDiariaCaja(esInicial);
		this.setResaltartotalCajaDiariaCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ID)) {
				this.setResaltaridCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.IVA)) {
				this.setResaltarivaCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.FLETE)) {
				this.setResaltarfleteCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.ICE)) {
				this.setResaltariceCajaDiariaCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaDiariaCajaConstantesFunciones.TOTAL)) {
				this.setResaltartotalCajaDiariaCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCajaDiariaCajaCajaDiariaCaja=true;

	public Boolean getMostrarBusquedaCajaDiariaCajaCajaDiariaCaja() {
		return this.mostrarBusquedaCajaDiariaCajaCajaDiariaCaja;
	}

	public void setMostrarBusquedaCajaDiariaCajaCajaDiariaCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCajaDiariaCajaCajaDiariaCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCajaDiariaCajaCajaDiariaCaja=true;

	public Boolean getActivarBusquedaCajaDiariaCajaCajaDiariaCaja() {
		return this.activarBusquedaCajaDiariaCajaCajaDiariaCaja;
	}

	public void setActivarBusquedaCajaDiariaCajaCajaDiariaCaja(Boolean habilitarResaltar) {
		this.activarBusquedaCajaDiariaCajaCajaDiariaCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCajaDiariaCajaCajaDiariaCaja=null;

	public Border getResaltarBusquedaCajaDiariaCajaCajaDiariaCaja() {
		return this.resaltarBusquedaCajaDiariaCajaCajaDiariaCaja;
	}

	public void setResaltarBusquedaCajaDiariaCajaCajaDiariaCaja(Border borderResaltar) {
		this.resaltarBusquedaCajaDiariaCajaCajaDiariaCaja= borderResaltar;
	}

	public void setResaltarBusquedaCajaDiariaCajaCajaDiariaCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CajaDiariaCajaBeanSwingJInternalFrame cajadiariacajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCajaDiariaCajaCajaDiariaCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}