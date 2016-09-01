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
package com.bydan.erp.sris.util.report;

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


import com.bydan.erp.sris.util.report.SriFacturasProveedoresConstantesFunciones;
import com.bydan.erp.sris.util.report.SriFacturasProveedoresParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.SriFacturasProveedoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SriFacturasProveedoresConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SriFacturasProveedores";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SriFacturasProveedores"+SriFacturasProveedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriFacturasProveedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriFacturasProveedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriFacturasProveedoresConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriFacturasProveedoresConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriFacturasProveedoresConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriFacturasProveedoresConstantesFunciones.SCHEMA+"_"+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriFacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriFacturasProveedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriFacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriFacturasProveedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sri Facturas Proveedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sri Facturas Proveedores";
	public static final String SCLASSWEBTITULO_LOWER="Sri Facturas Proveedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SriFacturasProveedores";
	public static final String OBJECTNAME="srifacturasproveedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="sri_facturas_proveedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select srifacturasproveedores from "+SriFacturasProveedoresConstantesFunciones.SPERSISTENCENAME+" srifacturasproveedores";
	public static String QUERYSELECTNATIVE="select "+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".id,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".version_row,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".id_empresa,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".id_transaccion,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision_desde,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".identificacion,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".nombre,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".ruc,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".nombre_modulo,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".nombre_transaccion,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".codigo_asiento_contable,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".numero_factura,"+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME+".credito_mone_local from "+SriFacturasProveedoresConstantesFunciones.SCHEMA+"."+SriFacturasProveedoresConstantesFunciones.TABLENAME;//+" as "+SriFacturasProveedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String IDENTIFICACION= "identificacion";
    public static final String NOMBRE= "nombre";
    public static final String RUC= "ruc";
    public static final String NOMBREMODULO= "nombre_modulo";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String CODIGOASIENTOCONTABLE= "codigo_asiento_contable";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBREMODULO= "Nombre Modulo";
		public static final String LABEL_NOMBREMODULO_LOWER= "Nombre Modulo";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_CODIGOASIENTOCONTABLE= "Codigo Asiento Contable";
		public static final String LABEL_CODIGOASIENTOCONTABLE_LOWER= "Codigo Asiento Contable";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
	
		
		
		
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getSriFacturasProveedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.IDTRANSACCION)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.IDENTIFICACION)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.NOMBRE)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.RUC)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.NOMBREMODULO)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_NOMBREMODULO;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSriFacturasProveedoresDescripcion(SriFacturasProveedores srifacturasproveedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(srifacturasproveedores !=null/* && srifacturasproveedores.getId()!=0*/) {
			sDescripcion=srifacturasproveedores.getnombre();//srifacturasproveedoressrifacturasproveedores.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSriFacturasProveedoresDescripcionDetallado(SriFacturasProveedores srifacturasproveedores) {
		String sDescripcion="";
			
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.ID+"=";
		sDescripcion+=srifacturasproveedores.getId().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=srifacturasproveedores.getVersionRow().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=srifacturasproveedores.getid_empresa().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=srifacturasproveedores.getid_transaccion().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=srifacturasproveedores.getfecha_emision_desde().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=srifacturasproveedores.getfecha_emision_hasta().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=srifacturasproveedores.getidentificacion()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.NOMBRE+"=";
		sDescripcion+=srifacturasproveedores.getnombre()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.RUC+"=";
		sDescripcion+=srifacturasproveedores.getruc()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.NOMBREMODULO+"=";
		sDescripcion+=srifacturasproveedores.getnombre_modulo()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=srifacturasproveedores.getnombre_completo_cliente()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=srifacturasproveedores.getnombre_transaccion()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE+"=";
		sDescripcion+=srifacturasproveedores.getcodigo_asiento_contable()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=srifacturasproveedores.getfecha_emision().toString()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=srifacturasproveedores.getnumero_factura()+",";
		sDescripcion+=SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=srifacturasproveedores.getcredito_mone_local().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSriFacturasProveedoresDescripcion(SriFacturasProveedores srifacturasproveedores,String sValor) throws Exception {			
		if(srifacturasproveedores !=null) {
			srifacturasproveedores.setnombre(sValor);;//srifacturasproveedoressrifacturasproveedores.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaSriFacturasProveedores")) {
			sNombreIndice="Tipo=  Por Transaccion Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSriFacturasProveedores(Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSriFacturasProveedores(SriFacturasProveedores srifacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		srifacturasproveedores.setidentificacion(srifacturasproveedores.getidentificacion().trim());
		srifacturasproveedores.setnombre(srifacturasproveedores.getnombre().trim());
		srifacturasproveedores.setruc(srifacturasproveedores.getruc().trim());
		srifacturasproveedores.setnombre_modulo(srifacturasproveedores.getnombre_modulo().trim());
		srifacturasproveedores.setnombre_completo_cliente(srifacturasproveedores.getnombre_completo_cliente().trim());
		srifacturasproveedores.setnombre_transaccion(srifacturasproveedores.getnombre_transaccion().trim());
		srifacturasproveedores.setcodigo_asiento_contable(srifacturasproveedores.getcodigo_asiento_contable().trim());
		srifacturasproveedores.setnumero_factura(srifacturasproveedores.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosSriFacturasProveedoress(List<SriFacturasProveedores> srifacturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SriFacturasProveedores srifacturasproveedores: srifacturasproveedoress) {
			srifacturasproveedores.setidentificacion(srifacturasproveedores.getidentificacion().trim());
			srifacturasproveedores.setnombre(srifacturasproveedores.getnombre().trim());
			srifacturasproveedores.setruc(srifacturasproveedores.getruc().trim());
			srifacturasproveedores.setnombre_modulo(srifacturasproveedores.getnombre_modulo().trim());
			srifacturasproveedores.setnombre_completo_cliente(srifacturasproveedores.getnombre_completo_cliente().trim());
			srifacturasproveedores.setnombre_transaccion(srifacturasproveedores.getnombre_transaccion().trim());
			srifacturasproveedores.setcodigo_asiento_contable(srifacturasproveedores.getcodigo_asiento_contable().trim());
			srifacturasproveedores.setnumero_factura(srifacturasproveedores.getnumero_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriFacturasProveedores(SriFacturasProveedores srifacturasproveedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && srifacturasproveedores.getConCambioAuxiliar()) {
			srifacturasproveedores.setIsDeleted(srifacturasproveedores.getIsDeletedAuxiliar());	
			srifacturasproveedores.setIsNew(srifacturasproveedores.getIsNewAuxiliar());	
			srifacturasproveedores.setIsChanged(srifacturasproveedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			srifacturasproveedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			srifacturasproveedores.setIsDeletedAuxiliar(false);	
			srifacturasproveedores.setIsNewAuxiliar(false);	
			srifacturasproveedores.setIsChangedAuxiliar(false);
			
			srifacturasproveedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSriFacturasProveedoress(List<SriFacturasProveedores> srifacturasproveedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SriFacturasProveedores srifacturasproveedores : srifacturasproveedoress) {
			if(conAsignarBase && srifacturasproveedores.getConCambioAuxiliar()) {
				srifacturasproveedores.setIsDeleted(srifacturasproveedores.getIsDeletedAuxiliar());	
				srifacturasproveedores.setIsNew(srifacturasproveedores.getIsNewAuxiliar());	
				srifacturasproveedores.setIsChanged(srifacturasproveedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				srifacturasproveedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				srifacturasproveedores.setIsDeletedAuxiliar(false);	
				srifacturasproveedores.setIsNewAuxiliar(false);	
				srifacturasproveedores.setIsChangedAuxiliar(false);
				
				srifacturasproveedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSriFacturasProveedores(SriFacturasProveedores srifacturasproveedores,Boolean conEnteros) throws Exception  {
		srifacturasproveedores.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSriFacturasProveedoress(List<SriFacturasProveedores> srifacturasproveedoress,Boolean conEnteros) throws Exception  {
		
		for(SriFacturasProveedores srifacturasproveedores: srifacturasproveedoress) {
			srifacturasproveedores.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSriFacturasProveedores(List<SriFacturasProveedores> srifacturasproveedoress,SriFacturasProveedores srifacturasproveedoresAux) throws Exception  {
		SriFacturasProveedoresConstantesFunciones.InicializarValoresSriFacturasProveedores(srifacturasproveedoresAux,true);
		
		for(SriFacturasProveedores srifacturasproveedores: srifacturasproveedoress) {
			if(srifacturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			srifacturasproveedoresAux.setcredito_mone_local(srifacturasproveedoresAux.getcredito_mone_local()+srifacturasproveedores.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSriFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriFacturasProveedoresConstantesFunciones.getArrayColumnasGlobalesSriFacturasProveedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSriFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SriFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SriFacturasProveedoresConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSriFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SriFacturasProveedores> srifacturasproveedoress,SriFacturasProveedores srifacturasproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SriFacturasProveedores srifacturasproveedoresAux: srifacturasproveedoress) {
			if(srifacturasproveedoresAux!=null && srifacturasproveedores!=null) {
				if((srifacturasproveedoresAux.getId()==null && srifacturasproveedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(srifacturasproveedoresAux.getId()!=null && srifacturasproveedores.getId()!=null){
					if(srifacturasproveedoresAux.getId().equals(srifacturasproveedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSriFacturasProveedores(List<SriFacturasProveedores> srifacturasproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double credito_mone_localTotal=0.0;
	
		for(SriFacturasProveedores srifacturasproveedores: srifacturasproveedoress) {			
			if(srifacturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			credito_mone_localTotal+=srifacturasproveedores.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSriFacturasProveedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_ID, SriFacturasProveedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_VERSIONROW, SriFacturasProveedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_IDENTIFICACION, SriFacturasProveedoresConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRE, SriFacturasProveedoresConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_RUC, SriFacturasProveedoresConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_NOMBREMODULO, SriFacturasProveedoresConstantesFunciones.NOMBREMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRETRANSACCION, SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE, SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION, SriFacturasProveedoresConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA, SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL, SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSriFacturasProveedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.NOMBREMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedores() throws Exception  {
		return SriFacturasProveedoresConstantesFunciones.getTiposSeleccionarSriFacturasProveedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedores(Boolean conFk) throws Exception  {
		return SriFacturasProveedoresConstantesFunciones.getTiposSeleccionarSriFacturasProveedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSriFacturasProveedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBREMODULO);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBREMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSriFacturasProveedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSriFacturasProveedores(SriFacturasProveedores srifacturasproveedoresAux) throws Exception {
		
			srifacturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(srifacturasproveedoresAux.getEmpresa()));
			srifacturasproveedoresAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(srifacturasproveedoresAux.getTransaccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSriFacturasProveedores(List<SriFacturasProveedores> srifacturasproveedoressTemp) throws Exception {
		for(SriFacturasProveedores srifacturasproveedoresAux:srifacturasproveedoressTemp) {
			
			srifacturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(srifacturasproveedoresAux.getEmpresa()));
			srifacturasproveedoresAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(srifacturasproveedoresAux.getTransaccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSriFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSriFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriFacturasProveedoresConstantesFunciones.getClassesRelationshipsOfSriFacturasProveedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSriFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriFacturasProveedoresConstantesFunciones.getClassesRelationshipsFromStringsOfSriFacturasProveedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSriFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SriFacturasProveedores srifacturasproveedores,List<SriFacturasProveedores> srifacturasproveedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SriFacturasProveedores srifacturasproveedores,List<SriFacturasProveedores> srifacturasproveedoress) throws Exception {
		try	{			
			for(SriFacturasProveedores srifacturasproveedoresLocal:srifacturasproveedoress) {
				if(srifacturasproveedoresLocal.getId().equals(srifacturasproveedores.getId())) {
					srifacturasproveedoresLocal.setIsSelected(srifacturasproveedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSriFacturasProveedores(List<SriFacturasProveedores> srifacturasproveedoressAux) throws Exception {
		//this.srifacturasproveedoressAux=srifacturasproveedoressAux;
		
		for(SriFacturasProveedores srifacturasproveedoresAux:srifacturasproveedoressAux) {
			if(srifacturasproveedoresAux.getIsChanged()) {
				srifacturasproveedoresAux.setIsChanged(false);
			}		
			
			if(srifacturasproveedoresAux.getIsNew()) {
				srifacturasproveedoresAux.setIsNew(false);
			}	
			
			if(srifacturasproveedoresAux.getIsDeleted()) {
				srifacturasproveedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSriFacturasProveedores(SriFacturasProveedores srifacturasproveedoresAux) throws Exception {
		//this.srifacturasproveedoresAux=srifacturasproveedoresAux;
		
			if(srifacturasproveedoresAux.getIsChanged()) {
				srifacturasproveedoresAux.setIsChanged(false);
			}		
			
			if(srifacturasproveedoresAux.getIsNew()) {
				srifacturasproveedoresAux.setIsNew(false);
			}	
			
			if(srifacturasproveedoresAux.getIsDeleted()) {
				srifacturasproveedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SriFacturasProveedores srifacturasproveedoresAsignar,SriFacturasProveedores srifacturasproveedores) throws Exception {
		srifacturasproveedoresAsignar.setId(srifacturasproveedores.getId());	
		srifacturasproveedoresAsignar.setVersionRow(srifacturasproveedores.getVersionRow());	
		srifacturasproveedoresAsignar.setidentificacion(srifacturasproveedores.getidentificacion());	
		srifacturasproveedoresAsignar.setnombre(srifacturasproveedores.getnombre());	
		srifacturasproveedoresAsignar.setruc(srifacturasproveedores.getruc());	
		srifacturasproveedoresAsignar.setnombre_modulo(srifacturasproveedores.getnombre_modulo());	
		srifacturasproveedoresAsignar.setnombre_completo_cliente(srifacturasproveedores.getnombre_completo_cliente());	
		srifacturasproveedoresAsignar.setnombre_transaccion(srifacturasproveedores.getnombre_transaccion());	
		srifacturasproveedoresAsignar.setcodigo_asiento_contable(srifacturasproveedores.getcodigo_asiento_contable());	
		srifacturasproveedoresAsignar.setfecha_emision(srifacturasproveedores.getfecha_emision());	
		srifacturasproveedoresAsignar.setnumero_factura(srifacturasproveedores.getnumero_factura());	
		srifacturasproveedoresAsignar.setcredito_mone_local(srifacturasproveedores.getcredito_mone_local());	
	}
	
	public static void inicializarSriFacturasProveedores(SriFacturasProveedores srifacturasproveedores) throws Exception {
		try {
				srifacturasproveedores.setId(0L);	
					
				srifacturasproveedores.setidentificacion("");	
				srifacturasproveedores.setnombre("");	
				srifacturasproveedores.setruc("");	
				srifacturasproveedores.setnombre_modulo("");	
				srifacturasproveedores.setnombre_completo_cliente("");	
				srifacturasproveedores.setnombre_transaccion("");	
				srifacturasproveedores.setcodigo_asiento_contable("");	
				srifacturasproveedores.setfecha_emision(new Date());	
				srifacturasproveedores.setnumero_factura("");	
				srifacturasproveedores.setcredito_mone_local(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSriFacturasProveedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBREMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriFacturasProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSriFacturasProveedores(String sTipo,Row row,Workbook workbook,SriFacturasProveedores srifacturasproveedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getnombre_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getcodigo_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(srifacturasproveedores.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySriFacturasProveedores="";
	
	public String getsFinalQuerySriFacturasProveedores() {
		return this.sFinalQuerySriFacturasProveedores;
	}
	
	public void setsFinalQuerySriFacturasProveedores(String sFinalQuerySriFacturasProveedores) {
		this.sFinalQuerySriFacturasProveedores= sFinalQuerySriFacturasProveedores;
	}
	
	public Border resaltarSeleccionarSriFacturasProveedores=null;
	
	public Border setResaltarSeleccionarSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSriFacturasProveedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSriFacturasProveedores() {
		return this.resaltarSeleccionarSriFacturasProveedores;
	}
	
	public void setResaltarSeleccionarSriFacturasProveedores(Border borderResaltarSeleccionarSriFacturasProveedores) {
		this.resaltarSeleccionarSriFacturasProveedores= borderResaltarSeleccionarSriFacturasProveedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSriFacturasProveedores=null;
	public Boolean mostraridSriFacturasProveedores=true;
	public Boolean activaridSriFacturasProveedores=true;

	public Border resaltarid_empresaSriFacturasProveedores=null;
	public Boolean mostrarid_empresaSriFacturasProveedores=true;
	public Boolean activarid_empresaSriFacturasProveedores=true;
	public Boolean cargarid_empresaSriFacturasProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSriFacturasProveedores=false;//ConEventDepend=true

	public Border resaltarid_transaccionSriFacturasProveedores=null;
	public Boolean mostrarid_transaccionSriFacturasProveedores=true;
	public Boolean activarid_transaccionSriFacturasProveedores=true;
	public Boolean cargarid_transaccionSriFacturasProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionSriFacturasProveedores=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeSriFacturasProveedores=null;
	public Boolean mostrarfecha_emision_desdeSriFacturasProveedores=true;
	public Boolean activarfecha_emision_desdeSriFacturasProveedores=true;

	public Border resaltarfecha_emision_hastaSriFacturasProveedores=null;
	public Boolean mostrarfecha_emision_hastaSriFacturasProveedores=true;
	public Boolean activarfecha_emision_hastaSriFacturasProveedores=true;

	public Border resaltaridentificacionSriFacturasProveedores=null;
	public Boolean mostraridentificacionSriFacturasProveedores=true;
	public Boolean activaridentificacionSriFacturasProveedores=true;

	public Border resaltarnombreSriFacturasProveedores=null;
	public Boolean mostrarnombreSriFacturasProveedores=true;
	public Boolean activarnombreSriFacturasProveedores=true;

	public Border resaltarrucSriFacturasProveedores=null;
	public Boolean mostrarrucSriFacturasProveedores=true;
	public Boolean activarrucSriFacturasProveedores=true;

	public Border resaltarnombre_moduloSriFacturasProveedores=null;
	public Boolean mostrarnombre_moduloSriFacturasProveedores=true;
	public Boolean activarnombre_moduloSriFacturasProveedores=true;

	public Border resaltarnombre_completo_clienteSriFacturasProveedores=null;
	public Boolean mostrarnombre_completo_clienteSriFacturasProveedores=true;
	public Boolean activarnombre_completo_clienteSriFacturasProveedores=true;

	public Border resaltarnombre_transaccionSriFacturasProveedores=null;
	public Boolean mostrarnombre_transaccionSriFacturasProveedores=true;
	public Boolean activarnombre_transaccionSriFacturasProveedores=true;

	public Border resaltarcodigo_asiento_contableSriFacturasProveedores=null;
	public Boolean mostrarcodigo_asiento_contableSriFacturasProveedores=true;
	public Boolean activarcodigo_asiento_contableSriFacturasProveedores=true;

	public Border resaltarfecha_emisionSriFacturasProveedores=null;
	public Boolean mostrarfecha_emisionSriFacturasProveedores=true;
	public Boolean activarfecha_emisionSriFacturasProveedores=true;

	public Border resaltarnumero_facturaSriFacturasProveedores=null;
	public Boolean mostrarnumero_facturaSriFacturasProveedores=true;
	public Boolean activarnumero_facturaSriFacturasProveedores=true;

	public Border resaltarcredito_mone_localSriFacturasProveedores=null;
	public Boolean mostrarcredito_mone_localSriFacturasProveedores=true;
	public Boolean activarcredito_mone_localSriFacturasProveedores=true;

	
	

	public Border setResaltaridSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltaridSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSriFacturasProveedores() {
		return this.resaltaridSriFacturasProveedores;
	}

	public void setResaltaridSriFacturasProveedores(Border borderResaltar) {
		this.resaltaridSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostraridSriFacturasProveedores() {
		return this.mostraridSriFacturasProveedores;
	}

	public void setMostraridSriFacturasProveedores(Boolean mostraridSriFacturasProveedores) {
		this.mostraridSriFacturasProveedores= mostraridSriFacturasProveedores;
	}

	public Boolean getActivaridSriFacturasProveedores() {
		return this.activaridSriFacturasProveedores;
	}

	public void setActivaridSriFacturasProveedores(Boolean activaridSriFacturasProveedores) {
		this.activaridSriFacturasProveedores= activaridSriFacturasProveedores;
	}

	public Border setResaltarid_empresaSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSriFacturasProveedores() {
		return this.resaltarid_empresaSriFacturasProveedores;
	}

	public void setResaltarid_empresaSriFacturasProveedores(Border borderResaltar) {
		this.resaltarid_empresaSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaSriFacturasProveedores() {
		return this.mostrarid_empresaSriFacturasProveedores;
	}

	public void setMostrarid_empresaSriFacturasProveedores(Boolean mostrarid_empresaSriFacturasProveedores) {
		this.mostrarid_empresaSriFacturasProveedores= mostrarid_empresaSriFacturasProveedores;
	}

	public Boolean getActivarid_empresaSriFacturasProveedores() {
		return this.activarid_empresaSriFacturasProveedores;
	}

	public void setActivarid_empresaSriFacturasProveedores(Boolean activarid_empresaSriFacturasProveedores) {
		this.activarid_empresaSriFacturasProveedores= activarid_empresaSriFacturasProveedores;
	}

	public Boolean getCargarid_empresaSriFacturasProveedores() {
		return this.cargarid_empresaSriFacturasProveedores;
	}

	public void setCargarid_empresaSriFacturasProveedores(Boolean cargarid_empresaSriFacturasProveedores) {
		this.cargarid_empresaSriFacturasProveedores= cargarid_empresaSriFacturasProveedores;
	}

	public Border setResaltarid_transaccionSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarid_transaccionSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionSriFacturasProveedores() {
		return this.resaltarid_transaccionSriFacturasProveedores;
	}

	public void setResaltarid_transaccionSriFacturasProveedores(Border borderResaltar) {
		this.resaltarid_transaccionSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarid_transaccionSriFacturasProveedores() {
		return this.mostrarid_transaccionSriFacturasProveedores;
	}

	public void setMostrarid_transaccionSriFacturasProveedores(Boolean mostrarid_transaccionSriFacturasProveedores) {
		this.mostrarid_transaccionSriFacturasProveedores= mostrarid_transaccionSriFacturasProveedores;
	}

	public Boolean getActivarid_transaccionSriFacturasProveedores() {
		return this.activarid_transaccionSriFacturasProveedores;
	}

	public void setActivarid_transaccionSriFacturasProveedores(Boolean activarid_transaccionSriFacturasProveedores) {
		this.activarid_transaccionSriFacturasProveedores= activarid_transaccionSriFacturasProveedores;
	}

	public Boolean getCargarid_transaccionSriFacturasProveedores() {
		return this.cargarid_transaccionSriFacturasProveedores;
	}

	public void setCargarid_transaccionSriFacturasProveedores(Boolean cargarid_transaccionSriFacturasProveedores) {
		this.cargarid_transaccionSriFacturasProveedores= cargarid_transaccionSriFacturasProveedores;
	}

	public Border setResaltarfecha_emision_desdeSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeSriFacturasProveedores() {
		return this.resaltarfecha_emision_desdeSriFacturasProveedores;
	}

	public void setResaltarfecha_emision_desdeSriFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emision_desdeSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeSriFacturasProveedores() {
		return this.mostrarfecha_emision_desdeSriFacturasProveedores;
	}

	public void setMostrarfecha_emision_desdeSriFacturasProveedores(Boolean mostrarfecha_emision_desdeSriFacturasProveedores) {
		this.mostrarfecha_emision_desdeSriFacturasProveedores= mostrarfecha_emision_desdeSriFacturasProveedores;
	}

	public Boolean getActivarfecha_emision_desdeSriFacturasProveedores() {
		return this.activarfecha_emision_desdeSriFacturasProveedores;
	}

	public void setActivarfecha_emision_desdeSriFacturasProveedores(Boolean activarfecha_emision_desdeSriFacturasProveedores) {
		this.activarfecha_emision_desdeSriFacturasProveedores= activarfecha_emision_desdeSriFacturasProveedores;
	}

	public Border setResaltarfecha_emision_hastaSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaSriFacturasProveedores() {
		return this.resaltarfecha_emision_hastaSriFacturasProveedores;
	}

	public void setResaltarfecha_emision_hastaSriFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emision_hastaSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaSriFacturasProveedores() {
		return this.mostrarfecha_emision_hastaSriFacturasProveedores;
	}

	public void setMostrarfecha_emision_hastaSriFacturasProveedores(Boolean mostrarfecha_emision_hastaSriFacturasProveedores) {
		this.mostrarfecha_emision_hastaSriFacturasProveedores= mostrarfecha_emision_hastaSriFacturasProveedores;
	}

	public Boolean getActivarfecha_emision_hastaSriFacturasProveedores() {
		return this.activarfecha_emision_hastaSriFacturasProveedores;
	}

	public void setActivarfecha_emision_hastaSriFacturasProveedores(Boolean activarfecha_emision_hastaSriFacturasProveedores) {
		this.activarfecha_emision_hastaSriFacturasProveedores= activarfecha_emision_hastaSriFacturasProveedores;
	}

	public Border setResaltaridentificacionSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltaridentificacionSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionSriFacturasProveedores() {
		return this.resaltaridentificacionSriFacturasProveedores;
	}

	public void setResaltaridentificacionSriFacturasProveedores(Border borderResaltar) {
		this.resaltaridentificacionSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostraridentificacionSriFacturasProveedores() {
		return this.mostraridentificacionSriFacturasProveedores;
	}

	public void setMostraridentificacionSriFacturasProveedores(Boolean mostraridentificacionSriFacturasProveedores) {
		this.mostraridentificacionSriFacturasProveedores= mostraridentificacionSriFacturasProveedores;
	}

	public Boolean getActivaridentificacionSriFacturasProveedores() {
		return this.activaridentificacionSriFacturasProveedores;
	}

	public void setActivaridentificacionSriFacturasProveedores(Boolean activaridentificacionSriFacturasProveedores) {
		this.activaridentificacionSriFacturasProveedores= activaridentificacionSriFacturasProveedores;
	}

	public Border setResaltarnombreSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombreSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSriFacturasProveedores() {
		return this.resaltarnombreSriFacturasProveedores;
	}

	public void setResaltarnombreSriFacturasProveedores(Border borderResaltar) {
		this.resaltarnombreSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombreSriFacturasProveedores() {
		return this.mostrarnombreSriFacturasProveedores;
	}

	public void setMostrarnombreSriFacturasProveedores(Boolean mostrarnombreSriFacturasProveedores) {
		this.mostrarnombreSriFacturasProveedores= mostrarnombreSriFacturasProveedores;
	}

	public Boolean getActivarnombreSriFacturasProveedores() {
		return this.activarnombreSriFacturasProveedores;
	}

	public void setActivarnombreSriFacturasProveedores(Boolean activarnombreSriFacturasProveedores) {
		this.activarnombreSriFacturasProveedores= activarnombreSriFacturasProveedores;
	}

	public Border setResaltarrucSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarrucSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSriFacturasProveedores() {
		return this.resaltarrucSriFacturasProveedores;
	}

	public void setResaltarrucSriFacturasProveedores(Border borderResaltar) {
		this.resaltarrucSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarrucSriFacturasProveedores() {
		return this.mostrarrucSriFacturasProveedores;
	}

	public void setMostrarrucSriFacturasProveedores(Boolean mostrarrucSriFacturasProveedores) {
		this.mostrarrucSriFacturasProveedores= mostrarrucSriFacturasProveedores;
	}

	public Boolean getActivarrucSriFacturasProveedores() {
		return this.activarrucSriFacturasProveedores;
	}

	public void setActivarrucSriFacturasProveedores(Boolean activarrucSriFacturasProveedores) {
		this.activarrucSriFacturasProveedores= activarrucSriFacturasProveedores;
	}

	public Border setResaltarnombre_moduloSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_moduloSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_moduloSriFacturasProveedores() {
		return this.resaltarnombre_moduloSriFacturasProveedores;
	}

	public void setResaltarnombre_moduloSriFacturasProveedores(Border borderResaltar) {
		this.resaltarnombre_moduloSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_moduloSriFacturasProveedores() {
		return this.mostrarnombre_moduloSriFacturasProveedores;
	}

	public void setMostrarnombre_moduloSriFacturasProveedores(Boolean mostrarnombre_moduloSriFacturasProveedores) {
		this.mostrarnombre_moduloSriFacturasProveedores= mostrarnombre_moduloSriFacturasProveedores;
	}

	public Boolean getActivarnombre_moduloSriFacturasProveedores() {
		return this.activarnombre_moduloSriFacturasProveedores;
	}

	public void setActivarnombre_moduloSriFacturasProveedores(Boolean activarnombre_moduloSriFacturasProveedores) {
		this.activarnombre_moduloSriFacturasProveedores= activarnombre_moduloSriFacturasProveedores;
	}

	public Border setResaltarnombre_completo_clienteSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteSriFacturasProveedores() {
		return this.resaltarnombre_completo_clienteSriFacturasProveedores;
	}

	public void setResaltarnombre_completo_clienteSriFacturasProveedores(Border borderResaltar) {
		this.resaltarnombre_completo_clienteSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteSriFacturasProveedores() {
		return this.mostrarnombre_completo_clienteSriFacturasProveedores;
	}

	public void setMostrarnombre_completo_clienteSriFacturasProveedores(Boolean mostrarnombre_completo_clienteSriFacturasProveedores) {
		this.mostrarnombre_completo_clienteSriFacturasProveedores= mostrarnombre_completo_clienteSriFacturasProveedores;
	}

	public Boolean getActivarnombre_completo_clienteSriFacturasProveedores() {
		return this.activarnombre_completo_clienteSriFacturasProveedores;
	}

	public void setActivarnombre_completo_clienteSriFacturasProveedores(Boolean activarnombre_completo_clienteSriFacturasProveedores) {
		this.activarnombre_completo_clienteSriFacturasProveedores= activarnombre_completo_clienteSriFacturasProveedores;
	}

	public Border setResaltarnombre_transaccionSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionSriFacturasProveedores() {
		return this.resaltarnombre_transaccionSriFacturasProveedores;
	}

	public void setResaltarnombre_transaccionSriFacturasProveedores(Border borderResaltar) {
		this.resaltarnombre_transaccionSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionSriFacturasProveedores() {
		return this.mostrarnombre_transaccionSriFacturasProveedores;
	}

	public void setMostrarnombre_transaccionSriFacturasProveedores(Boolean mostrarnombre_transaccionSriFacturasProveedores) {
		this.mostrarnombre_transaccionSriFacturasProveedores= mostrarnombre_transaccionSriFacturasProveedores;
	}

	public Boolean getActivarnombre_transaccionSriFacturasProveedores() {
		return this.activarnombre_transaccionSriFacturasProveedores;
	}

	public void setActivarnombre_transaccionSriFacturasProveedores(Boolean activarnombre_transaccionSriFacturasProveedores) {
		this.activarnombre_transaccionSriFacturasProveedores= activarnombre_transaccionSriFacturasProveedores;
	}

	public Border setResaltarcodigo_asiento_contableSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarcodigo_asiento_contableSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asiento_contableSriFacturasProveedores() {
		return this.resaltarcodigo_asiento_contableSriFacturasProveedores;
	}

	public void setResaltarcodigo_asiento_contableSriFacturasProveedores(Border borderResaltar) {
		this.resaltarcodigo_asiento_contableSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarcodigo_asiento_contableSriFacturasProveedores() {
		return this.mostrarcodigo_asiento_contableSriFacturasProveedores;
	}

	public void setMostrarcodigo_asiento_contableSriFacturasProveedores(Boolean mostrarcodigo_asiento_contableSriFacturasProveedores) {
		this.mostrarcodigo_asiento_contableSriFacturasProveedores= mostrarcodigo_asiento_contableSriFacturasProveedores;
	}

	public Boolean getActivarcodigo_asiento_contableSriFacturasProveedores() {
		return this.activarcodigo_asiento_contableSriFacturasProveedores;
	}

	public void setActivarcodigo_asiento_contableSriFacturasProveedores(Boolean activarcodigo_asiento_contableSriFacturasProveedores) {
		this.activarcodigo_asiento_contableSriFacturasProveedores= activarcodigo_asiento_contableSriFacturasProveedores;
	}

	public Border setResaltarfecha_emisionSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSriFacturasProveedores() {
		return this.resaltarfecha_emisionSriFacturasProveedores;
	}

	public void setResaltarfecha_emisionSriFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emisionSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSriFacturasProveedores() {
		return this.mostrarfecha_emisionSriFacturasProveedores;
	}

	public void setMostrarfecha_emisionSriFacturasProveedores(Boolean mostrarfecha_emisionSriFacturasProveedores) {
		this.mostrarfecha_emisionSriFacturasProveedores= mostrarfecha_emisionSriFacturasProveedores;
	}

	public Boolean getActivarfecha_emisionSriFacturasProveedores() {
		return this.activarfecha_emisionSriFacturasProveedores;
	}

	public void setActivarfecha_emisionSriFacturasProveedores(Boolean activarfecha_emisionSriFacturasProveedores) {
		this.activarfecha_emisionSriFacturasProveedores= activarfecha_emisionSriFacturasProveedores;
	}

	public Border setResaltarnumero_facturaSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaSriFacturasProveedores() {
		return this.resaltarnumero_facturaSriFacturasProveedores;
	}

	public void setResaltarnumero_facturaSriFacturasProveedores(Border borderResaltar) {
		this.resaltarnumero_facturaSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaSriFacturasProveedores() {
		return this.mostrarnumero_facturaSriFacturasProveedores;
	}

	public void setMostrarnumero_facturaSriFacturasProveedores(Boolean mostrarnumero_facturaSriFacturasProveedores) {
		this.mostrarnumero_facturaSriFacturasProveedores= mostrarnumero_facturaSriFacturasProveedores;
	}

	public Boolean getActivarnumero_facturaSriFacturasProveedores() {
		return this.activarnumero_facturaSriFacturasProveedores;
	}

	public void setActivarnumero_facturaSriFacturasProveedores(Boolean activarnumero_facturaSriFacturasProveedores) {
		this.activarnumero_facturaSriFacturasProveedores= activarnumero_facturaSriFacturasProveedores;
	}

	public Border setResaltarcredito_mone_localSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//srifacturasproveedoresBeanSwingJInternalFrame.jTtoolBarSriFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localSriFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localSriFacturasProveedores() {
		return this.resaltarcredito_mone_localSriFacturasProveedores;
	}

	public void setResaltarcredito_mone_localSriFacturasProveedores(Border borderResaltar) {
		this.resaltarcredito_mone_localSriFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localSriFacturasProveedores() {
		return this.mostrarcredito_mone_localSriFacturasProveedores;
	}

	public void setMostrarcredito_mone_localSriFacturasProveedores(Boolean mostrarcredito_mone_localSriFacturasProveedores) {
		this.mostrarcredito_mone_localSriFacturasProveedores= mostrarcredito_mone_localSriFacturasProveedores;
	}

	public Boolean getActivarcredito_mone_localSriFacturasProveedores() {
		return this.activarcredito_mone_localSriFacturasProveedores;
	}

	public void setActivarcredito_mone_localSriFacturasProveedores(Boolean activarcredito_mone_localSriFacturasProveedores) {
		this.activarcredito_mone_localSriFacturasProveedores= activarcredito_mone_localSriFacturasProveedores;
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
		
		
		this.setMostraridSriFacturasProveedores(esInicial);
		this.setMostrarid_empresaSriFacturasProveedores(esInicial);
		this.setMostrarid_transaccionSriFacturasProveedores(esInicial);
		this.setMostrarfecha_emision_desdeSriFacturasProveedores(esInicial);
		this.setMostrarfecha_emision_hastaSriFacturasProveedores(esInicial);
		this.setMostraridentificacionSriFacturasProveedores(esInicial);
		this.setMostrarnombreSriFacturasProveedores(esInicial);
		this.setMostrarrucSriFacturasProveedores(esInicial);
		this.setMostrarnombre_moduloSriFacturasProveedores(esInicial);
		this.setMostrarnombre_completo_clienteSriFacturasProveedores(esInicial);
		this.setMostrarnombre_transaccionSriFacturasProveedores(esInicial);
		this.setMostrarcodigo_asiento_contableSriFacturasProveedores(esInicial);
		this.setMostrarfecha_emisionSriFacturasProveedores(esInicial);
		this.setMostrarnumero_facturaSriFacturasProveedores(esInicial);
		this.setMostrarcredito_mone_localSriFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.ID)) {
				this.setMostraridSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.RUC)) {
				this.setMostrarrucSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBREMODULO)) {
				this.setMostrarnombre_moduloSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setMostrarcodigo_asiento_contableSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localSriFacturasProveedores(esAsigna);
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
		
		
		this.setActivaridSriFacturasProveedores(esInicial);
		this.setActivarid_empresaSriFacturasProveedores(esInicial);
		this.setActivarid_transaccionSriFacturasProveedores(esInicial);
		this.setActivarfecha_emision_desdeSriFacturasProveedores(esInicial);
		this.setActivarfecha_emision_hastaSriFacturasProveedores(esInicial);
		this.setActivaridentificacionSriFacturasProveedores(esInicial);
		this.setActivarnombreSriFacturasProveedores(esInicial);
		this.setActivarrucSriFacturasProveedores(esInicial);
		this.setActivarnombre_moduloSriFacturasProveedores(esInicial);
		this.setActivarnombre_completo_clienteSriFacturasProveedores(esInicial);
		this.setActivarnombre_transaccionSriFacturasProveedores(esInicial);
		this.setActivarcodigo_asiento_contableSriFacturasProveedores(esInicial);
		this.setActivarfecha_emisionSriFacturasProveedores(esInicial);
		this.setActivarnumero_facturaSriFacturasProveedores(esInicial);
		this.setActivarcredito_mone_localSriFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.ID)) {
				this.setActivaridSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.RUC)) {
				this.setActivarrucSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBREMODULO)) {
				this.setActivarnombre_moduloSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setActivarcodigo_asiento_contableSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localSriFacturasProveedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSriFacturasProveedores(esInicial);
		this.setResaltarid_empresaSriFacturasProveedores(esInicial);
		this.setResaltarid_transaccionSriFacturasProveedores(esInicial);
		this.setResaltarfecha_emision_desdeSriFacturasProveedores(esInicial);
		this.setResaltarfecha_emision_hastaSriFacturasProveedores(esInicial);
		this.setResaltaridentificacionSriFacturasProveedores(esInicial);
		this.setResaltarnombreSriFacturasProveedores(esInicial);
		this.setResaltarrucSriFacturasProveedores(esInicial);
		this.setResaltarnombre_moduloSriFacturasProveedores(esInicial);
		this.setResaltarnombre_completo_clienteSriFacturasProveedores(esInicial);
		this.setResaltarnombre_transaccionSriFacturasProveedores(esInicial);
		this.setResaltarcodigo_asiento_contableSriFacturasProveedores(esInicial);
		this.setResaltarfecha_emisionSriFacturasProveedores(esInicial);
		this.setResaltarnumero_facturaSriFacturasProveedores(esInicial);
		this.setResaltarcredito_mone_localSriFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.ID)) {
				this.setResaltaridSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.RUC)) {
				this.setResaltarrucSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBREMODULO)) {
				this.setResaltarnombre_moduloSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setResaltarcodigo_asiento_contableSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaSriFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriFacturasProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localSriFacturasProveedores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSriFacturasProveedoresSriFacturasProveedores=true;

	public Boolean getMostrarBusquedaSriFacturasProveedoresSriFacturasProveedores() {
		return this.mostrarBusquedaSriFacturasProveedoresSriFacturasProveedores;
	}

	public void setMostrarBusquedaSriFacturasProveedoresSriFacturasProveedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSriFacturasProveedoresSriFacturasProveedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSriFacturasProveedoresSriFacturasProveedores=true;

	public Boolean getActivarBusquedaSriFacturasProveedoresSriFacturasProveedores() {
		return this.activarBusquedaSriFacturasProveedoresSriFacturasProveedores;
	}

	public void setActivarBusquedaSriFacturasProveedoresSriFacturasProveedores(Boolean habilitarResaltar) {
		this.activarBusquedaSriFacturasProveedoresSriFacturasProveedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSriFacturasProveedoresSriFacturasProveedores=null;

	public Border getResaltarBusquedaSriFacturasProveedoresSriFacturasProveedores() {
		return this.resaltarBusquedaSriFacturasProveedoresSriFacturasProveedores;
	}

	public void setResaltarBusquedaSriFacturasProveedoresSriFacturasProveedores(Border borderResaltar) {
		this.resaltarBusquedaSriFacturasProveedoresSriFacturasProveedores= borderResaltar;
	}

	public void setResaltarBusquedaSriFacturasProveedoresSriFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SriFacturasProveedoresBeanSwingJInternalFrame srifacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSriFacturasProveedoresSriFacturasProveedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}