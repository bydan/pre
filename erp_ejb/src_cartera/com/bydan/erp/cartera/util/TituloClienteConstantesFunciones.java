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


import com.bydan.erp.cartera.util.TituloClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TituloClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TituloClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TituloClienteConstantesFunciones extends TituloClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TituloCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TituloCliente"+TituloClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TituloClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TituloClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TituloClienteConstantesFunciones.SCHEMA+"_"+TituloClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TituloClienteConstantesFunciones.SCHEMA+"_"+TituloClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TituloClienteConstantesFunciones.SCHEMA+"_"+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TituloClienteConstantesFunciones.SCHEMA+"_"+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TituloClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TituloClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TituloClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TituloClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TituloClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TituloClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Comercial Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Comercial Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Titulo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TituloCliente";
	public static final String OBJECTNAME="titulocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="titulo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select titulocliente from "+TituloClienteConstantesFunciones.SPERSISTENCENAME+" titulocliente";
	public static String QUERYSELECTNATIVE="select "+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".id,"+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".version_row,"+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".id_empresa,"+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".codigo,"+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".nombre,"+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME+".siglas from "+TituloClienteConstantesFunciones.SCHEMA+"."+TituloClienteConstantesFunciones.TABLENAME;//+" as "+TituloClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TituloClienteConstantesFuncionesAdditional tituloclienteConstantesFuncionesAdditional=null;
	
	public TituloClienteConstantesFuncionesAdditional getTituloClienteConstantesFuncionesAdditional() {
		return this.tituloclienteConstantesFuncionesAdditional;
	}
	
	public void setTituloClienteConstantesFuncionesAdditional(TituloClienteConstantesFuncionesAdditional tituloclienteConstantesFuncionesAdditional) {
		try {
			this.tituloclienteConstantesFuncionesAdditional=tituloclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
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
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTituloClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TituloClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TituloClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TituloClienteConstantesFunciones.CODIGO)) {sLabelColumna=TituloClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TituloClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TituloClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TituloClienteConstantesFunciones.SIGLAS)) {sLabelColumna=TituloClienteConstantesFunciones.LABEL_SIGLAS;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTituloClienteDescripcion(TituloCliente titulocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(titulocliente !=null/* && titulocliente.getId()!=0*/) {
			sDescripcion=titulocliente.getnombre();//tituloclientetitulocliente.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTituloClienteDescripcionDetallado(TituloCliente titulocliente) {
		String sDescripcion="";
			
		sDescripcion+=TituloClienteConstantesFunciones.ID+"=";
		sDescripcion+=titulocliente.getId().toString()+",";
		sDescripcion+=TituloClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=titulocliente.getVersionRow().toString()+",";
		sDescripcion+=TituloClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=titulocliente.getid_empresa().toString()+",";
		sDescripcion+=TituloClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=titulocliente.getcodigo()+",";
		sDescripcion+=TituloClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=titulocliente.getnombre()+",";
		sDescripcion+=TituloClienteConstantesFunciones.SIGLAS+"=";
		sDescripcion+=titulocliente.getsiglas()+",";
			
		return sDescripcion;
	}
	
	public static void setTituloClienteDescripcion(TituloCliente titulocliente,String sValor) throws Exception {			
		if(titulocliente !=null) {
			titulocliente.setnombre(sValor);;//tituloclientetitulocliente.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorIdEmpresaPorCodigo")) {
			sNombreIndice="Tipo=  Por Empresa Por Codigo";
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

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdEmpresaPorCodigo(Long id_empresa,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTituloCliente(TituloCliente titulocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		titulocliente.setcodigo(titulocliente.getcodigo().trim());
		titulocliente.setnombre(titulocliente.getnombre().trim());
		titulocliente.setsiglas(titulocliente.getsiglas().trim());
	}
	
	public static void quitarEspaciosTituloClientes(List<TituloCliente> tituloclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TituloCliente titulocliente: tituloclientes) {
			titulocliente.setcodigo(titulocliente.getcodigo().trim());
			titulocliente.setnombre(titulocliente.getnombre().trim());
			titulocliente.setsiglas(titulocliente.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTituloCliente(TituloCliente titulocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && titulocliente.getConCambioAuxiliar()) {
			titulocliente.setIsDeleted(titulocliente.getIsDeletedAuxiliar());	
			titulocliente.setIsNew(titulocliente.getIsNewAuxiliar());	
			titulocliente.setIsChanged(titulocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			titulocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			titulocliente.setIsDeletedAuxiliar(false);	
			titulocliente.setIsNewAuxiliar(false);	
			titulocliente.setIsChangedAuxiliar(false);
			
			titulocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTituloClientes(List<TituloCliente> tituloclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TituloCliente titulocliente : tituloclientes) {
			if(conAsignarBase && titulocliente.getConCambioAuxiliar()) {
				titulocliente.setIsDeleted(titulocliente.getIsDeletedAuxiliar());	
				titulocliente.setIsNew(titulocliente.getIsNewAuxiliar());	
				titulocliente.setIsChanged(titulocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				titulocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				titulocliente.setIsDeletedAuxiliar(false);	
				titulocliente.setIsNewAuxiliar(false);	
				titulocliente.setIsChangedAuxiliar(false);
				
				titulocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTituloCliente(TituloCliente titulocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTituloClientes(List<TituloCliente> tituloclientes,Boolean conEnteros) throws Exception  {
		
		for(TituloCliente titulocliente: tituloclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTituloCliente(List<TituloCliente> tituloclientes,TituloCliente tituloclienteAux) throws Exception  {
		TituloClienteConstantesFunciones.InicializarValoresTituloCliente(tituloclienteAux,true);
		
		for(TituloCliente titulocliente: tituloclientes) {
			if(titulocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TituloClienteConstantesFunciones.getArrayColumnasGlobalesTituloCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TituloClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TituloClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTituloCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TituloCliente> tituloclientes,TituloCliente titulocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TituloCliente tituloclienteAux: tituloclientes) {
			if(tituloclienteAux!=null && titulocliente!=null) {
				if((tituloclienteAux.getId()==null && titulocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tituloclienteAux.getId()!=null && titulocliente.getId()!=null){
					if(tituloclienteAux.getId().equals(titulocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTituloCliente(List<TituloCliente> tituloclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TituloCliente titulocliente: tituloclientes) {			
			if(titulocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTituloCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_ID, TituloClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_VERSIONROW, TituloClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_IDEMPRESA, TituloClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_CODIGO, TituloClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_NOMBRE, TituloClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TituloClienteConstantesFunciones.LABEL_SIGLAS, TituloClienteConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTituloCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TituloClienteConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTituloCliente() throws Exception  {
		return TituloClienteConstantesFunciones.getTiposSeleccionarTituloCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTituloCliente(Boolean conFk) throws Exception  {
		return TituloClienteConstantesFunciones.getTiposSeleccionarTituloCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTituloCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TituloClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TituloClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TituloClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TituloClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TituloClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TituloClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TituloClienteConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(TituloClienteConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTituloCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTituloCliente(TituloCliente tituloclienteAux) throws Exception {
		
			tituloclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tituloclienteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTituloCliente(List<TituloCliente> tituloclientesTemp) throws Exception {
		for(TituloCliente tituloclienteAux:tituloclientesTemp) {
			
			tituloclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tituloclienteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TituloClienteConstantesFunciones.getClassesRelationshipsOfTituloCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTituloCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TituloClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTituloCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTituloCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	public static void actualizarLista(TituloCliente titulocliente,List<TituloCliente> tituloclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TituloCliente tituloclienteEncontrado=null;
			
			for(TituloCliente tituloclienteLocal:tituloclientes) {
				if(tituloclienteLocal.getId().equals(titulocliente.getId())) {
					tituloclienteEncontrado=tituloclienteLocal;
					
					tituloclienteLocal.setIsChanged(titulocliente.getIsChanged());
					tituloclienteLocal.setIsNew(titulocliente.getIsNew());
					tituloclienteLocal.setIsDeleted(titulocliente.getIsDeleted());
					
					tituloclienteLocal.setGeneralEntityOriginal(titulocliente.getGeneralEntityOriginal());
					
					tituloclienteLocal.setId(titulocliente.getId());	
					tituloclienteLocal.setVersionRow(titulocliente.getVersionRow());	
					tituloclienteLocal.setid_empresa(titulocliente.getid_empresa());	
					tituloclienteLocal.setcodigo(titulocliente.getcodigo());	
					tituloclienteLocal.setnombre(titulocliente.getnombre());	
					tituloclienteLocal.setsiglas(titulocliente.getsiglas());	
					
					
					tituloclienteLocal.setClientes(titulocliente.getClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!titulocliente.getIsDeleted()) {
				if(!existe) {
					tituloclientes.add(titulocliente);
				}
			} else {
				if(tituloclienteEncontrado!=null && permiteQuitar)  {
					tituloclientes.remove(tituloclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TituloCliente titulocliente,List<TituloCliente> tituloclientes) throws Exception {
		try	{			
			for(TituloCliente tituloclienteLocal:tituloclientes) {
				if(tituloclienteLocal.getId().equals(titulocliente.getId())) {
					tituloclienteLocal.setIsSelected(titulocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTituloCliente(List<TituloCliente> tituloclientesAux) throws Exception {
		//this.tituloclientesAux=tituloclientesAux;
		
		for(TituloCliente tituloclienteAux:tituloclientesAux) {
			if(tituloclienteAux.getIsChanged()) {
				tituloclienteAux.setIsChanged(false);
			}		
			
			if(tituloclienteAux.getIsNew()) {
				tituloclienteAux.setIsNew(false);
			}	
			
			if(tituloclienteAux.getIsDeleted()) {
				tituloclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTituloCliente(TituloCliente tituloclienteAux) throws Exception {
		//this.tituloclienteAux=tituloclienteAux;
		
			if(tituloclienteAux.getIsChanged()) {
				tituloclienteAux.setIsChanged(false);
			}		
			
			if(tituloclienteAux.getIsNew()) {
				tituloclienteAux.setIsNew(false);
			}	
			
			if(tituloclienteAux.getIsDeleted()) {
				tituloclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TituloCliente tituloclienteAsignar,TituloCliente titulocliente) throws Exception {
		tituloclienteAsignar.setId(titulocliente.getId());	
		tituloclienteAsignar.setVersionRow(titulocliente.getVersionRow());	
		tituloclienteAsignar.setid_empresa(titulocliente.getid_empresa());
		tituloclienteAsignar.setempresa_descripcion(titulocliente.getempresa_descripcion());	
		tituloclienteAsignar.setcodigo(titulocliente.getcodigo());	
		tituloclienteAsignar.setnombre(titulocliente.getnombre());	
		tituloclienteAsignar.setsiglas(titulocliente.getsiglas());	
	}
	
	public static void inicializarTituloCliente(TituloCliente titulocliente) throws Exception {
		try {
				titulocliente.setId(0L);	
					
				titulocliente.setid_empresa(-1L);	
				titulocliente.setcodigo("");	
				titulocliente.setnombre("");	
				titulocliente.setsiglas("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTituloCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TituloClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TituloClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TituloClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TituloClienteConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTituloCliente(String sTipo,Row row,Workbook workbook,TituloCliente titulocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(titulocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(titulocliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(titulocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(titulocliente.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTituloCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTituloCliente() {
		return this.sFinalQueryTituloCliente;
	}
	
	public void setsFinalQueryTituloCliente(String sFinalQueryTituloCliente) {
		this.sFinalQueryTituloCliente= sFinalQueryTituloCliente;
	}
	
	public Border resaltarSeleccionarTituloCliente=null;
	
	public Border setResaltarSeleccionarTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTituloCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTituloCliente() {
		return this.resaltarSeleccionarTituloCliente;
	}
	
	public void setResaltarSeleccionarTituloCliente(Border borderResaltarSeleccionarTituloCliente) {
		this.resaltarSeleccionarTituloCliente= borderResaltarSeleccionarTituloCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTituloCliente=null;
	public Boolean mostraridTituloCliente=true;
	public Boolean activaridTituloCliente=true;

	public Border resaltarid_empresaTituloCliente=null;
	public Boolean mostrarid_empresaTituloCliente=true;
	public Boolean activarid_empresaTituloCliente=true;
	public Boolean cargarid_empresaTituloCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTituloCliente=false;//ConEventDepend=true

	public Border resaltarcodigoTituloCliente=null;
	public Boolean mostrarcodigoTituloCliente=true;
	public Boolean activarcodigoTituloCliente=true;

	public Border resaltarnombreTituloCliente=null;
	public Boolean mostrarnombreTituloCliente=true;
	public Boolean activarnombreTituloCliente=true;

	public Border resaltarsiglasTituloCliente=null;
	public Boolean mostrarsiglasTituloCliente=true;
	public Boolean activarsiglasTituloCliente=true;

	
	

	public Border setResaltaridTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltaridTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTituloCliente() {
		return this.resaltaridTituloCliente;
	}

	public void setResaltaridTituloCliente(Border borderResaltar) {
		this.resaltaridTituloCliente= borderResaltar;
	}

	public Boolean getMostraridTituloCliente() {
		return this.mostraridTituloCliente;
	}

	public void setMostraridTituloCliente(Boolean mostraridTituloCliente) {
		this.mostraridTituloCliente= mostraridTituloCliente;
	}

	public Boolean getActivaridTituloCliente() {
		return this.activaridTituloCliente;
	}

	public void setActivaridTituloCliente(Boolean activaridTituloCliente) {
		this.activaridTituloCliente= activaridTituloCliente;
	}

	public Border setResaltarid_empresaTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTituloCliente() {
		return this.resaltarid_empresaTituloCliente;
	}

	public void setResaltarid_empresaTituloCliente(Border borderResaltar) {
		this.resaltarid_empresaTituloCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaTituloCliente() {
		return this.mostrarid_empresaTituloCliente;
	}

	public void setMostrarid_empresaTituloCliente(Boolean mostrarid_empresaTituloCliente) {
		this.mostrarid_empresaTituloCliente= mostrarid_empresaTituloCliente;
	}

	public Boolean getActivarid_empresaTituloCliente() {
		return this.activarid_empresaTituloCliente;
	}

	public void setActivarid_empresaTituloCliente(Boolean activarid_empresaTituloCliente) {
		this.activarid_empresaTituloCliente= activarid_empresaTituloCliente;
	}

	public Boolean getCargarid_empresaTituloCliente() {
		return this.cargarid_empresaTituloCliente;
	}

	public void setCargarid_empresaTituloCliente(Boolean cargarid_empresaTituloCliente) {
		this.cargarid_empresaTituloCliente= cargarid_empresaTituloCliente;
	}

	public Border setResaltarcodigoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTituloCliente() {
		return this.resaltarcodigoTituloCliente;
	}

	public void setResaltarcodigoTituloCliente(Border borderResaltar) {
		this.resaltarcodigoTituloCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoTituloCliente() {
		return this.mostrarcodigoTituloCliente;
	}

	public void setMostrarcodigoTituloCliente(Boolean mostrarcodigoTituloCliente) {
		this.mostrarcodigoTituloCliente= mostrarcodigoTituloCliente;
	}

	public Boolean getActivarcodigoTituloCliente() {
		return this.activarcodigoTituloCliente;
	}

	public void setActivarcodigoTituloCliente(Boolean activarcodigoTituloCliente) {
		this.activarcodigoTituloCliente= activarcodigoTituloCliente;
	}

	public Border setResaltarnombreTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTituloCliente() {
		return this.resaltarnombreTituloCliente;
	}

	public void setResaltarnombreTituloCliente(Border borderResaltar) {
		this.resaltarnombreTituloCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTituloCliente() {
		return this.mostrarnombreTituloCliente;
	}

	public void setMostrarnombreTituloCliente(Boolean mostrarnombreTituloCliente) {
		this.mostrarnombreTituloCliente= mostrarnombreTituloCliente;
	}

	public Boolean getActivarnombreTituloCliente() {
		return this.activarnombreTituloCliente;
	}

	public void setActivarnombreTituloCliente(Boolean activarnombreTituloCliente) {
		this.activarnombreTituloCliente= activarnombreTituloCliente;
	}

	public Border setResaltarsiglasTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltar);
		
		this.resaltarsiglasTituloCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasTituloCliente() {
		return this.resaltarsiglasTituloCliente;
	}

	public void setResaltarsiglasTituloCliente(Border borderResaltar) {
		this.resaltarsiglasTituloCliente= borderResaltar;
	}

	public Boolean getMostrarsiglasTituloCliente() {
		return this.mostrarsiglasTituloCliente;
	}

	public void setMostrarsiglasTituloCliente(Boolean mostrarsiglasTituloCliente) {
		this.mostrarsiglasTituloCliente= mostrarsiglasTituloCliente;
	}

	public Boolean getActivarsiglasTituloCliente() {
		return this.activarsiglasTituloCliente;
	}

	public void setActivarsiglasTituloCliente(Boolean activarsiglasTituloCliente) {
		this.activarsiglasTituloCliente= activarsiglasTituloCliente;
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
		
		
		this.setMostraridTituloCliente(esInicial);
		this.setMostrarid_empresaTituloCliente(esInicial);
		this.setMostrarcodigoTituloCliente(esInicial);
		this.setMostrarnombreTituloCliente(esInicial);
		this.setMostrarsiglasTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TituloClienteConstantesFunciones.ID)) {
				this.setMostraridTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasTituloCliente(esAsigna);
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
		
		
		this.setActivaridTituloCliente(esInicial);
		this.setActivarid_empresaTituloCliente(esInicial);
		this.setActivarcodigoTituloCliente(esInicial);
		this.setActivarnombreTituloCliente(esInicial);
		this.setActivarsiglasTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TituloClienteConstantesFunciones.ID)) {
				this.setActivaridTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasTituloCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTituloCliente(esInicial);
		this.setResaltarid_empresaTituloCliente(esInicial);
		this.setResaltarcodigoTituloCliente(esInicial);
		this.setResaltarnombreTituloCliente(esInicial);
		this.setResaltarsiglasTituloCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TituloClienteConstantesFunciones.ID)) {
				this.setResaltaridTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTituloCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TituloClienteConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasTituloCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTituloCliente=null;

	public Border getResaltarClienteTituloCliente() {
		return this.resaltarClienteTituloCliente;
	}

	public void setResaltarClienteTituloCliente(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTituloCliente= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tituloclienteBeanSwingJInternalFrame.jTtoolBarTituloCliente.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTituloCliente= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTituloCliente=true;

	public Boolean getMostrarClienteTituloCliente() {
		return this.mostrarClienteTituloCliente;
	}

	public void setMostrarClienteTituloCliente(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTituloCliente= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTituloCliente=true;

	public Boolean gethabilitarResaltarClienteTituloCliente() {
		return this.activarClienteTituloCliente;
	}

	public void setActivarClienteTituloCliente(Boolean habilitarResaltarCliente) {
		this.activarClienteTituloCliente= habilitarResaltarCliente;
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

		this.setMostrarClienteTituloCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTituloCliente(esAsigna);
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

		this.setActivarClienteTituloCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTituloCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTituloCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTituloCliente(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTituloCliente=true;

	public Boolean getMostrarBusquedaPorCodigoTituloCliente() {
		return this.mostrarBusquedaPorCodigoTituloCliente;
	}

	public void setMostrarBusquedaPorCodigoTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTituloCliente=true;

	public Boolean getMostrarBusquedaPorNombreTituloCliente() {
		return this.mostrarBusquedaPorNombreTituloCliente;
	}

	public void setMostrarBusquedaPorNombreTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasTituloCliente=true;

	public Boolean getMostrarBusquedaPorSiglasTituloCliente() {
		return this.mostrarBusquedaPorSiglasTituloCliente;
	}

	public void setMostrarBusquedaPorSiglasTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasTituloCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTituloCliente=true;

	public Boolean getMostrarFK_IdEmpresaTituloCliente() {
		return this.mostrarFK_IdEmpresaTituloCliente;
	}

	public void setMostrarFK_IdEmpresaTituloCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTituloCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTituloCliente=true;

	public Boolean getActivarBusquedaPorCodigoTituloCliente() {
		return this.activarBusquedaPorCodigoTituloCliente;
	}

	public void setActivarBusquedaPorCodigoTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTituloCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTituloCliente=true;

	public Boolean getActivarBusquedaPorNombreTituloCliente() {
		return this.activarBusquedaPorNombreTituloCliente;
	}

	public void setActivarBusquedaPorNombreTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTituloCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasTituloCliente=true;

	public Boolean getActivarBusquedaPorSiglasTituloCliente() {
		return this.activarBusquedaPorSiglasTituloCliente;
	}

	public void setActivarBusquedaPorSiglasTituloCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasTituloCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTituloCliente=true;

	public Boolean getActivarFK_IdEmpresaTituloCliente() {
		return this.activarFK_IdEmpresaTituloCliente;
	}

	public void setActivarFK_IdEmpresaTituloCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTituloCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTituloCliente=null;

	public Border getResaltarBusquedaPorCodigoTituloCliente() {
		return this.resaltarBusquedaPorCodigoTituloCliente;
	}

	public void setResaltarBusquedaPorCodigoTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTituloCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTituloCliente=null;

	public Border getResaltarBusquedaPorNombreTituloCliente() {
		return this.resaltarBusquedaPorNombreTituloCliente;
	}

	public void setResaltarBusquedaPorNombreTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTituloCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasTituloCliente=null;

	public Border getResaltarBusquedaPorSiglasTituloCliente() {
		return this.resaltarBusquedaPorSiglasTituloCliente;
	}

	public void setResaltarBusquedaPorSiglasTituloCliente(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasTituloCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasTituloCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTituloCliente=null;

	public Border getResaltarFK_IdEmpresaTituloCliente() {
		return this.resaltarFK_IdEmpresaTituloCliente;
	}

	public void setResaltarFK_IdEmpresaTituloCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTituloCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTituloCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TituloClienteBeanSwingJInternalFrame tituloclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTituloCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}