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


import com.bydan.erp.contabilidad.util.PeriodoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PeriodoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PeriodoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PeriodoConstantesFunciones extends PeriodoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Periodo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Periodo"+PeriodoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PeriodoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PeriodoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PeriodoConstantesFunciones.SCHEMA+"_"+PeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PeriodoConstantesFunciones.SCHEMA+"_"+PeriodoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PeriodoConstantesFunciones.SCHEMA+"_"+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PeriodoConstantesFunciones.SCHEMA+"_"+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PeriodoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PeriodoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PeriodoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PeriodoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Periodos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Periodo";
	public static final String SCLASSWEBTITULO_LOWER="Periodo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Periodo";
	public static final String OBJECTNAME="periodo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="periodo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select periodo from "+PeriodoConstantesFunciones.SPERSISTENCENAME+" periodo";
	public static String QUERYSELECTNATIVE="select "+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".version_row,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id_empresa,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id_anio,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id_ejercicio,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id_mes,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".fecha_inicio,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".fecha_fin,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".nombre,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".descripcion,"+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME+".id_estado_periodo from "+PeriodoConstantesFunciones.SCHEMA+"."+PeriodoConstantesFunciones.TABLENAME;//+" as "+PeriodoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PeriodoConstantesFuncionesAdditional periodoConstantesFuncionesAdditional=null;
	
	public PeriodoConstantesFuncionesAdditional getPeriodoConstantesFuncionesAdditional() {
		return this.periodoConstantesFuncionesAdditional;
	}
	
	public void setPeriodoConstantesFuncionesAdditional(PeriodoConstantesFuncionesAdditional periodoConstantesFuncionesAdditional) {
		try {
			this.periodoConstantesFuncionesAdditional=periodoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDANIO= "id_anio";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDMES= "id_mes";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDESTADOPERIODO= "id_estado_periodo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDESTADOPERIODO= "Estado Periodo";
		public static final String LABEL_IDESTADOPERIODO_LOWER= "Estado Periodo";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPeriodoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PeriodoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.IDANIO)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.IDMES)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.FECHAINICIO)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.FECHAFIN)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.NOMBRE)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PeriodoConstantesFunciones.IDESTADOPERIODO)) {sLabelColumna=PeriodoConstantesFunciones.LABEL_IDESTADOPERIODO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(periodo !=null/* && periodo.getId()!=0*/) {
			sDescripcion=periodo.getnombre();//periodoperiodo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPeriodoDescripcionDetallado(Periodo periodo) {
		String sDescripcion="";
			
		sDescripcion+=PeriodoConstantesFunciones.ID+"=";
		sDescripcion+=periodo.getId().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=periodo.getVersionRow().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=periodo.getid_empresa().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.IDANIO+"=";
		sDescripcion+=periodo.getid_anio().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=periodo.getid_ejercicio().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.IDMES+"=";
		sDescripcion+=periodo.getid_mes().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=periodo.getfecha_inicio().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=periodo.getfecha_fin().toString()+",";
		sDescripcion+=PeriodoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=periodo.getnombre()+",";
		sDescripcion+=PeriodoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=periodo.getdescripcion()+",";
		sDescripcion+=PeriodoConstantesFunciones.IDESTADOPERIODO+"=";
		sDescripcion+=periodo.getid_estado_periodo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPeriodoDescripcion(Periodo periodo,String sValor) throws Exception {			
		if(periodo !=null) {
			periodo.setnombre(sValor);;//periodoperiodo.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
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

	public static String getEstadoPeriodoDescripcion(EstadoPeriodo estadoperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoperiodo!=null/*&&estadoperiodo.getId()>0*/) {
			sDescripcion=EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(estadoperiodo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdAnioPorIdEjercicio")) {
			sNombreIndice="Tipo=  Por Anio Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPeriodo")) {
			sNombreIndice="Tipo=  Por Estado Periodo";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("PorEmprePorAnioPorMes")) {
			sNombreIndice="Tipo=  Por Empresa Por Anio Por Mes";
		} else if(sNombreIndice.equals("PorIdPorEmprePorEjerPorAnioPorMes")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Ejercicio Por Anio Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdAnioPorIdEjercicio(Long id_anio,Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoPeriodo(Long id_estado_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_periodo!=null) {sDetalleIndice+=" Codigo Unico De Estado Periodo="+id_estado_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmprePorAnioPorMes(Long id_empresa,Long id_anio,Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmprePorEjerPorAnioPorMes(Long id,Long id_empresa,Long id_ejercicio,Long id_anio,Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPeriodo(Periodo periodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		periodo.setnombre(periodo.getnombre().trim());
		periodo.setdescripcion(periodo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPeriodos(List<Periodo> periodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Periodo periodo: periodos) {
			periodo.setnombre(periodo.getnombre().trim());
			periodo.setdescripcion(periodo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodo(Periodo periodo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && periodo.getConCambioAuxiliar()) {
			periodo.setIsDeleted(periodo.getIsDeletedAuxiliar());	
			periodo.setIsNew(periodo.getIsNewAuxiliar());	
			periodo.setIsChanged(periodo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			periodo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			periodo.setIsDeletedAuxiliar(false);	
			periodo.setIsNewAuxiliar(false);	
			periodo.setIsChangedAuxiliar(false);
			
			periodo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodos(List<Periodo> periodos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Periodo periodo : periodos) {
			if(conAsignarBase && periodo.getConCambioAuxiliar()) {
				periodo.setIsDeleted(periodo.getIsDeletedAuxiliar());	
				periodo.setIsNew(periodo.getIsNewAuxiliar());	
				periodo.setIsChanged(periodo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				periodo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				periodo.setIsDeletedAuxiliar(false);	
				periodo.setIsNewAuxiliar(false);	
				periodo.setIsChangedAuxiliar(false);
				
				periodo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPeriodo(Periodo periodo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPeriodos(List<Periodo> periodos,Boolean conEnteros) throws Exception  {
		
		for(Periodo periodo: periodos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPeriodo(List<Periodo> periodos,Periodo periodoAux) throws Exception  {
		PeriodoConstantesFunciones.InicializarValoresPeriodo(periodoAux,true);
		
		for(Periodo periodo: periodos) {
			if(periodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PeriodoConstantesFunciones.getArrayColumnasGlobalesPeriodo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PeriodoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PeriodoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PeriodoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PeriodoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PeriodoConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Periodo> periodos,Periodo periodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Periodo periodoAux: periodos) {
			if(periodoAux!=null && periodo!=null) {
				if((periodoAux.getId()==null && periodo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(periodoAux.getId()!=null && periodo.getId()!=null){
					if(periodoAux.getId().equals(periodo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPeriodo(List<Periodo> periodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Periodo periodo: periodos) {			
			if(periodo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPeriodo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_ID, PeriodoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_VERSIONROW, PeriodoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_IDEMPRESA, PeriodoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_IDANIO, PeriodoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_IDEJERCICIO, PeriodoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_IDMES, PeriodoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_FECHAINICIO, PeriodoConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_FECHAFIN, PeriodoConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_NOMBRE, PeriodoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_DESCRIPCION, PeriodoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoConstantesFunciones.LABEL_IDESTADOPERIODO, PeriodoConstantesFunciones.IDESTADOPERIODO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPeriodo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoConstantesFunciones.IDESTADOPERIODO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodo() throws Exception  {
		return PeriodoConstantesFunciones.getTiposSeleccionarPeriodo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodo(Boolean conFk) throws Exception  {
		return PeriodoConstantesFunciones.getTiposSeleccionarPeriodo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);
			reporte.setsDescripcion(PeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPeriodo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodo(Periodo periodoAux) throws Exception {
		
			periodoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(periodoAux.getEmpresa()));
			periodoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periodoAux.getAnio()));
			periodoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(periodoAux.getEjercicio()));
			periodoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periodoAux.getMes()));
			periodoAux.setestadoperiodo_descripcion(EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(periodoAux.getEstadoPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodo(List<Periodo> periodosTemp) throws Exception {
		for(Periodo periodoAux:periodosTemp) {
			
			periodoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(periodoAux.getEmpresa()));
			periodoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periodoAux.getAnio()));
			periodoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(periodoAux.getEjercicio()));
			periodoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periodoAux.getMes()));
			periodoAux.setestadoperiodo_descripcion(EstadoPeriodoConstantesFunciones.getEstadoPeriodoDescripcion(periodoAux.getEstadoPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(EstadoPeriodo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPeriodo.class)) {
						classes.add(new Classe(EstadoPeriodo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(EstadoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPeriodo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(EstadoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPeriodo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoConstantesFunciones.getClassesRelationshipsOfPeriodo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoConstantesFunciones.getClassesRelationshipsFromStringsOfPeriodo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Periodo periodo,List<Periodo> periodos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Periodo periodoEncontrado=null;
			
			for(Periodo periodoLocal:periodos) {
				if(periodoLocal.getId().equals(periodo.getId())) {
					periodoEncontrado=periodoLocal;
					
					periodoLocal.setIsChanged(periodo.getIsChanged());
					periodoLocal.setIsNew(periodo.getIsNew());
					periodoLocal.setIsDeleted(periodo.getIsDeleted());
					
					periodoLocal.setGeneralEntityOriginal(periodo.getGeneralEntityOriginal());
					
					periodoLocal.setId(periodo.getId());	
					periodoLocal.setVersionRow(periodo.getVersionRow());	
					periodoLocal.setid_empresa(periodo.getid_empresa());	
					periodoLocal.setid_anio(periodo.getid_anio());	
					periodoLocal.setid_ejercicio(periodo.getid_ejercicio());	
					periodoLocal.setid_mes(periodo.getid_mes());	
					periodoLocal.setfecha_inicio(periodo.getfecha_inicio());	
					periodoLocal.setfecha_fin(periodo.getfecha_fin());	
					periodoLocal.setnombre(periodo.getnombre());	
					periodoLocal.setdescripcion(periodo.getdescripcion());	
					periodoLocal.setid_estado_periodo(periodo.getid_estado_periodo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!periodo.getIsDeleted()) {
				if(!existe) {
					periodos.add(periodo);
				}
			} else {
				if(periodoEncontrado!=null && permiteQuitar)  {
					periodos.remove(periodoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Periodo periodo,List<Periodo> periodos) throws Exception {
		try	{			
			for(Periodo periodoLocal:periodos) {
				if(periodoLocal.getId().equals(periodo.getId())) {
					periodoLocal.setIsSelected(periodo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPeriodo(List<Periodo> periodosAux) throws Exception {
		//this.periodosAux=periodosAux;
		
		for(Periodo periodoAux:periodosAux) {
			if(periodoAux.getIsChanged()) {
				periodoAux.setIsChanged(false);
			}		
			
			if(periodoAux.getIsNew()) {
				periodoAux.setIsNew(false);
			}	
			
			if(periodoAux.getIsDeleted()) {
				periodoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPeriodo(Periodo periodoAux) throws Exception {
		//this.periodoAux=periodoAux;
		
			if(periodoAux.getIsChanged()) {
				periodoAux.setIsChanged(false);
			}		
			
			if(periodoAux.getIsNew()) {
				periodoAux.setIsNew(false);
			}	
			
			if(periodoAux.getIsDeleted()) {
				periodoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Periodo periodoAsignar,Periodo periodo) throws Exception {
		periodoAsignar.setId(periodo.getId());	
		periodoAsignar.setVersionRow(periodo.getVersionRow());	
		periodoAsignar.setid_empresa(periodo.getid_empresa());
		periodoAsignar.setempresa_descripcion(periodo.getempresa_descripcion());	
		periodoAsignar.setid_anio(periodo.getid_anio());
		periodoAsignar.setanio_descripcion(periodo.getanio_descripcion());	
		periodoAsignar.setid_ejercicio(periodo.getid_ejercicio());
		periodoAsignar.setejercicio_descripcion(periodo.getejercicio_descripcion());	
		periodoAsignar.setid_mes(periodo.getid_mes());
		periodoAsignar.setmes_descripcion(periodo.getmes_descripcion());	
		periodoAsignar.setfecha_inicio(periodo.getfecha_inicio());	
		periodoAsignar.setfecha_fin(periodo.getfecha_fin());	
		periodoAsignar.setnombre(periodo.getnombre());	
		periodoAsignar.setdescripcion(periodo.getdescripcion());	
		periodoAsignar.setid_estado_periodo(periodo.getid_estado_periodo());
		periodoAsignar.setestadoperiodo_descripcion(periodo.getestadoperiodo_descripcion());	
	}
	
	public static void inicializarPeriodo(Periodo periodo) throws Exception {
		try {
				periodo.setId(0L);	
					
				periodo.setid_empresa(-1L);	
				periodo.setid_anio(null);	
				periodo.setid_ejercicio(-1L);	
				periodo.setid_mes(-1L);	
				periodo.setfecha_inicio(new Date());	
				periodo.setfecha_fin(new Date());	
				periodo.setnombre("");	
				periodo.setdescripcion("");	
				periodo.setid_estado_periodo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPeriodo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoConstantesFunciones.LABEL_IDESTADOPERIODO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPeriodo(String sTipo,Row row,Workbook workbook,Periodo periodo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periodo.getestadoperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPeriodo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPeriodo() {
		return this.sFinalQueryPeriodo;
	}
	
	public void setsFinalQueryPeriodo(String sFinalQueryPeriodo) {
		this.sFinalQueryPeriodo= sFinalQueryPeriodo;
	}
	
	public Border resaltarSeleccionarPeriodo=null;
	
	public Border setResaltarSeleccionarPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPeriodo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPeriodo() {
		return this.resaltarSeleccionarPeriodo;
	}
	
	public void setResaltarSeleccionarPeriodo(Border borderResaltarSeleccionarPeriodo) {
		this.resaltarSeleccionarPeriodo= borderResaltarSeleccionarPeriodo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPeriodo=null;
	public Boolean mostraridPeriodo=true;
	public Boolean activaridPeriodo=true;

	public Border resaltarid_empresaPeriodo=null;
	public Boolean mostrarid_empresaPeriodo=true;
	public Boolean activarid_empresaPeriodo=true;
	public Boolean cargarid_empresaPeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPeriodo=false;//ConEventDepend=true

	public Border resaltarid_anioPeriodo=null;
	public Boolean mostrarid_anioPeriodo=true;
	public Boolean activarid_anioPeriodo=true;
	public Boolean cargarid_anioPeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPeriodo=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPeriodo=null;
	public Boolean mostrarid_ejercicioPeriodo=true;
	public Boolean activarid_ejercicioPeriodo=true;
	public Boolean cargarid_ejercicioPeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPeriodo=true;//ConEventDepend=true

	public Border resaltarid_mesPeriodo=null;
	public Boolean mostrarid_mesPeriodo=true;
	public Boolean activarid_mesPeriodo=true;
	public Boolean cargarid_mesPeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPeriodo=false;//ConEventDepend=true

	public Border resaltarfecha_inicioPeriodo=null;
	public Boolean mostrarfecha_inicioPeriodo=true;
	public Boolean activarfecha_inicioPeriodo=true;

	public Border resaltarfecha_finPeriodo=null;
	public Boolean mostrarfecha_finPeriodo=true;
	public Boolean activarfecha_finPeriodo=true;

	public Border resaltarnombrePeriodo=null;
	public Boolean mostrarnombrePeriodo=true;
	public Boolean activarnombrePeriodo=true;

	public Border resaltardescripcionPeriodo=null;
	public Boolean mostrardescripcionPeriodo=true;
	public Boolean activardescripcionPeriodo=true;

	public Border resaltarid_estado_periodoPeriodo=null;
	public Boolean mostrarid_estado_periodoPeriodo=true;
	public Boolean activarid_estado_periodoPeriodo=true;
	public Boolean cargarid_estado_periodoPeriodo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_periodoPeriodo=false;//ConEventDepend=true

	
	

	public Border setResaltaridPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltaridPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPeriodo() {
		return this.resaltaridPeriodo;
	}

	public void setResaltaridPeriodo(Border borderResaltar) {
		this.resaltaridPeriodo= borderResaltar;
	}

	public Boolean getMostraridPeriodo() {
		return this.mostraridPeriodo;
	}

	public void setMostraridPeriodo(Boolean mostraridPeriodo) {
		this.mostraridPeriodo= mostraridPeriodo;
	}

	public Boolean getActivaridPeriodo() {
		return this.activaridPeriodo;
	}

	public void setActivaridPeriodo(Boolean activaridPeriodo) {
		this.activaridPeriodo= activaridPeriodo;
	}

	public Border setResaltarid_empresaPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarid_empresaPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPeriodo() {
		return this.resaltarid_empresaPeriodo;
	}

	public void setResaltarid_empresaPeriodo(Border borderResaltar) {
		this.resaltarid_empresaPeriodo= borderResaltar;
	}

	public Boolean getMostrarid_empresaPeriodo() {
		return this.mostrarid_empresaPeriodo;
	}

	public void setMostrarid_empresaPeriodo(Boolean mostrarid_empresaPeriodo) {
		this.mostrarid_empresaPeriodo= mostrarid_empresaPeriodo;
	}

	public Boolean getActivarid_empresaPeriodo() {
		return this.activarid_empresaPeriodo;
	}

	public void setActivarid_empresaPeriodo(Boolean activarid_empresaPeriodo) {
		this.activarid_empresaPeriodo= activarid_empresaPeriodo;
	}

	public Boolean getCargarid_empresaPeriodo() {
		return this.cargarid_empresaPeriodo;
	}

	public void setCargarid_empresaPeriodo(Boolean cargarid_empresaPeriodo) {
		this.cargarid_empresaPeriodo= cargarid_empresaPeriodo;
	}

	public Border setResaltarid_anioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarid_anioPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPeriodo() {
		return this.resaltarid_anioPeriodo;
	}

	public void setResaltarid_anioPeriodo(Border borderResaltar) {
		this.resaltarid_anioPeriodo= borderResaltar;
	}

	public Boolean getMostrarid_anioPeriodo() {
		return this.mostrarid_anioPeriodo;
	}

	public void setMostrarid_anioPeriodo(Boolean mostrarid_anioPeriodo) {
		this.mostrarid_anioPeriodo= mostrarid_anioPeriodo;
	}

	public Boolean getActivarid_anioPeriodo() {
		return this.activarid_anioPeriodo;
	}

	public void setActivarid_anioPeriodo(Boolean activarid_anioPeriodo) {
		this.activarid_anioPeriodo= activarid_anioPeriodo;
	}

	public Boolean getCargarid_anioPeriodo() {
		return this.cargarid_anioPeriodo;
	}

	public void setCargarid_anioPeriodo(Boolean cargarid_anioPeriodo) {
		this.cargarid_anioPeriodo= cargarid_anioPeriodo;
	}

	public Border setResaltarid_ejercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPeriodo() {
		return this.resaltarid_ejercicioPeriodo;
	}

	public void setResaltarid_ejercicioPeriodo(Border borderResaltar) {
		this.resaltarid_ejercicioPeriodo= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPeriodo() {
		return this.mostrarid_ejercicioPeriodo;
	}

	public void setMostrarid_ejercicioPeriodo(Boolean mostrarid_ejercicioPeriodo) {
		this.mostrarid_ejercicioPeriodo= mostrarid_ejercicioPeriodo;
	}

	public Boolean getActivarid_ejercicioPeriodo() {
		return this.activarid_ejercicioPeriodo;
	}

	public void setActivarid_ejercicioPeriodo(Boolean activarid_ejercicioPeriodo) {
		this.activarid_ejercicioPeriodo= activarid_ejercicioPeriodo;
	}

	public Boolean getCargarid_ejercicioPeriodo() {
		return this.cargarid_ejercicioPeriodo;
	}

	public void setCargarid_ejercicioPeriodo(Boolean cargarid_ejercicioPeriodo) {
		this.cargarid_ejercicioPeriodo= cargarid_ejercicioPeriodo;
	}

	public Border setResaltarid_mesPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarid_mesPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPeriodo() {
		return this.resaltarid_mesPeriodo;
	}

	public void setResaltarid_mesPeriodo(Border borderResaltar) {
		this.resaltarid_mesPeriodo= borderResaltar;
	}

	public Boolean getMostrarid_mesPeriodo() {
		return this.mostrarid_mesPeriodo;
	}

	public void setMostrarid_mesPeriodo(Boolean mostrarid_mesPeriodo) {
		this.mostrarid_mesPeriodo= mostrarid_mesPeriodo;
	}

	public Boolean getActivarid_mesPeriodo() {
		return this.activarid_mesPeriodo;
	}

	public void setActivarid_mesPeriodo(Boolean activarid_mesPeriodo) {
		this.activarid_mesPeriodo= activarid_mesPeriodo;
	}

	public Boolean getCargarid_mesPeriodo() {
		return this.cargarid_mesPeriodo;
	}

	public void setCargarid_mesPeriodo(Boolean cargarid_mesPeriodo) {
		this.cargarid_mesPeriodo= cargarid_mesPeriodo;
	}

	public Border setResaltarfecha_inicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioPeriodo() {
		return this.resaltarfecha_inicioPeriodo;
	}

	public void setResaltarfecha_inicioPeriodo(Border borderResaltar) {
		this.resaltarfecha_inicioPeriodo= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioPeriodo() {
		return this.mostrarfecha_inicioPeriodo;
	}

	public void setMostrarfecha_inicioPeriodo(Boolean mostrarfecha_inicioPeriodo) {
		this.mostrarfecha_inicioPeriodo= mostrarfecha_inicioPeriodo;
	}

	public Boolean getActivarfecha_inicioPeriodo() {
		return this.activarfecha_inicioPeriodo;
	}

	public void setActivarfecha_inicioPeriodo(Boolean activarfecha_inicioPeriodo) {
		this.activarfecha_inicioPeriodo= activarfecha_inicioPeriodo;
	}

	public Border setResaltarfecha_finPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarfecha_finPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finPeriodo() {
		return this.resaltarfecha_finPeriodo;
	}

	public void setResaltarfecha_finPeriodo(Border borderResaltar) {
		this.resaltarfecha_finPeriodo= borderResaltar;
	}

	public Boolean getMostrarfecha_finPeriodo() {
		return this.mostrarfecha_finPeriodo;
	}

	public void setMostrarfecha_finPeriodo(Boolean mostrarfecha_finPeriodo) {
		this.mostrarfecha_finPeriodo= mostrarfecha_finPeriodo;
	}

	public Boolean getActivarfecha_finPeriodo() {
		return this.activarfecha_finPeriodo;
	}

	public void setActivarfecha_finPeriodo(Boolean activarfecha_finPeriodo) {
		this.activarfecha_finPeriodo= activarfecha_finPeriodo;
	}

	public Border setResaltarnombrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarnombrePeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePeriodo() {
		return this.resaltarnombrePeriodo;
	}

	public void setResaltarnombrePeriodo(Border borderResaltar) {
		this.resaltarnombrePeriodo= borderResaltar;
	}

	public Boolean getMostrarnombrePeriodo() {
		return this.mostrarnombrePeriodo;
	}

	public void setMostrarnombrePeriodo(Boolean mostrarnombrePeriodo) {
		this.mostrarnombrePeriodo= mostrarnombrePeriodo;
	}

	public Boolean getActivarnombrePeriodo() {
		return this.activarnombrePeriodo;
	}

	public void setActivarnombrePeriodo(Boolean activarnombrePeriodo) {
		this.activarnombrePeriodo= activarnombrePeriodo;
	}

	public Border setResaltardescripcionPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltardescripcionPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPeriodo() {
		return this.resaltardescripcionPeriodo;
	}

	public void setResaltardescripcionPeriodo(Border borderResaltar) {
		this.resaltardescripcionPeriodo= borderResaltar;
	}

	public Boolean getMostrardescripcionPeriodo() {
		return this.mostrardescripcionPeriodo;
	}

	public void setMostrardescripcionPeriodo(Boolean mostrardescripcionPeriodo) {
		this.mostrardescripcionPeriodo= mostrardescripcionPeriodo;
	}

	public Boolean getActivardescripcionPeriodo() {
		return this.activardescripcionPeriodo;
	}

	public void setActivardescripcionPeriodo(Boolean activardescripcionPeriodo) {
		this.activardescripcionPeriodo= activardescripcionPeriodo;
	}

	public Border setResaltarid_estado_periodoPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periodoBeanSwingJInternalFrame.jTtoolBarPeriodo.setBorder(borderResaltar);
		
		this.resaltarid_estado_periodoPeriodo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_periodoPeriodo() {
		return this.resaltarid_estado_periodoPeriodo;
	}

	public void setResaltarid_estado_periodoPeriodo(Border borderResaltar) {
		this.resaltarid_estado_periodoPeriodo= borderResaltar;
	}

	public Boolean getMostrarid_estado_periodoPeriodo() {
		return this.mostrarid_estado_periodoPeriodo;
	}

	public void setMostrarid_estado_periodoPeriodo(Boolean mostrarid_estado_periodoPeriodo) {
		this.mostrarid_estado_periodoPeriodo= mostrarid_estado_periodoPeriodo;
	}

	public Boolean getActivarid_estado_periodoPeriodo() {
		return this.activarid_estado_periodoPeriodo;
	}

	public void setActivarid_estado_periodoPeriodo(Boolean activarid_estado_periodoPeriodo) {
		this.activarid_estado_periodoPeriodo= activarid_estado_periodoPeriodo;
	}

	public Boolean getCargarid_estado_periodoPeriodo() {
		return this.cargarid_estado_periodoPeriodo;
	}

	public void setCargarid_estado_periodoPeriodo(Boolean cargarid_estado_periodoPeriodo) {
		this.cargarid_estado_periodoPeriodo= cargarid_estado_periodoPeriodo;
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
		
		
		this.setMostraridPeriodo(esInicial);
		this.setMostrarid_empresaPeriodo(esInicial);
		this.setMostrarid_anioPeriodo(esInicial);
		this.setMostrarid_ejercicioPeriodo(esInicial);
		this.setMostrarid_mesPeriodo(esInicial);
		this.setMostrarfecha_inicioPeriodo(esInicial);
		this.setMostrarfecha_finPeriodo(esInicial);
		this.setMostrarnombrePeriodo(esInicial);
		this.setMostrardescripcionPeriodo(esInicial);
		this.setMostrarid_estado_periodoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoConstantesFunciones.ID)) {
				this.setMostraridPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setMostrarid_estado_periodoPeriodo(esAsigna);
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
		
		
		this.setActivaridPeriodo(esInicial);
		this.setActivarid_empresaPeriodo(esInicial);
		this.setActivarid_anioPeriodo(esInicial);
		this.setActivarid_ejercicioPeriodo(esInicial);
		this.setActivarid_mesPeriodo(esInicial);
		this.setActivarfecha_inicioPeriodo(esInicial);
		this.setActivarfecha_finPeriodo(esInicial);
		this.setActivarnombrePeriodo(esInicial);
		this.setActivardescripcionPeriodo(esInicial);
		this.setActivarid_estado_periodoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoConstantesFunciones.ID)) {
				this.setActivaridPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDMES)) {
				this.setActivarid_mesPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setActivarid_estado_periodoPeriodo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPeriodo(esInicial);
		this.setResaltarid_empresaPeriodo(esInicial);
		this.setResaltarid_anioPeriodo(esInicial);
		this.setResaltarid_ejercicioPeriodo(esInicial);
		this.setResaltarid_mesPeriodo(esInicial);
		this.setResaltarfecha_inicioPeriodo(esInicial);
		this.setResaltarfecha_finPeriodo(esInicial);
		this.setResaltarnombrePeriodo(esInicial);
		this.setResaltardescripcionPeriodo(esInicial);
		this.setResaltarid_estado_periodoPeriodo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoConstantesFunciones.ID)) {
				this.setResaltaridPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPeriodo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoConstantesFunciones.IDESTADOPERIODO)) {
				this.setResaltarid_estado_periodoPeriodo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdAnioPorIdEjercicioPeriodo=true;

	public Boolean getMostrarBusquedaPorIdAnioPorIdEjercicioPeriodo() {
		return this.mostrarBusquedaPorIdAnioPorIdEjercicioPeriodo;
	}

	public void setMostrarBusquedaPorIdAnioPorIdEjercicioPeriodo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdAnioPorIdEjercicioPeriodo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAnioPeriodo=true;

	public Boolean getMostrarFK_IdAnioPeriodo() {
		return this.mostrarFK_IdAnioPeriodo;
	}

	public void setMostrarFK_IdAnioPeriodo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioPeriodo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPeriodo=true;

	public Boolean getMostrarFK_IdEmpresaPeriodo() {
		return this.mostrarFK_IdEmpresaPeriodo;
	}

	public void setMostrarFK_IdEmpresaPeriodo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPeriodo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdAnioPorIdEjercicioPeriodo=true;

	public Boolean getActivarBusquedaPorIdAnioPorIdEjercicioPeriodo() {
		return this.activarBusquedaPorIdAnioPorIdEjercicioPeriodo;
	}

	public void setActivarBusquedaPorIdAnioPorIdEjercicioPeriodo(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdAnioPorIdEjercicioPeriodo= habilitarResaltar;
	}

	public Boolean activarFK_IdAnioPeriodo=true;

	public Boolean getActivarFK_IdAnioPeriodo() {
		return this.activarFK_IdAnioPeriodo;
	}

	public void setActivarFK_IdAnioPeriodo(Boolean habilitarResaltar) {
		this.activarFK_IdAnioPeriodo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPeriodo=true;

	public Boolean getActivarFK_IdEmpresaPeriodo() {
		return this.activarFK_IdEmpresaPeriodo;
	}

	public void setActivarFK_IdEmpresaPeriodo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPeriodo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdAnioPorIdEjercicioPeriodo=null;

	public Border getResaltarBusquedaPorIdAnioPorIdEjercicioPeriodo() {
		return this.resaltarBusquedaPorIdAnioPorIdEjercicioPeriodo;
	}

	public void setResaltarBusquedaPorIdAnioPorIdEjercicioPeriodo(Border borderResaltar) {
		this.resaltarBusquedaPorIdAnioPorIdEjercicioPeriodo= borderResaltar;
	}

	public void setResaltarBusquedaPorIdAnioPorIdEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdAnioPorIdEjercicioPeriodo= borderResaltar;
	}

	public Border resaltarFK_IdAnioPeriodo=null;

	public Border getResaltarFK_IdAnioPeriodo() {
		return this.resaltarFK_IdAnioPeriodo;
	}

	public void setResaltarFK_IdAnioPeriodo(Border borderResaltar) {
		this.resaltarFK_IdAnioPeriodo= borderResaltar;
	}

	public void setResaltarFK_IdAnioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioPeriodo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPeriodo=null;

	public Border getResaltarFK_IdEmpresaPeriodo() {
		return this.resaltarFK_IdEmpresaPeriodo;
	}

	public void setResaltarFK_IdEmpresaPeriodo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPeriodo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPeriodo(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoBeanSwingJInternalFrame periodoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPeriodo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}