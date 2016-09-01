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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.CentroActividadConstantesFunciones;
import com.bydan.erp.contabilidad.util.CentroActividadParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CentroActividadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CentroActividadConstantesFunciones extends CentroActividadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CentroActividad";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CentroActividad"+CentroActividadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CentroActividadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CentroActividadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CentroActividadConstantesFunciones.SCHEMA+"_"+CentroActividadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CentroActividadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CentroActividadConstantesFunciones.SCHEMA+"_"+CentroActividadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CentroActividadConstantesFunciones.SCHEMA+"_"+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CentroActividadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CentroActividadConstantesFunciones.SCHEMA+"_"+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroActividadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroActividadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroActividadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CentroActividadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CentroActividadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CentroActividadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CentroActividadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Centro Actividades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Centro Actividad";
	public static final String SCLASSWEBTITULO_LOWER="Centro Actividad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CentroActividad";
	public static final String OBJECTNAME="centroactividad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="centro_actividad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select centroactividad from "+CentroActividadConstantesFunciones.SPERSISTENCENAME+" centroactividad";
	public static String QUERYSELECTNATIVE="select "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".version_row,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_empresa,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".codigo,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".nombre,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_tipo_grupo_flujo_caja,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".consolidado,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".con_proyecto,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".observacion from "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME;//+" as "+CentroActividadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CentroActividadConstantesFuncionesAdditional centroactividadConstantesFuncionesAdditional=null;
	
	public CentroActividadConstantesFuncionesAdditional getCentroActividadConstantesFuncionesAdditional() {
		return this.centroactividadConstantesFuncionesAdditional;
	}
	
	public void setCentroActividadConstantesFuncionesAdditional(CentroActividadConstantesFuncionesAdditional centroactividadConstantesFuncionesAdditional) {
		try {
			this.centroactividadConstantesFuncionesAdditional=centroactividadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPOGRUPOFLUJOCAJA= "id_tipo_grupo_flujo_caja";
    public static final String CONSOLIDADO= "consolidado";
    public static final String CONPROYECTO= "con_proyecto";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPOGRUPOFLUJOCAJA= "Tipo Grupo Flujo Caja";
		public static final String LABEL_IDTIPOGRUPOFLUJOCAJA_LOWER= "Tipo Grupo Flujo Caja";
    	public static final String LABEL_CONSOLIDADO= "Consolidado";
		public static final String LABEL_CONSOLIDADO_LOWER= "Consolidado";
    	public static final String LABEL_CONPROYECTO= "Con Proyecto";
		public static final String LABEL_CONPROYECTO_LOWER= "Con Proyecto";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCentroActividadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.IDEMPRESA)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.CODIGO)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.NOMBRE)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.CONSOLIDADO)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_CONSOLIDADO;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.CONPROYECTO)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_CONPROYECTO;}
		if(sNombreColumna.equals(CentroActividadConstantesFunciones.OBSERVACION)) {sLabelColumna=CentroActividadConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getconsolidadoDescripcion(CentroActividad centroactividad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!centroactividad.getconsolidado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getconsolidadoHtmlDescripcion(CentroActividad centroactividad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(centroactividad.getId(),centroactividad.getconsolidado());

		return sDescripcion;
	}	
		
	public static String getcon_proyectoDescripcion(CentroActividad centroactividad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!centroactividad.getcon_proyecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_proyectoHtmlDescripcion(CentroActividad centroactividad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(centroactividad.getId(),centroactividad.getcon_proyecto());

		return sDescripcion;
	}	
			
	
	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(centroactividad !=null/* && centroactividad.getId()!=0*/) {
			sDescripcion=centroactividad.getnombre();//centroactividadcentroactividad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCentroActividadDescripcionDetallado(CentroActividad centroactividad) {
		String sDescripcion="";
			
		sDescripcion+=CentroActividadConstantesFunciones.ID+"=";
		sDescripcion+=centroactividad.getId().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=centroactividad.getVersionRow().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=centroactividad.getid_empresa().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.CODIGO+"=";
		sDescripcion+=centroactividad.getcodigo()+",";
		sDescripcion+=CentroActividadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=centroactividad.getnombre()+",";
		sDescripcion+=CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=centroactividad.getid_tipo_movimiento().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA+"=";
		sDescripcion+=centroactividad.getid_tipo_grupo_flujo_caja().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.CONSOLIDADO+"=";
		sDescripcion+=centroactividad.getconsolidado().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.CONPROYECTO+"=";
		sDescripcion+=centroactividad.getcon_proyecto().toString()+",";
		sDescripcion+=CentroActividadConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=centroactividad.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setCentroActividadDescripcion(CentroActividad centroactividad,String sValor) throws Exception {			
		if(centroactividad !=null) {
			centroactividad.setnombre(sValor);;//centroactividadcentroactividad.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTipoGrupoFlujoCajaDescripcion(TipoGrupoFlujoCaja tipogrupoflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogrupoflujocaja!=null/*&&tipogrupoflujocaja.getId()>0*/) {
			sDescripcion=TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(tipogrupoflujocaja);
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFlujoCaja")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Flujo Caja";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
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

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFlujoCaja(Long id_tipo_grupo_flujo_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_flujo_caja!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Flujo Caja="+id_tipo_grupo_flujo_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCentroActividad(CentroActividad centroactividad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		centroactividad.setcodigo(centroactividad.getcodigo().trim());
		centroactividad.setnombre(centroactividad.getnombre().trim());
		centroactividad.setobservacion(centroactividad.getobservacion().trim());
	}
	
	public static void quitarEspaciosCentroActividads(List<CentroActividad> centroactividads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroActividad centroactividad: centroactividads) {
			centroactividad.setcodigo(centroactividad.getcodigo().trim());
			centroactividad.setnombre(centroactividad.getnombre().trim());
			centroactividad.setobservacion(centroactividad.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroActividad(CentroActividad centroactividad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && centroactividad.getConCambioAuxiliar()) {
			centroactividad.setIsDeleted(centroactividad.getIsDeletedAuxiliar());	
			centroactividad.setIsNew(centroactividad.getIsNewAuxiliar());	
			centroactividad.setIsChanged(centroactividad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			centroactividad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			centroactividad.setIsDeletedAuxiliar(false);	
			centroactividad.setIsNewAuxiliar(false);	
			centroactividad.setIsChangedAuxiliar(false);
			
			centroactividad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroActividads(List<CentroActividad> centroactividads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CentroActividad centroactividad : centroactividads) {
			if(conAsignarBase && centroactividad.getConCambioAuxiliar()) {
				centroactividad.setIsDeleted(centroactividad.getIsDeletedAuxiliar());	
				centroactividad.setIsNew(centroactividad.getIsNewAuxiliar());	
				centroactividad.setIsChanged(centroactividad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				centroactividad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				centroactividad.setIsDeletedAuxiliar(false);	
				centroactividad.setIsNewAuxiliar(false);	
				centroactividad.setIsChangedAuxiliar(false);
				
				centroactividad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCentroActividad(CentroActividad centroactividad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCentroActividads(List<CentroActividad> centroactividads,Boolean conEnteros) throws Exception  {
		
		for(CentroActividad centroactividad: centroactividads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCentroActividad(List<CentroActividad> centroactividads,CentroActividad centroactividadAux) throws Exception  {
		CentroActividadConstantesFunciones.InicializarValoresCentroActividad(centroactividadAux,true);
		
		for(CentroActividad centroactividad: centroactividads) {
			if(centroactividad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroActividad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CentroActividadConstantesFunciones.getArrayColumnasGlobalesCentroActividad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroActividad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroActividadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroActividadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCentroActividad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroActividad> centroactividads,CentroActividad centroactividad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroActividad centroactividadAux: centroactividads) {
			if(centroactividadAux!=null && centroactividad!=null) {
				if((centroactividadAux.getId()==null && centroactividad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(centroactividadAux.getId()!=null && centroactividad.getId()!=null){
					if(centroactividadAux.getId().equals(centroactividad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroActividad(List<CentroActividad> centroactividads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CentroActividad centroactividad: centroactividads) {			
			if(centroactividad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCentroActividad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_ID, CentroActividadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_VERSIONROW, CentroActividadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_IDEMPRESA, CentroActividadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_CODIGO, CentroActividadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_NOMBRE, CentroActividadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA, CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_CONSOLIDADO, CentroActividadConstantesFunciones.CONSOLIDADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_CONPROYECTO, CentroActividadConstantesFunciones.CONPROYECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroActividadConstantesFunciones.LABEL_OBSERVACION, CentroActividadConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCentroActividad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.CONSOLIDADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.CONPROYECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroActividadConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroActividad() throws Exception  {
		return CentroActividadConstantesFunciones.getTiposSeleccionarCentroActividad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroActividad(Boolean conFk) throws Exception  {
		return CentroActividadConstantesFunciones.getTiposSeleccionarCentroActividad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroActividad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_CONSOLIDADO);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_CONSOLIDADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_CONPROYECTO);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_CONPROYECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroActividadConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(CentroActividadConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCentroActividad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCentroActividad(CentroActividad centroactividadAux) throws Exception {
		
			centroactividadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centroactividadAux.getEmpresa()));
			centroactividadAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(centroactividadAux.getTipoMovimiento()));
			centroactividadAux.settipogrupoflujocaja_descripcion(TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(centroactividadAux.getTipoGrupoFlujoCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCentroActividad(List<CentroActividad> centroactividadsTemp) throws Exception {
		for(CentroActividad centroactividadAux:centroactividadsTemp) {
			
			centroactividadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centroactividadAux.getEmpresa()));
			centroactividadAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(centroactividadAux.getTipoMovimiento()));
			centroactividadAux.settipogrupoflujocaja_descripcion(TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(centroactividadAux.getTipoGrupoFlujoCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCentroActividad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoGrupoFlujoCaja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCentroActividad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoGrupoFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoGrupoFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroActividad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroActividadConstantesFunciones.getClassesRelationshipsOfCentroActividad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroActividad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PagoAuto.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(DetalleAsientoContable.class));
				classes.add(new Classe(AutoriPago.class));
				classes.add(new Classe(PresupuestoFlujoCajaTsr.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PagoAuto.class)) {
						classes.add(new Classe(PagoAuto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAsientoContable.class)) {
						classes.add(new Classe(DetalleAsientoContable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPago.class)) {
						classes.add(new Classe(AutoriPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoFlujoCajaTsr.class)) {
						classes.add(new Classe(PresupuestoFlujoCajaTsr.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroActividad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroActividadConstantesFunciones.getClassesRelationshipsFromStringsOfCentroActividad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroActividad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(DetalleAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContable.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}

					if(PresupuestoFlujoCajaTsr.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoFlujoCajaTsr.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(DetalleAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContable.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}

					if(PresupuestoFlujoCajaTsr.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoFlujoCajaTsr.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(CentroActividad centroactividad,List<CentroActividad> centroactividads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CentroActividad centroactividadEncontrado=null;
			
			for(CentroActividad centroactividadLocal:centroactividads) {
				if(centroactividadLocal.getId().equals(centroactividad.getId())) {
					centroactividadEncontrado=centroactividadLocal;
					
					centroactividadLocal.setIsChanged(centroactividad.getIsChanged());
					centroactividadLocal.setIsNew(centroactividad.getIsNew());
					centroactividadLocal.setIsDeleted(centroactividad.getIsDeleted());
					
					centroactividadLocal.setGeneralEntityOriginal(centroactividad.getGeneralEntityOriginal());
					
					centroactividadLocal.setId(centroactividad.getId());	
					centroactividadLocal.setVersionRow(centroactividad.getVersionRow());	
					centroactividadLocal.setid_empresa(centroactividad.getid_empresa());	
					centroactividadLocal.setcodigo(centroactividad.getcodigo());	
					centroactividadLocal.setnombre(centroactividad.getnombre());	
					centroactividadLocal.setid_tipo_movimiento(centroactividad.getid_tipo_movimiento());	
					centroactividadLocal.setid_tipo_grupo_flujo_caja(centroactividad.getid_tipo_grupo_flujo_caja());	
					centroactividadLocal.setconsolidado(centroactividad.getconsolidado());	
					centroactividadLocal.setcon_proyecto(centroactividad.getcon_proyecto());	
					centroactividadLocal.setobservacion(centroactividad.getobservacion());	
					
					
					centroactividadLocal.setPagoAutos(centroactividad.getPagoAutos());
					centroactividadLocal.setClientes(centroactividad.getClientes());
					centroactividadLocal.setAutoriPagos(centroactividad.getAutoriPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!centroactividad.getIsDeleted()) {
				if(!existe) {
					centroactividads.add(centroactividad);
				}
			} else {
				if(centroactividadEncontrado!=null && permiteQuitar)  {
					centroactividads.remove(centroactividadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CentroActividad centroactividad,List<CentroActividad> centroactividads) throws Exception {
		try	{			
			for(CentroActividad centroactividadLocal:centroactividads) {
				if(centroactividadLocal.getId().equals(centroactividad.getId())) {
					centroactividadLocal.setIsSelected(centroactividad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCentroActividad(List<CentroActividad> centroactividadsAux) throws Exception {
		//this.centroactividadsAux=centroactividadsAux;
		
		for(CentroActividad centroactividadAux:centroactividadsAux) {
			if(centroactividadAux.getIsChanged()) {
				centroactividadAux.setIsChanged(false);
			}		
			
			if(centroactividadAux.getIsNew()) {
				centroactividadAux.setIsNew(false);
			}	
			
			if(centroactividadAux.getIsDeleted()) {
				centroactividadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCentroActividad(CentroActividad centroactividadAux) throws Exception {
		//this.centroactividadAux=centroactividadAux;
		
			if(centroactividadAux.getIsChanged()) {
				centroactividadAux.setIsChanged(false);
			}		
			
			if(centroactividadAux.getIsNew()) {
				centroactividadAux.setIsNew(false);
			}	
			
			if(centroactividadAux.getIsDeleted()) {
				centroactividadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CentroActividad centroactividadAsignar,CentroActividad centroactividad) throws Exception {
		centroactividadAsignar.setId(centroactividad.getId());	
		centroactividadAsignar.setVersionRow(centroactividad.getVersionRow());	
		centroactividadAsignar.setid_empresa(centroactividad.getid_empresa());
		centroactividadAsignar.setempresa_descripcion(centroactividad.getempresa_descripcion());	
		centroactividadAsignar.setcodigo(centroactividad.getcodigo());	
		centroactividadAsignar.setnombre(centroactividad.getnombre());	
		centroactividadAsignar.setid_tipo_movimiento(centroactividad.getid_tipo_movimiento());
		centroactividadAsignar.settipomovimiento_descripcion(centroactividad.gettipomovimiento_descripcion());	
		centroactividadAsignar.setid_tipo_grupo_flujo_caja(centroactividad.getid_tipo_grupo_flujo_caja());
		centroactividadAsignar.settipogrupoflujocaja_descripcion(centroactividad.gettipogrupoflujocaja_descripcion());	
		centroactividadAsignar.setconsolidado(centroactividad.getconsolidado());	
		centroactividadAsignar.setcon_proyecto(centroactividad.getcon_proyecto());	
		centroactividadAsignar.setobservacion(centroactividad.getobservacion());	
	}
	
	public static void inicializarCentroActividad(CentroActividad centroactividad) throws Exception {
		try {
				centroactividad.setId(0L);	
					
				centroactividad.setid_empresa(-1L);	
				centroactividad.setcodigo("");	
				centroactividad.setnombre("");	
				centroactividad.setid_tipo_movimiento(-1L);	
				centroactividad.setid_tipo_grupo_flujo_caja(-1L);	
				centroactividad.setconsolidado(false);	
				centroactividad.setcon_proyecto(false);	
				centroactividad.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCentroActividad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_CONSOLIDADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_CONPROYECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroActividadConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCentroActividad(String sTipo,Row row,Workbook workbook,CentroActividad centroactividad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.gettipogrupoflujocaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(centroactividad.getconsolidado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(centroactividad.getcon_proyecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centroactividad.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCentroActividad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCentroActividad() {
		return this.sFinalQueryCentroActividad;
	}
	
	public void setsFinalQueryCentroActividad(String sFinalQueryCentroActividad) {
		this.sFinalQueryCentroActividad= sFinalQueryCentroActividad;
	}
	
	public Border resaltarSeleccionarCentroActividad=null;
	
	public Border setResaltarSeleccionarCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCentroActividad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCentroActividad() {
		return this.resaltarSeleccionarCentroActividad;
	}
	
	public void setResaltarSeleccionarCentroActividad(Border borderResaltarSeleccionarCentroActividad) {
		this.resaltarSeleccionarCentroActividad= borderResaltarSeleccionarCentroActividad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCentroActividad=null;
	public Boolean mostraridCentroActividad=true;
	public Boolean activaridCentroActividad=true;

	public Border resaltarid_empresaCentroActividad=null;
	public Boolean mostrarid_empresaCentroActividad=true;
	public Boolean activarid_empresaCentroActividad=true;
	public Boolean cargarid_empresaCentroActividad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCentroActividad=false;//ConEventDepend=true

	public Border resaltarcodigoCentroActividad=null;
	public Boolean mostrarcodigoCentroActividad=true;
	public Boolean activarcodigoCentroActividad=true;

	public Border resaltarnombreCentroActividad=null;
	public Boolean mostrarnombreCentroActividad=true;
	public Boolean activarnombreCentroActividad=true;

	public Border resaltarid_tipo_movimientoCentroActividad=null;
	public Boolean mostrarid_tipo_movimientoCentroActividad=true;
	public Boolean activarid_tipo_movimientoCentroActividad=true;
	public Boolean cargarid_tipo_movimientoCentroActividad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoCentroActividad=false;//ConEventDepend=true

	public Border resaltarid_tipo_grupo_flujo_cajaCentroActividad=null;
	public Boolean mostrarid_tipo_grupo_flujo_cajaCentroActividad=true;
	public Boolean activarid_tipo_grupo_flujo_cajaCentroActividad=true;
	public Boolean cargarid_tipo_grupo_flujo_cajaCentroActividad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_flujo_cajaCentroActividad=false;//ConEventDepend=true

	public Border resaltarconsolidadoCentroActividad=null;
	public Boolean mostrarconsolidadoCentroActividad=true;
	public Boolean activarconsolidadoCentroActividad=true;

	public Border resaltarcon_proyectoCentroActividad=null;
	public Boolean mostrarcon_proyectoCentroActividad=true;
	public Boolean activarcon_proyectoCentroActividad=true;

	public Border resaltarobservacionCentroActividad=null;
	public Boolean mostrarobservacionCentroActividad=true;
	public Boolean activarobservacionCentroActividad=true;

	
	

	public Border setResaltaridCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltaridCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCentroActividad() {
		return this.resaltaridCentroActividad;
	}

	public void setResaltaridCentroActividad(Border borderResaltar) {
		this.resaltaridCentroActividad= borderResaltar;
	}

	public Boolean getMostraridCentroActividad() {
		return this.mostraridCentroActividad;
	}

	public void setMostraridCentroActividad(Boolean mostraridCentroActividad) {
		this.mostraridCentroActividad= mostraridCentroActividad;
	}

	public Boolean getActivaridCentroActividad() {
		return this.activaridCentroActividad;
	}

	public void setActivaridCentroActividad(Boolean activaridCentroActividad) {
		this.activaridCentroActividad= activaridCentroActividad;
	}

	public Border setResaltarid_empresaCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarid_empresaCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCentroActividad() {
		return this.resaltarid_empresaCentroActividad;
	}

	public void setResaltarid_empresaCentroActividad(Border borderResaltar) {
		this.resaltarid_empresaCentroActividad= borderResaltar;
	}

	public Boolean getMostrarid_empresaCentroActividad() {
		return this.mostrarid_empresaCentroActividad;
	}

	public void setMostrarid_empresaCentroActividad(Boolean mostrarid_empresaCentroActividad) {
		this.mostrarid_empresaCentroActividad= mostrarid_empresaCentroActividad;
	}

	public Boolean getActivarid_empresaCentroActividad() {
		return this.activarid_empresaCentroActividad;
	}

	public void setActivarid_empresaCentroActividad(Boolean activarid_empresaCentroActividad) {
		this.activarid_empresaCentroActividad= activarid_empresaCentroActividad;
	}

	public Boolean getCargarid_empresaCentroActividad() {
		return this.cargarid_empresaCentroActividad;
	}

	public void setCargarid_empresaCentroActividad(Boolean cargarid_empresaCentroActividad) {
		this.cargarid_empresaCentroActividad= cargarid_empresaCentroActividad;
	}

	public Border setResaltarcodigoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarcodigoCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCentroActividad() {
		return this.resaltarcodigoCentroActividad;
	}

	public void setResaltarcodigoCentroActividad(Border borderResaltar) {
		this.resaltarcodigoCentroActividad= borderResaltar;
	}

	public Boolean getMostrarcodigoCentroActividad() {
		return this.mostrarcodigoCentroActividad;
	}

	public void setMostrarcodigoCentroActividad(Boolean mostrarcodigoCentroActividad) {
		this.mostrarcodigoCentroActividad= mostrarcodigoCentroActividad;
	}

	public Boolean getActivarcodigoCentroActividad() {
		return this.activarcodigoCentroActividad;
	}

	public void setActivarcodigoCentroActividad(Boolean activarcodigoCentroActividad) {
		this.activarcodigoCentroActividad= activarcodigoCentroActividad;
	}

	public Border setResaltarnombreCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarnombreCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCentroActividad() {
		return this.resaltarnombreCentroActividad;
	}

	public void setResaltarnombreCentroActividad(Border borderResaltar) {
		this.resaltarnombreCentroActividad= borderResaltar;
	}

	public Boolean getMostrarnombreCentroActividad() {
		return this.mostrarnombreCentroActividad;
	}

	public void setMostrarnombreCentroActividad(Boolean mostrarnombreCentroActividad) {
		this.mostrarnombreCentroActividad= mostrarnombreCentroActividad;
	}

	public Boolean getActivarnombreCentroActividad() {
		return this.activarnombreCentroActividad;
	}

	public void setActivarnombreCentroActividad(Boolean activarnombreCentroActividad) {
		this.activarnombreCentroActividad= activarnombreCentroActividad;
	}

	public Border setResaltarid_tipo_movimientoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoCentroActividad() {
		return this.resaltarid_tipo_movimientoCentroActividad;
	}

	public void setResaltarid_tipo_movimientoCentroActividad(Border borderResaltar) {
		this.resaltarid_tipo_movimientoCentroActividad= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoCentroActividad() {
		return this.mostrarid_tipo_movimientoCentroActividad;
	}

	public void setMostrarid_tipo_movimientoCentroActividad(Boolean mostrarid_tipo_movimientoCentroActividad) {
		this.mostrarid_tipo_movimientoCentroActividad= mostrarid_tipo_movimientoCentroActividad;
	}

	public Boolean getActivarid_tipo_movimientoCentroActividad() {
		return this.activarid_tipo_movimientoCentroActividad;
	}

	public void setActivarid_tipo_movimientoCentroActividad(Boolean activarid_tipo_movimientoCentroActividad) {
		this.activarid_tipo_movimientoCentroActividad= activarid_tipo_movimientoCentroActividad;
	}

	public Boolean getCargarid_tipo_movimientoCentroActividad() {
		return this.cargarid_tipo_movimientoCentroActividad;
	}

	public void setCargarid_tipo_movimientoCentroActividad(Boolean cargarid_tipo_movimientoCentroActividad) {
		this.cargarid_tipo_movimientoCentroActividad= cargarid_tipo_movimientoCentroActividad;
	}

	public Border setResaltarid_tipo_grupo_flujo_cajaCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_flujo_cajaCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_flujo_cajaCentroActividad() {
		return this.resaltarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public void setResaltarid_tipo_grupo_flujo_cajaCentroActividad(Border borderResaltar) {
		this.resaltarid_tipo_grupo_flujo_cajaCentroActividad= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_flujo_cajaCentroActividad() {
		return this.mostrarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public void setMostrarid_tipo_grupo_flujo_cajaCentroActividad(Boolean mostrarid_tipo_grupo_flujo_cajaCentroActividad) {
		this.mostrarid_tipo_grupo_flujo_cajaCentroActividad= mostrarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public Boolean getActivarid_tipo_grupo_flujo_cajaCentroActividad() {
		return this.activarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public void setActivarid_tipo_grupo_flujo_cajaCentroActividad(Boolean activarid_tipo_grupo_flujo_cajaCentroActividad) {
		this.activarid_tipo_grupo_flujo_cajaCentroActividad= activarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public Boolean getCargarid_tipo_grupo_flujo_cajaCentroActividad() {
		return this.cargarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public void setCargarid_tipo_grupo_flujo_cajaCentroActividad(Boolean cargarid_tipo_grupo_flujo_cajaCentroActividad) {
		this.cargarid_tipo_grupo_flujo_cajaCentroActividad= cargarid_tipo_grupo_flujo_cajaCentroActividad;
	}

	public Border setResaltarconsolidadoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarconsolidadoCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconsolidadoCentroActividad() {
		return this.resaltarconsolidadoCentroActividad;
	}

	public void setResaltarconsolidadoCentroActividad(Border borderResaltar) {
		this.resaltarconsolidadoCentroActividad= borderResaltar;
	}

	public Boolean getMostrarconsolidadoCentroActividad() {
		return this.mostrarconsolidadoCentroActividad;
	}

	public void setMostrarconsolidadoCentroActividad(Boolean mostrarconsolidadoCentroActividad) {
		this.mostrarconsolidadoCentroActividad= mostrarconsolidadoCentroActividad;
	}

	public Boolean getActivarconsolidadoCentroActividad() {
		return this.activarconsolidadoCentroActividad;
	}

	public void setActivarconsolidadoCentroActividad(Boolean activarconsolidadoCentroActividad) {
		this.activarconsolidadoCentroActividad= activarconsolidadoCentroActividad;
	}

	public Border setResaltarcon_proyectoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarcon_proyectoCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_proyectoCentroActividad() {
		return this.resaltarcon_proyectoCentroActividad;
	}

	public void setResaltarcon_proyectoCentroActividad(Border borderResaltar) {
		this.resaltarcon_proyectoCentroActividad= borderResaltar;
	}

	public Boolean getMostrarcon_proyectoCentroActividad() {
		return this.mostrarcon_proyectoCentroActividad;
	}

	public void setMostrarcon_proyectoCentroActividad(Boolean mostrarcon_proyectoCentroActividad) {
		this.mostrarcon_proyectoCentroActividad= mostrarcon_proyectoCentroActividad;
	}

	public Boolean getActivarcon_proyectoCentroActividad() {
		return this.activarcon_proyectoCentroActividad;
	}

	public void setActivarcon_proyectoCentroActividad(Boolean activarcon_proyectoCentroActividad) {
		this.activarcon_proyectoCentroActividad= activarcon_proyectoCentroActividad;
	}

	public Border setResaltarobservacionCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltar);
		
		this.resaltarobservacionCentroActividad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionCentroActividad() {
		return this.resaltarobservacionCentroActividad;
	}

	public void setResaltarobservacionCentroActividad(Border borderResaltar) {
		this.resaltarobservacionCentroActividad= borderResaltar;
	}

	public Boolean getMostrarobservacionCentroActividad() {
		return this.mostrarobservacionCentroActividad;
	}

	public void setMostrarobservacionCentroActividad(Boolean mostrarobservacionCentroActividad) {
		this.mostrarobservacionCentroActividad= mostrarobservacionCentroActividad;
	}

	public Boolean getActivarobservacionCentroActividad() {
		return this.activarobservacionCentroActividad;
	}

	public void setActivarobservacionCentroActividad(Boolean activarobservacionCentroActividad) {
		this.activarobservacionCentroActividad= activarobservacionCentroActividad;
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
		
		
		this.setMostraridCentroActividad(esInicial);
		this.setMostrarid_empresaCentroActividad(esInicial);
		this.setMostrarcodigoCentroActividad(esInicial);
		this.setMostrarnombreCentroActividad(esInicial);
		this.setMostrarid_tipo_movimientoCentroActividad(esInicial);
		this.setMostrarid_tipo_grupo_flujo_cajaCentroActividad(esInicial);
		this.setMostrarconsolidadoCentroActividad(esInicial);
		this.setMostrarcon_proyectoCentroActividad(esInicial);
		this.setMostrarobservacionCentroActividad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroActividadConstantesFunciones.ID)) {
				this.setMostraridCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setMostrarid_tipo_grupo_flujo_cajaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONSOLIDADO)) {
				this.setMostrarconsolidadoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONPROYECTO)) {
				this.setMostrarcon_proyectoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionCentroActividad(esAsigna);
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
		
		
		this.setActivaridCentroActividad(esInicial);
		this.setActivarid_empresaCentroActividad(esInicial);
		this.setActivarcodigoCentroActividad(esInicial);
		this.setActivarnombreCentroActividad(esInicial);
		this.setActivarid_tipo_movimientoCentroActividad(esInicial);
		this.setActivarid_tipo_grupo_flujo_cajaCentroActividad(esInicial);
		this.setActivarconsolidadoCentroActividad(esInicial);
		this.setActivarcon_proyectoCentroActividad(esInicial);
		this.setActivarobservacionCentroActividad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroActividadConstantesFunciones.ID)) {
				this.setActivaridCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setActivarid_tipo_grupo_flujo_cajaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONSOLIDADO)) {
				this.setActivarconsolidadoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONPROYECTO)) {
				this.setActivarcon_proyectoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionCentroActividad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCentroActividad(esInicial);
		this.setResaltarid_empresaCentroActividad(esInicial);
		this.setResaltarcodigoCentroActividad(esInicial);
		this.setResaltarnombreCentroActividad(esInicial);
		this.setResaltarid_tipo_movimientoCentroActividad(esInicial);
		this.setResaltarid_tipo_grupo_flujo_cajaCentroActividad(esInicial);
		this.setResaltarconsolidadoCentroActividad(esInicial);
		this.setResaltarcon_proyectoCentroActividad(esInicial);
		this.setResaltarobservacionCentroActividad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroActividadConstantesFunciones.ID)) {
				this.setResaltaridCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setResaltarid_tipo_grupo_flujo_cajaCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONSOLIDADO)) {
				this.setResaltarconsolidadoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.CONPROYECTO)) {
				this.setResaltarcon_proyectoCentroActividad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroActividadConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionCentroActividad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPagoAutoCentroActividad=null;

	public Border getResaltarPagoAutoCentroActividad() {
		return this.resaltarPagoAutoCentroActividad;
	}

	public void setResaltarPagoAutoCentroActividad(Border borderResaltarPagoAuto) {
		if(borderResaltarPagoAuto!=null) {
			this.resaltarPagoAutoCentroActividad= borderResaltarPagoAuto;
		}
	}

	public Border setResaltarPagoAutoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltarPagoAuto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltarPagoAuto);
			
		this.resaltarPagoAutoCentroActividad= borderResaltarPagoAuto;

		 return borderResaltarPagoAuto;
	}



	public Boolean mostrarPagoAutoCentroActividad=true;

	public Boolean getMostrarPagoAutoCentroActividad() {
		return this.mostrarPagoAutoCentroActividad;
	}

	public void setMostrarPagoAutoCentroActividad(Boolean visibilidadResaltarPagoAuto) {
		this.mostrarPagoAutoCentroActividad= visibilidadResaltarPagoAuto;
	}



	public Boolean activarPagoAutoCentroActividad=true;

	public Boolean gethabilitarResaltarPagoAutoCentroActividad() {
		return this.activarPagoAutoCentroActividad;
	}

	public void setActivarPagoAutoCentroActividad(Boolean habilitarResaltarPagoAuto) {
		this.activarPagoAutoCentroActividad= habilitarResaltarPagoAuto;
	}


	public Border resaltarClienteCentroActividad=null;

	public Border getResaltarClienteCentroActividad() {
		return this.resaltarClienteCentroActividad;
	}

	public void setResaltarClienteCentroActividad(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteCentroActividad= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltarCliente);
			
		this.resaltarClienteCentroActividad= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteCentroActividad=true;

	public Boolean getMostrarClienteCentroActividad() {
		return this.mostrarClienteCentroActividad;
	}

	public void setMostrarClienteCentroActividad(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteCentroActividad= visibilidadResaltarCliente;
	}



	public Boolean activarClienteCentroActividad=true;

	public Boolean gethabilitarResaltarClienteCentroActividad() {
		return this.activarClienteCentroActividad;
	}

	public void setActivarClienteCentroActividad(Boolean habilitarResaltarCliente) {
		this.activarClienteCentroActividad= habilitarResaltarCliente;
	}


	public Border resaltarAutoriPagoCentroActividad=null;

	public Border getResaltarAutoriPagoCentroActividad() {
		return this.resaltarAutoriPagoCentroActividad;
	}

	public void setResaltarAutoriPagoCentroActividad(Border borderResaltarAutoriPago) {
		if(borderResaltarAutoriPago!=null) {
			this.resaltarAutoriPagoCentroActividad= borderResaltarAutoriPago;
		}
	}

	public Border setResaltarAutoriPagoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//centroactividadBeanSwingJInternalFrame.jTtoolBarCentroActividad.setBorder(borderResaltarAutoriPago);
			
		this.resaltarAutoriPagoCentroActividad= borderResaltarAutoriPago;

		 return borderResaltarAutoriPago;
	}



	public Boolean mostrarAutoriPagoCentroActividad=true;

	public Boolean getMostrarAutoriPagoCentroActividad() {
		return this.mostrarAutoriPagoCentroActividad;
	}

	public void setMostrarAutoriPagoCentroActividad(Boolean visibilidadResaltarAutoriPago) {
		this.mostrarAutoriPagoCentroActividad= visibilidadResaltarAutoriPago;
	}



	public Boolean activarAutoriPagoCentroActividad=true;

	public Boolean gethabilitarResaltarAutoriPagoCentroActividad() {
		return this.activarAutoriPagoCentroActividad;
	}

	public void setActivarAutoriPagoCentroActividad(Boolean habilitarResaltarAutoriPago) {
		this.activarAutoriPagoCentroActividad= habilitarResaltarAutoriPago;
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

		this.setMostrarPagoAutoCentroActividad(esInicial);
		this.setMostrarClienteCentroActividad(esInicial);
		this.setMostrarAutoriPagoCentroActividad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setMostrarPagoAutoCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setMostrarAutoriPagoCentroActividad(esAsigna);
				continue;
			}
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

		this.setActivarPagoAutoCentroActividad(esInicial);
		this.setActivarClienteCentroActividad(esInicial);
		this.setActivarAutoriPagoCentroActividad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setActivarPagoAutoCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setActivarAutoriPagoCentroActividad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPagoAutoCentroActividad(esInicial);
		this.setResaltarClienteCentroActividad(esInicial);
		this.setResaltarAutoriPagoCentroActividad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setResaltarPagoAutoCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteCentroActividad(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setResaltarAutoriPagoCentroActividad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoCentroActividad=true;

	public Boolean getMostrarBusquedaPorCodigoCentroActividad() {
		return this.mostrarBusquedaPorCodigoCentroActividad;
	}

	public void setMostrarBusquedaPorCodigoCentroActividad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoCentroActividad= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCentroActividad=true;

	public Boolean getMostrarBusquedaPorNombreCentroActividad() {
		return this.mostrarBusquedaPorNombreCentroActividad;
	}

	public void setMostrarBusquedaPorNombreCentroActividad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCentroActividad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCentroActividad=true;

	public Boolean getMostrarFK_IdEmpresaCentroActividad() {
		return this.mostrarFK_IdEmpresaCentroActividad;
	}

	public void setMostrarFK_IdEmpresaCentroActividad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCentroActividad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoFlujoCajaCentroActividad=true;

	public Boolean getMostrarFK_IdTipoGrupoFlujoCajaCentroActividad() {
		return this.mostrarFK_IdTipoGrupoFlujoCajaCentroActividad;
	}

	public void setMostrarFK_IdTipoGrupoFlujoCajaCentroActividad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoFlujoCajaCentroActividad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoCentroActividad=true;

	public Boolean getMostrarFK_IdTipoMovimientoCentroActividad() {
		return this.mostrarFK_IdTipoMovimientoCentroActividad;
	}

	public void setMostrarFK_IdTipoMovimientoCentroActividad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoCentroActividad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoCentroActividad=true;

	public Boolean getActivarBusquedaPorCodigoCentroActividad() {
		return this.activarBusquedaPorCodigoCentroActividad;
	}

	public void setActivarBusquedaPorCodigoCentroActividad(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoCentroActividad= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCentroActividad=true;

	public Boolean getActivarBusquedaPorNombreCentroActividad() {
		return this.activarBusquedaPorNombreCentroActividad;
	}

	public void setActivarBusquedaPorNombreCentroActividad(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCentroActividad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCentroActividad=true;

	public Boolean getActivarFK_IdEmpresaCentroActividad() {
		return this.activarFK_IdEmpresaCentroActividad;
	}

	public void setActivarFK_IdEmpresaCentroActividad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCentroActividad= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoFlujoCajaCentroActividad=true;

	public Boolean getActivarFK_IdTipoGrupoFlujoCajaCentroActividad() {
		return this.activarFK_IdTipoGrupoFlujoCajaCentroActividad;
	}

	public void setActivarFK_IdTipoGrupoFlujoCajaCentroActividad(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoFlujoCajaCentroActividad= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoCentroActividad=true;

	public Boolean getActivarFK_IdTipoMovimientoCentroActividad() {
		return this.activarFK_IdTipoMovimientoCentroActividad;
	}

	public void setActivarFK_IdTipoMovimientoCentroActividad(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoCentroActividad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoCentroActividad=null;

	public Border getResaltarBusquedaPorCodigoCentroActividad() {
		return this.resaltarBusquedaPorCodigoCentroActividad;
	}

	public void setResaltarBusquedaPorCodigoCentroActividad(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoCentroActividad= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoCentroActividad= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCentroActividad=null;

	public Border getResaltarBusquedaPorNombreCentroActividad() {
		return this.resaltarBusquedaPorNombreCentroActividad;
	}

	public void setResaltarBusquedaPorNombreCentroActividad(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCentroActividad= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCentroActividad= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCentroActividad=null;

	public Border getResaltarFK_IdEmpresaCentroActividad() {
		return this.resaltarFK_IdEmpresaCentroActividad;
	}

	public void setResaltarFK_IdEmpresaCentroActividad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCentroActividad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCentroActividad= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoFlujoCajaCentroActividad=null;

	public Border getResaltarFK_IdTipoGrupoFlujoCajaCentroActividad() {
		return this.resaltarFK_IdTipoGrupoFlujoCajaCentroActividad;
	}

	public void setResaltarFK_IdTipoGrupoFlujoCajaCentroActividad(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoFlujoCajaCentroActividad= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoFlujoCajaCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoFlujoCajaCentroActividad= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoCentroActividad=null;

	public Border getResaltarFK_IdTipoMovimientoCentroActividad() {
		return this.resaltarFK_IdTipoMovimientoCentroActividad;
	}

	public void setResaltarFK_IdTipoMovimientoCentroActividad(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoCentroActividad= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoCentroActividad(ParametroGeneralUsuario parametroGeneralUsuario/*CentroActividadBeanSwingJInternalFrame centroactividadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoCentroActividad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}