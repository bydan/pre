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
package com.bydan.erp.activosfijos.util.report;

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


import com.bydan.erp.activosfijos.util.report.TransferenciasConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.TransferenciasParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.TransferenciasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransferenciasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Transferencias";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Transferencias"+TransferenciasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransferenciasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransferenciasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransferenciasConstantesFunciones.SCHEMA+"_"+TransferenciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransferenciasConstantesFunciones.SCHEMA+"_"+TransferenciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransferenciasConstantesFunciones.SCHEMA+"_"+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransferenciasConstantesFunciones.SCHEMA+"_"+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransferenciasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransferenciasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransferenciasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransferenciasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transferenciases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transferencias";
	public static final String SCLASSWEBTITULO_LOWER="Transferencias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Transferencias";
	public static final String OBJECTNAME="transferencias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="transferencias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transferencias from "+TransferenciasConstantesFunciones.SPERSISTENCENAME+" transferencias";
	public static String QUERYSELECTNATIVE="select "+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".id,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".version_row,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".id_empresa,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".empresa_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".sucursal_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".sub_grupo_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".grupo_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".activo_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".empresa_destino,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".sucursal_destino,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".sub_grupo_destino,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".grupo_destino,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".activo_destino,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".secuencial,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".fecha,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".numero_documento,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".costo,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".depreciacion,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".costo_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".depreciacion_origen,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".razon,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".descripcion,"+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME+".tipo from "+TransferenciasConstantesFunciones.SCHEMA+"."+TransferenciasConstantesFunciones.TABLENAME;//+" as "+TransferenciasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String EMPRESAORIGEN= "empresa_origen";
    public static final String SUCURSALORIGEN= "sucursal_origen";
    public static final String SUBGRUPOORIGEN= "sub_grupo_origen";
    public static final String GRUPOORIGEN= "grupo_origen";
    public static final String ACTIVOORIGEN= "activo_origen";
    public static final String EMPRESADESTINO= "empresa_destino";
    public static final String SUCURSALDESTINO= "sucursal_destino";
    public static final String SUBGRUPODESTINO= "sub_grupo_destino";
    public static final String GRUPODESTINO= "grupo_destino";
    public static final String ACTIVODESTINO= "activo_destino";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String COSTO= "costo";
    public static final String DEPRECIACION= "depreciacion";
    public static final String COSTOORIGEN= "costo_origen";
    public static final String DEPRECIACIONORIGEN= "depreciacion_origen";
    public static final String RAZON= "razon";
    public static final String DESCRIPCION= "descripcion";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_EMPRESAORIGEN= "Empresa Origen";
		public static final String LABEL_EMPRESAORIGEN_LOWER= "Empresa Origen";
    	public static final String LABEL_SUCURSALORIGEN= "Sucursal Origen";
		public static final String LABEL_SUCURSALORIGEN_LOWER= "Sucursal Origen";
    	public static final String LABEL_SUBGRUPOORIGEN= "Sub Grupo Origen";
		public static final String LABEL_SUBGRUPOORIGEN_LOWER= "Sub Grupo Origen";
    	public static final String LABEL_GRUPOORIGEN= "Grupo Origen";
		public static final String LABEL_GRUPOORIGEN_LOWER= "Grupo Origen";
    	public static final String LABEL_ACTIVOORIGEN= "Activo Origen";
		public static final String LABEL_ACTIVOORIGEN_LOWER= "Activo Origen";
    	public static final String LABEL_EMPRESADESTINO= "Empresa Destino";
		public static final String LABEL_EMPRESADESTINO_LOWER= "Empresa Destino";
    	public static final String LABEL_SUCURSALDESTINO= "Sucursal Destino";
		public static final String LABEL_SUCURSALDESTINO_LOWER= "Sucursal Destino";
    	public static final String LABEL_SUBGRUPODESTINO= "Sub Grupo Destino";
		public static final String LABEL_SUBGRUPODESTINO_LOWER= "Sub Grupo Destino";
    	public static final String LABEL_GRUPODESTINO= "Grupo Destino";
		public static final String LABEL_GRUPODESTINO_LOWER= "Grupo Destino";
    	public static final String LABEL_ACTIVODESTINO= "Activo Destino";
		public static final String LABEL_ACTIVODESTINO_LOWER= "Activo Destino";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_DEPRECIACION= "Depreciacion";
		public static final String LABEL_DEPRECIACION_LOWER= "Depreciacion";
    	public static final String LABEL_COSTOORIGEN= "Costo Origen";
		public static final String LABEL_COSTOORIGEN_LOWER= "Costo Origen";
    	public static final String LABEL_DEPRECIACIONORIGEN= "Depreciacion Origen";
		public static final String LABEL_DEPRECIACIONORIGEN_LOWER= "Depreciacion Origen";
    	public static final String LABEL_RAZON= "Razon";
		public static final String LABEL_RAZON_LOWER= "Razon";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
	public static final String SREGEXEMPRESA_ORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMPRESA_ORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSUCURSAL_ORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSUCURSAL_ORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSUB_GRUPO_ORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSUB_GRUPO_ORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGRUPO_ORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGRUPO_ORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACTIVO_ORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACTIVO_ORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMPRESA_DESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMPRESA_DESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSUCURSAL_DESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSUCURSAL_DESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSUB_GRUPO_DESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSUB_GRUPO_DESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGRUPO_DESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGRUPO_DESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACTIVO_DESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACTIVO_DESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXRAZON=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRAZON=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransferenciasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.EMPRESAORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_EMPRESAORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.SUCURSALORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_SUCURSALORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.SUBGRUPOORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_SUBGRUPOORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.GRUPOORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_GRUPOORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.ACTIVOORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_ACTIVOORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.EMPRESADESTINO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_EMPRESADESTINO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.SUCURSALDESTINO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_SUCURSALDESTINO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.SUBGRUPODESTINO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_SUBGRUPODESTINO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.GRUPODESTINO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_GRUPODESTINO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.ACTIVODESTINO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_ACTIVODESTINO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.SECUENCIAL)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.FECHA)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.COSTO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.DEPRECIACION)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_DEPRECIACION;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.COSTOORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_COSTOORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.RAZON)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_RAZON;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.DESCRIPCION)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(TransferenciasConstantesFunciones.TIPO)) {sLabelColumna=TransferenciasConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransferenciasDescripcion(Transferencias transferencias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transferencias !=null/* && transferencias.getId()!=0*/) {
			sDescripcion=transferencias.getsucursal_origen();//transferenciastransferencias.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransferenciasDescripcionDetallado(Transferencias transferencias) {
		String sDescripcion="";
			
		sDescripcion+=TransferenciasConstantesFunciones.ID+"=";
		sDescripcion+=transferencias.getId().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transferencias.getVersionRow().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transferencias.getid_empresa().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.EMPRESAORIGEN+"=";
		sDescripcion+=transferencias.getempresa_origen()+",";
		sDescripcion+=TransferenciasConstantesFunciones.SUCURSALORIGEN+"=";
		sDescripcion+=transferencias.getsucursal_origen()+",";
		sDescripcion+=TransferenciasConstantesFunciones.SUBGRUPOORIGEN+"=";
		sDescripcion+=transferencias.getsub_grupo_origen()+",";
		sDescripcion+=TransferenciasConstantesFunciones.GRUPOORIGEN+"=";
		sDescripcion+=transferencias.getgrupo_origen()+",";
		sDescripcion+=TransferenciasConstantesFunciones.ACTIVOORIGEN+"=";
		sDescripcion+=transferencias.getactivo_origen()+",";
		sDescripcion+=TransferenciasConstantesFunciones.EMPRESADESTINO+"=";
		sDescripcion+=transferencias.getempresa_destino()+",";
		sDescripcion+=TransferenciasConstantesFunciones.SUCURSALDESTINO+"=";
		sDescripcion+=transferencias.getsucursal_destino()+",";
		sDescripcion+=TransferenciasConstantesFunciones.SUBGRUPODESTINO+"=";
		sDescripcion+=transferencias.getsub_grupo_destino()+",";
		sDescripcion+=TransferenciasConstantesFunciones.GRUPODESTINO+"=";
		sDescripcion+=transferencias.getgrupo_destino()+",";
		sDescripcion+=TransferenciasConstantesFunciones.ACTIVODESTINO+"=";
		sDescripcion+=transferencias.getactivo_destino()+",";
		sDescripcion+=TransferenciasConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=transferencias.getsecuencial()+",";
		sDescripcion+=TransferenciasConstantesFunciones.FECHA+"=";
		sDescripcion+=transferencias.getfecha().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=transferencias.getnumero_documento()+",";
		sDescripcion+=TransferenciasConstantesFunciones.COSTO+"=";
		sDescripcion+=transferencias.getcosto().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.DEPRECIACION+"=";
		sDescripcion+=transferencias.getdepreciacion().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.COSTOORIGEN+"=";
		sDescripcion+=transferencias.getcosto_origen().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.DEPRECIACIONORIGEN+"=";
		sDescripcion+=transferencias.getdepreciacion_origen().toString()+",";
		sDescripcion+=TransferenciasConstantesFunciones.RAZON+"=";
		sDescripcion+=transferencias.getrazon()+",";
		sDescripcion+=TransferenciasConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=transferencias.getdescripcion()+",";
		sDescripcion+=TransferenciasConstantesFunciones.TIPO+"=";
		sDescripcion+=transferencias.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setTransferenciasDescripcion(Transferencias transferencias,String sValor) throws Exception {			
		if(transferencias !=null) {
			transferencias.setsucursal_origen(sValor);//transferenciastransferencias.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaTransferencias")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaTransferencias(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransferencias(Transferencias transferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transferencias.setempresa_origen(transferencias.getempresa_origen().trim());
		transferencias.setsucursal_origen(transferencias.getsucursal_origen().trim());
		transferencias.setsub_grupo_origen(transferencias.getsub_grupo_origen().trim());
		transferencias.setgrupo_origen(transferencias.getgrupo_origen().trim());
		transferencias.setactivo_origen(transferencias.getactivo_origen().trim());
		transferencias.setempresa_destino(transferencias.getempresa_destino().trim());
		transferencias.setsucursal_destino(transferencias.getsucursal_destino().trim());
		transferencias.setsub_grupo_destino(transferencias.getsub_grupo_destino().trim());
		transferencias.setgrupo_destino(transferencias.getgrupo_destino().trim());
		transferencias.setactivo_destino(transferencias.getactivo_destino().trim());
		transferencias.setsecuencial(transferencias.getsecuencial().trim());
		transferencias.setnumero_documento(transferencias.getnumero_documento().trim());
		transferencias.setrazon(transferencias.getrazon().trim());
		transferencias.setdescripcion(transferencias.getdescripcion().trim());
		transferencias.settipo(transferencias.gettipo().trim());
	}
	
	public static void quitarEspaciosTransferenciass(List<Transferencias> transferenciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transferencias transferencias: transferenciass) {
			transferencias.setempresa_origen(transferencias.getempresa_origen().trim());
			transferencias.setsucursal_origen(transferencias.getsucursal_origen().trim());
			transferencias.setsub_grupo_origen(transferencias.getsub_grupo_origen().trim());
			transferencias.setgrupo_origen(transferencias.getgrupo_origen().trim());
			transferencias.setactivo_origen(transferencias.getactivo_origen().trim());
			transferencias.setempresa_destino(transferencias.getempresa_destino().trim());
			transferencias.setsucursal_destino(transferencias.getsucursal_destino().trim());
			transferencias.setsub_grupo_destino(transferencias.getsub_grupo_destino().trim());
			transferencias.setgrupo_destino(transferencias.getgrupo_destino().trim());
			transferencias.setactivo_destino(transferencias.getactivo_destino().trim());
			transferencias.setsecuencial(transferencias.getsecuencial().trim());
			transferencias.setnumero_documento(transferencias.getnumero_documento().trim());
			transferencias.setrazon(transferencias.getrazon().trim());
			transferencias.setdescripcion(transferencias.getdescripcion().trim());
			transferencias.settipo(transferencias.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferencias(Transferencias transferencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transferencias.getConCambioAuxiliar()) {
			transferencias.setIsDeleted(transferencias.getIsDeletedAuxiliar());	
			transferencias.setIsNew(transferencias.getIsNewAuxiliar());	
			transferencias.setIsChanged(transferencias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transferencias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transferencias.setIsDeletedAuxiliar(false);	
			transferencias.setIsNewAuxiliar(false);	
			transferencias.setIsChangedAuxiliar(false);
			
			transferencias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferenciass(List<Transferencias> transferenciass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Transferencias transferencias : transferenciass) {
			if(conAsignarBase && transferencias.getConCambioAuxiliar()) {
				transferencias.setIsDeleted(transferencias.getIsDeletedAuxiliar());	
				transferencias.setIsNew(transferencias.getIsNewAuxiliar());	
				transferencias.setIsChanged(transferencias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transferencias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transferencias.setIsDeletedAuxiliar(false);	
				transferencias.setIsNewAuxiliar(false);	
				transferencias.setIsChangedAuxiliar(false);
				
				transferencias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransferencias(Transferencias transferencias,Boolean conEnteros) throws Exception  {
		transferencias.setcosto(0.0);
		transferencias.setdepreciacion(0.0);
		transferencias.setcosto_origen(0.0);
		transferencias.setdepreciacion_origen(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransferenciass(List<Transferencias> transferenciass,Boolean conEnteros) throws Exception  {
		
		for(Transferencias transferencias: transferenciass) {
			transferencias.setcosto(0.0);
			transferencias.setdepreciacion(0.0);
			transferencias.setcosto_origen(0.0);
			transferencias.setdepreciacion_origen(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransferencias(List<Transferencias> transferenciass,Transferencias transferenciasAux) throws Exception  {
		TransferenciasConstantesFunciones.InicializarValoresTransferencias(transferenciasAux,true);
		
		for(Transferencias transferencias: transferenciass) {
			if(transferencias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transferenciasAux.setcosto(transferenciasAux.getcosto()+transferencias.getcosto());			
			transferenciasAux.setdepreciacion(transferenciasAux.getdepreciacion()+transferencias.getdepreciacion());			
			transferenciasAux.setcosto_origen(transferenciasAux.getcosto_origen()+transferencias.getcosto_origen());			
			transferenciasAux.setdepreciacion_origen(transferenciasAux.getdepreciacion_origen()+transferencias.getdepreciacion_origen());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransferenciasConstantesFunciones.getArrayColumnasGlobalesTransferencias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferencias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransferencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transferencias> transferenciass,Transferencias transferencias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transferencias transferenciasAux: transferenciass) {
			if(transferenciasAux!=null && transferencias!=null) {
				if((transferenciasAux.getId()==null && transferencias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transferenciasAux.getId()!=null && transferencias.getId()!=null){
					if(transferenciasAux.getId().equals(transferencias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransferencias(List<Transferencias> transferenciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double depreciacionTotal=0.0;
		Double costo_origenTotal=0.0;
		Double depreciacion_origenTotal=0.0;
	
		for(Transferencias transferencias: transferenciass) {			
			if(transferencias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=transferencias.getcosto();
			depreciacionTotal+=transferencias.getdepreciacion();
			costo_origenTotal+=transferencias.getcosto_origen();
			depreciacion_origenTotal+=transferencias.getdepreciacion_origen();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.DEPRECIACION);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACION);
		datoGeneral.setdValorDouble(depreciacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.COSTOORIGEN);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTOORIGEN);
		datoGeneral.setdValorDouble(costo_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN);
		datoGeneral.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		datoGeneral.setdValorDouble(depreciacion_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransferencias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_ID, TransferenciasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_VERSIONROW, TransferenciasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_EMPRESAORIGEN, TransferenciasConstantesFunciones.EMPRESAORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_SUCURSALORIGEN, TransferenciasConstantesFunciones.SUCURSALORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_SUBGRUPOORIGEN, TransferenciasConstantesFunciones.SUBGRUPOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_GRUPOORIGEN, TransferenciasConstantesFunciones.GRUPOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_ACTIVOORIGEN, TransferenciasConstantesFunciones.ACTIVOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_EMPRESADESTINO, TransferenciasConstantesFunciones.EMPRESADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_SUCURSALDESTINO, TransferenciasConstantesFunciones.SUCURSALDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_SUBGRUPODESTINO, TransferenciasConstantesFunciones.SUBGRUPODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_GRUPODESTINO, TransferenciasConstantesFunciones.GRUPODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_ACTIVODESTINO, TransferenciasConstantesFunciones.ACTIVODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_SECUENCIAL, TransferenciasConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_FECHA, TransferenciasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_NUMERODOCUMENTO, TransferenciasConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_COSTO, TransferenciasConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_DEPRECIACION, TransferenciasConstantesFunciones.DEPRECIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_COSTOORIGEN, TransferenciasConstantesFunciones.COSTOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN, TransferenciasConstantesFunciones.DEPRECIACIONORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_RAZON, TransferenciasConstantesFunciones.RAZON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_DESCRIPCION, TransferenciasConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasConstantesFunciones.LABEL_TIPO, TransferenciasConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransferencias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.EMPRESAORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.SUCURSALORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.SUBGRUPOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.GRUPOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.ACTIVOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.EMPRESADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.SUCURSALDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.SUBGRUPODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.GRUPODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.ACTIVODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.DEPRECIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.COSTOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.DEPRECIACIONORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.RAZON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencias() throws Exception  {
		return TransferenciasConstantesFunciones.getTiposSeleccionarTransferencias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencias(Boolean conFk) throws Exception  {
		return TransferenciasConstantesFunciones.getTiposSeleccionarTransferencias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_EMPRESAORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_EMPRESAORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_SUCURSALORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_SUCURSALORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_SUBGRUPOORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_SUBGRUPOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_GRUPOORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_GRUPOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_ACTIVOORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_ACTIVOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_EMPRESADESTINO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_EMPRESADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_SUCURSALDESTINO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_SUCURSALDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_SUBGRUPODESTINO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_SUBGRUPODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_GRUPODESTINO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_GRUPODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_ACTIVODESTINO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_ACTIVODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_DEPRECIACION);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_COSTOORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_COSTOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_RAZON);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_RAZON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(TransferenciasConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransferencias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransferencias(Transferencias transferenciasAux) throws Exception {
		
			transferenciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciasAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransferencias(List<Transferencias> transferenciassTemp) throws Exception {
		for(Transferencias transferenciasAux:transferenciassTemp) {
			
			transferenciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciasAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransferencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransferencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciasConstantesFunciones.getClassesRelationshipsOfTransferencias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciasConstantesFunciones.getClassesRelationshipsFromStringsOfTransferencias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Transferencias transferencias,List<Transferencias> transferenciass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Transferencias transferencias,List<Transferencias> transferenciass) throws Exception {
		try	{			
			for(Transferencias transferenciasLocal:transferenciass) {
				if(transferenciasLocal.getId().equals(transferencias.getId())) {
					transferenciasLocal.setIsSelected(transferencias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransferencias(List<Transferencias> transferenciassAux) throws Exception {
		//this.transferenciassAux=transferenciassAux;
		
		for(Transferencias transferenciasAux:transferenciassAux) {
			if(transferenciasAux.getIsChanged()) {
				transferenciasAux.setIsChanged(false);
			}		
			
			if(transferenciasAux.getIsNew()) {
				transferenciasAux.setIsNew(false);
			}	
			
			if(transferenciasAux.getIsDeleted()) {
				transferenciasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransferencias(Transferencias transferenciasAux) throws Exception {
		//this.transferenciasAux=transferenciasAux;
		
			if(transferenciasAux.getIsChanged()) {
				transferenciasAux.setIsChanged(false);
			}		
			
			if(transferenciasAux.getIsNew()) {
				transferenciasAux.setIsNew(false);
			}	
			
			if(transferenciasAux.getIsDeleted()) {
				transferenciasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Transferencias transferenciasAsignar,Transferencias transferencias) throws Exception {
		transferenciasAsignar.setId(transferencias.getId());	
		transferenciasAsignar.setVersionRow(transferencias.getVersionRow());	
		transferenciasAsignar.setempresa_origen(transferencias.getempresa_origen());	
		transferenciasAsignar.setsucursal_origen(transferencias.getsucursal_origen());	
		transferenciasAsignar.setsub_grupo_origen(transferencias.getsub_grupo_origen());	
		transferenciasAsignar.setgrupo_origen(transferencias.getgrupo_origen());	
		transferenciasAsignar.setactivo_origen(transferencias.getactivo_origen());	
		transferenciasAsignar.setempresa_destino(transferencias.getempresa_destino());	
		transferenciasAsignar.setsucursal_destino(transferencias.getsucursal_destino());	
		transferenciasAsignar.setsub_grupo_destino(transferencias.getsub_grupo_destino());	
		transferenciasAsignar.setgrupo_destino(transferencias.getgrupo_destino());	
		transferenciasAsignar.setactivo_destino(transferencias.getactivo_destino());	
		transferenciasAsignar.setsecuencial(transferencias.getsecuencial());	
		transferenciasAsignar.setfecha(transferencias.getfecha());	
		transferenciasAsignar.setnumero_documento(transferencias.getnumero_documento());	
		transferenciasAsignar.setcosto(transferencias.getcosto());	
		transferenciasAsignar.setdepreciacion(transferencias.getdepreciacion());	
		transferenciasAsignar.setcosto_origen(transferencias.getcosto_origen());	
		transferenciasAsignar.setdepreciacion_origen(transferencias.getdepreciacion_origen());	
		transferenciasAsignar.setrazon(transferencias.getrazon());	
		transferenciasAsignar.setdescripcion(transferencias.getdescripcion());	
		transferenciasAsignar.settipo(transferencias.gettipo());	
	}
	
	public static void inicializarTransferencias(Transferencias transferencias) throws Exception {
		try {
				transferencias.setId(0L);	
					
				transferencias.setempresa_origen("");	
				transferencias.setsucursal_origen("");	
				transferencias.setsub_grupo_origen("");	
				transferencias.setgrupo_origen("");	
				transferencias.setactivo_origen("");	
				transferencias.setempresa_destino("");	
				transferencias.setsucursal_destino("");	
				transferencias.setsub_grupo_destino("");	
				transferencias.setgrupo_destino("");	
				transferencias.setactivo_destino("");	
				transferencias.setsecuencial("");	
				transferencias.setfecha(new Date());	
				transferencias.setnumero_documento("");	
				transferencias.setcosto(0.0);	
				transferencias.setdepreciacion(0.0);	
				transferencias.setcosto_origen(0.0);	
				transferencias.setdepreciacion_origen(0.0);	
				transferencias.setrazon("");	
				transferencias.setdescripcion("");	
				transferencias.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransferencias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_EMPRESAORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_SUCURSALORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_SUBGRUPOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_GRUPOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_ACTIVOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_EMPRESADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_SUCURSALDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_SUBGRUPODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_GRUPODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_ACTIVODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_DEPRECIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_COSTOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_RAZON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransferencias(String sTipo,Row row,Workbook workbook,Transferencias transferencias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getempresa_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getsucursal_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getsub_grupo_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getgrupo_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getactivo_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getempresa_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getsucursal_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getsub_grupo_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getgrupo_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getactivo_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getdepreciacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getcosto_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getdepreciacion_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getrazon());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencias.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransferencias="";
	
	public String getsFinalQueryTransferencias() {
		return this.sFinalQueryTransferencias;
	}
	
	public void setsFinalQueryTransferencias(String sFinalQueryTransferencias) {
		this.sFinalQueryTransferencias= sFinalQueryTransferencias;
	}
	
	public Border resaltarSeleccionarTransferencias=null;
	
	public Border setResaltarSeleccionarTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransferencias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransferencias() {
		return this.resaltarSeleccionarTransferencias;
	}
	
	public void setResaltarSeleccionarTransferencias(Border borderResaltarSeleccionarTransferencias) {
		this.resaltarSeleccionarTransferencias= borderResaltarSeleccionarTransferencias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransferencias=null;
	public Boolean mostraridTransferencias=true;
	public Boolean activaridTransferencias=true;

	public Border resaltarid_empresaTransferencias=null;
	public Boolean mostrarid_empresaTransferencias=true;
	public Boolean activarid_empresaTransferencias=true;
	public Boolean cargarid_empresaTransferencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransferencias=false;//ConEventDepend=true

	public Border resaltarempresa_origenTransferencias=null;
	public Boolean mostrarempresa_origenTransferencias=true;
	public Boolean activarempresa_origenTransferencias=true;

	public Border resaltarsucursal_origenTransferencias=null;
	public Boolean mostrarsucursal_origenTransferencias=true;
	public Boolean activarsucursal_origenTransferencias=true;

	public Border resaltarsub_grupo_origenTransferencias=null;
	public Boolean mostrarsub_grupo_origenTransferencias=true;
	public Boolean activarsub_grupo_origenTransferencias=true;

	public Border resaltargrupo_origenTransferencias=null;
	public Boolean mostrargrupo_origenTransferencias=true;
	public Boolean activargrupo_origenTransferencias=true;

	public Border resaltaractivo_origenTransferencias=null;
	public Boolean mostraractivo_origenTransferencias=true;
	public Boolean activaractivo_origenTransferencias=true;

	public Border resaltarempresa_destinoTransferencias=null;
	public Boolean mostrarempresa_destinoTransferencias=true;
	public Boolean activarempresa_destinoTransferencias=true;

	public Border resaltarsucursal_destinoTransferencias=null;
	public Boolean mostrarsucursal_destinoTransferencias=true;
	public Boolean activarsucursal_destinoTransferencias=true;

	public Border resaltarsub_grupo_destinoTransferencias=null;
	public Boolean mostrarsub_grupo_destinoTransferencias=true;
	public Boolean activarsub_grupo_destinoTransferencias=true;

	public Border resaltargrupo_destinoTransferencias=null;
	public Boolean mostrargrupo_destinoTransferencias=true;
	public Boolean activargrupo_destinoTransferencias=true;

	public Border resaltaractivo_destinoTransferencias=null;
	public Boolean mostraractivo_destinoTransferencias=true;
	public Boolean activaractivo_destinoTransferencias=true;

	public Border resaltarsecuencialTransferencias=null;
	public Boolean mostrarsecuencialTransferencias=true;
	public Boolean activarsecuencialTransferencias=true;

	public Border resaltarfechaTransferencias=null;
	public Boolean mostrarfechaTransferencias=true;
	public Boolean activarfechaTransferencias=true;

	public Border resaltarnumero_documentoTransferencias=null;
	public Boolean mostrarnumero_documentoTransferencias=true;
	public Boolean activarnumero_documentoTransferencias=true;

	public Border resaltarcostoTransferencias=null;
	public Boolean mostrarcostoTransferencias=true;
	public Boolean activarcostoTransferencias=true;

	public Border resaltardepreciacionTransferencias=null;
	public Boolean mostrardepreciacionTransferencias=true;
	public Boolean activardepreciacionTransferencias=true;

	public Border resaltarcosto_origenTransferencias=null;
	public Boolean mostrarcosto_origenTransferencias=true;
	public Boolean activarcosto_origenTransferencias=true;

	public Border resaltardepreciacion_origenTransferencias=null;
	public Boolean mostrardepreciacion_origenTransferencias=true;
	public Boolean activardepreciacion_origenTransferencias=true;

	public Border resaltarrazonTransferencias=null;
	public Boolean mostrarrazonTransferencias=true;
	public Boolean activarrazonTransferencias=true;

	public Border resaltardescripcionTransferencias=null;
	public Boolean mostrardescripcionTransferencias=true;
	public Boolean activardescripcionTransferencias=true;

	public Border resaltartipoTransferencias=null;
	public Boolean mostrartipoTransferencias=true;
	public Boolean activartipoTransferencias=true;

	
	

	public Border setResaltaridTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltaridTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransferencias() {
		return this.resaltaridTransferencias;
	}

	public void setResaltaridTransferencias(Border borderResaltar) {
		this.resaltaridTransferencias= borderResaltar;
	}

	public Boolean getMostraridTransferencias() {
		return this.mostraridTransferencias;
	}

	public void setMostraridTransferencias(Boolean mostraridTransferencias) {
		this.mostraridTransferencias= mostraridTransferencias;
	}

	public Boolean getActivaridTransferencias() {
		return this.activaridTransferencias;
	}

	public void setActivaridTransferencias(Boolean activaridTransferencias) {
		this.activaridTransferencias= activaridTransferencias;
	}

	public Border setResaltarid_empresaTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransferencias() {
		return this.resaltarid_empresaTransferencias;
	}

	public void setResaltarid_empresaTransferencias(Border borderResaltar) {
		this.resaltarid_empresaTransferencias= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransferencias() {
		return this.mostrarid_empresaTransferencias;
	}

	public void setMostrarid_empresaTransferencias(Boolean mostrarid_empresaTransferencias) {
		this.mostrarid_empresaTransferencias= mostrarid_empresaTransferencias;
	}

	public Boolean getActivarid_empresaTransferencias() {
		return this.activarid_empresaTransferencias;
	}

	public void setActivarid_empresaTransferencias(Boolean activarid_empresaTransferencias) {
		this.activarid_empresaTransferencias= activarid_empresaTransferencias;
	}

	public Boolean getCargarid_empresaTransferencias() {
		return this.cargarid_empresaTransferencias;
	}

	public void setCargarid_empresaTransferencias(Boolean cargarid_empresaTransferencias) {
		this.cargarid_empresaTransferencias= cargarid_empresaTransferencias;
	}

	public Border setResaltarempresa_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarempresa_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempresa_origenTransferencias() {
		return this.resaltarempresa_origenTransferencias;
	}

	public void setResaltarempresa_origenTransferencias(Border borderResaltar) {
		this.resaltarempresa_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrarempresa_origenTransferencias() {
		return this.mostrarempresa_origenTransferencias;
	}

	public void setMostrarempresa_origenTransferencias(Boolean mostrarempresa_origenTransferencias) {
		this.mostrarempresa_origenTransferencias= mostrarempresa_origenTransferencias;
	}

	public Boolean getActivarempresa_origenTransferencias() {
		return this.activarempresa_origenTransferencias;
	}

	public void setActivarempresa_origenTransferencias(Boolean activarempresa_origenTransferencias) {
		this.activarempresa_origenTransferencias= activarempresa_origenTransferencias;
	}

	public Border setResaltarsucursal_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarsucursal_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsucursal_origenTransferencias() {
		return this.resaltarsucursal_origenTransferencias;
	}

	public void setResaltarsucursal_origenTransferencias(Border borderResaltar) {
		this.resaltarsucursal_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrarsucursal_origenTransferencias() {
		return this.mostrarsucursal_origenTransferencias;
	}

	public void setMostrarsucursal_origenTransferencias(Boolean mostrarsucursal_origenTransferencias) {
		this.mostrarsucursal_origenTransferencias= mostrarsucursal_origenTransferencias;
	}

	public Boolean getActivarsucursal_origenTransferencias() {
		return this.activarsucursal_origenTransferencias;
	}

	public void setActivarsucursal_origenTransferencias(Boolean activarsucursal_origenTransferencias) {
		this.activarsucursal_origenTransferencias= activarsucursal_origenTransferencias;
	}

	public Border setResaltarsub_grupo_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarsub_grupo_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_grupo_origenTransferencias() {
		return this.resaltarsub_grupo_origenTransferencias;
	}

	public void setResaltarsub_grupo_origenTransferencias(Border borderResaltar) {
		this.resaltarsub_grupo_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrarsub_grupo_origenTransferencias() {
		return this.mostrarsub_grupo_origenTransferencias;
	}

	public void setMostrarsub_grupo_origenTransferencias(Boolean mostrarsub_grupo_origenTransferencias) {
		this.mostrarsub_grupo_origenTransferencias= mostrarsub_grupo_origenTransferencias;
	}

	public Boolean getActivarsub_grupo_origenTransferencias() {
		return this.activarsub_grupo_origenTransferencias;
	}

	public void setActivarsub_grupo_origenTransferencias(Boolean activarsub_grupo_origenTransferencias) {
		this.activarsub_grupo_origenTransferencias= activarsub_grupo_origenTransferencias;
	}

	public Border setResaltargrupo_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltargrupo_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargrupo_origenTransferencias() {
		return this.resaltargrupo_origenTransferencias;
	}

	public void setResaltargrupo_origenTransferencias(Border borderResaltar) {
		this.resaltargrupo_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrargrupo_origenTransferencias() {
		return this.mostrargrupo_origenTransferencias;
	}

	public void setMostrargrupo_origenTransferencias(Boolean mostrargrupo_origenTransferencias) {
		this.mostrargrupo_origenTransferencias= mostrargrupo_origenTransferencias;
	}

	public Boolean getActivargrupo_origenTransferencias() {
		return this.activargrupo_origenTransferencias;
	}

	public void setActivargrupo_origenTransferencias(Boolean activargrupo_origenTransferencias) {
		this.activargrupo_origenTransferencias= activargrupo_origenTransferencias;
	}

	public Border setResaltaractivo_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltaractivo_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractivo_origenTransferencias() {
		return this.resaltaractivo_origenTransferencias;
	}

	public void setResaltaractivo_origenTransferencias(Border borderResaltar) {
		this.resaltaractivo_origenTransferencias= borderResaltar;
	}

	public Boolean getMostraractivo_origenTransferencias() {
		return this.mostraractivo_origenTransferencias;
	}

	public void setMostraractivo_origenTransferencias(Boolean mostraractivo_origenTransferencias) {
		this.mostraractivo_origenTransferencias= mostraractivo_origenTransferencias;
	}

	public Boolean getActivaractivo_origenTransferencias() {
		return this.activaractivo_origenTransferencias;
	}

	public void setActivaractivo_origenTransferencias(Boolean activaractivo_origenTransferencias) {
		this.activaractivo_origenTransferencias= activaractivo_origenTransferencias;
	}

	public Border setResaltarempresa_destinoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarempresa_destinoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempresa_destinoTransferencias() {
		return this.resaltarempresa_destinoTransferencias;
	}

	public void setResaltarempresa_destinoTransferencias(Border borderResaltar) {
		this.resaltarempresa_destinoTransferencias= borderResaltar;
	}

	public Boolean getMostrarempresa_destinoTransferencias() {
		return this.mostrarempresa_destinoTransferencias;
	}

	public void setMostrarempresa_destinoTransferencias(Boolean mostrarempresa_destinoTransferencias) {
		this.mostrarempresa_destinoTransferencias= mostrarempresa_destinoTransferencias;
	}

	public Boolean getActivarempresa_destinoTransferencias() {
		return this.activarempresa_destinoTransferencias;
	}

	public void setActivarempresa_destinoTransferencias(Boolean activarempresa_destinoTransferencias) {
		this.activarempresa_destinoTransferencias= activarempresa_destinoTransferencias;
	}

	public Border setResaltarsucursal_destinoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarsucursal_destinoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsucursal_destinoTransferencias() {
		return this.resaltarsucursal_destinoTransferencias;
	}

	public void setResaltarsucursal_destinoTransferencias(Border borderResaltar) {
		this.resaltarsucursal_destinoTransferencias= borderResaltar;
	}

	public Boolean getMostrarsucursal_destinoTransferencias() {
		return this.mostrarsucursal_destinoTransferencias;
	}

	public void setMostrarsucursal_destinoTransferencias(Boolean mostrarsucursal_destinoTransferencias) {
		this.mostrarsucursal_destinoTransferencias= mostrarsucursal_destinoTransferencias;
	}

	public Boolean getActivarsucursal_destinoTransferencias() {
		return this.activarsucursal_destinoTransferencias;
	}

	public void setActivarsucursal_destinoTransferencias(Boolean activarsucursal_destinoTransferencias) {
		this.activarsucursal_destinoTransferencias= activarsucursal_destinoTransferencias;
	}

	public Border setResaltarsub_grupo_destinoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarsub_grupo_destinoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_grupo_destinoTransferencias() {
		return this.resaltarsub_grupo_destinoTransferencias;
	}

	public void setResaltarsub_grupo_destinoTransferencias(Border borderResaltar) {
		this.resaltarsub_grupo_destinoTransferencias= borderResaltar;
	}

	public Boolean getMostrarsub_grupo_destinoTransferencias() {
		return this.mostrarsub_grupo_destinoTransferencias;
	}

	public void setMostrarsub_grupo_destinoTransferencias(Boolean mostrarsub_grupo_destinoTransferencias) {
		this.mostrarsub_grupo_destinoTransferencias= mostrarsub_grupo_destinoTransferencias;
	}

	public Boolean getActivarsub_grupo_destinoTransferencias() {
		return this.activarsub_grupo_destinoTransferencias;
	}

	public void setActivarsub_grupo_destinoTransferencias(Boolean activarsub_grupo_destinoTransferencias) {
		this.activarsub_grupo_destinoTransferencias= activarsub_grupo_destinoTransferencias;
	}

	public Border setResaltargrupo_destinoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltargrupo_destinoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargrupo_destinoTransferencias() {
		return this.resaltargrupo_destinoTransferencias;
	}

	public void setResaltargrupo_destinoTransferencias(Border borderResaltar) {
		this.resaltargrupo_destinoTransferencias= borderResaltar;
	}

	public Boolean getMostrargrupo_destinoTransferencias() {
		return this.mostrargrupo_destinoTransferencias;
	}

	public void setMostrargrupo_destinoTransferencias(Boolean mostrargrupo_destinoTransferencias) {
		this.mostrargrupo_destinoTransferencias= mostrargrupo_destinoTransferencias;
	}

	public Boolean getActivargrupo_destinoTransferencias() {
		return this.activargrupo_destinoTransferencias;
	}

	public void setActivargrupo_destinoTransferencias(Boolean activargrupo_destinoTransferencias) {
		this.activargrupo_destinoTransferencias= activargrupo_destinoTransferencias;
	}

	public Border setResaltaractivo_destinoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltaractivo_destinoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractivo_destinoTransferencias() {
		return this.resaltaractivo_destinoTransferencias;
	}

	public void setResaltaractivo_destinoTransferencias(Border borderResaltar) {
		this.resaltaractivo_destinoTransferencias= borderResaltar;
	}

	public Boolean getMostraractivo_destinoTransferencias() {
		return this.mostraractivo_destinoTransferencias;
	}

	public void setMostraractivo_destinoTransferencias(Boolean mostraractivo_destinoTransferencias) {
		this.mostraractivo_destinoTransferencias= mostraractivo_destinoTransferencias;
	}

	public Boolean getActivaractivo_destinoTransferencias() {
		return this.activaractivo_destinoTransferencias;
	}

	public void setActivaractivo_destinoTransferencias(Boolean activaractivo_destinoTransferencias) {
		this.activaractivo_destinoTransferencias= activaractivo_destinoTransferencias;
	}

	public Border setResaltarsecuencialTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarsecuencialTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialTransferencias() {
		return this.resaltarsecuencialTransferencias;
	}

	public void setResaltarsecuencialTransferencias(Border borderResaltar) {
		this.resaltarsecuencialTransferencias= borderResaltar;
	}

	public Boolean getMostrarsecuencialTransferencias() {
		return this.mostrarsecuencialTransferencias;
	}

	public void setMostrarsecuencialTransferencias(Boolean mostrarsecuencialTransferencias) {
		this.mostrarsecuencialTransferencias= mostrarsecuencialTransferencias;
	}

	public Boolean getActivarsecuencialTransferencias() {
		return this.activarsecuencialTransferencias;
	}

	public void setActivarsecuencialTransferencias(Boolean activarsecuencialTransferencias) {
		this.activarsecuencialTransferencias= activarsecuencialTransferencias;
	}

	public Border setResaltarfechaTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarfechaTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaTransferencias() {
		return this.resaltarfechaTransferencias;
	}

	public void setResaltarfechaTransferencias(Border borderResaltar) {
		this.resaltarfechaTransferencias= borderResaltar;
	}

	public Boolean getMostrarfechaTransferencias() {
		return this.mostrarfechaTransferencias;
	}

	public void setMostrarfechaTransferencias(Boolean mostrarfechaTransferencias) {
		this.mostrarfechaTransferencias= mostrarfechaTransferencias;
	}

	public Boolean getActivarfechaTransferencias() {
		return this.activarfechaTransferencias;
	}

	public void setActivarfechaTransferencias(Boolean activarfechaTransferencias) {
		this.activarfechaTransferencias= activarfechaTransferencias;
	}

	public Border setResaltarnumero_documentoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoTransferencias() {
		return this.resaltarnumero_documentoTransferencias;
	}

	public void setResaltarnumero_documentoTransferencias(Border borderResaltar) {
		this.resaltarnumero_documentoTransferencias= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoTransferencias() {
		return this.mostrarnumero_documentoTransferencias;
	}

	public void setMostrarnumero_documentoTransferencias(Boolean mostrarnumero_documentoTransferencias) {
		this.mostrarnumero_documentoTransferencias= mostrarnumero_documentoTransferencias;
	}

	public Boolean getActivarnumero_documentoTransferencias() {
		return this.activarnumero_documentoTransferencias;
	}

	public void setActivarnumero_documentoTransferencias(Boolean activarnumero_documentoTransferencias) {
		this.activarnumero_documentoTransferencias= activarnumero_documentoTransferencias;
	}

	public Border setResaltarcostoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarcostoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoTransferencias() {
		return this.resaltarcostoTransferencias;
	}

	public void setResaltarcostoTransferencias(Border borderResaltar) {
		this.resaltarcostoTransferencias= borderResaltar;
	}

	public Boolean getMostrarcostoTransferencias() {
		return this.mostrarcostoTransferencias;
	}

	public void setMostrarcostoTransferencias(Boolean mostrarcostoTransferencias) {
		this.mostrarcostoTransferencias= mostrarcostoTransferencias;
	}

	public Boolean getActivarcostoTransferencias() {
		return this.activarcostoTransferencias;
	}

	public void setActivarcostoTransferencias(Boolean activarcostoTransferencias) {
		this.activarcostoTransferencias= activarcostoTransferencias;
	}

	public Border setResaltardepreciacionTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltardepreciacionTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardepreciacionTransferencias() {
		return this.resaltardepreciacionTransferencias;
	}

	public void setResaltardepreciacionTransferencias(Border borderResaltar) {
		this.resaltardepreciacionTransferencias= borderResaltar;
	}

	public Boolean getMostrardepreciacionTransferencias() {
		return this.mostrardepreciacionTransferencias;
	}

	public void setMostrardepreciacionTransferencias(Boolean mostrardepreciacionTransferencias) {
		this.mostrardepreciacionTransferencias= mostrardepreciacionTransferencias;
	}

	public Boolean getActivardepreciacionTransferencias() {
		return this.activardepreciacionTransferencias;
	}

	public void setActivardepreciacionTransferencias(Boolean activardepreciacionTransferencias) {
		this.activardepreciacionTransferencias= activardepreciacionTransferencias;
	}

	public Border setResaltarcosto_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarcosto_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_origenTransferencias() {
		return this.resaltarcosto_origenTransferencias;
	}

	public void setResaltarcosto_origenTransferencias(Border borderResaltar) {
		this.resaltarcosto_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrarcosto_origenTransferencias() {
		return this.mostrarcosto_origenTransferencias;
	}

	public void setMostrarcosto_origenTransferencias(Boolean mostrarcosto_origenTransferencias) {
		this.mostrarcosto_origenTransferencias= mostrarcosto_origenTransferencias;
	}

	public Boolean getActivarcosto_origenTransferencias() {
		return this.activarcosto_origenTransferencias;
	}

	public void setActivarcosto_origenTransferencias(Boolean activarcosto_origenTransferencias) {
		this.activarcosto_origenTransferencias= activarcosto_origenTransferencias;
	}

	public Border setResaltardepreciacion_origenTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltardepreciacion_origenTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardepreciacion_origenTransferencias() {
		return this.resaltardepreciacion_origenTransferencias;
	}

	public void setResaltardepreciacion_origenTransferencias(Border borderResaltar) {
		this.resaltardepreciacion_origenTransferencias= borderResaltar;
	}

	public Boolean getMostrardepreciacion_origenTransferencias() {
		return this.mostrardepreciacion_origenTransferencias;
	}

	public void setMostrardepreciacion_origenTransferencias(Boolean mostrardepreciacion_origenTransferencias) {
		this.mostrardepreciacion_origenTransferencias= mostrardepreciacion_origenTransferencias;
	}

	public Boolean getActivardepreciacion_origenTransferencias() {
		return this.activardepreciacion_origenTransferencias;
	}

	public void setActivardepreciacion_origenTransferencias(Boolean activardepreciacion_origenTransferencias) {
		this.activardepreciacion_origenTransferencias= activardepreciacion_origenTransferencias;
	}

	public Border setResaltarrazonTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltarrazonTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrazonTransferencias() {
		return this.resaltarrazonTransferencias;
	}

	public void setResaltarrazonTransferencias(Border borderResaltar) {
		this.resaltarrazonTransferencias= borderResaltar;
	}

	public Boolean getMostrarrazonTransferencias() {
		return this.mostrarrazonTransferencias;
	}

	public void setMostrarrazonTransferencias(Boolean mostrarrazonTransferencias) {
		this.mostrarrazonTransferencias= mostrarrazonTransferencias;
	}

	public Boolean getActivarrazonTransferencias() {
		return this.activarrazonTransferencias;
	}

	public void setActivarrazonTransferencias(Boolean activarrazonTransferencias) {
		this.activarrazonTransferencias= activarrazonTransferencias;
	}

	public Border setResaltardescripcionTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltardescripcionTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTransferencias() {
		return this.resaltardescripcionTransferencias;
	}

	public void setResaltardescripcionTransferencias(Border borderResaltar) {
		this.resaltardescripcionTransferencias= borderResaltar;
	}

	public Boolean getMostrardescripcionTransferencias() {
		return this.mostrardescripcionTransferencias;
	}

	public void setMostrardescripcionTransferencias(Boolean mostrardescripcionTransferencias) {
		this.mostrardescripcionTransferencias= mostrardescripcionTransferencias;
	}

	public Boolean getActivardescripcionTransferencias() {
		return this.activardescripcionTransferencias;
	}

	public void setActivardescripcionTransferencias(Boolean activardescripcionTransferencias) {
		this.activardescripcionTransferencias= activardescripcionTransferencias;
	}

	public Border setResaltartipoTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasBeanSwingJInternalFrame.jTtoolBarTransferencias.setBorder(borderResaltar);
		
		this.resaltartipoTransferencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoTransferencias() {
		return this.resaltartipoTransferencias;
	}

	public void setResaltartipoTransferencias(Border borderResaltar) {
		this.resaltartipoTransferencias= borderResaltar;
	}

	public Boolean getMostrartipoTransferencias() {
		return this.mostrartipoTransferencias;
	}

	public void setMostrartipoTransferencias(Boolean mostrartipoTransferencias) {
		this.mostrartipoTransferencias= mostrartipoTransferencias;
	}

	public Boolean getActivartipoTransferencias() {
		return this.activartipoTransferencias;
	}

	public void setActivartipoTransferencias(Boolean activartipoTransferencias) {
		this.activartipoTransferencias= activartipoTransferencias;
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
		
		
		this.setMostraridTransferencias(esInicial);
		this.setMostrarid_empresaTransferencias(esInicial);
		this.setMostrarempresa_origenTransferencias(esInicial);
		this.setMostrarsucursal_origenTransferencias(esInicial);
		this.setMostrarsub_grupo_origenTransferencias(esInicial);
		this.setMostrargrupo_origenTransferencias(esInicial);
		this.setMostraractivo_origenTransferencias(esInicial);
		this.setMostrarempresa_destinoTransferencias(esInicial);
		this.setMostrarsucursal_destinoTransferencias(esInicial);
		this.setMostrarsub_grupo_destinoTransferencias(esInicial);
		this.setMostrargrupo_destinoTransferencias(esInicial);
		this.setMostraractivo_destinoTransferencias(esInicial);
		this.setMostrarsecuencialTransferencias(esInicial);
		this.setMostrarfechaTransferencias(esInicial);
		this.setMostrarnumero_documentoTransferencias(esInicial);
		this.setMostrarcostoTransferencias(esInicial);
		this.setMostrardepreciacionTransferencias(esInicial);
		this.setMostrarcosto_origenTransferencias(esInicial);
		this.setMostrardepreciacion_origenTransferencias(esInicial);
		this.setMostrarrazonTransferencias(esInicial);
		this.setMostrardescripcionTransferencias(esInicial);
		this.setMostrartipoTransferencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasConstantesFunciones.ID)) {
				this.setMostraridTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESAORIGEN)) {
				this.setMostrarempresa_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALORIGEN)) {
				this.setMostrarsucursal_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPOORIGEN)) {
				this.setMostrarsub_grupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPOORIGEN)) {
				this.setMostrargrupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVOORIGEN)) {
				this.setMostraractivo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESADESTINO)) {
				this.setMostrarempresa_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALDESTINO)) {
				this.setMostrarsucursal_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPODESTINO)) {
				this.setMostrarsub_grupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPODESTINO)) {
				this.setMostrargrupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVODESTINO)) {
				this.setMostraractivo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.FECHA)) {
				this.setMostrarfechaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTO)) {
				this.setMostrarcostoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACION)) {
				this.setMostrardepreciacionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTOORIGEN)) {
				this.setMostrarcosto_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setMostrardepreciacion_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.RAZON)) {
				this.setMostrarrazonTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.TIPO)) {
				this.setMostrartipoTransferencias(esAsigna);
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
		
		
		this.setActivaridTransferencias(esInicial);
		this.setActivarid_empresaTransferencias(esInicial);
		this.setActivarempresa_origenTransferencias(esInicial);
		this.setActivarsucursal_origenTransferencias(esInicial);
		this.setActivarsub_grupo_origenTransferencias(esInicial);
		this.setActivargrupo_origenTransferencias(esInicial);
		this.setActivaractivo_origenTransferencias(esInicial);
		this.setActivarempresa_destinoTransferencias(esInicial);
		this.setActivarsucursal_destinoTransferencias(esInicial);
		this.setActivarsub_grupo_destinoTransferencias(esInicial);
		this.setActivargrupo_destinoTransferencias(esInicial);
		this.setActivaractivo_destinoTransferencias(esInicial);
		this.setActivarsecuencialTransferencias(esInicial);
		this.setActivarfechaTransferencias(esInicial);
		this.setActivarnumero_documentoTransferencias(esInicial);
		this.setActivarcostoTransferencias(esInicial);
		this.setActivardepreciacionTransferencias(esInicial);
		this.setActivarcosto_origenTransferencias(esInicial);
		this.setActivardepreciacion_origenTransferencias(esInicial);
		this.setActivarrazonTransferencias(esInicial);
		this.setActivardescripcionTransferencias(esInicial);
		this.setActivartipoTransferencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasConstantesFunciones.ID)) {
				this.setActivaridTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESAORIGEN)) {
				this.setActivarempresa_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALORIGEN)) {
				this.setActivarsucursal_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPOORIGEN)) {
				this.setActivarsub_grupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPOORIGEN)) {
				this.setActivargrupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVOORIGEN)) {
				this.setActivaractivo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESADESTINO)) {
				this.setActivarempresa_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALDESTINO)) {
				this.setActivarsucursal_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPODESTINO)) {
				this.setActivarsub_grupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPODESTINO)) {
				this.setActivargrupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVODESTINO)) {
				this.setActivaractivo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.FECHA)) {
				this.setActivarfechaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTO)) {
				this.setActivarcostoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACION)) {
				this.setActivardepreciacionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTOORIGEN)) {
				this.setActivarcosto_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setActivardepreciacion_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.RAZON)) {
				this.setActivarrazonTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.TIPO)) {
				this.setActivartipoTransferencias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransferencias(esInicial);
		this.setResaltarid_empresaTransferencias(esInicial);
		this.setResaltarempresa_origenTransferencias(esInicial);
		this.setResaltarsucursal_origenTransferencias(esInicial);
		this.setResaltarsub_grupo_origenTransferencias(esInicial);
		this.setResaltargrupo_origenTransferencias(esInicial);
		this.setResaltaractivo_origenTransferencias(esInicial);
		this.setResaltarempresa_destinoTransferencias(esInicial);
		this.setResaltarsucursal_destinoTransferencias(esInicial);
		this.setResaltarsub_grupo_destinoTransferencias(esInicial);
		this.setResaltargrupo_destinoTransferencias(esInicial);
		this.setResaltaractivo_destinoTransferencias(esInicial);
		this.setResaltarsecuencialTransferencias(esInicial);
		this.setResaltarfechaTransferencias(esInicial);
		this.setResaltarnumero_documentoTransferencias(esInicial);
		this.setResaltarcostoTransferencias(esInicial);
		this.setResaltardepreciacionTransferencias(esInicial);
		this.setResaltarcosto_origenTransferencias(esInicial);
		this.setResaltardepreciacion_origenTransferencias(esInicial);
		this.setResaltarrazonTransferencias(esInicial);
		this.setResaltardescripcionTransferencias(esInicial);
		this.setResaltartipoTransferencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasConstantesFunciones.ID)) {
				this.setResaltaridTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESAORIGEN)) {
				this.setResaltarempresa_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALORIGEN)) {
				this.setResaltarsucursal_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPOORIGEN)) {
				this.setResaltarsub_grupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPOORIGEN)) {
				this.setResaltargrupo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVOORIGEN)) {
				this.setResaltaractivo_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.EMPRESADESTINO)) {
				this.setResaltarempresa_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUCURSALDESTINO)) {
				this.setResaltarsucursal_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SUBGRUPODESTINO)) {
				this.setResaltarsub_grupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.GRUPODESTINO)) {
				this.setResaltargrupo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.ACTIVODESTINO)) {
				this.setResaltaractivo_destinoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.FECHA)) {
				this.setResaltarfechaTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTO)) {
				this.setResaltarcostoTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACION)) {
				this.setResaltardepreciacionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.COSTOORIGEN)) {
				this.setResaltarcosto_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setResaltardepreciacion_origenTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.RAZON)) {
				this.setResaltarrazonTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTransferencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasConstantesFunciones.TIPO)) {
				this.setResaltartipoTransferencias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaTransferenciasTransferencias=true;

	public Boolean getMostrarBusquedaTransferenciasTransferencias() {
		return this.mostrarBusquedaTransferenciasTransferencias;
	}

	public void setMostrarBusquedaTransferenciasTransferencias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaTransferenciasTransferencias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaTransferenciasTransferencias=true;

	public Boolean getActivarBusquedaTransferenciasTransferencias() {
		return this.activarBusquedaTransferenciasTransferencias;
	}

	public void setActivarBusquedaTransferenciasTransferencias(Boolean habilitarResaltar) {
		this.activarBusquedaTransferenciasTransferencias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaTransferenciasTransferencias=null;

	public Border getResaltarBusquedaTransferenciasTransferencias() {
		return this.resaltarBusquedaTransferenciasTransferencias;
	}

	public void setResaltarBusquedaTransferenciasTransferencias(Border borderResaltar) {
		this.resaltarBusquedaTransferenciasTransferencias= borderResaltar;
	}

	public void setResaltarBusquedaTransferenciasTransferencias(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasBeanSwingJInternalFrame transferenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaTransferenciasTransferencias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}