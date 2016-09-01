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


import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ActivosFijosPorRamosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ActivosFijosPorRamos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ActivosFijosPorRamos"+ActivosFijosPorRamosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ActivosFijosPorRamosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ActivosFijosPorRamosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ActivosFijosPorRamosConstantesFunciones.SCHEMA+"_"+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorRamosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ActivosFijosPorRamosConstantesFunciones.SCHEMA+"_"+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ActivosFijosPorRamosConstantesFunciones.SCHEMA+"_"+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorRamosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ActivosFijosPorRamosConstantesFunciones.SCHEMA+"_"+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorRamosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ActivosFijosPorRamosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ActivosFijosPorRamosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ActivosFijosPorRamosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ActivosFijosPorRamosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ActivosFijosPorRamosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ActivosFijosPorRamosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Activos Fijos Por Ramoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Activos Fijos Por Ramos";
	public static final String SCLASSWEBTITULO_LOWER="Activos Fijos Por Ramos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ActivosFijosPorRamos";
	public static final String OBJECTNAME="activosfijosporramos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="activos_fijos_por_ramos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select activosfijosporramos from "+ActivosFijosPorRamosConstantesFunciones.SPERSISTENCENAME+" activosfijosporramos";
	public static String QUERYSELECTNATIVE="select "+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".id,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".version_row,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".id_empresa,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".id_tipo_ramo_activo_fijo,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".clave,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".nombre,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".fecha_compra,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".vida_util,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".costo_de_compra,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".marca,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".modelo,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".numero_matricula,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".numero_motor,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".numero_chasis,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".numero_placa,"+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME+".valor_comercial from "+ActivosFijosPorRamosConstantesFunciones.SCHEMA+"."+ActivosFijosPorRamosConstantesFunciones.TABLENAME;//+" as "+ActivosFijosPorRamosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPORAMOACTIVOFIJO= "id_tipo_ramo_activo_fijo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
    public static final String MARCA= "marca";
    public static final String MODELO= "modelo";
    public static final String NUMEROMATRICULA= "numero_matricula";
    public static final String NUMEROMOTOR= "numero_motor";
    public static final String NUMEROCHASIS= "numero_chasis";
    public static final String NUMEROPLACA= "numero_placa";
    public static final String VALORCOMERCIAL= "valor_comercial";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPORAMOACTIVOFIJO= "Tipo Ramo Activo Fijo";
		public static final String LABEL_IDTIPORAMOACTIVOFIJO_LOWER= "Tipo Ramo Activo Fijo";
    	public static final String LABEL_NOMBRESUBGRUPO= "Nombre Sub Grupo";
		public static final String LABEL_NOMBRESUBGRUPO_LOWER= "Nombre Sub Grupo";
    	public static final String LABEL_NOMBREDETALLEGRUPO= "Nombre Detalle Grupo";
		public static final String LABEL_NOMBREDETALLEGRUPO_LOWER= "Nombre Detalle Grupo";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_VIDAUTIL= "Va Util";
		public static final String LABEL_VIDAUTIL_LOWER= "Vida Util";
    	public static final String LABEL_COSTODECOMPRA= "Costo Compra";
		public static final String LABEL_COSTODECOMPRA_LOWER= "Costo De Compra";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_MODELO= "Modelo";
		public static final String LABEL_MODELO_LOWER= "Modelo";
    	public static final String LABEL_NUMEROMATRICULA= "Numero Matricula";
		public static final String LABEL_NUMEROMATRICULA_LOWER= "Numero Matricula";
    	public static final String LABEL_NUMEROMOTOR= "Numero Motor";
		public static final String LABEL_NUMEROMOTOR_LOWER= "Numero Motor";
    	public static final String LABEL_NUMEROCHASIS= "Numero Chasis";
		public static final String LABEL_NUMEROCHASIS_LOWER= "Numero Chasis";
    	public static final String LABEL_NUMEROPLACA= "Numero Placa";
		public static final String LABEL_NUMEROPLACA_LOWER= "Numero Placa";
    	public static final String LABEL_VALORCOMERCIAL= "Valor Comercial";
		public static final String LABEL_VALORCOMERCIAL_LOWER= "Valor Comercial";
	
		
		
		
		
	public static final String SREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMODELO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMODELO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MATRICULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MATRICULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MOTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MOTOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHASIS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHASIS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PLACA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PLACA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getActivosFijosPorRamosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.CLAVE)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRE)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.MARCA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.MODELO)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_MODELO;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMATRICULA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMOTOR;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROCHASIS;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROPLACA;}
		if(sNombreColumna.equals(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL)) {sLabelColumna=ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getActivosFijosPorRamosDescripcion(ActivosFijosPorRamos activosfijosporramos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(activosfijosporramos !=null/* && activosfijosporramos.getId()!=0*/) {
			sDescripcion=activosfijosporramos.getnombre();//activosfijosporramosactivosfijosporramos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getActivosFijosPorRamosDescripcionDetallado(ActivosFijosPorRamos activosfijosporramos) {
		String sDescripcion="";
			
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.ID+"=";
		sDescripcion+=activosfijosporramos.getId().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=activosfijosporramos.getVersionRow().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=activosfijosporramos.getid_empresa().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.IDTIPORAMOACTIVOFIJO+"=";
		sDescripcion+=activosfijosporramos.getid_tipo_ramo_activo_fijo().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=activosfijosporramos.getnombre_sub_grupo()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=activosfijosporramos.getnombre_detalle_grupo()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.CLAVE+"=";
		sDescripcion+=activosfijosporramos.getclave()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=activosfijosporramos.getnombre()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=activosfijosporramos.getfecha_compra().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=activosfijosporramos.getvida_util().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=activosfijosporramos.getcosto_de_compra().toString()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.MARCA+"=";
		sDescripcion+=activosfijosporramos.getmarca()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.MODELO+"=";
		sDescripcion+=activosfijosporramos.getmodelo()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA+"=";
		sDescripcion+=activosfijosporramos.getnumero_matricula()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR+"=";
		sDescripcion+=activosfijosporramos.getnumero_motor()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS+"=";
		sDescripcion+=activosfijosporramos.getnumero_chasis()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA+"=";
		sDescripcion+=activosfijosporramos.getnumero_placa()+",";
		sDescripcion+=ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL+"=";
		sDescripcion+=activosfijosporramos.getvalor_comercial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setActivosFijosPorRamosDescripcion(ActivosFijosPorRamos activosfijosporramos,String sValor) throws Exception {			
		if(activosfijosporramos !=null) {
			activosfijosporramos.setnombre(sValor);;//activosfijosporramosactivosfijosporramos.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoRamoActivoFijoDescripcion(TipoRamoActivoFijo tiporamoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporamoactivofijo!=null/*&&tiporamoactivofijo.getId()>0*/) {
			sDescripcion=TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(tiporamoactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaActivosFijosPorRamos")) {
			sNombreIndice="Tipo=  Por Tipo Ramo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRamoActivoFijo")) {
			sNombreIndice="Tipo=  Por Tipo Ramo Activo Fijo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaActivosFijosPorRamos(Long id_tipo_ramo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_ramo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Ramo Activo Fijo="+id_tipo_ramo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRamoActivoFijo(Long id_tipo_ramo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_ramo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Ramo Activo Fijo="+id_tipo_ramo_activo_fijo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		activosfijosporramos.setnombre_sub_grupo(activosfijosporramos.getnombre_sub_grupo().trim());
		activosfijosporramos.setnombre_detalle_grupo(activosfijosporramos.getnombre_detalle_grupo().trim());
		activosfijosporramos.setclave(activosfijosporramos.getclave().trim());
		activosfijosporramos.setnombre(activosfijosporramos.getnombre().trim());
		activosfijosporramos.setmarca(activosfijosporramos.getmarca().trim());
		activosfijosporramos.setmodelo(activosfijosporramos.getmodelo().trim());
		activosfijosporramos.setnumero_matricula(activosfijosporramos.getnumero_matricula().trim());
		activosfijosporramos.setnumero_motor(activosfijosporramos.getnumero_motor().trim());
		activosfijosporramos.setnumero_chasis(activosfijosporramos.getnumero_chasis().trim());
		activosfijosporramos.setnumero_placa(activosfijosporramos.getnumero_placa().trim());
	}
	
	public static void quitarEspaciosActivosFijosPorRamoss(List<ActivosFijosPorRamos> activosfijosporramoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {
			activosfijosporramos.setnombre_sub_grupo(activosfijosporramos.getnombre_sub_grupo().trim());
			activosfijosporramos.setnombre_detalle_grupo(activosfijosporramos.getnombre_detalle_grupo().trim());
			activosfijosporramos.setclave(activosfijosporramos.getclave().trim());
			activosfijosporramos.setnombre(activosfijosporramos.getnombre().trim());
			activosfijosporramos.setmarca(activosfijosporramos.getmarca().trim());
			activosfijosporramos.setmodelo(activosfijosporramos.getmodelo().trim());
			activosfijosporramos.setnumero_matricula(activosfijosporramos.getnumero_matricula().trim());
			activosfijosporramos.setnumero_motor(activosfijosporramos.getnumero_motor().trim());
			activosfijosporramos.setnumero_chasis(activosfijosporramos.getnumero_chasis().trim());
			activosfijosporramos.setnumero_placa(activosfijosporramos.getnumero_placa().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && activosfijosporramos.getConCambioAuxiliar()) {
			activosfijosporramos.setIsDeleted(activosfijosporramos.getIsDeletedAuxiliar());	
			activosfijosporramos.setIsNew(activosfijosporramos.getIsNewAuxiliar());	
			activosfijosporramos.setIsChanged(activosfijosporramos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			activosfijosporramos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			activosfijosporramos.setIsDeletedAuxiliar(false);	
			activosfijosporramos.setIsNewAuxiliar(false);	
			activosfijosporramos.setIsChangedAuxiliar(false);
			
			activosfijosporramos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresActivosFijosPorRamoss(List<ActivosFijosPorRamos> activosfijosporramoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ActivosFijosPorRamos activosfijosporramos : activosfijosporramoss) {
			if(conAsignarBase && activosfijosporramos.getConCambioAuxiliar()) {
				activosfijosporramos.setIsDeleted(activosfijosporramos.getIsDeletedAuxiliar());	
				activosfijosporramos.setIsNew(activosfijosporramos.getIsNewAuxiliar());	
				activosfijosporramos.setIsChanged(activosfijosporramos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				activosfijosporramos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				activosfijosporramos.setIsDeletedAuxiliar(false);	
				activosfijosporramos.setIsNewAuxiliar(false);	
				activosfijosporramos.setIsChangedAuxiliar(false);
				
				activosfijosporramos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramos,Boolean conEnteros) throws Exception  {
		activosfijosporramos.setvida_util(0.0);
		activosfijosporramos.setcosto_de_compra(0.0);
		activosfijosporramos.setvalor_comercial(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresActivosFijosPorRamoss(List<ActivosFijosPorRamos> activosfijosporramoss,Boolean conEnteros) throws Exception  {
		
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {
			activosfijosporramos.setvida_util(0.0);
			activosfijosporramos.setcosto_de_compra(0.0);
			activosfijosporramos.setvalor_comercial(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaActivosFijosPorRamos(List<ActivosFijosPorRamos> activosfijosporramoss,ActivosFijosPorRamos activosfijosporramosAux) throws Exception  {
		ActivosFijosPorRamosConstantesFunciones.InicializarValoresActivosFijosPorRamos(activosfijosporramosAux,true);
		
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {
			if(activosfijosporramos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			activosfijosporramosAux.setvida_util(activosfijosporramosAux.getvida_util()+activosfijosporramos.getvida_util());			
			activosfijosporramosAux.setcosto_de_compra(activosfijosporramosAux.getcosto_de_compra()+activosfijosporramos.getcosto_de_compra());			
			activosfijosporramosAux.setvalor_comercial(activosfijosporramosAux.getvalor_comercial()+activosfijosporramos.getvalor_comercial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorRamos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ActivosFijosPorRamosConstantesFunciones.getArrayColumnasGlobalesActivosFijosPorRamos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesActivosFijosPorRamos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoActivosFijosPorRamos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ActivosFijosPorRamos> activosfijosporramoss,ActivosFijosPorRamos activosfijosporramos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ActivosFijosPorRamos activosfijosporramosAux: activosfijosporramoss) {
			if(activosfijosporramosAux!=null && activosfijosporramos!=null) {
				if((activosfijosporramosAux.getId()==null && activosfijosporramos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(activosfijosporramosAux.getId()!=null && activosfijosporramos.getId()!=null){
					if(activosfijosporramosAux.getId().equals(activosfijosporramos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaActivosFijosPorRamos(List<ActivosFijosPorRamos> activosfijosporramoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double valor_comercialTotal=0.0;
	
		for(ActivosFijosPorRamos activosfijosporramos: activosfijosporramoss) {			
			if(activosfijosporramos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=activosfijosporramos.getvida_util();
			costo_de_compraTotal+=activosfijosporramos.getcosto_de_compra();
			valor_comercialTotal+=activosfijosporramos.getvalor_comercial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL);
		datoGeneral.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL);
		datoGeneral.setdValorDouble(valor_comercialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaActivosFijosPorRamos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_ID, ActivosFijosPorRamosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_VERSIONROW, ActivosFijosPorRamosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRESUBGRUPO, ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_CLAVE, ActivosFijosPorRamosConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRE, ActivosFijosPorRamosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_FECHACOMPRA, ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL, ActivosFijosPorRamosConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA, ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_MARCA, ActivosFijosPorRamosConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_MODELO, ActivosFijosPorRamosConstantesFunciones.MODELO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMATRICULA, ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMOTOR, ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROCHASIS, ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROPLACA, ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL, ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasActivosFijosPorRamos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.MODELO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorRamos() throws Exception  {
		return ActivosFijosPorRamosConstantesFunciones.getTiposSeleccionarActivosFijosPorRamos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorRamos(Boolean conFk) throws Exception  {
		return ActivosFijosPorRamosConstantesFunciones.getTiposSeleccionarActivosFijosPorRamos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarActivosFijosPorRamos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_MODELO);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_MODELO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMATRICULA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMATRICULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMOTOR);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMOTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROCHASIS);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROCHASIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROPLACA);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROPLACA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL);
			reporte.setsDescripcion(ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesActivosFijosPorRamos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramosAux) throws Exception {
		
			activosfijosporramosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(activosfijosporramosAux.getEmpresa()));
			activosfijosporramosAux.settiporamoactivofijo_descripcion(TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(activosfijosporramosAux.getTipoRamoActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesActivosFijosPorRamos(List<ActivosFijosPorRamos> activosfijosporramossTemp) throws Exception {
		for(ActivosFijosPorRamos activosfijosporramosAux:activosfijosporramossTemp) {
			
			activosfijosporramosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(activosfijosporramosAux.getEmpresa()));
			activosfijosporramosAux.settiporamoactivofijo_descripcion(TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(activosfijosporramosAux.getTipoRamoActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfActivosFijosPorRamos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoRamoActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRamoActivoFijo.class)) {
						classes.add(new Classe(TipoRamoActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfActivosFijosPorRamos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRamoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRamoActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRamoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRamoActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijosPorRamos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosPorRamosConstantesFunciones.getClassesRelationshipsOfActivosFijosPorRamos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfActivosFijosPorRamos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijosPorRamos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ActivosFijosPorRamosConstantesFunciones.getClassesRelationshipsFromStringsOfActivosFijosPorRamos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfActivosFijosPorRamos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ActivosFijosPorRamos activosfijosporramos,List<ActivosFijosPorRamos> activosfijosporramoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ActivosFijosPorRamos activosfijosporramos,List<ActivosFijosPorRamos> activosfijosporramoss) throws Exception {
		try	{			
			for(ActivosFijosPorRamos activosfijosporramosLocal:activosfijosporramoss) {
				if(activosfijosporramosLocal.getId().equals(activosfijosporramos.getId())) {
					activosfijosporramosLocal.setIsSelected(activosfijosporramos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesActivosFijosPorRamos(List<ActivosFijosPorRamos> activosfijosporramossAux) throws Exception {
		//this.activosfijosporramossAux=activosfijosporramossAux;
		
		for(ActivosFijosPorRamos activosfijosporramosAux:activosfijosporramossAux) {
			if(activosfijosporramosAux.getIsChanged()) {
				activosfijosporramosAux.setIsChanged(false);
			}		
			
			if(activosfijosporramosAux.getIsNew()) {
				activosfijosporramosAux.setIsNew(false);
			}	
			
			if(activosfijosporramosAux.getIsDeleted()) {
				activosfijosporramosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramosAux) throws Exception {
		//this.activosfijosporramosAux=activosfijosporramosAux;
		
			if(activosfijosporramosAux.getIsChanged()) {
				activosfijosporramosAux.setIsChanged(false);
			}		
			
			if(activosfijosporramosAux.getIsNew()) {
				activosfijosporramosAux.setIsNew(false);
			}	
			
			if(activosfijosporramosAux.getIsDeleted()) {
				activosfijosporramosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ActivosFijosPorRamos activosfijosporramosAsignar,ActivosFijosPorRamos activosfijosporramos) throws Exception {
		activosfijosporramosAsignar.setId(activosfijosporramos.getId());	
		activosfijosporramosAsignar.setVersionRow(activosfijosporramos.getVersionRow());	
		activosfijosporramosAsignar.setnombre_sub_grupo(activosfijosporramos.getnombre_sub_grupo());	
		activosfijosporramosAsignar.setnombre_detalle_grupo(activosfijosporramos.getnombre_detalle_grupo());	
		activosfijosporramosAsignar.setclave(activosfijosporramos.getclave());	
		activosfijosporramosAsignar.setnombre(activosfijosporramos.getnombre());	
		activosfijosporramosAsignar.setfecha_compra(activosfijosporramos.getfecha_compra());	
		activosfijosporramosAsignar.setvida_util(activosfijosporramos.getvida_util());	
		activosfijosporramosAsignar.setcosto_de_compra(activosfijosporramos.getcosto_de_compra());	
		activosfijosporramosAsignar.setmarca(activosfijosporramos.getmarca());	
		activosfijosporramosAsignar.setmodelo(activosfijosporramos.getmodelo());	
		activosfijosporramosAsignar.setnumero_matricula(activosfijosporramos.getnumero_matricula());	
		activosfijosporramosAsignar.setnumero_motor(activosfijosporramos.getnumero_motor());	
		activosfijosporramosAsignar.setnumero_chasis(activosfijosporramos.getnumero_chasis());	
		activosfijosporramosAsignar.setnumero_placa(activosfijosporramos.getnumero_placa());	
		activosfijosporramosAsignar.setvalor_comercial(activosfijosporramos.getvalor_comercial());	
	}
	
	public static void inicializarActivosFijosPorRamos(ActivosFijosPorRamos activosfijosporramos) throws Exception {
		try {
				activosfijosporramos.setId(0L);	
					
				activosfijosporramos.setnombre_sub_grupo("");	
				activosfijosporramos.setnombre_detalle_grupo("");	
				activosfijosporramos.setclave("");	
				activosfijosporramos.setnombre("");	
				activosfijosporramos.setfecha_compra(new Date());	
				activosfijosporramos.setvida_util(0.0);	
				activosfijosporramos.setcosto_de_compra(0.0);	
				activosfijosporramos.setmarca("");	
				activosfijosporramos.setmodelo("");	
				activosfijosporramos.setnumero_matricula("");	
				activosfijosporramos.setnumero_motor("");	
				activosfijosporramos.setnumero_chasis("");	
				activosfijosporramos.setnumero_placa("");	
				activosfijosporramos.setvalor_comercial(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderActivosFijosPorRamos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_MODELO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMATRICULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROMOTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROCHASIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_NUMEROPLACA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ActivosFijosPorRamosConstantesFunciones.LABEL_VALORCOMERCIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataActivosFijosPorRamos(String sTipo,Row row,Workbook workbook,ActivosFijosPorRamos activosfijosporramos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.gettiporamoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getmodelo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnumero_matricula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnumero_motor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnumero_chasis());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getnumero_placa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(activosfijosporramos.getvalor_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryActivosFijosPorRamos="";
	
	public String getsFinalQueryActivosFijosPorRamos() {
		return this.sFinalQueryActivosFijosPorRamos;
	}
	
	public void setsFinalQueryActivosFijosPorRamos(String sFinalQueryActivosFijosPorRamos) {
		this.sFinalQueryActivosFijosPorRamos= sFinalQueryActivosFijosPorRamos;
	}
	
	public Border resaltarSeleccionarActivosFijosPorRamos=null;
	
	public Border setResaltarSeleccionarActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarActivosFijosPorRamos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarActivosFijosPorRamos() {
		return this.resaltarSeleccionarActivosFijosPorRamos;
	}
	
	public void setResaltarSeleccionarActivosFijosPorRamos(Border borderResaltarSeleccionarActivosFijosPorRamos) {
		this.resaltarSeleccionarActivosFijosPorRamos= borderResaltarSeleccionarActivosFijosPorRamos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridActivosFijosPorRamos=null;
	public Boolean mostraridActivosFijosPorRamos=true;
	public Boolean activaridActivosFijosPorRamos=true;

	public Border resaltarid_empresaActivosFijosPorRamos=null;
	public Boolean mostrarid_empresaActivosFijosPorRamos=true;
	public Boolean activarid_empresaActivosFijosPorRamos=true;
	public Boolean cargarid_empresaActivosFijosPorRamos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaActivosFijosPorRamos=false;//ConEventDepend=true

	public Border resaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos=null;
	public Boolean mostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos=true;
	public Boolean activarid_tipo_ramo_activo_fijoActivosFijosPorRamos=true;
	public Boolean cargarid_tipo_ramo_activo_fijoActivosFijosPorRamos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ramo_activo_fijoActivosFijosPorRamos=false;//ConEventDepend=true

	public Border resaltarnombre_sub_grupoActivosFijosPorRamos=null;
	public Boolean mostrarnombre_sub_grupoActivosFijosPorRamos=true;
	public Boolean activarnombre_sub_grupoActivosFijosPorRamos=true;

	public Border resaltarnombre_detalle_grupoActivosFijosPorRamos=null;
	public Boolean mostrarnombre_detalle_grupoActivosFijosPorRamos=true;
	public Boolean activarnombre_detalle_grupoActivosFijosPorRamos=true;

	public Border resaltarclaveActivosFijosPorRamos=null;
	public Boolean mostrarclaveActivosFijosPorRamos=true;
	public Boolean activarclaveActivosFijosPorRamos=true;

	public Border resaltarnombreActivosFijosPorRamos=null;
	public Boolean mostrarnombreActivosFijosPorRamos=true;
	public Boolean activarnombreActivosFijosPorRamos=true;

	public Border resaltarfecha_compraActivosFijosPorRamos=null;
	public Boolean mostrarfecha_compraActivosFijosPorRamos=true;
	public Boolean activarfecha_compraActivosFijosPorRamos=true;

	public Border resaltarvida_utilActivosFijosPorRamos=null;
	public Boolean mostrarvida_utilActivosFijosPorRamos=true;
	public Boolean activarvida_utilActivosFijosPorRamos=true;

	public Border resaltarcosto_de_compraActivosFijosPorRamos=null;
	public Boolean mostrarcosto_de_compraActivosFijosPorRamos=true;
	public Boolean activarcosto_de_compraActivosFijosPorRamos=true;

	public Border resaltarmarcaActivosFijosPorRamos=null;
	public Boolean mostrarmarcaActivosFijosPorRamos=true;
	public Boolean activarmarcaActivosFijosPorRamos=true;

	public Border resaltarmodeloActivosFijosPorRamos=null;
	public Boolean mostrarmodeloActivosFijosPorRamos=true;
	public Boolean activarmodeloActivosFijosPorRamos=true;

	public Border resaltarnumero_matriculaActivosFijosPorRamos=null;
	public Boolean mostrarnumero_matriculaActivosFijosPorRamos=true;
	public Boolean activarnumero_matriculaActivosFijosPorRamos=true;

	public Border resaltarnumero_motorActivosFijosPorRamos=null;
	public Boolean mostrarnumero_motorActivosFijosPorRamos=true;
	public Boolean activarnumero_motorActivosFijosPorRamos=true;

	public Border resaltarnumero_chasisActivosFijosPorRamos=null;
	public Boolean mostrarnumero_chasisActivosFijosPorRamos=true;
	public Boolean activarnumero_chasisActivosFijosPorRamos=true;

	public Border resaltarnumero_placaActivosFijosPorRamos=null;
	public Boolean mostrarnumero_placaActivosFijosPorRamos=true;
	public Boolean activarnumero_placaActivosFijosPorRamos=true;

	public Border resaltarvalor_comercialActivosFijosPorRamos=null;
	public Boolean mostrarvalor_comercialActivosFijosPorRamos=true;
	public Boolean activarvalor_comercialActivosFijosPorRamos=true;

	
	

	public Border setResaltaridActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltaridActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridActivosFijosPorRamos() {
		return this.resaltaridActivosFijosPorRamos;
	}

	public void setResaltaridActivosFijosPorRamos(Border borderResaltar) {
		this.resaltaridActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostraridActivosFijosPorRamos() {
		return this.mostraridActivosFijosPorRamos;
	}

	public void setMostraridActivosFijosPorRamos(Boolean mostraridActivosFijosPorRamos) {
		this.mostraridActivosFijosPorRamos= mostraridActivosFijosPorRamos;
	}

	public Boolean getActivaridActivosFijosPorRamos() {
		return this.activaridActivosFijosPorRamos;
	}

	public void setActivaridActivosFijosPorRamos(Boolean activaridActivosFijosPorRamos) {
		this.activaridActivosFijosPorRamos= activaridActivosFijosPorRamos;
	}

	public Border setResaltarid_empresaActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarid_empresaActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaActivosFijosPorRamos() {
		return this.resaltarid_empresaActivosFijosPorRamos;
	}

	public void setResaltarid_empresaActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarid_empresaActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarid_empresaActivosFijosPorRamos() {
		return this.mostrarid_empresaActivosFijosPorRamos;
	}

	public void setMostrarid_empresaActivosFijosPorRamos(Boolean mostrarid_empresaActivosFijosPorRamos) {
		this.mostrarid_empresaActivosFijosPorRamos= mostrarid_empresaActivosFijosPorRamos;
	}

	public Boolean getActivarid_empresaActivosFijosPorRamos() {
		return this.activarid_empresaActivosFijosPorRamos;
	}

	public void setActivarid_empresaActivosFijosPorRamos(Boolean activarid_empresaActivosFijosPorRamos) {
		this.activarid_empresaActivosFijosPorRamos= activarid_empresaActivosFijosPorRamos;
	}

	public Boolean getCargarid_empresaActivosFijosPorRamos() {
		return this.cargarid_empresaActivosFijosPorRamos;
	}

	public void setCargarid_empresaActivosFijosPorRamos(Boolean cargarid_empresaActivosFijosPorRamos) {
		this.cargarid_empresaActivosFijosPorRamos= cargarid_empresaActivosFijosPorRamos;
	}

	public Border setResaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos() {
		return this.resaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public void setResaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos() {
		return this.mostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public void setMostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos(Boolean mostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos) {
		this.mostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos= mostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public Boolean getActivarid_tipo_ramo_activo_fijoActivosFijosPorRamos() {
		return this.activarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public void setActivarid_tipo_ramo_activo_fijoActivosFijosPorRamos(Boolean activarid_tipo_ramo_activo_fijoActivosFijosPorRamos) {
		this.activarid_tipo_ramo_activo_fijoActivosFijosPorRamos= activarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public Boolean getCargarid_tipo_ramo_activo_fijoActivosFijosPorRamos() {
		return this.cargarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public void setCargarid_tipo_ramo_activo_fijoActivosFijosPorRamos(Boolean cargarid_tipo_ramo_activo_fijoActivosFijosPorRamos) {
		this.cargarid_tipo_ramo_activo_fijoActivosFijosPorRamos= cargarid_tipo_ramo_activo_fijoActivosFijosPorRamos;
	}

	public Border setResaltarnombre_sub_grupoActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoActivosFijosPorRamos() {
		return this.resaltarnombre_sub_grupoActivosFijosPorRamos;
	}

	public void setResaltarnombre_sub_grupoActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnombre_sub_grupoActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoActivosFijosPorRamos() {
		return this.mostrarnombre_sub_grupoActivosFijosPorRamos;
	}

	public void setMostrarnombre_sub_grupoActivosFijosPorRamos(Boolean mostrarnombre_sub_grupoActivosFijosPorRamos) {
		this.mostrarnombre_sub_grupoActivosFijosPorRamos= mostrarnombre_sub_grupoActivosFijosPorRamos;
	}

	public Boolean getActivarnombre_sub_grupoActivosFijosPorRamos() {
		return this.activarnombre_sub_grupoActivosFijosPorRamos;
	}

	public void setActivarnombre_sub_grupoActivosFijosPorRamos(Boolean activarnombre_sub_grupoActivosFijosPorRamos) {
		this.activarnombre_sub_grupoActivosFijosPorRamos= activarnombre_sub_grupoActivosFijosPorRamos;
	}

	public Border setResaltarnombre_detalle_grupoActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoActivosFijosPorRamos() {
		return this.resaltarnombre_detalle_grupoActivosFijosPorRamos;
	}

	public void setResaltarnombre_detalle_grupoActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoActivosFijosPorRamos() {
		return this.mostrarnombre_detalle_grupoActivosFijosPorRamos;
	}

	public void setMostrarnombre_detalle_grupoActivosFijosPorRamos(Boolean mostrarnombre_detalle_grupoActivosFijosPorRamos) {
		this.mostrarnombre_detalle_grupoActivosFijosPorRamos= mostrarnombre_detalle_grupoActivosFijosPorRamos;
	}

	public Boolean getActivarnombre_detalle_grupoActivosFijosPorRamos() {
		return this.activarnombre_detalle_grupoActivosFijosPorRamos;
	}

	public void setActivarnombre_detalle_grupoActivosFijosPorRamos(Boolean activarnombre_detalle_grupoActivosFijosPorRamos) {
		this.activarnombre_detalle_grupoActivosFijosPorRamos= activarnombre_detalle_grupoActivosFijosPorRamos;
	}

	public Border setResaltarclaveActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarclaveActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveActivosFijosPorRamos() {
		return this.resaltarclaveActivosFijosPorRamos;
	}

	public void setResaltarclaveActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarclaveActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarclaveActivosFijosPorRamos() {
		return this.mostrarclaveActivosFijosPorRamos;
	}

	public void setMostrarclaveActivosFijosPorRamos(Boolean mostrarclaveActivosFijosPorRamos) {
		this.mostrarclaveActivosFijosPorRamos= mostrarclaveActivosFijosPorRamos;
	}

	public Boolean getActivarclaveActivosFijosPorRamos() {
		return this.activarclaveActivosFijosPorRamos;
	}

	public void setActivarclaveActivosFijosPorRamos(Boolean activarclaveActivosFijosPorRamos) {
		this.activarclaveActivosFijosPorRamos= activarclaveActivosFijosPorRamos;
	}

	public Border setResaltarnombreActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnombreActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreActivosFijosPorRamos() {
		return this.resaltarnombreActivosFijosPorRamos;
	}

	public void setResaltarnombreActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnombreActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnombreActivosFijosPorRamos() {
		return this.mostrarnombreActivosFijosPorRamos;
	}

	public void setMostrarnombreActivosFijosPorRamos(Boolean mostrarnombreActivosFijosPorRamos) {
		this.mostrarnombreActivosFijosPorRamos= mostrarnombreActivosFijosPorRamos;
	}

	public Boolean getActivarnombreActivosFijosPorRamos() {
		return this.activarnombreActivosFijosPorRamos;
	}

	public void setActivarnombreActivosFijosPorRamos(Boolean activarnombreActivosFijosPorRamos) {
		this.activarnombreActivosFijosPorRamos= activarnombreActivosFijosPorRamos;
	}

	public Border setResaltarfecha_compraActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarfecha_compraActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraActivosFijosPorRamos() {
		return this.resaltarfecha_compraActivosFijosPorRamos;
	}

	public void setResaltarfecha_compraActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarfecha_compraActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarfecha_compraActivosFijosPorRamos() {
		return this.mostrarfecha_compraActivosFijosPorRamos;
	}

	public void setMostrarfecha_compraActivosFijosPorRamos(Boolean mostrarfecha_compraActivosFijosPorRamos) {
		this.mostrarfecha_compraActivosFijosPorRamos= mostrarfecha_compraActivosFijosPorRamos;
	}

	public Boolean getActivarfecha_compraActivosFijosPorRamos() {
		return this.activarfecha_compraActivosFijosPorRamos;
	}

	public void setActivarfecha_compraActivosFijosPorRamos(Boolean activarfecha_compraActivosFijosPorRamos) {
		this.activarfecha_compraActivosFijosPorRamos= activarfecha_compraActivosFijosPorRamos;
	}

	public Border setResaltarvida_utilActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarvida_utilActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilActivosFijosPorRamos() {
		return this.resaltarvida_utilActivosFijosPorRamos;
	}

	public void setResaltarvida_utilActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarvida_utilActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarvida_utilActivosFijosPorRamos() {
		return this.mostrarvida_utilActivosFijosPorRamos;
	}

	public void setMostrarvida_utilActivosFijosPorRamos(Boolean mostrarvida_utilActivosFijosPorRamos) {
		this.mostrarvida_utilActivosFijosPorRamos= mostrarvida_utilActivosFijosPorRamos;
	}

	public Boolean getActivarvida_utilActivosFijosPorRamos() {
		return this.activarvida_utilActivosFijosPorRamos;
	}

	public void setActivarvida_utilActivosFijosPorRamos(Boolean activarvida_utilActivosFijosPorRamos) {
		this.activarvida_utilActivosFijosPorRamos= activarvida_utilActivosFijosPorRamos;
	}

	public Border setResaltarcosto_de_compraActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraActivosFijosPorRamos() {
		return this.resaltarcosto_de_compraActivosFijosPorRamos;
	}

	public void setResaltarcosto_de_compraActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarcosto_de_compraActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraActivosFijosPorRamos() {
		return this.mostrarcosto_de_compraActivosFijosPorRamos;
	}

	public void setMostrarcosto_de_compraActivosFijosPorRamos(Boolean mostrarcosto_de_compraActivosFijosPorRamos) {
		this.mostrarcosto_de_compraActivosFijosPorRamos= mostrarcosto_de_compraActivosFijosPorRamos;
	}

	public Boolean getActivarcosto_de_compraActivosFijosPorRamos() {
		return this.activarcosto_de_compraActivosFijosPorRamos;
	}

	public void setActivarcosto_de_compraActivosFijosPorRamos(Boolean activarcosto_de_compraActivosFijosPorRamos) {
		this.activarcosto_de_compraActivosFijosPorRamos= activarcosto_de_compraActivosFijosPorRamos;
	}

	public Border setResaltarmarcaActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarmarcaActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaActivosFijosPorRamos() {
		return this.resaltarmarcaActivosFijosPorRamos;
	}

	public void setResaltarmarcaActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarmarcaActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarmarcaActivosFijosPorRamos() {
		return this.mostrarmarcaActivosFijosPorRamos;
	}

	public void setMostrarmarcaActivosFijosPorRamos(Boolean mostrarmarcaActivosFijosPorRamos) {
		this.mostrarmarcaActivosFijosPorRamos= mostrarmarcaActivosFijosPorRamos;
	}

	public Boolean getActivarmarcaActivosFijosPorRamos() {
		return this.activarmarcaActivosFijosPorRamos;
	}

	public void setActivarmarcaActivosFijosPorRamos(Boolean activarmarcaActivosFijosPorRamos) {
		this.activarmarcaActivosFijosPorRamos= activarmarcaActivosFijosPorRamos;
	}

	public Border setResaltarmodeloActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarmodeloActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodeloActivosFijosPorRamos() {
		return this.resaltarmodeloActivosFijosPorRamos;
	}

	public void setResaltarmodeloActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarmodeloActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarmodeloActivosFijosPorRamos() {
		return this.mostrarmodeloActivosFijosPorRamos;
	}

	public void setMostrarmodeloActivosFijosPorRamos(Boolean mostrarmodeloActivosFijosPorRamos) {
		this.mostrarmodeloActivosFijosPorRamos= mostrarmodeloActivosFijosPorRamos;
	}

	public Boolean getActivarmodeloActivosFijosPorRamos() {
		return this.activarmodeloActivosFijosPorRamos;
	}

	public void setActivarmodeloActivosFijosPorRamos(Boolean activarmodeloActivosFijosPorRamos) {
		this.activarmodeloActivosFijosPorRamos= activarmodeloActivosFijosPorRamos;
	}

	public Border setResaltarnumero_matriculaActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnumero_matriculaActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_matriculaActivosFijosPorRamos() {
		return this.resaltarnumero_matriculaActivosFijosPorRamos;
	}

	public void setResaltarnumero_matriculaActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnumero_matriculaActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnumero_matriculaActivosFijosPorRamos() {
		return this.mostrarnumero_matriculaActivosFijosPorRamos;
	}

	public void setMostrarnumero_matriculaActivosFijosPorRamos(Boolean mostrarnumero_matriculaActivosFijosPorRamos) {
		this.mostrarnumero_matriculaActivosFijosPorRamos= mostrarnumero_matriculaActivosFijosPorRamos;
	}

	public Boolean getActivarnumero_matriculaActivosFijosPorRamos() {
		return this.activarnumero_matriculaActivosFijosPorRamos;
	}

	public void setActivarnumero_matriculaActivosFijosPorRamos(Boolean activarnumero_matriculaActivosFijosPorRamos) {
		this.activarnumero_matriculaActivosFijosPorRamos= activarnumero_matriculaActivosFijosPorRamos;
	}

	public Border setResaltarnumero_motorActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnumero_motorActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_motorActivosFijosPorRamos() {
		return this.resaltarnumero_motorActivosFijosPorRamos;
	}

	public void setResaltarnumero_motorActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnumero_motorActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnumero_motorActivosFijosPorRamos() {
		return this.mostrarnumero_motorActivosFijosPorRamos;
	}

	public void setMostrarnumero_motorActivosFijosPorRamos(Boolean mostrarnumero_motorActivosFijosPorRamos) {
		this.mostrarnumero_motorActivosFijosPorRamos= mostrarnumero_motorActivosFijosPorRamos;
	}

	public Boolean getActivarnumero_motorActivosFijosPorRamos() {
		return this.activarnumero_motorActivosFijosPorRamos;
	}

	public void setActivarnumero_motorActivosFijosPorRamos(Boolean activarnumero_motorActivosFijosPorRamos) {
		this.activarnumero_motorActivosFijosPorRamos= activarnumero_motorActivosFijosPorRamos;
	}

	public Border setResaltarnumero_chasisActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnumero_chasisActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chasisActivosFijosPorRamos() {
		return this.resaltarnumero_chasisActivosFijosPorRamos;
	}

	public void setResaltarnumero_chasisActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnumero_chasisActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnumero_chasisActivosFijosPorRamos() {
		return this.mostrarnumero_chasisActivosFijosPorRamos;
	}

	public void setMostrarnumero_chasisActivosFijosPorRamos(Boolean mostrarnumero_chasisActivosFijosPorRamos) {
		this.mostrarnumero_chasisActivosFijosPorRamos= mostrarnumero_chasisActivosFijosPorRamos;
	}

	public Boolean getActivarnumero_chasisActivosFijosPorRamos() {
		return this.activarnumero_chasisActivosFijosPorRamos;
	}

	public void setActivarnumero_chasisActivosFijosPorRamos(Boolean activarnumero_chasisActivosFijosPorRamos) {
		this.activarnumero_chasisActivosFijosPorRamos= activarnumero_chasisActivosFijosPorRamos;
	}

	public Border setResaltarnumero_placaActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarnumero_placaActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_placaActivosFijosPorRamos() {
		return this.resaltarnumero_placaActivosFijosPorRamos;
	}

	public void setResaltarnumero_placaActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarnumero_placaActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarnumero_placaActivosFijosPorRamos() {
		return this.mostrarnumero_placaActivosFijosPorRamos;
	}

	public void setMostrarnumero_placaActivosFijosPorRamos(Boolean mostrarnumero_placaActivosFijosPorRamos) {
		this.mostrarnumero_placaActivosFijosPorRamos= mostrarnumero_placaActivosFijosPorRamos;
	}

	public Boolean getActivarnumero_placaActivosFijosPorRamos() {
		return this.activarnumero_placaActivosFijosPorRamos;
	}

	public void setActivarnumero_placaActivosFijosPorRamos(Boolean activarnumero_placaActivosFijosPorRamos) {
		this.activarnumero_placaActivosFijosPorRamos= activarnumero_placaActivosFijosPorRamos;
	}

	public Border setResaltarvalor_comercialActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//activosfijosporramosBeanSwingJInternalFrame.jTtoolBarActivosFijosPorRamos.setBorder(borderResaltar);
		
		this.resaltarvalor_comercialActivosFijosPorRamos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comercialActivosFijosPorRamos() {
		return this.resaltarvalor_comercialActivosFijosPorRamos;
	}

	public void setResaltarvalor_comercialActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarvalor_comercialActivosFijosPorRamos= borderResaltar;
	}

	public Boolean getMostrarvalor_comercialActivosFijosPorRamos() {
		return this.mostrarvalor_comercialActivosFijosPorRamos;
	}

	public void setMostrarvalor_comercialActivosFijosPorRamos(Boolean mostrarvalor_comercialActivosFijosPorRamos) {
		this.mostrarvalor_comercialActivosFijosPorRamos= mostrarvalor_comercialActivosFijosPorRamos;
	}

	public Boolean getActivarvalor_comercialActivosFijosPorRamos() {
		return this.activarvalor_comercialActivosFijosPorRamos;
	}

	public void setActivarvalor_comercialActivosFijosPorRamos(Boolean activarvalor_comercialActivosFijosPorRamos) {
		this.activarvalor_comercialActivosFijosPorRamos= activarvalor_comercialActivosFijosPorRamos;
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
		
		
		this.setMostraridActivosFijosPorRamos(esInicial);
		this.setMostrarid_empresaActivosFijosPorRamos(esInicial);
		this.setMostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esInicial);
		this.setMostrarnombre_sub_grupoActivosFijosPorRamos(esInicial);
		this.setMostrarnombre_detalle_grupoActivosFijosPorRamos(esInicial);
		this.setMostrarclaveActivosFijosPorRamos(esInicial);
		this.setMostrarnombreActivosFijosPorRamos(esInicial);
		this.setMostrarfecha_compraActivosFijosPorRamos(esInicial);
		this.setMostrarvida_utilActivosFijosPorRamos(esInicial);
		this.setMostrarcosto_de_compraActivosFijosPorRamos(esInicial);
		this.setMostrarmarcaActivosFijosPorRamos(esInicial);
		this.setMostrarmodeloActivosFijosPorRamos(esInicial);
		this.setMostrarnumero_matriculaActivosFijosPorRamos(esInicial);
		this.setMostrarnumero_motorActivosFijosPorRamos(esInicial);
		this.setMostrarnumero_chasisActivosFijosPorRamos(esInicial);
		this.setMostrarnumero_placaActivosFijosPorRamos(esInicial);
		this.setMostrarvalor_comercialActivosFijosPorRamos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.ID)) {
				this.setMostraridActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setMostrarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.CLAVE)) {
				this.setMostrarclaveActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MARCA)) {
				this.setMostrarmarcaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MODELO)) {
				this.setMostrarmodeloActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA)) {
				this.setMostrarnumero_matriculaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR)) {
				this.setMostrarnumero_motorActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS)) {
				this.setMostrarnumero_chasisActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA)) {
				this.setMostrarnumero_placaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL)) {
				this.setMostrarvalor_comercialActivosFijosPorRamos(esAsigna);
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
		
		
		this.setActivaridActivosFijosPorRamos(esInicial);
		this.setActivarid_empresaActivosFijosPorRamos(esInicial);
		this.setActivarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esInicial);
		this.setActivarnombre_sub_grupoActivosFijosPorRamos(esInicial);
		this.setActivarnombre_detalle_grupoActivosFijosPorRamos(esInicial);
		this.setActivarclaveActivosFijosPorRamos(esInicial);
		this.setActivarnombreActivosFijosPorRamos(esInicial);
		this.setActivarfecha_compraActivosFijosPorRamos(esInicial);
		this.setActivarvida_utilActivosFijosPorRamos(esInicial);
		this.setActivarcosto_de_compraActivosFijosPorRamos(esInicial);
		this.setActivarmarcaActivosFijosPorRamos(esInicial);
		this.setActivarmodeloActivosFijosPorRamos(esInicial);
		this.setActivarnumero_matriculaActivosFijosPorRamos(esInicial);
		this.setActivarnumero_motorActivosFijosPorRamos(esInicial);
		this.setActivarnumero_chasisActivosFijosPorRamos(esInicial);
		this.setActivarnumero_placaActivosFijosPorRamos(esInicial);
		this.setActivarvalor_comercialActivosFijosPorRamos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.ID)) {
				this.setActivaridActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setActivarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.CLAVE)) {
				this.setActivarclaveActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MARCA)) {
				this.setActivarmarcaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MODELO)) {
				this.setActivarmodeloActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA)) {
				this.setActivarnumero_matriculaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR)) {
				this.setActivarnumero_motorActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS)) {
				this.setActivarnumero_chasisActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA)) {
				this.setActivarnumero_placaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL)) {
				this.setActivarvalor_comercialActivosFijosPorRamos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridActivosFijosPorRamos(esInicial);
		this.setResaltarid_empresaActivosFijosPorRamos(esInicial);
		this.setResaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esInicial);
		this.setResaltarnombre_sub_grupoActivosFijosPorRamos(esInicial);
		this.setResaltarnombre_detalle_grupoActivosFijosPorRamos(esInicial);
		this.setResaltarclaveActivosFijosPorRamos(esInicial);
		this.setResaltarnombreActivosFijosPorRamos(esInicial);
		this.setResaltarfecha_compraActivosFijosPorRamos(esInicial);
		this.setResaltarvida_utilActivosFijosPorRamos(esInicial);
		this.setResaltarcosto_de_compraActivosFijosPorRamos(esInicial);
		this.setResaltarmarcaActivosFijosPorRamos(esInicial);
		this.setResaltarmodeloActivosFijosPorRamos(esInicial);
		this.setResaltarnumero_matriculaActivosFijosPorRamos(esInicial);
		this.setResaltarnumero_motorActivosFijosPorRamos(esInicial);
		this.setResaltarnumero_chasisActivosFijosPorRamos(esInicial);
		this.setResaltarnumero_placaActivosFijosPorRamos(esInicial);
		this.setResaltarvalor_comercialActivosFijosPorRamos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.ID)) {
				this.setResaltaridActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setResaltarid_tipo_ramo_activo_fijoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.CLAVE)) {
				this.setResaltarclaveActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MARCA)) {
				this.setResaltarmarcaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.MODELO)) {
				this.setResaltarmodeloActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMATRICULA)) {
				this.setResaltarnumero_matriculaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROMOTOR)) {
				this.setResaltarnumero_motorActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROCHASIS)) {
				this.setResaltarnumero_chasisActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.NUMEROPLACA)) {
				this.setResaltarnumero_placaActivosFijosPorRamos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ActivosFijosPorRamosConstantesFunciones.VALORCOMERCIAL)) {
				this.setResaltarvalor_comercialActivosFijosPorRamos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaActivosFijosPorRamosActivosFijosPorRamos=true;

	public Boolean getMostrarBusquedaActivosFijosPorRamosActivosFijosPorRamos() {
		return this.mostrarBusquedaActivosFijosPorRamosActivosFijosPorRamos;
	}

	public void setMostrarBusquedaActivosFijosPorRamosActivosFijosPorRamos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaActivosFijosPorRamosActivosFijosPorRamos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaActivosFijosPorRamosActivosFijosPorRamos=true;

	public Boolean getActivarBusquedaActivosFijosPorRamosActivosFijosPorRamos() {
		return this.activarBusquedaActivosFijosPorRamosActivosFijosPorRamos;
	}

	public void setActivarBusquedaActivosFijosPorRamosActivosFijosPorRamos(Boolean habilitarResaltar) {
		this.activarBusquedaActivosFijosPorRamosActivosFijosPorRamos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos=null;

	public Border getResaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos() {
		return this.resaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos;
	}

	public void setResaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos(Border borderResaltar) {
		this.resaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos= borderResaltar;
	}

	public void setResaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos(ParametroGeneralUsuario parametroGeneralUsuario/*ActivosFijosPorRamosBeanSwingJInternalFrame activosfijosporramosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaActivosFijosPorRamosActivosFijosPorRamos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}