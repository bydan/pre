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


import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrConstantesFunciones;
import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



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
final public class PresupuestoFlujoCajaTsrConstantesFunciones extends PresupuestoFlujoCajaTsrConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoFlujoCajaTsr";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoFlujoCajaTsr"+PresupuestoFlujoCajaTsrConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoFlujoCajaTsrHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoFlujoCajaTsrHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaTsrHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaTsrHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaTsrHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaTsrHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaTsrConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoFlujoCajaTsrConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoFlujoCajaTsrConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoFlujoCajaTsrConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoFlujoCajaTsrConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Presupuesto Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Flujo Caja Tsr";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoFlujoCajaTsr";
	public static final String OBJECTNAME="presupuestoflujocajatsr";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="presupuesto_flujo_caja_tsr";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoflujocajatsr from "+PresupuestoFlujoCajaTsrConstantesFunciones.SPERSISTENCENAME+" presupuestoflujocajatsr";
	public static String QUERYSELECTNATIVE="select "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".version_row,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_usuario,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_anio,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_mes,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_centro_actividad,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".codigo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".nombre,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".fecha,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".fecha_presupuesto,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".valor,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_centro_costo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".descripcion from "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoFlujoCajaTsrConstantesFuncionesAdditional presupuestoflujocajatsrConstantesFuncionesAdditional=null;
	
	public PresupuestoFlujoCajaTsrConstantesFuncionesAdditional getPresupuestoFlujoCajaTsrConstantesFuncionesAdditional() {
		return this.presupuestoflujocajatsrConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoFlujoCajaTsrConstantesFuncionesAdditional(PresupuestoFlujoCajaTsrConstantesFuncionesAdditional presupuestoflujocajatsrConstantesFuncionesAdditional) {
		try {
			this.presupuestoflujocajatsrConstantesFuncionesAdditional=presupuestoflujocajatsrConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHA= "fecha";
    public static final String FECHAPRESUPUESTO= "fecha_presupuesto";
    public static final String VALOR= "valor";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Activad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAPRESUPUESTO= "F. Presupuesto";
		public static final String LABEL_FECHAPRESUPUESTO_LOWER= "Fecha Presupuesto";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresupuestoFlujoCajaTsrLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDMES)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHA)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHAPRESUPUESTO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.VALOR)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION)) {sLabelColumna=PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoFlujoCajaTsrDescripcion(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoflujocajatsr !=null/* && presupuestoflujocajatsr.getId()!=0*/) {
			sDescripcion=presupuestoflujocajatsr.getcodigo();//presupuestoflujocajatsrpresupuestoflujocajatsr.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoFlujoCajaTsrDescripcionDetallado(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoflujocajatsr.getId().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoflujocajatsr.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_sucursal().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_usuario().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_anio().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDMES+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_mes().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_tipo_movimiento().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_centro_actividad().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO+"=";
		sDescripcion+=presupuestoflujocajatsr.getcodigo()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presupuestoflujocajatsr.getnombre()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.FECHA+"=";
		sDescripcion+=presupuestoflujocajatsr.getfecha().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO+"=";
		sDescripcion+=presupuestoflujocajatsr.getfecha_presupuesto().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.VALOR+"=";
		sDescripcion+=presupuestoflujocajatsr.getvalor().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_cuenta_contable().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=presupuestoflujocajatsr.getid_centro_costo().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=presupuestoflujocajatsr.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoFlujoCajaTsrDescripcion(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,String sValor) throws Exception {			
		if(presupuestoflujocajatsr !=null) {
			presupuestoflujocajatsr.setcodigo(sValor);;//presupuestoflujocajatsrpresupuestoflujocajatsr.getcodigo().trim();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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

	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centroactividad!=null/*&&centroactividad.getId()>0*/) {
			sDescripcion=CentroActividadConstantesFunciones.getCentroActividadDescripcion(centroactividad);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorFecha")) {
			sNombreIndice="Tipo=  Por Fecha";
		} else if(sNombreIndice.equals("BusquedaPorFechaPresupuesto")) {
			sNombreIndice="Tipo=  Por F. Presupuesto";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorValor")) {
			sNombreIndice="Tipo=  Por Valor";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCentroActividad")) {
			sNombreIndice="Tipo=  Por Centro Activad";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFecha(Date fecha) {
		String sDetalleIndice=" Parametros->";
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaPresupuesto(Date fecha_presupuesto) {
		String sDetalleIndice=" Parametros->";
		if(fecha_presupuesto!=null) {sDetalleIndice+=" F. Presupuesto="+fecha_presupuesto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorValor(Double valor) {
		String sDetalleIndice=" Parametros->";
		if(valor!=null) {sDetalleIndice+=" Valor="+valor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroActividad(Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Activad="+id_centro_actividad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presupuestoflujocajatsr.setcodigo(presupuestoflujocajatsr.getcodigo().trim());
		presupuestoflujocajatsr.setnombre(presupuestoflujocajatsr.getnombre().trim());
		presupuestoflujocajatsr.setdescripcion(presupuestoflujocajatsr.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr: presupuestoflujocajatsrs) {
			presupuestoflujocajatsr.setcodigo(presupuestoflujocajatsr.getcodigo().trim());
			presupuestoflujocajatsr.setnombre(presupuestoflujocajatsr.getnombre().trim());
			presupuestoflujocajatsr.setdescripcion(presupuestoflujocajatsr.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoflujocajatsr.getConCambioAuxiliar()) {
			presupuestoflujocajatsr.setIsDeleted(presupuestoflujocajatsr.getIsDeletedAuxiliar());	
			presupuestoflujocajatsr.setIsNew(presupuestoflujocajatsr.getIsNewAuxiliar());	
			presupuestoflujocajatsr.setIsChanged(presupuestoflujocajatsr.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoflujocajatsr.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoflujocajatsr.setIsDeletedAuxiliar(false);	
			presupuestoflujocajatsr.setIsNewAuxiliar(false);	
			presupuestoflujocajatsr.setIsChangedAuxiliar(false);
			
			presupuestoflujocajatsr.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr : presupuestoflujocajatsrs) {
			if(conAsignarBase && presupuestoflujocajatsr.getConCambioAuxiliar()) {
				presupuestoflujocajatsr.setIsDeleted(presupuestoflujocajatsr.getIsDeletedAuxiliar());	
				presupuestoflujocajatsr.setIsNew(presupuestoflujocajatsr.getIsNewAuxiliar());	
				presupuestoflujocajatsr.setIsChanged(presupuestoflujocajatsr.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoflujocajatsr.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoflujocajatsr.setIsDeletedAuxiliar(false);	
				presupuestoflujocajatsr.setIsNewAuxiliar(false);	
				presupuestoflujocajatsr.setIsChangedAuxiliar(false);
				
				presupuestoflujocajatsr.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean conEnteros) throws Exception  {
		presupuestoflujocajatsr.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr: presupuestoflujocajatsrs) {
			presupuestoflujocajatsr.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux) throws Exception  {
		PresupuestoFlujoCajaTsrConstantesFunciones.InicializarValoresPresupuestoFlujoCajaTsr(presupuestoflujocajatsrAux,true);
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr: presupuestoflujocajatsrs) {
			if(presupuestoflujocajatsr.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoflujocajatsrAux.setvalor(presupuestoflujocajatsrAux.getvalor()+presupuestoflujocajatsr.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoFlujoCajaTsr(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoFlujoCajaTsrConstantesFunciones.getArrayColumnasGlobalesPresupuestoFlujoCajaTsr(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoFlujoCajaTsr(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoFlujoCajaTsr(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux: presupuestoflujocajatsrs) {
			if(presupuestoflujocajatsrAux!=null && presupuestoflujocajatsr!=null) {
				if((presupuestoflujocajatsrAux.getId()==null && presupuestoflujocajatsr.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoflujocajatsrAux.getId()!=null && presupuestoflujocajatsr.getId()!=null){
					if(presupuestoflujocajatsrAux.getId().equals(presupuestoflujocajatsr.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr: presupuestoflujocajatsrs) {			
			if(presupuestoflujocajatsr.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presupuestoflujocajatsr.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoFlujoCajaTsr() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_ID, PresupuestoFlujoCajaTsrConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VERSIONROW, PresupuestoFlujoCajaTsrConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEMPRESA, PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDSUCURSAL, PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDPERIODO, PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDUSUARIO, PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDANIO, PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDMES, PresupuestoFlujoCajaTsrConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROACTIVIDAD, PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_CODIGO, PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_NOMBRE, PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHA, PresupuestoFlujoCajaTsrConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHAPRESUPUESTO, PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR, PresupuestoFlujoCajaTsrConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCUENTACONTABLE, PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROCOSTO, PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_DESCRIPCION, PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoFlujoCajaTsr() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCajaTsr() throws Exception  {
		return PresupuestoFlujoCajaTsrConstantesFunciones.getTiposSeleccionarPresupuestoFlujoCajaTsr(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCajaTsr(Boolean conFk) throws Exception  {
		return PresupuestoFlujoCajaTsrConstantesFunciones.getTiposSeleccionarPresupuestoFlujoCajaTsr(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCajaTsr(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHAPRESUPUESTO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHAPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoFlujoCajaTsr(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux) throws Exception {
		
			presupuestoflujocajatsrAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoflujocajatsrAux.getEmpresa()));
			presupuestoflujocajatsrAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoflujocajatsrAux.getSucursal()));
			presupuestoflujocajatsrAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoflujocajatsrAux.getEjercicio()));
			presupuestoflujocajatsrAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoflujocajatsrAux.getPeriodo()));
			presupuestoflujocajatsrAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(presupuestoflujocajatsrAux.getUsuario()));
			presupuestoflujocajatsrAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(presupuestoflujocajatsrAux.getAnio()));
			presupuestoflujocajatsrAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(presupuestoflujocajatsrAux.getMes()));
			presupuestoflujocajatsrAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(presupuestoflujocajatsrAux.getTipoMovimiento()));
			presupuestoflujocajatsrAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(presupuestoflujocajatsrAux.getCentroActividad()));
			presupuestoflujocajatsrAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoflujocajatsrAux.getCuentaContable()));
			presupuestoflujocajatsrAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presupuestoflujocajatsrAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrsTemp) throws Exception {
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux:presupuestoflujocajatsrsTemp) {
			
			presupuestoflujocajatsrAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoflujocajatsrAux.getEmpresa()));
			presupuestoflujocajatsrAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoflujocajatsrAux.getSucursal()));
			presupuestoflujocajatsrAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoflujocajatsrAux.getEjercicio()));
			presupuestoflujocajatsrAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoflujocajatsrAux.getPeriodo()));
			presupuestoflujocajatsrAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(presupuestoflujocajatsrAux.getUsuario()));
			presupuestoflujocajatsrAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(presupuestoflujocajatsrAux.getAnio()));
			presupuestoflujocajatsrAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(presupuestoflujocajatsrAux.getMes()));
			presupuestoflujocajatsrAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(presupuestoflujocajatsrAux.getTipoMovimiento()));
			presupuestoflujocajatsrAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(presupuestoflujocajatsrAux.getCentroActividad()));
			presupuestoflujocajatsrAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoflujocajatsrAux.getCuentaContable()));
			presupuestoflujocajatsrAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presupuestoflujocajatsrAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoFlujoCajaTsr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(CentroActividad.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CentroCosto.class));
				
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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoFlujoCajaTsr(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCajaTsr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoFlujoCajaTsrConstantesFunciones.getClassesRelationshipsOfPresupuestoFlujoCajaTsr(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCajaTsr(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoFlujoCajaTsr(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoFlujoCajaTsrConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoFlujoCajaTsr(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoFlujoCajaTsr(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoFlujoCajaTsr presupuestoflujocajatsrEncontrado=null;
			
			for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal:presupuestoflujocajatsrs) {
				if(presupuestoflujocajatsrLocal.getId().equals(presupuestoflujocajatsr.getId())) {
					presupuestoflujocajatsrEncontrado=presupuestoflujocajatsrLocal;
					
					presupuestoflujocajatsrLocal.setIsChanged(presupuestoflujocajatsr.getIsChanged());
					presupuestoflujocajatsrLocal.setIsNew(presupuestoflujocajatsr.getIsNew());
					presupuestoflujocajatsrLocal.setIsDeleted(presupuestoflujocajatsr.getIsDeleted());
					
					presupuestoflujocajatsrLocal.setGeneralEntityOriginal(presupuestoflujocajatsr.getGeneralEntityOriginal());
					
					presupuestoflujocajatsrLocal.setId(presupuestoflujocajatsr.getId());	
					presupuestoflujocajatsrLocal.setVersionRow(presupuestoflujocajatsr.getVersionRow());	
					presupuestoflujocajatsrLocal.setid_empresa(presupuestoflujocajatsr.getid_empresa());	
					presupuestoflujocajatsrLocal.setid_sucursal(presupuestoflujocajatsr.getid_sucursal());	
					presupuestoflujocajatsrLocal.setid_ejercicio(presupuestoflujocajatsr.getid_ejercicio());	
					presupuestoflujocajatsrLocal.setid_periodo(presupuestoflujocajatsr.getid_periodo());	
					presupuestoflujocajatsrLocal.setid_usuario(presupuestoflujocajatsr.getid_usuario());	
					presupuestoflujocajatsrLocal.setid_anio(presupuestoflujocajatsr.getid_anio());	
					presupuestoflujocajatsrLocal.setid_mes(presupuestoflujocajatsr.getid_mes());	
					presupuestoflujocajatsrLocal.setid_tipo_movimiento(presupuestoflujocajatsr.getid_tipo_movimiento());	
					presupuestoflujocajatsrLocal.setid_centro_actividad(presupuestoflujocajatsr.getid_centro_actividad());	
					presupuestoflujocajatsrLocal.setcodigo(presupuestoflujocajatsr.getcodigo());	
					presupuestoflujocajatsrLocal.setnombre(presupuestoflujocajatsr.getnombre());	
					presupuestoflujocajatsrLocal.setfecha(presupuestoflujocajatsr.getfecha());	
					presupuestoflujocajatsrLocal.setfecha_presupuesto(presupuestoflujocajatsr.getfecha_presupuesto());	
					presupuestoflujocajatsrLocal.setvalor(presupuestoflujocajatsr.getvalor());	
					presupuestoflujocajatsrLocal.setid_cuenta_contable(presupuestoflujocajatsr.getid_cuenta_contable());	
					presupuestoflujocajatsrLocal.setid_centro_costo(presupuestoflujocajatsr.getid_centro_costo());	
					presupuestoflujocajatsrLocal.setdescripcion(presupuestoflujocajatsr.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoflujocajatsr.getIsDeleted()) {
				if(!existe) {
					presupuestoflujocajatsrs.add(presupuestoflujocajatsr);
				}
			} else {
				if(presupuestoflujocajatsrEncontrado!=null && permiteQuitar)  {
					presupuestoflujocajatsrs.remove(presupuestoflujocajatsrEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs) throws Exception {
		try	{			
			for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal:presupuestoflujocajatsrs) {
				if(presupuestoflujocajatsrLocal.getId().equals(presupuestoflujocajatsr.getId())) {
					presupuestoflujocajatsrLocal.setIsSelected(presupuestoflujocajatsr.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrsAux) throws Exception {
		//this.presupuestoflujocajatsrsAux=presupuestoflujocajatsrsAux;
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux:presupuestoflujocajatsrsAux) {
			if(presupuestoflujocajatsrAux.getIsChanged()) {
				presupuestoflujocajatsrAux.setIsChanged(false);
			}		
			
			if(presupuestoflujocajatsrAux.getIsNew()) {
				presupuestoflujocajatsrAux.setIsNew(false);
			}	
			
			if(presupuestoflujocajatsrAux.getIsDeleted()) {
				presupuestoflujocajatsrAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux) throws Exception {
		//this.presupuestoflujocajatsrAux=presupuestoflujocajatsrAux;
		
			if(presupuestoflujocajatsrAux.getIsChanged()) {
				presupuestoflujocajatsrAux.setIsChanged(false);
			}		
			
			if(presupuestoflujocajatsrAux.getIsNew()) {
				presupuestoflujocajatsrAux.setIsNew(false);
			}	
			
			if(presupuestoflujocajatsrAux.getIsDeleted()) {
				presupuestoflujocajatsrAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAsignar,PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {
		presupuestoflujocajatsrAsignar.setId(presupuestoflujocajatsr.getId());	
		presupuestoflujocajatsrAsignar.setVersionRow(presupuestoflujocajatsr.getVersionRow());	
		presupuestoflujocajatsrAsignar.setid_empresa(presupuestoflujocajatsr.getid_empresa());
		presupuestoflujocajatsrAsignar.setempresa_descripcion(presupuestoflujocajatsr.getempresa_descripcion());	
		presupuestoflujocajatsrAsignar.setid_sucursal(presupuestoflujocajatsr.getid_sucursal());
		presupuestoflujocajatsrAsignar.setsucursal_descripcion(presupuestoflujocajatsr.getsucursal_descripcion());	
		presupuestoflujocajatsrAsignar.setid_ejercicio(presupuestoflujocajatsr.getid_ejercicio());
		presupuestoflujocajatsrAsignar.setejercicio_descripcion(presupuestoflujocajatsr.getejercicio_descripcion());	
		presupuestoflujocajatsrAsignar.setid_periodo(presupuestoflujocajatsr.getid_periodo());
		presupuestoflujocajatsrAsignar.setperiodo_descripcion(presupuestoflujocajatsr.getperiodo_descripcion());	
		presupuestoflujocajatsrAsignar.setid_usuario(presupuestoflujocajatsr.getid_usuario());
		presupuestoflujocajatsrAsignar.setusuario_descripcion(presupuestoflujocajatsr.getusuario_descripcion());	
		presupuestoflujocajatsrAsignar.setid_anio(presupuestoflujocajatsr.getid_anio());
		presupuestoflujocajatsrAsignar.setanio_descripcion(presupuestoflujocajatsr.getanio_descripcion());	
		presupuestoflujocajatsrAsignar.setid_mes(presupuestoflujocajatsr.getid_mes());
		presupuestoflujocajatsrAsignar.setmes_descripcion(presupuestoflujocajatsr.getmes_descripcion());	
		presupuestoflujocajatsrAsignar.setid_tipo_movimiento(presupuestoflujocajatsr.getid_tipo_movimiento());
		presupuestoflujocajatsrAsignar.settipomovimiento_descripcion(presupuestoflujocajatsr.gettipomovimiento_descripcion());	
		presupuestoflujocajatsrAsignar.setid_centro_actividad(presupuestoflujocajatsr.getid_centro_actividad());
		presupuestoflujocajatsrAsignar.setcentroactividad_descripcion(presupuestoflujocajatsr.getcentroactividad_descripcion());	
		presupuestoflujocajatsrAsignar.setcodigo(presupuestoflujocajatsr.getcodigo());	
		presupuestoflujocajatsrAsignar.setnombre(presupuestoflujocajatsr.getnombre());	
		presupuestoflujocajatsrAsignar.setfecha(presupuestoflujocajatsr.getfecha());	
		presupuestoflujocajatsrAsignar.setfecha_presupuesto(presupuestoflujocajatsr.getfecha_presupuesto());	
		presupuestoflujocajatsrAsignar.setvalor(presupuestoflujocajatsr.getvalor());	
		presupuestoflujocajatsrAsignar.setid_cuenta_contable(presupuestoflujocajatsr.getid_cuenta_contable());
		presupuestoflujocajatsrAsignar.setcuentacontable_descripcion(presupuestoflujocajatsr.getcuentacontable_descripcion());	
		presupuestoflujocajatsrAsignar.setid_centro_costo(presupuestoflujocajatsr.getid_centro_costo());
		presupuestoflujocajatsrAsignar.setcentrocosto_descripcion(presupuestoflujocajatsr.getcentrocosto_descripcion());	
		presupuestoflujocajatsrAsignar.setdescripcion(presupuestoflujocajatsr.getdescripcion());	
	}
	
	public static void inicializarPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {
		try {
				presupuestoflujocajatsr.setId(0L);	
					
				presupuestoflujocajatsr.setid_empresa(-1L);	
				presupuestoflujocajatsr.setid_sucursal(-1L);	
				presupuestoflujocajatsr.setid_ejercicio(-1L);	
				presupuestoflujocajatsr.setid_periodo(-1L);	
				presupuestoflujocajatsr.setid_usuario(-1L);	
				presupuestoflujocajatsr.setid_anio(null);	
				presupuestoflujocajatsr.setid_mes(null);	
				presupuestoflujocajatsr.setid_tipo_movimiento(-1L);	
				presupuestoflujocajatsr.setid_centro_actividad(null);	
				presupuestoflujocajatsr.setcodigo("");	
				presupuestoflujocajatsr.setnombre("");	
				presupuestoflujocajatsr.setfecha(new Date());	
				presupuestoflujocajatsr.setfecha_presupuesto(new Date());	
				presupuestoflujocajatsr.setvalor(0.0);	
				presupuestoflujocajatsr.setid_cuenta_contable(-1L);	
				presupuestoflujocajatsr.setid_centro_costo(null);	
				presupuestoflujocajatsr.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoFlujoCajaTsr(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_FECHAPRESUPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaTsrConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoFlujoCajaTsr(String sTipo,Row row,Workbook workbook,PresupuestoFlujoCajaTsr presupuestoflujocajatsr,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getfecha_presupuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocajatsr.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoFlujoCajaTsr=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoFlujoCajaTsr() {
		return this.sFinalQueryPresupuestoFlujoCajaTsr;
	}
	
	public void setsFinalQueryPresupuestoFlujoCajaTsr(String sFinalQueryPresupuestoFlujoCajaTsr) {
		this.sFinalQueryPresupuestoFlujoCajaTsr= sFinalQueryPresupuestoFlujoCajaTsr;
	}
	
	public Border resaltarSeleccionarPresupuestoFlujoCajaTsr=null;
	
	public Border setResaltarSeleccionarPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoFlujoCajaTsr= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoFlujoCajaTsr() {
		return this.resaltarSeleccionarPresupuestoFlujoCajaTsr;
	}
	
	public void setResaltarSeleccionarPresupuestoFlujoCajaTsr(Border borderResaltarSeleccionarPresupuestoFlujoCajaTsr) {
		this.resaltarSeleccionarPresupuestoFlujoCajaTsr= borderResaltarSeleccionarPresupuestoFlujoCajaTsr;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoFlujoCajaTsr=null;
	public Boolean mostraridPresupuestoFlujoCajaTsr=true;
	public Boolean activaridPresupuestoFlujoCajaTsr=true;

	public Border resaltarid_empresaPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_empresaPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_empresaPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_empresaPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_sucursalPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_sucursalPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_sucursalPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_ejercicioPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_ejercicioPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_ejercicioPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_periodoPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_periodoPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_periodoPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_usuarioPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_usuarioPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_usuarioPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_usuarioPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_anioPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_anioPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_anioPresupuestoFlujoCajaTsr=false;
	public Boolean cargarid_anioPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_mesPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_mesPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_mesPresupuestoFlujoCajaTsr=false;
	public Boolean cargarid_mesPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_tipo_movimientoPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_tipo_movimientoPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_tipo_movimientoPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_centro_actividadPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_centro_actividadPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_centro_actividadPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_centro_actividadPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarcodigoPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarcodigoPresupuestoFlujoCajaTsr=true;
	public Boolean activarcodigoPresupuestoFlujoCajaTsr=true;

	public Border resaltarnombrePresupuestoFlujoCajaTsr=null;
	public Boolean mostrarnombrePresupuestoFlujoCajaTsr=true;
	public Boolean activarnombrePresupuestoFlujoCajaTsr=true;

	public Border resaltarfechaPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarfechaPresupuestoFlujoCajaTsr=true;
	public Boolean activarfechaPresupuestoFlujoCajaTsr=true;

	public Border resaltarfecha_presupuestoPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarfecha_presupuestoPresupuestoFlujoCajaTsr=true;
	public Boolean activarfecha_presupuestoPresupuestoFlujoCajaTsr=true;

	public Border resaltarvalorPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarvalorPresupuestoFlujoCajaTsr=true;
	public Boolean activarvalorPresupuestoFlujoCajaTsr=true;

	public Border resaltarid_cuenta_contablePresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_cuenta_contablePresupuestoFlujoCajaTsr=true;
	public Boolean activarid_cuenta_contablePresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_cuenta_contablePresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contablePresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltarid_centro_costoPresupuestoFlujoCajaTsr=null;
	public Boolean mostrarid_centro_costoPresupuestoFlujoCajaTsr=true;
	public Boolean activarid_centro_costoPresupuestoFlujoCajaTsr=true;
	public Boolean cargarid_centro_costoPresupuestoFlujoCajaTsr=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPresupuestoFlujoCajaTsr=false;//ConEventDepend=true

	public Border resaltardescripcionPresupuestoFlujoCajaTsr=null;
	public Boolean mostrardescripcionPresupuestoFlujoCajaTsr=true;
	public Boolean activardescripcionPresupuestoFlujoCajaTsr=true;

	
	

	public Border setResaltaridPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoFlujoCajaTsr() {
		return this.resaltaridPresupuestoFlujoCajaTsr;
	}

	public void setResaltaridPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltaridPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostraridPresupuestoFlujoCajaTsr() {
		return this.mostraridPresupuestoFlujoCajaTsr;
	}

	public void setMostraridPresupuestoFlujoCajaTsr(Boolean mostraridPresupuestoFlujoCajaTsr) {
		this.mostraridPresupuestoFlujoCajaTsr= mostraridPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivaridPresupuestoFlujoCajaTsr() {
		return this.activaridPresupuestoFlujoCajaTsr;
	}

	public void setActivaridPresupuestoFlujoCajaTsr(Boolean activaridPresupuestoFlujoCajaTsr) {
		this.activaridPresupuestoFlujoCajaTsr= activaridPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_empresaPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoFlujoCajaTsr() {
		return this.resaltarid_empresaPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_empresaPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoFlujoCajaTsr() {
		return this.mostrarid_empresaPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_empresaPresupuestoFlujoCajaTsr(Boolean mostrarid_empresaPresupuestoFlujoCajaTsr) {
		this.mostrarid_empresaPresupuestoFlujoCajaTsr= mostrarid_empresaPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_empresaPresupuestoFlujoCajaTsr() {
		return this.activarid_empresaPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_empresaPresupuestoFlujoCajaTsr(Boolean activarid_empresaPresupuestoFlujoCajaTsr) {
		this.activarid_empresaPresupuestoFlujoCajaTsr= activarid_empresaPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_empresaPresupuestoFlujoCajaTsr() {
		return this.cargarid_empresaPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_empresaPresupuestoFlujoCajaTsr(Boolean cargarid_empresaPresupuestoFlujoCajaTsr) {
		this.cargarid_empresaPresupuestoFlujoCajaTsr= cargarid_empresaPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_sucursalPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresupuestoFlujoCajaTsr() {
		return this.resaltarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_sucursalPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_sucursalPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresupuestoFlujoCajaTsr() {
		return this.mostrarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_sucursalPresupuestoFlujoCajaTsr(Boolean mostrarid_sucursalPresupuestoFlujoCajaTsr) {
		this.mostrarid_sucursalPresupuestoFlujoCajaTsr= mostrarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_sucursalPresupuestoFlujoCajaTsr() {
		return this.activarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_sucursalPresupuestoFlujoCajaTsr(Boolean activarid_sucursalPresupuestoFlujoCajaTsr) {
		this.activarid_sucursalPresupuestoFlujoCajaTsr= activarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_sucursalPresupuestoFlujoCajaTsr() {
		return this.cargarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_sucursalPresupuestoFlujoCajaTsr(Boolean cargarid_sucursalPresupuestoFlujoCajaTsr) {
		this.cargarid_sucursalPresupuestoFlujoCajaTsr= cargarid_sucursalPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_ejercicioPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoFlujoCajaTsr() {
		return this.resaltarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_ejercicioPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoFlujoCajaTsr() {
		return this.mostrarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_ejercicioPresupuestoFlujoCajaTsr(Boolean mostrarid_ejercicioPresupuestoFlujoCajaTsr) {
		this.mostrarid_ejercicioPresupuestoFlujoCajaTsr= mostrarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_ejercicioPresupuestoFlujoCajaTsr() {
		return this.activarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_ejercicioPresupuestoFlujoCajaTsr(Boolean activarid_ejercicioPresupuestoFlujoCajaTsr) {
		this.activarid_ejercicioPresupuestoFlujoCajaTsr= activarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_ejercicioPresupuestoFlujoCajaTsr() {
		return this.cargarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_ejercicioPresupuestoFlujoCajaTsr(Boolean cargarid_ejercicioPresupuestoFlujoCajaTsr) {
		this.cargarid_ejercicioPresupuestoFlujoCajaTsr= cargarid_ejercicioPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_periodoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoFlujoCajaTsr() {
		return this.resaltarid_periodoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_periodoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoFlujoCajaTsr() {
		return this.mostrarid_periodoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_periodoPresupuestoFlujoCajaTsr(Boolean mostrarid_periodoPresupuestoFlujoCajaTsr) {
		this.mostrarid_periodoPresupuestoFlujoCajaTsr= mostrarid_periodoPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_periodoPresupuestoFlujoCajaTsr() {
		return this.activarid_periodoPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_periodoPresupuestoFlujoCajaTsr(Boolean activarid_periodoPresupuestoFlujoCajaTsr) {
		this.activarid_periodoPresupuestoFlujoCajaTsr= activarid_periodoPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_periodoPresupuestoFlujoCajaTsr() {
		return this.cargarid_periodoPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_periodoPresupuestoFlujoCajaTsr(Boolean cargarid_periodoPresupuestoFlujoCajaTsr) {
		this.cargarid_periodoPresupuestoFlujoCajaTsr= cargarid_periodoPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_usuarioPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPresupuestoFlujoCajaTsr() {
		return this.resaltarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_usuarioPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_usuarioPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPresupuestoFlujoCajaTsr() {
		return this.mostrarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_usuarioPresupuestoFlujoCajaTsr(Boolean mostrarid_usuarioPresupuestoFlujoCajaTsr) {
		this.mostrarid_usuarioPresupuestoFlujoCajaTsr= mostrarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_usuarioPresupuestoFlujoCajaTsr() {
		return this.activarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_usuarioPresupuestoFlujoCajaTsr(Boolean activarid_usuarioPresupuestoFlujoCajaTsr) {
		this.activarid_usuarioPresupuestoFlujoCajaTsr= activarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_usuarioPresupuestoFlujoCajaTsr() {
		return this.cargarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_usuarioPresupuestoFlujoCajaTsr(Boolean cargarid_usuarioPresupuestoFlujoCajaTsr) {
		this.cargarid_usuarioPresupuestoFlujoCajaTsr= cargarid_usuarioPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_anioPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_anioPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPresupuestoFlujoCajaTsr() {
		return this.resaltarid_anioPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_anioPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_anioPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_anioPresupuestoFlujoCajaTsr() {
		return this.mostrarid_anioPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_anioPresupuestoFlujoCajaTsr(Boolean mostrarid_anioPresupuestoFlujoCajaTsr) {
		this.mostrarid_anioPresupuestoFlujoCajaTsr= mostrarid_anioPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_anioPresupuestoFlujoCajaTsr() {
		return this.activarid_anioPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_anioPresupuestoFlujoCajaTsr(Boolean activarid_anioPresupuestoFlujoCajaTsr) {
		this.activarid_anioPresupuestoFlujoCajaTsr= activarid_anioPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_anioPresupuestoFlujoCajaTsr() {
		return this.cargarid_anioPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_anioPresupuestoFlujoCajaTsr(Boolean cargarid_anioPresupuestoFlujoCajaTsr) {
		this.cargarid_anioPresupuestoFlujoCajaTsr= cargarid_anioPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_mesPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_mesPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPresupuestoFlujoCajaTsr() {
		return this.resaltarid_mesPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_mesPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_mesPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_mesPresupuestoFlujoCajaTsr() {
		return this.mostrarid_mesPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_mesPresupuestoFlujoCajaTsr(Boolean mostrarid_mesPresupuestoFlujoCajaTsr) {
		this.mostrarid_mesPresupuestoFlujoCajaTsr= mostrarid_mesPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_mesPresupuestoFlujoCajaTsr() {
		return this.activarid_mesPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_mesPresupuestoFlujoCajaTsr(Boolean activarid_mesPresupuestoFlujoCajaTsr) {
		this.activarid_mesPresupuestoFlujoCajaTsr= activarid_mesPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_mesPresupuestoFlujoCajaTsr() {
		return this.cargarid_mesPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_mesPresupuestoFlujoCajaTsr(Boolean cargarid_mesPresupuestoFlujoCajaTsr) {
		this.cargarid_mesPresupuestoFlujoCajaTsr= cargarid_mesPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_tipo_movimientoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoPresupuestoFlujoCajaTsr() {
		return this.resaltarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_tipo_movimientoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_tipo_movimientoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoPresupuestoFlujoCajaTsr() {
		return this.mostrarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_tipo_movimientoPresupuestoFlujoCajaTsr(Boolean mostrarid_tipo_movimientoPresupuestoFlujoCajaTsr) {
		this.mostrarid_tipo_movimientoPresupuestoFlujoCajaTsr= mostrarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_tipo_movimientoPresupuestoFlujoCajaTsr() {
		return this.activarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_tipo_movimientoPresupuestoFlujoCajaTsr(Boolean activarid_tipo_movimientoPresupuestoFlujoCajaTsr) {
		this.activarid_tipo_movimientoPresupuestoFlujoCajaTsr= activarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_tipo_movimientoPresupuestoFlujoCajaTsr() {
		return this.cargarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_tipo_movimientoPresupuestoFlujoCajaTsr(Boolean cargarid_tipo_movimientoPresupuestoFlujoCajaTsr) {
		this.cargarid_tipo_movimientoPresupuestoFlujoCajaTsr= cargarid_tipo_movimientoPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_centro_actividadPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_centro_actividadPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadPresupuestoFlujoCajaTsr() {
		return this.resaltarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_centro_actividadPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_centro_actividadPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadPresupuestoFlujoCajaTsr() {
		return this.mostrarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_centro_actividadPresupuestoFlujoCajaTsr(Boolean mostrarid_centro_actividadPresupuestoFlujoCajaTsr) {
		this.mostrarid_centro_actividadPresupuestoFlujoCajaTsr= mostrarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_centro_actividadPresupuestoFlujoCajaTsr() {
		return this.activarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_centro_actividadPresupuestoFlujoCajaTsr(Boolean activarid_centro_actividadPresupuestoFlujoCajaTsr) {
		this.activarid_centro_actividadPresupuestoFlujoCajaTsr= activarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_centro_actividadPresupuestoFlujoCajaTsr() {
		return this.cargarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_centro_actividadPresupuestoFlujoCajaTsr(Boolean cargarid_centro_actividadPresupuestoFlujoCajaTsr) {
		this.cargarid_centro_actividadPresupuestoFlujoCajaTsr= cargarid_centro_actividadPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarcodigoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarcodigoPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresupuestoFlujoCajaTsr() {
		return this.resaltarcodigoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarcodigoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarcodigoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarcodigoPresupuestoFlujoCajaTsr() {
		return this.mostrarcodigoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarcodigoPresupuestoFlujoCajaTsr(Boolean mostrarcodigoPresupuestoFlujoCajaTsr) {
		this.mostrarcodigoPresupuestoFlujoCajaTsr= mostrarcodigoPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarcodigoPresupuestoFlujoCajaTsr() {
		return this.activarcodigoPresupuestoFlujoCajaTsr;
	}

	public void setActivarcodigoPresupuestoFlujoCajaTsr(Boolean activarcodigoPresupuestoFlujoCajaTsr) {
		this.activarcodigoPresupuestoFlujoCajaTsr= activarcodigoPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarnombrePresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarnombrePresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresupuestoFlujoCajaTsr() {
		return this.resaltarnombrePresupuestoFlujoCajaTsr;
	}

	public void setResaltarnombrePresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarnombrePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarnombrePresupuestoFlujoCajaTsr() {
		return this.mostrarnombrePresupuestoFlujoCajaTsr;
	}

	public void setMostrarnombrePresupuestoFlujoCajaTsr(Boolean mostrarnombrePresupuestoFlujoCajaTsr) {
		this.mostrarnombrePresupuestoFlujoCajaTsr= mostrarnombrePresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarnombrePresupuestoFlujoCajaTsr() {
		return this.activarnombrePresupuestoFlujoCajaTsr;
	}

	public void setActivarnombrePresupuestoFlujoCajaTsr(Boolean activarnombrePresupuestoFlujoCajaTsr) {
		this.activarnombrePresupuestoFlujoCajaTsr= activarnombrePresupuestoFlujoCajaTsr;
	}

	public Border setResaltarfechaPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarfechaPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPresupuestoFlujoCajaTsr() {
		return this.resaltarfechaPresupuestoFlujoCajaTsr;
	}

	public void setResaltarfechaPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarfechaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarfechaPresupuestoFlujoCajaTsr() {
		return this.mostrarfechaPresupuestoFlujoCajaTsr;
	}

	public void setMostrarfechaPresupuestoFlujoCajaTsr(Boolean mostrarfechaPresupuestoFlujoCajaTsr) {
		this.mostrarfechaPresupuestoFlujoCajaTsr= mostrarfechaPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarfechaPresupuestoFlujoCajaTsr() {
		return this.activarfechaPresupuestoFlujoCajaTsr;
	}

	public void setActivarfechaPresupuestoFlujoCajaTsr(Boolean activarfechaPresupuestoFlujoCajaTsr) {
		this.activarfechaPresupuestoFlujoCajaTsr= activarfechaPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarfecha_presupuestoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarfecha_presupuestoPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_presupuestoPresupuestoFlujoCajaTsr() {
		return this.resaltarfecha_presupuestoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarfecha_presupuestoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarfecha_presupuestoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarfecha_presupuestoPresupuestoFlujoCajaTsr() {
		return this.mostrarfecha_presupuestoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarfecha_presupuestoPresupuestoFlujoCajaTsr(Boolean mostrarfecha_presupuestoPresupuestoFlujoCajaTsr) {
		this.mostrarfecha_presupuestoPresupuestoFlujoCajaTsr= mostrarfecha_presupuestoPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarfecha_presupuestoPresupuestoFlujoCajaTsr() {
		return this.activarfecha_presupuestoPresupuestoFlujoCajaTsr;
	}

	public void setActivarfecha_presupuestoPresupuestoFlujoCajaTsr(Boolean activarfecha_presupuestoPresupuestoFlujoCajaTsr) {
		this.activarfecha_presupuestoPresupuestoFlujoCajaTsr= activarfecha_presupuestoPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarvalorPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarvalorPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresupuestoFlujoCajaTsr() {
		return this.resaltarvalorPresupuestoFlujoCajaTsr;
	}

	public void setResaltarvalorPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarvalorPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarvalorPresupuestoFlujoCajaTsr() {
		return this.mostrarvalorPresupuestoFlujoCajaTsr;
	}

	public void setMostrarvalorPresupuestoFlujoCajaTsr(Boolean mostrarvalorPresupuestoFlujoCajaTsr) {
		this.mostrarvalorPresupuestoFlujoCajaTsr= mostrarvalorPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarvalorPresupuestoFlujoCajaTsr() {
		return this.activarvalorPresupuestoFlujoCajaTsr;
	}

	public void setActivarvalorPresupuestoFlujoCajaTsr(Boolean activarvalorPresupuestoFlujoCajaTsr) {
		this.activarvalorPresupuestoFlujoCajaTsr= activarvalorPresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_cuenta_contablePresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contablePresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contablePresupuestoFlujoCajaTsr() {
		return this.resaltarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_cuenta_contablePresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_cuenta_contablePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contablePresupuestoFlujoCajaTsr() {
		return this.mostrarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_cuenta_contablePresupuestoFlujoCajaTsr(Boolean mostrarid_cuenta_contablePresupuestoFlujoCajaTsr) {
		this.mostrarid_cuenta_contablePresupuestoFlujoCajaTsr= mostrarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_cuenta_contablePresupuestoFlujoCajaTsr() {
		return this.activarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public void setActivarid_cuenta_contablePresupuestoFlujoCajaTsr(Boolean activarid_cuenta_contablePresupuestoFlujoCajaTsr) {
		this.activarid_cuenta_contablePresupuestoFlujoCajaTsr= activarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_cuenta_contablePresupuestoFlujoCajaTsr() {
		return this.cargarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public void setCargarid_cuenta_contablePresupuestoFlujoCajaTsr(Boolean cargarid_cuenta_contablePresupuestoFlujoCajaTsr) {
		this.cargarid_cuenta_contablePresupuestoFlujoCajaTsr= cargarid_cuenta_contablePresupuestoFlujoCajaTsr;
	}

	public Border setResaltarid_centro_costoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPresupuestoFlujoCajaTsr() {
		return this.resaltarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarid_centro_costoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarid_centro_costoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPresupuestoFlujoCajaTsr() {
		return this.mostrarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarid_centro_costoPresupuestoFlujoCajaTsr(Boolean mostrarid_centro_costoPresupuestoFlujoCajaTsr) {
		this.mostrarid_centro_costoPresupuestoFlujoCajaTsr= mostrarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivarid_centro_costoPresupuestoFlujoCajaTsr() {
		return this.activarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public void setActivarid_centro_costoPresupuestoFlujoCajaTsr(Boolean activarid_centro_costoPresupuestoFlujoCajaTsr) {
		this.activarid_centro_costoPresupuestoFlujoCajaTsr= activarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public Boolean getCargarid_centro_costoPresupuestoFlujoCajaTsr() {
		return this.cargarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public void setCargarid_centro_costoPresupuestoFlujoCajaTsr(Boolean cargarid_centro_costoPresupuestoFlujoCajaTsr) {
		this.cargarid_centro_costoPresupuestoFlujoCajaTsr= cargarid_centro_costoPresupuestoFlujoCajaTsr;
	}

	public Border setResaltardescripcionPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajatsrBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCajaTsr.setBorder(borderResaltar);
		
		this.resaltardescripcionPresupuestoFlujoCajaTsr= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPresupuestoFlujoCajaTsr() {
		return this.resaltardescripcionPresupuestoFlujoCajaTsr;
	}

	public void setResaltardescripcionPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltardescripcionPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Boolean getMostrardescripcionPresupuestoFlujoCajaTsr() {
		return this.mostrardescripcionPresupuestoFlujoCajaTsr;
	}

	public void setMostrardescripcionPresupuestoFlujoCajaTsr(Boolean mostrardescripcionPresupuestoFlujoCajaTsr) {
		this.mostrardescripcionPresupuestoFlujoCajaTsr= mostrardescripcionPresupuestoFlujoCajaTsr;
	}

	public Boolean getActivardescripcionPresupuestoFlujoCajaTsr() {
		return this.activardescripcionPresupuestoFlujoCajaTsr;
	}

	public void setActivardescripcionPresupuestoFlujoCajaTsr(Boolean activardescripcionPresupuestoFlujoCajaTsr) {
		this.activardescripcionPresupuestoFlujoCajaTsr= activardescripcionPresupuestoFlujoCajaTsr;
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
		
		
		this.setMostraridPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_empresaPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_sucursalPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_ejercicioPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_periodoPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_usuarioPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_anioPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_mesPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_tipo_movimientoPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_centro_actividadPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarcodigoPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarnombrePresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarfechaPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarfecha_presupuestoPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarvalorPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_cuenta_contablePresupuestoFlujoCajaTsr(esInicial);
		this.setMostrarid_centro_costoPresupuestoFlujoCajaTsr(esInicial);
		this.setMostrardescripcionPresupuestoFlujoCajaTsr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.ID)) {
				this.setMostraridPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHA)) {
				this.setMostrarfechaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setMostrarfecha_presupuestoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contablePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPresupuestoFlujoCajaTsr(esAsigna);
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
		
		
		this.setActivaridPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_empresaPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_sucursalPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_ejercicioPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_periodoPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_usuarioPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_anioPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_mesPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_tipo_movimientoPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_centro_actividadPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarcodigoPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarnombrePresupuestoFlujoCajaTsr(esInicial);
		this.setActivarfechaPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarfecha_presupuestoPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarvalorPresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_cuenta_contablePresupuestoFlujoCajaTsr(esInicial);
		this.setActivarid_centro_costoPresupuestoFlujoCajaTsr(esInicial);
		this.setActivardescripcionPresupuestoFlujoCajaTsr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.ID)) {
				this.setActivaridPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDMES)) {
				this.setActivarid_mesPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHA)) {
				this.setActivarfechaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setActivarfecha_presupuestoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.VALOR)) {
				this.setActivarvalorPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contablePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_empresaPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_sucursalPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_ejercicioPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_periodoPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_usuarioPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_anioPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_mesPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_tipo_movimientoPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_centro_actividadPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarcodigoPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarnombrePresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarfechaPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarfecha_presupuestoPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarvalorPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_cuenta_contablePresupuestoFlujoCajaTsr(esInicial);
		this.setResaltarid_centro_costoPresupuestoFlujoCajaTsr(esInicial);
		this.setResaltardescripcionPresupuestoFlujoCajaTsr(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHA)) {
				this.setResaltarfechaPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setResaltarfecha_presupuestoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contablePresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPresupuestoFlujoCajaTsr(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPresupuestoFlujoCajaTsr(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarBusquedaPorCodigoPresupuestoFlujoCajaTsr() {
		return this.mostrarBusquedaPorCodigoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarBusquedaPorCodigoPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarBusquedaPorFechaPresupuestoFlujoCajaTsr() {
		return this.mostrarBusquedaPorFechaPresupuestoFlujoCajaTsr;
	}

	public void setMostrarBusquedaPorFechaPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr() {
		return this.mostrarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarBusquedaPorNombrePresupuestoFlujoCajaTsr() {
		return this.mostrarBusquedaPorNombrePresupuestoFlujoCajaTsr;
	}

	public void setMostrarBusquedaPorNombrePresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorValorPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarBusquedaPorValorPresupuestoFlujoCajaTsr() {
		return this.mostrarBusquedaPorValorPresupuestoFlujoCajaTsr;
	}

	public void setMostrarBusquedaPorValorPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorValorPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroActividadPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdCentroActividadPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdCentroActividadPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdCentroActividadPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroActividadPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdCentroCostoPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdCentroCostoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdCentroCostoPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdCuentaContablePresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdCuentaContablePresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdCuentaContablePresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdEjercicioPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdEjercicioPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdEmpresaPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdEmpresaPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdPeriodoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdPeriodoPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdSucursalPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdSucursalPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdSucursalPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr=true;

	public Boolean getMostrarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr() {
		return this.mostrarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr;
	}

	public void setMostrarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarBusquedaPorCodigoPresupuestoFlujoCajaTsr() {
		return this.activarBusquedaPorCodigoPresupuestoFlujoCajaTsr;
	}

	public void setActivarBusquedaPorCodigoPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarBusquedaPorFechaPresupuestoFlujoCajaTsr() {
		return this.activarBusquedaPorFechaPresupuestoFlujoCajaTsr;
	}

	public void setActivarBusquedaPorFechaPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr() {
		return this.activarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr;
	}

	public void setActivarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePresupuestoFlujoCajaTsr=true;

	public Boolean getActivarBusquedaPorNombrePresupuestoFlujoCajaTsr() {
		return this.activarBusquedaPorNombrePresupuestoFlujoCajaTsr;
	}

	public void setActivarBusquedaPorNombrePresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarBusquedaPorValorPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarBusquedaPorValorPresupuestoFlujoCajaTsr() {
		return this.activarBusquedaPorValorPresupuestoFlujoCajaTsr;
	}

	public void setActivarBusquedaPorValorPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarBusquedaPorValorPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroActividadPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdCentroActividadPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdCentroActividadPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdCentroActividadPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdCentroActividadPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdCentroCostoPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdCentroCostoPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdCentroCostoPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdCuentaContablePresupuestoFlujoCajaTsr() {
		return this.activarFK_IdCuentaContablePresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdCuentaContablePresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdEjercicioPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdEjercicioPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdEmpresaPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdEmpresaPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdPeriodoPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdPeriodoPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdSucursalPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdSucursalPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdSucursalPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresupuestoFlujoCajaTsr= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr=true;

	public Boolean getActivarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr() {
		return this.activarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr;
	}

	public void setActivarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr=null;

	public Border getResaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr() {
		return this.resaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaPresupuestoFlujoCajaTsr=null;

	public Border getResaltarBusquedaPorFechaPresupuestoFlujoCajaTsr() {
		return this.resaltarBusquedaPorFechaPresupuestoFlujoCajaTsr;
	}

	public void setResaltarBusquedaPorFechaPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarBusquedaPorFechaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr=null;

	public Border getResaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr() {
		return this.resaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaPresupuestoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePresupuestoFlujoCajaTsr=null;

	public Border getResaltarBusquedaPorNombrePresupuestoFlujoCajaTsr() {
		return this.resaltarBusquedaPorNombrePresupuestoFlujoCajaTsr;
	}

	public void setResaltarBusquedaPorNombrePresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarBusquedaPorValorPresupuestoFlujoCajaTsr=null;

	public Border getResaltarBusquedaPorValorPresupuestoFlujoCajaTsr() {
		return this.resaltarBusquedaPorValorPresupuestoFlujoCajaTsr;
	}

	public void setResaltarBusquedaPorValorPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarBusquedaPorValorPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarBusquedaPorValorPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorValorPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroActividadPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdEjercicioPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdEjercicioPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdEjercicioPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdEmpresaPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdEmpresaPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdEmpresaPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdPeriodoPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdPeriodoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdPeriodoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdSucursalPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdSucursalPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdSucursalPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr=null;

	public Border getResaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr() {
		return this.resaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr;
	}

	public void setResaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaTsrBeanSwingJInternalFrame presupuestoflujocajatsrBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoPresupuestoFlujoCajaTsr= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}