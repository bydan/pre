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


import com.bydan.erp.cartera.util.BienConstantesFunciones;
import com.bydan.erp.cartera.util.BienParameterReturnGeneral;
//import com.bydan.erp.cartera.util.BienParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BienConstantesFunciones extends BienConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Bien";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Bien"+BienConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BienHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BienHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BienConstantesFunciones.SCHEMA+"_"+BienConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BienHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BienConstantesFunciones.SCHEMA+"_"+BienConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BienConstantesFunciones.SCHEMA+"_"+BienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BienHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BienConstantesFunciones.SCHEMA+"_"+BienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BienConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BienHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BienConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BienHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BienConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BienConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BienConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BienConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bienes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Bien";
	public static final String SCLASSWEBTITULO_LOWER="Bien";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Bien";
	public static final String OBJECTNAME="bien";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="bien";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bien from "+BienConstantesFunciones.SPERSISTENCENAME+" bien";
	public static String QUERYSELECTNATIVE="select "+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".id,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".version_row,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".id_empresa,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".id_cliente,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".id_tipobien,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".numero,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".descripcion,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".valor_avaluo,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".direccion,"+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME+".es_activo from "+BienConstantesFunciones.SCHEMA+"."+BienConstantesFunciones.TABLENAME;//+" as "+BienConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BienConstantesFuncionesAdditional bienConstantesFuncionesAdditional=null;
	
	public BienConstantesFuncionesAdditional getBienConstantesFuncionesAdditional() {
		return this.bienConstantesFuncionesAdditional;
	}
	
	public void setBienConstantesFuncionesAdditional(BienConstantesFuncionesAdditional bienConstantesFuncionesAdditional) {
		try {
			this.bienConstantesFuncionesAdditional=bienConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOBIEN= "id_tipobien";
    public static final String NUMERO= "numero";
    public static final String DESCRIPCION= "descripcion";
    public static final String VALORAVALUO= "valor_avaluo";
    public static final String DIRECCION= "direccion";
    public static final String ESACTIVO= "es_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOBIEN= "Tipo Bien";
		public static final String LABEL_IDTIPOBIEN_LOWER= "Tipo Bien";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_VALORAVALUO= "Valor Avaluo";
		public static final String LABEL_VALORAVALUO_LOWER= "Valor Avaluo";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getBienLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BienConstantesFunciones.IDEMPRESA)) {sLabelColumna=BienConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BienConstantesFunciones.IDCLIENTE)) {sLabelColumna=BienConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(BienConstantesFunciones.IDTIPOBIEN)) {sLabelColumna=BienConstantesFunciones.LABEL_IDTIPOBIEN;}
		if(sNombreColumna.equals(BienConstantesFunciones.NUMERO)) {sLabelColumna=BienConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(BienConstantesFunciones.DESCRIPCION)) {sLabelColumna=BienConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(BienConstantesFunciones.VALORAVALUO)) {sLabelColumna=BienConstantesFunciones.LABEL_VALORAVALUO;}
		if(sNombreColumna.equals(BienConstantesFunciones.DIRECCION)) {sLabelColumna=BienConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(BienConstantesFunciones.ESACTIVO)) {sLabelColumna=BienConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_activoDescripcion(Bien bien) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bien.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(Bien bien) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bien.getId(),bien.getes_activo());

		return sDescripcion;
	}	
	
	public static String getBienDescripcion(Bien bien) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bien !=null/* && bien.getId()!=0*/) {
			if(bien.getId()!=null) {
				sDescripcion=bien.getId().toString();
			}//bienbien.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBienDescripcionDetallado(Bien bien) {
		String sDescripcion="";
			
		sDescripcion+=BienConstantesFunciones.ID+"=";
		sDescripcion+=bien.getId().toString()+",";
		sDescripcion+=BienConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bien.getVersionRow().toString()+",";
		sDescripcion+=BienConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bien.getid_empresa().toString()+",";
		sDescripcion+=BienConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=bien.getid_cliente().toString()+",";
		sDescripcion+=BienConstantesFunciones.IDTIPOBIEN+"=";
		sDescripcion+=bien.getid_tipobien().toString()+",";
		sDescripcion+=BienConstantesFunciones.NUMERO+"=";
		sDescripcion+=bien.getnumero()+",";
		sDescripcion+=BienConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=bien.getdescripcion()+",";
		sDescripcion+=BienConstantesFunciones.VALORAVALUO+"=";
		sDescripcion+=bien.getvalor_avaluo().toString()+",";
		sDescripcion+=BienConstantesFunciones.DIRECCION+"=";
		sDescripcion+=bien.getdireccion()+",";
		sDescripcion+=BienConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=bien.getes_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBienDescripcion(Bien bien,String sValor) throws Exception {			
		if(bien !=null) {
			//bienbien.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoBienDescripcion(TipoBien tipobien) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipobien!=null/*&&tipobien.getId()>0*/) {
			sDescripcion=TipoBienConstantesFunciones.getTipoBienDescripcion(tipobien);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdValorClienteTipoBien")) {
			sNombreIndice="Tipo=  Por Tipo Bien";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteTipoBien(Long id_tipobien) {
		String sDetalleIndice=" Parametros->";
		if(id_tipobien!=null) {sDetalleIndice+=" Codigo Unico De Tipo Bien="+id_tipobien.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBien(Bien bien,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bien.setnumero(bien.getnumero().trim());
		bien.setdescripcion(bien.getdescripcion().trim());
		bien.setdireccion(bien.getdireccion().trim());
	}
	
	public static void quitarEspaciosBiens(List<Bien> biens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Bien bien: biens) {
			bien.setnumero(bien.getnumero().trim());
			bien.setdescripcion(bien.getdescripcion().trim());
			bien.setdireccion(bien.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBien(Bien bien,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bien.getConCambioAuxiliar()) {
			bien.setIsDeleted(bien.getIsDeletedAuxiliar());	
			bien.setIsNew(bien.getIsNewAuxiliar());	
			bien.setIsChanged(bien.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bien.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bien.setIsDeletedAuxiliar(false);	
			bien.setIsNewAuxiliar(false);	
			bien.setIsChangedAuxiliar(false);
			
			bien.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBiens(List<Bien> biens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Bien bien : biens) {
			if(conAsignarBase && bien.getConCambioAuxiliar()) {
				bien.setIsDeleted(bien.getIsDeletedAuxiliar());	
				bien.setIsNew(bien.getIsNewAuxiliar());	
				bien.setIsChanged(bien.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bien.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bien.setIsDeletedAuxiliar(false);	
				bien.setIsNewAuxiliar(false);	
				bien.setIsChangedAuxiliar(false);
				
				bien.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBien(Bien bien,Boolean conEnteros) throws Exception  {
		bien.setvalor_avaluo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBiens(List<Bien> biens,Boolean conEnteros) throws Exception  {
		
		for(Bien bien: biens) {
			bien.setvalor_avaluo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBien(List<Bien> biens,Bien bienAux) throws Exception  {
		BienConstantesFunciones.InicializarValoresBien(bienAux,true);
		
		for(Bien bien: biens) {
			if(bien.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bienAux.setvalor_avaluo(bienAux.getvalor_avaluo()+bien.getvalor_avaluo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBien(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BienConstantesFunciones.getArrayColumnasGlobalesBien(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBien(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BienConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BienConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBien(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Bien> biens,Bien bien,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Bien bienAux: biens) {
			if(bienAux!=null && bien!=null) {
				if((bienAux.getId()==null && bien.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bienAux.getId()!=null && bien.getId()!=null){
					if(bienAux.getId().equals(bien.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBien(List<Bien> biens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_avaluoTotal=0.0;
	
		for(Bien bien: biens) {			
			if(bien.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_avaluoTotal+=bien.getvalor_avaluo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BienConstantesFunciones.VALORAVALUO);
		datoGeneral.setsDescripcion(BienConstantesFunciones.LABEL_VALORAVALUO);
		datoGeneral.setdValorDouble(valor_avaluoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBien() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_ID, BienConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_VERSIONROW, BienConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_IDEMPRESA, BienConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_IDCLIENTE, BienConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_IDTIPOBIEN, BienConstantesFunciones.IDTIPOBIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_NUMERO, BienConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_DESCRIPCION, BienConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_VALORAVALUO, BienConstantesFunciones.VALORAVALUO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_DIRECCION, BienConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BienConstantesFunciones.LABEL_ESACTIVO, BienConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBien() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.IDTIPOBIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.VALORAVALUO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BienConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBien() throws Exception  {
		return BienConstantesFunciones.getTiposSeleccionarBien(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBien(Boolean conFk) throws Exception  {
		return BienConstantesFunciones.getTiposSeleccionarBien(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBien(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_IDTIPOBIEN);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_IDTIPOBIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_VALORAVALUO);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_VALORAVALUO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BienConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(BienConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBien(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBien(Bien bienAux) throws Exception {
		
			bienAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bienAux.getEmpresa()));
			bienAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(bienAux.getCliente()));
			bienAux.settipobien_descripcion(TipoBienConstantesFunciones.getTipoBienDescripcion(bienAux.getTipoBien()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBien(List<Bien> biensTemp) throws Exception {
		for(Bien bienAux:biensTemp) {
			
			bienAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bienAux.getEmpresa()));
			bienAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(bienAux.getCliente()));
			bienAux.settipobien_descripcion(TipoBienConstantesFunciones.getTipoBienDescripcion(bienAux.getTipoBien()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoBien.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoBien.class)) {
						classes.add(new Classe(TipoBien.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoBien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBien.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoBien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBien.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BienConstantesFunciones.getClassesRelationshipsOfBien(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BienConstantesFunciones.getClassesRelationshipsFromStringsOfBien(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Bien bien,List<Bien> biens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Bien bienEncontrado=null;
			
			for(Bien bienLocal:biens) {
				if(bienLocal.getId().equals(bien.getId())) {
					bienEncontrado=bienLocal;
					
					bienLocal.setIsChanged(bien.getIsChanged());
					bienLocal.setIsNew(bien.getIsNew());
					bienLocal.setIsDeleted(bien.getIsDeleted());
					
					bienLocal.setGeneralEntityOriginal(bien.getGeneralEntityOriginal());
					
					bienLocal.setId(bien.getId());	
					bienLocal.setVersionRow(bien.getVersionRow());	
					bienLocal.setid_empresa(bien.getid_empresa());	
					bienLocal.setid_cliente(bien.getid_cliente());	
					bienLocal.setid_tipobien(bien.getid_tipobien());	
					bienLocal.setnumero(bien.getnumero());	
					bienLocal.setdescripcion(bien.getdescripcion());	
					bienLocal.setvalor_avaluo(bien.getvalor_avaluo());	
					bienLocal.setdireccion(bien.getdireccion());	
					bienLocal.setes_activo(bien.getes_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bien.getIsDeleted()) {
				if(!existe) {
					biens.add(bien);
				}
			} else {
				if(bienEncontrado!=null && permiteQuitar)  {
					biens.remove(bienEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Bien bien,List<Bien> biens) throws Exception {
		try	{			
			for(Bien bienLocal:biens) {
				if(bienLocal.getId().equals(bien.getId())) {
					bienLocal.setIsSelected(bien.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBien(List<Bien> biensAux) throws Exception {
		//this.biensAux=biensAux;
		
		for(Bien bienAux:biensAux) {
			if(bienAux.getIsChanged()) {
				bienAux.setIsChanged(false);
			}		
			
			if(bienAux.getIsNew()) {
				bienAux.setIsNew(false);
			}	
			
			if(bienAux.getIsDeleted()) {
				bienAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBien(Bien bienAux) throws Exception {
		//this.bienAux=bienAux;
		
			if(bienAux.getIsChanged()) {
				bienAux.setIsChanged(false);
			}		
			
			if(bienAux.getIsNew()) {
				bienAux.setIsNew(false);
			}	
			
			if(bienAux.getIsDeleted()) {
				bienAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Bien bienAsignar,Bien bien) throws Exception {
		bienAsignar.setId(bien.getId());	
		bienAsignar.setVersionRow(bien.getVersionRow());	
		bienAsignar.setid_empresa(bien.getid_empresa());
		bienAsignar.setempresa_descripcion(bien.getempresa_descripcion());	
		bienAsignar.setid_cliente(bien.getid_cliente());
		bienAsignar.setcliente_descripcion(bien.getcliente_descripcion());	
		bienAsignar.setid_tipobien(bien.getid_tipobien());
		bienAsignar.settipobien_descripcion(bien.gettipobien_descripcion());	
		bienAsignar.setnumero(bien.getnumero());	
		bienAsignar.setdescripcion(bien.getdescripcion());	
		bienAsignar.setvalor_avaluo(bien.getvalor_avaluo());	
		bienAsignar.setdireccion(bien.getdireccion());	
		bienAsignar.setes_activo(bien.getes_activo());	
	}
	
	public static void inicializarBien(Bien bien) throws Exception {
		try {
				bien.setId(0L);	
					
				bien.setid_empresa(-1L);	
				bien.setid_cliente(-1L);	
				bien.setid_tipobien(-1L);	
				bien.setnumero("");	
				bien.setdescripcion("");	
				bien.setvalor_avaluo(0.0);	
				bien.setdireccion("");	
				bien.setes_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBien(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_IDTIPOBIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_VALORAVALUO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BienConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBien(String sTipo,Row row,Workbook workbook,Bien bien,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.gettipobien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getvalor_avaluo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bien.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bien.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBien=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBien() {
		return this.sFinalQueryBien;
	}
	
	public void setsFinalQueryBien(String sFinalQueryBien) {
		this.sFinalQueryBien= sFinalQueryBien;
	}
	
	public Border resaltarSeleccionarBien=null;
	
	public Border setResaltarSeleccionarBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBien= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBien() {
		return this.resaltarSeleccionarBien;
	}
	
	public void setResaltarSeleccionarBien(Border borderResaltarSeleccionarBien) {
		this.resaltarSeleccionarBien= borderResaltarSeleccionarBien;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBien=null;
	public Boolean mostraridBien=true;
	public Boolean activaridBien=true;

	public Border resaltarid_empresaBien=null;
	public Boolean mostrarid_empresaBien=true;
	public Boolean activarid_empresaBien=true;
	public Boolean cargarid_empresaBien=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBien=false;//ConEventDepend=true

	public Border resaltarid_clienteBien=null;
	public Boolean mostrarid_clienteBien=true;
	public Boolean activarid_clienteBien=true;
	public Boolean cargarid_clienteBien=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteBien=false;//ConEventDepend=true

	public Border resaltarid_tipobienBien=null;
	public Boolean mostrarid_tipobienBien=true;
	public Boolean activarid_tipobienBien=true;
	public Boolean cargarid_tipobienBien=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipobienBien=false;//ConEventDepend=true

	public Border resaltarnumeroBien=null;
	public Boolean mostrarnumeroBien=true;
	public Boolean activarnumeroBien=true;

	public Border resaltardescripcionBien=null;
	public Boolean mostrardescripcionBien=true;
	public Boolean activardescripcionBien=true;

	public Border resaltarvalor_avaluoBien=null;
	public Boolean mostrarvalor_avaluoBien=true;
	public Boolean activarvalor_avaluoBien=true;

	public Border resaltardireccionBien=null;
	public Boolean mostrardireccionBien=true;
	public Boolean activardireccionBien=true;

	public Border resaltares_activoBien=null;
	public Boolean mostrares_activoBien=true;
	public Boolean activares_activoBien=true;

	
	

	public Border setResaltaridBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltaridBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBien() {
		return this.resaltaridBien;
	}

	public void setResaltaridBien(Border borderResaltar) {
		this.resaltaridBien= borderResaltar;
	}

	public Boolean getMostraridBien() {
		return this.mostraridBien;
	}

	public void setMostraridBien(Boolean mostraridBien) {
		this.mostraridBien= mostraridBien;
	}

	public Boolean getActivaridBien() {
		return this.activaridBien;
	}

	public void setActivaridBien(Boolean activaridBien) {
		this.activaridBien= activaridBien;
	}

	public Border setResaltarid_empresaBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarid_empresaBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBien() {
		return this.resaltarid_empresaBien;
	}

	public void setResaltarid_empresaBien(Border borderResaltar) {
		this.resaltarid_empresaBien= borderResaltar;
	}

	public Boolean getMostrarid_empresaBien() {
		return this.mostrarid_empresaBien;
	}

	public void setMostrarid_empresaBien(Boolean mostrarid_empresaBien) {
		this.mostrarid_empresaBien= mostrarid_empresaBien;
	}

	public Boolean getActivarid_empresaBien() {
		return this.activarid_empresaBien;
	}

	public void setActivarid_empresaBien(Boolean activarid_empresaBien) {
		this.activarid_empresaBien= activarid_empresaBien;
	}

	public Boolean getCargarid_empresaBien() {
		return this.cargarid_empresaBien;
	}

	public void setCargarid_empresaBien(Boolean cargarid_empresaBien) {
		this.cargarid_empresaBien= cargarid_empresaBien;
	}

	public Border setResaltarid_clienteBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarid_clienteBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteBien() {
		return this.resaltarid_clienteBien;
	}

	public void setResaltarid_clienteBien(Border borderResaltar) {
		this.resaltarid_clienteBien= borderResaltar;
	}

	public Boolean getMostrarid_clienteBien() {
		return this.mostrarid_clienteBien;
	}

	public void setMostrarid_clienteBien(Boolean mostrarid_clienteBien) {
		this.mostrarid_clienteBien= mostrarid_clienteBien;
	}

	public Boolean getActivarid_clienteBien() {
		return this.activarid_clienteBien;
	}

	public void setActivarid_clienteBien(Boolean activarid_clienteBien) {
		this.activarid_clienteBien= activarid_clienteBien;
	}

	public Boolean getCargarid_clienteBien() {
		return this.cargarid_clienteBien;
	}

	public void setCargarid_clienteBien(Boolean cargarid_clienteBien) {
		this.cargarid_clienteBien= cargarid_clienteBien;
	}

	public Border setResaltarid_tipobienBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarid_tipobienBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipobienBien() {
		return this.resaltarid_tipobienBien;
	}

	public void setResaltarid_tipobienBien(Border borderResaltar) {
		this.resaltarid_tipobienBien= borderResaltar;
	}

	public Boolean getMostrarid_tipobienBien() {
		return this.mostrarid_tipobienBien;
	}

	public void setMostrarid_tipobienBien(Boolean mostrarid_tipobienBien) {
		this.mostrarid_tipobienBien= mostrarid_tipobienBien;
	}

	public Boolean getActivarid_tipobienBien() {
		return this.activarid_tipobienBien;
	}

	public void setActivarid_tipobienBien(Boolean activarid_tipobienBien) {
		this.activarid_tipobienBien= activarid_tipobienBien;
	}

	public Boolean getCargarid_tipobienBien() {
		return this.cargarid_tipobienBien;
	}

	public void setCargarid_tipobienBien(Boolean cargarid_tipobienBien) {
		this.cargarid_tipobienBien= cargarid_tipobienBien;
	}

	public Border setResaltarnumeroBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarnumeroBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroBien() {
		return this.resaltarnumeroBien;
	}

	public void setResaltarnumeroBien(Border borderResaltar) {
		this.resaltarnumeroBien= borderResaltar;
	}

	public Boolean getMostrarnumeroBien() {
		return this.mostrarnumeroBien;
	}

	public void setMostrarnumeroBien(Boolean mostrarnumeroBien) {
		this.mostrarnumeroBien= mostrarnumeroBien;
	}

	public Boolean getActivarnumeroBien() {
		return this.activarnumeroBien;
	}

	public void setActivarnumeroBien(Boolean activarnumeroBien) {
		this.activarnumeroBien= activarnumeroBien;
	}

	public Border setResaltardescripcionBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltardescripcionBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionBien() {
		return this.resaltardescripcionBien;
	}

	public void setResaltardescripcionBien(Border borderResaltar) {
		this.resaltardescripcionBien= borderResaltar;
	}

	public Boolean getMostrardescripcionBien() {
		return this.mostrardescripcionBien;
	}

	public void setMostrardescripcionBien(Boolean mostrardescripcionBien) {
		this.mostrardescripcionBien= mostrardescripcionBien;
	}

	public Boolean getActivardescripcionBien() {
		return this.activardescripcionBien;
	}

	public void setActivardescripcionBien(Boolean activardescripcionBien) {
		this.activardescripcionBien= activardescripcionBien;
	}

	public Border setResaltarvalor_avaluoBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltarvalor_avaluoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_avaluoBien() {
		return this.resaltarvalor_avaluoBien;
	}

	public void setResaltarvalor_avaluoBien(Border borderResaltar) {
		this.resaltarvalor_avaluoBien= borderResaltar;
	}

	public Boolean getMostrarvalor_avaluoBien() {
		return this.mostrarvalor_avaluoBien;
	}

	public void setMostrarvalor_avaluoBien(Boolean mostrarvalor_avaluoBien) {
		this.mostrarvalor_avaluoBien= mostrarvalor_avaluoBien;
	}

	public Boolean getActivarvalor_avaluoBien() {
		return this.activarvalor_avaluoBien;
	}

	public void setActivarvalor_avaluoBien(Boolean activarvalor_avaluoBien) {
		this.activarvalor_avaluoBien= activarvalor_avaluoBien;
	}

	public Border setResaltardireccionBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltardireccionBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionBien() {
		return this.resaltardireccionBien;
	}

	public void setResaltardireccionBien(Border borderResaltar) {
		this.resaltardireccionBien= borderResaltar;
	}

	public Boolean getMostrardireccionBien() {
		return this.mostrardireccionBien;
	}

	public void setMostrardireccionBien(Boolean mostrardireccionBien) {
		this.mostrardireccionBien= mostrardireccionBien;
	}

	public Boolean getActivardireccionBien() {
		return this.activardireccionBien;
	}

	public void setActivardireccionBien(Boolean activardireccionBien) {
		this.activardireccionBien= activardireccionBien;
	}

	public Border setResaltares_activoBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bienBeanSwingJInternalFrame.jTtoolBarBien.setBorder(borderResaltar);
		
		this.resaltares_activoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoBien() {
		return this.resaltares_activoBien;
	}

	public void setResaltares_activoBien(Border borderResaltar) {
		this.resaltares_activoBien= borderResaltar;
	}

	public Boolean getMostrares_activoBien() {
		return this.mostrares_activoBien;
	}

	public void setMostrares_activoBien(Boolean mostrares_activoBien) {
		this.mostrares_activoBien= mostrares_activoBien;
	}

	public Boolean getActivares_activoBien() {
		return this.activares_activoBien;
	}

	public void setActivares_activoBien(Boolean activares_activoBien) {
		this.activares_activoBien= activares_activoBien;
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
		
		
		this.setMostraridBien(esInicial);
		this.setMostrarid_empresaBien(esInicial);
		this.setMostrarid_clienteBien(esInicial);
		this.setMostrarid_tipobienBien(esInicial);
		this.setMostrarnumeroBien(esInicial);
		this.setMostrardescripcionBien(esInicial);
		this.setMostrarvalor_avaluoBien(esInicial);
		this.setMostrardireccionBien(esInicial);
		this.setMostrares_activoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BienConstantesFunciones.ID)) {
				this.setMostraridBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDTIPOBIEN)) {
				this.setMostrarid_tipobienBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.VALORAVALUO)) {
				this.setMostrarvalor_avaluoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoBien(esAsigna);
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
		
		
		this.setActivaridBien(esInicial);
		this.setActivarid_empresaBien(esInicial);
		this.setActivarid_clienteBien(esInicial);
		this.setActivarid_tipobienBien(esInicial);
		this.setActivarnumeroBien(esInicial);
		this.setActivardescripcionBien(esInicial);
		this.setActivarvalor_avaluoBien(esInicial);
		this.setActivardireccionBien(esInicial);
		this.setActivares_activoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BienConstantesFunciones.ID)) {
				this.setActivaridBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDTIPOBIEN)) {
				this.setActivarid_tipobienBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.NUMERO)) {
				this.setActivarnumeroBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.VALORAVALUO)) {
				this.setActivarvalor_avaluoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DIRECCION)) {
				this.setActivardireccionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoBien(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBien(esInicial);
		this.setResaltarid_empresaBien(esInicial);
		this.setResaltarid_clienteBien(esInicial);
		this.setResaltarid_tipobienBien(esInicial);
		this.setResaltarnumeroBien(esInicial);
		this.setResaltardescripcionBien(esInicial);
		this.setResaltarvalor_avaluoBien(esInicial);
		this.setResaltardireccionBien(esInicial);
		this.setResaltares_activoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BienConstantesFunciones.ID)) {
				this.setResaltaridBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.IDTIPOBIEN)) {
				this.setResaltarid_tipobienBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.VALORAVALUO)) {
				this.setResaltarvalor_avaluoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(BienConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoBien(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteBien=true;

	public Boolean getMostrarFK_IdClienteBien() {
		return this.mostrarFK_IdClienteBien;
	}

	public void setMostrarFK_IdClienteBien(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteBien= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBien=true;

	public Boolean getMostrarFK_IdEmpresaBien() {
		return this.mostrarFK_IdEmpresaBien;
	}

	public void setMostrarFK_IdEmpresaBien(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBien= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteTipoBienBien=true;

	public Boolean getMostrarFK_IdValorClienteTipoBienBien() {
		return this.mostrarFK_IdValorClienteTipoBienBien;
	}

	public void setMostrarFK_IdValorClienteTipoBienBien(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteTipoBienBien= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteBien=true;

	public Boolean getActivarFK_IdClienteBien() {
		return this.activarFK_IdClienteBien;
	}

	public void setActivarFK_IdClienteBien(Boolean habilitarResaltar) {
		this.activarFK_IdClienteBien= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBien=true;

	public Boolean getActivarFK_IdEmpresaBien() {
		return this.activarFK_IdEmpresaBien;
	}

	public void setActivarFK_IdEmpresaBien(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBien= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteTipoBienBien=true;

	public Boolean getActivarFK_IdValorClienteTipoBienBien() {
		return this.activarFK_IdValorClienteTipoBienBien;
	}

	public void setActivarFK_IdValorClienteTipoBienBien(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteTipoBienBien= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteBien=null;

	public Border getResaltarFK_IdClienteBien() {
		return this.resaltarFK_IdClienteBien;
	}

	public void setResaltarFK_IdClienteBien(Border borderResaltar) {
		this.resaltarFK_IdClienteBien= borderResaltar;
	}

	public void setResaltarFK_IdClienteBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteBien= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBien=null;

	public Border getResaltarFK_IdEmpresaBien() {
		return this.resaltarFK_IdEmpresaBien;
	}

	public void setResaltarFK_IdEmpresaBien(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBien= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBien= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteTipoBienBien=null;

	public Border getResaltarFK_IdValorClienteTipoBienBien() {
		return this.resaltarFK_IdValorClienteTipoBienBien;
	}

	public void setResaltarFK_IdValorClienteTipoBienBien(Border borderResaltar) {
		this.resaltarFK_IdValorClienteTipoBienBien= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteTipoBienBien(ParametroGeneralUsuario parametroGeneralUsuario/*BienBeanSwingJInternalFrame bienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteTipoBienBien= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}