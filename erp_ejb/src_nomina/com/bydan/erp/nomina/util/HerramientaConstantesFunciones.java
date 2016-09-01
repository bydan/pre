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


import com.bydan.erp.nomina.util.HerramientaConstantesFunciones;
import com.bydan.erp.nomina.util.HerramientaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HerramientaParameterGeneral;

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
final public class HerramientaConstantesFunciones extends HerramientaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Herramienta";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Herramienta"+HerramientaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HerramientaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HerramientaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HerramientaConstantesFunciones.SCHEMA+"_"+HerramientaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HerramientaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HerramientaConstantesFunciones.SCHEMA+"_"+HerramientaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HerramientaConstantesFunciones.SCHEMA+"_"+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HerramientaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HerramientaConstantesFunciones.SCHEMA+"_"+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HerramientaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HerramientaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HerramientaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HerramientaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HerramientaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HerramientaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HerramientaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Herramientas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Herramienta";
	public static final String SCLASSWEBTITULO_LOWER="Herramienta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Herramienta";
	public static final String OBJECTNAME="herramienta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="herramienta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select herramienta from "+HerramientaConstantesFunciones.SPERSISTENCENAME+" herramienta";
	public static String QUERYSELECTNATIVE="select "+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME+".id,"+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME+".version_row,"+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME+".id_empresa,"+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME+".nombre,"+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME+".descripcion from "+HerramientaConstantesFunciones.SCHEMA+"."+HerramientaConstantesFunciones.TABLENAME;//+" as "+HerramientaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HerramientaConstantesFuncionesAdditional herramientaConstantesFuncionesAdditional=null;
	
	public HerramientaConstantesFuncionesAdditional getHerramientaConstantesFuncionesAdditional() {
		return this.herramientaConstantesFuncionesAdditional;
	}
	
	public void setHerramientaConstantesFuncionesAdditional(HerramientaConstantesFuncionesAdditional herramientaConstantesFuncionesAdditional) {
		try {
			this.herramientaConstantesFuncionesAdditional=herramientaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getHerramientaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HerramientaConstantesFunciones.IDEMPRESA)) {sLabelColumna=HerramientaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HerramientaConstantesFunciones.NOMBRE)) {sLabelColumna=HerramientaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(HerramientaConstantesFunciones.DESCRIPCION)) {sLabelColumna=HerramientaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getHerramientaDescripcion(Herramienta herramienta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(herramienta !=null/* && herramienta.getId()!=0*/) {
			sDescripcion=herramienta.getnombre();//herramientaherramienta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getHerramientaDescripcionDetallado(Herramienta herramienta) {
		String sDescripcion="";
			
		sDescripcion+=HerramientaConstantesFunciones.ID+"=";
		sDescripcion+=herramienta.getId().toString()+",";
		sDescripcion+=HerramientaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=herramienta.getVersionRow().toString()+",";
		sDescripcion+=HerramientaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=herramienta.getid_empresa().toString()+",";
		sDescripcion+=HerramientaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=herramienta.getnombre()+",";
		sDescripcion+=HerramientaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=herramienta.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setHerramientaDescripcion(Herramienta herramienta,String sValor) throws Exception {			
		if(herramienta !=null) {
			herramienta.setnombre(sValor);;//herramientaherramienta.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	
	
	public static void quitarEspaciosHerramienta(Herramienta herramienta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		herramienta.setnombre(herramienta.getnombre().trim());
		herramienta.setdescripcion(herramienta.getdescripcion().trim());
	}
	
	public static void quitarEspaciosHerramientas(List<Herramienta> herramientas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Herramienta herramienta: herramientas) {
			herramienta.setnombre(herramienta.getnombre().trim());
			herramienta.setdescripcion(herramienta.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHerramienta(Herramienta herramienta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && herramienta.getConCambioAuxiliar()) {
			herramienta.setIsDeleted(herramienta.getIsDeletedAuxiliar());	
			herramienta.setIsNew(herramienta.getIsNewAuxiliar());	
			herramienta.setIsChanged(herramienta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			herramienta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			herramienta.setIsDeletedAuxiliar(false);	
			herramienta.setIsNewAuxiliar(false);	
			herramienta.setIsChangedAuxiliar(false);
			
			herramienta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHerramientas(List<Herramienta> herramientas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Herramienta herramienta : herramientas) {
			if(conAsignarBase && herramienta.getConCambioAuxiliar()) {
				herramienta.setIsDeleted(herramienta.getIsDeletedAuxiliar());	
				herramienta.setIsNew(herramienta.getIsNewAuxiliar());	
				herramienta.setIsChanged(herramienta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				herramienta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				herramienta.setIsDeletedAuxiliar(false);	
				herramienta.setIsNewAuxiliar(false);	
				herramienta.setIsChangedAuxiliar(false);
				
				herramienta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHerramienta(Herramienta herramienta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHerramientas(List<Herramienta> herramientas,Boolean conEnteros) throws Exception  {
		
		for(Herramienta herramienta: herramientas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHerramienta(List<Herramienta> herramientas,Herramienta herramientaAux) throws Exception  {
		HerramientaConstantesFunciones.InicializarValoresHerramienta(herramientaAux,true);
		
		for(Herramienta herramienta: herramientas) {
			if(herramienta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHerramienta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HerramientaConstantesFunciones.getArrayColumnasGlobalesHerramienta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHerramienta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HerramientaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HerramientaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHerramienta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Herramienta> herramientas,Herramienta herramienta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Herramienta herramientaAux: herramientas) {
			if(herramientaAux!=null && herramienta!=null) {
				if((herramientaAux.getId()==null && herramienta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(herramientaAux.getId()!=null && herramienta.getId()!=null){
					if(herramientaAux.getId().equals(herramienta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHerramienta(List<Herramienta> herramientas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Herramienta herramienta: herramientas) {			
			if(herramienta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHerramienta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HerramientaConstantesFunciones.LABEL_ID, HerramientaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HerramientaConstantesFunciones.LABEL_VERSIONROW, HerramientaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HerramientaConstantesFunciones.LABEL_IDEMPRESA, HerramientaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HerramientaConstantesFunciones.LABEL_NOMBRE, HerramientaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HerramientaConstantesFunciones.LABEL_DESCRIPCION, HerramientaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHerramienta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HerramientaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HerramientaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HerramientaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HerramientaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HerramientaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHerramienta() throws Exception  {
		return HerramientaConstantesFunciones.getTiposSeleccionarHerramienta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHerramienta(Boolean conFk) throws Exception  {
		return HerramientaConstantesFunciones.getTiposSeleccionarHerramienta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHerramienta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HerramientaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HerramientaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HerramientaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(HerramientaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HerramientaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(HerramientaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHerramienta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHerramienta(Herramienta herramientaAux) throws Exception {
		
			herramientaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(herramientaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHerramienta(List<Herramienta> herramientasTemp) throws Exception {
		for(Herramienta herramientaAux:herramientasTemp) {
			
			herramientaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(herramientaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHerramienta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHerramienta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHerramienta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HerramientaConstantesFunciones.getClassesRelationshipsOfHerramienta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHerramienta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoHerra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoHerra.class)) {
						classes.add(new Classe(EmpleadoHerra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHerramienta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HerramientaConstantesFunciones.getClassesRelationshipsFromStringsOfHerramienta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHerramienta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoHerra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHerra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoHerra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHerra.class)); continue;
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
	public static void actualizarLista(Herramienta herramienta,List<Herramienta> herramientas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Herramienta herramientaEncontrado=null;
			
			for(Herramienta herramientaLocal:herramientas) {
				if(herramientaLocal.getId().equals(herramienta.getId())) {
					herramientaEncontrado=herramientaLocal;
					
					herramientaLocal.setIsChanged(herramienta.getIsChanged());
					herramientaLocal.setIsNew(herramienta.getIsNew());
					herramientaLocal.setIsDeleted(herramienta.getIsDeleted());
					
					herramientaLocal.setGeneralEntityOriginal(herramienta.getGeneralEntityOriginal());
					
					herramientaLocal.setId(herramienta.getId());	
					herramientaLocal.setVersionRow(herramienta.getVersionRow());	
					herramientaLocal.setid_empresa(herramienta.getid_empresa());	
					herramientaLocal.setnombre(herramienta.getnombre());	
					herramientaLocal.setdescripcion(herramienta.getdescripcion());	
					
					
					herramientaLocal.setEmpleadoHerras(herramienta.getEmpleadoHerras());
					
					existe=true;
					break;
				}
			}
			
			if(!herramienta.getIsDeleted()) {
				if(!existe) {
					herramientas.add(herramienta);
				}
			} else {
				if(herramientaEncontrado!=null && permiteQuitar)  {
					herramientas.remove(herramientaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Herramienta herramienta,List<Herramienta> herramientas) throws Exception {
		try	{			
			for(Herramienta herramientaLocal:herramientas) {
				if(herramientaLocal.getId().equals(herramienta.getId())) {
					herramientaLocal.setIsSelected(herramienta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHerramienta(List<Herramienta> herramientasAux) throws Exception {
		//this.herramientasAux=herramientasAux;
		
		for(Herramienta herramientaAux:herramientasAux) {
			if(herramientaAux.getIsChanged()) {
				herramientaAux.setIsChanged(false);
			}		
			
			if(herramientaAux.getIsNew()) {
				herramientaAux.setIsNew(false);
			}	
			
			if(herramientaAux.getIsDeleted()) {
				herramientaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHerramienta(Herramienta herramientaAux) throws Exception {
		//this.herramientaAux=herramientaAux;
		
			if(herramientaAux.getIsChanged()) {
				herramientaAux.setIsChanged(false);
			}		
			
			if(herramientaAux.getIsNew()) {
				herramientaAux.setIsNew(false);
			}	
			
			if(herramientaAux.getIsDeleted()) {
				herramientaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Herramienta herramientaAsignar,Herramienta herramienta) throws Exception {
		herramientaAsignar.setId(herramienta.getId());	
		herramientaAsignar.setVersionRow(herramienta.getVersionRow());	
		herramientaAsignar.setid_empresa(herramienta.getid_empresa());
		herramientaAsignar.setempresa_descripcion(herramienta.getempresa_descripcion());	
		herramientaAsignar.setnombre(herramienta.getnombre());	
		herramientaAsignar.setdescripcion(herramienta.getdescripcion());	
	}
	
	public static void inicializarHerramienta(Herramienta herramienta) throws Exception {
		try {
				herramienta.setId(0L);	
					
				herramienta.setid_empresa(-1L);	
				herramienta.setnombre("");	
				herramienta.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHerramienta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HerramientaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HerramientaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HerramientaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHerramienta(String sTipo,Row row,Workbook workbook,Herramienta herramienta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(herramienta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(herramienta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(herramienta.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHerramienta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHerramienta() {
		return this.sFinalQueryHerramienta;
	}
	
	public void setsFinalQueryHerramienta(String sFinalQueryHerramienta) {
		this.sFinalQueryHerramienta= sFinalQueryHerramienta;
	}
	
	public Border resaltarSeleccionarHerramienta=null;
	
	public Border setResaltarSeleccionarHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHerramienta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHerramienta() {
		return this.resaltarSeleccionarHerramienta;
	}
	
	public void setResaltarSeleccionarHerramienta(Border borderResaltarSeleccionarHerramienta) {
		this.resaltarSeleccionarHerramienta= borderResaltarSeleccionarHerramienta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHerramienta=null;
	public Boolean mostraridHerramienta=true;
	public Boolean activaridHerramienta=true;

	public Border resaltarid_empresaHerramienta=null;
	public Boolean mostrarid_empresaHerramienta=true;
	public Boolean activarid_empresaHerramienta=true;
	public Boolean cargarid_empresaHerramienta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHerramienta=false;//ConEventDepend=true

	public Border resaltarnombreHerramienta=null;
	public Boolean mostrarnombreHerramienta=true;
	public Boolean activarnombreHerramienta=true;

	public Border resaltardescripcionHerramienta=null;
	public Boolean mostrardescripcionHerramienta=true;
	public Boolean activardescripcionHerramienta=true;

	
	

	public Border setResaltaridHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltar);
		
		this.resaltaridHerramienta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHerramienta() {
		return this.resaltaridHerramienta;
	}

	public void setResaltaridHerramienta(Border borderResaltar) {
		this.resaltaridHerramienta= borderResaltar;
	}

	public Boolean getMostraridHerramienta() {
		return this.mostraridHerramienta;
	}

	public void setMostraridHerramienta(Boolean mostraridHerramienta) {
		this.mostraridHerramienta= mostraridHerramienta;
	}

	public Boolean getActivaridHerramienta() {
		return this.activaridHerramienta;
	}

	public void setActivaridHerramienta(Boolean activaridHerramienta) {
		this.activaridHerramienta= activaridHerramienta;
	}

	public Border setResaltarid_empresaHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltar);
		
		this.resaltarid_empresaHerramienta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHerramienta() {
		return this.resaltarid_empresaHerramienta;
	}

	public void setResaltarid_empresaHerramienta(Border borderResaltar) {
		this.resaltarid_empresaHerramienta= borderResaltar;
	}

	public Boolean getMostrarid_empresaHerramienta() {
		return this.mostrarid_empresaHerramienta;
	}

	public void setMostrarid_empresaHerramienta(Boolean mostrarid_empresaHerramienta) {
		this.mostrarid_empresaHerramienta= mostrarid_empresaHerramienta;
	}

	public Boolean getActivarid_empresaHerramienta() {
		return this.activarid_empresaHerramienta;
	}

	public void setActivarid_empresaHerramienta(Boolean activarid_empresaHerramienta) {
		this.activarid_empresaHerramienta= activarid_empresaHerramienta;
	}

	public Boolean getCargarid_empresaHerramienta() {
		return this.cargarid_empresaHerramienta;
	}

	public void setCargarid_empresaHerramienta(Boolean cargarid_empresaHerramienta) {
		this.cargarid_empresaHerramienta= cargarid_empresaHerramienta;
	}

	public Border setResaltarnombreHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltar);
		
		this.resaltarnombreHerramienta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreHerramienta() {
		return this.resaltarnombreHerramienta;
	}

	public void setResaltarnombreHerramienta(Border borderResaltar) {
		this.resaltarnombreHerramienta= borderResaltar;
	}

	public Boolean getMostrarnombreHerramienta() {
		return this.mostrarnombreHerramienta;
	}

	public void setMostrarnombreHerramienta(Boolean mostrarnombreHerramienta) {
		this.mostrarnombreHerramienta= mostrarnombreHerramienta;
	}

	public Boolean getActivarnombreHerramienta() {
		return this.activarnombreHerramienta;
	}

	public void setActivarnombreHerramienta(Boolean activarnombreHerramienta) {
		this.activarnombreHerramienta= activarnombreHerramienta;
	}

	public Border setResaltardescripcionHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltar);
		
		this.resaltardescripcionHerramienta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionHerramienta() {
		return this.resaltardescripcionHerramienta;
	}

	public void setResaltardescripcionHerramienta(Border borderResaltar) {
		this.resaltardescripcionHerramienta= borderResaltar;
	}

	public Boolean getMostrardescripcionHerramienta() {
		return this.mostrardescripcionHerramienta;
	}

	public void setMostrardescripcionHerramienta(Boolean mostrardescripcionHerramienta) {
		this.mostrardescripcionHerramienta= mostrardescripcionHerramienta;
	}

	public Boolean getActivardescripcionHerramienta() {
		return this.activardescripcionHerramienta;
	}

	public void setActivardescripcionHerramienta(Boolean activardescripcionHerramienta) {
		this.activardescripcionHerramienta= activardescripcionHerramienta;
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
		
		
		this.setMostraridHerramienta(esInicial);
		this.setMostrarid_empresaHerramienta(esInicial);
		this.setMostrarnombreHerramienta(esInicial);
		this.setMostrardescripcionHerramienta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HerramientaConstantesFunciones.ID)) {
				this.setMostraridHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionHerramienta(esAsigna);
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
		
		
		this.setActivaridHerramienta(esInicial);
		this.setActivarid_empresaHerramienta(esInicial);
		this.setActivarnombreHerramienta(esInicial);
		this.setActivardescripcionHerramienta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HerramientaConstantesFunciones.ID)) {
				this.setActivaridHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionHerramienta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHerramienta(esInicial);
		this.setResaltarid_empresaHerramienta(esInicial);
		this.setResaltarnombreHerramienta(esInicial);
		this.setResaltardescripcionHerramienta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HerramientaConstantesFunciones.ID)) {
				this.setResaltaridHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreHerramienta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HerramientaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionHerramienta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoHerraHerramienta=null;

	public Border getResaltarEmpleadoHerraHerramienta() {
		return this.resaltarEmpleadoHerraHerramienta;
	}

	public void setResaltarEmpleadoHerraHerramienta(Border borderResaltarEmpleadoHerra) {
		if(borderResaltarEmpleadoHerra!=null) {
			this.resaltarEmpleadoHerraHerramienta= borderResaltarEmpleadoHerra;
		}
	}

	public Border setResaltarEmpleadoHerraHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoHerra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//herramientaBeanSwingJInternalFrame.jTtoolBarHerramienta.setBorder(borderResaltarEmpleadoHerra);
			
		this.resaltarEmpleadoHerraHerramienta= borderResaltarEmpleadoHerra;

		 return borderResaltarEmpleadoHerra;
	}



	public Boolean mostrarEmpleadoHerraHerramienta=true;

	public Boolean getMostrarEmpleadoHerraHerramienta() {
		return this.mostrarEmpleadoHerraHerramienta;
	}

	public void setMostrarEmpleadoHerraHerramienta(Boolean visibilidadResaltarEmpleadoHerra) {
		this.mostrarEmpleadoHerraHerramienta= visibilidadResaltarEmpleadoHerra;
	}



	public Boolean activarEmpleadoHerraHerramienta=true;

	public Boolean gethabilitarResaltarEmpleadoHerraHerramienta() {
		return this.activarEmpleadoHerraHerramienta;
	}

	public void setActivarEmpleadoHerraHerramienta(Boolean habilitarResaltarEmpleadoHerra) {
		this.activarEmpleadoHerraHerramienta= habilitarResaltarEmpleadoHerra;
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

		this.setMostrarEmpleadoHerraHerramienta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setMostrarEmpleadoHerraHerramienta(esAsigna);
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

		this.setActivarEmpleadoHerraHerramienta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setActivarEmpleadoHerraHerramienta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoHerraHerramienta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setResaltarEmpleadoHerraHerramienta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaHerramienta=true;

	public Boolean getMostrarFK_IdEmpresaHerramienta() {
		return this.mostrarFK_IdEmpresaHerramienta;
	}

	public void setMostrarFK_IdEmpresaHerramienta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHerramienta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaHerramienta=true;

	public Boolean getActivarFK_IdEmpresaHerramienta() {
		return this.activarFK_IdEmpresaHerramienta;
	}

	public void setActivarFK_IdEmpresaHerramienta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHerramienta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaHerramienta=null;

	public Border getResaltarFK_IdEmpresaHerramienta() {
		return this.resaltarFK_IdEmpresaHerramienta;
	}

	public void setResaltarFK_IdEmpresaHerramienta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHerramienta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHerramienta(ParametroGeneralUsuario parametroGeneralUsuario/*HerramientaBeanSwingJInternalFrame herramientaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHerramienta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}