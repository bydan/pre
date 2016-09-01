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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoRequisicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRequisicionConstantesFunciones extends TipoRequisicionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRequisicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRequisicion"+TipoRequisicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRequisicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRequisicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRequisicionConstantesFunciones.SCHEMA+"_"+TipoRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRequisicionConstantesFunciones.SCHEMA+"_"+TipoRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRequisicionConstantesFunciones.SCHEMA+"_"+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRequisicionConstantesFunciones.SCHEMA+"_"+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRequisicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRequisicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRequisicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRequisicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Requesiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Requesicion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Requisicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRequisicion";
	public static final String OBJECTNAME="tiporequisicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_requisicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporequisicion from "+TipoRequisicionConstantesFunciones.SPERSISTENCENAME+" tiporequisicion";
	public static String QUERYSELECTNATIVE="select "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".version_row,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_empresa,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".codigo,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".nombre,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_tipo_periodo,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_dia,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".hora from "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME;//+" as "+TipoRequisicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRequisicionConstantesFuncionesAdditional tiporequisicionConstantesFuncionesAdditional=null;
	
	public TipoRequisicionConstantesFuncionesAdditional getTipoRequisicionConstantesFuncionesAdditional() {
		return this.tiporequisicionConstantesFuncionesAdditional;
	}
	
	public void setTipoRequisicionConstantesFuncionesAdditional(TipoRequisicionConstantesFuncionesAdditional tiporequisicionConstantesFuncionesAdditional) {
		try {
			this.tiporequisicionConstantesFuncionesAdditional=tiporequisicionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOPERIODO= "id_tipo_periodo";
    public static final String IDDIA= "id_dia";
    public static final String HORA= "hora";
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
    	public static final String LABEL_IDTIPOPERIODO= "Tipo Periodo";
		public static final String LABEL_IDTIPOPERIODO_LOWER= "Tipo Periodo";
    	public static final String LABEL_IDDIA= "Dia";
		public static final String LABEL_IDDIA_LOWER= "Dia";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getTipoRequisicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.CODIGO)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.IDTIPOPERIODO)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_IDTIPOPERIODO;}
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.IDDIA)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_IDDIA;}
		if(sNombreColumna.equals(TipoRequisicionConstantesFunciones.HORA)) {sLabelColumna=TipoRequisicionConstantesFunciones.LABEL_HORA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getTipoRequisicionDescripcion(TipoRequisicion tiporequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporequisicion !=null/* && tiporequisicion.getId()!=0*/) {
			sDescripcion=tiporequisicion.getnombre();//tiporequisiciontiporequisicion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRequisicionDescripcionDetallado(TipoRequisicion tiporequisicion) {
		String sDescripcion="";
			
		sDescripcion+=TipoRequisicionConstantesFunciones.ID+"=";
		sDescripcion+=tiporequisicion.getId().toString()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporequisicion.getVersionRow().toString()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporequisicion.getid_empresa().toString()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporequisicion.getcodigo()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporequisicion.getnombre()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.IDTIPOPERIODO+"=";
		sDescripcion+=tiporequisicion.getid_tipo_periodo().toString()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.IDDIA+"=";
		sDescripcion+=tiporequisicion.getid_dia().toString()+",";
		sDescripcion+=TipoRequisicionConstantesFunciones.HORA+"=";
		sDescripcion+=tiporequisicion.gethora().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRequisicionDescripcion(TipoRequisicion tiporequisicion,String sValor) throws Exception {			
		if(tiporequisicion !=null) {
			tiporequisicion.setnombre(sValor);;//tiporequisiciontiporequisicion.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoPeriodoDescripcion(TipoPeriodo tipoperiodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoperiodo!=null/*&&tipoperiodo.getId()>0*/) {
			sDescripcion=TipoPeriodoConstantesFunciones.getTipoPeriodoDescripcion(tipoperiodo);
		}

		return sDescripcion;
	}

	public static String getDiaDescripcion(Dia dia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(dia!=null/*&&dia.getId()>0*/) {
			sDescripcion=DiaConstantesFunciones.getDiaDescripcion(dia);
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
		} else if(sNombreIndice.equals("FK_IdDia")) {
			sNombreIndice="Tipo=  Por Dia";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoPeriodo")) {
			sNombreIndice="Tipo=  Por Tipo Periodo";
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

	public static String getDetalleIndiceFK_IdDia(Long id_dia) {
		String sDetalleIndice=" Parametros->";
		if(id_dia!=null) {sDetalleIndice+=" Codigo Unico De Dia="+id_dia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPeriodo(Long id_tipo_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_periodo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Periodo="+id_tipo_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRequisicion(TipoRequisicion tiporequisicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporequisicion.setcodigo(tiporequisicion.getcodigo().trim());
		tiporequisicion.setnombre(tiporequisicion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRequisicions(List<TipoRequisicion> tiporequisicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRequisicion tiporequisicion: tiporequisicions) {
			tiporequisicion.setcodigo(tiporequisicion.getcodigo().trim());
			tiporequisicion.setnombre(tiporequisicion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRequisicion(TipoRequisicion tiporequisicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporequisicion.getConCambioAuxiliar()) {
			tiporequisicion.setIsDeleted(tiporequisicion.getIsDeletedAuxiliar());	
			tiporequisicion.setIsNew(tiporequisicion.getIsNewAuxiliar());	
			tiporequisicion.setIsChanged(tiporequisicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporequisicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporequisicion.setIsDeletedAuxiliar(false);	
			tiporequisicion.setIsNewAuxiliar(false);	
			tiporequisicion.setIsChangedAuxiliar(false);
			
			tiporequisicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRequisicions(List<TipoRequisicion> tiporequisicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRequisicion tiporequisicion : tiporequisicions) {
			if(conAsignarBase && tiporequisicion.getConCambioAuxiliar()) {
				tiporequisicion.setIsDeleted(tiporequisicion.getIsDeletedAuxiliar());	
				tiporequisicion.setIsNew(tiporequisicion.getIsNewAuxiliar());	
				tiporequisicion.setIsChanged(tiporequisicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporequisicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporequisicion.setIsDeletedAuxiliar(false);	
				tiporequisicion.setIsNewAuxiliar(false);	
				tiporequisicion.setIsChangedAuxiliar(false);
				
				tiporequisicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRequisicion(TipoRequisicion tiporequisicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRequisicions(List<TipoRequisicion> tiporequisicions,Boolean conEnteros) throws Exception  {
		
		for(TipoRequisicion tiporequisicion: tiporequisicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRequisicion(List<TipoRequisicion> tiporequisicions,TipoRequisicion tiporequisicionAux) throws Exception  {
		TipoRequisicionConstantesFunciones.InicializarValoresTipoRequisicion(tiporequisicionAux,true);
		
		for(TipoRequisicion tiporequisicion: tiporequisicions) {
			if(tiporequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRequisicionConstantesFunciones.getArrayColumnasGlobalesTipoRequisicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRequisicionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRequisicionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRequisicion> tiporequisicions,TipoRequisicion tiporequisicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRequisicion tiporequisicionAux: tiporequisicions) {
			if(tiporequisicionAux!=null && tiporequisicion!=null) {
				if((tiporequisicionAux.getId()==null && tiporequisicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporequisicionAux.getId()!=null && tiporequisicion.getId()!=null){
					if(tiporequisicionAux.getId().equals(tiporequisicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRequisicion(List<TipoRequisicion> tiporequisicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRequisicion tiporequisicion: tiporequisicions) {			
			if(tiporequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRequisicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_ID, TipoRequisicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_VERSIONROW, TipoRequisicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_IDEMPRESA, TipoRequisicionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_CODIGO, TipoRequisicionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_NOMBRE, TipoRequisicionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_IDTIPOPERIODO, TipoRequisicionConstantesFunciones.IDTIPOPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_IDDIA, TipoRequisicionConstantesFunciones.IDDIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRequisicionConstantesFunciones.LABEL_HORA, TipoRequisicionConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRequisicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.IDTIPOPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.IDDIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRequisicionConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRequisicion() throws Exception  {
		return TipoRequisicionConstantesFunciones.getTiposSeleccionarTipoRequisicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRequisicion(Boolean conFk) throws Exception  {
		return TipoRequisicionConstantesFunciones.getTiposSeleccionarTipoRequisicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRequisicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_IDTIPOPERIODO);
			reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_IDTIPOPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_IDDIA);
			reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_IDDIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(TipoRequisicionConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(TipoRequisicionConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRequisicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRequisicion(TipoRequisicion tiporequisicionAux) throws Exception {
		
			tiporequisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporequisicionAux.getEmpresa()));
			tiporequisicionAux.settipoperiodo_descripcion(TipoPeriodoConstantesFunciones.getTipoPeriodoDescripcion(tiporequisicionAux.getTipoPeriodo()));
			tiporequisicionAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(tiporequisicionAux.getDia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRequisicion(List<TipoRequisicion> tiporequisicionsTemp) throws Exception {
		for(TipoRequisicion tiporequisicionAux:tiporequisicionsTemp) {
			
			tiporequisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporequisicionAux.getEmpresa()));
			tiporequisicionAux.settipoperiodo_descripcion(TipoPeriodoConstantesFunciones.getTipoPeriodoDescripcion(tiporequisicionAux.getTipoPeriodo()));
			tiporequisicionAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(tiporequisicionAux.getDia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoPeriodo.class));
				classes.add(new Classe(Dia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPeriodo.class)) {
						classes.add(new Classe(TipoPeriodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Dia.class)) {
						classes.add(new Classe(Dia.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPeriodo.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoPeriodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPeriodo.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRequisicionConstantesFunciones.getClassesRelationshipsOfTipoRequisicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Requisicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Requisicion.class)) {
						classes.add(new Classe(Requisicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRequisicionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRequisicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
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
	public static void actualizarLista(TipoRequisicion tiporequisicion,List<TipoRequisicion> tiporequisicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRequisicion tiporequisicionEncontrado=null;
			
			for(TipoRequisicion tiporequisicionLocal:tiporequisicions) {
				if(tiporequisicionLocal.getId().equals(tiporequisicion.getId())) {
					tiporequisicionEncontrado=tiporequisicionLocal;
					
					tiporequisicionLocal.setIsChanged(tiporequisicion.getIsChanged());
					tiporequisicionLocal.setIsNew(tiporequisicion.getIsNew());
					tiporequisicionLocal.setIsDeleted(tiporequisicion.getIsDeleted());
					
					tiporequisicionLocal.setGeneralEntityOriginal(tiporequisicion.getGeneralEntityOriginal());
					
					tiporequisicionLocal.setId(tiporequisicion.getId());	
					tiporequisicionLocal.setVersionRow(tiporequisicion.getVersionRow());	
					tiporequisicionLocal.setid_empresa(tiporequisicion.getid_empresa());	
					tiporequisicionLocal.setcodigo(tiporequisicion.getcodigo());	
					tiporequisicionLocal.setnombre(tiporequisicion.getnombre());	
					tiporequisicionLocal.setid_tipo_periodo(tiporequisicion.getid_tipo_periodo());	
					tiporequisicionLocal.setid_dia(tiporequisicion.getid_dia());	
					tiporequisicionLocal.sethora(tiporequisicion.gethora());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiporequisicion.getIsDeleted()) {
				if(!existe) {
					tiporequisicions.add(tiporequisicion);
				}
			} else {
				if(tiporequisicionEncontrado!=null && permiteQuitar)  {
					tiporequisicions.remove(tiporequisicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRequisicion tiporequisicion,List<TipoRequisicion> tiporequisicions) throws Exception {
		try	{			
			for(TipoRequisicion tiporequisicionLocal:tiporequisicions) {
				if(tiporequisicionLocal.getId().equals(tiporequisicion.getId())) {
					tiporequisicionLocal.setIsSelected(tiporequisicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRequisicion(List<TipoRequisicion> tiporequisicionsAux) throws Exception {
		//this.tiporequisicionsAux=tiporequisicionsAux;
		
		for(TipoRequisicion tiporequisicionAux:tiporequisicionsAux) {
			if(tiporequisicionAux.getIsChanged()) {
				tiporequisicionAux.setIsChanged(false);
			}		
			
			if(tiporequisicionAux.getIsNew()) {
				tiporequisicionAux.setIsNew(false);
			}	
			
			if(tiporequisicionAux.getIsDeleted()) {
				tiporequisicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRequisicion(TipoRequisicion tiporequisicionAux) throws Exception {
		//this.tiporequisicionAux=tiporequisicionAux;
		
			if(tiporequisicionAux.getIsChanged()) {
				tiporequisicionAux.setIsChanged(false);
			}		
			
			if(tiporequisicionAux.getIsNew()) {
				tiporequisicionAux.setIsNew(false);
			}	
			
			if(tiporequisicionAux.getIsDeleted()) {
				tiporequisicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRequisicion tiporequisicionAsignar,TipoRequisicion tiporequisicion) throws Exception {
		tiporequisicionAsignar.setId(tiporequisicion.getId());	
		tiporequisicionAsignar.setVersionRow(tiporequisicion.getVersionRow());	
		tiporequisicionAsignar.setid_empresa(tiporequisicion.getid_empresa());
		tiporequisicionAsignar.setempresa_descripcion(tiporequisicion.getempresa_descripcion());	
		tiporequisicionAsignar.setcodigo(tiporequisicion.getcodigo());	
		tiporequisicionAsignar.setnombre(tiporequisicion.getnombre());	
		tiporequisicionAsignar.setid_tipo_periodo(tiporequisicion.getid_tipo_periodo());
		tiporequisicionAsignar.settipoperiodo_descripcion(tiporequisicion.gettipoperiodo_descripcion());	
		tiporequisicionAsignar.setid_dia(tiporequisicion.getid_dia());
		tiporequisicionAsignar.setdia_descripcion(tiporequisicion.getdia_descripcion());	
		tiporequisicionAsignar.sethora(tiporequisicion.gethora());	
	}
	
	public static void inicializarTipoRequisicion(TipoRequisicion tiporequisicion) throws Exception {
		try {
				tiporequisicion.setId(0L);	
					
				tiporequisicion.setid_empresa(-1L);	
				tiporequisicion.setcodigo("");	
				tiporequisicion.setnombre("");	
				tiporequisicion.setid_tipo_periodo(-1L);	
				tiporequisicion.setid_dia(-1L);	
				tiporequisicion.sethora(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRequisicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_IDTIPOPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_IDDIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRequisicionConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRequisicion(String sTipo,Row row,Workbook workbook,TipoRequisicion tiporequisicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.gettipoperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.getdia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporequisicion.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRequisicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRequisicion() {
		return this.sFinalQueryTipoRequisicion;
	}
	
	public void setsFinalQueryTipoRequisicion(String sFinalQueryTipoRequisicion) {
		this.sFinalQueryTipoRequisicion= sFinalQueryTipoRequisicion;
	}
	
	public Border resaltarSeleccionarTipoRequisicion=null;
	
	public Border setResaltarSeleccionarTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRequisicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRequisicion() {
		return this.resaltarSeleccionarTipoRequisicion;
	}
	
	public void setResaltarSeleccionarTipoRequisicion(Border borderResaltarSeleccionarTipoRequisicion) {
		this.resaltarSeleccionarTipoRequisicion= borderResaltarSeleccionarTipoRequisicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRequisicion=null;
	public Boolean mostraridTipoRequisicion=true;
	public Boolean activaridTipoRequisicion=true;

	public Border resaltarid_empresaTipoRequisicion=null;
	public Boolean mostrarid_empresaTipoRequisicion=true;
	public Boolean activarid_empresaTipoRequisicion=true;
	public Boolean cargarid_empresaTipoRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRequisicion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoRequisicion=null;
	public Boolean mostrarcodigoTipoRequisicion=true;
	public Boolean activarcodigoTipoRequisicion=true;

	public Border resaltarnombreTipoRequisicion=null;
	public Boolean mostrarnombreTipoRequisicion=true;
	public Boolean activarnombreTipoRequisicion=true;

	public Border resaltarid_tipo_periodoTipoRequisicion=null;
	public Boolean mostrarid_tipo_periodoTipoRequisicion=true;
	public Boolean activarid_tipo_periodoTipoRequisicion=true;
	public Boolean cargarid_tipo_periodoTipoRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_periodoTipoRequisicion=false;//ConEventDepend=true

	public Border resaltarid_diaTipoRequisicion=null;
	public Boolean mostrarid_diaTipoRequisicion=true;
	public Boolean activarid_diaTipoRequisicion=true;
	public Boolean cargarid_diaTipoRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_diaTipoRequisicion=false;//ConEventDepend=true

	public Border resaltarhoraTipoRequisicion=null;
	public Boolean mostrarhoraTipoRequisicion=true;
	public Boolean activarhoraTipoRequisicion=true;

	
	

	public Border setResaltaridTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltaridTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRequisicion() {
		return this.resaltaridTipoRequisicion;
	}

	public void setResaltaridTipoRequisicion(Border borderResaltar) {
		this.resaltaridTipoRequisicion= borderResaltar;
	}

	public Boolean getMostraridTipoRequisicion() {
		return this.mostraridTipoRequisicion;
	}

	public void setMostraridTipoRequisicion(Boolean mostraridTipoRequisicion) {
		this.mostraridTipoRequisicion= mostraridTipoRequisicion;
	}

	public Boolean getActivaridTipoRequisicion() {
		return this.activaridTipoRequisicion;
	}

	public void setActivaridTipoRequisicion(Boolean activaridTipoRequisicion) {
		this.activaridTipoRequisicion= activaridTipoRequisicion;
	}

	public Border setResaltarid_empresaTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRequisicion() {
		return this.resaltarid_empresaTipoRequisicion;
	}

	public void setResaltarid_empresaTipoRequisicion(Border borderResaltar) {
		this.resaltarid_empresaTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRequisicion() {
		return this.mostrarid_empresaTipoRequisicion;
	}

	public void setMostrarid_empresaTipoRequisicion(Boolean mostrarid_empresaTipoRequisicion) {
		this.mostrarid_empresaTipoRequisicion= mostrarid_empresaTipoRequisicion;
	}

	public Boolean getActivarid_empresaTipoRequisicion() {
		return this.activarid_empresaTipoRequisicion;
	}

	public void setActivarid_empresaTipoRequisicion(Boolean activarid_empresaTipoRequisicion) {
		this.activarid_empresaTipoRequisicion= activarid_empresaTipoRequisicion;
	}

	public Boolean getCargarid_empresaTipoRequisicion() {
		return this.cargarid_empresaTipoRequisicion;
	}

	public void setCargarid_empresaTipoRequisicion(Boolean cargarid_empresaTipoRequisicion) {
		this.cargarid_empresaTipoRequisicion= cargarid_empresaTipoRequisicion;
	}

	public Border setResaltarcodigoTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRequisicion() {
		return this.resaltarcodigoTipoRequisicion;
	}

	public void setResaltarcodigoTipoRequisicion(Border borderResaltar) {
		this.resaltarcodigoTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRequisicion() {
		return this.mostrarcodigoTipoRequisicion;
	}

	public void setMostrarcodigoTipoRequisicion(Boolean mostrarcodigoTipoRequisicion) {
		this.mostrarcodigoTipoRequisicion= mostrarcodigoTipoRequisicion;
	}

	public Boolean getActivarcodigoTipoRequisicion() {
		return this.activarcodigoTipoRequisicion;
	}

	public void setActivarcodigoTipoRequisicion(Boolean activarcodigoTipoRequisicion) {
		this.activarcodigoTipoRequisicion= activarcodigoTipoRequisicion;
	}

	public Border setResaltarnombreTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRequisicion() {
		return this.resaltarnombreTipoRequisicion;
	}

	public void setResaltarnombreTipoRequisicion(Border borderResaltar) {
		this.resaltarnombreTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRequisicion() {
		return this.mostrarnombreTipoRequisicion;
	}

	public void setMostrarnombreTipoRequisicion(Boolean mostrarnombreTipoRequisicion) {
		this.mostrarnombreTipoRequisicion= mostrarnombreTipoRequisicion;
	}

	public Boolean getActivarnombreTipoRequisicion() {
		return this.activarnombreTipoRequisicion;
	}

	public void setActivarnombreTipoRequisicion(Boolean activarnombreTipoRequisicion) {
		this.activarnombreTipoRequisicion= activarnombreTipoRequisicion;
	}

	public Border setResaltarid_tipo_periodoTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_periodoTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_periodoTipoRequisicion() {
		return this.resaltarid_tipo_periodoTipoRequisicion;
	}

	public void setResaltarid_tipo_periodoTipoRequisicion(Border borderResaltar) {
		this.resaltarid_tipo_periodoTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_periodoTipoRequisicion() {
		return this.mostrarid_tipo_periodoTipoRequisicion;
	}

	public void setMostrarid_tipo_periodoTipoRequisicion(Boolean mostrarid_tipo_periodoTipoRequisicion) {
		this.mostrarid_tipo_periodoTipoRequisicion= mostrarid_tipo_periodoTipoRequisicion;
	}

	public Boolean getActivarid_tipo_periodoTipoRequisicion() {
		return this.activarid_tipo_periodoTipoRequisicion;
	}

	public void setActivarid_tipo_periodoTipoRequisicion(Boolean activarid_tipo_periodoTipoRequisicion) {
		this.activarid_tipo_periodoTipoRequisicion= activarid_tipo_periodoTipoRequisicion;
	}

	public Boolean getCargarid_tipo_periodoTipoRequisicion() {
		return this.cargarid_tipo_periodoTipoRequisicion;
	}

	public void setCargarid_tipo_periodoTipoRequisicion(Boolean cargarid_tipo_periodoTipoRequisicion) {
		this.cargarid_tipo_periodoTipoRequisicion= cargarid_tipo_periodoTipoRequisicion;
	}

	public Border setResaltarid_diaTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_diaTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_diaTipoRequisicion() {
		return this.resaltarid_diaTipoRequisicion;
	}

	public void setResaltarid_diaTipoRequisicion(Border borderResaltar) {
		this.resaltarid_diaTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_diaTipoRequisicion() {
		return this.mostrarid_diaTipoRequisicion;
	}

	public void setMostrarid_diaTipoRequisicion(Boolean mostrarid_diaTipoRequisicion) {
		this.mostrarid_diaTipoRequisicion= mostrarid_diaTipoRequisicion;
	}

	public Boolean getActivarid_diaTipoRequisicion() {
		return this.activarid_diaTipoRequisicion;
	}

	public void setActivarid_diaTipoRequisicion(Boolean activarid_diaTipoRequisicion) {
		this.activarid_diaTipoRequisicion= activarid_diaTipoRequisicion;
	}

	public Boolean getCargarid_diaTipoRequisicion() {
		return this.cargarid_diaTipoRequisicion;
	}

	public void setCargarid_diaTipoRequisicion(Boolean cargarid_diaTipoRequisicion) {
		this.cargarid_diaTipoRequisicion= cargarid_diaTipoRequisicion;
	}

	public Border setResaltarhoraTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporequisicionBeanSwingJInternalFrame.jTtoolBarTipoRequisicion.setBorder(borderResaltar);
		
		this.resaltarhoraTipoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraTipoRequisicion() {
		return this.resaltarhoraTipoRequisicion;
	}

	public void setResaltarhoraTipoRequisicion(Border borderResaltar) {
		this.resaltarhoraTipoRequisicion= borderResaltar;
	}

	public Boolean getMostrarhoraTipoRequisicion() {
		return this.mostrarhoraTipoRequisicion;
	}

	public void setMostrarhoraTipoRequisicion(Boolean mostrarhoraTipoRequisicion) {
		this.mostrarhoraTipoRequisicion= mostrarhoraTipoRequisicion;
	}

	public Boolean getActivarhoraTipoRequisicion() {
		return this.activarhoraTipoRequisicion;
	}

	public void setActivarhoraTipoRequisicion(Boolean activarhoraTipoRequisicion) {
		this.activarhoraTipoRequisicion= activarhoraTipoRequisicion;
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
		
		
		this.setMostraridTipoRequisicion(esInicial);
		this.setMostrarid_empresaTipoRequisicion(esInicial);
		this.setMostrarcodigoTipoRequisicion(esInicial);
		this.setMostrarnombreTipoRequisicion(esInicial);
		this.setMostrarid_tipo_periodoTipoRequisicion(esInicial);
		this.setMostrarid_diaTipoRequisicion(esInicial);
		this.setMostrarhoraTipoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.ID)) {
				this.setMostraridTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDTIPOPERIODO)) {
				this.setMostrarid_tipo_periodoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDDIA)) {
				this.setMostrarid_diaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.HORA)) {
				this.setMostrarhoraTipoRequisicion(esAsigna);
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
		
		
		this.setActivaridTipoRequisicion(esInicial);
		this.setActivarid_empresaTipoRequisicion(esInicial);
		this.setActivarcodigoTipoRequisicion(esInicial);
		this.setActivarnombreTipoRequisicion(esInicial);
		this.setActivarid_tipo_periodoTipoRequisicion(esInicial);
		this.setActivarid_diaTipoRequisicion(esInicial);
		this.setActivarhoraTipoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.ID)) {
				this.setActivaridTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDTIPOPERIODO)) {
				this.setActivarid_tipo_periodoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDDIA)) {
				this.setActivarid_diaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.HORA)) {
				this.setActivarhoraTipoRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRequisicion(esInicial);
		this.setResaltarid_empresaTipoRequisicion(esInicial);
		this.setResaltarcodigoTipoRequisicion(esInicial);
		this.setResaltarnombreTipoRequisicion(esInicial);
		this.setResaltarid_tipo_periodoTipoRequisicion(esInicial);
		this.setResaltarid_diaTipoRequisicion(esInicial);
		this.setResaltarhoraTipoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.ID)) {
				this.setResaltaridTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDTIPOPERIODO)) {
				this.setResaltarid_tipo_periodoTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.IDDIA)) {
				this.setResaltarid_diaTipoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRequisicionConstantesFunciones.HORA)) {
				this.setResaltarhoraTipoRequisicion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoRequisicion=true;

	public Boolean getMostrarBusquedaPorCodigoTipoRequisicion() {
		return this.mostrarBusquedaPorCodigoTipoRequisicion;
	}

	public void setMostrarBusquedaPorCodigoTipoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoRequisicion=true;

	public Boolean getMostrarBusquedaPorNombreTipoRequisicion() {
		return this.mostrarBusquedaPorNombreTipoRequisicion;
	}

	public void setMostrarBusquedaPorNombreTipoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDiaTipoRequisicion=true;

	public Boolean getMostrarFK_IdDiaTipoRequisicion() {
		return this.mostrarFK_IdDiaTipoRequisicion;
	}

	public void setMostrarFK_IdDiaTipoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDiaTipoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoRequisicion=true;

	public Boolean getMostrarFK_IdEmpresaTipoRequisicion() {
		return this.mostrarFK_IdEmpresaTipoRequisicion;
	}

	public void setMostrarFK_IdEmpresaTipoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPeriodoTipoRequisicion=true;

	public Boolean getMostrarFK_IdTipoPeriodoTipoRequisicion() {
		return this.mostrarFK_IdTipoPeriodoTipoRequisicion;
	}

	public void setMostrarFK_IdTipoPeriodoTipoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPeriodoTipoRequisicion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoRequisicion=true;

	public Boolean getActivarBusquedaPorCodigoTipoRequisicion() {
		return this.activarBusquedaPorCodigoTipoRequisicion;
	}

	public void setActivarBusquedaPorCodigoTipoRequisicion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoRequisicion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoRequisicion=true;

	public Boolean getActivarBusquedaPorNombreTipoRequisicion() {
		return this.activarBusquedaPorNombreTipoRequisicion;
	}

	public void setActivarBusquedaPorNombreTipoRequisicion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdDiaTipoRequisicion=true;

	public Boolean getActivarFK_IdDiaTipoRequisicion() {
		return this.activarFK_IdDiaTipoRequisicion;
	}

	public void setActivarFK_IdDiaTipoRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdDiaTipoRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoRequisicion=true;

	public Boolean getActivarFK_IdEmpresaTipoRequisicion() {
		return this.activarFK_IdEmpresaTipoRequisicion;
	}

	public void setActivarFK_IdEmpresaTipoRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPeriodoTipoRequisicion=true;

	public Boolean getActivarFK_IdTipoPeriodoTipoRequisicion() {
		return this.activarFK_IdTipoPeriodoTipoRequisicion;
	}

	public void setActivarFK_IdTipoPeriodoTipoRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPeriodoTipoRequisicion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoRequisicion=null;

	public Border getResaltarBusquedaPorCodigoTipoRequisicion() {
		return this.resaltarBusquedaPorCodigoTipoRequisicion;
	}

	public void setResaltarBusquedaPorCodigoTipoRequisicion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoRequisicion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoRequisicion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoRequisicion=null;

	public Border getResaltarBusquedaPorNombreTipoRequisicion() {
		return this.resaltarBusquedaPorNombreTipoRequisicion;
	}

	public void setResaltarBusquedaPorNombreTipoRequisicion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoRequisicion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdDiaTipoRequisicion=null;

	public Border getResaltarFK_IdDiaTipoRequisicion() {
		return this.resaltarFK_IdDiaTipoRequisicion;
	}

	public void setResaltarFK_IdDiaTipoRequisicion(Border borderResaltar) {
		this.resaltarFK_IdDiaTipoRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdDiaTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDiaTipoRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoRequisicion=null;

	public Border getResaltarFK_IdEmpresaTipoRequisicion() {
		return this.resaltarFK_IdEmpresaTipoRequisicion;
	}

	public void setResaltarFK_IdEmpresaTipoRequisicion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoPeriodoTipoRequisicion=null;

	public Border getResaltarFK_IdTipoPeriodoTipoRequisicion() {
		return this.resaltarFK_IdTipoPeriodoTipoRequisicion;
	}

	public void setResaltarFK_IdTipoPeriodoTipoRequisicion(Border borderResaltar) {
		this.resaltarFK_IdTipoPeriodoTipoRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoPeriodoTipoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRequisicionBeanSwingJInternalFrame tiporequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPeriodoTipoRequisicion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}