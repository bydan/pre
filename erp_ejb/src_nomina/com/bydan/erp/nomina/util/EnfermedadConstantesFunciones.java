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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EnfermedadConstantesFunciones;
import com.bydan.erp.nomina.util.EnfermedadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EnfermedadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EnfermedadConstantesFunciones extends EnfermedadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Enfermedad";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Enfermedad"+EnfermedadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EnfermedadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EnfermedadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EnfermedadConstantesFunciones.SCHEMA+"_"+EnfermedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EnfermedadConstantesFunciones.SCHEMA+"_"+EnfermedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EnfermedadConstantesFunciones.SCHEMA+"_"+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EnfermedadConstantesFunciones.SCHEMA+"_"+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EnfermedadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EnfermedadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EnfermedadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EnfermedadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Enfermedades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Enfermedad";
	public static final String SCLASSWEBTITULO_LOWER="Enfermedad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Enfermedad";
	public static final String OBJECTNAME="enfermedad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="enfermedad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select enfermedad from "+EnfermedadConstantesFunciones.SPERSISTENCENAME+" enfermedad";
	public static String QUERYSELECTNATIVE="select "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".version_row,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id_empresa,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id_tipo_enfermedad,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".nombre,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".descripcion from "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME;//+" as "+EnfermedadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EnfermedadConstantesFuncionesAdditional enfermedadConstantesFuncionesAdditional=null;
	
	public EnfermedadConstantesFuncionesAdditional getEnfermedadConstantesFuncionesAdditional() {
		return this.enfermedadConstantesFuncionesAdditional;
	}
	
	public void setEnfermedadConstantesFuncionesAdditional(EnfermedadConstantesFuncionesAdditional enfermedadConstantesFuncionesAdditional) {
		try {
			this.enfermedadConstantesFuncionesAdditional=enfermedadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOENFERMEDAD= "id_tipo_enfermedad";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOENFERMEDAD= "Tipo Enfermedad";
		public static final String LABEL_IDTIPOENFERMEDAD_LOWER= "Tipo Enfermedad";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEnfermedadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EnfermedadConstantesFunciones.IDEMPRESA)) {sLabelColumna=EnfermedadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EnfermedadConstantesFunciones.IDTIPOENFERMEDAD)) {sLabelColumna=EnfermedadConstantesFunciones.LABEL_IDTIPOENFERMEDAD;}
		if(sNombreColumna.equals(EnfermedadConstantesFunciones.NOMBRE)) {sLabelColumna=EnfermedadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EnfermedadConstantesFunciones.DESCRIPCION)) {sLabelColumna=EnfermedadConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEnfermedadDescripcion(Enfermedad enfermedad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(enfermedad !=null/* && enfermedad.getId()!=0*/) {
			sDescripcion=enfermedad.getnombre();//enfermedadenfermedad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEnfermedadDescripcionDetallado(Enfermedad enfermedad) {
		String sDescripcion="";
			
		sDescripcion+=EnfermedadConstantesFunciones.ID+"=";
		sDescripcion+=enfermedad.getId().toString()+",";
		sDescripcion+=EnfermedadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=enfermedad.getVersionRow().toString()+",";
		sDescripcion+=EnfermedadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=enfermedad.getid_empresa().toString()+",";
		sDescripcion+=EnfermedadConstantesFunciones.IDTIPOENFERMEDAD+"=";
		sDescripcion+=enfermedad.getid_tipo_enfermedad().toString()+",";
		sDescripcion+=EnfermedadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=enfermedad.getnombre()+",";
		sDescripcion+=EnfermedadConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=enfermedad.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEnfermedadDescripcion(Enfermedad enfermedad,String sValor) throws Exception {			
		if(enfermedad !=null) {
			enfermedad.setnombre(sValor);;//enfermedadenfermedad.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoEnfermedadDescripcion(TipoEnfermedad tipoenfermedad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoenfermedad!=null/*&&tipoenfermedad.getId()>0*/) {
			sDescripcion=TipoEnfermedadConstantesFunciones.getTipoEnfermedadDescripcion(tipoenfermedad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoEnfermedad")) {
			sNombreIndice="Tipo=  Por Tipo Enfermedad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEnfermedad(Long id_tipo_enfermedad) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_enfermedad!=null) {sDetalleIndice+=" Codigo Unico De Tipo Enfermedad="+id_tipo_enfermedad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEnfermedad(Enfermedad enfermedad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		enfermedad.setnombre(enfermedad.getnombre().trim());
		enfermedad.setdescripcion(enfermedad.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEnfermedads(List<Enfermedad> enfermedads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Enfermedad enfermedad: enfermedads) {
			enfermedad.setnombre(enfermedad.getnombre().trim());
			enfermedad.setdescripcion(enfermedad.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEnfermedad(Enfermedad enfermedad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && enfermedad.getConCambioAuxiliar()) {
			enfermedad.setIsDeleted(enfermedad.getIsDeletedAuxiliar());	
			enfermedad.setIsNew(enfermedad.getIsNewAuxiliar());	
			enfermedad.setIsChanged(enfermedad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			enfermedad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			enfermedad.setIsDeletedAuxiliar(false);	
			enfermedad.setIsNewAuxiliar(false);	
			enfermedad.setIsChangedAuxiliar(false);
			
			enfermedad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEnfermedads(List<Enfermedad> enfermedads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Enfermedad enfermedad : enfermedads) {
			if(conAsignarBase && enfermedad.getConCambioAuxiliar()) {
				enfermedad.setIsDeleted(enfermedad.getIsDeletedAuxiliar());	
				enfermedad.setIsNew(enfermedad.getIsNewAuxiliar());	
				enfermedad.setIsChanged(enfermedad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				enfermedad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				enfermedad.setIsDeletedAuxiliar(false);	
				enfermedad.setIsNewAuxiliar(false);	
				enfermedad.setIsChangedAuxiliar(false);
				
				enfermedad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEnfermedad(Enfermedad enfermedad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEnfermedads(List<Enfermedad> enfermedads,Boolean conEnteros) throws Exception  {
		
		for(Enfermedad enfermedad: enfermedads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEnfermedad(List<Enfermedad> enfermedads,Enfermedad enfermedadAux) throws Exception  {
		EnfermedadConstantesFunciones.InicializarValoresEnfermedad(enfermedadAux,true);
		
		for(Enfermedad enfermedad: enfermedads) {
			if(enfermedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EnfermedadConstantesFunciones.getArrayColumnasGlobalesEnfermedad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EnfermedadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EnfermedadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Enfermedad> enfermedads,Enfermedad enfermedad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Enfermedad enfermedadAux: enfermedads) {
			if(enfermedadAux!=null && enfermedad!=null) {
				if((enfermedadAux.getId()==null && enfermedad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(enfermedadAux.getId()!=null && enfermedad.getId()!=null){
					if(enfermedadAux.getId().equals(enfermedad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEnfermedad(List<Enfermedad> enfermedads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Enfermedad enfermedad: enfermedads) {			
			if(enfermedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEnfermedad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_ID, EnfermedadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_VERSIONROW, EnfermedadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_IDEMPRESA, EnfermedadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_IDTIPOENFERMEDAD, EnfermedadConstantesFunciones.IDTIPOENFERMEDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_NOMBRE, EnfermedadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EnfermedadConstantesFunciones.LABEL_DESCRIPCION, EnfermedadConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEnfermedad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.IDTIPOENFERMEDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EnfermedadConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEnfermedad() throws Exception  {
		return EnfermedadConstantesFunciones.getTiposSeleccionarEnfermedad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEnfermedad(Boolean conFk) throws Exception  {
		return EnfermedadConstantesFunciones.getTiposSeleccionarEnfermedad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEnfermedad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EnfermedadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EnfermedadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EnfermedadConstantesFunciones.LABEL_IDTIPOENFERMEDAD);
			reporte.setsDescripcion(EnfermedadConstantesFunciones.LABEL_IDTIPOENFERMEDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EnfermedadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EnfermedadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EnfermedadConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EnfermedadConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEnfermedad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEnfermedad(Enfermedad enfermedadAux) throws Exception {
		
			enfermedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(enfermedadAux.getEmpresa()));
			enfermedadAux.settipoenfermedad_descripcion(TipoEnfermedadConstantesFunciones.getTipoEnfermedadDescripcion(enfermedadAux.getTipoEnfermedad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEnfermedad(List<Enfermedad> enfermedadsTemp) throws Exception {
		for(Enfermedad enfermedadAux:enfermedadsTemp) {
			
			enfermedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(enfermedadAux.getEmpresa()));
			enfermedadAux.settipoenfermedad_descripcion(TipoEnfermedadConstantesFunciones.getTipoEnfermedadDescripcion(enfermedadAux.getTipoEnfermedad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoEnfermedad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEnfermedad.class)) {
						classes.add(new Classe(TipoEnfermedad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoEnfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEnfermedad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoEnfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEnfermedad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EnfermedadConstantesFunciones.getClassesRelationshipsOfEnfermedad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoEnfer.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoEnfer.class)) {
						classes.add(new Classe(EmpleadoEnfer.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EnfermedadConstantesFunciones.getClassesRelationshipsFromStringsOfEnfermedad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoEnfer.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEnfer.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoEnfer.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEnfer.class)); continue;
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
	public static void actualizarLista(Enfermedad enfermedad,List<Enfermedad> enfermedads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Enfermedad enfermedadEncontrado=null;
			
			for(Enfermedad enfermedadLocal:enfermedads) {
				if(enfermedadLocal.getId().equals(enfermedad.getId())) {
					enfermedadEncontrado=enfermedadLocal;
					
					enfermedadLocal.setIsChanged(enfermedad.getIsChanged());
					enfermedadLocal.setIsNew(enfermedad.getIsNew());
					enfermedadLocal.setIsDeleted(enfermedad.getIsDeleted());
					
					enfermedadLocal.setGeneralEntityOriginal(enfermedad.getGeneralEntityOriginal());
					
					enfermedadLocal.setId(enfermedad.getId());	
					enfermedadLocal.setVersionRow(enfermedad.getVersionRow());	
					enfermedadLocal.setid_empresa(enfermedad.getid_empresa());	
					enfermedadLocal.setid_tipo_enfermedad(enfermedad.getid_tipo_enfermedad());	
					enfermedadLocal.setnombre(enfermedad.getnombre());	
					enfermedadLocal.setdescripcion(enfermedad.getdescripcion());	
					
					
					enfermedadLocal.setEmpleadoEnfers(enfermedad.getEmpleadoEnfers());
					
					existe=true;
					break;
				}
			}
			
			if(!enfermedad.getIsDeleted()) {
				if(!existe) {
					enfermedads.add(enfermedad);
				}
			} else {
				if(enfermedadEncontrado!=null && permiteQuitar)  {
					enfermedads.remove(enfermedadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Enfermedad enfermedad,List<Enfermedad> enfermedads) throws Exception {
		try	{			
			for(Enfermedad enfermedadLocal:enfermedads) {
				if(enfermedadLocal.getId().equals(enfermedad.getId())) {
					enfermedadLocal.setIsSelected(enfermedad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEnfermedad(List<Enfermedad> enfermedadsAux) throws Exception {
		//this.enfermedadsAux=enfermedadsAux;
		
		for(Enfermedad enfermedadAux:enfermedadsAux) {
			if(enfermedadAux.getIsChanged()) {
				enfermedadAux.setIsChanged(false);
			}		
			
			if(enfermedadAux.getIsNew()) {
				enfermedadAux.setIsNew(false);
			}	
			
			if(enfermedadAux.getIsDeleted()) {
				enfermedadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEnfermedad(Enfermedad enfermedadAux) throws Exception {
		//this.enfermedadAux=enfermedadAux;
		
			if(enfermedadAux.getIsChanged()) {
				enfermedadAux.setIsChanged(false);
			}		
			
			if(enfermedadAux.getIsNew()) {
				enfermedadAux.setIsNew(false);
			}	
			
			if(enfermedadAux.getIsDeleted()) {
				enfermedadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Enfermedad enfermedadAsignar,Enfermedad enfermedad) throws Exception {
		enfermedadAsignar.setId(enfermedad.getId());	
		enfermedadAsignar.setVersionRow(enfermedad.getVersionRow());	
		enfermedadAsignar.setid_empresa(enfermedad.getid_empresa());
		enfermedadAsignar.setempresa_descripcion(enfermedad.getempresa_descripcion());	
		enfermedadAsignar.setid_tipo_enfermedad(enfermedad.getid_tipo_enfermedad());
		enfermedadAsignar.settipoenfermedad_descripcion(enfermedad.gettipoenfermedad_descripcion());	
		enfermedadAsignar.setnombre(enfermedad.getnombre());	
		enfermedadAsignar.setdescripcion(enfermedad.getdescripcion());	
	}
	
	public static void inicializarEnfermedad(Enfermedad enfermedad) throws Exception {
		try {
				enfermedad.setId(0L);	
					
				enfermedad.setid_empresa(-1L);	
				enfermedad.setid_tipo_enfermedad(-1L);	
				enfermedad.setnombre("");	
				enfermedad.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEnfermedad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EnfermedadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EnfermedadConstantesFunciones.LABEL_IDTIPOENFERMEDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EnfermedadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EnfermedadConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEnfermedad(String sTipo,Row row,Workbook workbook,Enfermedad enfermedad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(enfermedad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(enfermedad.gettipoenfermedad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(enfermedad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(enfermedad.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEnfermedad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEnfermedad() {
		return this.sFinalQueryEnfermedad;
	}
	
	public void setsFinalQueryEnfermedad(String sFinalQueryEnfermedad) {
		this.sFinalQueryEnfermedad= sFinalQueryEnfermedad;
	}
	
	public Border resaltarSeleccionarEnfermedad=null;
	
	public Border setResaltarSeleccionarEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEnfermedad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEnfermedad() {
		return this.resaltarSeleccionarEnfermedad;
	}
	
	public void setResaltarSeleccionarEnfermedad(Border borderResaltarSeleccionarEnfermedad) {
		this.resaltarSeleccionarEnfermedad= borderResaltarSeleccionarEnfermedad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEnfermedad=null;
	public Boolean mostraridEnfermedad=true;
	public Boolean activaridEnfermedad=true;

	public Border resaltarid_empresaEnfermedad=null;
	public Boolean mostrarid_empresaEnfermedad=true;
	public Boolean activarid_empresaEnfermedad=true;
	public Boolean cargarid_empresaEnfermedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEnfermedad=false;//ConEventDepend=true

	public Border resaltarid_tipo_enfermedadEnfermedad=null;
	public Boolean mostrarid_tipo_enfermedadEnfermedad=true;
	public Boolean activarid_tipo_enfermedadEnfermedad=true;
	public Boolean cargarid_tipo_enfermedadEnfermedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_enfermedadEnfermedad=false;//ConEventDepend=true

	public Border resaltarnombreEnfermedad=null;
	public Boolean mostrarnombreEnfermedad=true;
	public Boolean activarnombreEnfermedad=true;

	public Border resaltardescripcionEnfermedad=null;
	public Boolean mostrardescripcionEnfermedad=true;
	public Boolean activardescripcionEnfermedad=true;

	
	

	public Border setResaltaridEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltaridEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEnfermedad() {
		return this.resaltaridEnfermedad;
	}

	public void setResaltaridEnfermedad(Border borderResaltar) {
		this.resaltaridEnfermedad= borderResaltar;
	}

	public Boolean getMostraridEnfermedad() {
		return this.mostraridEnfermedad;
	}

	public void setMostraridEnfermedad(Boolean mostraridEnfermedad) {
		this.mostraridEnfermedad= mostraridEnfermedad;
	}

	public Boolean getActivaridEnfermedad() {
		return this.activaridEnfermedad;
	}

	public void setActivaridEnfermedad(Boolean activaridEnfermedad) {
		this.activaridEnfermedad= activaridEnfermedad;
	}

	public Border setResaltarid_empresaEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltarid_empresaEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEnfermedad() {
		return this.resaltarid_empresaEnfermedad;
	}

	public void setResaltarid_empresaEnfermedad(Border borderResaltar) {
		this.resaltarid_empresaEnfermedad= borderResaltar;
	}

	public Boolean getMostrarid_empresaEnfermedad() {
		return this.mostrarid_empresaEnfermedad;
	}

	public void setMostrarid_empresaEnfermedad(Boolean mostrarid_empresaEnfermedad) {
		this.mostrarid_empresaEnfermedad= mostrarid_empresaEnfermedad;
	}

	public Boolean getActivarid_empresaEnfermedad() {
		return this.activarid_empresaEnfermedad;
	}

	public void setActivarid_empresaEnfermedad(Boolean activarid_empresaEnfermedad) {
		this.activarid_empresaEnfermedad= activarid_empresaEnfermedad;
	}

	public Boolean getCargarid_empresaEnfermedad() {
		return this.cargarid_empresaEnfermedad;
	}

	public void setCargarid_empresaEnfermedad(Boolean cargarid_empresaEnfermedad) {
		this.cargarid_empresaEnfermedad= cargarid_empresaEnfermedad;
	}

	public Border setResaltarid_tipo_enfermedadEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltarid_tipo_enfermedadEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_enfermedadEnfermedad() {
		return this.resaltarid_tipo_enfermedadEnfermedad;
	}

	public void setResaltarid_tipo_enfermedadEnfermedad(Border borderResaltar) {
		this.resaltarid_tipo_enfermedadEnfermedad= borderResaltar;
	}

	public Boolean getMostrarid_tipo_enfermedadEnfermedad() {
		return this.mostrarid_tipo_enfermedadEnfermedad;
	}

	public void setMostrarid_tipo_enfermedadEnfermedad(Boolean mostrarid_tipo_enfermedadEnfermedad) {
		this.mostrarid_tipo_enfermedadEnfermedad= mostrarid_tipo_enfermedadEnfermedad;
	}

	public Boolean getActivarid_tipo_enfermedadEnfermedad() {
		return this.activarid_tipo_enfermedadEnfermedad;
	}

	public void setActivarid_tipo_enfermedadEnfermedad(Boolean activarid_tipo_enfermedadEnfermedad) {
		this.activarid_tipo_enfermedadEnfermedad= activarid_tipo_enfermedadEnfermedad;
	}

	public Boolean getCargarid_tipo_enfermedadEnfermedad() {
		return this.cargarid_tipo_enfermedadEnfermedad;
	}

	public void setCargarid_tipo_enfermedadEnfermedad(Boolean cargarid_tipo_enfermedadEnfermedad) {
		this.cargarid_tipo_enfermedadEnfermedad= cargarid_tipo_enfermedadEnfermedad;
	}

	public Border setResaltarnombreEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltarnombreEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEnfermedad() {
		return this.resaltarnombreEnfermedad;
	}

	public void setResaltarnombreEnfermedad(Border borderResaltar) {
		this.resaltarnombreEnfermedad= borderResaltar;
	}

	public Boolean getMostrarnombreEnfermedad() {
		return this.mostrarnombreEnfermedad;
	}

	public void setMostrarnombreEnfermedad(Boolean mostrarnombreEnfermedad) {
		this.mostrarnombreEnfermedad= mostrarnombreEnfermedad;
	}

	public Boolean getActivarnombreEnfermedad() {
		return this.activarnombreEnfermedad;
	}

	public void setActivarnombreEnfermedad(Boolean activarnombreEnfermedad) {
		this.activarnombreEnfermedad= activarnombreEnfermedad;
	}

	public Border setResaltardescripcionEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltar);
		
		this.resaltardescripcionEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEnfermedad() {
		return this.resaltardescripcionEnfermedad;
	}

	public void setResaltardescripcionEnfermedad(Border borderResaltar) {
		this.resaltardescripcionEnfermedad= borderResaltar;
	}

	public Boolean getMostrardescripcionEnfermedad() {
		return this.mostrardescripcionEnfermedad;
	}

	public void setMostrardescripcionEnfermedad(Boolean mostrardescripcionEnfermedad) {
		this.mostrardescripcionEnfermedad= mostrardescripcionEnfermedad;
	}

	public Boolean getActivardescripcionEnfermedad() {
		return this.activardescripcionEnfermedad;
	}

	public void setActivardescripcionEnfermedad(Boolean activardescripcionEnfermedad) {
		this.activardescripcionEnfermedad= activardescripcionEnfermedad;
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
		
		
		this.setMostraridEnfermedad(esInicial);
		this.setMostrarid_empresaEnfermedad(esInicial);
		this.setMostrarid_tipo_enfermedadEnfermedad(esInicial);
		this.setMostrarnombreEnfermedad(esInicial);
		this.setMostrardescripcionEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EnfermedadConstantesFunciones.ID)) {
				this.setMostraridEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDTIPOENFERMEDAD)) {
				this.setMostrarid_tipo_enfermedadEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEnfermedad(esAsigna);
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
		
		
		this.setActivaridEnfermedad(esInicial);
		this.setActivarid_empresaEnfermedad(esInicial);
		this.setActivarid_tipo_enfermedadEnfermedad(esInicial);
		this.setActivarnombreEnfermedad(esInicial);
		this.setActivardescripcionEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EnfermedadConstantesFunciones.ID)) {
				this.setActivaridEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDTIPOENFERMEDAD)) {
				this.setActivarid_tipo_enfermedadEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEnfermedad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEnfermedad(esInicial);
		this.setResaltarid_empresaEnfermedad(esInicial);
		this.setResaltarid_tipo_enfermedadEnfermedad(esInicial);
		this.setResaltarnombreEnfermedad(esInicial);
		this.setResaltardescripcionEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EnfermedadConstantesFunciones.ID)) {
				this.setResaltaridEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.IDTIPOENFERMEDAD)) {
				this.setResaltarid_tipo_enfermedadEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(EnfermedadConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEnfermedad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoEnferEnfermedad=null;

	public Border getResaltarEmpleadoEnferEnfermedad() {
		return this.resaltarEmpleadoEnferEnfermedad;
	}

	public void setResaltarEmpleadoEnferEnfermedad(Border borderResaltarEmpleadoEnfer) {
		if(borderResaltarEmpleadoEnfer!=null) {
			this.resaltarEmpleadoEnferEnfermedad= borderResaltarEmpleadoEnfer;
		}
	}

	public Border setResaltarEmpleadoEnferEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoEnfer=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//enfermedadBeanSwingJInternalFrame.jTtoolBarEnfermedad.setBorder(borderResaltarEmpleadoEnfer);
			
		this.resaltarEmpleadoEnferEnfermedad= borderResaltarEmpleadoEnfer;

		 return borderResaltarEmpleadoEnfer;
	}



	public Boolean mostrarEmpleadoEnferEnfermedad=true;

	public Boolean getMostrarEmpleadoEnferEnfermedad() {
		return this.mostrarEmpleadoEnferEnfermedad;
	}

	public void setMostrarEmpleadoEnferEnfermedad(Boolean visibilidadResaltarEmpleadoEnfer) {
		this.mostrarEmpleadoEnferEnfermedad= visibilidadResaltarEmpleadoEnfer;
	}



	public Boolean activarEmpleadoEnferEnfermedad=true;

	public Boolean gethabilitarResaltarEmpleadoEnferEnfermedad() {
		return this.activarEmpleadoEnferEnfermedad;
	}

	public void setActivarEmpleadoEnferEnfermedad(Boolean habilitarResaltarEmpleadoEnfer) {
		this.activarEmpleadoEnferEnfermedad= habilitarResaltarEmpleadoEnfer;
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

		this.setMostrarEmpleadoEnferEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setMostrarEmpleadoEnferEnfermedad(esAsigna);
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

		this.setActivarEmpleadoEnferEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setActivarEmpleadoEnferEnfermedad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoEnferEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setResaltarEmpleadoEnferEnfermedad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaEnfermedad=true;

	public Boolean getMostrarFK_IdEmpresaEnfermedad() {
		return this.mostrarFK_IdEmpresaEnfermedad;
	}

	public void setMostrarFK_IdEmpresaEnfermedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEnfermedad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEnfermedadEnfermedad=true;

	public Boolean getMostrarFK_IdTipoEnfermedadEnfermedad() {
		return this.mostrarFK_IdTipoEnfermedadEnfermedad;
	}

	public void setMostrarFK_IdTipoEnfermedadEnfermedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEnfermedadEnfermedad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaEnfermedad=true;

	public Boolean getActivarFK_IdEmpresaEnfermedad() {
		return this.activarFK_IdEmpresaEnfermedad;
	}

	public void setActivarFK_IdEmpresaEnfermedad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEnfermedad= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEnfermedadEnfermedad=true;

	public Boolean getActivarFK_IdTipoEnfermedadEnfermedad() {
		return this.activarFK_IdTipoEnfermedadEnfermedad;
	}

	public void setActivarFK_IdTipoEnfermedadEnfermedad(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEnfermedadEnfermedad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaEnfermedad=null;

	public Border getResaltarFK_IdEmpresaEnfermedad() {
		return this.resaltarFK_IdEmpresaEnfermedad;
	}

	public void setResaltarFK_IdEmpresaEnfermedad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEnfermedad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEnfermedad= borderResaltar;
	}

	public Border resaltarFK_IdTipoEnfermedadEnfermedad=null;

	public Border getResaltarFK_IdTipoEnfermedadEnfermedad() {
		return this.resaltarFK_IdTipoEnfermedadEnfermedad;
	}

	public void setResaltarFK_IdTipoEnfermedadEnfermedad(Border borderResaltar) {
		this.resaltarFK_IdTipoEnfermedadEnfermedad= borderResaltar;
	}

	public void setResaltarFK_IdTipoEnfermedadEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*EnfermedadBeanSwingJInternalFrame enfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEnfermedadEnfermedad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}