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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoIessAportesConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoIessAportesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessAportesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoIessAportesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoIessAportes";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoIessAportes"+ProcesoIessAportesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoIessAportesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoIessAportesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoIessAportesConstantesFunciones.SCHEMA+"_"+ProcesoIessAportesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessAportesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoIessAportesConstantesFunciones.SCHEMA+"_"+ProcesoIessAportesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoIessAportesConstantesFunciones.SCHEMA+"_"+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessAportesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoIessAportesConstantesFunciones.SCHEMA+"_"+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessAportesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessAportesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessAportesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoIessAportesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoIessAportesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoIessAportesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoIessAportesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Iess Aporteses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Iess Aportes";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Iess Aportes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoIessAportes";
	public static final String OBJECTNAME="procesoiessaportes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_iess_aportes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoiessaportes from "+ProcesoIessAportesConstantesFunciones.SPERSISTENCENAME+" procesoiessaportes";
	public static String QUERYSELECTNATIVE="select "+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".id,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".version_row,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".id_anio,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".id_mes,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".id_tipo_afiliacion,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".id_numero_patronal,"+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME+".porcentaje from "+ProcesoIessAportesConstantesFunciones.SCHEMA+"."+ProcesoIessAportesConstantesFunciones.TABLENAME;//+" as "+ProcesoIessAportesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDTIPOAFILIACION= "id_tipo_afiliacion";
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDTIPOAFILIACION= "Tipo Afiliacion";
		public static final String LABEL_IDTIPOAFILIACION_LOWER= "Tipo Afiliacion";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
	
	public static String getProcesoIessAportesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoIessAportesConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoIessAportesConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesoIessAportesConstantesFunciones.IDMES)) {sLabelColumna=ProcesoIessAportesConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION)) {sLabelColumna=ProcesoIessAportesConstantesFunciones.LABEL_IDTIPOAFILIACION;}
		if(sNombreColumna.equals(ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=ProcesoIessAportesConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		if(sNombreColumna.equals(ProcesoIessAportesConstantesFunciones.PORCENTAJE)) {sLabelColumna=ProcesoIessAportesConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getProcesoIessAportesDescripcion(ProcesoIessAportes procesoiessaportes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoiessaportes !=null/* && procesoiessaportes.getId()!=0*/) {
			if(procesoiessaportes.getId()!=null) {
				sDescripcion=procesoiessaportes.getId().toString();
			}//procesoiessaportesprocesoiessaportes.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoIessAportesDescripcionDetallado(ProcesoIessAportes procesoiessaportes) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoIessAportesConstantesFunciones.ID+"=";
		sDescripcion+=procesoiessaportes.getId().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoiessaportes.getVersionRow().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesoiessaportes.getid_anio().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.IDMES+"=";
		sDescripcion+=procesoiessaportes.getid_mes().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION+"=";
		sDescripcion+=procesoiessaportes.getid_tipo_afiliacion().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=procesoiessaportes.getid_numero_patronal().toString()+",";
		sDescripcion+=ProcesoIessAportesConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=procesoiessaportes.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoIessAportesDescripcion(ProcesoIessAportes procesoiessaportes,String sValor) throws Exception {			
		if(procesoiessaportes !=null) {
			//procesoiessaportesprocesoiessaportes.getId().toString();
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

	public static String getTipoAfiliacionDescripcion(TipoAfiliacion tipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoafiliacion!=null/*&&tipoafiliacion.getId()>0*/) {
			sDescripcion=TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(tipoafiliacion);
		}

		return sDescripcion;
	}

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoIessAportes")) {
			sNombreIndice="Tipo=  Por Anio Por Mes Por Tipo Afiliacion Por Numero Patronal Por Porcentaje";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdTipoAfiliacion")) {
			sNombreIndice="Tipo=  Por Tipo Afiliacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoIessAportes(Long id_anio,Long id_mes,Long id_tipo_afiliacion,Long id_numero_patronal,Double porcentaje) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_tipo_afiliacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Afiliacion="+id_tipo_afiliacion.toString();}
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();}
		if(porcentaje!=null) {sDetalleIndice+=" Porcentaje="+porcentaje.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNumeroPatronal(Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoAfiliacion(Long id_tipo_afiliacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_afiliacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Afiliacion="+id_tipo_afiliacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoIessAportes(ProcesoIessAportes procesoiessaportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoIessAportess(List<ProcesoIessAportes> procesoiessaportess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoIessAportes procesoiessaportes: procesoiessaportess) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessAportes(ProcesoIessAportes procesoiessaportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoiessaportes.getConCambioAuxiliar()) {
			procesoiessaportes.setIsDeleted(procesoiessaportes.getIsDeletedAuxiliar());	
			procesoiessaportes.setIsNew(procesoiessaportes.getIsNewAuxiliar());	
			procesoiessaportes.setIsChanged(procesoiessaportes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoiessaportes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoiessaportes.setIsDeletedAuxiliar(false);	
			procesoiessaportes.setIsNewAuxiliar(false);	
			procesoiessaportes.setIsChangedAuxiliar(false);
			
			procesoiessaportes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessAportess(List<ProcesoIessAportes> procesoiessaportess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoIessAportes procesoiessaportes : procesoiessaportess) {
			if(conAsignarBase && procesoiessaportes.getConCambioAuxiliar()) {
				procesoiessaportes.setIsDeleted(procesoiessaportes.getIsDeletedAuxiliar());	
				procesoiessaportes.setIsNew(procesoiessaportes.getIsNewAuxiliar());	
				procesoiessaportes.setIsChanged(procesoiessaportes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoiessaportes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoiessaportes.setIsDeletedAuxiliar(false);	
				procesoiessaportes.setIsNewAuxiliar(false);	
				procesoiessaportes.setIsChangedAuxiliar(false);
				
				procesoiessaportes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoIessAportes(ProcesoIessAportes procesoiessaportes,Boolean conEnteros) throws Exception  {
		procesoiessaportes.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoIessAportess(List<ProcesoIessAportes> procesoiessaportess,Boolean conEnteros) throws Exception  {
		
		for(ProcesoIessAportes procesoiessaportes: procesoiessaportess) {
			procesoiessaportes.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoIessAportes(List<ProcesoIessAportes> procesoiessaportess,ProcesoIessAportes procesoiessaportesAux) throws Exception  {
		ProcesoIessAportesConstantesFunciones.InicializarValoresProcesoIessAportes(procesoiessaportesAux,true);
		
		for(ProcesoIessAportes procesoiessaportes: procesoiessaportess) {
			if(procesoiessaportes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesoiessaportesAux.setporcentaje(procesoiessaportesAux.getporcentaje()+procesoiessaportes.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessAportes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoIessAportesConstantesFunciones.getArrayColumnasGlobalesProcesoIessAportes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessAportes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoIessAportes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoIessAportes> procesoiessaportess,ProcesoIessAportes procesoiessaportes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoIessAportes procesoiessaportesAux: procesoiessaportess) {
			if(procesoiessaportesAux!=null && procesoiessaportes!=null) {
				if((procesoiessaportesAux.getId()==null && procesoiessaportes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoiessaportesAux.getId()!=null && procesoiessaportes.getId()!=null){
					if(procesoiessaportesAux.getId().equals(procesoiessaportes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoIessAportes(List<ProcesoIessAportes> procesoiessaportess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ProcesoIessAportes procesoiessaportes: procesoiessaportess) {			
			if(procesoiessaportes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=procesoiessaportes.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoIessAportesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoIessAportes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoIessAportes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessAportes() throws Exception  {
		return ProcesoIessAportesConstantesFunciones.getTiposSeleccionarProcesoIessAportes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessAportes(Boolean conFk) throws Exception  {
		return ProcesoIessAportesConstantesFunciones.getTiposSeleccionarProcesoIessAportes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessAportes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessAportesConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessAportesConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessAportesConstantesFunciones.LABEL_IDTIPOAFILIACION);
			reporte.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_IDTIPOAFILIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessAportesConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessAportesConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ProcesoIessAportesConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoIessAportes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessAportes(ProcesoIessAportes procesoiessaportesAux) throws Exception {
		
			procesoiessaportesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessaportesAux.getAnio()));
			procesoiessaportesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesoiessaportesAux.getMes()));
			procesoiessaportesAux.settipoafiliacion_descripcion(TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(procesoiessaportesAux.getTipoAfiliacion()));
			procesoiessaportesAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessaportesAux.getNumeroPatronal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessAportes(List<ProcesoIessAportes> procesoiessaportessTemp) throws Exception {
		for(ProcesoIessAportes procesoiessaportesAux:procesoiessaportessTemp) {
			
			procesoiessaportesAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessaportesAux.getAnio()));
			procesoiessaportesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesoiessaportesAux.getMes()));
			procesoiessaportesAux.settipoafiliacion_descripcion(TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(procesoiessaportesAux.getTipoAfiliacion()));
			procesoiessaportesAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessaportesAux.getNumeroPatronal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoIessAportes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(TipoAfiliacion.class));
				classes.add(new Classe(NumeroPatronal.class));
				
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
					if(clas.clas.equals(TipoAfiliacion.class)) {
						classes.add(new Classe(TipoAfiliacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoIessAportes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
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

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessAportes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessAportesConstantesFunciones.getClassesRelationshipsOfProcesoIessAportes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessAportes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessAportes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessAportesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoIessAportes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessAportes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoIessAportes procesoiessaportes,List<ProcesoIessAportes> procesoiessaportess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoIessAportes procesoiessaportes,List<ProcesoIessAportes> procesoiessaportess) throws Exception {
		try	{			
			for(ProcesoIessAportes procesoiessaportesLocal:procesoiessaportess) {
				if(procesoiessaportesLocal.getId().equals(procesoiessaportes.getId())) {
					procesoiessaportesLocal.setIsSelected(procesoiessaportes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoIessAportes(List<ProcesoIessAportes> procesoiessaportessAux) throws Exception {
		//this.procesoiessaportessAux=procesoiessaportessAux;
		
		for(ProcesoIessAportes procesoiessaportesAux:procesoiessaportessAux) {
			if(procesoiessaportesAux.getIsChanged()) {
				procesoiessaportesAux.setIsChanged(false);
			}		
			
			if(procesoiessaportesAux.getIsNew()) {
				procesoiessaportesAux.setIsNew(false);
			}	
			
			if(procesoiessaportesAux.getIsDeleted()) {
				procesoiessaportesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoIessAportes(ProcesoIessAportes procesoiessaportesAux) throws Exception {
		//this.procesoiessaportesAux=procesoiessaportesAux;
		
			if(procesoiessaportesAux.getIsChanged()) {
				procesoiessaportesAux.setIsChanged(false);
			}		
			
			if(procesoiessaportesAux.getIsNew()) {
				procesoiessaportesAux.setIsNew(false);
			}	
			
			if(procesoiessaportesAux.getIsDeleted()) {
				procesoiessaportesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoIessAportes procesoiessaportesAsignar,ProcesoIessAportes procesoiessaportes) throws Exception {
		procesoiessaportesAsignar.setId(procesoiessaportes.getId());	
		procesoiessaportesAsignar.setVersionRow(procesoiessaportes.getVersionRow());	
		procesoiessaportesAsignar.setid_anio(procesoiessaportes.getid_anio());
		procesoiessaportesAsignar.setanio_descripcion(procesoiessaportes.getanio_descripcion());	
		procesoiessaportesAsignar.setid_mes(procesoiessaportes.getid_mes());
		procesoiessaportesAsignar.setmes_descripcion(procesoiessaportes.getmes_descripcion());	
		procesoiessaportesAsignar.setid_tipo_afiliacion(procesoiessaportes.getid_tipo_afiliacion());
		procesoiessaportesAsignar.settipoafiliacion_descripcion(procesoiessaportes.gettipoafiliacion_descripcion());	
		procesoiessaportesAsignar.setid_numero_patronal(procesoiessaportes.getid_numero_patronal());
		procesoiessaportesAsignar.setnumeropatronal_descripcion(procesoiessaportes.getnumeropatronal_descripcion());	
		procesoiessaportesAsignar.setporcentaje(procesoiessaportes.getporcentaje());	
	}
	
	public static void inicializarProcesoIessAportes(ProcesoIessAportes procesoiessaportes) throws Exception {
		try {
				procesoiessaportes.setId(0L);	
					
				procesoiessaportes.setid_anio(null);	
				procesoiessaportes.setid_mes(null);	
				procesoiessaportes.setid_tipo_afiliacion(-1L);	
				procesoiessaportes.setid_numero_patronal(-1L);	
				procesoiessaportes.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoIessAportes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessAportesConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessAportesConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessAportesConstantesFunciones.LABEL_IDTIPOAFILIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessAportesConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessAportesConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoIessAportes(String sTipo,Row row,Workbook workbook,ProcesoIessAportes procesoiessaportes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessaportes.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessaportes.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessaportes.gettipoafiliacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessaportes.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessaportes.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoIessAportes="";
	
	public String getsFinalQueryProcesoIessAportes() {
		return this.sFinalQueryProcesoIessAportes;
	}
	
	public void setsFinalQueryProcesoIessAportes(String sFinalQueryProcesoIessAportes) {
		this.sFinalQueryProcesoIessAportes= sFinalQueryProcesoIessAportes;
	}
	
	public Border resaltarSeleccionarProcesoIessAportes=null;
	
	public Border setResaltarSeleccionarProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoIessAportes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoIessAportes() {
		return this.resaltarSeleccionarProcesoIessAportes;
	}
	
	public void setResaltarSeleccionarProcesoIessAportes(Border borderResaltarSeleccionarProcesoIessAportes) {
		this.resaltarSeleccionarProcesoIessAportes= borderResaltarSeleccionarProcesoIessAportes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoIessAportes=null;
	public Boolean mostraridProcesoIessAportes=true;
	public Boolean activaridProcesoIessAportes=true;

	public Border resaltarid_anioProcesoIessAportes=null;
	public Boolean mostrarid_anioProcesoIessAportes=true;
	public Boolean activarid_anioProcesoIessAportes=true;
	public Boolean cargarid_anioProcesoIessAportes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoIessAportes=false;//ConEventDepend=true

	public Border resaltarid_mesProcesoIessAportes=null;
	public Boolean mostrarid_mesProcesoIessAportes=true;
	public Boolean activarid_mesProcesoIessAportes=true;
	public Boolean cargarid_mesProcesoIessAportes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesoIessAportes=false;//ConEventDepend=true

	public Border resaltarid_tipo_afiliacionProcesoIessAportes=null;
	public Boolean mostrarid_tipo_afiliacionProcesoIessAportes=true;
	public Boolean activarid_tipo_afiliacionProcesoIessAportes=true;
	public Boolean cargarid_tipo_afiliacionProcesoIessAportes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_afiliacionProcesoIessAportes=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalProcesoIessAportes=null;
	public Boolean mostrarid_numero_patronalProcesoIessAportes=true;
	public Boolean activarid_numero_patronalProcesoIessAportes=true;
	public Boolean cargarid_numero_patronalProcesoIessAportes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalProcesoIessAportes=false;//ConEventDepend=true

	public Border resaltarporcentajeProcesoIessAportes=null;
	public Boolean mostrarporcentajeProcesoIessAportes=true;
	public Boolean activarporcentajeProcesoIessAportes=true;

	
	

	public Border setResaltaridProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltaridProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoIessAportes() {
		return this.resaltaridProcesoIessAportes;
	}

	public void setResaltaridProcesoIessAportes(Border borderResaltar) {
		this.resaltaridProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostraridProcesoIessAportes() {
		return this.mostraridProcesoIessAportes;
	}

	public void setMostraridProcesoIessAportes(Boolean mostraridProcesoIessAportes) {
		this.mostraridProcesoIessAportes= mostraridProcesoIessAportes;
	}

	public Boolean getActivaridProcesoIessAportes() {
		return this.activaridProcesoIessAportes;
	}

	public void setActivaridProcesoIessAportes(Boolean activaridProcesoIessAportes) {
		this.activaridProcesoIessAportes= activaridProcesoIessAportes;
	}

	public Border setResaltarid_anioProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoIessAportes() {
		return this.resaltarid_anioProcesoIessAportes;
	}

	public void setResaltarid_anioProcesoIessAportes(Border borderResaltar) {
		this.resaltarid_anioProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoIessAportes() {
		return this.mostrarid_anioProcesoIessAportes;
	}

	public void setMostrarid_anioProcesoIessAportes(Boolean mostrarid_anioProcesoIessAportes) {
		this.mostrarid_anioProcesoIessAportes= mostrarid_anioProcesoIessAportes;
	}

	public Boolean getActivarid_anioProcesoIessAportes() {
		return this.activarid_anioProcesoIessAportes;
	}

	public void setActivarid_anioProcesoIessAportes(Boolean activarid_anioProcesoIessAportes) {
		this.activarid_anioProcesoIessAportes= activarid_anioProcesoIessAportes;
	}

	public Boolean getCargarid_anioProcesoIessAportes() {
		return this.cargarid_anioProcesoIessAportes;
	}

	public void setCargarid_anioProcesoIessAportes(Boolean cargarid_anioProcesoIessAportes) {
		this.cargarid_anioProcesoIessAportes= cargarid_anioProcesoIessAportes;
	}

	public Border setResaltarid_mesProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesoIessAportes() {
		return this.resaltarid_mesProcesoIessAportes;
	}

	public void setResaltarid_mesProcesoIessAportes(Border borderResaltar) {
		this.resaltarid_mesProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesoIessAportes() {
		return this.mostrarid_mesProcesoIessAportes;
	}

	public void setMostrarid_mesProcesoIessAportes(Boolean mostrarid_mesProcesoIessAportes) {
		this.mostrarid_mesProcesoIessAportes= mostrarid_mesProcesoIessAportes;
	}

	public Boolean getActivarid_mesProcesoIessAportes() {
		return this.activarid_mesProcesoIessAportes;
	}

	public void setActivarid_mesProcesoIessAportes(Boolean activarid_mesProcesoIessAportes) {
		this.activarid_mesProcesoIessAportes= activarid_mesProcesoIessAportes;
	}

	public Boolean getCargarid_mesProcesoIessAportes() {
		return this.cargarid_mesProcesoIessAportes;
	}

	public void setCargarid_mesProcesoIessAportes(Boolean cargarid_mesProcesoIessAportes) {
		this.cargarid_mesProcesoIessAportes= cargarid_mesProcesoIessAportes;
	}

	public Border setResaltarid_tipo_afiliacionProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarid_tipo_afiliacionProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_afiliacionProcesoIessAportes() {
		return this.resaltarid_tipo_afiliacionProcesoIessAportes;
	}

	public void setResaltarid_tipo_afiliacionProcesoIessAportes(Border borderResaltar) {
		this.resaltarid_tipo_afiliacionProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostrarid_tipo_afiliacionProcesoIessAportes() {
		return this.mostrarid_tipo_afiliacionProcesoIessAportes;
	}

	public void setMostrarid_tipo_afiliacionProcesoIessAportes(Boolean mostrarid_tipo_afiliacionProcesoIessAportes) {
		this.mostrarid_tipo_afiliacionProcesoIessAportes= mostrarid_tipo_afiliacionProcesoIessAportes;
	}

	public Boolean getActivarid_tipo_afiliacionProcesoIessAportes() {
		return this.activarid_tipo_afiliacionProcesoIessAportes;
	}

	public void setActivarid_tipo_afiliacionProcesoIessAportes(Boolean activarid_tipo_afiliacionProcesoIessAportes) {
		this.activarid_tipo_afiliacionProcesoIessAportes= activarid_tipo_afiliacionProcesoIessAportes;
	}

	public Boolean getCargarid_tipo_afiliacionProcesoIessAportes() {
		return this.cargarid_tipo_afiliacionProcesoIessAportes;
	}

	public void setCargarid_tipo_afiliacionProcesoIessAportes(Boolean cargarid_tipo_afiliacionProcesoIessAportes) {
		this.cargarid_tipo_afiliacionProcesoIessAportes= cargarid_tipo_afiliacionProcesoIessAportes;
	}

	public Border setResaltarid_numero_patronalProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalProcesoIessAportes() {
		return this.resaltarid_numero_patronalProcesoIessAportes;
	}

	public void setResaltarid_numero_patronalProcesoIessAportes(Border borderResaltar) {
		this.resaltarid_numero_patronalProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalProcesoIessAportes() {
		return this.mostrarid_numero_patronalProcesoIessAportes;
	}

	public void setMostrarid_numero_patronalProcesoIessAportes(Boolean mostrarid_numero_patronalProcesoIessAportes) {
		this.mostrarid_numero_patronalProcesoIessAportes= mostrarid_numero_patronalProcesoIessAportes;
	}

	public Boolean getActivarid_numero_patronalProcesoIessAportes() {
		return this.activarid_numero_patronalProcesoIessAportes;
	}

	public void setActivarid_numero_patronalProcesoIessAportes(Boolean activarid_numero_patronalProcesoIessAportes) {
		this.activarid_numero_patronalProcesoIessAportes= activarid_numero_patronalProcesoIessAportes;
	}

	public Boolean getCargarid_numero_patronalProcesoIessAportes() {
		return this.cargarid_numero_patronalProcesoIessAportes;
	}

	public void setCargarid_numero_patronalProcesoIessAportes(Boolean cargarid_numero_patronalProcesoIessAportes) {
		this.cargarid_numero_patronalProcesoIessAportes= cargarid_numero_patronalProcesoIessAportes;
	}

	public Border setResaltarporcentajeProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessaportesBeanSwingJInternalFrame.jTtoolBarProcesoIessAportes.setBorder(borderResaltar);
		
		this.resaltarporcentajeProcesoIessAportes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeProcesoIessAportes() {
		return this.resaltarporcentajeProcesoIessAportes;
	}

	public void setResaltarporcentajeProcesoIessAportes(Border borderResaltar) {
		this.resaltarporcentajeProcesoIessAportes= borderResaltar;
	}

	public Boolean getMostrarporcentajeProcesoIessAportes() {
		return this.mostrarporcentajeProcesoIessAportes;
	}

	public void setMostrarporcentajeProcesoIessAportes(Boolean mostrarporcentajeProcesoIessAportes) {
		this.mostrarporcentajeProcesoIessAportes= mostrarporcentajeProcesoIessAportes;
	}

	public Boolean getActivarporcentajeProcesoIessAportes() {
		return this.activarporcentajeProcesoIessAportes;
	}

	public void setActivarporcentajeProcesoIessAportes(Boolean activarporcentajeProcesoIessAportes) {
		this.activarporcentajeProcesoIessAportes= activarporcentajeProcesoIessAportes;
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
		
		
		this.setMostraridProcesoIessAportes(esInicial);
		this.setMostrarid_anioProcesoIessAportes(esInicial);
		this.setMostrarid_mesProcesoIessAportes(esInicial);
		this.setMostrarid_tipo_afiliacionProcesoIessAportes(esInicial);
		this.setMostrarid_numero_patronalProcesoIessAportes(esInicial);
		this.setMostrarporcentajeProcesoIessAportes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.ID)) {
				this.setMostraridProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION)) {
				this.setMostrarid_tipo_afiliacionProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeProcesoIessAportes(esAsigna);
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
		
		
		this.setActivaridProcesoIessAportes(esInicial);
		this.setActivarid_anioProcesoIessAportes(esInicial);
		this.setActivarid_mesProcesoIessAportes(esInicial);
		this.setActivarid_tipo_afiliacionProcesoIessAportes(esInicial);
		this.setActivarid_numero_patronalProcesoIessAportes(esInicial);
		this.setActivarporcentajeProcesoIessAportes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.ID)) {
				this.setActivaridProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION)) {
				this.setActivarid_tipo_afiliacionProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeProcesoIessAportes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoIessAportes(esInicial);
		this.setResaltarid_anioProcesoIessAportes(esInicial);
		this.setResaltarid_mesProcesoIessAportes(esInicial);
		this.setResaltarid_tipo_afiliacionProcesoIessAportes(esInicial);
		this.setResaltarid_numero_patronalProcesoIessAportes(esInicial);
		this.setResaltarporcentajeProcesoIessAportes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.ID)) {
				this.setResaltaridProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDTIPOAFILIACION)) {
				this.setResaltarid_tipo_afiliacionProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalProcesoIessAportes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessAportesConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeProcesoIessAportes(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoIessAportesProcesoIessAportes=true;

	public Boolean getMostrarBusquedaProcesoIessAportesProcesoIessAportes() {
		return this.mostrarBusquedaProcesoIessAportesProcesoIessAportes;
	}

	public void setMostrarBusquedaProcesoIessAportesProcesoIessAportes(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoIessAportesProcesoIessAportes= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoIessAportesProcesoIessAportes=true;

	public Boolean getActivarBusquedaProcesoIessAportesProcesoIessAportes() {
		return this.activarBusquedaProcesoIessAportesProcesoIessAportes;
	}

	public void setActivarBusquedaProcesoIessAportesProcesoIessAportes(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoIessAportesProcesoIessAportes= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoIessAportesProcesoIessAportes=null;

	public Border getResaltarBusquedaProcesoIessAportesProcesoIessAportes() {
		return this.resaltarBusquedaProcesoIessAportesProcesoIessAportes;
	}

	public void setResaltarBusquedaProcesoIessAportesProcesoIessAportes(Border borderResaltar) {
		this.resaltarBusquedaProcesoIessAportesProcesoIessAportes= borderResaltar;
	}

	public void setResaltarBusquedaProcesoIessAportesProcesoIessAportes(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessAportesBeanSwingJInternalFrame procesoiessaportesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoIessAportesProcesoIessAportes= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}