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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.AseguradoraConstantesFunciones;
import com.bydan.erp.activosfijos.util.AseguradoraParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.AseguradoraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AseguradoraConstantesFunciones extends AseguradoraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Aseguradora";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Aseguradora"+AseguradoraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AseguradoraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AseguradoraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AseguradoraConstantesFunciones.SCHEMA+"_"+AseguradoraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AseguradoraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AseguradoraConstantesFunciones.SCHEMA+"_"+AseguradoraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AseguradoraConstantesFunciones.SCHEMA+"_"+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AseguradoraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AseguradoraConstantesFunciones.SCHEMA+"_"+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AseguradoraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AseguradoraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AseguradoraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AseguradoraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AseguradoraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AseguradoraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AseguradoraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Aseguradoras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Aseguradora";
	public static final String SCLASSWEBTITULO_LOWER="Aseguradora";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Aseguradora";
	public static final String OBJECTNAME="aseguradora";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="aseguradora";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select aseguradora from "+AseguradoraConstantesFunciones.SPERSISTENCENAME+" aseguradora";
	public static String QUERYSELECTNATIVE="select "+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".id,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".version_row,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".id_empresa,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".codigo,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".nombre,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".direccion,"+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME+".telefono from "+AseguradoraConstantesFunciones.SCHEMA+"."+AseguradoraConstantesFunciones.TABLENAME;//+" as "+AseguradoraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AseguradoraConstantesFuncionesAdditional aseguradoraConstantesFuncionesAdditional=null;
	
	public AseguradoraConstantesFuncionesAdditional getAseguradoraConstantesFuncionesAdditional() {
		return this.aseguradoraConstantesFuncionesAdditional;
	}
	
	public void setAseguradoraConstantesFuncionesAdditional(AseguradoraConstantesFuncionesAdditional aseguradoraConstantesFuncionesAdditional) {
		try {
			this.aseguradoraConstantesFuncionesAdditional=aseguradoraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
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
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	
	public static String getAseguradoraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AseguradoraConstantesFunciones.IDEMPRESA)) {sLabelColumna=AseguradoraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AseguradoraConstantesFunciones.CODIGO)) {sLabelColumna=AseguradoraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AseguradoraConstantesFunciones.NOMBRE)) {sLabelColumna=AseguradoraConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AseguradoraConstantesFunciones.DIRECCION)) {sLabelColumna=AseguradoraConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(AseguradoraConstantesFunciones.TELEFONO)) {sLabelColumna=AseguradoraConstantesFunciones.LABEL_TELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getAseguradoraDescripcion(Aseguradora aseguradora) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(aseguradora !=null/* && aseguradora.getId()!=0*/) {
			sDescripcion=aseguradora.getcodigo();//aseguradoraaseguradora.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAseguradoraDescripcionDetallado(Aseguradora aseguradora) {
		String sDescripcion="";
			
		sDescripcion+=AseguradoraConstantesFunciones.ID+"=";
		sDescripcion+=aseguradora.getId().toString()+",";
		sDescripcion+=AseguradoraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=aseguradora.getVersionRow().toString()+",";
		sDescripcion+=AseguradoraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=aseguradora.getid_empresa().toString()+",";
		sDescripcion+=AseguradoraConstantesFunciones.CODIGO+"=";
		sDescripcion+=aseguradora.getcodigo()+",";
		sDescripcion+=AseguradoraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=aseguradora.getnombre()+",";
		sDescripcion+=AseguradoraConstantesFunciones.DIRECCION+"=";
		sDescripcion+=aseguradora.getdireccion()+",";
		sDescripcion+=AseguradoraConstantesFunciones.TELEFONO+"=";
		sDescripcion+=aseguradora.gettelefono()+",";
			
		return sDescripcion;
	}
	
	public static void setAseguradoraDescripcion(Aseguradora aseguradora,String sValor) throws Exception {			
		if(aseguradora !=null) {
			aseguradora.setcodigo(sValor);;//aseguradoraaseguradora.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosAseguradora(Aseguradora aseguradora,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		aseguradora.setcodigo(aseguradora.getcodigo().trim());
		aseguradora.setnombre(aseguradora.getnombre().trim());
		aseguradora.setdireccion(aseguradora.getdireccion().trim());
		aseguradora.settelefono(aseguradora.gettelefono().trim());
	}
	
	public static void quitarEspaciosAseguradoras(List<Aseguradora> aseguradoras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Aseguradora aseguradora: aseguradoras) {
			aseguradora.setcodigo(aseguradora.getcodigo().trim());
			aseguradora.setnombre(aseguradora.getnombre().trim());
			aseguradora.setdireccion(aseguradora.getdireccion().trim());
			aseguradora.settelefono(aseguradora.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAseguradora(Aseguradora aseguradora,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && aseguradora.getConCambioAuxiliar()) {
			aseguradora.setIsDeleted(aseguradora.getIsDeletedAuxiliar());	
			aseguradora.setIsNew(aseguradora.getIsNewAuxiliar());	
			aseguradora.setIsChanged(aseguradora.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			aseguradora.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			aseguradora.setIsDeletedAuxiliar(false);	
			aseguradora.setIsNewAuxiliar(false);	
			aseguradora.setIsChangedAuxiliar(false);
			
			aseguradora.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAseguradoras(List<Aseguradora> aseguradoras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Aseguradora aseguradora : aseguradoras) {
			if(conAsignarBase && aseguradora.getConCambioAuxiliar()) {
				aseguradora.setIsDeleted(aseguradora.getIsDeletedAuxiliar());	
				aseguradora.setIsNew(aseguradora.getIsNewAuxiliar());	
				aseguradora.setIsChanged(aseguradora.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				aseguradora.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				aseguradora.setIsDeletedAuxiliar(false);	
				aseguradora.setIsNewAuxiliar(false);	
				aseguradora.setIsChangedAuxiliar(false);
				
				aseguradora.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAseguradora(Aseguradora aseguradora,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAseguradoras(List<Aseguradora> aseguradoras,Boolean conEnteros) throws Exception  {
		
		for(Aseguradora aseguradora: aseguradoras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAseguradora(List<Aseguradora> aseguradoras,Aseguradora aseguradoraAux) throws Exception  {
		AseguradoraConstantesFunciones.InicializarValoresAseguradora(aseguradoraAux,true);
		
		for(Aseguradora aseguradora: aseguradoras) {
			if(aseguradora.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAseguradora(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AseguradoraConstantesFunciones.getArrayColumnasGlobalesAseguradora(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAseguradora(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AseguradoraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AseguradoraConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAseguradora(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Aseguradora> aseguradoras,Aseguradora aseguradora,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Aseguradora aseguradoraAux: aseguradoras) {
			if(aseguradoraAux!=null && aseguradora!=null) {
				if((aseguradoraAux.getId()==null && aseguradora.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(aseguradoraAux.getId()!=null && aseguradora.getId()!=null){
					if(aseguradoraAux.getId().equals(aseguradora.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAseguradora(List<Aseguradora> aseguradoras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Aseguradora aseguradora: aseguradoras) {			
			if(aseguradora.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAseguradora() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_ID, AseguradoraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_VERSIONROW, AseguradoraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_IDEMPRESA, AseguradoraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_CODIGO, AseguradoraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_NOMBRE, AseguradoraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_DIRECCION, AseguradoraConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AseguradoraConstantesFunciones.LABEL_TELEFONO, AseguradoraConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAseguradora() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AseguradoraConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAseguradora() throws Exception  {
		return AseguradoraConstantesFunciones.getTiposSeleccionarAseguradora(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAseguradora(Boolean conFk) throws Exception  {
		return AseguradoraConstantesFunciones.getTiposSeleccionarAseguradora(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAseguradora(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AseguradoraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AseguradoraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AseguradoraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AseguradoraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AseguradoraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AseguradoraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AseguradoraConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(AseguradoraConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AseguradoraConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(AseguradoraConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAseguradora(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAseguradora(Aseguradora aseguradoraAux) throws Exception {
		
			aseguradoraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(aseguradoraAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAseguradora(List<Aseguradora> aseguradorasTemp) throws Exception {
		for(Aseguradora aseguradoraAux:aseguradorasTemp) {
			
			aseguradoraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(aseguradoraAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAseguradora(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAseguradora(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAseguradora(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AseguradoraConstantesFunciones.getClassesRelationshipsOfAseguradora(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAseguradora(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Vehiculo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Vehiculo.class)) {
						classes.add(new Classe(Vehiculo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAseguradora(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AseguradoraConstantesFunciones.getClassesRelationshipsFromStringsOfAseguradora(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAseguradora(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
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
	public static void actualizarLista(Aseguradora aseguradora,List<Aseguradora> aseguradoras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Aseguradora aseguradoraEncontrado=null;
			
			for(Aseguradora aseguradoraLocal:aseguradoras) {
				if(aseguradoraLocal.getId().equals(aseguradora.getId())) {
					aseguradoraEncontrado=aseguradoraLocal;
					
					aseguradoraLocal.setIsChanged(aseguradora.getIsChanged());
					aseguradoraLocal.setIsNew(aseguradora.getIsNew());
					aseguradoraLocal.setIsDeleted(aseguradora.getIsDeleted());
					
					aseguradoraLocal.setGeneralEntityOriginal(aseguradora.getGeneralEntityOriginal());
					
					aseguradoraLocal.setId(aseguradora.getId());	
					aseguradoraLocal.setVersionRow(aseguradora.getVersionRow());	
					aseguradoraLocal.setid_empresa(aseguradora.getid_empresa());	
					aseguradoraLocal.setcodigo(aseguradora.getcodigo());	
					aseguradoraLocal.setnombre(aseguradora.getnombre());	
					aseguradoraLocal.setdireccion(aseguradora.getdireccion());	
					aseguradoraLocal.settelefono(aseguradora.gettelefono());	
					
					
					aseguradoraLocal.setVehiculos(aseguradora.getVehiculos());
					
					existe=true;
					break;
				}
			}
			
			if(!aseguradora.getIsDeleted()) {
				if(!existe) {
					aseguradoras.add(aseguradora);
				}
			} else {
				if(aseguradoraEncontrado!=null && permiteQuitar)  {
					aseguradoras.remove(aseguradoraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Aseguradora aseguradora,List<Aseguradora> aseguradoras) throws Exception {
		try	{			
			for(Aseguradora aseguradoraLocal:aseguradoras) {
				if(aseguradoraLocal.getId().equals(aseguradora.getId())) {
					aseguradoraLocal.setIsSelected(aseguradora.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAseguradora(List<Aseguradora> aseguradorasAux) throws Exception {
		//this.aseguradorasAux=aseguradorasAux;
		
		for(Aseguradora aseguradoraAux:aseguradorasAux) {
			if(aseguradoraAux.getIsChanged()) {
				aseguradoraAux.setIsChanged(false);
			}		
			
			if(aseguradoraAux.getIsNew()) {
				aseguradoraAux.setIsNew(false);
			}	
			
			if(aseguradoraAux.getIsDeleted()) {
				aseguradoraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAseguradora(Aseguradora aseguradoraAux) throws Exception {
		//this.aseguradoraAux=aseguradoraAux;
		
			if(aseguradoraAux.getIsChanged()) {
				aseguradoraAux.setIsChanged(false);
			}		
			
			if(aseguradoraAux.getIsNew()) {
				aseguradoraAux.setIsNew(false);
			}	
			
			if(aseguradoraAux.getIsDeleted()) {
				aseguradoraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Aseguradora aseguradoraAsignar,Aseguradora aseguradora) throws Exception {
		aseguradoraAsignar.setId(aseguradora.getId());	
		aseguradoraAsignar.setVersionRow(aseguradora.getVersionRow());	
		aseguradoraAsignar.setid_empresa(aseguradora.getid_empresa());
		aseguradoraAsignar.setempresa_descripcion(aseguradora.getempresa_descripcion());	
		aseguradoraAsignar.setcodigo(aseguradora.getcodigo());	
		aseguradoraAsignar.setnombre(aseguradora.getnombre());	
		aseguradoraAsignar.setdireccion(aseguradora.getdireccion());	
		aseguradoraAsignar.settelefono(aseguradora.gettelefono());	
	}
	
	public static void inicializarAseguradora(Aseguradora aseguradora) throws Exception {
		try {
				aseguradora.setId(0L);	
					
				aseguradora.setid_empresa(-1L);	
				aseguradora.setcodigo("");	
				aseguradora.setnombre("");	
				aseguradora.setdireccion("");	
				aseguradora.settelefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAseguradora(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AseguradoraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AseguradoraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AseguradoraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AseguradoraConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AseguradoraConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAseguradora(String sTipo,Row row,Workbook workbook,Aseguradora aseguradora,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(aseguradora.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(aseguradora.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(aseguradora.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(aseguradora.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(aseguradora.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAseguradora=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAseguradora() {
		return this.sFinalQueryAseguradora;
	}
	
	public void setsFinalQueryAseguradora(String sFinalQueryAseguradora) {
		this.sFinalQueryAseguradora= sFinalQueryAseguradora;
	}
	
	public Border resaltarSeleccionarAseguradora=null;
	
	public Border setResaltarSeleccionarAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAseguradora= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAseguradora() {
		return this.resaltarSeleccionarAseguradora;
	}
	
	public void setResaltarSeleccionarAseguradora(Border borderResaltarSeleccionarAseguradora) {
		this.resaltarSeleccionarAseguradora= borderResaltarSeleccionarAseguradora;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAseguradora=null;
	public Boolean mostraridAseguradora=true;
	public Boolean activaridAseguradora=true;

	public Border resaltarid_empresaAseguradora=null;
	public Boolean mostrarid_empresaAseguradora=true;
	public Boolean activarid_empresaAseguradora=true;
	public Boolean cargarid_empresaAseguradora=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAseguradora=false;//ConEventDepend=true

	public Border resaltarcodigoAseguradora=null;
	public Boolean mostrarcodigoAseguradora=true;
	public Boolean activarcodigoAseguradora=true;

	public Border resaltarnombreAseguradora=null;
	public Boolean mostrarnombreAseguradora=true;
	public Boolean activarnombreAseguradora=true;

	public Border resaltardireccionAseguradora=null;
	public Boolean mostrardireccionAseguradora=true;
	public Boolean activardireccionAseguradora=true;

	public Border resaltartelefonoAseguradora=null;
	public Boolean mostrartelefonoAseguradora=true;
	public Boolean activartelefonoAseguradora=true;

	
	

	public Border setResaltaridAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltaridAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAseguradora() {
		return this.resaltaridAseguradora;
	}

	public void setResaltaridAseguradora(Border borderResaltar) {
		this.resaltaridAseguradora= borderResaltar;
	}

	public Boolean getMostraridAseguradora() {
		return this.mostraridAseguradora;
	}

	public void setMostraridAseguradora(Boolean mostraridAseguradora) {
		this.mostraridAseguradora= mostraridAseguradora;
	}

	public Boolean getActivaridAseguradora() {
		return this.activaridAseguradora;
	}

	public void setActivaridAseguradora(Boolean activaridAseguradora) {
		this.activaridAseguradora= activaridAseguradora;
	}

	public Border setResaltarid_empresaAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltarid_empresaAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAseguradora() {
		return this.resaltarid_empresaAseguradora;
	}

	public void setResaltarid_empresaAseguradora(Border borderResaltar) {
		this.resaltarid_empresaAseguradora= borderResaltar;
	}

	public Boolean getMostrarid_empresaAseguradora() {
		return this.mostrarid_empresaAseguradora;
	}

	public void setMostrarid_empresaAseguradora(Boolean mostrarid_empresaAseguradora) {
		this.mostrarid_empresaAseguradora= mostrarid_empresaAseguradora;
	}

	public Boolean getActivarid_empresaAseguradora() {
		return this.activarid_empresaAseguradora;
	}

	public void setActivarid_empresaAseguradora(Boolean activarid_empresaAseguradora) {
		this.activarid_empresaAseguradora= activarid_empresaAseguradora;
	}

	public Boolean getCargarid_empresaAseguradora() {
		return this.cargarid_empresaAseguradora;
	}

	public void setCargarid_empresaAseguradora(Boolean cargarid_empresaAseguradora) {
		this.cargarid_empresaAseguradora= cargarid_empresaAseguradora;
	}

	public Border setResaltarcodigoAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltarcodigoAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAseguradora() {
		return this.resaltarcodigoAseguradora;
	}

	public void setResaltarcodigoAseguradora(Border borderResaltar) {
		this.resaltarcodigoAseguradora= borderResaltar;
	}

	public Boolean getMostrarcodigoAseguradora() {
		return this.mostrarcodigoAseguradora;
	}

	public void setMostrarcodigoAseguradora(Boolean mostrarcodigoAseguradora) {
		this.mostrarcodigoAseguradora= mostrarcodigoAseguradora;
	}

	public Boolean getActivarcodigoAseguradora() {
		return this.activarcodigoAseguradora;
	}

	public void setActivarcodigoAseguradora(Boolean activarcodigoAseguradora) {
		this.activarcodigoAseguradora= activarcodigoAseguradora;
	}

	public Border setResaltarnombreAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltarnombreAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAseguradora() {
		return this.resaltarnombreAseguradora;
	}

	public void setResaltarnombreAseguradora(Border borderResaltar) {
		this.resaltarnombreAseguradora= borderResaltar;
	}

	public Boolean getMostrarnombreAseguradora() {
		return this.mostrarnombreAseguradora;
	}

	public void setMostrarnombreAseguradora(Boolean mostrarnombreAseguradora) {
		this.mostrarnombreAseguradora= mostrarnombreAseguradora;
	}

	public Boolean getActivarnombreAseguradora() {
		return this.activarnombreAseguradora;
	}

	public void setActivarnombreAseguradora(Boolean activarnombreAseguradora) {
		this.activarnombreAseguradora= activarnombreAseguradora;
	}

	public Border setResaltardireccionAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltardireccionAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionAseguradora() {
		return this.resaltardireccionAseguradora;
	}

	public void setResaltardireccionAseguradora(Border borderResaltar) {
		this.resaltardireccionAseguradora= borderResaltar;
	}

	public Boolean getMostrardireccionAseguradora() {
		return this.mostrardireccionAseguradora;
	}

	public void setMostrardireccionAseguradora(Boolean mostrardireccionAseguradora) {
		this.mostrardireccionAseguradora= mostrardireccionAseguradora;
	}

	public Boolean getActivardireccionAseguradora() {
		return this.activardireccionAseguradora;
	}

	public void setActivardireccionAseguradora(Boolean activardireccionAseguradora) {
		this.activardireccionAseguradora= activardireccionAseguradora;
	}

	public Border setResaltartelefonoAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltar);
		
		this.resaltartelefonoAseguradora= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoAseguradora() {
		return this.resaltartelefonoAseguradora;
	}

	public void setResaltartelefonoAseguradora(Border borderResaltar) {
		this.resaltartelefonoAseguradora= borderResaltar;
	}

	public Boolean getMostrartelefonoAseguradora() {
		return this.mostrartelefonoAseguradora;
	}

	public void setMostrartelefonoAseguradora(Boolean mostrartelefonoAseguradora) {
		this.mostrartelefonoAseguradora= mostrartelefonoAseguradora;
	}

	public Boolean getActivartelefonoAseguradora() {
		return this.activartelefonoAseguradora;
	}

	public void setActivartelefonoAseguradora(Boolean activartelefonoAseguradora) {
		this.activartelefonoAseguradora= activartelefonoAseguradora;
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
		
		
		this.setMostraridAseguradora(esInicial);
		this.setMostrarid_empresaAseguradora(esInicial);
		this.setMostrarcodigoAseguradora(esInicial);
		this.setMostrarnombreAseguradora(esInicial);
		this.setMostrardireccionAseguradora(esInicial);
		this.setMostrartelefonoAseguradora(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AseguradoraConstantesFunciones.ID)) {
				this.setMostraridAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoAseguradora(esAsigna);
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
		
		
		this.setActivaridAseguradora(esInicial);
		this.setActivarid_empresaAseguradora(esInicial);
		this.setActivarcodigoAseguradora(esInicial);
		this.setActivarnombreAseguradora(esInicial);
		this.setActivardireccionAseguradora(esInicial);
		this.setActivartelefonoAseguradora(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AseguradoraConstantesFunciones.ID)) {
				this.setActivaridAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.DIRECCION)) {
				this.setActivardireccionAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoAseguradora(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAseguradora(esInicial);
		this.setResaltarid_empresaAseguradora(esInicial);
		this.setResaltarcodigoAseguradora(esInicial);
		this.setResaltarnombreAseguradora(esInicial);
		this.setResaltardireccionAseguradora(esInicial);
		this.setResaltartelefonoAseguradora(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AseguradoraConstantesFunciones.ID)) {
				this.setResaltaridAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionAseguradora(esAsigna);
				continue;
			}

			if(campo.clase.equals(AseguradoraConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoAseguradora(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarVehiculoAseguradora=null;

	public Border getResaltarVehiculoAseguradora() {
		return this.resaltarVehiculoAseguradora;
	}

	public void setResaltarVehiculoAseguradora(Border borderResaltarVehiculo) {
		if(borderResaltarVehiculo!=null) {
			this.resaltarVehiculoAseguradora= borderResaltarVehiculo;
		}
	}

	public Border setResaltarVehiculoAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltarVehiculo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//aseguradoraBeanSwingJInternalFrame.jTtoolBarAseguradora.setBorder(borderResaltarVehiculo);
			
		this.resaltarVehiculoAseguradora= borderResaltarVehiculo;

		 return borderResaltarVehiculo;
	}



	public Boolean mostrarVehiculoAseguradora=true;

	public Boolean getMostrarVehiculoAseguradora() {
		return this.mostrarVehiculoAseguradora;
	}

	public void setMostrarVehiculoAseguradora(Boolean visibilidadResaltarVehiculo) {
		this.mostrarVehiculoAseguradora= visibilidadResaltarVehiculo;
	}



	public Boolean activarVehiculoAseguradora=true;

	public Boolean gethabilitarResaltarVehiculoAseguradora() {
		return this.activarVehiculoAseguradora;
	}

	public void setActivarVehiculoAseguradora(Boolean habilitarResaltarVehiculo) {
		this.activarVehiculoAseguradora= habilitarResaltarVehiculo;
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

		this.setMostrarVehiculoAseguradora(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Vehiculo.class)) {
				this.setMostrarVehiculoAseguradora(esAsigna);
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

		this.setActivarVehiculoAseguradora(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Vehiculo.class)) {
				this.setActivarVehiculoAseguradora(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarVehiculoAseguradora(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Vehiculo.class)) {
				this.setResaltarVehiculoAseguradora(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaAseguradora=true;

	public Boolean getMostrarFK_IdEmpresaAseguradora() {
		return this.mostrarFK_IdEmpresaAseguradora;
	}

	public void setMostrarFK_IdEmpresaAseguradora(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAseguradora= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaAseguradora=true;

	public Boolean getActivarFK_IdEmpresaAseguradora() {
		return this.activarFK_IdEmpresaAseguradora;
	}

	public void setActivarFK_IdEmpresaAseguradora(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAseguradora= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaAseguradora=null;

	public Border getResaltarFK_IdEmpresaAseguradora() {
		return this.resaltarFK_IdEmpresaAseguradora;
	}

	public void setResaltarFK_IdEmpresaAseguradora(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAseguradora= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAseguradora(ParametroGeneralUsuario parametroGeneralUsuario/*AseguradoraBeanSwingJInternalFrame aseguradoraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAseguradora= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}