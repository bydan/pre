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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.ListadosDocumentosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ListadosDocumentosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ListadosDocumentosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ListadosDocumentosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadosDocumentos";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadosDocumentos"+ListadosDocumentosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadosDocumentosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadosDocumentosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadosDocumentosConstantesFunciones.SCHEMA+"_"+ListadosDocumentosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadosDocumentosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadosDocumentosConstantesFunciones.SCHEMA+"_"+ListadosDocumentosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadosDocumentosConstantesFunciones.SCHEMA+"_"+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadosDocumentosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadosDocumentosConstantesFunciones.SCHEMA+"_"+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosDocumentosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosDocumentosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosDocumentosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadosDocumentosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadosDocumentosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadosDocumentosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadosDocumentosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listados Documentoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listados Documentos";
	public static final String SCLASSWEBTITULO_LOWER="Listados Documentos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadosDocumentos";
	public static final String OBJECTNAME="listadosdocumentos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="listados_documentos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadosdocumentos from "+ListadosDocumentosConstantesFunciones.SPERSISTENCENAME+" listadosdocumentos";
	public static String QUERYSELECTNATIVE="select "+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".id,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".version_row,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".id_empresa,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".id_sucursal,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".id_ejercicio,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".fecha_desde,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".fecha_hasta,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".fecha,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".tipo_movimiento,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".codigo,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".beneficiario,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".beneficiario_cheque,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".detalle,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".valor_cheque,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".nombre_empresa,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".ruc_empresa,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".direccion_empresa,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".nombre_sucursal,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".valor,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".numero_mayor,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".fecha_emision,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".fecha_finalizacion,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".nombre_usuario,"+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME+".numero_cheque from "+ListadosDocumentosConstantesFunciones.SCHEMA+"."+ListadosDocumentosConstantesFunciones.TABLENAME;//+" as "+ListadosDocumentosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String FECHA= "fecha";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String CODIGO= "codigo";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String BENEFICIARIOCHEQUE= "beneficiario_cheque";
    public static final String DETALLE= "detalle";
    public static final String VALORCHEQUE= "valor_cheque";
    public static final String NOMBREEMPRESA= "nombre_empresa";
    public static final String RUCEMPRESA= "ruc_empresa";
    public static final String DIRECCIONEMPRESA= "direccion_empresa";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String VALOR= "valor";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAFINALIZACION= "fecha_finalizacion";
    public static final String NOMBREUSUARIO= "nombre_usuario";
    public static final String NUMEROCHEQUE= "numero_cheque";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento Base";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_BENEFICIARIOCHEQUE= "Beneficiario Cheque";
		public static final String LABEL_BENEFICIARIOCHEQUE_LOWER= "Beneficiario Cheque";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_VALORCHEQUE= "Valor Cheque";
		public static final String LABEL_VALORCHEQUE_LOWER= "Valor Cheque";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_RUCEMPRESA= "Ruc Empresa";
		public static final String LABEL_RUCEMPRESA_LOWER= "Ruc Empresa";
    	public static final String LABEL_DIRECCIONEMPRESA= "Direccion Empresa";
		public static final String LABEL_DIRECCIONEMPRESA_LOWER= "Direccion Empresa";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAFINALIZACION= "Fecha Finalizacion";
		public static final String LABEL_FECHAFINALIZACION_LOWER= "Fecha Finalizacion";
    	public static final String LABEL_NOMBREUSUARIO= "Nombre Usuario";
		public static final String LABEL_NOMBREUSUARIO_LOWER= "Nombre Usuario";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getListadosDocumentosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.FECHADESDE)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.FECHAHASTA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.FECHA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.CODIGO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIOCHEQUE;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.DETALLE)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.VALORCHEQUE)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.RUCEMPRESA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_RUCEMPRESA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_DIRECCIONEMPRESA;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.VALOR)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.FECHAEMISION)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.FECHAFINALIZACION)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_FECHAFINALIZACION;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.NOMBREUSUARIO)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_NOMBREUSUARIO;}
		if(sNombreColumna.equals(ListadosDocumentosConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ListadosDocumentosConstantesFunciones.LABEL_NUMEROCHEQUE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getListadosDocumentosDescripcion(ListadosDocumentos listadosdocumentos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadosdocumentos !=null/* && listadosdocumentos.getId()!=0*/) {
			sDescripcion=listadosdocumentos.getcodigo();//listadosdocumentoslistadosdocumentos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadosDocumentosDescripcionDetallado(ListadosDocumentos listadosdocumentos) {
		String sDescripcion="";
			
		sDescripcion+=ListadosDocumentosConstantesFunciones.ID+"=";
		sDescripcion+=listadosdocumentos.getId().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadosdocumentos.getVersionRow().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadosdocumentos.getid_empresa().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=listadosdocumentos.getid_sucursal().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=listadosdocumentos.getid_ejercicio().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=listadosdocumentos.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=listadosdocumentos.getfecha_desde().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=listadosdocumentos.getfecha_hasta().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.FECHA+"=";
		sDescripcion+=listadosdocumentos.getfecha().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=listadosdocumentos.gettipo_movimiento()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadosdocumentos.getcodigo()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=listadosdocumentos.getbeneficiario()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE+"=";
		sDescripcion+=listadosdocumentos.getbeneficiario_cheque()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.DETALLE+"=";
		sDescripcion+=listadosdocumentos.getdetalle()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.VALORCHEQUE+"=";
		sDescripcion+=listadosdocumentos.getvalor_cheque().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=listadosdocumentos.getnombre_empresa()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.RUCEMPRESA+"=";
		sDescripcion+=listadosdocumentos.getruc_empresa()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA+"=";
		sDescripcion+=listadosdocumentos.getdireccion_empresa()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=listadosdocumentos.getnombre_sucursal()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.VALOR+"=";
		sDescripcion+=listadosdocumentos.getvalor().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=listadosdocumentos.getnumero_mayor()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=listadosdocumentos.getfecha_emision().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.FECHAFINALIZACION+"=";
		sDescripcion+=listadosdocumentos.getfecha_finalizacion().toString()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.NOMBREUSUARIO+"=";
		sDescripcion+=listadosdocumentos.getnombre_usuario()+",";
		sDescripcion+=ListadosDocumentosConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=listadosdocumentos.getnumero_cheque()+",";
			
		return sDescripcion;
	}
	
	public static void setListadosDocumentosDescripcion(ListadosDocumentos listadosdocumentos,String sValor) throws Exception {			
		if(listadosdocumentos !=null) {
			listadosdocumentos.setcodigo(sValor);;//listadosdocumentoslistadosdocumentos.getcodigo().trim();
		}		
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaListadosDocumentos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Tipo Movimiento Base Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Base";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadosDocumentos(Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadosDocumentos(ListadosDocumentos listadosdocumentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadosdocumentos.settipo_movimiento(listadosdocumentos.gettipo_movimiento().trim());
		listadosdocumentos.setcodigo(listadosdocumentos.getcodigo().trim());
		listadosdocumentos.setbeneficiario(listadosdocumentos.getbeneficiario().trim());
		listadosdocumentos.setbeneficiario_cheque(listadosdocumentos.getbeneficiario_cheque().trim());
		listadosdocumentos.setdetalle(listadosdocumentos.getdetalle().trim());
		listadosdocumentos.setnombre_empresa(listadosdocumentos.getnombre_empresa().trim());
		listadosdocumentos.setruc_empresa(listadosdocumentos.getruc_empresa().trim());
		listadosdocumentos.setdireccion_empresa(listadosdocumentos.getdireccion_empresa().trim());
		listadosdocumentos.setnombre_sucursal(listadosdocumentos.getnombre_sucursal().trim());
		listadosdocumentos.setnumero_mayor(listadosdocumentos.getnumero_mayor().trim());
		listadosdocumentos.setnombre_usuario(listadosdocumentos.getnombre_usuario().trim());
		listadosdocumentos.setnumero_cheque(listadosdocumentos.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosListadosDocumentoss(List<ListadosDocumentos> listadosdocumentoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {
			listadosdocumentos.settipo_movimiento(listadosdocumentos.gettipo_movimiento().trim());
			listadosdocumentos.setcodigo(listadosdocumentos.getcodigo().trim());
			listadosdocumentos.setbeneficiario(listadosdocumentos.getbeneficiario().trim());
			listadosdocumentos.setbeneficiario_cheque(listadosdocumentos.getbeneficiario_cheque().trim());
			listadosdocumentos.setdetalle(listadosdocumentos.getdetalle().trim());
			listadosdocumentos.setnombre_empresa(listadosdocumentos.getnombre_empresa().trim());
			listadosdocumentos.setruc_empresa(listadosdocumentos.getruc_empresa().trim());
			listadosdocumentos.setdireccion_empresa(listadosdocumentos.getdireccion_empresa().trim());
			listadosdocumentos.setnombre_sucursal(listadosdocumentos.getnombre_sucursal().trim());
			listadosdocumentos.setnumero_mayor(listadosdocumentos.getnumero_mayor().trim());
			listadosdocumentos.setnombre_usuario(listadosdocumentos.getnombre_usuario().trim());
			listadosdocumentos.setnumero_cheque(listadosdocumentos.getnumero_cheque().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosDocumentos(ListadosDocumentos listadosdocumentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadosdocumentos.getConCambioAuxiliar()) {
			listadosdocumentos.setIsDeleted(listadosdocumentos.getIsDeletedAuxiliar());	
			listadosdocumentos.setIsNew(listadosdocumentos.getIsNewAuxiliar());	
			listadosdocumentos.setIsChanged(listadosdocumentos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadosdocumentos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadosdocumentos.setIsDeletedAuxiliar(false);	
			listadosdocumentos.setIsNewAuxiliar(false);	
			listadosdocumentos.setIsChangedAuxiliar(false);
			
			listadosdocumentos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosDocumentoss(List<ListadosDocumentos> listadosdocumentoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadosDocumentos listadosdocumentos : listadosdocumentoss) {
			if(conAsignarBase && listadosdocumentos.getConCambioAuxiliar()) {
				listadosdocumentos.setIsDeleted(listadosdocumentos.getIsDeletedAuxiliar());	
				listadosdocumentos.setIsNew(listadosdocumentos.getIsNewAuxiliar());	
				listadosdocumentos.setIsChanged(listadosdocumentos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadosdocumentos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadosdocumentos.setIsDeletedAuxiliar(false);	
				listadosdocumentos.setIsNewAuxiliar(false);	
				listadosdocumentos.setIsChangedAuxiliar(false);
				
				listadosdocumentos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadosDocumentos(ListadosDocumentos listadosdocumentos,Boolean conEnteros) throws Exception  {
		listadosdocumentos.setvalor_cheque(0.0);
		listadosdocumentos.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadosDocumentoss(List<ListadosDocumentos> listadosdocumentoss,Boolean conEnteros) throws Exception  {
		
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {
			listadosdocumentos.setvalor_cheque(0.0);
			listadosdocumentos.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadosDocumentos(List<ListadosDocumentos> listadosdocumentoss,ListadosDocumentos listadosdocumentosAux) throws Exception  {
		ListadosDocumentosConstantesFunciones.InicializarValoresListadosDocumentos(listadosdocumentosAux,true);
		
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {
			if(listadosdocumentos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadosdocumentosAux.setvalor_cheque(listadosdocumentosAux.getvalor_cheque()+listadosdocumentos.getvalor_cheque());			
			listadosdocumentosAux.setvalor(listadosdocumentosAux.getvalor()+listadosdocumentos.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosDocumentos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadosDocumentosConstantesFunciones.getArrayColumnasGlobalesListadosDocumentos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosDocumentos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosDocumentosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosDocumentosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosDocumentosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosDocumentosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadosDocumentos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosDocumentos> listadosdocumentoss,ListadosDocumentos listadosdocumentos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosDocumentos listadosdocumentosAux: listadosdocumentoss) {
			if(listadosdocumentosAux!=null && listadosdocumentos!=null) {
				if((listadosdocumentosAux.getId()==null && listadosdocumentos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadosdocumentosAux.getId()!=null && listadosdocumentos.getId()!=null){
					if(listadosdocumentosAux.getId().equals(listadosdocumentos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosDocumentos(List<ListadosDocumentos> listadosdocumentoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_chequeTotal=0.0;
		Double valorTotal=0.0;
	
		for(ListadosDocumentos listadosdocumentos: listadosdocumentoss) {			
			if(listadosdocumentos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_chequeTotal+=listadosdocumentos.getvalor_cheque();
			valorTotal+=listadosdocumentos.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosDocumentosConstantesFunciones.VALORCHEQUE);
		datoGeneral.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE);
		datoGeneral.setdValorDouble(valor_chequeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosDocumentosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadosDocumentos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_ID, ListadosDocumentosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_VERSIONROW, ListadosDocumentosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_FECHA, ListadosDocumentosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_TIPOMOVIMIENTO, ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_CODIGO, ListadosDocumentosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIO, ListadosDocumentosConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIOCHEQUE, ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_DETALLE, ListadosDocumentosConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE, ListadosDocumentosConstantesFunciones.VALORCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_NOMBREEMPRESA, ListadosDocumentosConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_RUCEMPRESA, ListadosDocumentosConstantesFunciones.RUCEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_DIRECCIONEMPRESA, ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_NOMBRESUCURSAL, ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_VALOR, ListadosDocumentosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_NUMEROMAYOR, ListadosDocumentosConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_FECHAEMISION, ListadosDocumentosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_FECHAFINALIZACION, ListadosDocumentosConstantesFunciones.FECHAFINALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_NOMBREUSUARIO, ListadosDocumentosConstantesFunciones.NOMBREUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosDocumentosConstantesFunciones.LABEL_NUMEROCHEQUE, ListadosDocumentosConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadosDocumentos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.VALORCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.RUCEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.FECHAFINALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.NOMBREUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosDocumentosConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosDocumentos() throws Exception  {
		return ListadosDocumentosConstantesFunciones.getTiposSeleccionarListadosDocumentos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosDocumentos(Boolean conFk) throws Exception  {
		return ListadosDocumentosConstantesFunciones.getTiposSeleccionarListadosDocumentos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosDocumentos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIOCHEQUE);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIOCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_RUCEMPRESA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_RUCEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_DIRECCIONEMPRESA);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_DIRECCIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_FECHAFINALIZACION);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_FECHAFINALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_NOMBREUSUARIO);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_NOMBREUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosDocumentosConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ListadosDocumentosConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadosDocumentos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadosDocumentos(ListadosDocumentos listadosdocumentosAux) throws Exception {
		
			listadosdocumentosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosdocumentosAux.getEmpresa()));
			listadosdocumentosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(listadosdocumentosAux.getSucursal()));
			listadosdocumentosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(listadosdocumentosAux.getEjercicio()));
			listadosdocumentosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(listadosdocumentosAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadosDocumentos(List<ListadosDocumentos> listadosdocumentossTemp) throws Exception {
		for(ListadosDocumentos listadosdocumentosAux:listadosdocumentossTemp) {
			
			listadosdocumentosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosdocumentosAux.getEmpresa()));
			listadosdocumentosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(listadosdocumentosAux.getSucursal()));
			listadosdocumentosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(listadosdocumentosAux.getEjercicio()));
			listadosdocumentosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(listadosdocumentosAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadosDocumentos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoMovimiento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadosDocumentos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosDocumentos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosDocumentosConstantesFunciones.getClassesRelationshipsOfListadosDocumentos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosDocumentos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosDocumentos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosDocumentosConstantesFunciones.getClassesRelationshipsFromStringsOfListadosDocumentos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosDocumentos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadosDocumentos listadosdocumentos,List<ListadosDocumentos> listadosdocumentoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadosDocumentos listadosdocumentos,List<ListadosDocumentos> listadosdocumentoss) throws Exception {
		try	{			
			for(ListadosDocumentos listadosdocumentosLocal:listadosdocumentoss) {
				if(listadosdocumentosLocal.getId().equals(listadosdocumentos.getId())) {
					listadosdocumentosLocal.setIsSelected(listadosdocumentos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadosDocumentos(List<ListadosDocumentos> listadosdocumentossAux) throws Exception {
		//this.listadosdocumentossAux=listadosdocumentossAux;
		
		for(ListadosDocumentos listadosdocumentosAux:listadosdocumentossAux) {
			if(listadosdocumentosAux.getIsChanged()) {
				listadosdocumentosAux.setIsChanged(false);
			}		
			
			if(listadosdocumentosAux.getIsNew()) {
				listadosdocumentosAux.setIsNew(false);
			}	
			
			if(listadosdocumentosAux.getIsDeleted()) {
				listadosdocumentosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadosDocumentos(ListadosDocumentos listadosdocumentosAux) throws Exception {
		//this.listadosdocumentosAux=listadosdocumentosAux;
		
			if(listadosdocumentosAux.getIsChanged()) {
				listadosdocumentosAux.setIsChanged(false);
			}		
			
			if(listadosdocumentosAux.getIsNew()) {
				listadosdocumentosAux.setIsNew(false);
			}	
			
			if(listadosdocumentosAux.getIsDeleted()) {
				listadosdocumentosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadosDocumentos listadosdocumentosAsignar,ListadosDocumentos listadosdocumentos) throws Exception {
		listadosdocumentosAsignar.setId(listadosdocumentos.getId());	
		listadosdocumentosAsignar.setVersionRow(listadosdocumentos.getVersionRow());	
		listadosdocumentosAsignar.setfecha(listadosdocumentos.getfecha());	
		listadosdocumentosAsignar.settipo_movimiento(listadosdocumentos.gettipo_movimiento());	
		listadosdocumentosAsignar.setcodigo(listadosdocumentos.getcodigo());	
		listadosdocumentosAsignar.setbeneficiario(listadosdocumentos.getbeneficiario());	
		listadosdocumentosAsignar.setbeneficiario_cheque(listadosdocumentos.getbeneficiario_cheque());	
		listadosdocumentosAsignar.setdetalle(listadosdocumentos.getdetalle());	
		listadosdocumentosAsignar.setvalor_cheque(listadosdocumentos.getvalor_cheque());	
		listadosdocumentosAsignar.setnombre_empresa(listadosdocumentos.getnombre_empresa());	
		listadosdocumentosAsignar.setruc_empresa(listadosdocumentos.getruc_empresa());	
		listadosdocumentosAsignar.setdireccion_empresa(listadosdocumentos.getdireccion_empresa());	
		listadosdocumentosAsignar.setnombre_sucursal(listadosdocumentos.getnombre_sucursal());	
		listadosdocumentosAsignar.setvalor(listadosdocumentos.getvalor());	
		listadosdocumentosAsignar.setnumero_mayor(listadosdocumentos.getnumero_mayor());	
		listadosdocumentosAsignar.setfecha_emision(listadosdocumentos.getfecha_emision());	
		listadosdocumentosAsignar.setfecha_finalizacion(listadosdocumentos.getfecha_finalizacion());	
		listadosdocumentosAsignar.setnombre_usuario(listadosdocumentos.getnombre_usuario());	
		listadosdocumentosAsignar.setnumero_cheque(listadosdocumentos.getnumero_cheque());	
	}
	
	public static void inicializarListadosDocumentos(ListadosDocumentos listadosdocumentos) throws Exception {
		try {
				listadosdocumentos.setId(0L);	
					
				listadosdocumentos.setfecha(new Date());	
				listadosdocumentos.settipo_movimiento("");	
				listadosdocumentos.setcodigo("");	
				listadosdocumentos.setbeneficiario("");	
				listadosdocumentos.setbeneficiario_cheque("");	
				listadosdocumentos.setdetalle("");	
				listadosdocumentos.setvalor_cheque(0.0);	
				listadosdocumentos.setnombre_empresa("");	
				listadosdocumentos.setruc_empresa("");	
				listadosdocumentos.setdireccion_empresa("");	
				listadosdocumentos.setnombre_sucursal("");	
				listadosdocumentos.setvalor(0.0);	
				listadosdocumentos.setnumero_mayor("");	
				listadosdocumentos.setfecha_emision(new Date());	
				listadosdocumentos.setfecha_finalizacion(new Date());	
				listadosdocumentos.setnombre_usuario("");	
				listadosdocumentos.setnumero_cheque("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadosDocumentos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_BENEFICIARIOCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_VALORCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_RUCEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_DIRECCIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_FECHAFINALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_NOMBREUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosDocumentosConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadosDocumentos(String sTipo,Row row,Workbook workbook,ListadosDocumentos listadosdocumentos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getbeneficiario_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getvalor_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getruc_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getdireccion_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getfecha_finalizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getnombre_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosdocumentos.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadosDocumentos="";
	
	public String getsFinalQueryListadosDocumentos() {
		return this.sFinalQueryListadosDocumentos;
	}
	
	public void setsFinalQueryListadosDocumentos(String sFinalQueryListadosDocumentos) {
		this.sFinalQueryListadosDocumentos= sFinalQueryListadosDocumentos;
	}
	
	public Border resaltarSeleccionarListadosDocumentos=null;
	
	public Border setResaltarSeleccionarListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadosDocumentos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadosDocumentos() {
		return this.resaltarSeleccionarListadosDocumentos;
	}
	
	public void setResaltarSeleccionarListadosDocumentos(Border borderResaltarSeleccionarListadosDocumentos) {
		this.resaltarSeleccionarListadosDocumentos= borderResaltarSeleccionarListadosDocumentos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadosDocumentos=null;
	public Boolean mostraridListadosDocumentos=true;
	public Boolean activaridListadosDocumentos=true;

	public Border resaltarid_empresaListadosDocumentos=null;
	public Boolean mostrarid_empresaListadosDocumentos=true;
	public Boolean activarid_empresaListadosDocumentos=true;
	public Boolean cargarid_empresaListadosDocumentos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadosDocumentos=false;//ConEventDepend=true

	public Border resaltarid_sucursalListadosDocumentos=null;
	public Boolean mostrarid_sucursalListadosDocumentos=true;
	public Boolean activarid_sucursalListadosDocumentos=true;
	public Boolean cargarid_sucursalListadosDocumentos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalListadosDocumentos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioListadosDocumentos=null;
	public Boolean mostrarid_ejercicioListadosDocumentos=true;
	public Boolean activarid_ejercicioListadosDocumentos=true;
	public Boolean cargarid_ejercicioListadosDocumentos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioListadosDocumentos=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoListadosDocumentos=null;
	public Boolean mostrarid_tipo_movimientoListadosDocumentos=true;
	public Boolean activarid_tipo_movimientoListadosDocumentos=true;
	public Boolean cargarid_tipo_movimientoListadosDocumentos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoListadosDocumentos=false;//ConEventDepend=true

	public Border resaltarfecha_desdeListadosDocumentos=null;
	public Boolean mostrarfecha_desdeListadosDocumentos=true;
	public Boolean activarfecha_desdeListadosDocumentos=true;

	public Border resaltarfecha_hastaListadosDocumentos=null;
	public Boolean mostrarfecha_hastaListadosDocumentos=true;
	public Boolean activarfecha_hastaListadosDocumentos=true;

	public Border resaltarfechaListadosDocumentos=null;
	public Boolean mostrarfechaListadosDocumentos=true;
	public Boolean activarfechaListadosDocumentos=true;

	public Border resaltartipo_movimientoListadosDocumentos=null;
	public Boolean mostrartipo_movimientoListadosDocumentos=true;
	public Boolean activartipo_movimientoListadosDocumentos=true;

	public Border resaltarcodigoListadosDocumentos=null;
	public Boolean mostrarcodigoListadosDocumentos=true;
	public Boolean activarcodigoListadosDocumentos=true;

	public Border resaltarbeneficiarioListadosDocumentos=null;
	public Boolean mostrarbeneficiarioListadosDocumentos=true;
	public Boolean activarbeneficiarioListadosDocumentos=true;

	public Border resaltarbeneficiario_chequeListadosDocumentos=null;
	public Boolean mostrarbeneficiario_chequeListadosDocumentos=true;
	public Boolean activarbeneficiario_chequeListadosDocumentos=true;

	public Border resaltardetalleListadosDocumentos=null;
	public Boolean mostrardetalleListadosDocumentos=true;
	public Boolean activardetalleListadosDocumentos=true;

	public Border resaltarvalor_chequeListadosDocumentos=null;
	public Boolean mostrarvalor_chequeListadosDocumentos=true;
	public Boolean activarvalor_chequeListadosDocumentos=true;

	public Border resaltarnombre_empresaListadosDocumentos=null;
	public Boolean mostrarnombre_empresaListadosDocumentos=true;
	public Boolean activarnombre_empresaListadosDocumentos=true;

	public Border resaltarruc_empresaListadosDocumentos=null;
	public Boolean mostrarruc_empresaListadosDocumentos=true;
	public Boolean activarruc_empresaListadosDocumentos=true;

	public Border resaltardireccion_empresaListadosDocumentos=null;
	public Boolean mostrardireccion_empresaListadosDocumentos=true;
	public Boolean activardireccion_empresaListadosDocumentos=true;

	public Border resaltarnombre_sucursalListadosDocumentos=null;
	public Boolean mostrarnombre_sucursalListadosDocumentos=true;
	public Boolean activarnombre_sucursalListadosDocumentos=true;

	public Border resaltarvalorListadosDocumentos=null;
	public Boolean mostrarvalorListadosDocumentos=true;
	public Boolean activarvalorListadosDocumentos=true;

	public Border resaltarnumero_mayorListadosDocumentos=null;
	public Boolean mostrarnumero_mayorListadosDocumentos=true;
	public Boolean activarnumero_mayorListadosDocumentos=true;

	public Border resaltarfecha_emisionListadosDocumentos=null;
	public Boolean mostrarfecha_emisionListadosDocumentos=true;
	public Boolean activarfecha_emisionListadosDocumentos=true;

	public Border resaltarfecha_finalizacionListadosDocumentos=null;
	public Boolean mostrarfecha_finalizacionListadosDocumentos=true;
	public Boolean activarfecha_finalizacionListadosDocumentos=true;

	public Border resaltarnombre_usuarioListadosDocumentos=null;
	public Boolean mostrarnombre_usuarioListadosDocumentos=true;
	public Boolean activarnombre_usuarioListadosDocumentos=true;

	public Border resaltarnumero_chequeListadosDocumentos=null;
	public Boolean mostrarnumero_chequeListadosDocumentos=true;
	public Boolean activarnumero_chequeListadosDocumentos=true;

	
	

	public Border setResaltaridListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltaridListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadosDocumentos() {
		return this.resaltaridListadosDocumentos;
	}

	public void setResaltaridListadosDocumentos(Border borderResaltar) {
		this.resaltaridListadosDocumentos= borderResaltar;
	}

	public Boolean getMostraridListadosDocumentos() {
		return this.mostraridListadosDocumentos;
	}

	public void setMostraridListadosDocumentos(Boolean mostraridListadosDocumentos) {
		this.mostraridListadosDocumentos= mostraridListadosDocumentos;
	}

	public Boolean getActivaridListadosDocumentos() {
		return this.activaridListadosDocumentos;
	}

	public void setActivaridListadosDocumentos(Boolean activaridListadosDocumentos) {
		this.activaridListadosDocumentos= activaridListadosDocumentos;
	}

	public Border setResaltarid_empresaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadosDocumentos() {
		return this.resaltarid_empresaListadosDocumentos;
	}

	public void setResaltarid_empresaListadosDocumentos(Border borderResaltar) {
		this.resaltarid_empresaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadosDocumentos() {
		return this.mostrarid_empresaListadosDocumentos;
	}

	public void setMostrarid_empresaListadosDocumentos(Boolean mostrarid_empresaListadosDocumentos) {
		this.mostrarid_empresaListadosDocumentos= mostrarid_empresaListadosDocumentos;
	}

	public Boolean getActivarid_empresaListadosDocumentos() {
		return this.activarid_empresaListadosDocumentos;
	}

	public void setActivarid_empresaListadosDocumentos(Boolean activarid_empresaListadosDocumentos) {
		this.activarid_empresaListadosDocumentos= activarid_empresaListadosDocumentos;
	}

	public Boolean getCargarid_empresaListadosDocumentos() {
		return this.cargarid_empresaListadosDocumentos;
	}

	public void setCargarid_empresaListadosDocumentos(Boolean cargarid_empresaListadosDocumentos) {
		this.cargarid_empresaListadosDocumentos= cargarid_empresaListadosDocumentos;
	}

	public Border setResaltarid_sucursalListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalListadosDocumentos() {
		return this.resaltarid_sucursalListadosDocumentos;
	}

	public void setResaltarid_sucursalListadosDocumentos(Border borderResaltar) {
		this.resaltarid_sucursalListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalListadosDocumentos() {
		return this.mostrarid_sucursalListadosDocumentos;
	}

	public void setMostrarid_sucursalListadosDocumentos(Boolean mostrarid_sucursalListadosDocumentos) {
		this.mostrarid_sucursalListadosDocumentos= mostrarid_sucursalListadosDocumentos;
	}

	public Boolean getActivarid_sucursalListadosDocumentos() {
		return this.activarid_sucursalListadosDocumentos;
	}

	public void setActivarid_sucursalListadosDocumentos(Boolean activarid_sucursalListadosDocumentos) {
		this.activarid_sucursalListadosDocumentos= activarid_sucursalListadosDocumentos;
	}

	public Boolean getCargarid_sucursalListadosDocumentos() {
		return this.cargarid_sucursalListadosDocumentos;
	}

	public void setCargarid_sucursalListadosDocumentos(Boolean cargarid_sucursalListadosDocumentos) {
		this.cargarid_sucursalListadosDocumentos= cargarid_sucursalListadosDocumentos;
	}

	public Border setResaltarid_ejercicioListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioListadosDocumentos() {
		return this.resaltarid_ejercicioListadosDocumentos;
	}

	public void setResaltarid_ejercicioListadosDocumentos(Border borderResaltar) {
		this.resaltarid_ejercicioListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioListadosDocumentos() {
		return this.mostrarid_ejercicioListadosDocumentos;
	}

	public void setMostrarid_ejercicioListadosDocumentos(Boolean mostrarid_ejercicioListadosDocumentos) {
		this.mostrarid_ejercicioListadosDocumentos= mostrarid_ejercicioListadosDocumentos;
	}

	public Boolean getActivarid_ejercicioListadosDocumentos() {
		return this.activarid_ejercicioListadosDocumentos;
	}

	public void setActivarid_ejercicioListadosDocumentos(Boolean activarid_ejercicioListadosDocumentos) {
		this.activarid_ejercicioListadosDocumentos= activarid_ejercicioListadosDocumentos;
	}

	public Boolean getCargarid_ejercicioListadosDocumentos() {
		return this.cargarid_ejercicioListadosDocumentos;
	}

	public void setCargarid_ejercicioListadosDocumentos(Boolean cargarid_ejercicioListadosDocumentos) {
		this.cargarid_ejercicioListadosDocumentos= cargarid_ejercicioListadosDocumentos;
	}

	public Border setResaltarid_tipo_movimientoListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoListadosDocumentos() {
		return this.resaltarid_tipo_movimientoListadosDocumentos;
	}

	public void setResaltarid_tipo_movimientoListadosDocumentos(Border borderResaltar) {
		this.resaltarid_tipo_movimientoListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoListadosDocumentos() {
		return this.mostrarid_tipo_movimientoListadosDocumentos;
	}

	public void setMostrarid_tipo_movimientoListadosDocumentos(Boolean mostrarid_tipo_movimientoListadosDocumentos) {
		this.mostrarid_tipo_movimientoListadosDocumentos= mostrarid_tipo_movimientoListadosDocumentos;
	}

	public Boolean getActivarid_tipo_movimientoListadosDocumentos() {
		return this.activarid_tipo_movimientoListadosDocumentos;
	}

	public void setActivarid_tipo_movimientoListadosDocumentos(Boolean activarid_tipo_movimientoListadosDocumentos) {
		this.activarid_tipo_movimientoListadosDocumentos= activarid_tipo_movimientoListadosDocumentos;
	}

	public Boolean getCargarid_tipo_movimientoListadosDocumentos() {
		return this.cargarid_tipo_movimientoListadosDocumentos;
	}

	public void setCargarid_tipo_movimientoListadosDocumentos(Boolean cargarid_tipo_movimientoListadosDocumentos) {
		this.cargarid_tipo_movimientoListadosDocumentos= cargarid_tipo_movimientoListadosDocumentos;
	}

	public Border setResaltarfecha_desdeListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeListadosDocumentos() {
		return this.resaltarfecha_desdeListadosDocumentos;
	}

	public void setResaltarfecha_desdeListadosDocumentos(Border borderResaltar) {
		this.resaltarfecha_desdeListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeListadosDocumentos() {
		return this.mostrarfecha_desdeListadosDocumentos;
	}

	public void setMostrarfecha_desdeListadosDocumentos(Boolean mostrarfecha_desdeListadosDocumentos) {
		this.mostrarfecha_desdeListadosDocumentos= mostrarfecha_desdeListadosDocumentos;
	}

	public Boolean getActivarfecha_desdeListadosDocumentos() {
		return this.activarfecha_desdeListadosDocumentos;
	}

	public void setActivarfecha_desdeListadosDocumentos(Boolean activarfecha_desdeListadosDocumentos) {
		this.activarfecha_desdeListadosDocumentos= activarfecha_desdeListadosDocumentos;
	}

	public Border setResaltarfecha_hastaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaListadosDocumentos() {
		return this.resaltarfecha_hastaListadosDocumentos;
	}

	public void setResaltarfecha_hastaListadosDocumentos(Border borderResaltar) {
		this.resaltarfecha_hastaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaListadosDocumentos() {
		return this.mostrarfecha_hastaListadosDocumentos;
	}

	public void setMostrarfecha_hastaListadosDocumentos(Boolean mostrarfecha_hastaListadosDocumentos) {
		this.mostrarfecha_hastaListadosDocumentos= mostrarfecha_hastaListadosDocumentos;
	}

	public Boolean getActivarfecha_hastaListadosDocumentos() {
		return this.activarfecha_hastaListadosDocumentos;
	}

	public void setActivarfecha_hastaListadosDocumentos(Boolean activarfecha_hastaListadosDocumentos) {
		this.activarfecha_hastaListadosDocumentos= activarfecha_hastaListadosDocumentos;
	}

	public Border setResaltarfechaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarfechaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaListadosDocumentos() {
		return this.resaltarfechaListadosDocumentos;
	}

	public void setResaltarfechaListadosDocumentos(Border borderResaltar) {
		this.resaltarfechaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarfechaListadosDocumentos() {
		return this.mostrarfechaListadosDocumentos;
	}

	public void setMostrarfechaListadosDocumentos(Boolean mostrarfechaListadosDocumentos) {
		this.mostrarfechaListadosDocumentos= mostrarfechaListadosDocumentos;
	}

	public Boolean getActivarfechaListadosDocumentos() {
		return this.activarfechaListadosDocumentos;
	}

	public void setActivarfechaListadosDocumentos(Boolean activarfechaListadosDocumentos) {
		this.activarfechaListadosDocumentos= activarfechaListadosDocumentos;
	}

	public Border setResaltartipo_movimientoListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoListadosDocumentos() {
		return this.resaltartipo_movimientoListadosDocumentos;
	}

	public void setResaltartipo_movimientoListadosDocumentos(Border borderResaltar) {
		this.resaltartipo_movimientoListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoListadosDocumentos() {
		return this.mostrartipo_movimientoListadosDocumentos;
	}

	public void setMostrartipo_movimientoListadosDocumentos(Boolean mostrartipo_movimientoListadosDocumentos) {
		this.mostrartipo_movimientoListadosDocumentos= mostrartipo_movimientoListadosDocumentos;
	}

	public Boolean getActivartipo_movimientoListadosDocumentos() {
		return this.activartipo_movimientoListadosDocumentos;
	}

	public void setActivartipo_movimientoListadosDocumentos(Boolean activartipo_movimientoListadosDocumentos) {
		this.activartipo_movimientoListadosDocumentos= activartipo_movimientoListadosDocumentos;
	}

	public Border setResaltarcodigoListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarcodigoListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadosDocumentos() {
		return this.resaltarcodigoListadosDocumentos;
	}

	public void setResaltarcodigoListadosDocumentos(Border borderResaltar) {
		this.resaltarcodigoListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarcodigoListadosDocumentos() {
		return this.mostrarcodigoListadosDocumentos;
	}

	public void setMostrarcodigoListadosDocumentos(Boolean mostrarcodigoListadosDocumentos) {
		this.mostrarcodigoListadosDocumentos= mostrarcodigoListadosDocumentos;
	}

	public Boolean getActivarcodigoListadosDocumentos() {
		return this.activarcodigoListadosDocumentos;
	}

	public void setActivarcodigoListadosDocumentos(Boolean activarcodigoListadosDocumentos) {
		this.activarcodigoListadosDocumentos= activarcodigoListadosDocumentos;
	}

	public Border setResaltarbeneficiarioListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioListadosDocumentos() {
		return this.resaltarbeneficiarioListadosDocumentos;
	}

	public void setResaltarbeneficiarioListadosDocumentos(Border borderResaltar) {
		this.resaltarbeneficiarioListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioListadosDocumentos() {
		return this.mostrarbeneficiarioListadosDocumentos;
	}

	public void setMostrarbeneficiarioListadosDocumentos(Boolean mostrarbeneficiarioListadosDocumentos) {
		this.mostrarbeneficiarioListadosDocumentos= mostrarbeneficiarioListadosDocumentos;
	}

	public Boolean getActivarbeneficiarioListadosDocumentos() {
		return this.activarbeneficiarioListadosDocumentos;
	}

	public void setActivarbeneficiarioListadosDocumentos(Boolean activarbeneficiarioListadosDocumentos) {
		this.activarbeneficiarioListadosDocumentos= activarbeneficiarioListadosDocumentos;
	}

	public Border setResaltarbeneficiario_chequeListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarbeneficiario_chequeListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiario_chequeListadosDocumentos() {
		return this.resaltarbeneficiario_chequeListadosDocumentos;
	}

	public void setResaltarbeneficiario_chequeListadosDocumentos(Border borderResaltar) {
		this.resaltarbeneficiario_chequeListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarbeneficiario_chequeListadosDocumentos() {
		return this.mostrarbeneficiario_chequeListadosDocumentos;
	}

	public void setMostrarbeneficiario_chequeListadosDocumentos(Boolean mostrarbeneficiario_chequeListadosDocumentos) {
		this.mostrarbeneficiario_chequeListadosDocumentos= mostrarbeneficiario_chequeListadosDocumentos;
	}

	public Boolean getActivarbeneficiario_chequeListadosDocumentos() {
		return this.activarbeneficiario_chequeListadosDocumentos;
	}

	public void setActivarbeneficiario_chequeListadosDocumentos(Boolean activarbeneficiario_chequeListadosDocumentos) {
		this.activarbeneficiario_chequeListadosDocumentos= activarbeneficiario_chequeListadosDocumentos;
	}

	public Border setResaltardetalleListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltardetalleListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleListadosDocumentos() {
		return this.resaltardetalleListadosDocumentos;
	}

	public void setResaltardetalleListadosDocumentos(Border borderResaltar) {
		this.resaltardetalleListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrardetalleListadosDocumentos() {
		return this.mostrardetalleListadosDocumentos;
	}

	public void setMostrardetalleListadosDocumentos(Boolean mostrardetalleListadosDocumentos) {
		this.mostrardetalleListadosDocumentos= mostrardetalleListadosDocumentos;
	}

	public Boolean getActivardetalleListadosDocumentos() {
		return this.activardetalleListadosDocumentos;
	}

	public void setActivardetalleListadosDocumentos(Boolean activardetalleListadosDocumentos) {
		this.activardetalleListadosDocumentos= activardetalleListadosDocumentos;
	}

	public Border setResaltarvalor_chequeListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarvalor_chequeListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_chequeListadosDocumentos() {
		return this.resaltarvalor_chequeListadosDocumentos;
	}

	public void setResaltarvalor_chequeListadosDocumentos(Border borderResaltar) {
		this.resaltarvalor_chequeListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarvalor_chequeListadosDocumentos() {
		return this.mostrarvalor_chequeListadosDocumentos;
	}

	public void setMostrarvalor_chequeListadosDocumentos(Boolean mostrarvalor_chequeListadosDocumentos) {
		this.mostrarvalor_chequeListadosDocumentos= mostrarvalor_chequeListadosDocumentos;
	}

	public Boolean getActivarvalor_chequeListadosDocumentos() {
		return this.activarvalor_chequeListadosDocumentos;
	}

	public void setActivarvalor_chequeListadosDocumentos(Boolean activarvalor_chequeListadosDocumentos) {
		this.activarvalor_chequeListadosDocumentos= activarvalor_chequeListadosDocumentos;
	}

	public Border setResaltarnombre_empresaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaListadosDocumentos() {
		return this.resaltarnombre_empresaListadosDocumentos;
	}

	public void setResaltarnombre_empresaListadosDocumentos(Border borderResaltar) {
		this.resaltarnombre_empresaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaListadosDocumentos() {
		return this.mostrarnombre_empresaListadosDocumentos;
	}

	public void setMostrarnombre_empresaListadosDocumentos(Boolean mostrarnombre_empresaListadosDocumentos) {
		this.mostrarnombre_empresaListadosDocumentos= mostrarnombre_empresaListadosDocumentos;
	}

	public Boolean getActivarnombre_empresaListadosDocumentos() {
		return this.activarnombre_empresaListadosDocumentos;
	}

	public void setActivarnombre_empresaListadosDocumentos(Boolean activarnombre_empresaListadosDocumentos) {
		this.activarnombre_empresaListadosDocumentos= activarnombre_empresaListadosDocumentos;
	}

	public Border setResaltarruc_empresaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarruc_empresaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_empresaListadosDocumentos() {
		return this.resaltarruc_empresaListadosDocumentos;
	}

	public void setResaltarruc_empresaListadosDocumentos(Border borderResaltar) {
		this.resaltarruc_empresaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarruc_empresaListadosDocumentos() {
		return this.mostrarruc_empresaListadosDocumentos;
	}

	public void setMostrarruc_empresaListadosDocumentos(Boolean mostrarruc_empresaListadosDocumentos) {
		this.mostrarruc_empresaListadosDocumentos= mostrarruc_empresaListadosDocumentos;
	}

	public Boolean getActivarruc_empresaListadosDocumentos() {
		return this.activarruc_empresaListadosDocumentos;
	}

	public void setActivarruc_empresaListadosDocumentos(Boolean activarruc_empresaListadosDocumentos) {
		this.activarruc_empresaListadosDocumentos= activarruc_empresaListadosDocumentos;
	}

	public Border setResaltardireccion_empresaListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltardireccion_empresaListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_empresaListadosDocumentos() {
		return this.resaltardireccion_empresaListadosDocumentos;
	}

	public void setResaltardireccion_empresaListadosDocumentos(Border borderResaltar) {
		this.resaltardireccion_empresaListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrardireccion_empresaListadosDocumentos() {
		return this.mostrardireccion_empresaListadosDocumentos;
	}

	public void setMostrardireccion_empresaListadosDocumentos(Boolean mostrardireccion_empresaListadosDocumentos) {
		this.mostrardireccion_empresaListadosDocumentos= mostrardireccion_empresaListadosDocumentos;
	}

	public Boolean getActivardireccion_empresaListadosDocumentos() {
		return this.activardireccion_empresaListadosDocumentos;
	}

	public void setActivardireccion_empresaListadosDocumentos(Boolean activardireccion_empresaListadosDocumentos) {
		this.activardireccion_empresaListadosDocumentos= activardireccion_empresaListadosDocumentos;
	}

	public Border setResaltarnombre_sucursalListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalListadosDocumentos() {
		return this.resaltarnombre_sucursalListadosDocumentos;
	}

	public void setResaltarnombre_sucursalListadosDocumentos(Border borderResaltar) {
		this.resaltarnombre_sucursalListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalListadosDocumentos() {
		return this.mostrarnombre_sucursalListadosDocumentos;
	}

	public void setMostrarnombre_sucursalListadosDocumentos(Boolean mostrarnombre_sucursalListadosDocumentos) {
		this.mostrarnombre_sucursalListadosDocumentos= mostrarnombre_sucursalListadosDocumentos;
	}

	public Boolean getActivarnombre_sucursalListadosDocumentos() {
		return this.activarnombre_sucursalListadosDocumentos;
	}

	public void setActivarnombre_sucursalListadosDocumentos(Boolean activarnombre_sucursalListadosDocumentos) {
		this.activarnombre_sucursalListadosDocumentos= activarnombre_sucursalListadosDocumentos;
	}

	public Border setResaltarvalorListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarvalorListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorListadosDocumentos() {
		return this.resaltarvalorListadosDocumentos;
	}

	public void setResaltarvalorListadosDocumentos(Border borderResaltar) {
		this.resaltarvalorListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarvalorListadosDocumentos() {
		return this.mostrarvalorListadosDocumentos;
	}

	public void setMostrarvalorListadosDocumentos(Boolean mostrarvalorListadosDocumentos) {
		this.mostrarvalorListadosDocumentos= mostrarvalorListadosDocumentos;
	}

	public Boolean getActivarvalorListadosDocumentos() {
		return this.activarvalorListadosDocumentos;
	}

	public void setActivarvalorListadosDocumentos(Boolean activarvalorListadosDocumentos) {
		this.activarvalorListadosDocumentos= activarvalorListadosDocumentos;
	}

	public Border setResaltarnumero_mayorListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorListadosDocumentos() {
		return this.resaltarnumero_mayorListadosDocumentos;
	}

	public void setResaltarnumero_mayorListadosDocumentos(Border borderResaltar) {
		this.resaltarnumero_mayorListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorListadosDocumentos() {
		return this.mostrarnumero_mayorListadosDocumentos;
	}

	public void setMostrarnumero_mayorListadosDocumentos(Boolean mostrarnumero_mayorListadosDocumentos) {
		this.mostrarnumero_mayorListadosDocumentos= mostrarnumero_mayorListadosDocumentos;
	}

	public Boolean getActivarnumero_mayorListadosDocumentos() {
		return this.activarnumero_mayorListadosDocumentos;
	}

	public void setActivarnumero_mayorListadosDocumentos(Boolean activarnumero_mayorListadosDocumentos) {
		this.activarnumero_mayorListadosDocumentos= activarnumero_mayorListadosDocumentos;
	}

	public Border setResaltarfecha_emisionListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionListadosDocumentos() {
		return this.resaltarfecha_emisionListadosDocumentos;
	}

	public void setResaltarfecha_emisionListadosDocumentos(Border borderResaltar) {
		this.resaltarfecha_emisionListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionListadosDocumentos() {
		return this.mostrarfecha_emisionListadosDocumentos;
	}

	public void setMostrarfecha_emisionListadosDocumentos(Boolean mostrarfecha_emisionListadosDocumentos) {
		this.mostrarfecha_emisionListadosDocumentos= mostrarfecha_emisionListadosDocumentos;
	}

	public Boolean getActivarfecha_emisionListadosDocumentos() {
		return this.activarfecha_emisionListadosDocumentos;
	}

	public void setActivarfecha_emisionListadosDocumentos(Boolean activarfecha_emisionListadosDocumentos) {
		this.activarfecha_emisionListadosDocumentos= activarfecha_emisionListadosDocumentos;
	}

	public Border setResaltarfecha_finalizacionListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarfecha_finalizacionListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalizacionListadosDocumentos() {
		return this.resaltarfecha_finalizacionListadosDocumentos;
	}

	public void setResaltarfecha_finalizacionListadosDocumentos(Border borderResaltar) {
		this.resaltarfecha_finalizacionListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarfecha_finalizacionListadosDocumentos() {
		return this.mostrarfecha_finalizacionListadosDocumentos;
	}

	public void setMostrarfecha_finalizacionListadosDocumentos(Boolean mostrarfecha_finalizacionListadosDocumentos) {
		this.mostrarfecha_finalizacionListadosDocumentos= mostrarfecha_finalizacionListadosDocumentos;
	}

	public Boolean getActivarfecha_finalizacionListadosDocumentos() {
		return this.activarfecha_finalizacionListadosDocumentos;
	}

	public void setActivarfecha_finalizacionListadosDocumentos(Boolean activarfecha_finalizacionListadosDocumentos) {
		this.activarfecha_finalizacionListadosDocumentos= activarfecha_finalizacionListadosDocumentos;
	}

	public Border setResaltarnombre_usuarioListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarnombre_usuarioListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_usuarioListadosDocumentos() {
		return this.resaltarnombre_usuarioListadosDocumentos;
	}

	public void setResaltarnombre_usuarioListadosDocumentos(Border borderResaltar) {
		this.resaltarnombre_usuarioListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarnombre_usuarioListadosDocumentos() {
		return this.mostrarnombre_usuarioListadosDocumentos;
	}

	public void setMostrarnombre_usuarioListadosDocumentos(Boolean mostrarnombre_usuarioListadosDocumentos) {
		this.mostrarnombre_usuarioListadosDocumentos= mostrarnombre_usuarioListadosDocumentos;
	}

	public Boolean getActivarnombre_usuarioListadosDocumentos() {
		return this.activarnombre_usuarioListadosDocumentos;
	}

	public void setActivarnombre_usuarioListadosDocumentos(Boolean activarnombre_usuarioListadosDocumentos) {
		this.activarnombre_usuarioListadosDocumentos= activarnombre_usuarioListadosDocumentos;
	}

	public Border setResaltarnumero_chequeListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosdocumentosBeanSwingJInternalFrame.jTtoolBarListadosDocumentos.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeListadosDocumentos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeListadosDocumentos() {
		return this.resaltarnumero_chequeListadosDocumentos;
	}

	public void setResaltarnumero_chequeListadosDocumentos(Border borderResaltar) {
		this.resaltarnumero_chequeListadosDocumentos= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeListadosDocumentos() {
		return this.mostrarnumero_chequeListadosDocumentos;
	}

	public void setMostrarnumero_chequeListadosDocumentos(Boolean mostrarnumero_chequeListadosDocumentos) {
		this.mostrarnumero_chequeListadosDocumentos= mostrarnumero_chequeListadosDocumentos;
	}

	public Boolean getActivarnumero_chequeListadosDocumentos() {
		return this.activarnumero_chequeListadosDocumentos;
	}

	public void setActivarnumero_chequeListadosDocumentos(Boolean activarnumero_chequeListadosDocumentos) {
		this.activarnumero_chequeListadosDocumentos= activarnumero_chequeListadosDocumentos;
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
		
		
		this.setMostraridListadosDocumentos(esInicial);
		this.setMostrarid_empresaListadosDocumentos(esInicial);
		this.setMostrarid_sucursalListadosDocumentos(esInicial);
		this.setMostrarid_ejercicioListadosDocumentos(esInicial);
		this.setMostrarid_tipo_movimientoListadosDocumentos(esInicial);
		this.setMostrarfecha_desdeListadosDocumentos(esInicial);
		this.setMostrarfecha_hastaListadosDocumentos(esInicial);
		this.setMostrarfechaListadosDocumentos(esInicial);
		this.setMostrartipo_movimientoListadosDocumentos(esInicial);
		this.setMostrarcodigoListadosDocumentos(esInicial);
		this.setMostrarbeneficiarioListadosDocumentos(esInicial);
		this.setMostrarbeneficiario_chequeListadosDocumentos(esInicial);
		this.setMostrardetalleListadosDocumentos(esInicial);
		this.setMostrarvalor_chequeListadosDocumentos(esInicial);
		this.setMostrarnombre_empresaListadosDocumentos(esInicial);
		this.setMostrarruc_empresaListadosDocumentos(esInicial);
		this.setMostrardireccion_empresaListadosDocumentos(esInicial);
		this.setMostrarnombre_sucursalListadosDocumentos(esInicial);
		this.setMostrarvalorListadosDocumentos(esInicial);
		this.setMostrarnumero_mayorListadosDocumentos(esInicial);
		this.setMostrarfecha_emisionListadosDocumentos(esInicial);
		this.setMostrarfecha_finalizacionListadosDocumentos(esInicial);
		this.setMostrarnombre_usuarioListadosDocumentos(esInicial);
		this.setMostrarnumero_chequeListadosDocumentos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.ID)) {
				this.setMostraridListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHA)) {
				this.setMostrarfechaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE)) {
				this.setMostrarbeneficiario_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DETALLE)) {
				this.setMostrardetalleListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALORCHEQUE)) {
				this.setMostrarvalor_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.RUCEMPRESA)) {
				this.setMostrarruc_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA)) {
				this.setMostrardireccion_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALOR)) {
				this.setMostrarvalorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAFINALIZACION)) {
				this.setMostrarfecha_finalizacionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREUSUARIO)) {
				this.setMostrarnombre_usuarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeListadosDocumentos(esAsigna);
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
		
		
		this.setActivaridListadosDocumentos(esInicial);
		this.setActivarid_empresaListadosDocumentos(esInicial);
		this.setActivarid_sucursalListadosDocumentos(esInicial);
		this.setActivarid_ejercicioListadosDocumentos(esInicial);
		this.setActivarid_tipo_movimientoListadosDocumentos(esInicial);
		this.setActivarfecha_desdeListadosDocumentos(esInicial);
		this.setActivarfecha_hastaListadosDocumentos(esInicial);
		this.setActivarfechaListadosDocumentos(esInicial);
		this.setActivartipo_movimientoListadosDocumentos(esInicial);
		this.setActivarcodigoListadosDocumentos(esInicial);
		this.setActivarbeneficiarioListadosDocumentos(esInicial);
		this.setActivarbeneficiario_chequeListadosDocumentos(esInicial);
		this.setActivardetalleListadosDocumentos(esInicial);
		this.setActivarvalor_chequeListadosDocumentos(esInicial);
		this.setActivarnombre_empresaListadosDocumentos(esInicial);
		this.setActivarruc_empresaListadosDocumentos(esInicial);
		this.setActivardireccion_empresaListadosDocumentos(esInicial);
		this.setActivarnombre_sucursalListadosDocumentos(esInicial);
		this.setActivarvalorListadosDocumentos(esInicial);
		this.setActivarnumero_mayorListadosDocumentos(esInicial);
		this.setActivarfecha_emisionListadosDocumentos(esInicial);
		this.setActivarfecha_finalizacionListadosDocumentos(esInicial);
		this.setActivarnombre_usuarioListadosDocumentos(esInicial);
		this.setActivarnumero_chequeListadosDocumentos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.ID)) {
				this.setActivaridListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHA)) {
				this.setActivarfechaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE)) {
				this.setActivarbeneficiario_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DETALLE)) {
				this.setActivardetalleListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALORCHEQUE)) {
				this.setActivarvalor_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.RUCEMPRESA)) {
				this.setActivarruc_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA)) {
				this.setActivardireccion_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALOR)) {
				this.setActivarvalorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAFINALIZACION)) {
				this.setActivarfecha_finalizacionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREUSUARIO)) {
				this.setActivarnombre_usuarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeListadosDocumentos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadosDocumentos(esInicial);
		this.setResaltarid_empresaListadosDocumentos(esInicial);
		this.setResaltarid_sucursalListadosDocumentos(esInicial);
		this.setResaltarid_ejercicioListadosDocumentos(esInicial);
		this.setResaltarid_tipo_movimientoListadosDocumentos(esInicial);
		this.setResaltarfecha_desdeListadosDocumentos(esInicial);
		this.setResaltarfecha_hastaListadosDocumentos(esInicial);
		this.setResaltarfechaListadosDocumentos(esInicial);
		this.setResaltartipo_movimientoListadosDocumentos(esInicial);
		this.setResaltarcodigoListadosDocumentos(esInicial);
		this.setResaltarbeneficiarioListadosDocumentos(esInicial);
		this.setResaltarbeneficiario_chequeListadosDocumentos(esInicial);
		this.setResaltardetalleListadosDocumentos(esInicial);
		this.setResaltarvalor_chequeListadosDocumentos(esInicial);
		this.setResaltarnombre_empresaListadosDocumentos(esInicial);
		this.setResaltarruc_empresaListadosDocumentos(esInicial);
		this.setResaltardireccion_empresaListadosDocumentos(esInicial);
		this.setResaltarnombre_sucursalListadosDocumentos(esInicial);
		this.setResaltarvalorListadosDocumentos(esInicial);
		this.setResaltarnumero_mayorListadosDocumentos(esInicial);
		this.setResaltarfecha_emisionListadosDocumentos(esInicial);
		this.setResaltarfecha_finalizacionListadosDocumentos(esInicial);
		this.setResaltarnombre_usuarioListadosDocumentos(esInicial);
		this.setResaltarnumero_chequeListadosDocumentos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.ID)) {
				this.setResaltaridListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHA)) {
				this.setResaltarfechaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.BENEFICIARIOCHEQUE)) {
				this.setResaltarbeneficiario_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DETALLE)) {
				this.setResaltardetalleListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALORCHEQUE)) {
				this.setResaltarvalor_chequeListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.RUCEMPRESA)) {
				this.setResaltarruc_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.DIRECCIONEMPRESA)) {
				this.setResaltardireccion_empresaListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.VALOR)) {
				this.setResaltarvalorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.FECHAFINALIZACION)) {
				this.setResaltarfecha_finalizacionListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NOMBREUSUARIO)) {
				this.setResaltarnombre_usuarioListadosDocumentos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosDocumentosConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeListadosDocumentos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadosDocumentosListadosDocumentos=true;

	public Boolean getMostrarBusquedaListadosDocumentosListadosDocumentos() {
		return this.mostrarBusquedaListadosDocumentosListadosDocumentos;
	}

	public void setMostrarBusquedaListadosDocumentosListadosDocumentos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadosDocumentosListadosDocumentos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadosDocumentosListadosDocumentos=true;

	public Boolean getActivarBusquedaListadosDocumentosListadosDocumentos() {
		return this.activarBusquedaListadosDocumentosListadosDocumentos;
	}

	public void setActivarBusquedaListadosDocumentosListadosDocumentos(Boolean habilitarResaltar) {
		this.activarBusquedaListadosDocumentosListadosDocumentos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadosDocumentosListadosDocumentos=null;

	public Border getResaltarBusquedaListadosDocumentosListadosDocumentos() {
		return this.resaltarBusquedaListadosDocumentosListadosDocumentos;
	}

	public void setResaltarBusquedaListadosDocumentosListadosDocumentos(Border borderResaltar) {
		this.resaltarBusquedaListadosDocumentosListadosDocumentos= borderResaltar;
	}

	public void setResaltarBusquedaListadosDocumentosListadosDocumentos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosDocumentosBeanSwingJInternalFrame listadosdocumentosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadosDocumentosListadosDocumentos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}