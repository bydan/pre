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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.PreguntaEvaluacionConstantesFunciones;
import com.bydan.erp.cartera.util.PreguntaEvaluacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PreguntaEvaluacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PreguntaEvaluacionConstantesFunciones extends PreguntaEvaluacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PreguntaEvaluacion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PreguntaEvaluacion"+PreguntaEvaluacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PreguntaEvaluacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PreguntaEvaluacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+PreguntaEvaluacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+PreguntaEvaluacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PreguntaEvaluacionConstantesFunciones.SCHEMA+"_"+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaEvaluacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEvaluacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PreguntaEvaluacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PreguntaEvaluacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PreguntaEvaluacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PreguntaEvaluacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pregunta Evaluacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pregunta Evaluacion";
	public static final String SCLASSWEBTITULO_LOWER="Pregunta Evaluacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PreguntaEvaluacion";
	public static final String OBJECTNAME="preguntaevaluacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="pregunta_evaluacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select preguntaevaluacion from "+PreguntaEvaluacionConstantesFunciones.SPERSISTENCENAME+" preguntaevaluacion";
	public static String QUERYSELECTNATIVE="select "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_sucursal,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_ejercicio,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_periodo,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".pregunta,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".calificacion,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".orden,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_anio,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_mes from "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+PreguntaEvaluacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PreguntaEvaluacionConstantesFuncionesAdditional preguntaevaluacionConstantesFuncionesAdditional=null;
	
	public PreguntaEvaluacionConstantesFuncionesAdditional getPreguntaEvaluacionConstantesFuncionesAdditional() {
		return this.preguntaevaluacionConstantesFuncionesAdditional;
	}
	
	public void setPreguntaEvaluacionConstantesFuncionesAdditional(PreguntaEvaluacionConstantesFuncionesAdditional preguntaevaluacionConstantesFuncionesAdditional) {
		try {
			this.preguntaevaluacionConstantesFuncionesAdditional=preguntaevaluacionConstantesFuncionesAdditional;
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
    public static final String PREGUNTA= "pregunta";
    public static final String CALIFICACION= "calificacion";
    public static final String ORDEN= "orden";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
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
    	public static final String LABEL_PREGUNTA= "Pregunta";
		public static final String LABEL_PREGUNTA_LOWER= "Pregunta";
    	public static final String LABEL_CALIFICACION= "Calificacion";
		public static final String LABEL_CALIFICACION_LOWER= "Calificacion";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
	public static final String SREGEXPREGUNTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPREGUNTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getPreguntaEvaluacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDPERIODO)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.PREGUNTA)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.CALIFICACION)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.ORDEN)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDANIO)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PreguntaEvaluacionConstantesFunciones.IDMES)) {sLabelColumna=PreguntaEvaluacionConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPreguntaEvaluacionDescripcion(PreguntaEvaluacion preguntaevaluacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(preguntaevaluacion !=null/* && preguntaevaluacion.getId()!=0*/) {
			if(preguntaevaluacion.getId()!=null) {
				sDescripcion=preguntaevaluacion.getId().toString();
			}//preguntaevaluacionpreguntaevaluacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPreguntaEvaluacionDescripcionDetallado(PreguntaEvaluacion preguntaevaluacion) {
		String sDescripcion="";
			
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.ID+"=";
		sDescripcion+=preguntaevaluacion.getId().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=preguntaevaluacion.getVersionRow().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=preguntaevaluacion.getid_empresa().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=preguntaevaluacion.getid_sucursal().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=preguntaevaluacion.getid_ejercicio().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=preguntaevaluacion.getid_periodo().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.PREGUNTA+"=";
		sDescripcion+=preguntaevaluacion.getpregunta()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.CALIFICACION+"=";
		sDescripcion+=preguntaevaluacion.getcalificacion().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.ORDEN+"=";
		sDescripcion+=preguntaevaluacion.getorden().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDANIO+"=";
		sDescripcion+=preguntaevaluacion.getid_anio().toString()+",";
		sDescripcion+=PreguntaEvaluacionConstantesFunciones.IDMES+"=";
		sDescripcion+=preguntaevaluacion.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPreguntaEvaluacionDescripcion(PreguntaEvaluacion preguntaevaluacion,String sValor) throws Exception {			
		if(preguntaevaluacion !=null) {
			//preguntaevaluacionpreguntaevaluacion.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdEjercicioPorIdPeriodo")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo";
		} else if(sNombreIndice.equals("BusquedaPorPregunta")) {
			sNombreIndice="Tipo=  Por Pregunta";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdEjercicioPorIdPeriodo(Long id_ejercicio,Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorPregunta(String pregunta) {
		String sDetalleIndice=" Parametros->";
		if(pregunta!=null) {sDetalleIndice+=" Pregunta="+pregunta;} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		preguntaevaluacion.setpregunta(preguntaevaluacion.getpregunta().trim());
	}
	
	public static void quitarEspaciosPreguntaEvaluacions(List<PreguntaEvaluacion> preguntaevaluacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PreguntaEvaluacion preguntaevaluacion: preguntaevaluacions) {
			preguntaevaluacion.setpregunta(preguntaevaluacion.getpregunta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && preguntaevaluacion.getConCambioAuxiliar()) {
			preguntaevaluacion.setIsDeleted(preguntaevaluacion.getIsDeletedAuxiliar());	
			preguntaevaluacion.setIsNew(preguntaevaluacion.getIsNewAuxiliar());	
			preguntaevaluacion.setIsChanged(preguntaevaluacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			preguntaevaluacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			preguntaevaluacion.setIsDeletedAuxiliar(false);	
			preguntaevaluacion.setIsNewAuxiliar(false);	
			preguntaevaluacion.setIsChangedAuxiliar(false);
			
			preguntaevaluacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaEvaluacions(List<PreguntaEvaluacion> preguntaevaluacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PreguntaEvaluacion preguntaevaluacion : preguntaevaluacions) {
			if(conAsignarBase && preguntaevaluacion.getConCambioAuxiliar()) {
				preguntaevaluacion.setIsDeleted(preguntaevaluacion.getIsDeletedAuxiliar());	
				preguntaevaluacion.setIsNew(preguntaevaluacion.getIsNewAuxiliar());	
				preguntaevaluacion.setIsChanged(preguntaevaluacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				preguntaevaluacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				preguntaevaluacion.setIsDeletedAuxiliar(false);	
				preguntaevaluacion.setIsNewAuxiliar(false);	
				preguntaevaluacion.setIsChangedAuxiliar(false);
				
				preguntaevaluacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion,Boolean conEnteros) throws Exception  {
		preguntaevaluacion.setcalificacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			preguntaevaluacion.setorden(0);
		}
	}		
	
	public static void InicializarValoresPreguntaEvaluacions(List<PreguntaEvaluacion> preguntaevaluacions,Boolean conEnteros) throws Exception  {
		
		for(PreguntaEvaluacion preguntaevaluacion: preguntaevaluacions) {
			preguntaevaluacion.setcalificacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				preguntaevaluacion.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPreguntaEvaluacion(List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacion preguntaevaluacionAux) throws Exception  {
		PreguntaEvaluacionConstantesFunciones.InicializarValoresPreguntaEvaluacion(preguntaevaluacionAux,true);
		
		for(PreguntaEvaluacion preguntaevaluacion: preguntaevaluacions) {
			if(preguntaevaluacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			preguntaevaluacionAux.setcalificacion(preguntaevaluacionAux.getcalificacion()+preguntaevaluacion.getcalificacion());			
			preguntaevaluacionAux.setorden(preguntaevaluacionAux.getorden()+preguntaevaluacion.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PreguntaEvaluacionConstantesFunciones.getArrayColumnasGlobalesPreguntaEvaluacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPreguntaEvaluacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PreguntaEvaluacionConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacion preguntaevaluacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PreguntaEvaluacion preguntaevaluacionAux: preguntaevaluacions) {
			if(preguntaevaluacionAux!=null && preguntaevaluacion!=null) {
				if((preguntaevaluacionAux.getId()==null && preguntaevaluacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(preguntaevaluacionAux.getId()!=null && preguntaevaluacion.getId()!=null){
					if(preguntaevaluacionAux.getId().equals(preguntaevaluacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPreguntaEvaluacion(List<PreguntaEvaluacion> preguntaevaluacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double calificacionTotal=0.0;
	
		for(PreguntaEvaluacion preguntaevaluacion: preguntaevaluacions) {			
			if(preguntaevaluacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			calificacionTotal+=preguntaevaluacion.getcalificacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PreguntaEvaluacionConstantesFunciones.CALIFICACION);
		datoGeneral.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION);
		datoGeneral.setdValorDouble(calificacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPreguntaEvaluacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_ID, PreguntaEvaluacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_VERSIONROW, PreguntaEvaluacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA, PreguntaEvaluacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL, PreguntaEvaluacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO, PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO, PreguntaEvaluacionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA, PreguntaEvaluacionConstantesFunciones.PREGUNTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION, PreguntaEvaluacionConstantesFunciones.CALIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_ORDEN, PreguntaEvaluacionConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDANIO, PreguntaEvaluacionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEvaluacionConstantesFunciones.LABEL_IDMES, PreguntaEvaluacionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPreguntaEvaluacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.PREGUNTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.CALIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEvaluacionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEvaluacion() throws Exception  {
		return PreguntaEvaluacionConstantesFunciones.getTiposSeleccionarPreguntaEvaluacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEvaluacion(Boolean conFk) throws Exception  {
		return PreguntaEvaluacionConstantesFunciones.getTiposSeleccionarPreguntaEvaluacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEvaluacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEvaluacionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PreguntaEvaluacionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPreguntaEvaluacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacionAux) throws Exception {
		
			preguntaevaluacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntaevaluacionAux.getEmpresa()));
			preguntaevaluacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(preguntaevaluacionAux.getSucursal()));
			preguntaevaluacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(preguntaevaluacionAux.getEjercicio()));
			preguntaevaluacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(preguntaevaluacionAux.getPeriodo()));
			preguntaevaluacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(preguntaevaluacionAux.getAnio()));
			preguntaevaluacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(preguntaevaluacionAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaEvaluacion(List<PreguntaEvaluacion> preguntaevaluacionsTemp) throws Exception {
		for(PreguntaEvaluacion preguntaevaluacionAux:preguntaevaluacionsTemp) {
			
			preguntaevaluacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntaevaluacionAux.getEmpresa()));
			preguntaevaluacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(preguntaevaluacionAux.getSucursal()));
			preguntaevaluacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(preguntaevaluacionAux.getEjercicio()));
			preguntaevaluacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(preguntaevaluacionAux.getPeriodo()));
			preguntaevaluacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(preguntaevaluacionAux.getAnio()));
			preguntaevaluacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(preguntaevaluacionAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaEvaluacionConstantesFunciones.getClassesRelationshipsOfPreguntaEvaluacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleEvaluacionProveedor.class));
				classes.add(new Classe(SubPreguntaEvaluacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionProveedor.class)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaEvaluacionConstantesFunciones.getClassesRelationshipsFromStringsOfPreguntaEvaluacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaEvaluacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
					}

					if(SubPreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
					}

					if(SubPreguntaEvaluacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubPreguntaEvaluacion.class)); continue;
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
	public static void actualizarLista(PreguntaEvaluacion preguntaevaluacion,List<PreguntaEvaluacion> preguntaevaluacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PreguntaEvaluacion preguntaevaluacionEncontrado=null;
			
			for(PreguntaEvaluacion preguntaevaluacionLocal:preguntaevaluacions) {
				if(preguntaevaluacionLocal.getId().equals(preguntaevaluacion.getId())) {
					preguntaevaluacionEncontrado=preguntaevaluacionLocal;
					
					preguntaevaluacionLocal.setIsChanged(preguntaevaluacion.getIsChanged());
					preguntaevaluacionLocal.setIsNew(preguntaevaluacion.getIsNew());
					preguntaevaluacionLocal.setIsDeleted(preguntaevaluacion.getIsDeleted());
					
					preguntaevaluacionLocal.setGeneralEntityOriginal(preguntaevaluacion.getGeneralEntityOriginal());
					
					preguntaevaluacionLocal.setId(preguntaevaluacion.getId());	
					preguntaevaluacionLocal.setVersionRow(preguntaevaluacion.getVersionRow());	
					preguntaevaluacionLocal.setid_empresa(preguntaevaluacion.getid_empresa());	
					preguntaevaluacionLocal.setid_sucursal(preguntaevaluacion.getid_sucursal());	
					preguntaevaluacionLocal.setid_ejercicio(preguntaevaluacion.getid_ejercicio());	
					preguntaevaluacionLocal.setid_periodo(preguntaevaluacion.getid_periodo());	
					preguntaevaluacionLocal.setpregunta(preguntaevaluacion.getpregunta());	
					preguntaevaluacionLocal.setcalificacion(preguntaevaluacion.getcalificacion());	
					preguntaevaluacionLocal.setorden(preguntaevaluacion.getorden());	
					preguntaevaluacionLocal.setid_anio(preguntaevaluacion.getid_anio());	
					preguntaevaluacionLocal.setid_mes(preguntaevaluacion.getid_mes());	
					
					
					preguntaevaluacionLocal.setDetalleEvaluacionProveedors(preguntaevaluacion.getDetalleEvaluacionProveedors());
					preguntaevaluacionLocal.setSubPreguntaEvaluacions(preguntaevaluacion.getSubPreguntaEvaluacions());
					
					existe=true;
					break;
				}
			}
			
			if(!preguntaevaluacion.getIsDeleted()) {
				if(!existe) {
					preguntaevaluacions.add(preguntaevaluacion);
				}
			} else {
				if(preguntaevaluacionEncontrado!=null && permiteQuitar)  {
					preguntaevaluacions.remove(preguntaevaluacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PreguntaEvaluacion preguntaevaluacion,List<PreguntaEvaluacion> preguntaevaluacions) throws Exception {
		try	{			
			for(PreguntaEvaluacion preguntaevaluacionLocal:preguntaevaluacions) {
				if(preguntaevaluacionLocal.getId().equals(preguntaevaluacion.getId())) {
					preguntaevaluacionLocal.setIsSelected(preguntaevaluacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPreguntaEvaluacion(List<PreguntaEvaluacion> preguntaevaluacionsAux) throws Exception {
		//this.preguntaevaluacionsAux=preguntaevaluacionsAux;
		
		for(PreguntaEvaluacion preguntaevaluacionAux:preguntaevaluacionsAux) {
			if(preguntaevaluacionAux.getIsChanged()) {
				preguntaevaluacionAux.setIsChanged(false);
			}		
			
			if(preguntaevaluacionAux.getIsNew()) {
				preguntaevaluacionAux.setIsNew(false);
			}	
			
			if(preguntaevaluacionAux.getIsDeleted()) {
				preguntaevaluacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacionAux) throws Exception {
		//this.preguntaevaluacionAux=preguntaevaluacionAux;
		
			if(preguntaevaluacionAux.getIsChanged()) {
				preguntaevaluacionAux.setIsChanged(false);
			}		
			
			if(preguntaevaluacionAux.getIsNew()) {
				preguntaevaluacionAux.setIsNew(false);
			}	
			
			if(preguntaevaluacionAux.getIsDeleted()) {
				preguntaevaluacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PreguntaEvaluacion preguntaevaluacionAsignar,PreguntaEvaluacion preguntaevaluacion) throws Exception {
		preguntaevaluacionAsignar.setId(preguntaevaluacion.getId());	
		preguntaevaluacionAsignar.setVersionRow(preguntaevaluacion.getVersionRow());	
		preguntaevaluacionAsignar.setid_empresa(preguntaevaluacion.getid_empresa());
		preguntaevaluacionAsignar.setempresa_descripcion(preguntaevaluacion.getempresa_descripcion());	
		preguntaevaluacionAsignar.setid_sucursal(preguntaevaluacion.getid_sucursal());
		preguntaevaluacionAsignar.setsucursal_descripcion(preguntaevaluacion.getsucursal_descripcion());	
		preguntaevaluacionAsignar.setid_ejercicio(preguntaevaluacion.getid_ejercicio());
		preguntaevaluacionAsignar.setejercicio_descripcion(preguntaevaluacion.getejercicio_descripcion());	
		preguntaevaluacionAsignar.setid_periodo(preguntaevaluacion.getid_periodo());
		preguntaevaluacionAsignar.setperiodo_descripcion(preguntaevaluacion.getperiodo_descripcion());	
		preguntaevaluacionAsignar.setpregunta(preguntaevaluacion.getpregunta());	
		preguntaevaluacionAsignar.setcalificacion(preguntaevaluacion.getcalificacion());	
		preguntaevaluacionAsignar.setorden(preguntaevaluacion.getorden());	
		preguntaevaluacionAsignar.setid_anio(preguntaevaluacion.getid_anio());
		preguntaevaluacionAsignar.setanio_descripcion(preguntaevaluacion.getanio_descripcion());	
		preguntaevaluacionAsignar.setid_mes(preguntaevaluacion.getid_mes());
		preguntaevaluacionAsignar.setmes_descripcion(preguntaevaluacion.getmes_descripcion());	
	}
	
	public static void inicializarPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion) throws Exception {
		try {
				preguntaevaluacion.setId(0L);	
					
				preguntaevaluacion.setid_empresa(-1L);	
				preguntaevaluacion.setid_sucursal(-1L);	
				preguntaevaluacion.setid_ejercicio(-1L);	
				preguntaevaluacion.setid_periodo(-1L);	
				preguntaevaluacion.setpregunta("");	
				preguntaevaluacion.setcalificacion(0.0);	
				preguntaevaluacion.setorden(0);	
				preguntaevaluacion.setid_anio(null);	
				preguntaevaluacion.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPreguntaEvaluacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_PREGUNTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_CALIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEvaluacionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPreguntaEvaluacion(String sTipo,Row row,Workbook workbook,PreguntaEvaluacion preguntaevaluacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getpregunta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getcalificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaevaluacion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPreguntaEvaluacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPreguntaEvaluacion() {
		return this.sFinalQueryPreguntaEvaluacion;
	}
	
	public void setsFinalQueryPreguntaEvaluacion(String sFinalQueryPreguntaEvaluacion) {
		this.sFinalQueryPreguntaEvaluacion= sFinalQueryPreguntaEvaluacion;
	}
	
	public Border resaltarSeleccionarPreguntaEvaluacion=null;
	
	public Border setResaltarSeleccionarPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPreguntaEvaluacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPreguntaEvaluacion() {
		return this.resaltarSeleccionarPreguntaEvaluacion;
	}
	
	public void setResaltarSeleccionarPreguntaEvaluacion(Border borderResaltarSeleccionarPreguntaEvaluacion) {
		this.resaltarSeleccionarPreguntaEvaluacion= borderResaltarSeleccionarPreguntaEvaluacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPreguntaEvaluacion=null;
	public Boolean mostraridPreguntaEvaluacion=true;
	public Boolean activaridPreguntaEvaluacion=true;

	public Border resaltarid_empresaPreguntaEvaluacion=null;
	public Boolean mostrarid_empresaPreguntaEvaluacion=true;
	public Boolean activarid_empresaPreguntaEvaluacion=true;
	public Boolean cargarid_empresaPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalPreguntaEvaluacion=null;
	public Boolean mostrarid_sucursalPreguntaEvaluacion=true;
	public Boolean activarid_sucursalPreguntaEvaluacion=true;
	public Boolean cargarid_sucursalPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPreguntaEvaluacion=null;
	public Boolean mostrarid_ejercicioPreguntaEvaluacion=true;
	public Boolean activarid_ejercicioPreguntaEvaluacion=true;
	public Boolean cargarid_ejercicioPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_periodoPreguntaEvaluacion=null;
	public Boolean mostrarid_periodoPreguntaEvaluacion=true;
	public Boolean activarid_periodoPreguntaEvaluacion=true;
	public Boolean cargarid_periodoPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarpreguntaPreguntaEvaluacion=null;
	public Boolean mostrarpreguntaPreguntaEvaluacion=true;
	public Boolean activarpreguntaPreguntaEvaluacion=true;

	public Border resaltarcalificacionPreguntaEvaluacion=null;
	public Boolean mostrarcalificacionPreguntaEvaluacion=true;
	public Boolean activarcalificacionPreguntaEvaluacion=true;

	public Border resaltarordenPreguntaEvaluacion=null;
	public Boolean mostrarordenPreguntaEvaluacion=true;
	public Boolean activarordenPreguntaEvaluacion=true;

	public Border resaltarid_anioPreguntaEvaluacion=null;
	public Boolean mostrarid_anioPreguntaEvaluacion=true;
	public Boolean activarid_anioPreguntaEvaluacion=false;
	public Boolean cargarid_anioPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPreguntaEvaluacion=false;//ConEventDepend=true

	public Border resaltarid_mesPreguntaEvaluacion=null;
	public Boolean mostrarid_mesPreguntaEvaluacion=true;
	public Boolean activarid_mesPreguntaEvaluacion=false;
	public Boolean cargarid_mesPreguntaEvaluacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPreguntaEvaluacion=false;//ConEventDepend=true

	
	

	public Border setResaltaridPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltaridPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPreguntaEvaluacion() {
		return this.resaltaridPreguntaEvaluacion;
	}

	public void setResaltaridPreguntaEvaluacion(Border borderResaltar) {
		this.resaltaridPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostraridPreguntaEvaluacion() {
		return this.mostraridPreguntaEvaluacion;
	}

	public void setMostraridPreguntaEvaluacion(Boolean mostraridPreguntaEvaluacion) {
		this.mostraridPreguntaEvaluacion= mostraridPreguntaEvaluacion;
	}

	public Boolean getActivaridPreguntaEvaluacion() {
		return this.activaridPreguntaEvaluacion;
	}

	public void setActivaridPreguntaEvaluacion(Boolean activaridPreguntaEvaluacion) {
		this.activaridPreguntaEvaluacion= activaridPreguntaEvaluacion;
	}

	public Border setResaltarid_empresaPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPreguntaEvaluacion() {
		return this.resaltarid_empresaPreguntaEvaluacion;
	}

	public void setResaltarid_empresaPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_empresaPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaPreguntaEvaluacion() {
		return this.mostrarid_empresaPreguntaEvaluacion;
	}

	public void setMostrarid_empresaPreguntaEvaluacion(Boolean mostrarid_empresaPreguntaEvaluacion) {
		this.mostrarid_empresaPreguntaEvaluacion= mostrarid_empresaPreguntaEvaluacion;
	}

	public Boolean getActivarid_empresaPreguntaEvaluacion() {
		return this.activarid_empresaPreguntaEvaluacion;
	}

	public void setActivarid_empresaPreguntaEvaluacion(Boolean activarid_empresaPreguntaEvaluacion) {
		this.activarid_empresaPreguntaEvaluacion= activarid_empresaPreguntaEvaluacion;
	}

	public Boolean getCargarid_empresaPreguntaEvaluacion() {
		return this.cargarid_empresaPreguntaEvaluacion;
	}

	public void setCargarid_empresaPreguntaEvaluacion(Boolean cargarid_empresaPreguntaEvaluacion) {
		this.cargarid_empresaPreguntaEvaluacion= cargarid_empresaPreguntaEvaluacion;
	}

	public Border setResaltarid_sucursalPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPreguntaEvaluacion() {
		return this.resaltarid_sucursalPreguntaEvaluacion;
	}

	public void setResaltarid_sucursalPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_sucursalPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPreguntaEvaluacion() {
		return this.mostrarid_sucursalPreguntaEvaluacion;
	}

	public void setMostrarid_sucursalPreguntaEvaluacion(Boolean mostrarid_sucursalPreguntaEvaluacion) {
		this.mostrarid_sucursalPreguntaEvaluacion= mostrarid_sucursalPreguntaEvaluacion;
	}

	public Boolean getActivarid_sucursalPreguntaEvaluacion() {
		return this.activarid_sucursalPreguntaEvaluacion;
	}

	public void setActivarid_sucursalPreguntaEvaluacion(Boolean activarid_sucursalPreguntaEvaluacion) {
		this.activarid_sucursalPreguntaEvaluacion= activarid_sucursalPreguntaEvaluacion;
	}

	public Boolean getCargarid_sucursalPreguntaEvaluacion() {
		return this.cargarid_sucursalPreguntaEvaluacion;
	}

	public void setCargarid_sucursalPreguntaEvaluacion(Boolean cargarid_sucursalPreguntaEvaluacion) {
		this.cargarid_sucursalPreguntaEvaluacion= cargarid_sucursalPreguntaEvaluacion;
	}

	public Border setResaltarid_ejercicioPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPreguntaEvaluacion() {
		return this.resaltarid_ejercicioPreguntaEvaluacion;
	}

	public void setResaltarid_ejercicioPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_ejercicioPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPreguntaEvaluacion() {
		return this.mostrarid_ejercicioPreguntaEvaluacion;
	}

	public void setMostrarid_ejercicioPreguntaEvaluacion(Boolean mostrarid_ejercicioPreguntaEvaluacion) {
		this.mostrarid_ejercicioPreguntaEvaluacion= mostrarid_ejercicioPreguntaEvaluacion;
	}

	public Boolean getActivarid_ejercicioPreguntaEvaluacion() {
		return this.activarid_ejercicioPreguntaEvaluacion;
	}

	public void setActivarid_ejercicioPreguntaEvaluacion(Boolean activarid_ejercicioPreguntaEvaluacion) {
		this.activarid_ejercicioPreguntaEvaluacion= activarid_ejercicioPreguntaEvaluacion;
	}

	public Boolean getCargarid_ejercicioPreguntaEvaluacion() {
		return this.cargarid_ejercicioPreguntaEvaluacion;
	}

	public void setCargarid_ejercicioPreguntaEvaluacion(Boolean cargarid_ejercicioPreguntaEvaluacion) {
		this.cargarid_ejercicioPreguntaEvaluacion= cargarid_ejercicioPreguntaEvaluacion;
	}

	public Border setResaltarid_periodoPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_periodoPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPreguntaEvaluacion() {
		return this.resaltarid_periodoPreguntaEvaluacion;
	}

	public void setResaltarid_periodoPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_periodoPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_periodoPreguntaEvaluacion() {
		return this.mostrarid_periodoPreguntaEvaluacion;
	}

	public void setMostrarid_periodoPreguntaEvaluacion(Boolean mostrarid_periodoPreguntaEvaluacion) {
		this.mostrarid_periodoPreguntaEvaluacion= mostrarid_periodoPreguntaEvaluacion;
	}

	public Boolean getActivarid_periodoPreguntaEvaluacion() {
		return this.activarid_periodoPreguntaEvaluacion;
	}

	public void setActivarid_periodoPreguntaEvaluacion(Boolean activarid_periodoPreguntaEvaluacion) {
		this.activarid_periodoPreguntaEvaluacion= activarid_periodoPreguntaEvaluacion;
	}

	public Boolean getCargarid_periodoPreguntaEvaluacion() {
		return this.cargarid_periodoPreguntaEvaluacion;
	}

	public void setCargarid_periodoPreguntaEvaluacion(Boolean cargarid_periodoPreguntaEvaluacion) {
		this.cargarid_periodoPreguntaEvaluacion= cargarid_periodoPreguntaEvaluacion;
	}

	public Border setResaltarpreguntaPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarpreguntaPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreguntaPreguntaEvaluacion() {
		return this.resaltarpreguntaPreguntaEvaluacion;
	}

	public void setResaltarpreguntaPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarpreguntaPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarpreguntaPreguntaEvaluacion() {
		return this.mostrarpreguntaPreguntaEvaluacion;
	}

	public void setMostrarpreguntaPreguntaEvaluacion(Boolean mostrarpreguntaPreguntaEvaluacion) {
		this.mostrarpreguntaPreguntaEvaluacion= mostrarpreguntaPreguntaEvaluacion;
	}

	public Boolean getActivarpreguntaPreguntaEvaluacion() {
		return this.activarpreguntaPreguntaEvaluacion;
	}

	public void setActivarpreguntaPreguntaEvaluacion(Boolean activarpreguntaPreguntaEvaluacion) {
		this.activarpreguntaPreguntaEvaluacion= activarpreguntaPreguntaEvaluacion;
	}

	public Border setResaltarcalificacionPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarcalificacionPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcalificacionPreguntaEvaluacion() {
		return this.resaltarcalificacionPreguntaEvaluacion;
	}

	public void setResaltarcalificacionPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarcalificacionPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarcalificacionPreguntaEvaluacion() {
		return this.mostrarcalificacionPreguntaEvaluacion;
	}

	public void setMostrarcalificacionPreguntaEvaluacion(Boolean mostrarcalificacionPreguntaEvaluacion) {
		this.mostrarcalificacionPreguntaEvaluacion= mostrarcalificacionPreguntaEvaluacion;
	}

	public Boolean getActivarcalificacionPreguntaEvaluacion() {
		return this.activarcalificacionPreguntaEvaluacion;
	}

	public void setActivarcalificacionPreguntaEvaluacion(Boolean activarcalificacionPreguntaEvaluacion) {
		this.activarcalificacionPreguntaEvaluacion= activarcalificacionPreguntaEvaluacion;
	}

	public Border setResaltarordenPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarordenPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPreguntaEvaluacion() {
		return this.resaltarordenPreguntaEvaluacion;
	}

	public void setResaltarordenPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarordenPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarordenPreguntaEvaluacion() {
		return this.mostrarordenPreguntaEvaluacion;
	}

	public void setMostrarordenPreguntaEvaluacion(Boolean mostrarordenPreguntaEvaluacion) {
		this.mostrarordenPreguntaEvaluacion= mostrarordenPreguntaEvaluacion;
	}

	public Boolean getActivarordenPreguntaEvaluacion() {
		return this.activarordenPreguntaEvaluacion;
	}

	public void setActivarordenPreguntaEvaluacion(Boolean activarordenPreguntaEvaluacion) {
		this.activarordenPreguntaEvaluacion= activarordenPreguntaEvaluacion;
	}

	public Border setResaltarid_anioPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_anioPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPreguntaEvaluacion() {
		return this.resaltarid_anioPreguntaEvaluacion;
	}

	public void setResaltarid_anioPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_anioPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_anioPreguntaEvaluacion() {
		return this.mostrarid_anioPreguntaEvaluacion;
	}

	public void setMostrarid_anioPreguntaEvaluacion(Boolean mostrarid_anioPreguntaEvaluacion) {
		this.mostrarid_anioPreguntaEvaluacion= mostrarid_anioPreguntaEvaluacion;
	}

	public Boolean getActivarid_anioPreguntaEvaluacion() {
		return this.activarid_anioPreguntaEvaluacion;
	}

	public void setActivarid_anioPreguntaEvaluacion(Boolean activarid_anioPreguntaEvaluacion) {
		this.activarid_anioPreguntaEvaluacion= activarid_anioPreguntaEvaluacion;
	}

	public Boolean getCargarid_anioPreguntaEvaluacion() {
		return this.cargarid_anioPreguntaEvaluacion;
	}

	public void setCargarid_anioPreguntaEvaluacion(Boolean cargarid_anioPreguntaEvaluacion) {
		this.cargarid_anioPreguntaEvaluacion= cargarid_anioPreguntaEvaluacion;
	}

	public Border setResaltarid_mesPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltar);
		
		this.resaltarid_mesPreguntaEvaluacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPreguntaEvaluacion() {
		return this.resaltarid_mesPreguntaEvaluacion;
	}

	public void setResaltarid_mesPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarid_mesPreguntaEvaluacion= borderResaltar;
	}

	public Boolean getMostrarid_mesPreguntaEvaluacion() {
		return this.mostrarid_mesPreguntaEvaluacion;
	}

	public void setMostrarid_mesPreguntaEvaluacion(Boolean mostrarid_mesPreguntaEvaluacion) {
		this.mostrarid_mesPreguntaEvaluacion= mostrarid_mesPreguntaEvaluacion;
	}

	public Boolean getActivarid_mesPreguntaEvaluacion() {
		return this.activarid_mesPreguntaEvaluacion;
	}

	public void setActivarid_mesPreguntaEvaluacion(Boolean activarid_mesPreguntaEvaluacion) {
		this.activarid_mesPreguntaEvaluacion= activarid_mesPreguntaEvaluacion;
	}

	public Boolean getCargarid_mesPreguntaEvaluacion() {
		return this.cargarid_mesPreguntaEvaluacion;
	}

	public void setCargarid_mesPreguntaEvaluacion(Boolean cargarid_mesPreguntaEvaluacion) {
		this.cargarid_mesPreguntaEvaluacion= cargarid_mesPreguntaEvaluacion;
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
		
		
		this.setMostraridPreguntaEvaluacion(esInicial);
		this.setMostrarid_empresaPreguntaEvaluacion(esInicial);
		this.setMostrarid_sucursalPreguntaEvaluacion(esInicial);
		this.setMostrarid_ejercicioPreguntaEvaluacion(esInicial);
		this.setMostrarid_periodoPreguntaEvaluacion(esInicial);
		this.setMostrarpreguntaPreguntaEvaluacion(esInicial);
		this.setMostrarcalificacionPreguntaEvaluacion(esInicial);
		this.setMostrarordenPreguntaEvaluacion(esInicial);
		this.setMostrarid_anioPreguntaEvaluacion(esInicial);
		this.setMostrarid_mesPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ID)) {
				this.setMostraridPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setMostrarpreguntaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.CALIFICACION)) {
				this.setMostrarcalificacionPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setMostrarordenPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPreguntaEvaluacion(esAsigna);
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
		
		
		this.setActivaridPreguntaEvaluacion(esInicial);
		this.setActivarid_empresaPreguntaEvaluacion(esInicial);
		this.setActivarid_sucursalPreguntaEvaluacion(esInicial);
		this.setActivarid_ejercicioPreguntaEvaluacion(esInicial);
		this.setActivarid_periodoPreguntaEvaluacion(esInicial);
		this.setActivarpreguntaPreguntaEvaluacion(esInicial);
		this.setActivarcalificacionPreguntaEvaluacion(esInicial);
		this.setActivarordenPreguntaEvaluacion(esInicial);
		this.setActivarid_anioPreguntaEvaluacion(esInicial);
		this.setActivarid_mesPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ID)) {
				this.setActivaridPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setActivarpreguntaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.CALIFICACION)) {
				this.setActivarcalificacionPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setActivarordenPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDMES)) {
				this.setActivarid_mesPreguntaEvaluacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPreguntaEvaluacion(esInicial);
		this.setResaltarid_empresaPreguntaEvaluacion(esInicial);
		this.setResaltarid_sucursalPreguntaEvaluacion(esInicial);
		this.setResaltarid_ejercicioPreguntaEvaluacion(esInicial);
		this.setResaltarid_periodoPreguntaEvaluacion(esInicial);
		this.setResaltarpreguntaPreguntaEvaluacion(esInicial);
		this.setResaltarcalificacionPreguntaEvaluacion(esInicial);
		this.setResaltarordenPreguntaEvaluacion(esInicial);
		this.setResaltarid_anioPreguntaEvaluacion(esInicial);
		this.setResaltarid_mesPreguntaEvaluacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ID)) {
				this.setResaltaridPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.PREGUNTA)) {
				this.setResaltarpreguntaPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.CALIFICACION)) {
				this.setResaltarcalificacionPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.ORDEN)) {
				this.setResaltarordenPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEvaluacionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPreguntaEvaluacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleEvaluacionProveedorPreguntaEvaluacion=null;

	public Border getResaltarDetalleEvaluacionProveedorPreguntaEvaluacion() {
		return this.resaltarDetalleEvaluacionProveedorPreguntaEvaluacion;
	}

	public void setResaltarDetalleEvaluacionProveedorPreguntaEvaluacion(Border borderResaltarDetalleEvaluacionProveedor) {
		if(borderResaltarDetalleEvaluacionProveedor!=null) {
			this.resaltarDetalleEvaluacionProveedorPreguntaEvaluacion= borderResaltarDetalleEvaluacionProveedor;
		}
	}

	public Border setResaltarDetalleEvaluacionProveedorPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltarDetalleEvaluacionProveedor);
			
		this.resaltarDetalleEvaluacionProveedorPreguntaEvaluacion= borderResaltarDetalleEvaluacionProveedor;

		 return borderResaltarDetalleEvaluacionProveedor;
	}



	public Boolean mostrarDetalleEvaluacionProveedorPreguntaEvaluacion=true;

	public Boolean getMostrarDetalleEvaluacionProveedorPreguntaEvaluacion() {
		return this.mostrarDetalleEvaluacionProveedorPreguntaEvaluacion;
	}

	public void setMostrarDetalleEvaluacionProveedorPreguntaEvaluacion(Boolean visibilidadResaltarDetalleEvaluacionProveedor) {
		this.mostrarDetalleEvaluacionProveedorPreguntaEvaluacion= visibilidadResaltarDetalleEvaluacionProveedor;
	}



	public Boolean activarDetalleEvaluacionProveedorPreguntaEvaluacion=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionProveedorPreguntaEvaluacion() {
		return this.activarDetalleEvaluacionProveedorPreguntaEvaluacion;
	}

	public void setActivarDetalleEvaluacionProveedorPreguntaEvaluacion(Boolean habilitarResaltarDetalleEvaluacionProveedor) {
		this.activarDetalleEvaluacionProveedorPreguntaEvaluacion= habilitarResaltarDetalleEvaluacionProveedor;
	}


	public Border resaltarSubPreguntaEvaluacionPreguntaEvaluacion=null;

	public Border getResaltarSubPreguntaEvaluacionPreguntaEvaluacion() {
		return this.resaltarSubPreguntaEvaluacionPreguntaEvaluacion;
	}

	public void setResaltarSubPreguntaEvaluacionPreguntaEvaluacion(Border borderResaltarSubPreguntaEvaluacion) {
		if(borderResaltarSubPreguntaEvaluacion!=null) {
			this.resaltarSubPreguntaEvaluacionPreguntaEvaluacion= borderResaltarSubPreguntaEvaluacion;
		}
	}

	public Border setResaltarSubPreguntaEvaluacionPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltarSubPreguntaEvaluacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//preguntaevaluacionBeanSwingJInternalFrame.jTtoolBarPreguntaEvaluacion.setBorder(borderResaltarSubPreguntaEvaluacion);
			
		this.resaltarSubPreguntaEvaluacionPreguntaEvaluacion= borderResaltarSubPreguntaEvaluacion;

		 return borderResaltarSubPreguntaEvaluacion;
	}



	public Boolean mostrarSubPreguntaEvaluacionPreguntaEvaluacion=true;

	public Boolean getMostrarSubPreguntaEvaluacionPreguntaEvaluacion() {
		return this.mostrarSubPreguntaEvaluacionPreguntaEvaluacion;
	}

	public void setMostrarSubPreguntaEvaluacionPreguntaEvaluacion(Boolean visibilidadResaltarSubPreguntaEvaluacion) {
		this.mostrarSubPreguntaEvaluacionPreguntaEvaluacion= visibilidadResaltarSubPreguntaEvaluacion;
	}



	public Boolean activarSubPreguntaEvaluacionPreguntaEvaluacion=true;

	public Boolean gethabilitarResaltarSubPreguntaEvaluacionPreguntaEvaluacion() {
		return this.activarSubPreguntaEvaluacionPreguntaEvaluacion;
	}

	public void setActivarSubPreguntaEvaluacionPreguntaEvaluacion(Boolean habilitarResaltarSubPreguntaEvaluacion) {
		this.activarSubPreguntaEvaluacionPreguntaEvaluacion= habilitarResaltarSubPreguntaEvaluacion;
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

		this.setMostrarDetalleEvaluacionProveedorPreguntaEvaluacion(esInicial);
		this.setMostrarSubPreguntaEvaluacionPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setMostrarDetalleEvaluacionProveedorPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubPreguntaEvaluacion.class)) {
				this.setMostrarSubPreguntaEvaluacionPreguntaEvaluacion(esAsigna);
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

		this.setActivarDetalleEvaluacionProveedorPreguntaEvaluacion(esInicial);
		this.setActivarSubPreguntaEvaluacionPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setActivarDetalleEvaluacionProveedorPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubPreguntaEvaluacion.class)) {
				this.setActivarSubPreguntaEvaluacionPreguntaEvaluacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleEvaluacionProveedorPreguntaEvaluacion(esInicial);
		this.setResaltarSubPreguntaEvaluacionPreguntaEvaluacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setResaltarDetalleEvaluacionProveedorPreguntaEvaluacion(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubPreguntaEvaluacion.class)) {
				this.setResaltarSubPreguntaEvaluacionPreguntaEvaluacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion=true;

	public Boolean getMostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion() {
		return this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion;
	}

	public void setMostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorPreguntaPreguntaEvaluacion=true;

	public Boolean getMostrarBusquedaPorPreguntaPreguntaEvaluacion() {
		return this.mostrarBusquedaPorPreguntaPreguntaEvaluacion;
	}

	public void setMostrarBusquedaPorPreguntaPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorPreguntaPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdEmpresaPreguntaEvaluacion() {
		return this.mostrarFK_IdEmpresaPreguntaEvaluacion;
	}

	public void setMostrarFK_IdEmpresaPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPreguntaEvaluacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPreguntaEvaluacion=true;

	public Boolean getMostrarFK_IdSucursalPreguntaEvaluacion() {
		return this.mostrarFK_IdSucursalPreguntaEvaluacion;
	}

	public void setMostrarFK_IdSucursalPreguntaEvaluacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPreguntaEvaluacion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion=true;

	public Boolean getActivarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion() {
		return this.activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion;
	}

	public void setActivarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorPreguntaPreguntaEvaluacion=true;

	public Boolean getActivarBusquedaPorPreguntaPreguntaEvaluacion() {
		return this.activarBusquedaPorPreguntaPreguntaEvaluacion;
	}

	public void setActivarBusquedaPorPreguntaPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarBusquedaPorPreguntaPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdEmpresaPreguntaEvaluacion() {
		return this.activarFK_IdEmpresaPreguntaEvaluacion;
	}

	public void setActivarFK_IdEmpresaPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPreguntaEvaluacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPreguntaEvaluacion=true;

	public Boolean getActivarFK_IdSucursalPreguntaEvaluacion() {
		return this.activarFK_IdSucursalPreguntaEvaluacion;
	}

	public void setActivarFK_IdSucursalPreguntaEvaluacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPreguntaEvaluacion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion=null;

	public Border getResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion() {
		return this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarBusquedaPorPreguntaPreguntaEvaluacion=null;

	public Border getResaltarBusquedaPorPreguntaPreguntaEvaluacion() {
		return this.resaltarBusquedaPorPreguntaPreguntaEvaluacion;
	}

	public void setResaltarBusquedaPorPreguntaPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarBusquedaPorPreguntaPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarBusquedaPorPreguntaPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorPreguntaPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPreguntaEvaluacion=null;

	public Border getResaltarFK_IdEmpresaPreguntaEvaluacion() {
		return this.resaltarFK_IdEmpresaPreguntaEvaluacion;
	}

	public void setResaltarFK_IdEmpresaPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPreguntaEvaluacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPreguntaEvaluacion=null;

	public Border getResaltarFK_IdSucursalPreguntaEvaluacion() {
		return this.resaltarFK_IdSucursalPreguntaEvaluacion;
	}

	public void setResaltarFK_IdSucursalPreguntaEvaluacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalPreguntaEvaluacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPreguntaEvaluacion(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEvaluacionBeanSwingJInternalFrame preguntaevaluacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPreguntaEvaluacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}