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


import com.bydan.erp.nomina.util.report.RubrosVariablesConstantesFunciones;
import com.bydan.erp.nomina.util.report.RubrosVariablesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.RubrosVariablesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RubrosVariablesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="RubrosVariables";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RubrosVariables"+RubrosVariablesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RubrosVariablesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RubrosVariablesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RubrosVariablesConstantesFunciones.SCHEMA+"_"+RubrosVariablesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RubrosVariablesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RubrosVariablesConstantesFunciones.SCHEMA+"_"+RubrosVariablesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RubrosVariablesConstantesFunciones.SCHEMA+"_"+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RubrosVariablesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RubrosVariablesConstantesFunciones.SCHEMA+"_"+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubrosVariablesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubrosVariablesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubrosVariablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RubrosVariablesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RubrosVariablesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RubrosVariablesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RubrosVariablesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rubros Variableses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Rubros Variables";
	public static final String SCLASSWEBTITULO_LOWER="Rubros Variables";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RubrosVariables";
	public static final String OBJECTNAME="rubrosvariables";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rubros_variables";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rubrosvariables from "+RubrosVariablesConstantesFunciones.SPERSISTENCENAME+" rubrosvariables";
	public static String QUERYSELECTNATIVE="select "+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".id,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".version_row,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".id_tipo_contrato,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".id_empresa,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".fecha_desde,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".fecha_hasta,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".codigo,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".nombre,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".fecha,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".valor,"+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME+".nombre_rubro_emplea from "+RubrosVariablesConstantesFunciones.SCHEMA+"."+RubrosVariablesConstantesFunciones.TABLENAME;//+" as "+RubrosVariablesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOCONTRATO= "id_tipo_contrato";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String NOMBRERUBROEMPLEA= "nombre_rubro_emplea";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOCONTRATO= "Tipo Contrato";
		public static final String LABEL_IDTIPOCONTRATO_LOWER= "Tipo Contrato";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NOMBRERUBROEMPLEA= "Nombre Rubro Emplea";
		public static final String LABEL_NOMBRERUBROEMPLEA_LOWER= "Nombre Rubro Emplea";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_RUBRO_EMPLEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RUBRO_EMPLEA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRubrosVariablesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.IDTIPOCONTRATO)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_IDTIPOCONTRATO;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.IDEMPRESA)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.FECHADESDE)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.FECHAHASTA)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.CODIGO)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.NOMBRE)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.FECHA)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.VALOR)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA)) {sLabelColumna=RubrosVariablesConstantesFunciones.LABEL_NOMBRERUBROEMPLEA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRubrosVariablesDescripcion(RubrosVariables rubrosvariables) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rubrosvariables !=null/* && rubrosvariables.getId()!=0*/) {
			sDescripcion=rubrosvariables.getcodigo();//rubrosvariablesrubrosvariables.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRubrosVariablesDescripcionDetallado(RubrosVariables rubrosvariables) {
		String sDescripcion="";
			
		sDescripcion+=RubrosVariablesConstantesFunciones.ID+"=";
		sDescripcion+=rubrosvariables.getId().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rubrosvariables.getVersionRow().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.IDTIPOCONTRATO+"=";
		sDescripcion+=rubrosvariables.getid_tipo_contrato().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rubrosvariables.getid_empresa().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=rubrosvariables.getid_rubro_emplea().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=rubrosvariables.getfecha_desde().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=rubrosvariables.getfecha_hasta().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.CODIGO+"=";
		sDescripcion+=rubrosvariables.getcodigo()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=rubrosvariables.getnombre()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.FECHA+"=";
		sDescripcion+=rubrosvariables.getfecha().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.VALOR+"=";
		sDescripcion+=rubrosvariables.getvalor().toString()+",";
		sDescripcion+=RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA+"=";
		sDescripcion+=rubrosvariables.getnombre_rubro_emplea()+",";
			
		return sDescripcion;
	}
	
	public static void setRubrosVariablesDescripcion(RubrosVariables rubrosvariables,String sValor) throws Exception {			
		if(rubrosvariables !=null) {
			rubrosvariables.setcodigo(sValor);;//rubrosvariablesrubrosvariables.getcodigo().trim();
		}		
	}
	
		

	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocontrato!=null/*&&tipocontrato.getId()>0*/) {
			sDescripcion=TipoContratoConstantesFunciones.getTipoContratoDescripcion(tipocontrato);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaRubrosVariables")) {
			sNombreIndice="Tipo=  Por Tipo Contrato Por Rubro Emplea Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Tipo Contrato";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaRubrosVariables(Long id_tipo_contrato,Long id_rubro_emplea,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();}
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_tipo_contrato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRubrosVariables(RubrosVariables rubrosvariables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rubrosvariables.setcodigo(rubrosvariables.getcodigo().trim());
		rubrosvariables.setnombre(rubrosvariables.getnombre().trim());
		rubrosvariables.setnombre_rubro_emplea(rubrosvariables.getnombre_rubro_emplea().trim());
	}
	
	public static void quitarEspaciosRubrosVariabless(List<RubrosVariables> rubrosvariabless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RubrosVariables rubrosvariables: rubrosvariabless) {
			rubrosvariables.setcodigo(rubrosvariables.getcodigo().trim());
			rubrosvariables.setnombre(rubrosvariables.getnombre().trim());
			rubrosvariables.setnombre_rubro_emplea(rubrosvariables.getnombre_rubro_emplea().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubrosVariables(RubrosVariables rubrosvariables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rubrosvariables.getConCambioAuxiliar()) {
			rubrosvariables.setIsDeleted(rubrosvariables.getIsDeletedAuxiliar());	
			rubrosvariables.setIsNew(rubrosvariables.getIsNewAuxiliar());	
			rubrosvariables.setIsChanged(rubrosvariables.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rubrosvariables.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rubrosvariables.setIsDeletedAuxiliar(false);	
			rubrosvariables.setIsNewAuxiliar(false);	
			rubrosvariables.setIsChangedAuxiliar(false);
			
			rubrosvariables.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubrosVariabless(List<RubrosVariables> rubrosvariabless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RubrosVariables rubrosvariables : rubrosvariabless) {
			if(conAsignarBase && rubrosvariables.getConCambioAuxiliar()) {
				rubrosvariables.setIsDeleted(rubrosvariables.getIsDeletedAuxiliar());	
				rubrosvariables.setIsNew(rubrosvariables.getIsNewAuxiliar());	
				rubrosvariables.setIsChanged(rubrosvariables.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rubrosvariables.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rubrosvariables.setIsDeletedAuxiliar(false);	
				rubrosvariables.setIsNewAuxiliar(false);	
				rubrosvariables.setIsChangedAuxiliar(false);
				
				rubrosvariables.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRubrosVariables(RubrosVariables rubrosvariables,Boolean conEnteros) throws Exception  {
		rubrosvariables.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRubrosVariabless(List<RubrosVariables> rubrosvariabless,Boolean conEnteros) throws Exception  {
		
		for(RubrosVariables rubrosvariables: rubrosvariabless) {
			rubrosvariables.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRubrosVariables(List<RubrosVariables> rubrosvariabless,RubrosVariables rubrosvariablesAux) throws Exception  {
		RubrosVariablesConstantesFunciones.InicializarValoresRubrosVariables(rubrosvariablesAux,true);
		
		for(RubrosVariables rubrosvariables: rubrosvariabless) {
			if(rubrosvariables.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rubrosvariablesAux.setvalor(rubrosvariablesAux.getvalor()+rubrosvariables.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRubrosVariables(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RubrosVariablesConstantesFunciones.getArrayColumnasGlobalesRubrosVariables(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRubrosVariables(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubrosVariablesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubrosVariablesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRubrosVariables(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RubrosVariables> rubrosvariabless,RubrosVariables rubrosvariables,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RubrosVariables rubrosvariablesAux: rubrosvariabless) {
			if(rubrosvariablesAux!=null && rubrosvariables!=null) {
				if((rubrosvariablesAux.getId()==null && rubrosvariables.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rubrosvariablesAux.getId()!=null && rubrosvariables.getId()!=null){
					if(rubrosvariablesAux.getId().equals(rubrosvariables.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRubrosVariables(List<RubrosVariables> rubrosvariabless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(RubrosVariables rubrosvariables: rubrosvariabless) {			
			if(rubrosvariables.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=rubrosvariables.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RubrosVariablesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRubrosVariables() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_ID, RubrosVariablesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_VERSIONROW, RubrosVariablesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_CODIGO, RubrosVariablesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_NOMBRE, RubrosVariablesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_FECHA, RubrosVariablesConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_VALOR, RubrosVariablesConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubrosVariablesConstantesFunciones.LABEL_NOMBRERUBROEMPLEA, RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRubrosVariables() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubrosVariables() throws Exception  {
		return RubrosVariablesConstantesFunciones.getTiposSeleccionarRubrosVariables(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubrosVariables(Boolean conFk) throws Exception  {
		return RubrosVariablesConstantesFunciones.getTiposSeleccionarRubrosVariables(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubrosVariables(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_IDTIPOCONTRATO);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_IDTIPOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubrosVariablesConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);
			reporte.setsDescripcion(RubrosVariablesConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRubrosVariables(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRubrosVariables(RubrosVariables rubrosvariablesAux) throws Exception {
		
			rubrosvariablesAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(rubrosvariablesAux.getTipoContrato()));
			rubrosvariablesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubrosvariablesAux.getEmpresa()));
			rubrosvariablesAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubrosvariablesAux.getRubroEmplea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRubrosVariables(List<RubrosVariables> rubrosvariablessTemp) throws Exception {
		for(RubrosVariables rubrosvariablesAux:rubrosvariablessTemp) {
			
			rubrosvariablesAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(rubrosvariablesAux.getTipoContrato()));
			rubrosvariablesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubrosvariablesAux.getEmpresa()));
			rubrosvariablesAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubrosvariablesAux.getRubroEmplea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRubrosVariables(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoContrato.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(RubroEmplea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoContrato.class)) {
						classes.add(new Classe(TipoContrato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRubrosVariables(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubrosVariables(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubrosVariablesConstantesFunciones.getClassesRelationshipsOfRubrosVariables(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubrosVariables(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubrosVariables(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubrosVariablesConstantesFunciones.getClassesRelationshipsFromStringsOfRubrosVariables(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubrosVariables(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RubrosVariables rubrosvariables,List<RubrosVariables> rubrosvariabless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(RubrosVariables rubrosvariables,List<RubrosVariables> rubrosvariabless) throws Exception {
		try	{			
			for(RubrosVariables rubrosvariablesLocal:rubrosvariabless) {
				if(rubrosvariablesLocal.getId().equals(rubrosvariables.getId())) {
					rubrosvariablesLocal.setIsSelected(rubrosvariables.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRubrosVariables(List<RubrosVariables> rubrosvariablessAux) throws Exception {
		//this.rubrosvariablessAux=rubrosvariablessAux;
		
		for(RubrosVariables rubrosvariablesAux:rubrosvariablessAux) {
			if(rubrosvariablesAux.getIsChanged()) {
				rubrosvariablesAux.setIsChanged(false);
			}		
			
			if(rubrosvariablesAux.getIsNew()) {
				rubrosvariablesAux.setIsNew(false);
			}	
			
			if(rubrosvariablesAux.getIsDeleted()) {
				rubrosvariablesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRubrosVariables(RubrosVariables rubrosvariablesAux) throws Exception {
		//this.rubrosvariablesAux=rubrosvariablesAux;
		
			if(rubrosvariablesAux.getIsChanged()) {
				rubrosvariablesAux.setIsChanged(false);
			}		
			
			if(rubrosvariablesAux.getIsNew()) {
				rubrosvariablesAux.setIsNew(false);
			}	
			
			if(rubrosvariablesAux.getIsDeleted()) {
				rubrosvariablesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RubrosVariables rubrosvariablesAsignar,RubrosVariables rubrosvariables) throws Exception {
		rubrosvariablesAsignar.setId(rubrosvariables.getId());	
		rubrosvariablesAsignar.setVersionRow(rubrosvariables.getVersionRow());	
		rubrosvariablesAsignar.setcodigo(rubrosvariables.getcodigo());	
		rubrosvariablesAsignar.setnombre(rubrosvariables.getnombre());	
		rubrosvariablesAsignar.setfecha(rubrosvariables.getfecha());	
		rubrosvariablesAsignar.setvalor(rubrosvariables.getvalor());	
		rubrosvariablesAsignar.setnombre_rubro_emplea(rubrosvariables.getnombre_rubro_emplea());	
	}
	
	public static void inicializarRubrosVariables(RubrosVariables rubrosvariables) throws Exception {
		try {
				rubrosvariables.setId(0L);	
					
				rubrosvariables.setcodigo("");	
				rubrosvariables.setnombre("");	
				rubrosvariables.setfecha(new Date());	
				rubrosvariables.setvalor(0.0);	
				rubrosvariables.setnombre_rubro_emplea("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRubrosVariables(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_IDTIPOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubrosVariablesConstantesFunciones.LABEL_NOMBRERUBROEMPLEA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRubrosVariables(String sTipo,Row row,Workbook workbook,RubrosVariables rubrosvariables,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.gettipocontrato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubrosvariables.getnombre_rubro_emplea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRubrosVariables="";
	
	public String getsFinalQueryRubrosVariables() {
		return this.sFinalQueryRubrosVariables;
	}
	
	public void setsFinalQueryRubrosVariables(String sFinalQueryRubrosVariables) {
		this.sFinalQueryRubrosVariables= sFinalQueryRubrosVariables;
	}
	
	public Border resaltarSeleccionarRubrosVariables=null;
	
	public Border setResaltarSeleccionarRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRubrosVariables= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRubrosVariables() {
		return this.resaltarSeleccionarRubrosVariables;
	}
	
	public void setResaltarSeleccionarRubrosVariables(Border borderResaltarSeleccionarRubrosVariables) {
		this.resaltarSeleccionarRubrosVariables= borderResaltarSeleccionarRubrosVariables;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRubrosVariables=null;
	public Boolean mostraridRubrosVariables=true;
	public Boolean activaridRubrosVariables=true;

	public Border resaltarid_tipo_contratoRubrosVariables=null;
	public Boolean mostrarid_tipo_contratoRubrosVariables=true;
	public Boolean activarid_tipo_contratoRubrosVariables=true;
	public Boolean cargarid_tipo_contratoRubrosVariables=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_contratoRubrosVariables=false;//ConEventDepend=true

	public Border resaltarid_empresaRubrosVariables=null;
	public Boolean mostrarid_empresaRubrosVariables=true;
	public Boolean activarid_empresaRubrosVariables=true;
	public Boolean cargarid_empresaRubrosVariables=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRubrosVariables=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaRubrosVariables=null;
	public Boolean mostrarid_rubro_empleaRubrosVariables=true;
	public Boolean activarid_rubro_empleaRubrosVariables=true;
	public Boolean cargarid_rubro_empleaRubrosVariables=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaRubrosVariables=false;//ConEventDepend=true

	public Border resaltarfecha_desdeRubrosVariables=null;
	public Boolean mostrarfecha_desdeRubrosVariables=true;
	public Boolean activarfecha_desdeRubrosVariables=true;

	public Border resaltarfecha_hastaRubrosVariables=null;
	public Boolean mostrarfecha_hastaRubrosVariables=true;
	public Boolean activarfecha_hastaRubrosVariables=true;

	public Border resaltarcodigoRubrosVariables=null;
	public Boolean mostrarcodigoRubrosVariables=true;
	public Boolean activarcodigoRubrosVariables=true;

	public Border resaltarnombreRubrosVariables=null;
	public Boolean mostrarnombreRubrosVariables=true;
	public Boolean activarnombreRubrosVariables=true;

	public Border resaltarfechaRubrosVariables=null;
	public Boolean mostrarfechaRubrosVariables=true;
	public Boolean activarfechaRubrosVariables=true;

	public Border resaltarvalorRubrosVariables=null;
	public Boolean mostrarvalorRubrosVariables=true;
	public Boolean activarvalorRubrosVariables=true;

	public Border resaltarnombre_rubro_empleaRubrosVariables=null;
	public Boolean mostrarnombre_rubro_empleaRubrosVariables=true;
	public Boolean activarnombre_rubro_empleaRubrosVariables=true;

	
	

	public Border setResaltaridRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltaridRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRubrosVariables() {
		return this.resaltaridRubrosVariables;
	}

	public void setResaltaridRubrosVariables(Border borderResaltar) {
		this.resaltaridRubrosVariables= borderResaltar;
	}

	public Boolean getMostraridRubrosVariables() {
		return this.mostraridRubrosVariables;
	}

	public void setMostraridRubrosVariables(Boolean mostraridRubrosVariables) {
		this.mostraridRubrosVariables= mostraridRubrosVariables;
	}

	public Boolean getActivaridRubrosVariables() {
		return this.activaridRubrosVariables;
	}

	public void setActivaridRubrosVariables(Boolean activaridRubrosVariables) {
		this.activaridRubrosVariables= activaridRubrosVariables;
	}

	public Border setResaltarid_tipo_contratoRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarid_tipo_contratoRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_contratoRubrosVariables() {
		return this.resaltarid_tipo_contratoRubrosVariables;
	}

	public void setResaltarid_tipo_contratoRubrosVariables(Border borderResaltar) {
		this.resaltarid_tipo_contratoRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarid_tipo_contratoRubrosVariables() {
		return this.mostrarid_tipo_contratoRubrosVariables;
	}

	public void setMostrarid_tipo_contratoRubrosVariables(Boolean mostrarid_tipo_contratoRubrosVariables) {
		this.mostrarid_tipo_contratoRubrosVariables= mostrarid_tipo_contratoRubrosVariables;
	}

	public Boolean getActivarid_tipo_contratoRubrosVariables() {
		return this.activarid_tipo_contratoRubrosVariables;
	}

	public void setActivarid_tipo_contratoRubrosVariables(Boolean activarid_tipo_contratoRubrosVariables) {
		this.activarid_tipo_contratoRubrosVariables= activarid_tipo_contratoRubrosVariables;
	}

	public Boolean getCargarid_tipo_contratoRubrosVariables() {
		return this.cargarid_tipo_contratoRubrosVariables;
	}

	public void setCargarid_tipo_contratoRubrosVariables(Boolean cargarid_tipo_contratoRubrosVariables) {
		this.cargarid_tipo_contratoRubrosVariables= cargarid_tipo_contratoRubrosVariables;
	}

	public Border setResaltarid_empresaRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarid_empresaRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRubrosVariables() {
		return this.resaltarid_empresaRubrosVariables;
	}

	public void setResaltarid_empresaRubrosVariables(Border borderResaltar) {
		this.resaltarid_empresaRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarid_empresaRubrosVariables() {
		return this.mostrarid_empresaRubrosVariables;
	}

	public void setMostrarid_empresaRubrosVariables(Boolean mostrarid_empresaRubrosVariables) {
		this.mostrarid_empresaRubrosVariables= mostrarid_empresaRubrosVariables;
	}

	public Boolean getActivarid_empresaRubrosVariables() {
		return this.activarid_empresaRubrosVariables;
	}

	public void setActivarid_empresaRubrosVariables(Boolean activarid_empresaRubrosVariables) {
		this.activarid_empresaRubrosVariables= activarid_empresaRubrosVariables;
	}

	public Boolean getCargarid_empresaRubrosVariables() {
		return this.cargarid_empresaRubrosVariables;
	}

	public void setCargarid_empresaRubrosVariables(Boolean cargarid_empresaRubrosVariables) {
		this.cargarid_empresaRubrosVariables= cargarid_empresaRubrosVariables;
	}

	public Border setResaltarid_rubro_empleaRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaRubrosVariables() {
		return this.resaltarid_rubro_empleaRubrosVariables;
	}

	public void setResaltarid_rubro_empleaRubrosVariables(Border borderResaltar) {
		this.resaltarid_rubro_empleaRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaRubrosVariables() {
		return this.mostrarid_rubro_empleaRubrosVariables;
	}

	public void setMostrarid_rubro_empleaRubrosVariables(Boolean mostrarid_rubro_empleaRubrosVariables) {
		this.mostrarid_rubro_empleaRubrosVariables= mostrarid_rubro_empleaRubrosVariables;
	}

	public Boolean getActivarid_rubro_empleaRubrosVariables() {
		return this.activarid_rubro_empleaRubrosVariables;
	}

	public void setActivarid_rubro_empleaRubrosVariables(Boolean activarid_rubro_empleaRubrosVariables) {
		this.activarid_rubro_empleaRubrosVariables= activarid_rubro_empleaRubrosVariables;
	}

	public Boolean getCargarid_rubro_empleaRubrosVariables() {
		return this.cargarid_rubro_empleaRubrosVariables;
	}

	public void setCargarid_rubro_empleaRubrosVariables(Boolean cargarid_rubro_empleaRubrosVariables) {
		this.cargarid_rubro_empleaRubrosVariables= cargarid_rubro_empleaRubrosVariables;
	}

	public Border setResaltarfecha_desdeRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeRubrosVariables() {
		return this.resaltarfecha_desdeRubrosVariables;
	}

	public void setResaltarfecha_desdeRubrosVariables(Border borderResaltar) {
		this.resaltarfecha_desdeRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeRubrosVariables() {
		return this.mostrarfecha_desdeRubrosVariables;
	}

	public void setMostrarfecha_desdeRubrosVariables(Boolean mostrarfecha_desdeRubrosVariables) {
		this.mostrarfecha_desdeRubrosVariables= mostrarfecha_desdeRubrosVariables;
	}

	public Boolean getActivarfecha_desdeRubrosVariables() {
		return this.activarfecha_desdeRubrosVariables;
	}

	public void setActivarfecha_desdeRubrosVariables(Boolean activarfecha_desdeRubrosVariables) {
		this.activarfecha_desdeRubrosVariables= activarfecha_desdeRubrosVariables;
	}

	public Border setResaltarfecha_hastaRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaRubrosVariables() {
		return this.resaltarfecha_hastaRubrosVariables;
	}

	public void setResaltarfecha_hastaRubrosVariables(Border borderResaltar) {
		this.resaltarfecha_hastaRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaRubrosVariables() {
		return this.mostrarfecha_hastaRubrosVariables;
	}

	public void setMostrarfecha_hastaRubrosVariables(Boolean mostrarfecha_hastaRubrosVariables) {
		this.mostrarfecha_hastaRubrosVariables= mostrarfecha_hastaRubrosVariables;
	}

	public Boolean getActivarfecha_hastaRubrosVariables() {
		return this.activarfecha_hastaRubrosVariables;
	}

	public void setActivarfecha_hastaRubrosVariables(Boolean activarfecha_hastaRubrosVariables) {
		this.activarfecha_hastaRubrosVariables= activarfecha_hastaRubrosVariables;
	}

	public Border setResaltarcodigoRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarcodigoRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoRubrosVariables() {
		return this.resaltarcodigoRubrosVariables;
	}

	public void setResaltarcodigoRubrosVariables(Border borderResaltar) {
		this.resaltarcodigoRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarcodigoRubrosVariables() {
		return this.mostrarcodigoRubrosVariables;
	}

	public void setMostrarcodigoRubrosVariables(Boolean mostrarcodigoRubrosVariables) {
		this.mostrarcodigoRubrosVariables= mostrarcodigoRubrosVariables;
	}

	public Boolean getActivarcodigoRubrosVariables() {
		return this.activarcodigoRubrosVariables;
	}

	public void setActivarcodigoRubrosVariables(Boolean activarcodigoRubrosVariables) {
		this.activarcodigoRubrosVariables= activarcodigoRubrosVariables;
	}

	public Border setResaltarnombreRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarnombreRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRubrosVariables() {
		return this.resaltarnombreRubrosVariables;
	}

	public void setResaltarnombreRubrosVariables(Border borderResaltar) {
		this.resaltarnombreRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarnombreRubrosVariables() {
		return this.mostrarnombreRubrosVariables;
	}

	public void setMostrarnombreRubrosVariables(Boolean mostrarnombreRubrosVariables) {
		this.mostrarnombreRubrosVariables= mostrarnombreRubrosVariables;
	}

	public Boolean getActivarnombreRubrosVariables() {
		return this.activarnombreRubrosVariables;
	}

	public void setActivarnombreRubrosVariables(Boolean activarnombreRubrosVariables) {
		this.activarnombreRubrosVariables= activarnombreRubrosVariables;
	}

	public Border setResaltarfechaRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarfechaRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaRubrosVariables() {
		return this.resaltarfechaRubrosVariables;
	}

	public void setResaltarfechaRubrosVariables(Border borderResaltar) {
		this.resaltarfechaRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarfechaRubrosVariables() {
		return this.mostrarfechaRubrosVariables;
	}

	public void setMostrarfechaRubrosVariables(Boolean mostrarfechaRubrosVariables) {
		this.mostrarfechaRubrosVariables= mostrarfechaRubrosVariables;
	}

	public Boolean getActivarfechaRubrosVariables() {
		return this.activarfechaRubrosVariables;
	}

	public void setActivarfechaRubrosVariables(Boolean activarfechaRubrosVariables) {
		this.activarfechaRubrosVariables= activarfechaRubrosVariables;
	}

	public Border setResaltarvalorRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarvalorRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRubrosVariables() {
		return this.resaltarvalorRubrosVariables;
	}

	public void setResaltarvalorRubrosVariables(Border borderResaltar) {
		this.resaltarvalorRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarvalorRubrosVariables() {
		return this.mostrarvalorRubrosVariables;
	}

	public void setMostrarvalorRubrosVariables(Boolean mostrarvalorRubrosVariables) {
		this.mostrarvalorRubrosVariables= mostrarvalorRubrosVariables;
	}

	public Boolean getActivarvalorRubrosVariables() {
		return this.activarvalorRubrosVariables;
	}

	public void setActivarvalorRubrosVariables(Boolean activarvalorRubrosVariables) {
		this.activarvalorRubrosVariables= activarvalorRubrosVariables;
	}

	public Border setResaltarnombre_rubro_empleaRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubrosvariablesBeanSwingJInternalFrame.jTtoolBarRubrosVariables.setBorder(borderResaltar);
		
		this.resaltarnombre_rubro_empleaRubrosVariables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_rubro_empleaRubrosVariables() {
		return this.resaltarnombre_rubro_empleaRubrosVariables;
	}

	public void setResaltarnombre_rubro_empleaRubrosVariables(Border borderResaltar) {
		this.resaltarnombre_rubro_empleaRubrosVariables= borderResaltar;
	}

	public Boolean getMostrarnombre_rubro_empleaRubrosVariables() {
		return this.mostrarnombre_rubro_empleaRubrosVariables;
	}

	public void setMostrarnombre_rubro_empleaRubrosVariables(Boolean mostrarnombre_rubro_empleaRubrosVariables) {
		this.mostrarnombre_rubro_empleaRubrosVariables= mostrarnombre_rubro_empleaRubrosVariables;
	}

	public Boolean getActivarnombre_rubro_empleaRubrosVariables() {
		return this.activarnombre_rubro_empleaRubrosVariables;
	}

	public void setActivarnombre_rubro_empleaRubrosVariables(Boolean activarnombre_rubro_empleaRubrosVariables) {
		this.activarnombre_rubro_empleaRubrosVariables= activarnombre_rubro_empleaRubrosVariables;
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
		
		
		this.setMostraridRubrosVariables(esInicial);
		this.setMostrarid_tipo_contratoRubrosVariables(esInicial);
		this.setMostrarid_empresaRubrosVariables(esInicial);
		this.setMostrarid_rubro_empleaRubrosVariables(esInicial);
		this.setMostrarfecha_desdeRubrosVariables(esInicial);
		this.setMostrarfecha_hastaRubrosVariables(esInicial);
		this.setMostrarcodigoRubrosVariables(esInicial);
		this.setMostrarnombreRubrosVariables(esInicial);
		this.setMostrarfechaRubrosVariables(esInicial);
		this.setMostrarvalorRubrosVariables(esInicial);
		this.setMostrarnombre_rubro_empleaRubrosVariables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.ID)) {
				this.setMostraridRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDTIPOCONTRATO)) {
				this.setMostrarid_tipo_contratoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHA)) {
				this.setMostrarfechaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.VALOR)) {
				this.setMostrarvalorRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setMostrarnombre_rubro_empleaRubrosVariables(esAsigna);
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
		
		
		this.setActivaridRubrosVariables(esInicial);
		this.setActivarid_tipo_contratoRubrosVariables(esInicial);
		this.setActivarid_empresaRubrosVariables(esInicial);
		this.setActivarid_rubro_empleaRubrosVariables(esInicial);
		this.setActivarfecha_desdeRubrosVariables(esInicial);
		this.setActivarfecha_hastaRubrosVariables(esInicial);
		this.setActivarcodigoRubrosVariables(esInicial);
		this.setActivarnombreRubrosVariables(esInicial);
		this.setActivarfechaRubrosVariables(esInicial);
		this.setActivarvalorRubrosVariables(esInicial);
		this.setActivarnombre_rubro_empleaRubrosVariables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.ID)) {
				this.setActivaridRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDTIPOCONTRATO)) {
				this.setActivarid_tipo_contratoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHA)) {
				this.setActivarfechaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.VALOR)) {
				this.setActivarvalorRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setActivarnombre_rubro_empleaRubrosVariables(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRubrosVariables(esInicial);
		this.setResaltarid_tipo_contratoRubrosVariables(esInicial);
		this.setResaltarid_empresaRubrosVariables(esInicial);
		this.setResaltarid_rubro_empleaRubrosVariables(esInicial);
		this.setResaltarfecha_desdeRubrosVariables(esInicial);
		this.setResaltarfecha_hastaRubrosVariables(esInicial);
		this.setResaltarcodigoRubrosVariables(esInicial);
		this.setResaltarnombreRubrosVariables(esInicial);
		this.setResaltarfechaRubrosVariables(esInicial);
		this.setResaltarvalorRubrosVariables(esInicial);
		this.setResaltarnombre_rubro_empleaRubrosVariables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.ID)) {
				this.setResaltaridRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDTIPOCONTRATO)) {
				this.setResaltarid_tipo_contratoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.FECHA)) {
				this.setResaltarfechaRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.VALOR)) {
				this.setResaltarvalorRubrosVariables(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubrosVariablesConstantesFunciones.NOMBRERUBROEMPLEA)) {
				this.setResaltarnombre_rubro_empleaRubrosVariables(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaRubrosVariablesRubrosVariables=true;

	public Boolean getMostrarBusquedaRubrosVariablesRubrosVariables() {
		return this.mostrarBusquedaRubrosVariablesRubrosVariables;
	}

	public void setMostrarBusquedaRubrosVariablesRubrosVariables(Boolean visibilidadResaltar) {
		this.mostrarBusquedaRubrosVariablesRubrosVariables= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaRubrosVariablesRubrosVariables=true;

	public Boolean getActivarBusquedaRubrosVariablesRubrosVariables() {
		return this.activarBusquedaRubrosVariablesRubrosVariables;
	}

	public void setActivarBusquedaRubrosVariablesRubrosVariables(Boolean habilitarResaltar) {
		this.activarBusquedaRubrosVariablesRubrosVariables= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaRubrosVariablesRubrosVariables=null;

	public Border getResaltarBusquedaRubrosVariablesRubrosVariables() {
		return this.resaltarBusquedaRubrosVariablesRubrosVariables;
	}

	public void setResaltarBusquedaRubrosVariablesRubrosVariables(Border borderResaltar) {
		this.resaltarBusquedaRubrosVariablesRubrosVariables= borderResaltar;
	}

	public void setResaltarBusquedaRubrosVariablesRubrosVariables(ParametroGeneralUsuario parametroGeneralUsuario/*RubrosVariablesBeanSwingJInternalFrame rubrosvariablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaRubrosVariablesRubrosVariables= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}