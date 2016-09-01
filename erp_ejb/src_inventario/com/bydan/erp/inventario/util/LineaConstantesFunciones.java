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


import com.bydan.erp.inventario.util.LineaConstantesFunciones;
import com.bydan.erp.inventario.util.LineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.LineaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LineaConstantesFunciones extends LineaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Linea";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Linea"+LineaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LineaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LineaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LineaConstantesFunciones.SCHEMA+"_"+LineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LineaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LineaConstantesFunciones.SCHEMA+"_"+LineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LineaConstantesFunciones.SCHEMA+"_"+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LineaConstantesFunciones.SCHEMA+"_"+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LineaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LineaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LineaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LineaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Lineas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Linea";
	public static final String SCLASSWEBTITULO_LOWER="Linea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Linea";
	public static final String OBJECTNAME="linea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="linea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select linea from "+LineaConstantesFunciones.SPERSISTENCENAME+" linea";
	public static String QUERYSELECTNATIVE="select "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".version_row,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_empresa,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_nivel_linea,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_linea,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".codigo,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".nombre,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".descripcion from "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME;//+" as "+LineaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LineaConstantesFuncionesAdditional lineaConstantesFuncionesAdditional=null;
	
	public LineaConstantesFuncionesAdditional getLineaConstantesFuncionesAdditional() {
		return this.lineaConstantesFuncionesAdditional;
	}
	
	public void setLineaConstantesFuncionesAdditional(LineaConstantesFuncionesAdditional lineaConstantesFuncionesAdditional) {
		try {
			this.lineaConstantesFuncionesAdditional=lineaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDNIVELLINEA= "id_nivel_linea";
    public static final String IDLINEA= "id_linea";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDNIVELLINEA= "Nivel Linea";
		public static final String LABEL_IDNIVELLINEA_LOWER= "Nivel Linea";
    	public static final String LABEL_IDLINEA= "Linea Padre";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getLineaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LineaConstantesFunciones.IDEMPRESA)) {sLabelColumna=LineaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LineaConstantesFunciones.IDNIVELLINEA)) {sLabelColumna=LineaConstantesFunciones.LABEL_IDNIVELLINEA;}
		if(sNombreColumna.equals(LineaConstantesFunciones.IDLINEA)) {sLabelColumna=LineaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(LineaConstantesFunciones.CODIGO)) {sLabelColumna=LineaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(LineaConstantesFunciones.NOMBRE)) {sLabelColumna=LineaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(LineaConstantesFunciones.DESCRIPCION)) {sLabelColumna=LineaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(linea !=null/* && linea.getId()!=0*/) {
			sDescripcion=linea.getcodigo()+"-"+linea.getnombre();//linealinea.getcodigo().trim()+"-"+linea.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLineaDescripcionDetallado(Linea linea) {
		String sDescripcion="";
			
		sDescripcion+=LineaConstantesFunciones.ID+"=";
		sDescripcion+=linea.getId().toString()+",";
		sDescripcion+=LineaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=linea.getVersionRow().toString()+",";
		sDescripcion+=LineaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=linea.getid_empresa().toString()+",";
		sDescripcion+=LineaConstantesFunciones.IDNIVELLINEA+"=";
		sDescripcion+=linea.getid_nivel_linea().toString()+",";
		sDescripcion+=LineaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=linea.getid_linea().toString()+",";
		sDescripcion+=LineaConstantesFunciones.CODIGO+"=";
		sDescripcion+=linea.getcodigo()+",";
		sDescripcion+=LineaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=linea.getnombre()+",";
		sDescripcion+=LineaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=linea.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setLineaDescripcion(Linea linea,String sValor) throws Exception {			
		if(linea !=null) {
			linea.setcodigo(sValor);
linea.setnombre(sValor);;//linealinea.getcodigo().trim()+"-"+linea.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getNivelLineaDescripcion(NivelLinea nivellinea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(nivellinea!=null/*&&nivellinea.getId()>0*/) {
			sDescripcion=NivelLineaConstantesFunciones.getNivelLineaDescripcion(nivellinea);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea Padre";
		} else if(sNombreIndice.equals("FK_IdNivelLinea")) {
			sNombreIndice="Tipo=  Por Nivel Linea";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea Padre="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNivelLinea(Long id_nivel_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_nivel_linea!=null) {sDetalleIndice+=" Codigo Unico De Nivel Linea="+id_nivel_linea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLinea(Linea linea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		linea.setcodigo(linea.getcodigo().trim());
		linea.setnombre(linea.getnombre().trim());
		linea.setdescripcion(linea.getdescripcion().trim());
	}
	
	public static void quitarEspaciosLineas(List<Linea> lineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Linea linea: lineas) {
			linea.setcodigo(linea.getcodigo().trim());
			linea.setnombre(linea.getnombre().trim());
			linea.setdescripcion(linea.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLinea(Linea linea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && linea.getConCambioAuxiliar()) {
			linea.setIsDeleted(linea.getIsDeletedAuxiliar());	
			linea.setIsNew(linea.getIsNewAuxiliar());	
			linea.setIsChanged(linea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			linea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			linea.setIsDeletedAuxiliar(false);	
			linea.setIsNewAuxiliar(false);	
			linea.setIsChangedAuxiliar(false);
			
			linea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineas(List<Linea> lineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Linea linea : lineas) {
			if(conAsignarBase && linea.getConCambioAuxiliar()) {
				linea.setIsDeleted(linea.getIsDeletedAuxiliar());	
				linea.setIsNew(linea.getIsNewAuxiliar());	
				linea.setIsChanged(linea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				linea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				linea.setIsDeletedAuxiliar(false);	
				linea.setIsNewAuxiliar(false);	
				linea.setIsChangedAuxiliar(false);
				
				linea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLinea(Linea linea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLineas(List<Linea> lineas,Boolean conEnteros) throws Exception  {
		
		for(Linea linea: lineas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLinea(List<Linea> lineas,Linea lineaAux) throws Exception  {
		LineaConstantesFunciones.InicializarValoresLinea(lineaAux,true);
		
		for(Linea linea: lineas) {
			if(linea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LineaConstantesFunciones.getArrayColumnasGlobalesLinea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLinea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LineaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LineaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Linea> lineas,Linea linea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Linea lineaAux: lineas) {
			if(lineaAux!=null && linea!=null) {
				if((lineaAux.getId()==null && linea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(lineaAux.getId()!=null && linea.getId()!=null){
					if(lineaAux.getId().equals(linea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLinea(List<Linea> lineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Linea linea: lineas) {			
			if(linea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLinea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_ID, LineaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_VERSIONROW, LineaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_IDEMPRESA, LineaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_IDNIVELLINEA, LineaConstantesFunciones.IDNIVELLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_IDLINEA, LineaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_CODIGO, LineaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_NOMBRE, LineaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaConstantesFunciones.LABEL_DESCRIPCION, LineaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLinea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.IDNIVELLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLinea() throws Exception  {
		return LineaConstantesFunciones.getTiposSeleccionarLinea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLinea(Boolean conFk) throws Exception  {
		return LineaConstantesFunciones.getTiposSeleccionarLinea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLinea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_IDNIVELLINEA);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_IDNIVELLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(LineaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLinea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLinea(Linea lineaAux) throws Exception {
		
			lineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineaAux.getEmpresa()));
			lineaAux.setnivellinea_descripcion(NivelLineaConstantesFunciones.getNivelLineaDescripcion(lineaAux.getNivelLinea()));
			lineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineaAux.getLinea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLinea(List<Linea> lineasTemp) throws Exception {
		for(Linea lineaAux:lineasTemp) {
			
			lineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineaAux.getEmpresa()));
			lineaAux.setnivellinea_descripcion(NivelLineaConstantesFunciones.getNivelLineaDescripcion(lineaAux.getNivelLinea()));
			lineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(lineaAux.getLinea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(NivelLinea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NivelLinea.class)) {
						classes.add(new Classe(NivelLinea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(NivelLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelLinea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(NivelLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelLinea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaConstantesFunciones.getClassesRelationshipsOfLinea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresupuestoLinea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(ComisionGrupo.class));
				classes.add(new Classe(ProductoPuntoVenta.class));
				classes.add(new Classe(ComisionLinea.class));
				classes.add(new Classe(ComisionCate.class));
				classes.add(new Classe(DetallePlaneacionCompra.class));
				classes.add(new Classe(CuentasContablesLineaProducto.class));
				classes.add(new Classe(Precio.class));
				classes.add(new Classe(LineaPuntoVenta.class));
				classes.add(new Classe(DetalleCodigoBarraProducto.class));
				classes.add(new Classe(PresupuestoVentasLineas.class));
				classes.add(new Classe(CentroCostoGrupoProducto.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ComisionMarca.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoLinea.class)) {
						classes.add(new Classe(PresupuestoLinea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionGrupo.class)) {
						classes.add(new Classe(ComisionGrupo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoPuntoVenta.class)) {
						classes.add(new Classe(ProductoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionLinea.class)) {
						classes.add(new Classe(ComisionLinea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionCate.class)) {
						classes.add(new Classe(ComisionCate.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePlaneacionCompra.class)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentasContablesLineaProducto.class)) {
						classes.add(new Classe(CuentasContablesLineaProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Precio.class)) {
						classes.add(new Classe(Precio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LineaPuntoVenta.class)) {
						classes.add(new Classe(LineaPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCodigoBarraProducto.class)) {
						classes.add(new Classe(DetalleCodigoBarraProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentasLineas.class)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCostoGrupoProducto.class)) {
						classes.add(new Classe(CentroCostoGrupoProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionMarca.class)) {
						classes.add(new Classe(ComisionMarca.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaConstantesFunciones.getClassesRelationshipsFromStringsOfLinea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresupuestoLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoLinea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}

					if(ProductoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoPuntoVenta.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(DetallePlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); continue;
					}

					if(CuentasContablesLineaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentasContablesLineaProducto.class)); continue;
					}

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(LineaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaPuntoVenta.class)); continue;
					}

					if(DetalleCodigoBarraProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCodigoBarraProducto.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
					}

					if(CentroCostoGrupoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCostoGrupoProducto.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresupuestoLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoLinea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}

					if(ProductoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoPuntoVenta.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(DetallePlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); continue;
					}

					if(CuentasContablesLineaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentasContablesLineaProducto.class)); continue;
					}

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(LineaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaPuntoVenta.class)); continue;
					}

					if(DetalleCodigoBarraProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCodigoBarraProducto.class)); continue;
					}

					if(PresupuestoVentasLineas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentasLineas.class)); continue;
					}

					if(CentroCostoGrupoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCostoGrupoProducto.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
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
	public static void actualizarLista(Linea linea,List<Linea> lineas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Linea lineaEncontrado=null;
			
			for(Linea lineaLocal:lineas) {
				if(lineaLocal.getId().equals(linea.getId())) {
					lineaEncontrado=lineaLocal;
					
					lineaLocal.setIsChanged(linea.getIsChanged());
					lineaLocal.setIsNew(linea.getIsNew());
					lineaLocal.setIsDeleted(linea.getIsDeleted());
					
					lineaLocal.setGeneralEntityOriginal(linea.getGeneralEntityOriginal());
					
					lineaLocal.setId(linea.getId());	
					lineaLocal.setVersionRow(linea.getVersionRow());	
					lineaLocal.setid_empresa(linea.getid_empresa());	
					lineaLocal.setid_nivel_linea(linea.getid_nivel_linea());	
					lineaLocal.setid_linea(linea.getid_linea());	
					lineaLocal.setcodigo(linea.getcodigo());	
					lineaLocal.setnombre(linea.getnombre());	
					lineaLocal.setdescripcion(linea.getdescripcion());	
					
					
					lineaLocal.setPresupuestoLineas(linea.getPresupuestoLineas());
					lineaLocal.setLineas(linea.getLineas());
					lineaLocal.setComisionGrupoGrupos(linea.getComisionGrupoGrupos());
					lineaLocal.setProductoPuntoVentas(linea.getProductoPuntoVentas());
					lineaLocal.setComisionLineas(linea.getComisionLineas());
					lineaLocal.setComisionCates(linea.getComisionCates());
					lineaLocal.setDetallePlaneacionCompras(linea.getDetallePlaneacionCompras());
					lineaLocal.setCuentasContablesLineaProductoCategorias(linea.getCuentasContablesLineaProductoCategorias());
					lineaLocal.setPrecioGrupos(linea.getPrecioGrupos());
					lineaLocal.setLineaPuntoVentaMarcas(linea.getLineaPuntoVentaMarcas());
					lineaLocal.setDetalleCodigoBarraProductoMarcas(linea.getDetalleCodigoBarraProductoMarcas());
					lineaLocal.setPresupuestoVentasLineasMarcas(linea.getPresupuestoVentasLineasMarcas());
					lineaLocal.setCentroCostoGrupoProductos(linea.getCentroCostoGrupoProductos());
					lineaLocal.setProductos(linea.getProductos());
					lineaLocal.setComisionMarcaGrupos(linea.getComisionMarcaGrupos());
					
					existe=true;
					break;
				}
			}
			
			if(!linea.getIsDeleted()) {
				if(!existe) {
					lineas.add(linea);
				}
			} else {
				if(lineaEncontrado!=null && permiteQuitar)  {
					lineas.remove(lineaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Linea linea,List<Linea> lineas) throws Exception {
		try	{			
			for(Linea lineaLocal:lineas) {
				if(lineaLocal.getId().equals(linea.getId())) {
					lineaLocal.setIsSelected(linea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLinea(List<Linea> lineasAux) throws Exception {
		//this.lineasAux=lineasAux;
		
		for(Linea lineaAux:lineasAux) {
			if(lineaAux.getIsChanged()) {
				lineaAux.setIsChanged(false);
			}		
			
			if(lineaAux.getIsNew()) {
				lineaAux.setIsNew(false);
			}	
			
			if(lineaAux.getIsDeleted()) {
				lineaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLinea(Linea lineaAux) throws Exception {
		//this.lineaAux=lineaAux;
		
			if(lineaAux.getIsChanged()) {
				lineaAux.setIsChanged(false);
			}		
			
			if(lineaAux.getIsNew()) {
				lineaAux.setIsNew(false);
			}	
			
			if(lineaAux.getIsDeleted()) {
				lineaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Linea lineaAsignar,Linea linea) throws Exception {
		lineaAsignar.setId(linea.getId());	
		lineaAsignar.setVersionRow(linea.getVersionRow());	
		lineaAsignar.setid_empresa(linea.getid_empresa());
		lineaAsignar.setempresa_descripcion(linea.getempresa_descripcion());	
		lineaAsignar.setid_nivel_linea(linea.getid_nivel_linea());
		lineaAsignar.setnivellinea_descripcion(linea.getnivellinea_descripcion());	
		lineaAsignar.setid_linea(linea.getid_linea());
		lineaAsignar.setlinea_descripcion(linea.getlinea_descripcion());	
		lineaAsignar.setcodigo(linea.getcodigo());	
		lineaAsignar.setnombre(linea.getnombre());	
		lineaAsignar.setdescripcion(linea.getdescripcion());	
	}
	
	public static void inicializarLinea(Linea linea) throws Exception {
		try {
				linea.setId(0L);	
					
				linea.setid_empresa(-1L);	
				linea.setid_nivel_linea(-1L);	
				linea.setid_linea(null);	
				linea.setcodigo("");	
				linea.setnombre("");	
				linea.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLinea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_IDNIVELLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLinea(String sTipo,Row row,Workbook workbook,Linea linea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getnivellinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(linea.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLinea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLinea() {
		return this.sFinalQueryLinea;
	}
	
	public void setsFinalQueryLinea(String sFinalQueryLinea) {
		this.sFinalQueryLinea= sFinalQueryLinea;
	}
	
	public Border resaltarSeleccionarLinea=null;
	
	public Border setResaltarSeleccionarLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLinea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLinea() {
		return this.resaltarSeleccionarLinea;
	}
	
	public void setResaltarSeleccionarLinea(Border borderResaltarSeleccionarLinea) {
		this.resaltarSeleccionarLinea= borderResaltarSeleccionarLinea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLinea=null;
	public Boolean mostraridLinea=true;
	public Boolean activaridLinea=true;

	public Border resaltarid_empresaLinea=null;
	public Boolean mostrarid_empresaLinea=true;
	public Boolean activarid_empresaLinea=true;
	public Boolean cargarid_empresaLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLinea=false;//ConEventDepend=true

	public Border resaltarid_nivel_lineaLinea=null;
	public Boolean mostrarid_nivel_lineaLinea=true;
	public Boolean activarid_nivel_lineaLinea=true;
	public Boolean cargarid_nivel_lineaLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nivel_lineaLinea=false;//ConEventDepend=true

	public Border resaltarid_lineaLinea=null;
	public Boolean mostrarid_lineaLinea=true;
	public Boolean activarid_lineaLinea=true;
	public Boolean cargarid_lineaLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaLinea=false;//ConEventDepend=true

	public Border resaltarcodigoLinea=null;
	public Boolean mostrarcodigoLinea=true;
	public Boolean activarcodigoLinea=true;

	public Border resaltarnombreLinea=null;
	public Boolean mostrarnombreLinea=true;
	public Boolean activarnombreLinea=true;

	public Border resaltardescripcionLinea=null;
	public Boolean mostrardescripcionLinea=true;
	public Boolean activardescripcionLinea=true;

	
	

	public Border setResaltaridLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltaridLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLinea() {
		return this.resaltaridLinea;
	}

	public void setResaltaridLinea(Border borderResaltar) {
		this.resaltaridLinea= borderResaltar;
	}

	public Boolean getMostraridLinea() {
		return this.mostraridLinea;
	}

	public void setMostraridLinea(Boolean mostraridLinea) {
		this.mostraridLinea= mostraridLinea;
	}

	public Boolean getActivaridLinea() {
		return this.activaridLinea;
	}

	public void setActivaridLinea(Boolean activaridLinea) {
		this.activaridLinea= activaridLinea;
	}

	public Border setResaltarid_empresaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarid_empresaLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLinea() {
		return this.resaltarid_empresaLinea;
	}

	public void setResaltarid_empresaLinea(Border borderResaltar) {
		this.resaltarid_empresaLinea= borderResaltar;
	}

	public Boolean getMostrarid_empresaLinea() {
		return this.mostrarid_empresaLinea;
	}

	public void setMostrarid_empresaLinea(Boolean mostrarid_empresaLinea) {
		this.mostrarid_empresaLinea= mostrarid_empresaLinea;
	}

	public Boolean getActivarid_empresaLinea() {
		return this.activarid_empresaLinea;
	}

	public void setActivarid_empresaLinea(Boolean activarid_empresaLinea) {
		this.activarid_empresaLinea= activarid_empresaLinea;
	}

	public Boolean getCargarid_empresaLinea() {
		return this.cargarid_empresaLinea;
	}

	public void setCargarid_empresaLinea(Boolean cargarid_empresaLinea) {
		this.cargarid_empresaLinea= cargarid_empresaLinea;
	}

	public Border setResaltarid_nivel_lineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarid_nivel_lineaLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nivel_lineaLinea() {
		return this.resaltarid_nivel_lineaLinea;
	}

	public void setResaltarid_nivel_lineaLinea(Border borderResaltar) {
		this.resaltarid_nivel_lineaLinea= borderResaltar;
	}

	public Boolean getMostrarid_nivel_lineaLinea() {
		return this.mostrarid_nivel_lineaLinea;
	}

	public void setMostrarid_nivel_lineaLinea(Boolean mostrarid_nivel_lineaLinea) {
		this.mostrarid_nivel_lineaLinea= mostrarid_nivel_lineaLinea;
	}

	public Boolean getActivarid_nivel_lineaLinea() {
		return this.activarid_nivel_lineaLinea;
	}

	public void setActivarid_nivel_lineaLinea(Boolean activarid_nivel_lineaLinea) {
		this.activarid_nivel_lineaLinea= activarid_nivel_lineaLinea;
	}

	public Boolean getCargarid_nivel_lineaLinea() {
		return this.cargarid_nivel_lineaLinea;
	}

	public void setCargarid_nivel_lineaLinea(Boolean cargarid_nivel_lineaLinea) {
		this.cargarid_nivel_lineaLinea= cargarid_nivel_lineaLinea;
	}

	public Border setResaltarid_lineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarid_lineaLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaLinea() {
		return this.resaltarid_lineaLinea;
	}

	public void setResaltarid_lineaLinea(Border borderResaltar) {
		this.resaltarid_lineaLinea= borderResaltar;
	}

	public Boolean getMostrarid_lineaLinea() {
		return this.mostrarid_lineaLinea;
	}

	public void setMostrarid_lineaLinea(Boolean mostrarid_lineaLinea) {
		this.mostrarid_lineaLinea= mostrarid_lineaLinea;
	}

	public Boolean getActivarid_lineaLinea() {
		return this.activarid_lineaLinea;
	}

	public void setActivarid_lineaLinea(Boolean activarid_lineaLinea) {
		this.activarid_lineaLinea= activarid_lineaLinea;
	}

	public Boolean getCargarid_lineaLinea() {
		return this.cargarid_lineaLinea;
	}

	public void setCargarid_lineaLinea(Boolean cargarid_lineaLinea) {
		this.cargarid_lineaLinea= cargarid_lineaLinea;
	}

	public Border setResaltarcodigoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarcodigoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoLinea() {
		return this.resaltarcodigoLinea;
	}

	public void setResaltarcodigoLinea(Border borderResaltar) {
		this.resaltarcodigoLinea= borderResaltar;
	}

	public Boolean getMostrarcodigoLinea() {
		return this.mostrarcodigoLinea;
	}

	public void setMostrarcodigoLinea(Boolean mostrarcodigoLinea) {
		this.mostrarcodigoLinea= mostrarcodigoLinea;
	}

	public Boolean getActivarcodigoLinea() {
		return this.activarcodigoLinea;
	}

	public void setActivarcodigoLinea(Boolean activarcodigoLinea) {
		this.activarcodigoLinea= activarcodigoLinea;
	}

	public Border setResaltarnombreLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltarnombreLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLinea() {
		return this.resaltarnombreLinea;
	}

	public void setResaltarnombreLinea(Border borderResaltar) {
		this.resaltarnombreLinea= borderResaltar;
	}

	public Boolean getMostrarnombreLinea() {
		return this.mostrarnombreLinea;
	}

	public void setMostrarnombreLinea(Boolean mostrarnombreLinea) {
		this.mostrarnombreLinea= mostrarnombreLinea;
	}

	public Boolean getActivarnombreLinea() {
		return this.activarnombreLinea;
	}

	public void setActivarnombreLinea(Boolean activarnombreLinea) {
		this.activarnombreLinea= activarnombreLinea;
	}

	public Border setResaltardescripcionLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltar);
		
		this.resaltardescripcionLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionLinea() {
		return this.resaltardescripcionLinea;
	}

	public void setResaltardescripcionLinea(Border borderResaltar) {
		this.resaltardescripcionLinea= borderResaltar;
	}

	public Boolean getMostrardescripcionLinea() {
		return this.mostrardescripcionLinea;
	}

	public void setMostrardescripcionLinea(Boolean mostrardescripcionLinea) {
		this.mostrardescripcionLinea= mostrardescripcionLinea;
	}

	public Boolean getActivardescripcionLinea() {
		return this.activardescripcionLinea;
	}

	public void setActivardescripcionLinea(Boolean activardescripcionLinea) {
		this.activardescripcionLinea= activardescripcionLinea;
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
		
		
		this.setMostraridLinea(esInicial);
		this.setMostrarid_empresaLinea(esInicial);
		this.setMostrarid_nivel_lineaLinea(esInicial);
		this.setMostrarid_lineaLinea(esInicial);
		this.setMostrarcodigoLinea(esInicial);
		this.setMostrarnombreLinea(esInicial);
		this.setMostrardescripcionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaConstantesFunciones.ID)) {
				this.setMostraridLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDNIVELLINEA)) {
				this.setMostrarid_nivel_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionLinea(esAsigna);
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
		
		
		this.setActivaridLinea(esInicial);
		this.setActivarid_empresaLinea(esInicial);
		this.setActivarid_nivel_lineaLinea(esInicial);
		this.setActivarid_lineaLinea(esInicial);
		this.setActivarcodigoLinea(esInicial);
		this.setActivarnombreLinea(esInicial);
		this.setActivardescripcionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaConstantesFunciones.ID)) {
				this.setActivaridLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDNIVELLINEA)) {
				this.setActivarid_nivel_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionLinea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLinea(esInicial);
		this.setResaltarid_empresaLinea(esInicial);
		this.setResaltarid_nivel_lineaLinea(esInicial);
		this.setResaltarid_lineaLinea(esInicial);
		this.setResaltarcodigoLinea(esInicial);
		this.setResaltarnombreLinea(esInicial);
		this.setResaltardescripcionLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaConstantesFunciones.ID)) {
				this.setResaltaridLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDNIVELLINEA)) {
				this.setResaltarid_nivel_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionLinea(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPresupuestoLineaLinea=null;

	public Border getResaltarPresupuestoLineaLinea() {
		return this.resaltarPresupuestoLineaLinea;
	}

	public void setResaltarPresupuestoLineaLinea(Border borderResaltarPresupuestoLinea) {
		if(borderResaltarPresupuestoLinea!=null) {
			this.resaltarPresupuestoLineaLinea= borderResaltarPresupuestoLinea;
		}
	}

	public Border setResaltarPresupuestoLineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarPresupuestoLinea);
			
		this.resaltarPresupuestoLineaLinea= borderResaltarPresupuestoLinea;

		 return borderResaltarPresupuestoLinea;
	}



	public Boolean mostrarPresupuestoLineaLinea=true;

	public Boolean getMostrarPresupuestoLineaLinea() {
		return this.mostrarPresupuestoLineaLinea;
	}

	public void setMostrarPresupuestoLineaLinea(Boolean visibilidadResaltarPresupuestoLinea) {
		this.mostrarPresupuestoLineaLinea= visibilidadResaltarPresupuestoLinea;
	}



	public Boolean activarPresupuestoLineaLinea=true;

	public Boolean gethabilitarResaltarPresupuestoLineaLinea() {
		return this.activarPresupuestoLineaLinea;
	}

	public void setActivarPresupuestoLineaLinea(Boolean habilitarResaltarPresupuestoLinea) {
		this.activarPresupuestoLineaLinea= habilitarResaltarPresupuestoLinea;
	}


	public Border resaltarLineaLinea=null;

	public Border getResaltarLineaLinea() {
		return this.resaltarLineaLinea;
	}

	public void setResaltarLineaLinea(Border borderResaltarLinea) {
		if(borderResaltarLinea!=null) {
			this.resaltarLineaLinea= borderResaltarLinea;
		}
	}

	public Border setResaltarLineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarLinea);
			
		this.resaltarLineaLinea= borderResaltarLinea;

		 return borderResaltarLinea;
	}



	public Boolean mostrarLineaLinea=true;

	public Boolean getMostrarLineaLinea() {
		return this.mostrarLineaLinea;
	}

	public void setMostrarLineaLinea(Boolean visibilidadResaltarLinea) {
		this.mostrarLineaLinea= visibilidadResaltarLinea;
	}



	public Boolean activarLineaLinea=true;

	public Boolean gethabilitarResaltarLineaLinea() {
		return this.activarLineaLinea;
	}

	public void setActivarLineaLinea(Boolean habilitarResaltarLinea) {
		this.activarLineaLinea= habilitarResaltarLinea;
	}


	public Border resaltarComisionGrupoLinea=null;

	public Border getResaltarComisionGrupoLinea() {
		return this.resaltarComisionGrupoLinea;
	}

	public void setResaltarComisionGrupoLinea(Border borderResaltarComisionGrupo) {
		if(borderResaltarComisionGrupo!=null) {
			this.resaltarComisionGrupoLinea= borderResaltarComisionGrupo;
		}
	}

	public Border setResaltarComisionGrupoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionGrupo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarComisionGrupo);
			
		this.resaltarComisionGrupoLinea= borderResaltarComisionGrupo;

		 return borderResaltarComisionGrupo;
	}



	public Boolean mostrarComisionGrupoLinea=true;

	public Boolean getMostrarComisionGrupoLinea() {
		return this.mostrarComisionGrupoLinea;
	}

	public void setMostrarComisionGrupoLinea(Boolean visibilidadResaltarComisionGrupo) {
		this.mostrarComisionGrupoLinea= visibilidadResaltarComisionGrupo;
	}



	public Boolean activarComisionGrupoLinea=true;

	public Boolean gethabilitarResaltarComisionGrupoLinea() {
		return this.activarComisionGrupoLinea;
	}

	public void setActivarComisionGrupoLinea(Boolean habilitarResaltarComisionGrupo) {
		this.activarComisionGrupoLinea= habilitarResaltarComisionGrupo;
	}


	public Border resaltarProductoPuntoVentaLinea=null;

	public Border getResaltarProductoPuntoVentaLinea() {
		return this.resaltarProductoPuntoVentaLinea;
	}

	public void setResaltarProductoPuntoVentaLinea(Border borderResaltarProductoPuntoVenta) {
		if(borderResaltarProductoPuntoVenta!=null) {
			this.resaltarProductoPuntoVentaLinea= borderResaltarProductoPuntoVenta;
		}
	}

	public Border setResaltarProductoPuntoVentaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarProductoPuntoVenta);
			
		this.resaltarProductoPuntoVentaLinea= borderResaltarProductoPuntoVenta;

		 return borderResaltarProductoPuntoVenta;
	}



	public Boolean mostrarProductoPuntoVentaLinea=true;

	public Boolean getMostrarProductoPuntoVentaLinea() {
		return this.mostrarProductoPuntoVentaLinea;
	}

	public void setMostrarProductoPuntoVentaLinea(Boolean visibilidadResaltarProductoPuntoVenta) {
		this.mostrarProductoPuntoVentaLinea= visibilidadResaltarProductoPuntoVenta;
	}



	public Boolean activarProductoPuntoVentaLinea=true;

	public Boolean gethabilitarResaltarProductoPuntoVentaLinea() {
		return this.activarProductoPuntoVentaLinea;
	}

	public void setActivarProductoPuntoVentaLinea(Boolean habilitarResaltarProductoPuntoVenta) {
		this.activarProductoPuntoVentaLinea= habilitarResaltarProductoPuntoVenta;
	}


	public Border resaltarComisionLineaLinea=null;

	public Border getResaltarComisionLineaLinea() {
		return this.resaltarComisionLineaLinea;
	}

	public void setResaltarComisionLineaLinea(Border borderResaltarComisionLinea) {
		if(borderResaltarComisionLinea!=null) {
			this.resaltarComisionLineaLinea= borderResaltarComisionLinea;
		}
	}

	public Border setResaltarComisionLineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarComisionLinea);
			
		this.resaltarComisionLineaLinea= borderResaltarComisionLinea;

		 return borderResaltarComisionLinea;
	}



	public Boolean mostrarComisionLineaLinea=true;

	public Boolean getMostrarComisionLineaLinea() {
		return this.mostrarComisionLineaLinea;
	}

	public void setMostrarComisionLineaLinea(Boolean visibilidadResaltarComisionLinea) {
		this.mostrarComisionLineaLinea= visibilidadResaltarComisionLinea;
	}



	public Boolean activarComisionLineaLinea=true;

	public Boolean gethabilitarResaltarComisionLineaLinea() {
		return this.activarComisionLineaLinea;
	}

	public void setActivarComisionLineaLinea(Boolean habilitarResaltarComisionLinea) {
		this.activarComisionLineaLinea= habilitarResaltarComisionLinea;
	}


	public Border resaltarComisionCateLinea=null;

	public Border getResaltarComisionCateLinea() {
		return this.resaltarComisionCateLinea;
	}

	public void setResaltarComisionCateLinea(Border borderResaltarComisionCate) {
		if(borderResaltarComisionCate!=null) {
			this.resaltarComisionCateLinea= borderResaltarComisionCate;
		}
	}

	public Border setResaltarComisionCateLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionCate=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarComisionCate);
			
		this.resaltarComisionCateLinea= borderResaltarComisionCate;

		 return borderResaltarComisionCate;
	}



	public Boolean mostrarComisionCateLinea=true;

	public Boolean getMostrarComisionCateLinea() {
		return this.mostrarComisionCateLinea;
	}

	public void setMostrarComisionCateLinea(Boolean visibilidadResaltarComisionCate) {
		this.mostrarComisionCateLinea= visibilidadResaltarComisionCate;
	}



	public Boolean activarComisionCateLinea=true;

	public Boolean gethabilitarResaltarComisionCateLinea() {
		return this.activarComisionCateLinea;
	}

	public void setActivarComisionCateLinea(Boolean habilitarResaltarComisionCate) {
		this.activarComisionCateLinea= habilitarResaltarComisionCate;
	}


	public Border resaltarDetallePlaneacionCompraLinea=null;

	public Border getResaltarDetallePlaneacionCompraLinea() {
		return this.resaltarDetallePlaneacionCompraLinea;
	}

	public void setResaltarDetallePlaneacionCompraLinea(Border borderResaltarDetallePlaneacionCompra) {
		if(borderResaltarDetallePlaneacionCompra!=null) {
			this.resaltarDetallePlaneacionCompraLinea= borderResaltarDetallePlaneacionCompra;
		}
	}

	public Border setResaltarDetallePlaneacionCompraLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePlaneacionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarDetallePlaneacionCompra);
			
		this.resaltarDetallePlaneacionCompraLinea= borderResaltarDetallePlaneacionCompra;

		 return borderResaltarDetallePlaneacionCompra;
	}



	public Boolean mostrarDetallePlaneacionCompraLinea=true;

	public Boolean getMostrarDetallePlaneacionCompraLinea() {
		return this.mostrarDetallePlaneacionCompraLinea;
	}

	public void setMostrarDetallePlaneacionCompraLinea(Boolean visibilidadResaltarDetallePlaneacionCompra) {
		this.mostrarDetallePlaneacionCompraLinea= visibilidadResaltarDetallePlaneacionCompra;
	}



	public Boolean activarDetallePlaneacionCompraLinea=true;

	public Boolean gethabilitarResaltarDetallePlaneacionCompraLinea() {
		return this.activarDetallePlaneacionCompraLinea;
	}

	public void setActivarDetallePlaneacionCompraLinea(Boolean habilitarResaltarDetallePlaneacionCompra) {
		this.activarDetallePlaneacionCompraLinea= habilitarResaltarDetallePlaneacionCompra;
	}


	public Border resaltarCuentasContablesLineaProductoLinea=null;

	public Border getResaltarCuentasContablesLineaProductoLinea() {
		return this.resaltarCuentasContablesLineaProductoLinea;
	}

	public void setResaltarCuentasContablesLineaProductoLinea(Border borderResaltarCuentasContablesLineaProducto) {
		if(borderResaltarCuentasContablesLineaProducto!=null) {
			this.resaltarCuentasContablesLineaProductoLinea= borderResaltarCuentasContablesLineaProducto;
		}
	}

	public Border setResaltarCuentasContablesLineaProductoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentasContablesLineaProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarCuentasContablesLineaProducto);
			
		this.resaltarCuentasContablesLineaProductoLinea= borderResaltarCuentasContablesLineaProducto;

		 return borderResaltarCuentasContablesLineaProducto;
	}



	public Boolean mostrarCuentasContablesLineaProductoLinea=true;

	public Boolean getMostrarCuentasContablesLineaProductoLinea() {
		return this.mostrarCuentasContablesLineaProductoLinea;
	}

	public void setMostrarCuentasContablesLineaProductoLinea(Boolean visibilidadResaltarCuentasContablesLineaProducto) {
		this.mostrarCuentasContablesLineaProductoLinea= visibilidadResaltarCuentasContablesLineaProducto;
	}



	public Boolean activarCuentasContablesLineaProductoLinea=true;

	public Boolean gethabilitarResaltarCuentasContablesLineaProductoLinea() {
		return this.activarCuentasContablesLineaProductoLinea;
	}

	public void setActivarCuentasContablesLineaProductoLinea(Boolean habilitarResaltarCuentasContablesLineaProducto) {
		this.activarCuentasContablesLineaProductoLinea= habilitarResaltarCuentasContablesLineaProducto;
	}


	public Border resaltarPrecioLinea=null;

	public Border getResaltarPrecioLinea() {
		return this.resaltarPrecioLinea;
	}

	public void setResaltarPrecioLinea(Border borderResaltarPrecio) {
		if(borderResaltarPrecio!=null) {
			this.resaltarPrecioLinea= borderResaltarPrecio;
		}
	}

	public Border setResaltarPrecioLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarPrecio);
			
		this.resaltarPrecioLinea= borderResaltarPrecio;

		 return borderResaltarPrecio;
	}



	public Boolean mostrarPrecioLinea=true;

	public Boolean getMostrarPrecioLinea() {
		return this.mostrarPrecioLinea;
	}

	public void setMostrarPrecioLinea(Boolean visibilidadResaltarPrecio) {
		this.mostrarPrecioLinea= visibilidadResaltarPrecio;
	}



	public Boolean activarPrecioLinea=true;

	public Boolean gethabilitarResaltarPrecioLinea() {
		return this.activarPrecioLinea;
	}

	public void setActivarPrecioLinea(Boolean habilitarResaltarPrecio) {
		this.activarPrecioLinea= habilitarResaltarPrecio;
	}


	public Border resaltarLineaPuntoVentaLinea=null;

	public Border getResaltarLineaPuntoVentaLinea() {
		return this.resaltarLineaPuntoVentaLinea;
	}

	public void setResaltarLineaPuntoVentaLinea(Border borderResaltarLineaPuntoVenta) {
		if(borderResaltarLineaPuntoVenta!=null) {
			this.resaltarLineaPuntoVentaLinea= borderResaltarLineaPuntoVenta;
		}
	}

	public Border setResaltarLineaPuntoVentaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarLineaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarLineaPuntoVenta);
			
		this.resaltarLineaPuntoVentaLinea= borderResaltarLineaPuntoVenta;

		 return borderResaltarLineaPuntoVenta;
	}



	public Boolean mostrarLineaPuntoVentaLinea=true;

	public Boolean getMostrarLineaPuntoVentaLinea() {
		return this.mostrarLineaPuntoVentaLinea;
	}

	public void setMostrarLineaPuntoVentaLinea(Boolean visibilidadResaltarLineaPuntoVenta) {
		this.mostrarLineaPuntoVentaLinea= visibilidadResaltarLineaPuntoVenta;
	}



	public Boolean activarLineaPuntoVentaLinea=true;

	public Boolean gethabilitarResaltarLineaPuntoVentaLinea() {
		return this.activarLineaPuntoVentaLinea;
	}

	public void setActivarLineaPuntoVentaLinea(Boolean habilitarResaltarLineaPuntoVenta) {
		this.activarLineaPuntoVentaLinea= habilitarResaltarLineaPuntoVenta;
	}


	public Border resaltarDetalleCodigoBarraProductoLinea=null;

	public Border getResaltarDetalleCodigoBarraProductoLinea() {
		return this.resaltarDetalleCodigoBarraProductoLinea;
	}

	public void setResaltarDetalleCodigoBarraProductoLinea(Border borderResaltarDetalleCodigoBarraProducto) {
		if(borderResaltarDetalleCodigoBarraProducto!=null) {
			this.resaltarDetalleCodigoBarraProductoLinea= borderResaltarDetalleCodigoBarraProducto;
		}
	}

	public Border setResaltarDetalleCodigoBarraProductoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCodigoBarraProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarDetalleCodigoBarraProducto);
			
		this.resaltarDetalleCodigoBarraProductoLinea= borderResaltarDetalleCodigoBarraProducto;

		 return borderResaltarDetalleCodigoBarraProducto;
	}



	public Boolean mostrarDetalleCodigoBarraProductoLinea=true;

	public Boolean getMostrarDetalleCodigoBarraProductoLinea() {
		return this.mostrarDetalleCodigoBarraProductoLinea;
	}

	public void setMostrarDetalleCodigoBarraProductoLinea(Boolean visibilidadResaltarDetalleCodigoBarraProducto) {
		this.mostrarDetalleCodigoBarraProductoLinea= visibilidadResaltarDetalleCodigoBarraProducto;
	}



	public Boolean activarDetalleCodigoBarraProductoLinea=true;

	public Boolean gethabilitarResaltarDetalleCodigoBarraProductoLinea() {
		return this.activarDetalleCodigoBarraProductoLinea;
	}

	public void setActivarDetalleCodigoBarraProductoLinea(Boolean habilitarResaltarDetalleCodigoBarraProducto) {
		this.activarDetalleCodigoBarraProductoLinea= habilitarResaltarDetalleCodigoBarraProducto;
	}


	public Border resaltarPresupuestoVentasLineasLinea=null;

	public Border getResaltarPresupuestoVentasLineasLinea() {
		return this.resaltarPresupuestoVentasLineasLinea;
	}

	public void setResaltarPresupuestoVentasLineasLinea(Border borderResaltarPresupuestoVentasLineas) {
		if(borderResaltarPresupuestoVentasLineas!=null) {
			this.resaltarPresupuestoVentasLineasLinea= borderResaltarPresupuestoVentasLineas;
		}
	}

	public Border setResaltarPresupuestoVentasLineasLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentasLineas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarPresupuestoVentasLineas);
			
		this.resaltarPresupuestoVentasLineasLinea= borderResaltarPresupuestoVentasLineas;

		 return borderResaltarPresupuestoVentasLineas;
	}



	public Boolean mostrarPresupuestoVentasLineasLinea=true;

	public Boolean getMostrarPresupuestoVentasLineasLinea() {
		return this.mostrarPresupuestoVentasLineasLinea;
	}

	public void setMostrarPresupuestoVentasLineasLinea(Boolean visibilidadResaltarPresupuestoVentasLineas) {
		this.mostrarPresupuestoVentasLineasLinea= visibilidadResaltarPresupuestoVentasLineas;
	}



	public Boolean activarPresupuestoVentasLineasLinea=true;

	public Boolean gethabilitarResaltarPresupuestoVentasLineasLinea() {
		return this.activarPresupuestoVentasLineasLinea;
	}

	public void setActivarPresupuestoVentasLineasLinea(Boolean habilitarResaltarPresupuestoVentasLineas) {
		this.activarPresupuestoVentasLineasLinea= habilitarResaltarPresupuestoVentasLineas;
	}


	public Border resaltarCentroCostoGrupoProductoLinea=null;

	public Border getResaltarCentroCostoGrupoProductoLinea() {
		return this.resaltarCentroCostoGrupoProductoLinea;
	}

	public void setResaltarCentroCostoGrupoProductoLinea(Border borderResaltarCentroCostoGrupoProducto) {
		if(borderResaltarCentroCostoGrupoProducto!=null) {
			this.resaltarCentroCostoGrupoProductoLinea= borderResaltarCentroCostoGrupoProducto;
		}
	}

	public Border setResaltarCentroCostoGrupoProductoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarCentroCostoGrupoProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarCentroCostoGrupoProducto);
			
		this.resaltarCentroCostoGrupoProductoLinea= borderResaltarCentroCostoGrupoProducto;

		 return borderResaltarCentroCostoGrupoProducto;
	}



	public Boolean mostrarCentroCostoGrupoProductoLinea=true;

	public Boolean getMostrarCentroCostoGrupoProductoLinea() {
		return this.mostrarCentroCostoGrupoProductoLinea;
	}

	public void setMostrarCentroCostoGrupoProductoLinea(Boolean visibilidadResaltarCentroCostoGrupoProducto) {
		this.mostrarCentroCostoGrupoProductoLinea= visibilidadResaltarCentroCostoGrupoProducto;
	}



	public Boolean activarCentroCostoGrupoProductoLinea=true;

	public Boolean gethabilitarResaltarCentroCostoGrupoProductoLinea() {
		return this.activarCentroCostoGrupoProductoLinea;
	}

	public void setActivarCentroCostoGrupoProductoLinea(Boolean habilitarResaltarCentroCostoGrupoProducto) {
		this.activarCentroCostoGrupoProductoLinea= habilitarResaltarCentroCostoGrupoProducto;
	}


	public Border resaltarProductoLinea=null;

	public Border getResaltarProductoLinea() {
		return this.resaltarProductoLinea;
	}

	public void setResaltarProductoLinea(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoLinea= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarProducto);
			
		this.resaltarProductoLinea= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoLinea=true;

	public Boolean getMostrarProductoLinea() {
		return this.mostrarProductoLinea;
	}

	public void setMostrarProductoLinea(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoLinea= visibilidadResaltarProducto;
	}



	public Boolean activarProductoLinea=true;

	public Boolean gethabilitarResaltarProductoLinea() {
		return this.activarProductoLinea;
	}

	public void setActivarProductoLinea(Boolean habilitarResaltarProducto) {
		this.activarProductoLinea= habilitarResaltarProducto;
	}


	public Border resaltarComisionMarcaLinea=null;

	public Border getResaltarComisionMarcaLinea() {
		return this.resaltarComisionMarcaLinea;
	}

	public void setResaltarComisionMarcaLinea(Border borderResaltarComisionMarca) {
		if(borderResaltarComisionMarca!=null) {
			this.resaltarComisionMarcaLinea= borderResaltarComisionMarca;
		}
	}

	public Border setResaltarComisionMarcaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionMarca=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineaBeanSwingJInternalFrame.jTtoolBarLinea.setBorder(borderResaltarComisionMarca);
			
		this.resaltarComisionMarcaLinea= borderResaltarComisionMarca;

		 return borderResaltarComisionMarca;
	}



	public Boolean mostrarComisionMarcaLinea=true;

	public Boolean getMostrarComisionMarcaLinea() {
		return this.mostrarComisionMarcaLinea;
	}

	public void setMostrarComisionMarcaLinea(Boolean visibilidadResaltarComisionMarca) {
		this.mostrarComisionMarcaLinea= visibilidadResaltarComisionMarca;
	}



	public Boolean activarComisionMarcaLinea=true;

	public Boolean gethabilitarResaltarComisionMarcaLinea() {
		return this.activarComisionMarcaLinea;
	}

	public void setActivarComisionMarcaLinea(Boolean habilitarResaltarComisionMarca) {
		this.activarComisionMarcaLinea= habilitarResaltarComisionMarca;
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

		this.setMostrarPresupuestoLineaLinea(esInicial);
		this.setMostrarLineaLinea(esInicial);
		this.setMostrarComisionGrupoLinea(esInicial);
		this.setMostrarProductoPuntoVentaLinea(esInicial);
		this.setMostrarComisionLineaLinea(esInicial);
		this.setMostrarComisionCateLinea(esInicial);
		this.setMostrarDetallePlaneacionCompraLinea(esInicial);
		this.setMostrarCuentasContablesLineaProductoLinea(esInicial);
		this.setMostrarPrecioLinea(esInicial);
		this.setMostrarLineaPuntoVentaLinea(esInicial);
		this.setMostrarDetalleCodigoBarraProductoLinea(esInicial);
		this.setMostrarPresupuestoVentasLineasLinea(esInicial);
		this.setMostrarCentroCostoGrupoProductoLinea(esInicial);
		this.setMostrarProductoLinea(esInicial);
		this.setMostrarComisionMarcaLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresupuestoLinea.class)) {
				this.setMostrarPresupuestoLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Linea.class)) {
				this.setMostrarLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setMostrarComisionGrupoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPuntoVenta.class)) {
				this.setMostrarProductoPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setMostrarComisionLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setMostrarComisionCateLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setMostrarDetallePlaneacionCompraLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentasContablesLineaProducto.class)) {
				this.setMostrarCuentasContablesLineaProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setMostrarPrecioLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(LineaPuntoVenta.class)) {
				this.setMostrarLineaPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCodigoBarraProducto.class)) {
				this.setMostrarDetalleCodigoBarraProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setMostrarPresupuestoVentasLineasLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroCostoGrupoProducto.class)) {
				this.setMostrarCentroCostoGrupoProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setMostrarComisionMarcaLinea(esAsigna);
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

		this.setActivarPresupuestoLineaLinea(esInicial);
		this.setActivarLineaLinea(esInicial);
		this.setActivarComisionGrupoLinea(esInicial);
		this.setActivarProductoPuntoVentaLinea(esInicial);
		this.setActivarComisionLineaLinea(esInicial);
		this.setActivarComisionCateLinea(esInicial);
		this.setActivarDetallePlaneacionCompraLinea(esInicial);
		this.setActivarCuentasContablesLineaProductoLinea(esInicial);
		this.setActivarPrecioLinea(esInicial);
		this.setActivarLineaPuntoVentaLinea(esInicial);
		this.setActivarDetalleCodigoBarraProductoLinea(esInicial);
		this.setActivarPresupuestoVentasLineasLinea(esInicial);
		this.setActivarCentroCostoGrupoProductoLinea(esInicial);
		this.setActivarProductoLinea(esInicial);
		this.setActivarComisionMarcaLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresupuestoLinea.class)) {
				this.setActivarPresupuestoLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Linea.class)) {
				this.setActivarLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setActivarComisionGrupoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPuntoVenta.class)) {
				this.setActivarProductoPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setActivarComisionLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setActivarComisionCateLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setActivarDetallePlaneacionCompraLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentasContablesLineaProducto.class)) {
				this.setActivarCuentasContablesLineaProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setActivarPrecioLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(LineaPuntoVenta.class)) {
				this.setActivarLineaPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCodigoBarraProducto.class)) {
				this.setActivarDetalleCodigoBarraProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setActivarPresupuestoVentasLineasLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroCostoGrupoProducto.class)) {
				this.setActivarCentroCostoGrupoProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setActivarComisionMarcaLinea(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPresupuestoLineaLinea(esInicial);
		this.setResaltarLineaLinea(esInicial);
		this.setResaltarComisionGrupoLinea(esInicial);
		this.setResaltarProductoPuntoVentaLinea(esInicial);
		this.setResaltarComisionLineaLinea(esInicial);
		this.setResaltarComisionCateLinea(esInicial);
		this.setResaltarDetallePlaneacionCompraLinea(esInicial);
		this.setResaltarCuentasContablesLineaProductoLinea(esInicial);
		this.setResaltarPrecioLinea(esInicial);
		this.setResaltarLineaPuntoVentaLinea(esInicial);
		this.setResaltarDetalleCodigoBarraProductoLinea(esInicial);
		this.setResaltarPresupuestoVentasLineasLinea(esInicial);
		this.setResaltarCentroCostoGrupoProductoLinea(esInicial);
		this.setResaltarProductoLinea(esInicial);
		this.setResaltarComisionMarcaLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresupuestoLinea.class)) {
				this.setResaltarPresupuestoLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Linea.class)) {
				this.setResaltarLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionGrupo.class)) {
				this.setResaltarComisionGrupoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPuntoVenta.class)) {
				this.setResaltarProductoPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionLinea.class)) {
				this.setResaltarComisionLineaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionCate.class)) {
				this.setResaltarComisionCateLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setResaltarDetallePlaneacionCompraLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentasContablesLineaProducto.class)) {
				this.setResaltarCuentasContablesLineaProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setResaltarPrecioLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(LineaPuntoVenta.class)) {
				this.setResaltarLineaPuntoVentaLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCodigoBarraProducto.class)) {
				this.setResaltarDetalleCodigoBarraProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentasLineas.class)) {
				this.setResaltarPresupuestoVentasLineasLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroCostoGrupoProducto.class)) {
				this.setResaltarCentroCostoGrupoProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionMarca.class)) {
				this.setResaltarComisionMarcaLinea(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoLinea=true;

	public Boolean getMostrarBusquedaPorCodigoLinea() {
		return this.mostrarBusquedaPorCodigoLinea;
	}

	public void setMostrarBusquedaPorCodigoLinea(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoLinea= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreLinea=true;

	public Boolean getMostrarBusquedaPorNombreLinea() {
		return this.mostrarBusquedaPorNombreLinea;
	}

	public void setMostrarBusquedaPorNombreLinea(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreLinea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLinea=true;

	public Boolean getMostrarFK_IdEmpresaLinea() {
		return this.mostrarFK_IdEmpresaLinea;
	}

	public void setMostrarFK_IdEmpresaLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLinea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaLinea=true;

	public Boolean getMostrarFK_IdLineaLinea() {
		return this.mostrarFK_IdLineaLinea;
	}

	public void setMostrarFK_IdLineaLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaLinea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNivelLineaLinea=true;

	public Boolean getMostrarFK_IdNivelLineaLinea() {
		return this.mostrarFK_IdNivelLineaLinea;
	}

	public void setMostrarFK_IdNivelLineaLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNivelLineaLinea= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoLinea=true;

	public Boolean getActivarBusquedaPorCodigoLinea() {
		return this.activarBusquedaPorCodigoLinea;
	}

	public void setActivarBusquedaPorCodigoLinea(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoLinea= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreLinea=true;

	public Boolean getActivarBusquedaPorNombreLinea() {
		return this.activarBusquedaPorNombreLinea;
	}

	public void setActivarBusquedaPorNombreLinea(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreLinea= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLinea=true;

	public Boolean getActivarFK_IdEmpresaLinea() {
		return this.activarFK_IdEmpresaLinea;
	}

	public void setActivarFK_IdEmpresaLinea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLinea= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaLinea=true;

	public Boolean getActivarFK_IdLineaLinea() {
		return this.activarFK_IdLineaLinea;
	}

	public void setActivarFK_IdLineaLinea(Boolean habilitarResaltar) {
		this.activarFK_IdLineaLinea= habilitarResaltar;
	}

	public Boolean activarFK_IdNivelLineaLinea=true;

	public Boolean getActivarFK_IdNivelLineaLinea() {
		return this.activarFK_IdNivelLineaLinea;
	}

	public void setActivarFK_IdNivelLineaLinea(Boolean habilitarResaltar) {
		this.activarFK_IdNivelLineaLinea= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoLinea=null;

	public Border getResaltarBusquedaPorCodigoLinea() {
		return this.resaltarBusquedaPorCodigoLinea;
	}

	public void setResaltarBusquedaPorCodigoLinea(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoLinea= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoLinea= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreLinea=null;

	public Border getResaltarBusquedaPorNombreLinea() {
		return this.resaltarBusquedaPorNombreLinea;
	}

	public void setResaltarBusquedaPorNombreLinea(Border borderResaltar) {
		this.resaltarBusquedaPorNombreLinea= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreLinea= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLinea=null;

	public Border getResaltarFK_IdEmpresaLinea() {
		return this.resaltarFK_IdEmpresaLinea;
	}

	public void setResaltarFK_IdEmpresaLinea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLinea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLinea= borderResaltar;
	}

	public Border resaltarFK_IdLineaLinea=null;

	public Border getResaltarFK_IdLineaLinea() {
		return this.resaltarFK_IdLineaLinea;
	}

	public void setResaltarFK_IdLineaLinea(Border borderResaltar) {
		this.resaltarFK_IdLineaLinea= borderResaltar;
	}

	public void setResaltarFK_IdLineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaLinea= borderResaltar;
	}

	public Border resaltarFK_IdNivelLineaLinea=null;

	public Border getResaltarFK_IdNivelLineaLinea() {
		return this.resaltarFK_IdNivelLineaLinea;
	}

	public void setResaltarFK_IdNivelLineaLinea(Border borderResaltar) {
		this.resaltarFK_IdNivelLineaLinea= borderResaltar;
	}

	public void setResaltarFK_IdNivelLineaLinea(ParametroGeneralUsuario parametroGeneralUsuario/*LineaBeanSwingJInternalFrame lineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNivelLineaLinea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}