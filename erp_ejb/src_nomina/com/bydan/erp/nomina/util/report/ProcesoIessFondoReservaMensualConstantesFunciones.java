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

import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaMensualParameterGeneral;

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
final public class ProcesoIessFondoReservaMensualConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoIessFondoReservaMensual";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoIessFondoReservaMensual"+ProcesoIessFondoReservaMensualConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoIessFondoReservaMensualHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoIessFondoReservaMensualHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"_"+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoIessFondoReservaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoIessFondoReservaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoIessFondoReservaMensualConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoIessFondoReservaMensualConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoIessFondoReservaMensualConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoIessFondoReservaMensualConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Iess Fondo Reserva Mensuales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Iess Fondo Reserva Mensual";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Iess Fondo Reserva Mensual";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoIessFondoReservaMensual";
	public static final String OBJECTNAME="procesoiessfondoreservamensual";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_iess_fondo_reserva_mensual";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesoiessfondoreservamensual from "+ProcesoIessFondoReservaMensualConstantesFunciones.SPERSISTENCENAME+" procesoiessfondoreservamensual";
	public static String QUERYSELECTNATIVE="select "+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".id,"+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".version_row,"+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".id_anio,"+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".id_mes,"+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".id_numero_patronal,"+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME+".id_tipo_proceso_nomina from "+ProcesoIessFondoReservaMensualConstantesFunciones.SCHEMA+"."+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME;//+" as "+ProcesoIessFondoReservaMensualConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
    public static final String IDTIPOPROCESONOMINA= "id_tipo_proceso_nomina";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
    	public static final String LABEL_IDTIPOPROCESONOMINA= "Tipo Proceso Nomina";
		public static final String LABEL_IDTIPOPROCESONOMINA_LOWER= "Tipo Proceso Nomina";
	
		
		
		
		
		
		
	
	public static String getProcesoIessFondoReservaMensualLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDMES)) {sLabelColumna=ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		if(sNombreColumna.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA)) {sLabelColumna=ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDTIPOPROCESONOMINA;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProcesoIessFondoReservaMensualDescripcion(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesoiessfondoreservamensual !=null/* && procesoiessfondoreservamensual.getId()!=0*/) {
			if(procesoiessfondoreservamensual.getId()!=null) {
				sDescripcion=procesoiessfondoreservamensual.getId().toString();
			}//procesoiessfondoreservamensualprocesoiessfondoreservamensual.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoIessFondoReservaMensualDescripcionDetallado(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.ID+"=";
		sDescripcion+=procesoiessfondoreservamensual.getId().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesoiessfondoreservamensual.getVersionRow().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesoiessfondoreservamensual.getid_anio().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.IDMES+"=";
		sDescripcion+=procesoiessfondoreservamensual.getid_mes().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=procesoiessfondoreservamensual.getid_numero_patronal().toString()+",";
		sDescripcion+=ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA+"=";
		sDescripcion+=procesoiessfondoreservamensual.getid_tipo_proceso_nomina().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoIessFondoReservaMensualDescripcion(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,String sValor) throws Exception {			
		if(procesoiessfondoreservamensual !=null) {
			//procesoiessfondoreservamensualprocesoiessfondoreservamensual.getId().toString();
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

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}

	public static String getTipoProcesoNominaDescripcion(TipoProcesoNomina tipoprocesonomina) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprocesonomina!=null/*&&tipoprocesonomina.getId()>0*/) {
			sDescripcion=TipoProcesoNominaConstantesFunciones.getTipoProcesoNominaDescripcion(tipoprocesonomina);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoIessFondoReservaMensual")) {
			sNombreIndice="Tipo=  Por Anio Por Mes Por Numero Patronal Por Tipo Proceso Nomina";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdTipoProcesoNomina")) {
			sNombreIndice="Tipo=  Por Tipo Proceso Nomina";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoIessFondoReservaMensual(Long id_anio,Long id_mes,Long id_numero_patronal,Long id_tipo_proceso_nomina) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();}
		if(id_tipo_proceso_nomina!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proceso Nomina="+id_tipo_proceso_nomina.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoProcesoNomina(Long id_tipo_proceso_nomina) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_proceso_nomina!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proceso Nomina="+id_tipo_proceso_nomina.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoIessFondoReservaMensuals(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual: procesoiessfondoreservamensuals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesoiessfondoreservamensual.getConCambioAuxiliar()) {
			procesoiessfondoreservamensual.setIsDeleted(procesoiessfondoreservamensual.getIsDeletedAuxiliar());	
			procesoiessfondoreservamensual.setIsNew(procesoiessfondoreservamensual.getIsNewAuxiliar());	
			procesoiessfondoreservamensual.setIsChanged(procesoiessfondoreservamensual.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesoiessfondoreservamensual.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesoiessfondoreservamensual.setIsDeletedAuxiliar(false);	
			procesoiessfondoreservamensual.setIsNewAuxiliar(false);	
			procesoiessfondoreservamensual.setIsChangedAuxiliar(false);
			
			procesoiessfondoreservamensual.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoIessFondoReservaMensuals(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual : procesoiessfondoreservamensuals) {
			if(conAsignarBase && procesoiessfondoreservamensual.getConCambioAuxiliar()) {
				procesoiessfondoreservamensual.setIsDeleted(procesoiessfondoreservamensual.getIsDeletedAuxiliar());	
				procesoiessfondoreservamensual.setIsNew(procesoiessfondoreservamensual.getIsNewAuxiliar());	
				procesoiessfondoreservamensual.setIsChanged(procesoiessfondoreservamensual.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesoiessfondoreservamensual.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesoiessfondoreservamensual.setIsDeletedAuxiliar(false);	
				procesoiessfondoreservamensual.setIsNewAuxiliar(false);	
				procesoiessfondoreservamensual.setIsChangedAuxiliar(false);
				
				procesoiessfondoreservamensual.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoIessFondoReservaMensuals(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,Boolean conEnteros) throws Exception  {
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual: procesoiessfondoreservamensuals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoIessFondoReservaMensual(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux) throws Exception  {
		ProcesoIessFondoReservaMensualConstantesFunciones.InicializarValoresProcesoIessFondoReservaMensual(procesoiessfondoreservamensualAux,true);
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual: procesoiessfondoreservamensuals) {
			if(procesoiessfondoreservamensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessFondoReservaMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoIessFondoReservaMensualConstantesFunciones.getArrayColumnasGlobalesProcesoIessFondoReservaMensual(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoIessFondoReservaMensual(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoIessFondoReservaMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux: procesoiessfondoreservamensuals) {
			if(procesoiessfondoreservamensualAux!=null && procesoiessfondoreservamensual!=null) {
				if((procesoiessfondoreservamensualAux.getId()==null && procesoiessfondoreservamensual.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesoiessfondoreservamensualAux.getId()!=null && procesoiessfondoreservamensual.getId()!=null){
					if(procesoiessfondoreservamensualAux.getId().equals(procesoiessfondoreservamensual.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoIessFondoReservaMensual(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual: procesoiessfondoreservamensuals) {			
			if(procesoiessfondoreservamensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoIessFondoReservaMensual() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoIessFondoReservaMensual() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReservaMensual() throws Exception  {
		return ProcesoIessFondoReservaMensualConstantesFunciones.getTiposSeleccionarProcesoIessFondoReservaMensual(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReservaMensual(Boolean conFk) throws Exception  {
		return ProcesoIessFondoReservaMensualConstantesFunciones.getTiposSeleccionarProcesoIessFondoReservaMensual(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoIessFondoReservaMensual(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDTIPOPROCESONOMINA);
			reporte.setsDescripcion(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDTIPOPROCESONOMINA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoIessFondoReservaMensual(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux) throws Exception {
		
			procesoiessfondoreservamensualAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessfondoreservamensualAux.getAnio()));
			procesoiessfondoreservamensualAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesoiessfondoreservamensualAux.getMes()));
			procesoiessfondoreservamensualAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessfondoreservamensualAux.getNumeroPatronal()));
			procesoiessfondoreservamensualAux.settipoprocesonomina_descripcion(TipoProcesoNominaConstantesFunciones.getTipoProcesoNominaDescripcion(procesoiessfondoreservamensualAux.getTipoProcesoNomina()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoIessFondoReservaMensual(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensualsTemp) throws Exception {
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux:procesoiessfondoreservamensualsTemp) {
			
			procesoiessfondoreservamensualAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesoiessfondoreservamensualAux.getAnio()));
			procesoiessfondoreservamensualAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesoiessfondoreservamensualAux.getMes()));
			procesoiessfondoreservamensualAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(procesoiessfondoreservamensualAux.getNumeroPatronal()));
			procesoiessfondoreservamensualAux.settipoprocesonomina_descripcion(TipoProcesoNominaConstantesFunciones.getTipoProcesoNominaDescripcion(procesoiessfondoreservamensualAux.getTipoProcesoNomina()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoIessFondoReservaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(TipoProcesoNomina.class));
				
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
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProcesoNomina.class)) {
						classes.add(new Classe(TipoProcesoNomina.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoIessFondoReservaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoProcesoNomina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoNomina.class)); continue;
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

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoProcesoNomina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProcesoNomina.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessFondoReservaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessFondoReservaMensualConstantesFunciones.getClassesRelationshipsOfProcesoIessFondoReservaMensual(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoIessFondoReservaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessFondoReservaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoIessFondoReservaMensualConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoIessFondoReservaMensual(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoIessFondoReservaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensuals) throws Exception {
		try	{			
			for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualLocal:procesoiessfondoreservamensuals) {
				if(procesoiessfondoreservamensualLocal.getId().equals(procesoiessfondoreservamensual.getId())) {
					procesoiessfondoreservamensualLocal.setIsSelected(procesoiessfondoreservamensual.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoIessFondoReservaMensual(List<ProcesoIessFondoReservaMensual> procesoiessfondoreservamensualsAux) throws Exception {
		//this.procesoiessfondoreservamensualsAux=procesoiessfondoreservamensualsAux;
		
		for(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux:procesoiessfondoreservamensualsAux) {
			if(procesoiessfondoreservamensualAux.getIsChanged()) {
				procesoiessfondoreservamensualAux.setIsChanged(false);
			}		
			
			if(procesoiessfondoreservamensualAux.getIsNew()) {
				procesoiessfondoreservamensualAux.setIsNew(false);
			}	
			
			if(procesoiessfondoreservamensualAux.getIsDeleted()) {
				procesoiessfondoreservamensualAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAux) throws Exception {
		//this.procesoiessfondoreservamensualAux=procesoiessfondoreservamensualAux;
		
			if(procesoiessfondoreservamensualAux.getIsChanged()) {
				procesoiessfondoreservamensualAux.setIsChanged(false);
			}		
			
			if(procesoiessfondoreservamensualAux.getIsNew()) {
				procesoiessfondoreservamensualAux.setIsNew(false);
			}	
			
			if(procesoiessfondoreservamensualAux.getIsDeleted()) {
				procesoiessfondoreservamensualAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoIessFondoReservaMensual procesoiessfondoreservamensualAsignar,ProcesoIessFondoReservaMensual procesoiessfondoreservamensual) throws Exception {
		procesoiessfondoreservamensualAsignar.setId(procesoiessfondoreservamensual.getId());	
		procesoiessfondoreservamensualAsignar.setVersionRow(procesoiessfondoreservamensual.getVersionRow());	
		procesoiessfondoreservamensualAsignar.setid_anio(procesoiessfondoreservamensual.getid_anio());
		procesoiessfondoreservamensualAsignar.setanio_descripcion(procesoiessfondoreservamensual.getanio_descripcion());	
		procesoiessfondoreservamensualAsignar.setid_mes(procesoiessfondoreservamensual.getid_mes());
		procesoiessfondoreservamensualAsignar.setmes_descripcion(procesoiessfondoreservamensual.getmes_descripcion());	
		procesoiessfondoreservamensualAsignar.setid_numero_patronal(procesoiessfondoreservamensual.getid_numero_patronal());
		procesoiessfondoreservamensualAsignar.setnumeropatronal_descripcion(procesoiessfondoreservamensual.getnumeropatronal_descripcion());	
		procesoiessfondoreservamensualAsignar.setid_tipo_proceso_nomina(procesoiessfondoreservamensual.getid_tipo_proceso_nomina());
		procesoiessfondoreservamensualAsignar.settipoprocesonomina_descripcion(procesoiessfondoreservamensual.gettipoprocesonomina_descripcion());	
	}
	
	public static void inicializarProcesoIessFondoReservaMensual(ProcesoIessFondoReservaMensual procesoiessfondoreservamensual) throws Exception {
		try {
				procesoiessfondoreservamensual.setId(0L);	
					
				procesoiessfondoreservamensual.setid_anio(null);	
				procesoiessfondoreservamensual.setid_mes(null);	
				procesoiessfondoreservamensual.setid_numero_patronal(-1L);	
				procesoiessfondoreservamensual.setid_tipo_proceso_nomina(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoIessFondoReservaMensual(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoIessFondoReservaMensualConstantesFunciones.LABEL_IDTIPOPROCESONOMINA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoIessFondoReservaMensual(String sTipo,Row row,Workbook workbook,ProcesoIessFondoReservaMensual procesoiessfondoreservamensual,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreservamensual.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreservamensual.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreservamensual.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesoiessfondoreservamensual.gettipoprocesonomina_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoIessFondoReservaMensual="";
	
	public String getsFinalQueryProcesoIessFondoReservaMensual() {
		return this.sFinalQueryProcesoIessFondoReservaMensual;
	}
	
	public void setsFinalQueryProcesoIessFondoReservaMensual(String sFinalQueryProcesoIessFondoReservaMensual) {
		this.sFinalQueryProcesoIessFondoReservaMensual= sFinalQueryProcesoIessFondoReservaMensual;
	}
	
	public Border resaltarSeleccionarProcesoIessFondoReservaMensual=null;
	
	public Border setResaltarSeleccionarProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoIessFondoReservaMensual= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoIessFondoReservaMensual() {
		return this.resaltarSeleccionarProcesoIessFondoReservaMensual;
	}
	
	public void setResaltarSeleccionarProcesoIessFondoReservaMensual(Border borderResaltarSeleccionarProcesoIessFondoReservaMensual) {
		this.resaltarSeleccionarProcesoIessFondoReservaMensual= borderResaltarSeleccionarProcesoIessFondoReservaMensual;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoIessFondoReservaMensual=null;
	public Boolean mostraridProcesoIessFondoReservaMensual=true;
	public Boolean activaridProcesoIessFondoReservaMensual=true;

	public Border resaltarid_anioProcesoIessFondoReservaMensual=null;
	public Boolean mostrarid_anioProcesoIessFondoReservaMensual=true;
	public Boolean activarid_anioProcesoIessFondoReservaMensual=true;
	public Boolean cargarid_anioProcesoIessFondoReservaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoIessFondoReservaMensual=false;//ConEventDepend=true

	public Border resaltarid_mesProcesoIessFondoReservaMensual=null;
	public Boolean mostrarid_mesProcesoIessFondoReservaMensual=true;
	public Boolean activarid_mesProcesoIessFondoReservaMensual=true;
	public Boolean cargarid_mesProcesoIessFondoReservaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesoIessFondoReservaMensual=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalProcesoIessFondoReservaMensual=null;
	public Boolean mostrarid_numero_patronalProcesoIessFondoReservaMensual=true;
	public Boolean activarid_numero_patronalProcesoIessFondoReservaMensual=true;
	public Boolean cargarid_numero_patronalProcesoIessFondoReservaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalProcesoIessFondoReservaMensual=false;//ConEventDepend=true

	public Border resaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual=null;
	public Boolean mostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual=true;
	public Boolean activarid_tipo_proceso_nominaProcesoIessFondoReservaMensual=true;
	public Boolean cargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_proceso_nominaProcesoIessFondoReservaMensual=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltaridProcesoIessFondoReservaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoIessFondoReservaMensual() {
		return this.resaltaridProcesoIessFondoReservaMensual;
	}

	public void setResaltaridProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltaridProcesoIessFondoReservaMensual= borderResaltar;
	}

	public Boolean getMostraridProcesoIessFondoReservaMensual() {
		return this.mostraridProcesoIessFondoReservaMensual;
	}

	public void setMostraridProcesoIessFondoReservaMensual(Boolean mostraridProcesoIessFondoReservaMensual) {
		this.mostraridProcesoIessFondoReservaMensual= mostraridProcesoIessFondoReservaMensual;
	}

	public Boolean getActivaridProcesoIessFondoReservaMensual() {
		return this.activaridProcesoIessFondoReservaMensual;
	}

	public void setActivaridProcesoIessFondoReservaMensual(Boolean activaridProcesoIessFondoReservaMensual) {
		this.activaridProcesoIessFondoReservaMensual= activaridProcesoIessFondoReservaMensual;
	}

	public Border setResaltarid_anioProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoIessFondoReservaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoIessFondoReservaMensual() {
		return this.resaltarid_anioProcesoIessFondoReservaMensual;
	}

	public void setResaltarid_anioProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltarid_anioProcesoIessFondoReservaMensual= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoIessFondoReservaMensual() {
		return this.mostrarid_anioProcesoIessFondoReservaMensual;
	}

	public void setMostrarid_anioProcesoIessFondoReservaMensual(Boolean mostrarid_anioProcesoIessFondoReservaMensual) {
		this.mostrarid_anioProcesoIessFondoReservaMensual= mostrarid_anioProcesoIessFondoReservaMensual;
	}

	public Boolean getActivarid_anioProcesoIessFondoReservaMensual() {
		return this.activarid_anioProcesoIessFondoReservaMensual;
	}

	public void setActivarid_anioProcesoIessFondoReservaMensual(Boolean activarid_anioProcesoIessFondoReservaMensual) {
		this.activarid_anioProcesoIessFondoReservaMensual= activarid_anioProcesoIessFondoReservaMensual;
	}

	public Boolean getCargarid_anioProcesoIessFondoReservaMensual() {
		return this.cargarid_anioProcesoIessFondoReservaMensual;
	}

	public void setCargarid_anioProcesoIessFondoReservaMensual(Boolean cargarid_anioProcesoIessFondoReservaMensual) {
		this.cargarid_anioProcesoIessFondoReservaMensual= cargarid_anioProcesoIessFondoReservaMensual;
	}

	public Border setResaltarid_mesProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesoIessFondoReservaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesoIessFondoReservaMensual() {
		return this.resaltarid_mesProcesoIessFondoReservaMensual;
	}

	public void setResaltarid_mesProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltarid_mesProcesoIessFondoReservaMensual= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesoIessFondoReservaMensual() {
		return this.mostrarid_mesProcesoIessFondoReservaMensual;
	}

	public void setMostrarid_mesProcesoIessFondoReservaMensual(Boolean mostrarid_mesProcesoIessFondoReservaMensual) {
		this.mostrarid_mesProcesoIessFondoReservaMensual= mostrarid_mesProcesoIessFondoReservaMensual;
	}

	public Boolean getActivarid_mesProcesoIessFondoReservaMensual() {
		return this.activarid_mesProcesoIessFondoReservaMensual;
	}

	public void setActivarid_mesProcesoIessFondoReservaMensual(Boolean activarid_mesProcesoIessFondoReservaMensual) {
		this.activarid_mesProcesoIessFondoReservaMensual= activarid_mesProcesoIessFondoReservaMensual;
	}

	public Boolean getCargarid_mesProcesoIessFondoReservaMensual() {
		return this.cargarid_mesProcesoIessFondoReservaMensual;
	}

	public void setCargarid_mesProcesoIessFondoReservaMensual(Boolean cargarid_mesProcesoIessFondoReservaMensual) {
		this.cargarid_mesProcesoIessFondoReservaMensual= cargarid_mesProcesoIessFondoReservaMensual;
	}

	public Border setResaltarid_numero_patronalProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalProcesoIessFondoReservaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalProcesoIessFondoReservaMensual() {
		return this.resaltarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public void setResaltarid_numero_patronalProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltarid_numero_patronalProcesoIessFondoReservaMensual= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalProcesoIessFondoReservaMensual() {
		return this.mostrarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public void setMostrarid_numero_patronalProcesoIessFondoReservaMensual(Boolean mostrarid_numero_patronalProcesoIessFondoReservaMensual) {
		this.mostrarid_numero_patronalProcesoIessFondoReservaMensual= mostrarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public Boolean getActivarid_numero_patronalProcesoIessFondoReservaMensual() {
		return this.activarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public void setActivarid_numero_patronalProcesoIessFondoReservaMensual(Boolean activarid_numero_patronalProcesoIessFondoReservaMensual) {
		this.activarid_numero_patronalProcesoIessFondoReservaMensual= activarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public Boolean getCargarid_numero_patronalProcesoIessFondoReservaMensual() {
		return this.cargarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public void setCargarid_numero_patronalProcesoIessFondoReservaMensual(Boolean cargarid_numero_patronalProcesoIessFondoReservaMensual) {
		this.cargarid_numero_patronalProcesoIessFondoReservaMensual= cargarid_numero_patronalProcesoIessFondoReservaMensual;
	}

	public Border setResaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesoiessfondoreservamensualBeanSwingJInternalFrame.jTtoolBarProcesoIessFondoReservaMensual.setBorder(borderResaltar);
		
		this.resaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual() {
		return this.resaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public void setResaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual= borderResaltar;
	}

	public Boolean getMostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual() {
		return this.mostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public void setMostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(Boolean mostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual) {
		this.mostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual= mostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public Boolean getActivarid_tipo_proceso_nominaProcesoIessFondoReservaMensual() {
		return this.activarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public void setActivarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(Boolean activarid_tipo_proceso_nominaProcesoIessFondoReservaMensual) {
		this.activarid_tipo_proceso_nominaProcesoIessFondoReservaMensual= activarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public Boolean getCargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual() {
		return this.cargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
	}

	public void setCargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(Boolean cargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual) {
		this.cargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual= cargarid_tipo_proceso_nominaProcesoIessFondoReservaMensual;
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
		
		
		this.setMostraridProcesoIessFondoReservaMensual(esInicial);
		this.setMostrarid_anioProcesoIessFondoReservaMensual(esInicial);
		this.setMostrarid_mesProcesoIessFondoReservaMensual(esInicial);
		this.setMostrarid_numero_patronalProcesoIessFondoReservaMensual(esInicial);
		this.setMostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.ID)) {
				this.setMostraridProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA)) {
				this.setMostrarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esAsigna);
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
		
		
		this.setActivaridProcesoIessFondoReservaMensual(esInicial);
		this.setActivarid_anioProcesoIessFondoReservaMensual(esInicial);
		this.setActivarid_mesProcesoIessFondoReservaMensual(esInicial);
		this.setActivarid_numero_patronalProcesoIessFondoReservaMensual(esInicial);
		this.setActivarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.ID)) {
				this.setActivaridProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA)) {
				this.setActivarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoIessFondoReservaMensual(esInicial);
		this.setResaltarid_anioProcesoIessFondoReservaMensual(esInicial);
		this.setResaltarid_mesProcesoIessFondoReservaMensual(esInicial);
		this.setResaltarid_numero_patronalProcesoIessFondoReservaMensual(esInicial);
		this.setResaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.ID)) {
				this.setResaltaridProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalProcesoIessFondoReservaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoIessFondoReservaMensualConstantesFunciones.IDTIPOPROCESONOMINA)) {
				this.setResaltarid_tipo_proceso_nominaProcesoIessFondoReservaMensual(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual=true;

	public Boolean getMostrarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual() {
		return this.mostrarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual;
	}

	public void setMostrarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual=true;

	public Boolean getActivarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual() {
		return this.activarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual;
	}

	public void setActivarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual=null;

	public Border getResaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual() {
		return this.resaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual;
	}

	public void setResaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual(Border borderResaltar) {
		this.resaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual= borderResaltar;
	}

	public void setResaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoIessFondoReservaMensualBeanSwingJInternalFrame procesoiessfondoreservamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoIessFondoReservaMensualProcesoIessFondoReservaMensual= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}