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

import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;

import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarCalcularDepreciacionesParameterGeneral;

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
final public class ProcesarCalcularDepreciacionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesarCalcularDepreciaciones";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesarCalcularDepreciaciones"+ProcesarCalcularDepreciacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesarCalcularDepreciacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesarCalcularDepreciacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"_"+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarCalcularDepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"_"+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"_"+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarCalcularDepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"_"+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarCalcularDepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarCalcularDepreciacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarCalcularDepreciacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesarCalcularDepreciacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesarCalcularDepreciacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesarCalcularDepreciacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesarCalcularDepreciacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Procesar Calcular Depreciacioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Procesar Calcular Depreciaciones";
	public static final String SCLASSWEBTITULO_LOWER="Procesar Calcular Depreciaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesarCalcularDepreciaciones";
	public static final String OBJECTNAME="procesarcalculardepreciaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="procesar_calcular_depreciaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesarcalculardepreciaciones from "+ProcesarCalcularDepreciacionesConstantesFunciones.SPERSISTENCENAME+" procesarcalculardepreciaciones";
	public static String QUERYSELECTNATIVE="select "+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".id,"+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".version_row,"+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".id_anio,"+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".id_mes,"+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME+".id_sub_grupo_activo_fijo from "+ProcesarCalcularDepreciacionesConstantesFunciones.SCHEMA+"."+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME;//+" as "+ProcesarCalcularDepreciacionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDDETALLEGRUPOACTIVOFIJO= "id_detalle_grupo_activo_fijo";
    public static final String IDSUBGRUPOACTIVOFIJO= "id_sub_grupo_activo_fijo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO= "Detalle Grupo Activo Fijo";
		public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO_LOWER= "Detalle Grupo Activo Fijo";
    	public static final String LABEL_IDSUBGRUPOACTIVOFIJO= "Sub Grupo Activo Fijo";
		public static final String LABEL_IDSUBGRUPOACTIVOFIJO_LOWER= "Sub Grupo Activo Fijo";
	
		
		
		
		
		
		
	
	public static String getProcesarCalcularDepreciacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO)) {sLabelColumna=ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDMES)) {sLabelColumna=ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {sLabelColumna=ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO;}
		if(sNombreColumna.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {sLabelColumna=ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProcesarCalcularDepreciacionesDescripcion(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesarcalculardepreciaciones !=null/* && procesarcalculardepreciaciones.getId()!=0*/) {
			if(procesarcalculardepreciaciones.getId()!=null) {
				sDescripcion=procesarcalculardepreciaciones.getId().toString();
			}//procesarcalculardepreciacionesprocesarcalculardepreciaciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesarCalcularDepreciacionesDescripcionDetallado(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones) {
		String sDescripcion="";
			
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.ID+"=";
		sDescripcion+=procesarcalculardepreciaciones.getId().toString()+",";
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesarcalculardepreciaciones.getVersionRow().toString()+",";
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesarcalculardepreciaciones.getid_anio().toString()+",";
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.IDMES+"=";
		sDescripcion+=procesarcalculardepreciaciones.getid_mes().toString()+",";
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO+"=";
		sDescripcion+=procesarcalculardepreciaciones.getid_detalle_grupo_activo_fijo().toString()+",";
		sDescripcion+=ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO+"=";
		sDescripcion+=procesarcalculardepreciaciones.getid_sub_grupo_activo_fijo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesarCalcularDepreciacionesDescripcion(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,String sValor) throws Exception {			
		if(procesarcalculardepreciaciones !=null) {
			//procesarcalculardepreciacionesprocesarcalculardepreciaciones.getId().toString();
		}		
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

	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallegrupoactivofijo!=null/*&&detallegrupoactivofijo.getId()>0*/) {
			sDescripcion=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detallegrupoactivofijo);
		}

		return sDescripcion;
	}

	public static String getSubGrupoActivoFijoDescripcion(SubGrupoActivoFijo subgrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subgrupoactivofijo!=null/*&&subgrupoactivofijo.getId()>0*/) {
			sDescripcion=SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(subgrupoactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesarCalcularDepreciaciones")) {
			sNombreIndice="Tipo=  Por Anio Por Mes Por Detalle Grupo Activo Fijo Por Sub Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdDetalleGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdSubGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Sub Grupo Activo Fijo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesarCalcularDepreciaciones(Long id_anio,Long id_mes,Long id_detalle_grupo_activo_fijo,Long id_sub_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();}
		if(id_sub_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Sub Grupo Activo Fijo="+id_sub_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleGrupoActivoFijo(Long id_detalle_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubGrupoActivoFijo(Long id_sub_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Sub Grupo Activo Fijo="+id_sub_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesarcalculardepreciaciones.getConCambioAuxiliar()) {
			procesarcalculardepreciaciones.setIsDeleted(procesarcalculardepreciaciones.getIsDeletedAuxiliar());	
			procesarcalculardepreciaciones.setIsNew(procesarcalculardepreciaciones.getIsNewAuxiliar());	
			procesarcalculardepreciaciones.setIsChanged(procesarcalculardepreciaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesarcalculardepreciaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesarcalculardepreciaciones.setIsDeletedAuxiliar(false);	
			procesarcalculardepreciaciones.setIsNewAuxiliar(false);	
			procesarcalculardepreciaciones.setIsChangedAuxiliar(false);
			
			procesarcalculardepreciaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones : procesarcalculardepreciacioness) {
			if(conAsignarBase && procesarcalculardepreciaciones.getConCambioAuxiliar()) {
				procesarcalculardepreciaciones.setIsDeleted(procesarcalculardepreciaciones.getIsDeletedAuxiliar());	
				procesarcalculardepreciaciones.setIsNew(procesarcalculardepreciaciones.getIsNewAuxiliar());	
				procesarcalculardepreciaciones.setIsChanged(procesarcalculardepreciaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesarcalculardepreciaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesarcalculardepreciaciones.setIsDeletedAuxiliar(false);	
				procesarcalculardepreciaciones.setIsNewAuxiliar(false);	
				procesarcalculardepreciaciones.setIsChangedAuxiliar(false);
				
				procesarcalculardepreciaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesarCalcularDepreciacioness(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,Boolean conEnteros) throws Exception  {
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesarCalcularDepreciaciones(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux) throws Exception  {
		ProcesarCalcularDepreciacionesConstantesFunciones.InicializarValoresProcesarCalcularDepreciaciones(procesarcalculardepreciacionesAux,true);
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {
			if(procesarcalculardepreciaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCalcularDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesarCalcularDepreciacionesConstantesFunciones.getArrayColumnasGlobalesProcesarCalcularDepreciaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarCalcularDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesarCalcularDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux: procesarcalculardepreciacioness) {
			if(procesarcalculardepreciacionesAux!=null && procesarcalculardepreciaciones!=null) {
				if((procesarcalculardepreciacionesAux.getId()==null && procesarcalculardepreciaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesarcalculardepreciacionesAux.getId()!=null && procesarcalculardepreciaciones.getId()!=null){
					if(procesarcalculardepreciacionesAux.getId().equals(procesarcalculardepreciaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarCalcularDepreciaciones(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones: procesarcalculardepreciacioness) {			
			if(procesarcalculardepreciaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesarCalcularDepreciaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesarCalcularDepreciaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCalcularDepreciaciones() throws Exception  {
		return ProcesarCalcularDepreciacionesConstantesFunciones.getTiposSeleccionarProcesarCalcularDepreciaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCalcularDepreciaciones(Boolean conFk) throws Exception  {
		return ProcesarCalcularDepreciacionesConstantesFunciones.getTiposSeleccionarProcesarCalcularDepreciaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarCalcularDepreciaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
			reporte.setsDescripcion(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);
			reporte.setsDescripcion(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesarCalcularDepreciaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux) throws Exception {
		
			procesarcalculardepreciacionesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesarcalculardepreciacionesAux.getAnio()));
			procesarcalculardepreciacionesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesarcalculardepreciacionesAux.getMes()));
			procesarcalculardepreciacionesAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(procesarcalculardepreciacionesAux.getDetalleGrupoActivoFijo()));
			procesarcalculardepreciacionesAux.setsubgrupoactivofijo_descripcion(SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(procesarcalculardepreciacionesAux.getSubGrupoActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarCalcularDepreciaciones(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacionessTemp) throws Exception {
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux:procesarcalculardepreciacionessTemp) {
			
			procesarcalculardepreciacionesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesarcalculardepreciacionesAux.getAnio()));
			procesarcalculardepreciacionesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesarcalculardepreciacionesAux.getMes()));
			procesarcalculardepreciacionesAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(procesarcalculardepreciacionesAux.getDetalleGrupoActivoFijo()));
			procesarcalculardepreciacionesAux.setsubgrupoactivofijo_descripcion(SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(procesarcalculardepreciacionesAux.getSubGrupoActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesarCalcularDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(DetalleGrupoActivoFijo.class));
				classes.add(new Classe(SubGrupoActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubGrupoActivoFijo.class)) {
						classes.add(new Classe(SubGrupoActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesarCalcularDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarCalcularDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarCalcularDepreciacionesConstantesFunciones.getClassesRelationshipsOfProcesarCalcularDepreciaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarCalcularDepreciaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarCalcularDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarCalcularDepreciacionesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesarCalcularDepreciaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarCalcularDepreciaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacioness) throws Exception {
		try	{			
			for(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesLocal:procesarcalculardepreciacioness) {
				if(procesarcalculardepreciacionesLocal.getId().equals(procesarcalculardepreciaciones.getId())) {
					procesarcalculardepreciacionesLocal.setIsSelected(procesarcalculardepreciaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesarCalcularDepreciaciones(List<ProcesarCalcularDepreciaciones> procesarcalculardepreciacionessAux) throws Exception {
		//this.procesarcalculardepreciacionessAux=procesarcalculardepreciacionessAux;
		
		for(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux:procesarcalculardepreciacionessAux) {
			if(procesarcalculardepreciacionesAux.getIsChanged()) {
				procesarcalculardepreciacionesAux.setIsChanged(false);
			}		
			
			if(procesarcalculardepreciacionesAux.getIsNew()) {
				procesarcalculardepreciacionesAux.setIsNew(false);
			}	
			
			if(procesarcalculardepreciacionesAux.getIsDeleted()) {
				procesarcalculardepreciacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAux) throws Exception {
		//this.procesarcalculardepreciacionesAux=procesarcalculardepreciacionesAux;
		
			if(procesarcalculardepreciacionesAux.getIsChanged()) {
				procesarcalculardepreciacionesAux.setIsChanged(false);
			}		
			
			if(procesarcalculardepreciacionesAux.getIsNew()) {
				procesarcalculardepreciacionesAux.setIsNew(false);
			}	
			
			if(procesarcalculardepreciacionesAux.getIsDeleted()) {
				procesarcalculardepreciacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesarCalcularDepreciaciones procesarcalculardepreciacionesAsignar,ProcesarCalcularDepreciaciones procesarcalculardepreciaciones) throws Exception {
		procesarcalculardepreciacionesAsignar.setId(procesarcalculardepreciaciones.getId());	
		procesarcalculardepreciacionesAsignar.setVersionRow(procesarcalculardepreciaciones.getVersionRow());	
		procesarcalculardepreciacionesAsignar.setid_anio(procesarcalculardepreciaciones.getid_anio());
		procesarcalculardepreciacionesAsignar.setanio_descripcion(procesarcalculardepreciaciones.getanio_descripcion());	
		procesarcalculardepreciacionesAsignar.setid_mes(procesarcalculardepreciaciones.getid_mes());
		procesarcalculardepreciacionesAsignar.setmes_descripcion(procesarcalculardepreciaciones.getmes_descripcion());	
		procesarcalculardepreciacionesAsignar.setid_detalle_grupo_activo_fijo(procesarcalculardepreciaciones.getid_detalle_grupo_activo_fijo());
		procesarcalculardepreciacionesAsignar.setdetallegrupoactivofijo_descripcion(procesarcalculardepreciaciones.getdetallegrupoactivofijo_descripcion());	
		procesarcalculardepreciacionesAsignar.setid_sub_grupo_activo_fijo(procesarcalculardepreciaciones.getid_sub_grupo_activo_fijo());
		procesarcalculardepreciacionesAsignar.setsubgrupoactivofijo_descripcion(procesarcalculardepreciaciones.getsubgrupoactivofijo_descripcion());	
	}
	
	public static void inicializarProcesarCalcularDepreciaciones(ProcesarCalcularDepreciaciones procesarcalculardepreciaciones) throws Exception {
		try {
				procesarcalculardepreciaciones.setId(0L);	
					
				procesarcalculardepreciaciones.setid_anio(null);	
				procesarcalculardepreciaciones.setid_mes(null);	
				procesarcalculardepreciaciones.setid_detalle_grupo_activo_fijo(-1L);	
				procesarcalculardepreciaciones.setid_sub_grupo_activo_fijo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesarCalcularDepreciaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarCalcularDepreciacionesConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesarCalcularDepreciaciones(String sTipo,Row row,Workbook workbook,ProcesarCalcularDepreciaciones procesarcalculardepreciaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarcalculardepreciaciones.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarcalculardepreciaciones.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarcalculardepreciaciones.getdetallegrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarcalculardepreciaciones.getsubgrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesarCalcularDepreciaciones="";
	
	public String getsFinalQueryProcesarCalcularDepreciaciones() {
		return this.sFinalQueryProcesarCalcularDepreciaciones;
	}
	
	public void setsFinalQueryProcesarCalcularDepreciaciones(String sFinalQueryProcesarCalcularDepreciaciones) {
		this.sFinalQueryProcesarCalcularDepreciaciones= sFinalQueryProcesarCalcularDepreciaciones;
	}
	
	public Border resaltarSeleccionarProcesarCalcularDepreciaciones=null;
	
	public Border setResaltarSeleccionarProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesarCalcularDepreciaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesarCalcularDepreciaciones() {
		return this.resaltarSeleccionarProcesarCalcularDepreciaciones;
	}
	
	public void setResaltarSeleccionarProcesarCalcularDepreciaciones(Border borderResaltarSeleccionarProcesarCalcularDepreciaciones) {
		this.resaltarSeleccionarProcesarCalcularDepreciaciones= borderResaltarSeleccionarProcesarCalcularDepreciaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesarCalcularDepreciaciones=null;
	public Boolean mostraridProcesarCalcularDepreciaciones=true;
	public Boolean activaridProcesarCalcularDepreciaciones=true;

	public Border resaltarid_anioProcesarCalcularDepreciaciones=null;
	public Boolean mostrarid_anioProcesarCalcularDepreciaciones=true;
	public Boolean activarid_anioProcesarCalcularDepreciaciones=true;
	public Boolean cargarid_anioProcesarCalcularDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesarCalcularDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_mesProcesarCalcularDepreciaciones=null;
	public Boolean mostrarid_mesProcesarCalcularDepreciaciones=true;
	public Boolean activarid_mesProcesarCalcularDepreciaciones=true;
	public Boolean cargarid_mesProcesarCalcularDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesarCalcularDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones=null;
	public Boolean mostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones=true;
	public Boolean activarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones=true;
	public Boolean cargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones=false;//ConEventDepend=true

	public Border resaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones=null;
	public Boolean mostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones=true;
	public Boolean activarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones=true;
	public Boolean cargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones=true;//ConEventDepend=true

	
	

	public Border setResaltaridProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltaridProcesarCalcularDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesarCalcularDepreciaciones() {
		return this.resaltaridProcesarCalcularDepreciaciones;
	}

	public void setResaltaridProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltaridProcesarCalcularDepreciaciones= borderResaltar;
	}

	public Boolean getMostraridProcesarCalcularDepreciaciones() {
		return this.mostraridProcesarCalcularDepreciaciones;
	}

	public void setMostraridProcesarCalcularDepreciaciones(Boolean mostraridProcesarCalcularDepreciaciones) {
		this.mostraridProcesarCalcularDepreciaciones= mostraridProcesarCalcularDepreciaciones;
	}

	public Boolean getActivaridProcesarCalcularDepreciaciones() {
		return this.activaridProcesarCalcularDepreciaciones;
	}

	public void setActivaridProcesarCalcularDepreciaciones(Boolean activaridProcesarCalcularDepreciaciones) {
		this.activaridProcesarCalcularDepreciaciones= activaridProcesarCalcularDepreciaciones;
	}

	public Border setResaltarid_anioProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesarCalcularDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesarCalcularDepreciaciones() {
		return this.resaltarid_anioProcesarCalcularDepreciaciones;
	}

	public void setResaltarid_anioProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltarid_anioProcesarCalcularDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesarCalcularDepreciaciones() {
		return this.mostrarid_anioProcesarCalcularDepreciaciones;
	}

	public void setMostrarid_anioProcesarCalcularDepreciaciones(Boolean mostrarid_anioProcesarCalcularDepreciaciones) {
		this.mostrarid_anioProcesarCalcularDepreciaciones= mostrarid_anioProcesarCalcularDepreciaciones;
	}

	public Boolean getActivarid_anioProcesarCalcularDepreciaciones() {
		return this.activarid_anioProcesarCalcularDepreciaciones;
	}

	public void setActivarid_anioProcesarCalcularDepreciaciones(Boolean activarid_anioProcesarCalcularDepreciaciones) {
		this.activarid_anioProcesarCalcularDepreciaciones= activarid_anioProcesarCalcularDepreciaciones;
	}

	public Boolean getCargarid_anioProcesarCalcularDepreciaciones() {
		return this.cargarid_anioProcesarCalcularDepreciaciones;
	}

	public void setCargarid_anioProcesarCalcularDepreciaciones(Boolean cargarid_anioProcesarCalcularDepreciaciones) {
		this.cargarid_anioProcesarCalcularDepreciaciones= cargarid_anioProcesarCalcularDepreciaciones;
	}

	public Border setResaltarid_mesProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesarCalcularDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesarCalcularDepreciaciones() {
		return this.resaltarid_mesProcesarCalcularDepreciaciones;
	}

	public void setResaltarid_mesProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltarid_mesProcesarCalcularDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesarCalcularDepreciaciones() {
		return this.mostrarid_mesProcesarCalcularDepreciaciones;
	}

	public void setMostrarid_mesProcesarCalcularDepreciaciones(Boolean mostrarid_mesProcesarCalcularDepreciaciones) {
		this.mostrarid_mesProcesarCalcularDepreciaciones= mostrarid_mesProcesarCalcularDepreciaciones;
	}

	public Boolean getActivarid_mesProcesarCalcularDepreciaciones() {
		return this.activarid_mesProcesarCalcularDepreciaciones;
	}

	public void setActivarid_mesProcesarCalcularDepreciaciones(Boolean activarid_mesProcesarCalcularDepreciaciones) {
		this.activarid_mesProcesarCalcularDepreciaciones= activarid_mesProcesarCalcularDepreciaciones;
	}

	public Boolean getCargarid_mesProcesarCalcularDepreciaciones() {
		return this.cargarid_mesProcesarCalcularDepreciaciones;
	}

	public void setCargarid_mesProcesarCalcularDepreciaciones(Boolean cargarid_mesProcesarCalcularDepreciaciones) {
		this.cargarid_mesProcesarCalcularDepreciaciones= cargarid_mesProcesarCalcularDepreciaciones;
	}

	public Border setResaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.resaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setResaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.mostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setMostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean mostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.mostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones= mostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public Boolean getActivarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.activarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setActivarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean activarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.activarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones= activarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public Boolean getCargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.cargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setCargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean cargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.cargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones= cargarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public Border setResaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarcalculardepreciacionesBeanSwingJInternalFrame.jTtoolBarProcesarCalcularDepreciaciones.setBorder(borderResaltar);
		
		this.resaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.resaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setResaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones= borderResaltar;
	}

	public Boolean getMostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.mostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setMostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean mostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.mostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones= mostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public Boolean getActivarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.activarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setActivarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean activarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.activarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones= activarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public Boolean getCargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones() {
		return this.cargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
	}

	public void setCargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(Boolean cargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones) {
		this.cargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones= cargarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones;
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
		
		
		this.setMostraridProcesarCalcularDepreciaciones(esInicial);
		this.setMostrarid_anioProcesarCalcularDepreciaciones(esInicial);
		this.setMostrarid_mesProcesarCalcularDepreciaciones(esInicial);
		this.setMostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);
		this.setMostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.ID)) {
				this.setMostraridProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setMostrarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setMostrarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
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
		
		
		this.setActivaridProcesarCalcularDepreciaciones(esInicial);
		this.setActivarid_anioProcesarCalcularDepreciaciones(esInicial);
		this.setActivarid_mesProcesarCalcularDepreciaciones(esInicial);
		this.setActivarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);
		this.setActivarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.ID)) {
				this.setActivaridProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setActivarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setActivarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesarCalcularDepreciaciones(esInicial);
		this.setResaltarid_anioProcesarCalcularDepreciaciones(esInicial);
		this.setResaltarid_mesProcesarCalcularDepreciaciones(esInicial);
		this.setResaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);
		this.setResaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.ID)) {
				this.setResaltaridProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setResaltarid_detalle_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarCalcularDepreciacionesConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setResaltarid_sub_grupo_activo_fijoProcesarCalcularDepreciaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones=true;

	public Boolean getMostrarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones() {
		return this.mostrarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones;
	}

	public void setMostrarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones=true;

	public Boolean getActivarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones() {
		return this.activarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones;
	}

	public void setActivarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones(Boolean habilitarResaltar) {
		this.activarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones=null;

	public Border getResaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones() {
		return this.resaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones;
	}

	public void setResaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones(Border borderResaltar) {
		this.resaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones= borderResaltar;
	}

	public void setResaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarCalcularDepreciacionesBeanSwingJInternalFrame procesarcalculardepreciacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesarCalcularDepreciacionesProcesarCalcularDepreciaciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}