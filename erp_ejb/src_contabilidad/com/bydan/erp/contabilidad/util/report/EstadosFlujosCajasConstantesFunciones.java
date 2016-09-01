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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadosFlujosCajasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadosFlujosCajas";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadosFlujosCajas"+EstadosFlujosCajasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadosFlujosCajasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadosFlujosCajasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadosFlujosCajasConstantesFunciones.SCHEMA+"_"+EstadosFlujosCajasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadosFlujosCajasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadosFlujosCajasConstantesFunciones.SCHEMA+"_"+EstadosFlujosCajasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadosFlujosCajasConstantesFunciones.SCHEMA+"_"+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadosFlujosCajasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadosFlujosCajasConstantesFunciones.SCHEMA+"_"+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadosFlujosCajasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadosFlujosCajasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosFlujosCajasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadosFlujosCajasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadosFlujosCajasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadosFlujosCajasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadosFlujosCajasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estados Flujos Cajases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estados Flujos Cajas";
	public static final String SCLASSWEBTITULO_LOWER="Estados Flujos Cajas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadosFlujosCajas";
	public static final String OBJECTNAME="estadosflujoscajas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="estados_flujos_cajas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadosflujoscajas from "+EstadosFlujosCajasConstantesFunciones.SPERSISTENCENAME+" estadosflujoscajas";
	public static String QUERYSELECTNATIVE="select "+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".id,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".version_row,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".id_empresa,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".id_ejercicio,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".id_periodo,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".id_centro_actividad,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".nombre_centro_actividad,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".codigo_centro_actividad,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".mensual,"+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME+".acumulado from "+EstadosFlujosCajasConstantesFunciones.SCHEMA+"."+EstadosFlujosCajasConstantesFunciones.TABLENAME;//+" as "+EstadosFlujosCajasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String NOMBRECENTROACTIVIDAD= "nombre_centro_actividad";
    public static final String CODIGOCENTROACTIVIDAD= "codigo_centro_actividad";
    public static final String MENSUAL= "mensual";
    public static final String ACUMULADO= "acumulado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Activad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_NOMBRECENTROACTIVIDAD= "Nombre Centro Activad";
		public static final String LABEL_NOMBRECENTROACTIVIDAD_LOWER= "Nombre Centro Actividad";
    	public static final String LABEL_CODIGOCENTROACTIVIDAD= "Codigo Centro Activad";
		public static final String LABEL_CODIGOCENTROACTIVIDAD_LOWER= "Codigo Centro Actividad";
    	public static final String LABEL_MENSUAL= "Mensual";
		public static final String LABEL_MENSUAL_LOWER= "Mensual";
    	public static final String LABEL_ACUMULADO= "Acumulado";
		public static final String LABEL_ACUMULADO_LOWER= "Acumulado";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CENTRO_ACTIVIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CENTRO_ACTIVIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CENTRO_ACTIVIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CENTRO_ACTIVIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getEstadosFlujosCajasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.IDPERIODO)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_CODIGOCENTROACTIVIDAD;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.MENSUAL)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL;}
		if(sNombreColumna.equals(EstadosFlujosCajasConstantesFunciones.ACUMULADO)) {sLabelColumna=EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getEstadosFlujosCajasDescripcion(EstadosFlujosCajas estadosflujoscajas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadosflujoscajas !=null/* && estadosflujoscajas.getId()!=0*/) {
			if(estadosflujoscajas.getId()!=null) {
				sDescripcion=estadosflujoscajas.getId().toString();
			}//estadosflujoscajasestadosflujoscajas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadosFlujosCajasDescripcionDetallado(EstadosFlujosCajas estadosflujoscajas) {
		String sDescripcion="";
			
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.ID+"=";
		sDescripcion+=estadosflujoscajas.getId().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadosflujoscajas.getVersionRow().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadosflujoscajas.getid_empresa().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=estadosflujoscajas.getid_ejercicio().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=estadosflujoscajas.getid_periodo().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=estadosflujoscajas.getid_centro_actividad().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD+"=";
		sDescripcion+=estadosflujoscajas.getnombre_centro_actividad()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD+"=";
		sDescripcion+=estadosflujoscajas.getcodigo_centro_actividad()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.MENSUAL+"=";
		sDescripcion+=estadosflujoscajas.getmensual().toString()+",";
		sDescripcion+=EstadosFlujosCajasConstantesFunciones.ACUMULADO+"=";
		sDescripcion+=estadosflujoscajas.getacumulado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadosFlujosCajasDescripcion(EstadosFlujosCajas estadosflujoscajas,String sValor) throws Exception {			
		if(estadosflujoscajas !=null) {
			//estadosflujoscajasestadosflujoscajas.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centroactividad!=null/*&&centroactividad.getId()>0*/) {
			sDescripcion=CentroActividadConstantesFunciones.getCentroActividadDescripcion(centroactividad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaEstadosFlujosCajas")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Centro Activad";
		} else if(sNombreIndice.equals("FK_IdCentroActividad")) {
			sNombreIndice="Tipo=  Por Centro Activad";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaEstadosFlujosCajas(Long id_ejercicio,Long id_periodo,Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Activad="+id_centro_actividad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroActividad(Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Activad="+id_centro_actividad.toString();} 

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

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadosflujoscajas.setnombre_centro_actividad(estadosflujoscajas.getnombre_centro_actividad().trim());
		estadosflujoscajas.setcodigo_centro_actividad(estadosflujoscajas.getcodigo_centro_actividad().trim());
	}
	
	public static void quitarEspaciosEstadosFlujosCajass(List<EstadosFlujosCajas> estadosflujoscajass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {
			estadosflujoscajas.setnombre_centro_actividad(estadosflujoscajas.getnombre_centro_actividad().trim());
			estadosflujoscajas.setcodigo_centro_actividad(estadosflujoscajas.getcodigo_centro_actividad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadosflujoscajas.getConCambioAuxiliar()) {
			estadosflujoscajas.setIsDeleted(estadosflujoscajas.getIsDeletedAuxiliar());	
			estadosflujoscajas.setIsNew(estadosflujoscajas.getIsNewAuxiliar());	
			estadosflujoscajas.setIsChanged(estadosflujoscajas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadosflujoscajas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadosflujoscajas.setIsDeletedAuxiliar(false);	
			estadosflujoscajas.setIsNewAuxiliar(false);	
			estadosflujoscajas.setIsChangedAuxiliar(false);
			
			estadosflujoscajas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadosFlujosCajass(List<EstadosFlujosCajas> estadosflujoscajass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadosFlujosCajas estadosflujoscajas : estadosflujoscajass) {
			if(conAsignarBase && estadosflujoscajas.getConCambioAuxiliar()) {
				estadosflujoscajas.setIsDeleted(estadosflujoscajas.getIsDeletedAuxiliar());	
				estadosflujoscajas.setIsNew(estadosflujoscajas.getIsNewAuxiliar());	
				estadosflujoscajas.setIsChanged(estadosflujoscajas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadosflujoscajas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadosflujoscajas.setIsDeletedAuxiliar(false);	
				estadosflujoscajas.setIsNewAuxiliar(false);	
				estadosflujoscajas.setIsChangedAuxiliar(false);
				
				estadosflujoscajas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajas,Boolean conEnteros) throws Exception  {
		estadosflujoscajas.setmensual(0.0);
		estadosflujoscajas.setacumulado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadosFlujosCajass(List<EstadosFlujosCajas> estadosflujoscajass,Boolean conEnteros) throws Exception  {
		
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {
			estadosflujoscajas.setmensual(0.0);
			estadosflujoscajas.setacumulado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadosFlujosCajas(List<EstadosFlujosCajas> estadosflujoscajass,EstadosFlujosCajas estadosflujoscajasAux) throws Exception  {
		EstadosFlujosCajasConstantesFunciones.InicializarValoresEstadosFlujosCajas(estadosflujoscajasAux,true);
		
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {
			if(estadosflujoscajas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			estadosflujoscajasAux.setmensual(estadosflujoscajasAux.getmensual()+estadosflujoscajas.getmensual());			
			estadosflujoscajasAux.setacumulado(estadosflujoscajasAux.getacumulado()+estadosflujoscajas.getacumulado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosFlujosCajas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadosFlujosCajasConstantesFunciones.getArrayColumnasGlobalesEstadosFlujosCajas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosFlujosCajas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosFlujosCajasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosFlujosCajasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadosFlujosCajas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadosFlujosCajas> estadosflujoscajass,EstadosFlujosCajas estadosflujoscajas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadosFlujosCajas estadosflujoscajasAux: estadosflujoscajass) {
			if(estadosflujoscajasAux!=null && estadosflujoscajas!=null) {
				if((estadosflujoscajasAux.getId()==null && estadosflujoscajas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadosflujoscajasAux.getId()!=null && estadosflujoscajas.getId()!=null){
					if(estadosflujoscajasAux.getId().equals(estadosflujoscajas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadosFlujosCajas(List<EstadosFlujosCajas> estadosflujoscajass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double mensualTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {			
			if(estadosflujoscajas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			mensualTotal+=estadosflujoscajas.getmensual();
			acumuladoTotal+=estadosflujoscajas.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosFlujosCajasConstantesFunciones.MENSUAL);
		datoGeneral.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL);
		datoGeneral.setdValorDouble(mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosFlujosCajasConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadosFlujosCajas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_ID, EstadosFlujosCajasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_VERSIONROW, EstadosFlujosCajasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_IDPERIODO, EstadosFlujosCajasConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD, EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_CODIGOCENTROACTIVIDAD, EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL, EstadosFlujosCajasConstantesFunciones.MENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO, EstadosFlujosCajasConstantesFunciones.ACUMULADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadosFlujosCajas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.MENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosFlujosCajasConstantesFunciones.ACUMULADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosFlujosCajas() throws Exception  {
		return EstadosFlujosCajasConstantesFunciones.getTiposSeleccionarEstadosFlujosCajas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosFlujosCajas(Boolean conFk) throws Exception  {
		return EstadosFlujosCajasConstantesFunciones.getTiposSeleccionarEstadosFlujosCajas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosFlujosCajas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_CODIGOCENTROACTIVIDAD);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_CODIGOCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO);
			reporte.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadosFlujosCajas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajasAux) throws Exception {
		
			estadosflujoscajasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadosflujoscajasAux.getEmpresa()));
			estadosflujoscajasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(estadosflujoscajasAux.getEjercicio()));
			estadosflujoscajasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(estadosflujoscajasAux.getPeriodo()));
			estadosflujoscajasAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(estadosflujoscajasAux.getCentroActividad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadosFlujosCajas(List<EstadosFlujosCajas> estadosflujoscajassTemp) throws Exception {
		for(EstadosFlujosCajas estadosflujoscajasAux:estadosflujoscajassTemp) {
			
			estadosflujoscajasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadosflujoscajasAux.getEmpresa()));
			estadosflujoscajasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(estadosflujoscajasAux.getEjercicio()));
			estadosflujoscajasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(estadosflujoscajasAux.getPeriodo()));
			estadosflujoscajasAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(estadosflujoscajasAux.getCentroActividad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadosFlujosCajas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(CentroActividad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadosFlujosCajas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadosFlujosCajas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadosFlujosCajasConstantesFunciones.getClassesRelationshipsOfEstadosFlujosCajas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadosFlujosCajas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadosFlujosCajas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadosFlujosCajasConstantesFunciones.getClassesRelationshipsFromStringsOfEstadosFlujosCajas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadosFlujosCajas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EstadosFlujosCajas estadosflujoscajas,List<EstadosFlujosCajas> estadosflujoscajass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EstadosFlujosCajas estadosflujoscajas,List<EstadosFlujosCajas> estadosflujoscajass) throws Exception {
		try	{			
			for(EstadosFlujosCajas estadosflujoscajasLocal:estadosflujoscajass) {
				if(estadosflujoscajasLocal.getId().equals(estadosflujoscajas.getId())) {
					estadosflujoscajasLocal.setIsSelected(estadosflujoscajas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadosFlujosCajas(List<EstadosFlujosCajas> estadosflujoscajassAux) throws Exception {
		//this.estadosflujoscajassAux=estadosflujoscajassAux;
		
		for(EstadosFlujosCajas estadosflujoscajasAux:estadosflujoscajassAux) {
			if(estadosflujoscajasAux.getIsChanged()) {
				estadosflujoscajasAux.setIsChanged(false);
			}		
			
			if(estadosflujoscajasAux.getIsNew()) {
				estadosflujoscajasAux.setIsNew(false);
			}	
			
			if(estadosflujoscajasAux.getIsDeleted()) {
				estadosflujoscajasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajasAux) throws Exception {
		//this.estadosflujoscajasAux=estadosflujoscajasAux;
		
			if(estadosflujoscajasAux.getIsChanged()) {
				estadosflujoscajasAux.setIsChanged(false);
			}		
			
			if(estadosflujoscajasAux.getIsNew()) {
				estadosflujoscajasAux.setIsNew(false);
			}	
			
			if(estadosflujoscajasAux.getIsDeleted()) {
				estadosflujoscajasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadosFlujosCajas estadosflujoscajasAsignar,EstadosFlujosCajas estadosflujoscajas) throws Exception {
		estadosflujoscajasAsignar.setId(estadosflujoscajas.getId());	
		estadosflujoscajasAsignar.setVersionRow(estadosflujoscajas.getVersionRow());	
		estadosflujoscajasAsignar.setid_periodo(estadosflujoscajas.getid_periodo());
		estadosflujoscajasAsignar.setperiodo_descripcion(estadosflujoscajas.getperiodo_descripcion());	
		estadosflujoscajasAsignar.setnombre_centro_actividad(estadosflujoscajas.getnombre_centro_actividad());	
		estadosflujoscajasAsignar.setcodigo_centro_actividad(estadosflujoscajas.getcodigo_centro_actividad());	
		estadosflujoscajasAsignar.setmensual(estadosflujoscajas.getmensual());	
		estadosflujoscajasAsignar.setacumulado(estadosflujoscajas.getacumulado());	
	}
	
	public static void inicializarEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajas) throws Exception {
		try {
				estadosflujoscajas.setId(0L);	
					
				estadosflujoscajas.setid_periodo(-1L);	
				estadosflujoscajas.setnombre_centro_actividad("");	
				estadosflujoscajas.setcodigo_centro_actividad("");	
				estadosflujoscajas.setmensual(0.0);	
				estadosflujoscajas.setacumulado(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadosFlujosCajas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_CODIGOCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadosFlujosCajas(String sTipo,Row row,Workbook workbook,EstadosFlujosCajas estadosflujoscajas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getnombre_centro_actividad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getcodigo_centro_actividad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getmensual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosflujoscajas.getacumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadosFlujosCajas="";
	
	public String getsFinalQueryEstadosFlujosCajas() {
		return this.sFinalQueryEstadosFlujosCajas;
	}
	
	public void setsFinalQueryEstadosFlujosCajas(String sFinalQueryEstadosFlujosCajas) {
		this.sFinalQueryEstadosFlujosCajas= sFinalQueryEstadosFlujosCajas;
	}
	
	public Border resaltarSeleccionarEstadosFlujosCajas=null;
	
	public Border setResaltarSeleccionarEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadosFlujosCajas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadosFlujosCajas() {
		return this.resaltarSeleccionarEstadosFlujosCajas;
	}
	
	public void setResaltarSeleccionarEstadosFlujosCajas(Border borderResaltarSeleccionarEstadosFlujosCajas) {
		this.resaltarSeleccionarEstadosFlujosCajas= borderResaltarSeleccionarEstadosFlujosCajas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadosFlujosCajas=null;
	public Boolean mostraridEstadosFlujosCajas=true;
	public Boolean activaridEstadosFlujosCajas=true;

	public Border resaltarid_empresaEstadosFlujosCajas=null;
	public Boolean mostrarid_empresaEstadosFlujosCajas=true;
	public Boolean activarid_empresaEstadosFlujosCajas=true;
	public Boolean cargarid_empresaEstadosFlujosCajas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadosFlujosCajas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEstadosFlujosCajas=null;
	public Boolean mostrarid_ejercicioEstadosFlujosCajas=true;
	public Boolean activarid_ejercicioEstadosFlujosCajas=true;
	public Boolean cargarid_ejercicioEstadosFlujosCajas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEstadosFlujosCajas=false;//ConEventDepend=true

	public Border resaltarid_periodoEstadosFlujosCajas=null;
	public Boolean mostrarid_periodoEstadosFlujosCajas=true;
	public Boolean activarid_periodoEstadosFlujosCajas=true;
	public Boolean cargarid_periodoEstadosFlujosCajas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoEstadosFlujosCajas=false;//ConEventDepend=true

	public Border resaltarid_centro_actividadEstadosFlujosCajas=null;
	public Boolean mostrarid_centro_actividadEstadosFlujosCajas=true;
	public Boolean activarid_centro_actividadEstadosFlujosCajas=true;
	public Boolean cargarid_centro_actividadEstadosFlujosCajas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadEstadosFlujosCajas=false;//ConEventDepend=true

	public Border resaltarnombre_centro_actividadEstadosFlujosCajas=null;
	public Boolean mostrarnombre_centro_actividadEstadosFlujosCajas=true;
	public Boolean activarnombre_centro_actividadEstadosFlujosCajas=true;

	public Border resaltarcodigo_centro_actividadEstadosFlujosCajas=null;
	public Boolean mostrarcodigo_centro_actividadEstadosFlujosCajas=true;
	public Boolean activarcodigo_centro_actividadEstadosFlujosCajas=true;

	public Border resaltarmensualEstadosFlujosCajas=null;
	public Boolean mostrarmensualEstadosFlujosCajas=true;
	public Boolean activarmensualEstadosFlujosCajas=true;

	public Border resaltaracumuladoEstadosFlujosCajas=null;
	public Boolean mostraracumuladoEstadosFlujosCajas=true;
	public Boolean activaracumuladoEstadosFlujosCajas=true;

	
	

	public Border setResaltaridEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltaridEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadosFlujosCajas() {
		return this.resaltaridEstadosFlujosCajas;
	}

	public void setResaltaridEstadosFlujosCajas(Border borderResaltar) {
		this.resaltaridEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostraridEstadosFlujosCajas() {
		return this.mostraridEstadosFlujosCajas;
	}

	public void setMostraridEstadosFlujosCajas(Boolean mostraridEstadosFlujosCajas) {
		this.mostraridEstadosFlujosCajas= mostraridEstadosFlujosCajas;
	}

	public Boolean getActivaridEstadosFlujosCajas() {
		return this.activaridEstadosFlujosCajas;
	}

	public void setActivaridEstadosFlujosCajas(Boolean activaridEstadosFlujosCajas) {
		this.activaridEstadosFlujosCajas= activaridEstadosFlujosCajas;
	}

	public Border setResaltarid_empresaEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadosFlujosCajas() {
		return this.resaltarid_empresaEstadosFlujosCajas;
	}

	public void setResaltarid_empresaEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarid_empresaEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadosFlujosCajas() {
		return this.mostrarid_empresaEstadosFlujosCajas;
	}

	public void setMostrarid_empresaEstadosFlujosCajas(Boolean mostrarid_empresaEstadosFlujosCajas) {
		this.mostrarid_empresaEstadosFlujosCajas= mostrarid_empresaEstadosFlujosCajas;
	}

	public Boolean getActivarid_empresaEstadosFlujosCajas() {
		return this.activarid_empresaEstadosFlujosCajas;
	}

	public void setActivarid_empresaEstadosFlujosCajas(Boolean activarid_empresaEstadosFlujosCajas) {
		this.activarid_empresaEstadosFlujosCajas= activarid_empresaEstadosFlujosCajas;
	}

	public Boolean getCargarid_empresaEstadosFlujosCajas() {
		return this.cargarid_empresaEstadosFlujosCajas;
	}

	public void setCargarid_empresaEstadosFlujosCajas(Boolean cargarid_empresaEstadosFlujosCajas) {
		this.cargarid_empresaEstadosFlujosCajas= cargarid_empresaEstadosFlujosCajas;
	}

	public Border setResaltarid_ejercicioEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEstadosFlujosCajas() {
		return this.resaltarid_ejercicioEstadosFlujosCajas;
	}

	public void setResaltarid_ejercicioEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarid_ejercicioEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEstadosFlujosCajas() {
		return this.mostrarid_ejercicioEstadosFlujosCajas;
	}

	public void setMostrarid_ejercicioEstadosFlujosCajas(Boolean mostrarid_ejercicioEstadosFlujosCajas) {
		this.mostrarid_ejercicioEstadosFlujosCajas= mostrarid_ejercicioEstadosFlujosCajas;
	}

	public Boolean getActivarid_ejercicioEstadosFlujosCajas() {
		return this.activarid_ejercicioEstadosFlujosCajas;
	}

	public void setActivarid_ejercicioEstadosFlujosCajas(Boolean activarid_ejercicioEstadosFlujosCajas) {
		this.activarid_ejercicioEstadosFlujosCajas= activarid_ejercicioEstadosFlujosCajas;
	}

	public Boolean getCargarid_ejercicioEstadosFlujosCajas() {
		return this.cargarid_ejercicioEstadosFlujosCajas;
	}

	public void setCargarid_ejercicioEstadosFlujosCajas(Boolean cargarid_ejercicioEstadosFlujosCajas) {
		this.cargarid_ejercicioEstadosFlujosCajas= cargarid_ejercicioEstadosFlujosCajas;
	}

	public Border setResaltarid_periodoEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarid_periodoEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoEstadosFlujosCajas() {
		return this.resaltarid_periodoEstadosFlujosCajas;
	}

	public void setResaltarid_periodoEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarid_periodoEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarid_periodoEstadosFlujosCajas() {
		return this.mostrarid_periodoEstadosFlujosCajas;
	}

	public void setMostrarid_periodoEstadosFlujosCajas(Boolean mostrarid_periodoEstadosFlujosCajas) {
		this.mostrarid_periodoEstadosFlujosCajas= mostrarid_periodoEstadosFlujosCajas;
	}

	public Boolean getActivarid_periodoEstadosFlujosCajas() {
		return this.activarid_periodoEstadosFlujosCajas;
	}

	public void setActivarid_periodoEstadosFlujosCajas(Boolean activarid_periodoEstadosFlujosCajas) {
		this.activarid_periodoEstadosFlujosCajas= activarid_periodoEstadosFlujosCajas;
	}

	public Boolean getCargarid_periodoEstadosFlujosCajas() {
		return this.cargarid_periodoEstadosFlujosCajas;
	}

	public void setCargarid_periodoEstadosFlujosCajas(Boolean cargarid_periodoEstadosFlujosCajas) {
		this.cargarid_periodoEstadosFlujosCajas= cargarid_periodoEstadosFlujosCajas;
	}

	public Border setResaltarid_centro_actividadEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarid_centro_actividadEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadEstadosFlujosCajas() {
		return this.resaltarid_centro_actividadEstadosFlujosCajas;
	}

	public void setResaltarid_centro_actividadEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarid_centro_actividadEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadEstadosFlujosCajas() {
		return this.mostrarid_centro_actividadEstadosFlujosCajas;
	}

	public void setMostrarid_centro_actividadEstadosFlujosCajas(Boolean mostrarid_centro_actividadEstadosFlujosCajas) {
		this.mostrarid_centro_actividadEstadosFlujosCajas= mostrarid_centro_actividadEstadosFlujosCajas;
	}

	public Boolean getActivarid_centro_actividadEstadosFlujosCajas() {
		return this.activarid_centro_actividadEstadosFlujosCajas;
	}

	public void setActivarid_centro_actividadEstadosFlujosCajas(Boolean activarid_centro_actividadEstadosFlujosCajas) {
		this.activarid_centro_actividadEstadosFlujosCajas= activarid_centro_actividadEstadosFlujosCajas;
	}

	public Boolean getCargarid_centro_actividadEstadosFlujosCajas() {
		return this.cargarid_centro_actividadEstadosFlujosCajas;
	}

	public void setCargarid_centro_actividadEstadosFlujosCajas(Boolean cargarid_centro_actividadEstadosFlujosCajas) {
		this.cargarid_centro_actividadEstadosFlujosCajas= cargarid_centro_actividadEstadosFlujosCajas;
	}

	public Border setResaltarnombre_centro_actividadEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarnombre_centro_actividadEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_centro_actividadEstadosFlujosCajas() {
		return this.resaltarnombre_centro_actividadEstadosFlujosCajas;
	}

	public void setResaltarnombre_centro_actividadEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarnombre_centro_actividadEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarnombre_centro_actividadEstadosFlujosCajas() {
		return this.mostrarnombre_centro_actividadEstadosFlujosCajas;
	}

	public void setMostrarnombre_centro_actividadEstadosFlujosCajas(Boolean mostrarnombre_centro_actividadEstadosFlujosCajas) {
		this.mostrarnombre_centro_actividadEstadosFlujosCajas= mostrarnombre_centro_actividadEstadosFlujosCajas;
	}

	public Boolean getActivarnombre_centro_actividadEstadosFlujosCajas() {
		return this.activarnombre_centro_actividadEstadosFlujosCajas;
	}

	public void setActivarnombre_centro_actividadEstadosFlujosCajas(Boolean activarnombre_centro_actividadEstadosFlujosCajas) {
		this.activarnombre_centro_actividadEstadosFlujosCajas= activarnombre_centro_actividadEstadosFlujosCajas;
	}

	public Border setResaltarcodigo_centro_actividadEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarcodigo_centro_actividadEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_centro_actividadEstadosFlujosCajas() {
		return this.resaltarcodigo_centro_actividadEstadosFlujosCajas;
	}

	public void setResaltarcodigo_centro_actividadEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarcodigo_centro_actividadEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarcodigo_centro_actividadEstadosFlujosCajas() {
		return this.mostrarcodigo_centro_actividadEstadosFlujosCajas;
	}

	public void setMostrarcodigo_centro_actividadEstadosFlujosCajas(Boolean mostrarcodigo_centro_actividadEstadosFlujosCajas) {
		this.mostrarcodigo_centro_actividadEstadosFlujosCajas= mostrarcodigo_centro_actividadEstadosFlujosCajas;
	}

	public Boolean getActivarcodigo_centro_actividadEstadosFlujosCajas() {
		return this.activarcodigo_centro_actividadEstadosFlujosCajas;
	}

	public void setActivarcodigo_centro_actividadEstadosFlujosCajas(Boolean activarcodigo_centro_actividadEstadosFlujosCajas) {
		this.activarcodigo_centro_actividadEstadosFlujosCajas= activarcodigo_centro_actividadEstadosFlujosCajas;
	}

	public Border setResaltarmensualEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltarmensualEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmensualEstadosFlujosCajas() {
		return this.resaltarmensualEstadosFlujosCajas;
	}

	public void setResaltarmensualEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarmensualEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostrarmensualEstadosFlujosCajas() {
		return this.mostrarmensualEstadosFlujosCajas;
	}

	public void setMostrarmensualEstadosFlujosCajas(Boolean mostrarmensualEstadosFlujosCajas) {
		this.mostrarmensualEstadosFlujosCajas= mostrarmensualEstadosFlujosCajas;
	}

	public Boolean getActivarmensualEstadosFlujosCajas() {
		return this.activarmensualEstadosFlujosCajas;
	}

	public void setActivarmensualEstadosFlujosCajas(Boolean activarmensualEstadosFlujosCajas) {
		this.activarmensualEstadosFlujosCajas= activarmensualEstadosFlujosCajas;
	}

	public Border setResaltaracumuladoEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosflujoscajasBeanSwingJInternalFrame.jTtoolBarEstadosFlujosCajas.setBorder(borderResaltar);
		
		this.resaltaracumuladoEstadosFlujosCajas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracumuladoEstadosFlujosCajas() {
		return this.resaltaracumuladoEstadosFlujosCajas;
	}

	public void setResaltaracumuladoEstadosFlujosCajas(Border borderResaltar) {
		this.resaltaracumuladoEstadosFlujosCajas= borderResaltar;
	}

	public Boolean getMostraracumuladoEstadosFlujosCajas() {
		return this.mostraracumuladoEstadosFlujosCajas;
	}

	public void setMostraracumuladoEstadosFlujosCajas(Boolean mostraracumuladoEstadosFlujosCajas) {
		this.mostraracumuladoEstadosFlujosCajas= mostraracumuladoEstadosFlujosCajas;
	}

	public Boolean getActivaracumuladoEstadosFlujosCajas() {
		return this.activaracumuladoEstadosFlujosCajas;
	}

	public void setActivaracumuladoEstadosFlujosCajas(Boolean activaracumuladoEstadosFlujosCajas) {
		this.activaracumuladoEstadosFlujosCajas= activaracumuladoEstadosFlujosCajas;
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
		
		
		this.setMostraridEstadosFlujosCajas(esInicial);
		this.setMostrarid_empresaEstadosFlujosCajas(esInicial);
		this.setMostrarid_ejercicioEstadosFlujosCajas(esInicial);
		this.setMostrarid_periodoEstadosFlujosCajas(esInicial);
		this.setMostrarid_centro_actividadEstadosFlujosCajas(esInicial);
		this.setMostrarnombre_centro_actividadEstadosFlujosCajas(esInicial);
		this.setMostrarcodigo_centro_actividadEstadosFlujosCajas(esInicial);
		this.setMostrarmensualEstadosFlujosCajas(esInicial);
		this.setMostraracumuladoEstadosFlujosCajas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ID)) {
				this.setMostraridEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setMostrarnombre_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD)) {
				this.setMostrarcodigo_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.MENSUAL)) {
				this.setMostrarmensualEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ACUMULADO)) {
				this.setMostraracumuladoEstadosFlujosCajas(esAsigna);
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
		
		
		this.setActivaridEstadosFlujosCajas(esInicial);
		this.setActivarid_empresaEstadosFlujosCajas(esInicial);
		this.setActivarid_ejercicioEstadosFlujosCajas(esInicial);
		this.setActivarid_periodoEstadosFlujosCajas(esInicial);
		this.setActivarid_centro_actividadEstadosFlujosCajas(esInicial);
		this.setActivarnombre_centro_actividadEstadosFlujosCajas(esInicial);
		this.setActivarcodigo_centro_actividadEstadosFlujosCajas(esInicial);
		this.setActivarmensualEstadosFlujosCajas(esInicial);
		this.setActivaracumuladoEstadosFlujosCajas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ID)) {
				this.setActivaridEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setActivarnombre_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD)) {
				this.setActivarcodigo_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.MENSUAL)) {
				this.setActivarmensualEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ACUMULADO)) {
				this.setActivaracumuladoEstadosFlujosCajas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadosFlujosCajas(esInicial);
		this.setResaltarid_empresaEstadosFlujosCajas(esInicial);
		this.setResaltarid_ejercicioEstadosFlujosCajas(esInicial);
		this.setResaltarid_periodoEstadosFlujosCajas(esInicial);
		this.setResaltarid_centro_actividadEstadosFlujosCajas(esInicial);
		this.setResaltarnombre_centro_actividadEstadosFlujosCajas(esInicial);
		this.setResaltarcodigo_centro_actividadEstadosFlujosCajas(esInicial);
		this.setResaltarmensualEstadosFlujosCajas(esInicial);
		this.setResaltaracumuladoEstadosFlujosCajas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ID)) {
				this.setResaltaridEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setResaltarnombre_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.CODIGOCENTROACTIVIDAD)) {
				this.setResaltarcodigo_centro_actividadEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.MENSUAL)) {
				this.setResaltarmensualEstadosFlujosCajas(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosFlujosCajasConstantesFunciones.ACUMULADO)) {
				this.setResaltaracumuladoEstadosFlujosCajas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEstadosFlujosCajasEstadosFlujosCajas=true;

	public Boolean getMostrarBusquedaEstadosFlujosCajasEstadosFlujosCajas() {
		return this.mostrarBusquedaEstadosFlujosCajasEstadosFlujosCajas;
	}

	public void setMostrarBusquedaEstadosFlujosCajasEstadosFlujosCajas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEstadosFlujosCajasEstadosFlujosCajas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEstadosFlujosCajasEstadosFlujosCajas=true;

	public Boolean getActivarBusquedaEstadosFlujosCajasEstadosFlujosCajas() {
		return this.activarBusquedaEstadosFlujosCajasEstadosFlujosCajas;
	}

	public void setActivarBusquedaEstadosFlujosCajasEstadosFlujosCajas(Boolean habilitarResaltar) {
		this.activarBusquedaEstadosFlujosCajasEstadosFlujosCajas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas=null;

	public Border getResaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas() {
		return this.resaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas;
	}

	public void setResaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas(Border borderResaltar) {
		this.resaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas= borderResaltar;
	}

	public void setResaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosFlujosCajasBeanSwingJInternalFrame estadosflujoscajasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEstadosFlujosCajasEstadosFlujosCajas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}