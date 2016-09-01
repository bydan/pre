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


import com.bydan.erp.cartera.util.PreguntaEquivalenciaConstantesFunciones;
import com.bydan.erp.cartera.util.PreguntaEquivalenciaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PreguntaEquivalenciaParameterGeneral;

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
final public class PreguntaEquivalenciaConstantesFunciones extends PreguntaEquivalenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PreguntaEquivalencia";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PreguntaEquivalencia"+PreguntaEquivalenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PreguntaEquivalenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PreguntaEquivalenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PreguntaEquivalenciaConstantesFunciones.SCHEMA+"_"+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaEquivalenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PreguntaEquivalenciaConstantesFunciones.SCHEMA+"_"+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PreguntaEquivalenciaConstantesFunciones.SCHEMA+"_"+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PreguntaEquivalenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PreguntaEquivalenciaConstantesFunciones.SCHEMA+"_"+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaEquivalenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PreguntaEquivalenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PreguntaEquivalenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PreguntaEquivalenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PreguntaEquivalenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PreguntaEquivalenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PreguntaEquivalenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Preguntas Equivalencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Preguntas Equivalencia";
	public static final String SCLASSWEBTITULO_LOWER="Pregunta Equivalencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PreguntaEquivalencia";
	public static final String OBJECTNAME="preguntaequivalencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="pregunta_equivalencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select preguntaequivalencia from "+PreguntaEquivalenciaConstantesFunciones.SPERSISTENCENAME+" preguntaequivalencia";
	public static String QUERYSELECTNATIVE="select "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".version_row,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_sucursal,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_periodo,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".descripcion,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".desde,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".hasta,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".orden,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_anio,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_mes from "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME;//+" as "+PreguntaEquivalenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PreguntaEquivalenciaConstantesFuncionesAdditional preguntaequivalenciaConstantesFuncionesAdditional=null;
	
	public PreguntaEquivalenciaConstantesFuncionesAdditional getPreguntaEquivalenciaConstantesFuncionesAdditional() {
		return this.preguntaequivalenciaConstantesFuncionesAdditional;
	}
	
	public void setPreguntaEquivalenciaConstantesFuncionesAdditional(PreguntaEquivalenciaConstantesFuncionesAdditional preguntaequivalenciaConstantesFuncionesAdditional) {
		try {
			this.preguntaequivalenciaConstantesFuncionesAdditional=preguntaequivalenciaConstantesFuncionesAdditional;
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
    public static final String DESCRIPCION= "descripcion";
    public static final String DESDE= "desde";
    public static final String HASTA= "hasta";
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
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESDE= "Desde";
		public static final String LABEL_DESDE_LOWER= "Desde";
    	public static final String LABEL_HASTA= "Hasta";
		public static final String LABEL_HASTA_LOWER= "Hasta";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getPreguntaEquivalenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDPERIODO)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.DESCRIPCION)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.DESDE)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.HASTA)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.ORDEN)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDANIO)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PreguntaEquivalenciaConstantesFunciones.IDMES)) {sLabelColumna=PreguntaEquivalenciaConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPreguntaEquivalenciaDescripcion(PreguntaEquivalencia preguntaequivalencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(preguntaequivalencia !=null/* && preguntaequivalencia.getId()!=0*/) {
			if(preguntaequivalencia.getId()!=null) {
				sDescripcion=preguntaequivalencia.getId().toString();
			}//preguntaequivalenciapreguntaequivalencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPreguntaEquivalenciaDescripcionDetallado(PreguntaEquivalencia preguntaequivalencia) {
		String sDescripcion="";
			
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.ID+"=";
		sDescripcion+=preguntaequivalencia.getId().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=preguntaequivalencia.getVersionRow().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=preguntaequivalencia.getid_empresa().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=preguntaequivalencia.getid_sucursal().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=preguntaequivalencia.getid_ejercicio().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=preguntaequivalencia.getid_periodo().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=preguntaequivalencia.getdescripcion()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.DESDE+"=";
		sDescripcion+=preguntaequivalencia.getdesde().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.HASTA+"=";
		sDescripcion+=preguntaequivalencia.gethasta().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.ORDEN+"=";
		sDescripcion+=preguntaequivalencia.getorden().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDANIO+"=";
		sDescripcion+=preguntaequivalencia.getid_anio().toString()+",";
		sDescripcion+=PreguntaEquivalenciaConstantesFunciones.IDMES+"=";
		sDescripcion+=preguntaequivalencia.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPreguntaEquivalenciaDescripcion(PreguntaEquivalencia preguntaequivalencia,String sValor) throws Exception {			
		if(preguntaequivalencia !=null) {
			//preguntaequivalenciapreguntaequivalencia.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		preguntaequivalencia.setdescripcion(preguntaequivalencia.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPreguntaEquivalencias(List<PreguntaEquivalencia> preguntaequivalencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PreguntaEquivalencia preguntaequivalencia: preguntaequivalencias) {
			preguntaequivalencia.setdescripcion(preguntaequivalencia.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && preguntaequivalencia.getConCambioAuxiliar()) {
			preguntaequivalencia.setIsDeleted(preguntaequivalencia.getIsDeletedAuxiliar());	
			preguntaequivalencia.setIsNew(preguntaequivalencia.getIsNewAuxiliar());	
			preguntaequivalencia.setIsChanged(preguntaequivalencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			preguntaequivalencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			preguntaequivalencia.setIsDeletedAuxiliar(false);	
			preguntaequivalencia.setIsNewAuxiliar(false);	
			preguntaequivalencia.setIsChangedAuxiliar(false);
			
			preguntaequivalencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPreguntaEquivalencias(List<PreguntaEquivalencia> preguntaequivalencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PreguntaEquivalencia preguntaequivalencia : preguntaequivalencias) {
			if(conAsignarBase && preguntaequivalencia.getConCambioAuxiliar()) {
				preguntaequivalencia.setIsDeleted(preguntaequivalencia.getIsDeletedAuxiliar());	
				preguntaequivalencia.setIsNew(preguntaequivalencia.getIsNewAuxiliar());	
				preguntaequivalencia.setIsChanged(preguntaequivalencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				preguntaequivalencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				preguntaequivalencia.setIsDeletedAuxiliar(false);	
				preguntaequivalencia.setIsNewAuxiliar(false);	
				preguntaequivalencia.setIsChangedAuxiliar(false);
				
				preguntaequivalencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia,Boolean conEnteros) throws Exception  {
		preguntaequivalencia.setdesde(0.0);
		preguntaequivalencia.sethasta(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			preguntaequivalencia.setorden(0);
		}
	}		
	
	public static void InicializarValoresPreguntaEquivalencias(List<PreguntaEquivalencia> preguntaequivalencias,Boolean conEnteros) throws Exception  {
		
		for(PreguntaEquivalencia preguntaequivalencia: preguntaequivalencias) {
			preguntaequivalencia.setdesde(0.0);
			preguntaequivalencia.sethasta(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				preguntaequivalencia.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPreguntaEquivalencia(List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalencia preguntaequivalenciaAux) throws Exception  {
		PreguntaEquivalenciaConstantesFunciones.InicializarValoresPreguntaEquivalencia(preguntaequivalenciaAux,true);
		
		for(PreguntaEquivalencia preguntaequivalencia: preguntaequivalencias) {
			if(preguntaequivalencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			preguntaequivalenciaAux.setdesde(preguntaequivalenciaAux.getdesde()+preguntaequivalencia.getdesde());			
			preguntaequivalenciaAux.sethasta(preguntaequivalenciaAux.gethasta()+preguntaequivalencia.gethasta());			
			preguntaequivalenciaAux.setorden(preguntaequivalenciaAux.getorden()+preguntaequivalencia.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaEquivalencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PreguntaEquivalenciaConstantesFunciones.getArrayColumnasGlobalesPreguntaEquivalencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPreguntaEquivalencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PreguntaEquivalenciaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPreguntaEquivalencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PreguntaEquivalenciaConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalencia preguntaequivalencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PreguntaEquivalencia preguntaequivalenciaAux: preguntaequivalencias) {
			if(preguntaequivalenciaAux!=null && preguntaequivalencia!=null) {
				if((preguntaequivalenciaAux.getId()==null && preguntaequivalencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(preguntaequivalenciaAux.getId()!=null && preguntaequivalencia.getId()!=null){
					if(preguntaequivalenciaAux.getId().equals(preguntaequivalencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPreguntaEquivalencia(List<PreguntaEquivalencia> preguntaequivalencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double desdeTotal=0.0;
		Double hastaTotal=0.0;
	
		for(PreguntaEquivalencia preguntaequivalencia: preguntaequivalencias) {			
			if(preguntaequivalencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			desdeTotal+=preguntaequivalencia.getdesde();
			hastaTotal+=preguntaequivalencia.gethasta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PreguntaEquivalenciaConstantesFunciones.DESDE);
		datoGeneral.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE);
		datoGeneral.setdValorDouble(desdeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PreguntaEquivalenciaConstantesFunciones.HASTA);
		datoGeneral.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA);
		datoGeneral.setdValorDouble(hastaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPreguntaEquivalencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_ID, PreguntaEquivalenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_VERSIONROW, PreguntaEquivalenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDEMPRESA, PreguntaEquivalenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDSUCURSAL, PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDEJERCICIO, PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDPERIODO, PreguntaEquivalenciaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_DESCRIPCION, PreguntaEquivalenciaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE, PreguntaEquivalenciaConstantesFunciones.DESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA, PreguntaEquivalenciaConstantesFunciones.HASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_ORDEN, PreguntaEquivalenciaConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDANIO, PreguntaEquivalenciaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PreguntaEquivalenciaConstantesFunciones.LABEL_IDMES, PreguntaEquivalenciaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPreguntaEquivalencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.DESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.HASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PreguntaEquivalenciaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEquivalencia() throws Exception  {
		return PreguntaEquivalenciaConstantesFunciones.getTiposSeleccionarPreguntaEquivalencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEquivalencia(Boolean conFk) throws Exception  {
		return PreguntaEquivalenciaConstantesFunciones.getTiposSeleccionarPreguntaEquivalencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPreguntaEquivalencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PreguntaEquivalenciaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PreguntaEquivalenciaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPreguntaEquivalencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalenciaAux) throws Exception {
		
			preguntaequivalenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntaequivalenciaAux.getEmpresa()));
			preguntaequivalenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(preguntaequivalenciaAux.getSucursal()));
			preguntaequivalenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(preguntaequivalenciaAux.getEjercicio()));
			preguntaequivalenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(preguntaequivalenciaAux.getPeriodo()));
			preguntaequivalenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(preguntaequivalenciaAux.getAnio()));
			preguntaequivalenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(preguntaequivalenciaAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPreguntaEquivalencia(List<PreguntaEquivalencia> preguntaequivalenciasTemp) throws Exception {
		for(PreguntaEquivalencia preguntaequivalenciaAux:preguntaequivalenciasTemp) {
			
			preguntaequivalenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(preguntaequivalenciaAux.getEmpresa()));
			preguntaequivalenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(preguntaequivalenciaAux.getSucursal()));
			preguntaequivalenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(preguntaequivalenciaAux.getEjercicio()));
			preguntaequivalenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(preguntaequivalenciaAux.getPeriodo()));
			preguntaequivalenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(preguntaequivalenciaAux.getAnio()));
			preguntaequivalenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(preguntaequivalenciaAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaEquivalencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPreguntaEquivalencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEquivalencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaEquivalenciaConstantesFunciones.getClassesRelationshipsOfPreguntaEquivalencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEquivalencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaEquivalencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PreguntaEquivalenciaConstantesFunciones.getClassesRelationshipsFromStringsOfPreguntaEquivalencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPreguntaEquivalencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PreguntaEquivalencia preguntaequivalencia,List<PreguntaEquivalencia> preguntaequivalencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PreguntaEquivalencia preguntaequivalenciaEncontrado=null;
			
			for(PreguntaEquivalencia preguntaequivalenciaLocal:preguntaequivalencias) {
				if(preguntaequivalenciaLocal.getId().equals(preguntaequivalencia.getId())) {
					preguntaequivalenciaEncontrado=preguntaequivalenciaLocal;
					
					preguntaequivalenciaLocal.setIsChanged(preguntaequivalencia.getIsChanged());
					preguntaequivalenciaLocal.setIsNew(preguntaequivalencia.getIsNew());
					preguntaequivalenciaLocal.setIsDeleted(preguntaequivalencia.getIsDeleted());
					
					preguntaequivalenciaLocal.setGeneralEntityOriginal(preguntaequivalencia.getGeneralEntityOriginal());
					
					preguntaequivalenciaLocal.setId(preguntaequivalencia.getId());	
					preguntaequivalenciaLocal.setVersionRow(preguntaequivalencia.getVersionRow());	
					preguntaequivalenciaLocal.setid_empresa(preguntaequivalencia.getid_empresa());	
					preguntaequivalenciaLocal.setid_sucursal(preguntaequivalencia.getid_sucursal());	
					preguntaequivalenciaLocal.setid_ejercicio(preguntaequivalencia.getid_ejercicio());	
					preguntaequivalenciaLocal.setid_periodo(preguntaequivalencia.getid_periodo());	
					preguntaequivalenciaLocal.setdescripcion(preguntaequivalencia.getdescripcion());	
					preguntaequivalenciaLocal.setdesde(preguntaequivalencia.getdesde());	
					preguntaequivalenciaLocal.sethasta(preguntaequivalencia.gethasta());	
					preguntaequivalenciaLocal.setorden(preguntaequivalencia.getorden());	
					preguntaequivalenciaLocal.setid_anio(preguntaequivalencia.getid_anio());	
					preguntaequivalenciaLocal.setid_mes(preguntaequivalencia.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!preguntaequivalencia.getIsDeleted()) {
				if(!existe) {
					preguntaequivalencias.add(preguntaequivalencia);
				}
			} else {
				if(preguntaequivalenciaEncontrado!=null && permiteQuitar)  {
					preguntaequivalencias.remove(preguntaequivalenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PreguntaEquivalencia preguntaequivalencia,List<PreguntaEquivalencia> preguntaequivalencias) throws Exception {
		try	{			
			for(PreguntaEquivalencia preguntaequivalenciaLocal:preguntaequivalencias) {
				if(preguntaequivalenciaLocal.getId().equals(preguntaequivalencia.getId())) {
					preguntaequivalenciaLocal.setIsSelected(preguntaequivalencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPreguntaEquivalencia(List<PreguntaEquivalencia> preguntaequivalenciasAux) throws Exception {
		//this.preguntaequivalenciasAux=preguntaequivalenciasAux;
		
		for(PreguntaEquivalencia preguntaequivalenciaAux:preguntaequivalenciasAux) {
			if(preguntaequivalenciaAux.getIsChanged()) {
				preguntaequivalenciaAux.setIsChanged(false);
			}		
			
			if(preguntaequivalenciaAux.getIsNew()) {
				preguntaequivalenciaAux.setIsNew(false);
			}	
			
			if(preguntaequivalenciaAux.getIsDeleted()) {
				preguntaequivalenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalenciaAux) throws Exception {
		//this.preguntaequivalenciaAux=preguntaequivalenciaAux;
		
			if(preguntaequivalenciaAux.getIsChanged()) {
				preguntaequivalenciaAux.setIsChanged(false);
			}		
			
			if(preguntaequivalenciaAux.getIsNew()) {
				preguntaequivalenciaAux.setIsNew(false);
			}	
			
			if(preguntaequivalenciaAux.getIsDeleted()) {
				preguntaequivalenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PreguntaEquivalencia preguntaequivalenciaAsignar,PreguntaEquivalencia preguntaequivalencia) throws Exception {
		preguntaequivalenciaAsignar.setId(preguntaequivalencia.getId());	
		preguntaequivalenciaAsignar.setVersionRow(preguntaequivalencia.getVersionRow());	
		preguntaequivalenciaAsignar.setid_empresa(preguntaequivalencia.getid_empresa());
		preguntaequivalenciaAsignar.setempresa_descripcion(preguntaequivalencia.getempresa_descripcion());	
		preguntaequivalenciaAsignar.setid_sucursal(preguntaequivalencia.getid_sucursal());
		preguntaequivalenciaAsignar.setsucursal_descripcion(preguntaequivalencia.getsucursal_descripcion());	
		preguntaequivalenciaAsignar.setid_ejercicio(preguntaequivalencia.getid_ejercicio());
		preguntaequivalenciaAsignar.setejercicio_descripcion(preguntaequivalencia.getejercicio_descripcion());	
		preguntaequivalenciaAsignar.setid_periodo(preguntaequivalencia.getid_periodo());
		preguntaequivalenciaAsignar.setperiodo_descripcion(preguntaequivalencia.getperiodo_descripcion());	
		preguntaequivalenciaAsignar.setdescripcion(preguntaequivalencia.getdescripcion());	
		preguntaequivalenciaAsignar.setdesde(preguntaequivalencia.getdesde());	
		preguntaequivalenciaAsignar.sethasta(preguntaequivalencia.gethasta());	
		preguntaequivalenciaAsignar.setorden(preguntaequivalencia.getorden());	
		preguntaequivalenciaAsignar.setid_anio(preguntaequivalencia.getid_anio());
		preguntaequivalenciaAsignar.setanio_descripcion(preguntaequivalencia.getanio_descripcion());	
		preguntaequivalenciaAsignar.setid_mes(preguntaequivalencia.getid_mes());
		preguntaequivalenciaAsignar.setmes_descripcion(preguntaequivalencia.getmes_descripcion());	
	}
	
	public static void inicializarPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia) throws Exception {
		try {
				preguntaequivalencia.setId(0L);	
					
				preguntaequivalencia.setid_empresa(-1L);	
				preguntaequivalencia.setid_sucursal(-1L);	
				preguntaequivalencia.setid_ejercicio(-1L);	
				preguntaequivalencia.setid_periodo(-1L);	
				preguntaequivalencia.setdescripcion("");	
				preguntaequivalencia.setdesde(0.0);	
				preguntaequivalencia.sethasta(0.0);	
				preguntaequivalencia.setorden(0);	
				preguntaequivalencia.setid_anio(null);	
				preguntaequivalencia.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPreguntaEquivalencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_DESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_HASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PreguntaEquivalenciaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPreguntaEquivalencia(String sTipo,Row row,Workbook workbook,PreguntaEquivalencia preguntaequivalencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getdesde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.gethasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(preguntaequivalencia.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPreguntaEquivalencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPreguntaEquivalencia() {
		return this.sFinalQueryPreguntaEquivalencia;
	}
	
	public void setsFinalQueryPreguntaEquivalencia(String sFinalQueryPreguntaEquivalencia) {
		this.sFinalQueryPreguntaEquivalencia= sFinalQueryPreguntaEquivalencia;
	}
	
	public Border resaltarSeleccionarPreguntaEquivalencia=null;
	
	public Border setResaltarSeleccionarPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPreguntaEquivalencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPreguntaEquivalencia() {
		return this.resaltarSeleccionarPreguntaEquivalencia;
	}
	
	public void setResaltarSeleccionarPreguntaEquivalencia(Border borderResaltarSeleccionarPreguntaEquivalencia) {
		this.resaltarSeleccionarPreguntaEquivalencia= borderResaltarSeleccionarPreguntaEquivalencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPreguntaEquivalencia=null;
	public Boolean mostraridPreguntaEquivalencia=true;
	public Boolean activaridPreguntaEquivalencia=true;

	public Border resaltarid_empresaPreguntaEquivalencia=null;
	public Boolean mostrarid_empresaPreguntaEquivalencia=true;
	public Boolean activarid_empresaPreguntaEquivalencia=true;
	public Boolean cargarid_empresaPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPreguntaEquivalencia=false;//ConEventDepend=true

	public Border resaltarid_sucursalPreguntaEquivalencia=null;
	public Boolean mostrarid_sucursalPreguntaEquivalencia=true;
	public Boolean activarid_sucursalPreguntaEquivalencia=true;
	public Boolean cargarid_sucursalPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPreguntaEquivalencia=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPreguntaEquivalencia=null;
	public Boolean mostrarid_ejercicioPreguntaEquivalencia=true;
	public Boolean activarid_ejercicioPreguntaEquivalencia=true;
	public Boolean cargarid_ejercicioPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPreguntaEquivalencia=false;//ConEventDepend=true

	public Border resaltarid_periodoPreguntaEquivalencia=null;
	public Boolean mostrarid_periodoPreguntaEquivalencia=true;
	public Boolean activarid_periodoPreguntaEquivalencia=true;
	public Boolean cargarid_periodoPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPreguntaEquivalencia=false;//ConEventDepend=true

	public Border resaltardescripcionPreguntaEquivalencia=null;
	public Boolean mostrardescripcionPreguntaEquivalencia=true;
	public Boolean activardescripcionPreguntaEquivalencia=true;

	public Border resaltardesdePreguntaEquivalencia=null;
	public Boolean mostrardesdePreguntaEquivalencia=true;
	public Boolean activardesdePreguntaEquivalencia=true;

	public Border resaltarhastaPreguntaEquivalencia=null;
	public Boolean mostrarhastaPreguntaEquivalencia=true;
	public Boolean activarhastaPreguntaEquivalencia=true;

	public Border resaltarordenPreguntaEquivalencia=null;
	public Boolean mostrarordenPreguntaEquivalencia=true;
	public Boolean activarordenPreguntaEquivalencia=true;

	public Border resaltarid_anioPreguntaEquivalencia=null;
	public Boolean mostrarid_anioPreguntaEquivalencia=true;
	public Boolean activarid_anioPreguntaEquivalencia=false;
	public Boolean cargarid_anioPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPreguntaEquivalencia=false;//ConEventDepend=true

	public Border resaltarid_mesPreguntaEquivalencia=null;
	public Boolean mostrarid_mesPreguntaEquivalencia=true;
	public Boolean activarid_mesPreguntaEquivalencia=false;
	public Boolean cargarid_mesPreguntaEquivalencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPreguntaEquivalencia=false;//ConEventDepend=true

	
	

	public Border setResaltaridPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltaridPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPreguntaEquivalencia() {
		return this.resaltaridPreguntaEquivalencia;
	}

	public void setResaltaridPreguntaEquivalencia(Border borderResaltar) {
		this.resaltaridPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostraridPreguntaEquivalencia() {
		return this.mostraridPreguntaEquivalencia;
	}

	public void setMostraridPreguntaEquivalencia(Boolean mostraridPreguntaEquivalencia) {
		this.mostraridPreguntaEquivalencia= mostraridPreguntaEquivalencia;
	}

	public Boolean getActivaridPreguntaEquivalencia() {
		return this.activaridPreguntaEquivalencia;
	}

	public void setActivaridPreguntaEquivalencia(Boolean activaridPreguntaEquivalencia) {
		this.activaridPreguntaEquivalencia= activaridPreguntaEquivalencia;
	}

	public Border setResaltarid_empresaPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPreguntaEquivalencia() {
		return this.resaltarid_empresaPreguntaEquivalencia;
	}

	public void setResaltarid_empresaPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_empresaPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaPreguntaEquivalencia() {
		return this.mostrarid_empresaPreguntaEquivalencia;
	}

	public void setMostrarid_empresaPreguntaEquivalencia(Boolean mostrarid_empresaPreguntaEquivalencia) {
		this.mostrarid_empresaPreguntaEquivalencia= mostrarid_empresaPreguntaEquivalencia;
	}

	public Boolean getActivarid_empresaPreguntaEquivalencia() {
		return this.activarid_empresaPreguntaEquivalencia;
	}

	public void setActivarid_empresaPreguntaEquivalencia(Boolean activarid_empresaPreguntaEquivalencia) {
		this.activarid_empresaPreguntaEquivalencia= activarid_empresaPreguntaEquivalencia;
	}

	public Boolean getCargarid_empresaPreguntaEquivalencia() {
		return this.cargarid_empresaPreguntaEquivalencia;
	}

	public void setCargarid_empresaPreguntaEquivalencia(Boolean cargarid_empresaPreguntaEquivalencia) {
		this.cargarid_empresaPreguntaEquivalencia= cargarid_empresaPreguntaEquivalencia;
	}

	public Border setResaltarid_sucursalPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPreguntaEquivalencia() {
		return this.resaltarid_sucursalPreguntaEquivalencia;
	}

	public void setResaltarid_sucursalPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_sucursalPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPreguntaEquivalencia() {
		return this.mostrarid_sucursalPreguntaEquivalencia;
	}

	public void setMostrarid_sucursalPreguntaEquivalencia(Boolean mostrarid_sucursalPreguntaEquivalencia) {
		this.mostrarid_sucursalPreguntaEquivalencia= mostrarid_sucursalPreguntaEquivalencia;
	}

	public Boolean getActivarid_sucursalPreguntaEquivalencia() {
		return this.activarid_sucursalPreguntaEquivalencia;
	}

	public void setActivarid_sucursalPreguntaEquivalencia(Boolean activarid_sucursalPreguntaEquivalencia) {
		this.activarid_sucursalPreguntaEquivalencia= activarid_sucursalPreguntaEquivalencia;
	}

	public Boolean getCargarid_sucursalPreguntaEquivalencia() {
		return this.cargarid_sucursalPreguntaEquivalencia;
	}

	public void setCargarid_sucursalPreguntaEquivalencia(Boolean cargarid_sucursalPreguntaEquivalencia) {
		this.cargarid_sucursalPreguntaEquivalencia= cargarid_sucursalPreguntaEquivalencia;
	}

	public Border setResaltarid_ejercicioPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPreguntaEquivalencia() {
		return this.resaltarid_ejercicioPreguntaEquivalencia;
	}

	public void setResaltarid_ejercicioPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_ejercicioPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPreguntaEquivalencia() {
		return this.mostrarid_ejercicioPreguntaEquivalencia;
	}

	public void setMostrarid_ejercicioPreguntaEquivalencia(Boolean mostrarid_ejercicioPreguntaEquivalencia) {
		this.mostrarid_ejercicioPreguntaEquivalencia= mostrarid_ejercicioPreguntaEquivalencia;
	}

	public Boolean getActivarid_ejercicioPreguntaEquivalencia() {
		return this.activarid_ejercicioPreguntaEquivalencia;
	}

	public void setActivarid_ejercicioPreguntaEquivalencia(Boolean activarid_ejercicioPreguntaEquivalencia) {
		this.activarid_ejercicioPreguntaEquivalencia= activarid_ejercicioPreguntaEquivalencia;
	}

	public Boolean getCargarid_ejercicioPreguntaEquivalencia() {
		return this.cargarid_ejercicioPreguntaEquivalencia;
	}

	public void setCargarid_ejercicioPreguntaEquivalencia(Boolean cargarid_ejercicioPreguntaEquivalencia) {
		this.cargarid_ejercicioPreguntaEquivalencia= cargarid_ejercicioPreguntaEquivalencia;
	}

	public Border setResaltarid_periodoPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_periodoPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPreguntaEquivalencia() {
		return this.resaltarid_periodoPreguntaEquivalencia;
	}

	public void setResaltarid_periodoPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_periodoPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_periodoPreguntaEquivalencia() {
		return this.mostrarid_periodoPreguntaEquivalencia;
	}

	public void setMostrarid_periodoPreguntaEquivalencia(Boolean mostrarid_periodoPreguntaEquivalencia) {
		this.mostrarid_periodoPreguntaEquivalencia= mostrarid_periodoPreguntaEquivalencia;
	}

	public Boolean getActivarid_periodoPreguntaEquivalencia() {
		return this.activarid_periodoPreguntaEquivalencia;
	}

	public void setActivarid_periodoPreguntaEquivalencia(Boolean activarid_periodoPreguntaEquivalencia) {
		this.activarid_periodoPreguntaEquivalencia= activarid_periodoPreguntaEquivalencia;
	}

	public Boolean getCargarid_periodoPreguntaEquivalencia() {
		return this.cargarid_periodoPreguntaEquivalencia;
	}

	public void setCargarid_periodoPreguntaEquivalencia(Boolean cargarid_periodoPreguntaEquivalencia) {
		this.cargarid_periodoPreguntaEquivalencia= cargarid_periodoPreguntaEquivalencia;
	}

	public Border setResaltardescripcionPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltardescripcionPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPreguntaEquivalencia() {
		return this.resaltardescripcionPreguntaEquivalencia;
	}

	public void setResaltardescripcionPreguntaEquivalencia(Border borderResaltar) {
		this.resaltardescripcionPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrardescripcionPreguntaEquivalencia() {
		return this.mostrardescripcionPreguntaEquivalencia;
	}

	public void setMostrardescripcionPreguntaEquivalencia(Boolean mostrardescripcionPreguntaEquivalencia) {
		this.mostrardescripcionPreguntaEquivalencia= mostrardescripcionPreguntaEquivalencia;
	}

	public Boolean getActivardescripcionPreguntaEquivalencia() {
		return this.activardescripcionPreguntaEquivalencia;
	}

	public void setActivardescripcionPreguntaEquivalencia(Boolean activardescripcionPreguntaEquivalencia) {
		this.activardescripcionPreguntaEquivalencia= activardescripcionPreguntaEquivalencia;
	}

	public Border setResaltardesdePreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltardesdePreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardesdePreguntaEquivalencia() {
		return this.resaltardesdePreguntaEquivalencia;
	}

	public void setResaltardesdePreguntaEquivalencia(Border borderResaltar) {
		this.resaltardesdePreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrardesdePreguntaEquivalencia() {
		return this.mostrardesdePreguntaEquivalencia;
	}

	public void setMostrardesdePreguntaEquivalencia(Boolean mostrardesdePreguntaEquivalencia) {
		this.mostrardesdePreguntaEquivalencia= mostrardesdePreguntaEquivalencia;
	}

	public Boolean getActivardesdePreguntaEquivalencia() {
		return this.activardesdePreguntaEquivalencia;
	}

	public void setActivardesdePreguntaEquivalencia(Boolean activardesdePreguntaEquivalencia) {
		this.activardesdePreguntaEquivalencia= activardesdePreguntaEquivalencia;
	}

	public Border setResaltarhastaPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarhastaPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhastaPreguntaEquivalencia() {
		return this.resaltarhastaPreguntaEquivalencia;
	}

	public void setResaltarhastaPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarhastaPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarhastaPreguntaEquivalencia() {
		return this.mostrarhastaPreguntaEquivalencia;
	}

	public void setMostrarhastaPreguntaEquivalencia(Boolean mostrarhastaPreguntaEquivalencia) {
		this.mostrarhastaPreguntaEquivalencia= mostrarhastaPreguntaEquivalencia;
	}

	public Boolean getActivarhastaPreguntaEquivalencia() {
		return this.activarhastaPreguntaEquivalencia;
	}

	public void setActivarhastaPreguntaEquivalencia(Boolean activarhastaPreguntaEquivalencia) {
		this.activarhastaPreguntaEquivalencia= activarhastaPreguntaEquivalencia;
	}

	public Border setResaltarordenPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarordenPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPreguntaEquivalencia() {
		return this.resaltarordenPreguntaEquivalencia;
	}

	public void setResaltarordenPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarordenPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarordenPreguntaEquivalencia() {
		return this.mostrarordenPreguntaEquivalencia;
	}

	public void setMostrarordenPreguntaEquivalencia(Boolean mostrarordenPreguntaEquivalencia) {
		this.mostrarordenPreguntaEquivalencia= mostrarordenPreguntaEquivalencia;
	}

	public Boolean getActivarordenPreguntaEquivalencia() {
		return this.activarordenPreguntaEquivalencia;
	}

	public void setActivarordenPreguntaEquivalencia(Boolean activarordenPreguntaEquivalencia) {
		this.activarordenPreguntaEquivalencia= activarordenPreguntaEquivalencia;
	}

	public Border setResaltarid_anioPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_anioPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPreguntaEquivalencia() {
		return this.resaltarid_anioPreguntaEquivalencia;
	}

	public void setResaltarid_anioPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_anioPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_anioPreguntaEquivalencia() {
		return this.mostrarid_anioPreguntaEquivalencia;
	}

	public void setMostrarid_anioPreguntaEquivalencia(Boolean mostrarid_anioPreguntaEquivalencia) {
		this.mostrarid_anioPreguntaEquivalencia= mostrarid_anioPreguntaEquivalencia;
	}

	public Boolean getActivarid_anioPreguntaEquivalencia() {
		return this.activarid_anioPreguntaEquivalencia;
	}

	public void setActivarid_anioPreguntaEquivalencia(Boolean activarid_anioPreguntaEquivalencia) {
		this.activarid_anioPreguntaEquivalencia= activarid_anioPreguntaEquivalencia;
	}

	public Boolean getCargarid_anioPreguntaEquivalencia() {
		return this.cargarid_anioPreguntaEquivalencia;
	}

	public void setCargarid_anioPreguntaEquivalencia(Boolean cargarid_anioPreguntaEquivalencia) {
		this.cargarid_anioPreguntaEquivalencia= cargarid_anioPreguntaEquivalencia;
	}

	public Border setResaltarid_mesPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//preguntaequivalenciaBeanSwingJInternalFrame.jTtoolBarPreguntaEquivalencia.setBorder(borderResaltar);
		
		this.resaltarid_mesPreguntaEquivalencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPreguntaEquivalencia() {
		return this.resaltarid_mesPreguntaEquivalencia;
	}

	public void setResaltarid_mesPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarid_mesPreguntaEquivalencia= borderResaltar;
	}

	public Boolean getMostrarid_mesPreguntaEquivalencia() {
		return this.mostrarid_mesPreguntaEquivalencia;
	}

	public void setMostrarid_mesPreguntaEquivalencia(Boolean mostrarid_mesPreguntaEquivalencia) {
		this.mostrarid_mesPreguntaEquivalencia= mostrarid_mesPreguntaEquivalencia;
	}

	public Boolean getActivarid_mesPreguntaEquivalencia() {
		return this.activarid_mesPreguntaEquivalencia;
	}

	public void setActivarid_mesPreguntaEquivalencia(Boolean activarid_mesPreguntaEquivalencia) {
		this.activarid_mesPreguntaEquivalencia= activarid_mesPreguntaEquivalencia;
	}

	public Boolean getCargarid_mesPreguntaEquivalencia() {
		return this.cargarid_mesPreguntaEquivalencia;
	}

	public void setCargarid_mesPreguntaEquivalencia(Boolean cargarid_mesPreguntaEquivalencia) {
		this.cargarid_mesPreguntaEquivalencia= cargarid_mesPreguntaEquivalencia;
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
		
		
		this.setMostraridPreguntaEquivalencia(esInicial);
		this.setMostrarid_empresaPreguntaEquivalencia(esInicial);
		this.setMostrarid_sucursalPreguntaEquivalencia(esInicial);
		this.setMostrarid_ejercicioPreguntaEquivalencia(esInicial);
		this.setMostrarid_periodoPreguntaEquivalencia(esInicial);
		this.setMostrardescripcionPreguntaEquivalencia(esInicial);
		this.setMostrardesdePreguntaEquivalencia(esInicial);
		this.setMostrarhastaPreguntaEquivalencia(esInicial);
		this.setMostrarordenPreguntaEquivalencia(esInicial);
		this.setMostrarid_anioPreguntaEquivalencia(esInicial);
		this.setMostrarid_mesPreguntaEquivalencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ID)) {
				this.setMostraridPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESDE)) {
				this.setMostrardesdePreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.HASTA)) {
				this.setMostrarhastaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ORDEN)) {
				this.setMostrarordenPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPreguntaEquivalencia(esAsigna);
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
		
		
		this.setActivaridPreguntaEquivalencia(esInicial);
		this.setActivarid_empresaPreguntaEquivalencia(esInicial);
		this.setActivarid_sucursalPreguntaEquivalencia(esInicial);
		this.setActivarid_ejercicioPreguntaEquivalencia(esInicial);
		this.setActivarid_periodoPreguntaEquivalencia(esInicial);
		this.setActivardescripcionPreguntaEquivalencia(esInicial);
		this.setActivardesdePreguntaEquivalencia(esInicial);
		this.setActivarhastaPreguntaEquivalencia(esInicial);
		this.setActivarordenPreguntaEquivalencia(esInicial);
		this.setActivarid_anioPreguntaEquivalencia(esInicial);
		this.setActivarid_mesPreguntaEquivalencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ID)) {
				this.setActivaridPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESDE)) {
				this.setActivardesdePreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.HASTA)) {
				this.setActivarhastaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ORDEN)) {
				this.setActivarordenPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDMES)) {
				this.setActivarid_mesPreguntaEquivalencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPreguntaEquivalencia(esInicial);
		this.setResaltarid_empresaPreguntaEquivalencia(esInicial);
		this.setResaltarid_sucursalPreguntaEquivalencia(esInicial);
		this.setResaltarid_ejercicioPreguntaEquivalencia(esInicial);
		this.setResaltarid_periodoPreguntaEquivalencia(esInicial);
		this.setResaltardescripcionPreguntaEquivalencia(esInicial);
		this.setResaltardesdePreguntaEquivalencia(esInicial);
		this.setResaltarhastaPreguntaEquivalencia(esInicial);
		this.setResaltarordenPreguntaEquivalencia(esInicial);
		this.setResaltarid_anioPreguntaEquivalencia(esInicial);
		this.setResaltarid_mesPreguntaEquivalencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ID)) {
				this.setResaltaridPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.DESDE)) {
				this.setResaltardesdePreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.HASTA)) {
				this.setResaltarhastaPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.ORDEN)) {
				this.setResaltarordenPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPreguntaEquivalencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PreguntaEquivalenciaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPreguntaEquivalencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia=true;

	public Boolean getMostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia() {
		return this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia;
	}

	public void setMostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPreguntaEquivalencia=true;

	public Boolean getMostrarFK_IdEmpresaPreguntaEquivalencia() {
		return this.mostrarFK_IdEmpresaPreguntaEquivalencia;
	}

	public void setMostrarFK_IdEmpresaPreguntaEquivalencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPreguntaEquivalencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPreguntaEquivalencia=true;

	public Boolean getMostrarFK_IdSucursalPreguntaEquivalencia() {
		return this.mostrarFK_IdSucursalPreguntaEquivalencia;
	}

	public void setMostrarFK_IdSucursalPreguntaEquivalencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPreguntaEquivalencia= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia=true;

	public Boolean getActivarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia() {
		return this.activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia;
	}

	public void setActivarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPreguntaEquivalencia=true;

	public Boolean getActivarFK_IdEmpresaPreguntaEquivalencia() {
		return this.activarFK_IdEmpresaPreguntaEquivalencia;
	}

	public void setActivarFK_IdEmpresaPreguntaEquivalencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPreguntaEquivalencia= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPreguntaEquivalencia=true;

	public Boolean getActivarFK_IdSucursalPreguntaEquivalencia() {
		return this.activarFK_IdSucursalPreguntaEquivalencia;
	}

	public void setActivarFK_IdSucursalPreguntaEquivalencia(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPreguntaEquivalencia= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia=null;

	public Border getResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia() {
		return this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia= borderResaltar;
	}

	public void setResaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdEjercicioPorIdPeriodoPreguntaEquivalencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPreguntaEquivalencia=null;

	public Border getResaltarFK_IdEmpresaPreguntaEquivalencia() {
		return this.resaltarFK_IdEmpresaPreguntaEquivalencia;
	}

	public void setResaltarFK_IdEmpresaPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPreguntaEquivalencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPreguntaEquivalencia= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPreguntaEquivalencia=null;

	public Border getResaltarFK_IdSucursalPreguntaEquivalencia() {
		return this.resaltarFK_IdSucursalPreguntaEquivalencia;
	}

	public void setResaltarFK_IdSucursalPreguntaEquivalencia(Border borderResaltar) {
		this.resaltarFK_IdSucursalPreguntaEquivalencia= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPreguntaEquivalencia(ParametroGeneralUsuario parametroGeneralUsuario/*PreguntaEquivalenciaBeanSwingJInternalFrame preguntaequivalenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPreguntaEquivalencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}