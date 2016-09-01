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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.ControlProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.report.ControlProveedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.ControlProveedoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ControlProveedoresConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ControlProveedores";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ControlProveedores"+ControlProveedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ControlProveedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ControlProveedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ControlProveedoresConstantesFunciones.SCHEMA+"_"+ControlProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ControlProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ControlProveedoresConstantesFunciones.SCHEMA+"_"+ControlProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ControlProveedoresConstantesFunciones.SCHEMA+"_"+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ControlProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ControlProveedoresConstantesFunciones.SCHEMA+"_"+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ControlProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ControlProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ControlProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ControlProveedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ControlProveedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ControlProveedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ControlProveedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Control Proveedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Control Proveedores";
	public static final String SCLASSWEBTITULO_LOWER="Control Proveedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ControlProveedores";
	public static final String OBJECTNAME="controlproveedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="control_proveedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select controlproveedores from "+ControlProveedoresConstantesFunciones.SPERSISTENCENAME+" controlproveedores";
	public static String QUERYSELECTNATIVE="select "+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".id,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".version_row,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".id_empresa,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".nombre_zona,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".nombre_ciudad,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".codigo,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".nombre_cliente,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".ruc,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".telefonos,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".direcciones,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".emails,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".numero_factura,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".fecha_emision,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".fecha_venta,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".saldo,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".debito_mone_local,"+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME+".credito_mone_local from "+ControlProveedoresConstantesFunciones.SCHEMA+"."+ControlProveedoresConstantesFunciones.TABLENAME;//+" as "+ControlProveedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String RUC= "ruc";
    public static final String TELEFONOS= "telefonos";
    public static final String DIRECCIONES= "direcciones";
    public static final String EMAILS= "emails";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String SALDO= "saldo";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha  Emisionhasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_TELEFONOS= "Telefonos";
		public static final String LABEL_TELEFONOS_LOWER= "Telefonos";
    	public static final String LABEL_DIRECCIONES= "Direcciones";
		public static final String LABEL_DIRECCIONES_LOWER= "Direcciones";
    	public static final String LABEL_EMAILS= "Emails";
		public static final String LABEL_EMAILS_LOWER= "Emails";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
	
		
		
		
		
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCIONES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCIONES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAILS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAILS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getControlProveedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.NOMBREZONA)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.CODIGO)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.RUC)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.TELEFONOS)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_TELEFONOS;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.DIRECCIONES)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_DIRECCIONES;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.EMAILS)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_EMAILS;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.FECHAEMISION)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.FECHAVENTA)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.SALDO)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getControlProveedoresDescripcion(ControlProveedores controlproveedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(controlproveedores !=null/* && controlproveedores.getId()!=0*/) {
			sDescripcion=controlproveedores.getcodigo();//controlproveedorescontrolproveedores.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getControlProveedoresDescripcionDetallado(ControlProveedores controlproveedores) {
		String sDescripcion="";
			
		sDescripcion+=ControlProveedoresConstantesFunciones.ID+"=";
		sDescripcion+=controlproveedores.getId().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=controlproveedores.getVersionRow().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=controlproveedores.getid_empresa().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=controlproveedores.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=controlproveedores.getnombre_zona()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=controlproveedores.getnombre_ciudad()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=controlproveedores.getnombre_grupo_cliente()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.CODIGO+"=";
		sDescripcion+=controlproveedores.getcodigo()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=controlproveedores.getnombre_cliente()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.RUC+"=";
		sDescripcion+=controlproveedores.getruc()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.TELEFONOS+"=";
		sDescripcion+=controlproveedores.gettelefonos()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.DIRECCIONES+"=";
		sDescripcion+=controlproveedores.getdirecciones()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.EMAILS+"=";
		sDescripcion+=controlproveedores.getemails()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=controlproveedores.getnumero_factura()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=controlproveedores.getfecha_emision().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=controlproveedores.getfecha_venta().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.SALDO+"=";
		sDescripcion+=controlproveedores.getsaldo().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=controlproveedores.getdebito_mone_local().toString()+",";
		sDescripcion+=ControlProveedoresConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=controlproveedores.getcredito_mone_local().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setControlProveedoresDescripcion(ControlProveedores controlproveedores,String sValor) throws Exception {			
		if(controlproveedores !=null) {
			controlproveedores.setcodigo(sValor);;//controlproveedorescontrolproveedores.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaControlProveedores")) {
			sNombreIndice="Tipo=  Por Fecha  Emisionhasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaControlProveedores(Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha  Emisionhasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosControlProveedores(ControlProveedores controlproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		controlproveedores.setnombre_zona(controlproveedores.getnombre_zona().trim());
		controlproveedores.setnombre_ciudad(controlproveedores.getnombre_ciudad().trim());
		controlproveedores.setnombre_grupo_cliente(controlproveedores.getnombre_grupo_cliente().trim());
		controlproveedores.setcodigo(controlproveedores.getcodigo().trim());
		controlproveedores.setnombre_cliente(controlproveedores.getnombre_cliente().trim());
		controlproveedores.setruc(controlproveedores.getruc().trim());
		controlproveedores.settelefonos(controlproveedores.gettelefonos().trim());
		controlproveedores.setdirecciones(controlproveedores.getdirecciones().trim());
		controlproveedores.setemails(controlproveedores.getemails().trim());
		controlproveedores.setnumero_factura(controlproveedores.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosControlProveedoress(List<ControlProveedores> controlproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ControlProveedores controlproveedores: controlproveedoress) {
			controlproveedores.setnombre_zona(controlproveedores.getnombre_zona().trim());
			controlproveedores.setnombre_ciudad(controlproveedores.getnombre_ciudad().trim());
			controlproveedores.setnombre_grupo_cliente(controlproveedores.getnombre_grupo_cliente().trim());
			controlproveedores.setcodigo(controlproveedores.getcodigo().trim());
			controlproveedores.setnombre_cliente(controlproveedores.getnombre_cliente().trim());
			controlproveedores.setruc(controlproveedores.getruc().trim());
			controlproveedores.settelefonos(controlproveedores.gettelefonos().trim());
			controlproveedores.setdirecciones(controlproveedores.getdirecciones().trim());
			controlproveedores.setemails(controlproveedores.getemails().trim());
			controlproveedores.setnumero_factura(controlproveedores.getnumero_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresControlProveedores(ControlProveedores controlproveedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && controlproveedores.getConCambioAuxiliar()) {
			controlproveedores.setIsDeleted(controlproveedores.getIsDeletedAuxiliar());	
			controlproveedores.setIsNew(controlproveedores.getIsNewAuxiliar());	
			controlproveedores.setIsChanged(controlproveedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			controlproveedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			controlproveedores.setIsDeletedAuxiliar(false);	
			controlproveedores.setIsNewAuxiliar(false);	
			controlproveedores.setIsChangedAuxiliar(false);
			
			controlproveedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresControlProveedoress(List<ControlProveedores> controlproveedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ControlProveedores controlproveedores : controlproveedoress) {
			if(conAsignarBase && controlproveedores.getConCambioAuxiliar()) {
				controlproveedores.setIsDeleted(controlproveedores.getIsDeletedAuxiliar());	
				controlproveedores.setIsNew(controlproveedores.getIsNewAuxiliar());	
				controlproveedores.setIsChanged(controlproveedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				controlproveedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				controlproveedores.setIsDeletedAuxiliar(false);	
				controlproveedores.setIsNewAuxiliar(false);	
				controlproveedores.setIsChangedAuxiliar(false);
				
				controlproveedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresControlProveedores(ControlProveedores controlproveedores,Boolean conEnteros) throws Exception  {
		controlproveedores.setsaldo(0.0);
		controlproveedores.setdebito_mone_local(0.0);
		controlproveedores.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresControlProveedoress(List<ControlProveedores> controlproveedoress,Boolean conEnteros) throws Exception  {
		
		for(ControlProveedores controlproveedores: controlproveedoress) {
			controlproveedores.setsaldo(0.0);
			controlproveedores.setdebito_mone_local(0.0);
			controlproveedores.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaControlProveedores(List<ControlProveedores> controlproveedoress,ControlProveedores controlproveedoresAux) throws Exception  {
		ControlProveedoresConstantesFunciones.InicializarValoresControlProveedores(controlproveedoresAux,true);
		
		for(ControlProveedores controlproveedores: controlproveedoress) {
			if(controlproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			controlproveedoresAux.setsaldo(controlproveedoresAux.getsaldo()+controlproveedores.getsaldo());			
			controlproveedoresAux.setdebito_mone_local(controlproveedoresAux.getdebito_mone_local()+controlproveedores.getdebito_mone_local());			
			controlproveedoresAux.setcredito_mone_local(controlproveedoresAux.getcredito_mone_local()+controlproveedores.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesControlProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ControlProveedoresConstantesFunciones.getArrayColumnasGlobalesControlProveedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesControlProveedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ControlProveedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ControlProveedoresConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoControlProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ControlProveedores> controlproveedoress,ControlProveedores controlproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ControlProveedores controlproveedoresAux: controlproveedoress) {
			if(controlproveedoresAux!=null && controlproveedores!=null) {
				if((controlproveedoresAux.getId()==null && controlproveedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(controlproveedoresAux.getId()!=null && controlproveedores.getId()!=null){
					if(controlproveedoresAux.getId().equals(controlproveedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaControlProveedores(List<ControlProveedores> controlproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(ControlProveedores controlproveedores: controlproveedoress) {			
			if(controlproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=controlproveedores.getsaldo();
			debito_mone_localTotal+=controlproveedores.getdebito_mone_local();
			credito_mone_localTotal+=controlproveedores.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaControlProveedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_ID, ControlProveedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_VERSIONROW, ControlProveedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_NOMBREZONA, ControlProveedoresConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_NOMBRECIUDAD, ControlProveedoresConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_CODIGO, ControlProveedoresConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE, ControlProveedoresConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_RUC, ControlProveedoresConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_TELEFONOS, ControlProveedoresConstantesFunciones.TELEFONOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_DIRECCIONES, ControlProveedoresConstantesFunciones.DIRECCIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_EMAILS, ControlProveedoresConstantesFunciones.EMAILS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_NUMEROFACTURA, ControlProveedoresConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_FECHAEMISION, ControlProveedoresConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_FECHAVENTA, ControlProveedoresConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_SALDO, ControlProveedoresConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL, ControlProveedoresConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL, ControlProveedoresConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasControlProveedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.TELEFONOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.DIRECCIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.EMAILS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ControlProveedoresConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlProveedores() throws Exception  {
		return ControlProveedoresConstantesFunciones.getTiposSeleccionarControlProveedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlProveedores(Boolean conFk) throws Exception  {
		return ControlProveedoresConstantesFunciones.getTiposSeleccionarControlProveedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarControlProveedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_TELEFONOS);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_TELEFONOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_DIRECCIONES);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_DIRECCIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_EMAILS);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_EMAILS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesControlProveedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesControlProveedores(ControlProveedores controlproveedoresAux) throws Exception {
		
			controlproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(controlproveedoresAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesControlProveedores(List<ControlProveedores> controlproveedoressTemp) throws Exception {
		for(ControlProveedores controlproveedoresAux:controlproveedoressTemp) {
			
			controlproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(controlproveedoresAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfControlProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfControlProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfControlProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ControlProveedoresConstantesFunciones.getClassesRelationshipsOfControlProveedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfControlProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfControlProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ControlProveedoresConstantesFunciones.getClassesRelationshipsFromStringsOfControlProveedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfControlProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ControlProveedores controlproveedores,List<ControlProveedores> controlproveedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ControlProveedores controlproveedores,List<ControlProveedores> controlproveedoress) throws Exception {
		try	{			
			for(ControlProveedores controlproveedoresLocal:controlproveedoress) {
				if(controlproveedoresLocal.getId().equals(controlproveedores.getId())) {
					controlproveedoresLocal.setIsSelected(controlproveedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesControlProveedores(List<ControlProveedores> controlproveedoressAux) throws Exception {
		//this.controlproveedoressAux=controlproveedoressAux;
		
		for(ControlProveedores controlproveedoresAux:controlproveedoressAux) {
			if(controlproveedoresAux.getIsChanged()) {
				controlproveedoresAux.setIsChanged(false);
			}		
			
			if(controlproveedoresAux.getIsNew()) {
				controlproveedoresAux.setIsNew(false);
			}	
			
			if(controlproveedoresAux.getIsDeleted()) {
				controlproveedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesControlProveedores(ControlProveedores controlproveedoresAux) throws Exception {
		//this.controlproveedoresAux=controlproveedoresAux;
		
			if(controlproveedoresAux.getIsChanged()) {
				controlproveedoresAux.setIsChanged(false);
			}		
			
			if(controlproveedoresAux.getIsNew()) {
				controlproveedoresAux.setIsNew(false);
			}	
			
			if(controlproveedoresAux.getIsDeleted()) {
				controlproveedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ControlProveedores controlproveedoresAsignar,ControlProveedores controlproveedores) throws Exception {
		controlproveedoresAsignar.setId(controlproveedores.getId());	
		controlproveedoresAsignar.setVersionRow(controlproveedores.getVersionRow());	
		controlproveedoresAsignar.setnombre_zona(controlproveedores.getnombre_zona());	
		controlproveedoresAsignar.setnombre_ciudad(controlproveedores.getnombre_ciudad());	
		controlproveedoresAsignar.setnombre_grupo_cliente(controlproveedores.getnombre_grupo_cliente());	
		controlproveedoresAsignar.setcodigo(controlproveedores.getcodigo());	
		controlproveedoresAsignar.setnombre_cliente(controlproveedores.getnombre_cliente());	
		controlproveedoresAsignar.setruc(controlproveedores.getruc());	
		controlproveedoresAsignar.settelefonos(controlproveedores.gettelefonos());	
		controlproveedoresAsignar.setdirecciones(controlproveedores.getdirecciones());	
		controlproveedoresAsignar.setemails(controlproveedores.getemails());	
		controlproveedoresAsignar.setnumero_factura(controlproveedores.getnumero_factura());	
		controlproveedoresAsignar.setfecha_emision(controlproveedores.getfecha_emision());	
		controlproveedoresAsignar.setfecha_venta(controlproveedores.getfecha_venta());	
		controlproveedoresAsignar.setsaldo(controlproveedores.getsaldo());	
		controlproveedoresAsignar.setdebito_mone_local(controlproveedores.getdebito_mone_local());	
		controlproveedoresAsignar.setcredito_mone_local(controlproveedores.getcredito_mone_local());	
	}
	
	public static void inicializarControlProveedores(ControlProveedores controlproveedores) throws Exception {
		try {
				controlproveedores.setId(0L);	
					
				controlproveedores.setnombre_zona("");	
				controlproveedores.setnombre_ciudad("");	
				controlproveedores.setnombre_grupo_cliente("");	
				controlproveedores.setcodigo("");	
				controlproveedores.setnombre_cliente("");	
				controlproveedores.setruc("");	
				controlproveedores.settelefonos("");	
				controlproveedores.setdirecciones("");	
				controlproveedores.setemails("");	
				controlproveedores.setnumero_factura("");	
				controlproveedores.setfecha_emision(new Date());	
				controlproveedores.setfecha_venta(new Date());	
				controlproveedores.setsaldo(0.0);	
				controlproveedores.setdebito_mone_local(0.0);	
				controlproveedores.setcredito_mone_local(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderControlProveedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_TELEFONOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_DIRECCIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_EMAILS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataControlProveedores(String sTipo,Row row,Workbook workbook,ControlProveedores controlproveedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.gettelefonos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getdirecciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getemails());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(controlproveedores.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryControlProveedores="";
	
	public String getsFinalQueryControlProveedores() {
		return this.sFinalQueryControlProveedores;
	}
	
	public void setsFinalQueryControlProveedores(String sFinalQueryControlProveedores) {
		this.sFinalQueryControlProveedores= sFinalQueryControlProveedores;
	}
	
	public Border resaltarSeleccionarControlProveedores=null;
	
	public Border setResaltarSeleccionarControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarControlProveedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarControlProveedores() {
		return this.resaltarSeleccionarControlProveedores;
	}
	
	public void setResaltarSeleccionarControlProveedores(Border borderResaltarSeleccionarControlProveedores) {
		this.resaltarSeleccionarControlProveedores= borderResaltarSeleccionarControlProveedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridControlProveedores=null;
	public Boolean mostraridControlProveedores=true;
	public Boolean activaridControlProveedores=true;

	public Border resaltarid_empresaControlProveedores=null;
	public Boolean mostrarid_empresaControlProveedores=true;
	public Boolean activarid_empresaControlProveedores=true;
	public Boolean cargarid_empresaControlProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaControlProveedores=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaControlProveedores=null;
	public Boolean mostrarfecha_emision_hastaControlProveedores=true;
	public Boolean activarfecha_emision_hastaControlProveedores=true;

	public Border resaltarnombre_zonaControlProveedores=null;
	public Boolean mostrarnombre_zonaControlProveedores=true;
	public Boolean activarnombre_zonaControlProveedores=true;

	public Border resaltarnombre_ciudadControlProveedores=null;
	public Boolean mostrarnombre_ciudadControlProveedores=true;
	public Boolean activarnombre_ciudadControlProveedores=true;

	public Border resaltarnombre_grupo_clienteControlProveedores=null;
	public Boolean mostrarnombre_grupo_clienteControlProveedores=true;
	public Boolean activarnombre_grupo_clienteControlProveedores=true;

	public Border resaltarcodigoControlProveedores=null;
	public Boolean mostrarcodigoControlProveedores=true;
	public Boolean activarcodigoControlProveedores=true;

	public Border resaltarnombre_clienteControlProveedores=null;
	public Boolean mostrarnombre_clienteControlProveedores=true;
	public Boolean activarnombre_clienteControlProveedores=true;

	public Border resaltarrucControlProveedores=null;
	public Boolean mostrarrucControlProveedores=true;
	public Boolean activarrucControlProveedores=true;

	public Border resaltartelefonosControlProveedores=null;
	public Boolean mostrartelefonosControlProveedores=true;
	public Boolean activartelefonosControlProveedores=true;

	public Border resaltardireccionesControlProveedores=null;
	public Boolean mostrardireccionesControlProveedores=true;
	public Boolean activardireccionesControlProveedores=true;

	public Border resaltaremailsControlProveedores=null;
	public Boolean mostraremailsControlProveedores=true;
	public Boolean activaremailsControlProveedores=true;

	public Border resaltarnumero_facturaControlProveedores=null;
	public Boolean mostrarnumero_facturaControlProveedores=true;
	public Boolean activarnumero_facturaControlProveedores=true;

	public Border resaltarfecha_emisionControlProveedores=null;
	public Boolean mostrarfecha_emisionControlProveedores=true;
	public Boolean activarfecha_emisionControlProveedores=true;

	public Border resaltarfecha_ventaControlProveedores=null;
	public Boolean mostrarfecha_ventaControlProveedores=true;
	public Boolean activarfecha_ventaControlProveedores=true;

	public Border resaltarsaldoControlProveedores=null;
	public Boolean mostrarsaldoControlProveedores=true;
	public Boolean activarsaldoControlProveedores=true;

	public Border resaltardebito_mone_localControlProveedores=null;
	public Boolean mostrardebito_mone_localControlProveedores=true;
	public Boolean activardebito_mone_localControlProveedores=true;

	public Border resaltarcredito_mone_localControlProveedores=null;
	public Boolean mostrarcredito_mone_localControlProveedores=true;
	public Boolean activarcredito_mone_localControlProveedores=true;

	
	

	public Border setResaltaridControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltaridControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridControlProveedores() {
		return this.resaltaridControlProveedores;
	}

	public void setResaltaridControlProveedores(Border borderResaltar) {
		this.resaltaridControlProveedores= borderResaltar;
	}

	public Boolean getMostraridControlProveedores() {
		return this.mostraridControlProveedores;
	}

	public void setMostraridControlProveedores(Boolean mostraridControlProveedores) {
		this.mostraridControlProveedores= mostraridControlProveedores;
	}

	public Boolean getActivaridControlProveedores() {
		return this.activaridControlProveedores;
	}

	public void setActivaridControlProveedores(Boolean activaridControlProveedores) {
		this.activaridControlProveedores= activaridControlProveedores;
	}

	public Border setResaltarid_empresaControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaControlProveedores() {
		return this.resaltarid_empresaControlProveedores;
	}

	public void setResaltarid_empresaControlProveedores(Border borderResaltar) {
		this.resaltarid_empresaControlProveedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaControlProveedores() {
		return this.mostrarid_empresaControlProveedores;
	}

	public void setMostrarid_empresaControlProveedores(Boolean mostrarid_empresaControlProveedores) {
		this.mostrarid_empresaControlProveedores= mostrarid_empresaControlProveedores;
	}

	public Boolean getActivarid_empresaControlProveedores() {
		return this.activarid_empresaControlProveedores;
	}

	public void setActivarid_empresaControlProveedores(Boolean activarid_empresaControlProveedores) {
		this.activarid_empresaControlProveedores= activarid_empresaControlProveedores;
	}

	public Boolean getCargarid_empresaControlProveedores() {
		return this.cargarid_empresaControlProveedores;
	}

	public void setCargarid_empresaControlProveedores(Boolean cargarid_empresaControlProveedores) {
		this.cargarid_empresaControlProveedores= cargarid_empresaControlProveedores;
	}

	public Border setResaltarfecha_emision_hastaControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaControlProveedores() {
		return this.resaltarfecha_emision_hastaControlProveedores;
	}

	public void setResaltarfecha_emision_hastaControlProveedores(Border borderResaltar) {
		this.resaltarfecha_emision_hastaControlProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaControlProveedores() {
		return this.mostrarfecha_emision_hastaControlProveedores;
	}

	public void setMostrarfecha_emision_hastaControlProveedores(Boolean mostrarfecha_emision_hastaControlProveedores) {
		this.mostrarfecha_emision_hastaControlProveedores= mostrarfecha_emision_hastaControlProveedores;
	}

	public Boolean getActivarfecha_emision_hastaControlProveedores() {
		return this.activarfecha_emision_hastaControlProveedores;
	}

	public void setActivarfecha_emision_hastaControlProveedores(Boolean activarfecha_emision_hastaControlProveedores) {
		this.activarfecha_emision_hastaControlProveedores= activarfecha_emision_hastaControlProveedores;
	}

	public Border setResaltarnombre_zonaControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaControlProveedores() {
		return this.resaltarnombre_zonaControlProveedores;
	}

	public void setResaltarnombre_zonaControlProveedores(Border borderResaltar) {
		this.resaltarnombre_zonaControlProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaControlProveedores() {
		return this.mostrarnombre_zonaControlProveedores;
	}

	public void setMostrarnombre_zonaControlProveedores(Boolean mostrarnombre_zonaControlProveedores) {
		this.mostrarnombre_zonaControlProveedores= mostrarnombre_zonaControlProveedores;
	}

	public Boolean getActivarnombre_zonaControlProveedores() {
		return this.activarnombre_zonaControlProveedores;
	}

	public void setActivarnombre_zonaControlProveedores(Boolean activarnombre_zonaControlProveedores) {
		this.activarnombre_zonaControlProveedores= activarnombre_zonaControlProveedores;
	}

	public Border setResaltarnombre_ciudadControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadControlProveedores() {
		return this.resaltarnombre_ciudadControlProveedores;
	}

	public void setResaltarnombre_ciudadControlProveedores(Border borderResaltar) {
		this.resaltarnombre_ciudadControlProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadControlProveedores() {
		return this.mostrarnombre_ciudadControlProveedores;
	}

	public void setMostrarnombre_ciudadControlProveedores(Boolean mostrarnombre_ciudadControlProveedores) {
		this.mostrarnombre_ciudadControlProveedores= mostrarnombre_ciudadControlProveedores;
	}

	public Boolean getActivarnombre_ciudadControlProveedores() {
		return this.activarnombre_ciudadControlProveedores;
	}

	public void setActivarnombre_ciudadControlProveedores(Boolean activarnombre_ciudadControlProveedores) {
		this.activarnombre_ciudadControlProveedores= activarnombre_ciudadControlProveedores;
	}

	public Border setResaltarnombre_grupo_clienteControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteControlProveedores() {
		return this.resaltarnombre_grupo_clienteControlProveedores;
	}

	public void setResaltarnombre_grupo_clienteControlProveedores(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteControlProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteControlProveedores() {
		return this.mostrarnombre_grupo_clienteControlProveedores;
	}

	public void setMostrarnombre_grupo_clienteControlProveedores(Boolean mostrarnombre_grupo_clienteControlProveedores) {
		this.mostrarnombre_grupo_clienteControlProveedores= mostrarnombre_grupo_clienteControlProveedores;
	}

	public Boolean getActivarnombre_grupo_clienteControlProveedores() {
		return this.activarnombre_grupo_clienteControlProveedores;
	}

	public void setActivarnombre_grupo_clienteControlProveedores(Boolean activarnombre_grupo_clienteControlProveedores) {
		this.activarnombre_grupo_clienteControlProveedores= activarnombre_grupo_clienteControlProveedores;
	}

	public Border setResaltarcodigoControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarcodigoControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoControlProveedores() {
		return this.resaltarcodigoControlProveedores;
	}

	public void setResaltarcodigoControlProveedores(Border borderResaltar) {
		this.resaltarcodigoControlProveedores= borderResaltar;
	}

	public Boolean getMostrarcodigoControlProveedores() {
		return this.mostrarcodigoControlProveedores;
	}

	public void setMostrarcodigoControlProveedores(Boolean mostrarcodigoControlProveedores) {
		this.mostrarcodigoControlProveedores= mostrarcodigoControlProveedores;
	}

	public Boolean getActivarcodigoControlProveedores() {
		return this.activarcodigoControlProveedores;
	}

	public void setActivarcodigoControlProveedores(Boolean activarcodigoControlProveedores) {
		this.activarcodigoControlProveedores= activarcodigoControlProveedores;
	}

	public Border setResaltarnombre_clienteControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteControlProveedores() {
		return this.resaltarnombre_clienteControlProveedores;
	}

	public void setResaltarnombre_clienteControlProveedores(Border borderResaltar) {
		this.resaltarnombre_clienteControlProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteControlProveedores() {
		return this.mostrarnombre_clienteControlProveedores;
	}

	public void setMostrarnombre_clienteControlProveedores(Boolean mostrarnombre_clienteControlProveedores) {
		this.mostrarnombre_clienteControlProveedores= mostrarnombre_clienteControlProveedores;
	}

	public Boolean getActivarnombre_clienteControlProveedores() {
		return this.activarnombre_clienteControlProveedores;
	}

	public void setActivarnombre_clienteControlProveedores(Boolean activarnombre_clienteControlProveedores) {
		this.activarnombre_clienteControlProveedores= activarnombre_clienteControlProveedores;
	}

	public Border setResaltarrucControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarrucControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucControlProveedores() {
		return this.resaltarrucControlProveedores;
	}

	public void setResaltarrucControlProveedores(Border borderResaltar) {
		this.resaltarrucControlProveedores= borderResaltar;
	}

	public Boolean getMostrarrucControlProveedores() {
		return this.mostrarrucControlProveedores;
	}

	public void setMostrarrucControlProveedores(Boolean mostrarrucControlProveedores) {
		this.mostrarrucControlProveedores= mostrarrucControlProveedores;
	}

	public Boolean getActivarrucControlProveedores() {
		return this.activarrucControlProveedores;
	}

	public void setActivarrucControlProveedores(Boolean activarrucControlProveedores) {
		this.activarrucControlProveedores= activarrucControlProveedores;
	}

	public Border setResaltartelefonosControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltartelefonosControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonosControlProveedores() {
		return this.resaltartelefonosControlProveedores;
	}

	public void setResaltartelefonosControlProveedores(Border borderResaltar) {
		this.resaltartelefonosControlProveedores= borderResaltar;
	}

	public Boolean getMostrartelefonosControlProveedores() {
		return this.mostrartelefonosControlProveedores;
	}

	public void setMostrartelefonosControlProveedores(Boolean mostrartelefonosControlProveedores) {
		this.mostrartelefonosControlProveedores= mostrartelefonosControlProveedores;
	}

	public Boolean getActivartelefonosControlProveedores() {
		return this.activartelefonosControlProveedores;
	}

	public void setActivartelefonosControlProveedores(Boolean activartelefonosControlProveedores) {
		this.activartelefonosControlProveedores= activartelefonosControlProveedores;
	}

	public Border setResaltardireccionesControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltardireccionesControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionesControlProveedores() {
		return this.resaltardireccionesControlProveedores;
	}

	public void setResaltardireccionesControlProveedores(Border borderResaltar) {
		this.resaltardireccionesControlProveedores= borderResaltar;
	}

	public Boolean getMostrardireccionesControlProveedores() {
		return this.mostrardireccionesControlProveedores;
	}

	public void setMostrardireccionesControlProveedores(Boolean mostrardireccionesControlProveedores) {
		this.mostrardireccionesControlProveedores= mostrardireccionesControlProveedores;
	}

	public Boolean getActivardireccionesControlProveedores() {
		return this.activardireccionesControlProveedores;
	}

	public void setActivardireccionesControlProveedores(Boolean activardireccionesControlProveedores) {
		this.activardireccionesControlProveedores= activardireccionesControlProveedores;
	}

	public Border setResaltaremailsControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltaremailsControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailsControlProveedores() {
		return this.resaltaremailsControlProveedores;
	}

	public void setResaltaremailsControlProveedores(Border borderResaltar) {
		this.resaltaremailsControlProveedores= borderResaltar;
	}

	public Boolean getMostraremailsControlProveedores() {
		return this.mostraremailsControlProveedores;
	}

	public void setMostraremailsControlProveedores(Boolean mostraremailsControlProveedores) {
		this.mostraremailsControlProveedores= mostraremailsControlProveedores;
	}

	public Boolean getActivaremailsControlProveedores() {
		return this.activaremailsControlProveedores;
	}

	public void setActivaremailsControlProveedores(Boolean activaremailsControlProveedores) {
		this.activaremailsControlProveedores= activaremailsControlProveedores;
	}

	public Border setResaltarnumero_facturaControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaControlProveedores() {
		return this.resaltarnumero_facturaControlProveedores;
	}

	public void setResaltarnumero_facturaControlProveedores(Border borderResaltar) {
		this.resaltarnumero_facturaControlProveedores= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaControlProveedores() {
		return this.mostrarnumero_facturaControlProveedores;
	}

	public void setMostrarnumero_facturaControlProveedores(Boolean mostrarnumero_facturaControlProveedores) {
		this.mostrarnumero_facturaControlProveedores= mostrarnumero_facturaControlProveedores;
	}

	public Boolean getActivarnumero_facturaControlProveedores() {
		return this.activarnumero_facturaControlProveedores;
	}

	public void setActivarnumero_facturaControlProveedores(Boolean activarnumero_facturaControlProveedores) {
		this.activarnumero_facturaControlProveedores= activarnumero_facturaControlProveedores;
	}

	public Border setResaltarfecha_emisionControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionControlProveedores() {
		return this.resaltarfecha_emisionControlProveedores;
	}

	public void setResaltarfecha_emisionControlProveedores(Border borderResaltar) {
		this.resaltarfecha_emisionControlProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionControlProveedores() {
		return this.mostrarfecha_emisionControlProveedores;
	}

	public void setMostrarfecha_emisionControlProveedores(Boolean mostrarfecha_emisionControlProveedores) {
		this.mostrarfecha_emisionControlProveedores= mostrarfecha_emisionControlProveedores;
	}

	public Boolean getActivarfecha_emisionControlProveedores() {
		return this.activarfecha_emisionControlProveedores;
	}

	public void setActivarfecha_emisionControlProveedores(Boolean activarfecha_emisionControlProveedores) {
		this.activarfecha_emisionControlProveedores= activarfecha_emisionControlProveedores;
	}

	public Border setResaltarfecha_ventaControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaControlProveedores() {
		return this.resaltarfecha_ventaControlProveedores;
	}

	public void setResaltarfecha_ventaControlProveedores(Border borderResaltar) {
		this.resaltarfecha_ventaControlProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaControlProveedores() {
		return this.mostrarfecha_ventaControlProveedores;
	}

	public void setMostrarfecha_ventaControlProveedores(Boolean mostrarfecha_ventaControlProveedores) {
		this.mostrarfecha_ventaControlProveedores= mostrarfecha_ventaControlProveedores;
	}

	public Boolean getActivarfecha_ventaControlProveedores() {
		return this.activarfecha_ventaControlProveedores;
	}

	public void setActivarfecha_ventaControlProveedores(Boolean activarfecha_ventaControlProveedores) {
		this.activarfecha_ventaControlProveedores= activarfecha_ventaControlProveedores;
	}

	public Border setResaltarsaldoControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarsaldoControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoControlProveedores() {
		return this.resaltarsaldoControlProveedores;
	}

	public void setResaltarsaldoControlProveedores(Border borderResaltar) {
		this.resaltarsaldoControlProveedores= borderResaltar;
	}

	public Boolean getMostrarsaldoControlProveedores() {
		return this.mostrarsaldoControlProveedores;
	}

	public void setMostrarsaldoControlProveedores(Boolean mostrarsaldoControlProveedores) {
		this.mostrarsaldoControlProveedores= mostrarsaldoControlProveedores;
	}

	public Boolean getActivarsaldoControlProveedores() {
		return this.activarsaldoControlProveedores;
	}

	public void setActivarsaldoControlProveedores(Boolean activarsaldoControlProveedores) {
		this.activarsaldoControlProveedores= activarsaldoControlProveedores;
	}

	public Border setResaltardebito_mone_localControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localControlProveedores() {
		return this.resaltardebito_mone_localControlProveedores;
	}

	public void setResaltardebito_mone_localControlProveedores(Border borderResaltar) {
		this.resaltardebito_mone_localControlProveedores= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localControlProveedores() {
		return this.mostrardebito_mone_localControlProveedores;
	}

	public void setMostrardebito_mone_localControlProveedores(Boolean mostrardebito_mone_localControlProveedores) {
		this.mostrardebito_mone_localControlProveedores= mostrardebito_mone_localControlProveedores;
	}

	public Boolean getActivardebito_mone_localControlProveedores() {
		return this.activardebito_mone_localControlProveedores;
	}

	public void setActivardebito_mone_localControlProveedores(Boolean activardebito_mone_localControlProveedores) {
		this.activardebito_mone_localControlProveedores= activardebito_mone_localControlProveedores;
	}

	public Border setResaltarcredito_mone_localControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//controlproveedoresBeanSwingJInternalFrame.jTtoolBarControlProveedores.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localControlProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localControlProveedores() {
		return this.resaltarcredito_mone_localControlProveedores;
	}

	public void setResaltarcredito_mone_localControlProveedores(Border borderResaltar) {
		this.resaltarcredito_mone_localControlProveedores= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localControlProveedores() {
		return this.mostrarcredito_mone_localControlProveedores;
	}

	public void setMostrarcredito_mone_localControlProveedores(Boolean mostrarcredito_mone_localControlProveedores) {
		this.mostrarcredito_mone_localControlProveedores= mostrarcredito_mone_localControlProveedores;
	}

	public Boolean getActivarcredito_mone_localControlProveedores() {
		return this.activarcredito_mone_localControlProveedores;
	}

	public void setActivarcredito_mone_localControlProveedores(Boolean activarcredito_mone_localControlProveedores) {
		this.activarcredito_mone_localControlProveedores= activarcredito_mone_localControlProveedores;
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
		
		
		this.setMostraridControlProveedores(esInicial);
		this.setMostrarid_empresaControlProveedores(esInicial);
		this.setMostrarfecha_emision_hastaControlProveedores(esInicial);
		this.setMostrarnombre_zonaControlProveedores(esInicial);
		this.setMostrarnombre_ciudadControlProveedores(esInicial);
		this.setMostrarnombre_grupo_clienteControlProveedores(esInicial);
		this.setMostrarcodigoControlProveedores(esInicial);
		this.setMostrarnombre_clienteControlProveedores(esInicial);
		this.setMostrarrucControlProveedores(esInicial);
		this.setMostrartelefonosControlProveedores(esInicial);
		this.setMostrardireccionesControlProveedores(esInicial);
		this.setMostraremailsControlProveedores(esInicial);
		this.setMostrarnumero_facturaControlProveedores(esInicial);
		this.setMostrarfecha_emisionControlProveedores(esInicial);
		this.setMostrarfecha_ventaControlProveedores(esInicial);
		this.setMostrarsaldoControlProveedores(esInicial);
		this.setMostrardebito_mone_localControlProveedores(esInicial);
		this.setMostrarcredito_mone_localControlProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.ID)) {
				this.setMostraridControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.RUC)) {
				this.setMostrarrucControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.TELEFONOS)) {
				this.setMostrartelefonosControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DIRECCIONES)) {
				this.setMostrardireccionesControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.EMAILS)) {
				this.setMostraremailsControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.SALDO)) {
				this.setMostrarsaldoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localControlProveedores(esAsigna);
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
		
		
		this.setActivaridControlProveedores(esInicial);
		this.setActivarid_empresaControlProveedores(esInicial);
		this.setActivarfecha_emision_hastaControlProveedores(esInicial);
		this.setActivarnombre_zonaControlProveedores(esInicial);
		this.setActivarnombre_ciudadControlProveedores(esInicial);
		this.setActivarnombre_grupo_clienteControlProveedores(esInicial);
		this.setActivarcodigoControlProveedores(esInicial);
		this.setActivarnombre_clienteControlProveedores(esInicial);
		this.setActivarrucControlProveedores(esInicial);
		this.setActivartelefonosControlProveedores(esInicial);
		this.setActivardireccionesControlProveedores(esInicial);
		this.setActivaremailsControlProveedores(esInicial);
		this.setActivarnumero_facturaControlProveedores(esInicial);
		this.setActivarfecha_emisionControlProveedores(esInicial);
		this.setActivarfecha_ventaControlProveedores(esInicial);
		this.setActivarsaldoControlProveedores(esInicial);
		this.setActivardebito_mone_localControlProveedores(esInicial);
		this.setActivarcredito_mone_localControlProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.ID)) {
				this.setActivaridControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CODIGO)) {
				this.setActivarcodigoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.RUC)) {
				this.setActivarrucControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.TELEFONOS)) {
				this.setActivartelefonosControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DIRECCIONES)) {
				this.setActivardireccionesControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.EMAILS)) {
				this.setActivaremailsControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.SALDO)) {
				this.setActivarsaldoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localControlProveedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridControlProveedores(esInicial);
		this.setResaltarid_empresaControlProveedores(esInicial);
		this.setResaltarfecha_emision_hastaControlProveedores(esInicial);
		this.setResaltarnombre_zonaControlProveedores(esInicial);
		this.setResaltarnombre_ciudadControlProveedores(esInicial);
		this.setResaltarnombre_grupo_clienteControlProveedores(esInicial);
		this.setResaltarcodigoControlProveedores(esInicial);
		this.setResaltarnombre_clienteControlProveedores(esInicial);
		this.setResaltarrucControlProveedores(esInicial);
		this.setResaltartelefonosControlProveedores(esInicial);
		this.setResaltardireccionesControlProveedores(esInicial);
		this.setResaltaremailsControlProveedores(esInicial);
		this.setResaltarnumero_facturaControlProveedores(esInicial);
		this.setResaltarfecha_emisionControlProveedores(esInicial);
		this.setResaltarfecha_ventaControlProveedores(esInicial);
		this.setResaltarsaldoControlProveedores(esInicial);
		this.setResaltardebito_mone_localControlProveedores(esInicial);
		this.setResaltarcredito_mone_localControlProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.ID)) {
				this.setResaltaridControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.RUC)) {
				this.setResaltarrucControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.TELEFONOS)) {
				this.setResaltartelefonosControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DIRECCIONES)) {
				this.setResaltardireccionesControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.EMAILS)) {
				this.setResaltaremailsControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.SALDO)) {
				this.setResaltarsaldoControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localControlProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localControlProveedores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaControlProveedoresControlProveedores=true;

	public Boolean getMostrarBusquedaControlProveedoresControlProveedores() {
		return this.mostrarBusquedaControlProveedoresControlProveedores;
	}

	public void setMostrarBusquedaControlProveedoresControlProveedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaControlProveedoresControlProveedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaControlProveedoresControlProveedores=true;

	public Boolean getActivarBusquedaControlProveedoresControlProveedores() {
		return this.activarBusquedaControlProveedoresControlProveedores;
	}

	public void setActivarBusquedaControlProveedoresControlProveedores(Boolean habilitarResaltar) {
		this.activarBusquedaControlProveedoresControlProveedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaControlProveedoresControlProveedores=null;

	public Border getResaltarBusquedaControlProveedoresControlProveedores() {
		return this.resaltarBusquedaControlProveedoresControlProveedores;
	}

	public void setResaltarBusquedaControlProveedoresControlProveedores(Border borderResaltar) {
		this.resaltarBusquedaControlProveedoresControlProveedores= borderResaltar;
	}

	public void setResaltarBusquedaControlProveedoresControlProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*ControlProveedoresBeanSwingJInternalFrame controlproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaControlProveedoresControlProveedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}