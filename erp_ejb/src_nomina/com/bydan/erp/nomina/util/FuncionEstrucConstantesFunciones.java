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


import com.bydan.erp.nomina.util.FuncionEstrucConstantesFunciones;
import com.bydan.erp.nomina.util.FuncionEstrucParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FuncionEstrucParameterGeneral;

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
final public class FuncionEstrucConstantesFunciones extends FuncionEstrucConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FuncionEstruc";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FuncionEstruc"+FuncionEstrucConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FuncionEstrucHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FuncionEstrucHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FuncionEstrucConstantesFunciones.SCHEMA+"_"+FuncionEstrucConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FuncionEstrucHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FuncionEstrucConstantesFunciones.SCHEMA+"_"+FuncionEstrucConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FuncionEstrucConstantesFunciones.SCHEMA+"_"+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FuncionEstrucHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FuncionEstrucConstantesFunciones.SCHEMA+"_"+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FuncionEstrucHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FuncionEstrucHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionEstrucConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FuncionEstrucConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FuncionEstrucConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FuncionEstrucConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FuncionEstrucConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Funcion Estruces";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Funcion Estruc";
	public static final String SCLASSWEBTITULO_LOWER="Funcion Estruc";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FuncionEstruc";
	public static final String OBJECTNAME="funcionestruc";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="funcion_estruc";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select funcionestruc from "+FuncionEstrucConstantesFunciones.SPERSISTENCENAME+" funcionestruc";
	public static String QUERYSELECTNATIVE="select "+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".id,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".version_row,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".id_empresa,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".id_sucursal,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".id_estructura,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".id_funcion,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".nombre,"+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME+".descripcion from "+FuncionEstrucConstantesFunciones.SCHEMA+"."+FuncionEstrucConstantesFunciones.TABLENAME;//+" as "+FuncionEstrucConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FuncionEstrucConstantesFuncionesAdditional funcionestrucConstantesFuncionesAdditional=null;
	
	public FuncionEstrucConstantesFuncionesAdditional getFuncionEstrucConstantesFuncionesAdditional() {
		return this.funcionestrucConstantesFuncionesAdditional;
	}
	
	public void setFuncionEstrucConstantesFuncionesAdditional(FuncionEstrucConstantesFuncionesAdditional funcionestrucConstantesFuncionesAdditional) {
		try {
			this.funcionestrucConstantesFuncionesAdditional=funcionestrucConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDFUNCION= "id_funcion";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDFUNCION= "Funcion";
		public static final String LABEL_IDFUNCION_LOWER= "Funcion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFuncionEstrucLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.IDEMPRESA)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.IDFUNCION)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_IDFUNCION;}
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.NOMBRE)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FuncionEstrucConstantesFunciones.DESCRIPCION)) {sLabelColumna=FuncionEstrucConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getFuncionEstrucDescripcion(FuncionEstruc funcionestruc) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(funcionestruc !=null/* && funcionestruc.getId()!=0*/) {
			sDescripcion=funcionestruc.getnombre();//funcionestrucfuncionestruc.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFuncionEstrucDescripcionDetallado(FuncionEstruc funcionestruc) {
		String sDescripcion="";
			
		sDescripcion+=FuncionEstrucConstantesFunciones.ID+"=";
		sDescripcion+=funcionestruc.getId().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=funcionestruc.getVersionRow().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=funcionestruc.getid_empresa().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=funcionestruc.getid_sucursal().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=funcionestruc.getid_estructura().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.IDFUNCION+"=";
		sDescripcion+=funcionestruc.getid_funcion().toString()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.NOMBRE+"=";
		sDescripcion+=funcionestruc.getnombre()+",";
		sDescripcion+=FuncionEstrucConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=funcionestruc.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setFuncionEstrucDescripcion(FuncionEstruc funcionestruc,String sValor) throws Exception {			
		if(funcionestruc !=null) {
			funcionestruc.setnombre(sValor);;//funcionestrucfuncionestruc.getnombre().trim();
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getFuncionDescripcion(Funcion funcion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(funcion!=null/*&&funcion.getId()>0*/) {
			sDescripcion=FuncionConstantesFunciones.getFuncionDescripcion(funcion);
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
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdFuncion")) {
			sNombreIndice="Tipo=  Por Funcion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFuncion(Long id_funcion) {
		String sDetalleIndice=" Parametros->";
		if(id_funcion!=null) {sDetalleIndice+=" Codigo Unico De Funcion="+id_funcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFuncionEstruc(FuncionEstruc funcionestruc,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		funcionestruc.setnombre(funcionestruc.getnombre().trim());
		funcionestruc.setdescripcion(funcionestruc.getdescripcion().trim());
	}
	
	public static void quitarEspaciosFuncionEstrucs(List<FuncionEstruc> funcionestrucs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FuncionEstruc funcionestruc: funcionestrucs) {
			funcionestruc.setnombre(funcionestruc.getnombre().trim());
			funcionestruc.setdescripcion(funcionestruc.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFuncionEstruc(FuncionEstruc funcionestruc,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && funcionestruc.getConCambioAuxiliar()) {
			funcionestruc.setIsDeleted(funcionestruc.getIsDeletedAuxiliar());	
			funcionestruc.setIsNew(funcionestruc.getIsNewAuxiliar());	
			funcionestruc.setIsChanged(funcionestruc.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			funcionestruc.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			funcionestruc.setIsDeletedAuxiliar(false);	
			funcionestruc.setIsNewAuxiliar(false);	
			funcionestruc.setIsChangedAuxiliar(false);
			
			funcionestruc.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFuncionEstrucs(List<FuncionEstruc> funcionestrucs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FuncionEstruc funcionestruc : funcionestrucs) {
			if(conAsignarBase && funcionestruc.getConCambioAuxiliar()) {
				funcionestruc.setIsDeleted(funcionestruc.getIsDeletedAuxiliar());	
				funcionestruc.setIsNew(funcionestruc.getIsNewAuxiliar());	
				funcionestruc.setIsChanged(funcionestruc.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				funcionestruc.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				funcionestruc.setIsDeletedAuxiliar(false);	
				funcionestruc.setIsNewAuxiliar(false);	
				funcionestruc.setIsChangedAuxiliar(false);
				
				funcionestruc.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFuncionEstruc(FuncionEstruc funcionestruc,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFuncionEstrucs(List<FuncionEstruc> funcionestrucs,Boolean conEnteros) throws Exception  {
		
		for(FuncionEstruc funcionestruc: funcionestrucs) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFuncionEstruc(List<FuncionEstruc> funcionestrucs,FuncionEstruc funcionestrucAux) throws Exception  {
		FuncionEstrucConstantesFunciones.InicializarValoresFuncionEstruc(funcionestrucAux,true);
		
		for(FuncionEstruc funcionestruc: funcionestrucs) {
			if(funcionestruc.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFuncionEstruc(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FuncionEstrucConstantesFunciones.getArrayColumnasGlobalesFuncionEstruc(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFuncionEstruc(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FuncionEstrucConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FuncionEstrucConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FuncionEstrucConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FuncionEstrucConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFuncionEstruc(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FuncionEstruc> funcionestrucs,FuncionEstruc funcionestruc,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FuncionEstruc funcionestrucAux: funcionestrucs) {
			if(funcionestrucAux!=null && funcionestruc!=null) {
				if((funcionestrucAux.getId()==null && funcionestruc.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(funcionestrucAux.getId()!=null && funcionestruc.getId()!=null){
					if(funcionestrucAux.getId().equals(funcionestruc.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFuncionEstruc(List<FuncionEstruc> funcionestrucs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FuncionEstruc funcionestruc: funcionestrucs) {			
			if(funcionestruc.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFuncionEstruc() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_ID, FuncionEstrucConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_VERSIONROW, FuncionEstrucConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_IDEMPRESA, FuncionEstrucConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_IDSUCURSAL, FuncionEstrucConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_IDESTRUCTURA, FuncionEstrucConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_IDFUNCION, FuncionEstrucConstantesFunciones.IDFUNCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_NOMBRE, FuncionEstrucConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionEstrucConstantesFunciones.LABEL_DESCRIPCION, FuncionEstrucConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFuncionEstruc() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.IDFUNCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionEstrucConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncionEstruc() throws Exception  {
		return FuncionEstrucConstantesFunciones.getTiposSeleccionarFuncionEstruc(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncionEstruc(Boolean conFk) throws Exception  {
		return FuncionEstrucConstantesFunciones.getTiposSeleccionarFuncionEstruc(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncionEstruc(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_IDFUNCION);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_IDFUNCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionEstrucConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FuncionEstrucConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFuncionEstruc(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFuncionEstruc(FuncionEstruc funcionestrucAux) throws Exception {
		
			funcionestrucAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(funcionestrucAux.getEmpresa()));
			funcionestrucAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(funcionestrucAux.getSucursal()));
			funcionestrucAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(funcionestrucAux.getEstructura()));
			funcionestrucAux.setfuncion_descripcion(FuncionConstantesFunciones.getFuncionDescripcion(funcionestrucAux.getFuncion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFuncionEstruc(List<FuncionEstruc> funcionestrucsTemp) throws Exception {
		for(FuncionEstruc funcionestrucAux:funcionestrucsTemp) {
			
			funcionestrucAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(funcionestrucAux.getEmpresa()));
			funcionestrucAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(funcionestrucAux.getSucursal()));
			funcionestrucAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(funcionestrucAux.getEstructura()));
			funcionestrucAux.setfuncion_descripcion(FuncionConstantesFunciones.getFuncionDescripcion(funcionestrucAux.getFuncion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFuncionEstruc(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Funcion.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Funcion.class)) {
						classes.add(new Classe(Funcion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFuncionEstruc(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Funcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Funcion.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Funcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Funcion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFuncionEstruc(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FuncionEstrucConstantesFunciones.getClassesRelationshipsOfFuncionEstruc(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFuncionEstruc(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFuncionEstruc(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FuncionEstrucConstantesFunciones.getClassesRelationshipsFromStringsOfFuncionEstruc(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFuncionEstruc(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FuncionEstruc funcionestruc,List<FuncionEstruc> funcionestrucs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FuncionEstruc funcionestrucEncontrado=null;
			
			for(FuncionEstruc funcionestrucLocal:funcionestrucs) {
				if(funcionestrucLocal.getId().equals(funcionestruc.getId())) {
					funcionestrucEncontrado=funcionestrucLocal;
					
					funcionestrucLocal.setIsChanged(funcionestruc.getIsChanged());
					funcionestrucLocal.setIsNew(funcionestruc.getIsNew());
					funcionestrucLocal.setIsDeleted(funcionestruc.getIsDeleted());
					
					funcionestrucLocal.setGeneralEntityOriginal(funcionestruc.getGeneralEntityOriginal());
					
					funcionestrucLocal.setId(funcionestruc.getId());	
					funcionestrucLocal.setVersionRow(funcionestruc.getVersionRow());	
					funcionestrucLocal.setid_empresa(funcionestruc.getid_empresa());	
					funcionestrucLocal.setid_sucursal(funcionestruc.getid_sucursal());	
					funcionestrucLocal.setid_estructura(funcionestruc.getid_estructura());	
					funcionestrucLocal.setid_funcion(funcionestruc.getid_funcion());	
					funcionestrucLocal.setnombre(funcionestruc.getnombre());	
					funcionestrucLocal.setdescripcion(funcionestruc.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!funcionestruc.getIsDeleted()) {
				if(!existe) {
					funcionestrucs.add(funcionestruc);
				}
			} else {
				if(funcionestrucEncontrado!=null && permiteQuitar)  {
					funcionestrucs.remove(funcionestrucEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FuncionEstruc funcionestruc,List<FuncionEstruc> funcionestrucs) throws Exception {
		try	{			
			for(FuncionEstruc funcionestrucLocal:funcionestrucs) {
				if(funcionestrucLocal.getId().equals(funcionestruc.getId())) {
					funcionestrucLocal.setIsSelected(funcionestruc.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFuncionEstruc(List<FuncionEstruc> funcionestrucsAux) throws Exception {
		//this.funcionestrucsAux=funcionestrucsAux;
		
		for(FuncionEstruc funcionestrucAux:funcionestrucsAux) {
			if(funcionestrucAux.getIsChanged()) {
				funcionestrucAux.setIsChanged(false);
			}		
			
			if(funcionestrucAux.getIsNew()) {
				funcionestrucAux.setIsNew(false);
			}	
			
			if(funcionestrucAux.getIsDeleted()) {
				funcionestrucAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFuncionEstruc(FuncionEstruc funcionestrucAux) throws Exception {
		//this.funcionestrucAux=funcionestrucAux;
		
			if(funcionestrucAux.getIsChanged()) {
				funcionestrucAux.setIsChanged(false);
			}		
			
			if(funcionestrucAux.getIsNew()) {
				funcionestrucAux.setIsNew(false);
			}	
			
			if(funcionestrucAux.getIsDeleted()) {
				funcionestrucAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FuncionEstruc funcionestrucAsignar,FuncionEstruc funcionestruc) throws Exception {
		funcionestrucAsignar.setId(funcionestruc.getId());	
		funcionestrucAsignar.setVersionRow(funcionestruc.getVersionRow());	
		funcionestrucAsignar.setid_empresa(funcionestruc.getid_empresa());
		funcionestrucAsignar.setempresa_descripcion(funcionestruc.getempresa_descripcion());	
		funcionestrucAsignar.setid_sucursal(funcionestruc.getid_sucursal());
		funcionestrucAsignar.setsucursal_descripcion(funcionestruc.getsucursal_descripcion());	
		funcionestrucAsignar.setid_estructura(funcionestruc.getid_estructura());
		funcionestrucAsignar.setestructura_descripcion(funcionestruc.getestructura_descripcion());	
		funcionestrucAsignar.setid_funcion(funcionestruc.getid_funcion());
		funcionestrucAsignar.setfuncion_descripcion(funcionestruc.getfuncion_descripcion());	
		funcionestrucAsignar.setnombre(funcionestruc.getnombre());	
		funcionestrucAsignar.setdescripcion(funcionestruc.getdescripcion());	
	}
	
	public static void inicializarFuncionEstruc(FuncionEstruc funcionestruc) throws Exception {
		try {
				funcionestruc.setId(0L);	
					
				funcionestruc.setid_empresa(-1L);	
				funcionestruc.setid_sucursal(-1L);	
				funcionestruc.setid_estructura(-1L);	
				funcionestruc.setid_funcion(-1L);	
				funcionestruc.setnombre("");	
				funcionestruc.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFuncionEstruc(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_IDFUNCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionEstrucConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFuncionEstruc(String sTipo,Row row,Workbook workbook,FuncionEstruc funcionestruc,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getfuncion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcionestruc.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFuncionEstruc=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFuncionEstruc() {
		return this.sFinalQueryFuncionEstruc;
	}
	
	public void setsFinalQueryFuncionEstruc(String sFinalQueryFuncionEstruc) {
		this.sFinalQueryFuncionEstruc= sFinalQueryFuncionEstruc;
	}
	
	public Border resaltarSeleccionarFuncionEstruc=null;
	
	public Border setResaltarSeleccionarFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFuncionEstruc= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFuncionEstruc() {
		return this.resaltarSeleccionarFuncionEstruc;
	}
	
	public void setResaltarSeleccionarFuncionEstruc(Border borderResaltarSeleccionarFuncionEstruc) {
		this.resaltarSeleccionarFuncionEstruc= borderResaltarSeleccionarFuncionEstruc;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFuncionEstruc=null;
	public Boolean mostraridFuncionEstruc=true;
	public Boolean activaridFuncionEstruc=true;

	public Border resaltarid_empresaFuncionEstruc=null;
	public Boolean mostrarid_empresaFuncionEstruc=true;
	public Boolean activarid_empresaFuncionEstruc=true;
	public Boolean cargarid_empresaFuncionEstruc=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFuncionEstruc=false;//ConEventDepend=true

	public Border resaltarid_sucursalFuncionEstruc=null;
	public Boolean mostrarid_sucursalFuncionEstruc=true;
	public Boolean activarid_sucursalFuncionEstruc=true;
	public Boolean cargarid_sucursalFuncionEstruc=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFuncionEstruc=false;//ConEventDepend=true

	public Border resaltarid_estructuraFuncionEstruc=null;
	public Boolean mostrarid_estructuraFuncionEstruc=true;
	public Boolean activarid_estructuraFuncionEstruc=true;
	public Boolean cargarid_estructuraFuncionEstruc=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraFuncionEstruc=false;//ConEventDepend=true

	public Border resaltarid_funcionFuncionEstruc=null;
	public Boolean mostrarid_funcionFuncionEstruc=true;
	public Boolean activarid_funcionFuncionEstruc=true;
	public Boolean cargarid_funcionFuncionEstruc=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_funcionFuncionEstruc=false;//ConEventDepend=true

	public Border resaltarnombreFuncionEstruc=null;
	public Boolean mostrarnombreFuncionEstruc=true;
	public Boolean activarnombreFuncionEstruc=true;

	public Border resaltardescripcionFuncionEstruc=null;
	public Boolean mostrardescripcionFuncionEstruc=true;
	public Boolean activardescripcionFuncionEstruc=true;

	
	

	public Border setResaltaridFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltaridFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFuncionEstruc() {
		return this.resaltaridFuncionEstruc;
	}

	public void setResaltaridFuncionEstruc(Border borderResaltar) {
		this.resaltaridFuncionEstruc= borderResaltar;
	}

	public Boolean getMostraridFuncionEstruc() {
		return this.mostraridFuncionEstruc;
	}

	public void setMostraridFuncionEstruc(Boolean mostraridFuncionEstruc) {
		this.mostraridFuncionEstruc= mostraridFuncionEstruc;
	}

	public Boolean getActivaridFuncionEstruc() {
		return this.activaridFuncionEstruc;
	}

	public void setActivaridFuncionEstruc(Boolean activaridFuncionEstruc) {
		this.activaridFuncionEstruc= activaridFuncionEstruc;
	}

	public Border setResaltarid_empresaFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarid_empresaFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFuncionEstruc() {
		return this.resaltarid_empresaFuncionEstruc;
	}

	public void setResaltarid_empresaFuncionEstruc(Border borderResaltar) {
		this.resaltarid_empresaFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrarid_empresaFuncionEstruc() {
		return this.mostrarid_empresaFuncionEstruc;
	}

	public void setMostrarid_empresaFuncionEstruc(Boolean mostrarid_empresaFuncionEstruc) {
		this.mostrarid_empresaFuncionEstruc= mostrarid_empresaFuncionEstruc;
	}

	public Boolean getActivarid_empresaFuncionEstruc() {
		return this.activarid_empresaFuncionEstruc;
	}

	public void setActivarid_empresaFuncionEstruc(Boolean activarid_empresaFuncionEstruc) {
		this.activarid_empresaFuncionEstruc= activarid_empresaFuncionEstruc;
	}

	public Boolean getCargarid_empresaFuncionEstruc() {
		return this.cargarid_empresaFuncionEstruc;
	}

	public void setCargarid_empresaFuncionEstruc(Boolean cargarid_empresaFuncionEstruc) {
		this.cargarid_empresaFuncionEstruc= cargarid_empresaFuncionEstruc;
	}

	public Border setResaltarid_sucursalFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFuncionEstruc() {
		return this.resaltarid_sucursalFuncionEstruc;
	}

	public void setResaltarid_sucursalFuncionEstruc(Border borderResaltar) {
		this.resaltarid_sucursalFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFuncionEstruc() {
		return this.mostrarid_sucursalFuncionEstruc;
	}

	public void setMostrarid_sucursalFuncionEstruc(Boolean mostrarid_sucursalFuncionEstruc) {
		this.mostrarid_sucursalFuncionEstruc= mostrarid_sucursalFuncionEstruc;
	}

	public Boolean getActivarid_sucursalFuncionEstruc() {
		return this.activarid_sucursalFuncionEstruc;
	}

	public void setActivarid_sucursalFuncionEstruc(Boolean activarid_sucursalFuncionEstruc) {
		this.activarid_sucursalFuncionEstruc= activarid_sucursalFuncionEstruc;
	}

	public Boolean getCargarid_sucursalFuncionEstruc() {
		return this.cargarid_sucursalFuncionEstruc;
	}

	public void setCargarid_sucursalFuncionEstruc(Boolean cargarid_sucursalFuncionEstruc) {
		this.cargarid_sucursalFuncionEstruc= cargarid_sucursalFuncionEstruc;
	}

	public Border setResaltarid_estructuraFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarid_estructuraFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraFuncionEstruc() {
		return this.resaltarid_estructuraFuncionEstruc;
	}

	public void setResaltarid_estructuraFuncionEstruc(Border borderResaltar) {
		this.resaltarid_estructuraFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrarid_estructuraFuncionEstruc() {
		return this.mostrarid_estructuraFuncionEstruc;
	}

	public void setMostrarid_estructuraFuncionEstruc(Boolean mostrarid_estructuraFuncionEstruc) {
		this.mostrarid_estructuraFuncionEstruc= mostrarid_estructuraFuncionEstruc;
	}

	public Boolean getActivarid_estructuraFuncionEstruc() {
		return this.activarid_estructuraFuncionEstruc;
	}

	public void setActivarid_estructuraFuncionEstruc(Boolean activarid_estructuraFuncionEstruc) {
		this.activarid_estructuraFuncionEstruc= activarid_estructuraFuncionEstruc;
	}

	public Boolean getCargarid_estructuraFuncionEstruc() {
		return this.cargarid_estructuraFuncionEstruc;
	}

	public void setCargarid_estructuraFuncionEstruc(Boolean cargarid_estructuraFuncionEstruc) {
		this.cargarid_estructuraFuncionEstruc= cargarid_estructuraFuncionEstruc;
	}

	public Border setResaltarid_funcionFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarid_funcionFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_funcionFuncionEstruc() {
		return this.resaltarid_funcionFuncionEstruc;
	}

	public void setResaltarid_funcionFuncionEstruc(Border borderResaltar) {
		this.resaltarid_funcionFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrarid_funcionFuncionEstruc() {
		return this.mostrarid_funcionFuncionEstruc;
	}

	public void setMostrarid_funcionFuncionEstruc(Boolean mostrarid_funcionFuncionEstruc) {
		this.mostrarid_funcionFuncionEstruc= mostrarid_funcionFuncionEstruc;
	}

	public Boolean getActivarid_funcionFuncionEstruc() {
		return this.activarid_funcionFuncionEstruc;
	}

	public void setActivarid_funcionFuncionEstruc(Boolean activarid_funcionFuncionEstruc) {
		this.activarid_funcionFuncionEstruc= activarid_funcionFuncionEstruc;
	}

	public Boolean getCargarid_funcionFuncionEstruc() {
		return this.cargarid_funcionFuncionEstruc;
	}

	public void setCargarid_funcionFuncionEstruc(Boolean cargarid_funcionFuncionEstruc) {
		this.cargarid_funcionFuncionEstruc= cargarid_funcionFuncionEstruc;
	}

	public Border setResaltarnombreFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltarnombreFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFuncionEstruc() {
		return this.resaltarnombreFuncionEstruc;
	}

	public void setResaltarnombreFuncionEstruc(Border borderResaltar) {
		this.resaltarnombreFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrarnombreFuncionEstruc() {
		return this.mostrarnombreFuncionEstruc;
	}

	public void setMostrarnombreFuncionEstruc(Boolean mostrarnombreFuncionEstruc) {
		this.mostrarnombreFuncionEstruc= mostrarnombreFuncionEstruc;
	}

	public Boolean getActivarnombreFuncionEstruc() {
		return this.activarnombreFuncionEstruc;
	}

	public void setActivarnombreFuncionEstruc(Boolean activarnombreFuncionEstruc) {
		this.activarnombreFuncionEstruc= activarnombreFuncionEstruc;
	}

	public Border setResaltardescripcionFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionestrucBeanSwingJInternalFrame.jTtoolBarFuncionEstruc.setBorder(borderResaltar);
		
		this.resaltardescripcionFuncionEstruc= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFuncionEstruc() {
		return this.resaltardescripcionFuncionEstruc;
	}

	public void setResaltardescripcionFuncionEstruc(Border borderResaltar) {
		this.resaltardescripcionFuncionEstruc= borderResaltar;
	}

	public Boolean getMostrardescripcionFuncionEstruc() {
		return this.mostrardescripcionFuncionEstruc;
	}

	public void setMostrardescripcionFuncionEstruc(Boolean mostrardescripcionFuncionEstruc) {
		this.mostrardescripcionFuncionEstruc= mostrardescripcionFuncionEstruc;
	}

	public Boolean getActivardescripcionFuncionEstruc() {
		return this.activardescripcionFuncionEstruc;
	}

	public void setActivardescripcionFuncionEstruc(Boolean activardescripcionFuncionEstruc) {
		this.activardescripcionFuncionEstruc= activardescripcionFuncionEstruc;
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
		
		
		this.setMostraridFuncionEstruc(esInicial);
		this.setMostrarid_empresaFuncionEstruc(esInicial);
		this.setMostrarid_sucursalFuncionEstruc(esInicial);
		this.setMostrarid_estructuraFuncionEstruc(esInicial);
		this.setMostrarid_funcionFuncionEstruc(esInicial);
		this.setMostrarnombreFuncionEstruc(esInicial);
		this.setMostrardescripcionFuncionEstruc(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.ID)) {
				this.setMostraridFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDFUNCION)) {
				this.setMostrarid_funcionFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFuncionEstruc(esAsigna);
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
		
		
		this.setActivaridFuncionEstruc(esInicial);
		this.setActivarid_empresaFuncionEstruc(esInicial);
		this.setActivarid_sucursalFuncionEstruc(esInicial);
		this.setActivarid_estructuraFuncionEstruc(esInicial);
		this.setActivarid_funcionFuncionEstruc(esInicial);
		this.setActivarnombreFuncionEstruc(esInicial);
		this.setActivardescripcionFuncionEstruc(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.ID)) {
				this.setActivaridFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDFUNCION)) {
				this.setActivarid_funcionFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFuncionEstruc(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFuncionEstruc(esInicial);
		this.setResaltarid_empresaFuncionEstruc(esInicial);
		this.setResaltarid_sucursalFuncionEstruc(esInicial);
		this.setResaltarid_estructuraFuncionEstruc(esInicial);
		this.setResaltarid_funcionFuncionEstruc(esInicial);
		this.setResaltarnombreFuncionEstruc(esInicial);
		this.setResaltardescripcionFuncionEstruc(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.ID)) {
				this.setResaltaridFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.IDFUNCION)) {
				this.setResaltarid_funcionFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFuncionEstruc(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionEstrucConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFuncionEstruc(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaFuncionEstruc=true;

	public Boolean getMostrarFK_IdEmpresaFuncionEstruc() {
		return this.mostrarFK_IdEmpresaFuncionEstruc;
	}

	public void setMostrarFK_IdEmpresaFuncionEstruc(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFuncionEstruc= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraFuncionEstruc=true;

	public Boolean getMostrarFK_IdEstructuraFuncionEstruc() {
		return this.mostrarFK_IdEstructuraFuncionEstruc;
	}

	public void setMostrarFK_IdEstructuraFuncionEstruc(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraFuncionEstruc= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFuncionFuncionEstruc=true;

	public Boolean getMostrarFK_IdFuncionFuncionEstruc() {
		return this.mostrarFK_IdFuncionFuncionEstruc;
	}

	public void setMostrarFK_IdFuncionFuncionEstruc(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFuncionFuncionEstruc= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFuncionEstruc=true;

	public Boolean getMostrarFK_IdSucursalFuncionEstruc() {
		return this.mostrarFK_IdSucursalFuncionEstruc;
	}

	public void setMostrarFK_IdSucursalFuncionEstruc(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFuncionEstruc= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFuncionEstruc=true;

	public Boolean getActivarFK_IdEmpresaFuncionEstruc() {
		return this.activarFK_IdEmpresaFuncionEstruc;
	}

	public void setActivarFK_IdEmpresaFuncionEstruc(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFuncionEstruc= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraFuncionEstruc=true;

	public Boolean getActivarFK_IdEstructuraFuncionEstruc() {
		return this.activarFK_IdEstructuraFuncionEstruc;
	}

	public void setActivarFK_IdEstructuraFuncionEstruc(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraFuncionEstruc= habilitarResaltar;
	}

	public Boolean activarFK_IdFuncionFuncionEstruc=true;

	public Boolean getActivarFK_IdFuncionFuncionEstruc() {
		return this.activarFK_IdFuncionFuncionEstruc;
	}

	public void setActivarFK_IdFuncionFuncionEstruc(Boolean habilitarResaltar) {
		this.activarFK_IdFuncionFuncionEstruc= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFuncionEstruc=true;

	public Boolean getActivarFK_IdSucursalFuncionEstruc() {
		return this.activarFK_IdSucursalFuncionEstruc;
	}

	public void setActivarFK_IdSucursalFuncionEstruc(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFuncionEstruc= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFuncionEstruc=null;

	public Border getResaltarFK_IdEmpresaFuncionEstruc() {
		return this.resaltarFK_IdEmpresaFuncionEstruc;
	}

	public void setResaltarFK_IdEmpresaFuncionEstruc(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFuncionEstruc= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFuncionEstruc= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraFuncionEstruc=null;

	public Border getResaltarFK_IdEstructuraFuncionEstruc() {
		return this.resaltarFK_IdEstructuraFuncionEstruc;
	}

	public void setResaltarFK_IdEstructuraFuncionEstruc(Border borderResaltar) {
		this.resaltarFK_IdEstructuraFuncionEstruc= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraFuncionEstruc= borderResaltar;
	}

	public Border resaltarFK_IdFuncionFuncionEstruc=null;

	public Border getResaltarFK_IdFuncionFuncionEstruc() {
		return this.resaltarFK_IdFuncionFuncionEstruc;
	}

	public void setResaltarFK_IdFuncionFuncionEstruc(Border borderResaltar) {
		this.resaltarFK_IdFuncionFuncionEstruc= borderResaltar;
	}

	public void setResaltarFK_IdFuncionFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFuncionFuncionEstruc= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFuncionEstruc=null;

	public Border getResaltarFK_IdSucursalFuncionEstruc() {
		return this.resaltarFK_IdSucursalFuncionEstruc;
	}

	public void setResaltarFK_IdSucursalFuncionEstruc(Border borderResaltar) {
		this.resaltarFK_IdSucursalFuncionEstruc= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFuncionEstruc(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionEstrucBeanSwingJInternalFrame funcionestrucBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFuncionEstruc= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}