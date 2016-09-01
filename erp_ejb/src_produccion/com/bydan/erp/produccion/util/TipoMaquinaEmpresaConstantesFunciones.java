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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoMaquinaEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoMaquinaEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoMaquinaEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMaquinaEmpresaConstantesFunciones extends TipoMaquinaEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMaquinaEmpresa";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMaquinaEmpresa"+TipoMaquinaEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMaquinaEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMaquinaEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMaquinaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMaquinaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMaquinaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMaquinaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMaquinaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMaquinaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMaquinaEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMaquinaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMaquinaEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Maquina Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Maquina Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Maquina Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMaquinaEmpresa";
	public static final String OBJECTNAME="tipomaquinaempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_maquina_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomaquinaempresa from "+TipoMaquinaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomaquinaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".marca,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".modelo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".costo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".esta_activo from "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMaquinaEmpresaConstantesFuncionesAdditional tipomaquinaempresaConstantesFuncionesAdditional=null;
	
	public TipoMaquinaEmpresaConstantesFuncionesAdditional getTipoMaquinaEmpresaConstantesFuncionesAdditional() {
		return this.tipomaquinaempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoMaquinaEmpresaConstantesFuncionesAdditional(TipoMaquinaEmpresaConstantesFuncionesAdditional tipomaquinaempresaConstantesFuncionesAdditional) {
		try {
			this.tipomaquinaempresaConstantesFuncionesAdditional=tipomaquinaempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String MARCA= "marca";
    public static final String MODELO= "modelo";
    public static final String COSTO= "costo";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta Contable Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_MODELO= "Modelo";
		public static final String LABEL_MODELO_LOWER= "Modelo";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMODELO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMODELO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getTipoMaquinaEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.MARCA)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.MODELO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_MODELO;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.COSTO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=TipoMaquinaEmpresaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipomaquinaempresa.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipomaquinaempresa.getId(),tipomaquinaempresa.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getTipoMaquinaEmpresaDescripcion(TipoMaquinaEmpresa tipomaquinaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomaquinaempresa !=null/* && tipomaquinaempresa.getId()!=0*/) {
			sDescripcion=tipomaquinaempresa.getcodigo();//tipomaquinaempresatipomaquinaempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMaquinaEmpresaDescripcionDetallado(TipoMaquinaEmpresa tipomaquinaempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipomaquinaempresa.getId().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomaquinaempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipomaquinaempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tipomaquinaempresa.getid_sucursal().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=tipomaquinaempresa.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=tipomaquinaempresa.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomaquinaempresa.getcodigo()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomaquinaempresa.getnombre()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.MARCA+"=";
		sDescripcion+=tipomaquinaempresa.getmarca()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.MODELO+"=";
		sDescripcion+=tipomaquinaempresa.getmodelo()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.COSTO+"=";
		sDescripcion+=tipomaquinaempresa.getcosto().toString()+",";
		sDescripcion+=TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=tipomaquinaempresa.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMaquinaEmpresaDescripcion(TipoMaquinaEmpresa tipomaquinaempresa,String sValor) throws Exception {			
		if(tipomaquinaempresa !=null) {
			tipomaquinaempresa.setcodigo(sValor);;//tipomaquinaempresatipomaquinaempresa.getcodigo().trim();
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

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomaquinaempresa.setcodigo(tipomaquinaempresa.getcodigo().trim());
		tipomaquinaempresa.setnombre(tipomaquinaempresa.getnombre().trim());
		tipomaquinaempresa.setmarca(tipomaquinaempresa.getmarca().trim());
		tipomaquinaempresa.setmodelo(tipomaquinaempresa.getmodelo().trim());
	}
	
	public static void quitarEspaciosTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> tipomaquinaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {
			tipomaquinaempresa.setcodigo(tipomaquinaempresa.getcodigo().trim());
			tipomaquinaempresa.setnombre(tipomaquinaempresa.getnombre().trim());
			tipomaquinaempresa.setmarca(tipomaquinaempresa.getmarca().trim());
			tipomaquinaempresa.setmodelo(tipomaquinaempresa.getmodelo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomaquinaempresa.getConCambioAuxiliar()) {
			tipomaquinaempresa.setIsDeleted(tipomaquinaempresa.getIsDeletedAuxiliar());	
			tipomaquinaempresa.setIsNew(tipomaquinaempresa.getIsNewAuxiliar());	
			tipomaquinaempresa.setIsChanged(tipomaquinaempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomaquinaempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomaquinaempresa.setIsDeletedAuxiliar(false);	
			tipomaquinaempresa.setIsNewAuxiliar(false);	
			tipomaquinaempresa.setIsChangedAuxiliar(false);
			
			tipomaquinaempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> tipomaquinaempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa : tipomaquinaempresas) {
			if(conAsignarBase && tipomaquinaempresa.getConCambioAuxiliar()) {
				tipomaquinaempresa.setIsDeleted(tipomaquinaempresa.getIsDeletedAuxiliar());	
				tipomaquinaempresa.setIsNew(tipomaquinaempresa.getIsNewAuxiliar());	
				tipomaquinaempresa.setIsChanged(tipomaquinaempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomaquinaempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomaquinaempresa.setIsDeletedAuxiliar(false);	
				tipomaquinaempresa.setIsNewAuxiliar(false);	
				tipomaquinaempresa.setIsChangedAuxiliar(false);
				
				tipomaquinaempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa,Boolean conEnteros) throws Exception  {
		tipomaquinaempresa.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> tipomaquinaempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {
			tipomaquinaempresa.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresa tipomaquinaempresaAux) throws Exception  {
		TipoMaquinaEmpresaConstantesFunciones.InicializarValoresTipoMaquinaEmpresa(tipomaquinaempresaAux,true);
		
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {
			if(tipomaquinaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipomaquinaempresaAux.setcosto(tipomaquinaempresaAux.getcosto()+tipomaquinaempresa.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMaquinaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMaquinaEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoMaquinaEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMaquinaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMaquinaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMaquinaEmpresa> tipomaquinaempresas,TipoMaquinaEmpresa tipomaquinaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMaquinaEmpresa tipomaquinaempresaAux: tipomaquinaempresas) {
			if(tipomaquinaempresaAux!=null && tipomaquinaempresa!=null) {
				if((tipomaquinaempresaAux.getId()==null && tipomaquinaempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomaquinaempresaAux.getId()!=null && tipomaquinaempresa.getId()!=null){
					if(tipomaquinaempresaAux.getId().equals(tipomaquinaempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> tipomaquinaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
	
		for(TipoMaquinaEmpresa tipomaquinaempresa: tipomaquinaempresas) {			
			if(tipomaquinaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=tipomaquinaempresa.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMaquinaEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_ID, TipoMaquinaEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoMaquinaEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_IDSUCURSAL, TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_CODIGO, TipoMaquinaEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_NOMBRE, TipoMaquinaEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_MARCA, TipoMaquinaEmpresaConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_MODELO, TipoMaquinaEmpresaConstantesFunciones.MODELO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO, TipoMaquinaEmpresaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMaquinaEmpresaConstantesFunciones.LABEL_ESTAACTIVO, TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMaquinaEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.MODELO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMaquinaEmpresa() throws Exception  {
		return TipoMaquinaEmpresaConstantesFunciones.getTiposSeleccionarTipoMaquinaEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMaquinaEmpresa(Boolean conFk) throws Exception  {
		return TipoMaquinaEmpresaConstantesFunciones.getTiposSeleccionarTipoMaquinaEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMaquinaEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_MODELO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_MODELO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMaquinaEmpresaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(TipoMaquinaEmpresaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMaquinaEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresaAux) throws Exception {
		
			tipomaquinaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomaquinaempresaAux.getEmpresa()));
			tipomaquinaempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipomaquinaempresaAux.getSucursal()));
			tipomaquinaempresaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipomaquinaempresaAux.getCuentaContableDebito()));
			tipomaquinaempresaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipomaquinaempresaAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> tipomaquinaempresasTemp) throws Exception {
		for(TipoMaquinaEmpresa tipomaquinaempresaAux:tipomaquinaempresasTemp) {
			
			tipomaquinaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomaquinaempresaAux.getEmpresa()));
			tipomaquinaempresaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipomaquinaempresaAux.getSucursal()));
			tipomaquinaempresaAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipomaquinaempresaAux.getCuentaContableDebito()));
			tipomaquinaempresaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipomaquinaempresaAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMaquinaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMaquinaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMaquinaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMaquinaEmpresaConstantesFunciones.getClassesRelationshipsOfTipoMaquinaEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMaquinaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
				classes.add(new Classe(ProductoProduMaquina.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMaquina.class)) {
						classes.add(new Classe(ProductoProduMaquina.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMaquinaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMaquinaEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMaquinaEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMaquinaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
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
	public static void actualizarLista(TipoMaquinaEmpresa tipomaquinaempresa,List<TipoMaquinaEmpresa> tipomaquinaempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMaquinaEmpresa tipomaquinaempresaEncontrado=null;
			
			for(TipoMaquinaEmpresa tipomaquinaempresaLocal:tipomaquinaempresas) {
				if(tipomaquinaempresaLocal.getId().equals(tipomaquinaempresa.getId())) {
					tipomaquinaempresaEncontrado=tipomaquinaempresaLocal;
					
					tipomaquinaempresaLocal.setIsChanged(tipomaquinaempresa.getIsChanged());
					tipomaquinaempresaLocal.setIsNew(tipomaquinaempresa.getIsNew());
					tipomaquinaempresaLocal.setIsDeleted(tipomaquinaempresa.getIsDeleted());
					
					tipomaquinaempresaLocal.setGeneralEntityOriginal(tipomaquinaempresa.getGeneralEntityOriginal());
					
					tipomaquinaempresaLocal.setId(tipomaquinaempresa.getId());	
					tipomaquinaempresaLocal.setVersionRow(tipomaquinaempresa.getVersionRow());	
					tipomaquinaempresaLocal.setid_empresa(tipomaquinaempresa.getid_empresa());	
					tipomaquinaempresaLocal.setid_sucursal(tipomaquinaempresa.getid_sucursal());	
					tipomaquinaempresaLocal.setid_cuenta_contable_debito(tipomaquinaempresa.getid_cuenta_contable_debito());	
					tipomaquinaempresaLocal.setid_cuenta_contable_credito(tipomaquinaempresa.getid_cuenta_contable_credito());	
					tipomaquinaempresaLocal.setcodigo(tipomaquinaempresa.getcodigo());	
					tipomaquinaempresaLocal.setnombre(tipomaquinaempresa.getnombre());	
					tipomaquinaempresaLocal.setmarca(tipomaquinaempresa.getmarca());	
					tipomaquinaempresaLocal.setmodelo(tipomaquinaempresa.getmodelo());	
					tipomaquinaempresaLocal.setcosto(tipomaquinaempresa.getcosto());	
					tipomaquinaempresaLocal.setesta_activo(tipomaquinaempresa.getesta_activo());	
					
					
					tipomaquinaempresaLocal.setProductoOrdenDetaProduMaquinas(tipomaquinaempresa.getProductoOrdenDetaProduMaquinas());
					tipomaquinaempresaLocal.setProductoProduMaquinas(tipomaquinaempresa.getProductoProduMaquinas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipomaquinaempresa.getIsDeleted()) {
				if(!existe) {
					tipomaquinaempresas.add(tipomaquinaempresa);
				}
			} else {
				if(tipomaquinaempresaEncontrado!=null && permiteQuitar)  {
					tipomaquinaempresas.remove(tipomaquinaempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMaquinaEmpresa tipomaquinaempresa,List<TipoMaquinaEmpresa> tipomaquinaempresas) throws Exception {
		try	{			
			for(TipoMaquinaEmpresa tipomaquinaempresaLocal:tipomaquinaempresas) {
				if(tipomaquinaempresaLocal.getId().equals(tipomaquinaempresa.getId())) {
					tipomaquinaempresaLocal.setIsSelected(tipomaquinaempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMaquinaEmpresa(List<TipoMaquinaEmpresa> tipomaquinaempresasAux) throws Exception {
		//this.tipomaquinaempresasAux=tipomaquinaempresasAux;
		
		for(TipoMaquinaEmpresa tipomaquinaempresaAux:tipomaquinaempresasAux) {
			if(tipomaquinaempresaAux.getIsChanged()) {
				tipomaquinaempresaAux.setIsChanged(false);
			}		
			
			if(tipomaquinaempresaAux.getIsNew()) {
				tipomaquinaempresaAux.setIsNew(false);
			}	
			
			if(tipomaquinaempresaAux.getIsDeleted()) {
				tipomaquinaempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresaAux) throws Exception {
		//this.tipomaquinaempresaAux=tipomaquinaempresaAux;
		
			if(tipomaquinaempresaAux.getIsChanged()) {
				tipomaquinaempresaAux.setIsChanged(false);
			}		
			
			if(tipomaquinaempresaAux.getIsNew()) {
				tipomaquinaempresaAux.setIsNew(false);
			}	
			
			if(tipomaquinaempresaAux.getIsDeleted()) {
				tipomaquinaempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMaquinaEmpresa tipomaquinaempresaAsignar,TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		tipomaquinaempresaAsignar.setId(tipomaquinaempresa.getId());	
		tipomaquinaempresaAsignar.setVersionRow(tipomaquinaempresa.getVersionRow());	
		tipomaquinaempresaAsignar.setid_empresa(tipomaquinaempresa.getid_empresa());
		tipomaquinaempresaAsignar.setempresa_descripcion(tipomaquinaempresa.getempresa_descripcion());	
		tipomaquinaempresaAsignar.setid_sucursal(tipomaquinaempresa.getid_sucursal());
		tipomaquinaempresaAsignar.setsucursal_descripcion(tipomaquinaempresa.getsucursal_descripcion());	
		tipomaquinaempresaAsignar.setid_cuenta_contable_debito(tipomaquinaempresa.getid_cuenta_contable_debito());
		tipomaquinaempresaAsignar.setcuentacontabledebito_descripcion(tipomaquinaempresa.getcuentacontabledebito_descripcion());	
		tipomaquinaempresaAsignar.setid_cuenta_contable_credito(tipomaquinaempresa.getid_cuenta_contable_credito());
		tipomaquinaempresaAsignar.setcuentacontablecredito_descripcion(tipomaquinaempresa.getcuentacontablecredito_descripcion());	
		tipomaquinaempresaAsignar.setcodigo(tipomaquinaempresa.getcodigo());	
		tipomaquinaempresaAsignar.setnombre(tipomaquinaempresa.getnombre());	
		tipomaquinaempresaAsignar.setmarca(tipomaquinaempresa.getmarca());	
		tipomaquinaempresaAsignar.setmodelo(tipomaquinaempresa.getmodelo());	
		tipomaquinaempresaAsignar.setcosto(tipomaquinaempresa.getcosto());	
		tipomaquinaempresaAsignar.setesta_activo(tipomaquinaempresa.getesta_activo());	
	}
	
	public static void inicializarTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		try {
				tipomaquinaempresa.setId(0L);	
					
				tipomaquinaempresa.setid_empresa(-1L);	
				tipomaquinaempresa.setid_sucursal(-1L);	
				tipomaquinaempresa.setid_cuenta_contable_debito(-1L);	
				tipomaquinaempresa.setid_cuenta_contable_credito(-1L);	
				tipomaquinaempresa.setcodigo("");	
				tipomaquinaempresa.setnombre("");	
				tipomaquinaempresa.setmarca("");	
				tipomaquinaempresa.setmodelo("");	
				tipomaquinaempresa.setcosto(0.0);	
				tipomaquinaempresa.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMaquinaEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_MODELO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMaquinaEmpresaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMaquinaEmpresa(String sTipo,Row row,Workbook workbook,TipoMaquinaEmpresa tipomaquinaempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getmodelo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomaquinaempresa.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipomaquinaempresa.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMaquinaEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMaquinaEmpresa() {
		return this.sFinalQueryTipoMaquinaEmpresa;
	}
	
	public void setsFinalQueryTipoMaquinaEmpresa(String sFinalQueryTipoMaquinaEmpresa) {
		this.sFinalQueryTipoMaquinaEmpresa= sFinalQueryTipoMaquinaEmpresa;
	}
	
	public Border resaltarSeleccionarTipoMaquinaEmpresa=null;
	
	public Border setResaltarSeleccionarTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMaquinaEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMaquinaEmpresa() {
		return this.resaltarSeleccionarTipoMaquinaEmpresa;
	}
	
	public void setResaltarSeleccionarTipoMaquinaEmpresa(Border borderResaltarSeleccionarTipoMaquinaEmpresa) {
		this.resaltarSeleccionarTipoMaquinaEmpresa= borderResaltarSeleccionarTipoMaquinaEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMaquinaEmpresa=null;
	public Boolean mostraridTipoMaquinaEmpresa=true;
	public Boolean activaridTipoMaquinaEmpresa=true;

	public Border resaltarid_empresaTipoMaquinaEmpresa=null;
	public Boolean mostrarid_empresaTipoMaquinaEmpresa=true;
	public Boolean activarid_empresaTipoMaquinaEmpresa=true;
	public Boolean cargarid_empresaTipoMaquinaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoMaquinaEmpresa=false;//ConEventDepend=true

	public Border resaltarid_sucursalTipoMaquinaEmpresa=null;
	public Boolean mostrarid_sucursalTipoMaquinaEmpresa=true;
	public Boolean activarid_sucursalTipoMaquinaEmpresa=true;
	public Boolean cargarid_sucursalTipoMaquinaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTipoMaquinaEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoTipoMaquinaEmpresa=null;
	public Boolean mostrarid_cuenta_contable_debitoTipoMaquinaEmpresa=true;
	public Boolean activarid_cuenta_contable_debitoTipoMaquinaEmpresa=true;
	public Boolean cargarid_cuenta_contable_debitoTipoMaquinaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoTipoMaquinaEmpresa=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoTipoMaquinaEmpresa=null;
	public Boolean mostrarid_cuenta_contable_creditoTipoMaquinaEmpresa=true;
	public Boolean activarid_cuenta_contable_creditoTipoMaquinaEmpresa=true;
	public Boolean cargarid_cuenta_contable_creditoTipoMaquinaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoTipoMaquinaEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoTipoMaquinaEmpresa=null;
	public Boolean mostrarcodigoTipoMaquinaEmpresa=true;
	public Boolean activarcodigoTipoMaquinaEmpresa=true;

	public Border resaltarnombreTipoMaquinaEmpresa=null;
	public Boolean mostrarnombreTipoMaquinaEmpresa=true;
	public Boolean activarnombreTipoMaquinaEmpresa=true;

	public Border resaltarmarcaTipoMaquinaEmpresa=null;
	public Boolean mostrarmarcaTipoMaquinaEmpresa=true;
	public Boolean activarmarcaTipoMaquinaEmpresa=true;

	public Border resaltarmodeloTipoMaquinaEmpresa=null;
	public Boolean mostrarmodeloTipoMaquinaEmpresa=true;
	public Boolean activarmodeloTipoMaquinaEmpresa=true;

	public Border resaltarcostoTipoMaquinaEmpresa=null;
	public Boolean mostrarcostoTipoMaquinaEmpresa=true;
	public Boolean activarcostoTipoMaquinaEmpresa=true;

	public Border resaltaresta_activoTipoMaquinaEmpresa=null;
	public Boolean mostraresta_activoTipoMaquinaEmpresa=true;
	public Boolean activaresta_activoTipoMaquinaEmpresa=true;

	
	

	public Border setResaltaridTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMaquinaEmpresa() {
		return this.resaltaridTipoMaquinaEmpresa;
	}

	public void setResaltaridTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltaridTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoMaquinaEmpresa() {
		return this.mostraridTipoMaquinaEmpresa;
	}

	public void setMostraridTipoMaquinaEmpresa(Boolean mostraridTipoMaquinaEmpresa) {
		this.mostraridTipoMaquinaEmpresa= mostraridTipoMaquinaEmpresa;
	}

	public Boolean getActivaridTipoMaquinaEmpresa() {
		return this.activaridTipoMaquinaEmpresa;
	}

	public void setActivaridTipoMaquinaEmpresa(Boolean activaridTipoMaquinaEmpresa) {
		this.activaridTipoMaquinaEmpresa= activaridTipoMaquinaEmpresa;
	}

	public Border setResaltarid_empresaTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoMaquinaEmpresa() {
		return this.resaltarid_empresaTipoMaquinaEmpresa;
	}

	public void setResaltarid_empresaTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoMaquinaEmpresa() {
		return this.mostrarid_empresaTipoMaquinaEmpresa;
	}

	public void setMostrarid_empresaTipoMaquinaEmpresa(Boolean mostrarid_empresaTipoMaquinaEmpresa) {
		this.mostrarid_empresaTipoMaquinaEmpresa= mostrarid_empresaTipoMaquinaEmpresa;
	}

	public Boolean getActivarid_empresaTipoMaquinaEmpresa() {
		return this.activarid_empresaTipoMaquinaEmpresa;
	}

	public void setActivarid_empresaTipoMaquinaEmpresa(Boolean activarid_empresaTipoMaquinaEmpresa) {
		this.activarid_empresaTipoMaquinaEmpresa= activarid_empresaTipoMaquinaEmpresa;
	}

	public Boolean getCargarid_empresaTipoMaquinaEmpresa() {
		return this.cargarid_empresaTipoMaquinaEmpresa;
	}

	public void setCargarid_empresaTipoMaquinaEmpresa(Boolean cargarid_empresaTipoMaquinaEmpresa) {
		this.cargarid_empresaTipoMaquinaEmpresa= cargarid_empresaTipoMaquinaEmpresa;
	}

	public Border setResaltarid_sucursalTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTipoMaquinaEmpresa() {
		return this.resaltarid_sucursalTipoMaquinaEmpresa;
	}

	public void setResaltarid_sucursalTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarid_sucursalTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTipoMaquinaEmpresa() {
		return this.mostrarid_sucursalTipoMaquinaEmpresa;
	}

	public void setMostrarid_sucursalTipoMaquinaEmpresa(Boolean mostrarid_sucursalTipoMaquinaEmpresa) {
		this.mostrarid_sucursalTipoMaquinaEmpresa= mostrarid_sucursalTipoMaquinaEmpresa;
	}

	public Boolean getActivarid_sucursalTipoMaquinaEmpresa() {
		return this.activarid_sucursalTipoMaquinaEmpresa;
	}

	public void setActivarid_sucursalTipoMaquinaEmpresa(Boolean activarid_sucursalTipoMaquinaEmpresa) {
		this.activarid_sucursalTipoMaquinaEmpresa= activarid_sucursalTipoMaquinaEmpresa;
	}

	public Boolean getCargarid_sucursalTipoMaquinaEmpresa() {
		return this.cargarid_sucursalTipoMaquinaEmpresa;
	}

	public void setCargarid_sucursalTipoMaquinaEmpresa(Boolean cargarid_sucursalTipoMaquinaEmpresa) {
		this.cargarid_sucursalTipoMaquinaEmpresa= cargarid_sucursalTipoMaquinaEmpresa;
	}

	public Border setResaltarid_cuenta_contable_debitoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoTipoMaquinaEmpresa() {
		return this.resaltarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public void setResaltarid_cuenta_contable_debitoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoTipoMaquinaEmpresa() {
		return this.mostrarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public void setMostrarid_cuenta_contable_debitoTipoMaquinaEmpresa(Boolean mostrarid_cuenta_contable_debitoTipoMaquinaEmpresa) {
		this.mostrarid_cuenta_contable_debitoTipoMaquinaEmpresa= mostrarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_debitoTipoMaquinaEmpresa() {
		return this.activarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public void setActivarid_cuenta_contable_debitoTipoMaquinaEmpresa(Boolean activarid_cuenta_contable_debitoTipoMaquinaEmpresa) {
		this.activarid_cuenta_contable_debitoTipoMaquinaEmpresa= activarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_debitoTipoMaquinaEmpresa() {
		return this.cargarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public void setCargarid_cuenta_contable_debitoTipoMaquinaEmpresa(Boolean cargarid_cuenta_contable_debitoTipoMaquinaEmpresa) {
		this.cargarid_cuenta_contable_debitoTipoMaquinaEmpresa= cargarid_cuenta_contable_debitoTipoMaquinaEmpresa;
	}

	public Border setResaltarid_cuenta_contable_creditoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoTipoMaquinaEmpresa() {
		return this.resaltarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public void setResaltarid_cuenta_contable_creditoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoTipoMaquinaEmpresa() {
		return this.mostrarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public void setMostrarid_cuenta_contable_creditoTipoMaquinaEmpresa(Boolean mostrarid_cuenta_contable_creditoTipoMaquinaEmpresa) {
		this.mostrarid_cuenta_contable_creditoTipoMaquinaEmpresa= mostrarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public Boolean getActivarid_cuenta_contable_creditoTipoMaquinaEmpresa() {
		return this.activarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public void setActivarid_cuenta_contable_creditoTipoMaquinaEmpresa(Boolean activarid_cuenta_contable_creditoTipoMaquinaEmpresa) {
		this.activarid_cuenta_contable_creditoTipoMaquinaEmpresa= activarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public Boolean getCargarid_cuenta_contable_creditoTipoMaquinaEmpresa() {
		return this.cargarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public void setCargarid_cuenta_contable_creditoTipoMaquinaEmpresa(Boolean cargarid_cuenta_contable_creditoTipoMaquinaEmpresa) {
		this.cargarid_cuenta_contable_creditoTipoMaquinaEmpresa= cargarid_cuenta_contable_creditoTipoMaquinaEmpresa;
	}

	public Border setResaltarcodigoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMaquinaEmpresa() {
		return this.resaltarcodigoTipoMaquinaEmpresa;
	}

	public void setResaltarcodigoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMaquinaEmpresa() {
		return this.mostrarcodigoTipoMaquinaEmpresa;
	}

	public void setMostrarcodigoTipoMaquinaEmpresa(Boolean mostrarcodigoTipoMaquinaEmpresa) {
		this.mostrarcodigoTipoMaquinaEmpresa= mostrarcodigoTipoMaquinaEmpresa;
	}

	public Boolean getActivarcodigoTipoMaquinaEmpresa() {
		return this.activarcodigoTipoMaquinaEmpresa;
	}

	public void setActivarcodigoTipoMaquinaEmpresa(Boolean activarcodigoTipoMaquinaEmpresa) {
		this.activarcodigoTipoMaquinaEmpresa= activarcodigoTipoMaquinaEmpresa;
	}

	public Border setResaltarnombreTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMaquinaEmpresa() {
		return this.resaltarnombreTipoMaquinaEmpresa;
	}

	public void setResaltarnombreTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMaquinaEmpresa() {
		return this.mostrarnombreTipoMaquinaEmpresa;
	}

	public void setMostrarnombreTipoMaquinaEmpresa(Boolean mostrarnombreTipoMaquinaEmpresa) {
		this.mostrarnombreTipoMaquinaEmpresa= mostrarnombreTipoMaquinaEmpresa;
	}

	public Boolean getActivarnombreTipoMaquinaEmpresa() {
		return this.activarnombreTipoMaquinaEmpresa;
	}

	public void setActivarnombreTipoMaquinaEmpresa(Boolean activarnombreTipoMaquinaEmpresa) {
		this.activarnombreTipoMaquinaEmpresa= activarnombreTipoMaquinaEmpresa;
	}

	public Border setResaltarmarcaTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarmarcaTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaTipoMaquinaEmpresa() {
		return this.resaltarmarcaTipoMaquinaEmpresa;
	}

	public void setResaltarmarcaTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarmarcaTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarmarcaTipoMaquinaEmpresa() {
		return this.mostrarmarcaTipoMaquinaEmpresa;
	}

	public void setMostrarmarcaTipoMaquinaEmpresa(Boolean mostrarmarcaTipoMaquinaEmpresa) {
		this.mostrarmarcaTipoMaquinaEmpresa= mostrarmarcaTipoMaquinaEmpresa;
	}

	public Boolean getActivarmarcaTipoMaquinaEmpresa() {
		return this.activarmarcaTipoMaquinaEmpresa;
	}

	public void setActivarmarcaTipoMaquinaEmpresa(Boolean activarmarcaTipoMaquinaEmpresa) {
		this.activarmarcaTipoMaquinaEmpresa= activarmarcaTipoMaquinaEmpresa;
	}

	public Border setResaltarmodeloTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarmodeloTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodeloTipoMaquinaEmpresa() {
		return this.resaltarmodeloTipoMaquinaEmpresa;
	}

	public void setResaltarmodeloTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarmodeloTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarmodeloTipoMaquinaEmpresa() {
		return this.mostrarmodeloTipoMaquinaEmpresa;
	}

	public void setMostrarmodeloTipoMaquinaEmpresa(Boolean mostrarmodeloTipoMaquinaEmpresa) {
		this.mostrarmodeloTipoMaquinaEmpresa= mostrarmodeloTipoMaquinaEmpresa;
	}

	public Boolean getActivarmodeloTipoMaquinaEmpresa() {
		return this.activarmodeloTipoMaquinaEmpresa;
	}

	public void setActivarmodeloTipoMaquinaEmpresa(Boolean activarmodeloTipoMaquinaEmpresa) {
		this.activarmodeloTipoMaquinaEmpresa= activarmodeloTipoMaquinaEmpresa;
	}

	public Border setResaltarcostoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltarcostoTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoTipoMaquinaEmpresa() {
		return this.resaltarcostoTipoMaquinaEmpresa;
	}

	public void setResaltarcostoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarcostoTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostrarcostoTipoMaquinaEmpresa() {
		return this.mostrarcostoTipoMaquinaEmpresa;
	}

	public void setMostrarcostoTipoMaquinaEmpresa(Boolean mostrarcostoTipoMaquinaEmpresa) {
		this.mostrarcostoTipoMaquinaEmpresa= mostrarcostoTipoMaquinaEmpresa;
	}

	public Boolean getActivarcostoTipoMaquinaEmpresa() {
		return this.activarcostoTipoMaquinaEmpresa;
	}

	public void setActivarcostoTipoMaquinaEmpresa(Boolean activarcostoTipoMaquinaEmpresa) {
		this.activarcostoTipoMaquinaEmpresa= activarcostoTipoMaquinaEmpresa;
	}

	public Border setResaltaresta_activoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltar);
		
		this.resaltaresta_activoTipoMaquinaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoTipoMaquinaEmpresa() {
		return this.resaltaresta_activoTipoMaquinaEmpresa;
	}

	public void setResaltaresta_activoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltaresta_activoTipoMaquinaEmpresa= borderResaltar;
	}

	public Boolean getMostraresta_activoTipoMaquinaEmpresa() {
		return this.mostraresta_activoTipoMaquinaEmpresa;
	}

	public void setMostraresta_activoTipoMaquinaEmpresa(Boolean mostraresta_activoTipoMaquinaEmpresa) {
		this.mostraresta_activoTipoMaquinaEmpresa= mostraresta_activoTipoMaquinaEmpresa;
	}

	public Boolean getActivaresta_activoTipoMaquinaEmpresa() {
		return this.activaresta_activoTipoMaquinaEmpresa;
	}

	public void setActivaresta_activoTipoMaquinaEmpresa(Boolean activaresta_activoTipoMaquinaEmpresa) {
		this.activaresta_activoTipoMaquinaEmpresa= activaresta_activoTipoMaquinaEmpresa;
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
		
		
		this.setMostraridTipoMaquinaEmpresa(esInicial);
		this.setMostrarid_empresaTipoMaquinaEmpresa(esInicial);
		this.setMostrarid_sucursalTipoMaquinaEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_debitoTipoMaquinaEmpresa(esInicial);
		this.setMostrarid_cuenta_contable_creditoTipoMaquinaEmpresa(esInicial);
		this.setMostrarcodigoTipoMaquinaEmpresa(esInicial);
		this.setMostrarnombreTipoMaquinaEmpresa(esInicial);
		this.setMostrarmarcaTipoMaquinaEmpresa(esInicial);
		this.setMostrarmodeloTipoMaquinaEmpresa(esInicial);
		this.setMostrarcostoTipoMaquinaEmpresa(esInicial);
		this.setMostraresta_activoTipoMaquinaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MARCA)) {
				this.setMostrarmarcaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MODELO)) {
				this.setMostrarmodeloTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.COSTO)) {
				this.setMostrarcostoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoTipoMaquinaEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoMaquinaEmpresa(esInicial);
		this.setActivarid_empresaTipoMaquinaEmpresa(esInicial);
		this.setActivarid_sucursalTipoMaquinaEmpresa(esInicial);
		this.setActivarid_cuenta_contable_debitoTipoMaquinaEmpresa(esInicial);
		this.setActivarid_cuenta_contable_creditoTipoMaquinaEmpresa(esInicial);
		this.setActivarcodigoTipoMaquinaEmpresa(esInicial);
		this.setActivarnombreTipoMaquinaEmpresa(esInicial);
		this.setActivarmarcaTipoMaquinaEmpresa(esInicial);
		this.setActivarmodeloTipoMaquinaEmpresa(esInicial);
		this.setActivarcostoTipoMaquinaEmpresa(esInicial);
		this.setActivaresta_activoTipoMaquinaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MARCA)) {
				this.setActivarmarcaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MODELO)) {
				this.setActivarmodeloTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.COSTO)) {
				this.setActivarcostoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoTipoMaquinaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMaquinaEmpresa(esInicial);
		this.setResaltarid_empresaTipoMaquinaEmpresa(esInicial);
		this.setResaltarid_sucursalTipoMaquinaEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_debitoTipoMaquinaEmpresa(esInicial);
		this.setResaltarid_cuenta_contable_creditoTipoMaquinaEmpresa(esInicial);
		this.setResaltarcodigoTipoMaquinaEmpresa(esInicial);
		this.setResaltarnombreTipoMaquinaEmpresa(esInicial);
		this.setResaltarmarcaTipoMaquinaEmpresa(esInicial);
		this.setResaltarmodeloTipoMaquinaEmpresa(esInicial);
		this.setResaltarcostoTipoMaquinaEmpresa(esInicial);
		this.setResaltaresta_activoTipoMaquinaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MARCA)) {
				this.setResaltarmarcaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.MODELO)) {
				this.setResaltarmodeloTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.COSTO)) {
				this.setResaltarcostoTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoTipoMaquinaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa=null;

	public Border getResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa() {
		return this.resaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa;
	}

	public void setResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(Border borderResaltarProductoOrdenDetaProduMaquina) {
		if(borderResaltarProductoOrdenDetaProduMaquina!=null) {
			this.resaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa= borderResaltarProductoOrdenDetaProduMaquina;
		}
	}

	public Border setResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltarProductoOrdenDetaProduMaquina);
			
		this.resaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa= borderResaltarProductoOrdenDetaProduMaquina;

		 return borderResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean mostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa=true;

	public Boolean getMostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa() {
		return this.mostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa;
	}

	public void setMostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(Boolean visibilidadResaltarProductoOrdenDetaProduMaquina) {
		this.mostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa= visibilidadResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean activarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa() {
		return this.activarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa;
	}

	public void setActivarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(Boolean habilitarResaltarProductoOrdenDetaProduMaquina) {
		this.activarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa= habilitarResaltarProductoOrdenDetaProduMaquina;
	}


	public Border resaltarProductoProduMaquinaTipoMaquinaEmpresa=null;

	public Border getResaltarProductoProduMaquinaTipoMaquinaEmpresa() {
		return this.resaltarProductoProduMaquinaTipoMaquinaEmpresa;
	}

	public void setResaltarProductoProduMaquinaTipoMaquinaEmpresa(Border borderResaltarProductoProduMaquina) {
		if(borderResaltarProductoProduMaquina!=null) {
			this.resaltarProductoProduMaquinaTipoMaquinaEmpresa= borderResaltarProductoProduMaquina;
		}
	}

	public Border setResaltarProductoProduMaquinaTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomaquinaempresaBeanSwingJInternalFrame.jTtoolBarTipoMaquinaEmpresa.setBorder(borderResaltarProductoProduMaquina);
			
		this.resaltarProductoProduMaquinaTipoMaquinaEmpresa= borderResaltarProductoProduMaquina;

		 return borderResaltarProductoProduMaquina;
	}



	public Boolean mostrarProductoProduMaquinaTipoMaquinaEmpresa=true;

	public Boolean getMostrarProductoProduMaquinaTipoMaquinaEmpresa() {
		return this.mostrarProductoProduMaquinaTipoMaquinaEmpresa;
	}

	public void setMostrarProductoProduMaquinaTipoMaquinaEmpresa(Boolean visibilidadResaltarProductoProduMaquina) {
		this.mostrarProductoProduMaquinaTipoMaquinaEmpresa= visibilidadResaltarProductoProduMaquina;
	}



	public Boolean activarProductoProduMaquinaTipoMaquinaEmpresa=true;

	public Boolean gethabilitarResaltarProductoProduMaquinaTipoMaquinaEmpresa() {
		return this.activarProductoProduMaquinaTipoMaquinaEmpresa;
	}

	public void setActivarProductoProduMaquinaTipoMaquinaEmpresa(Boolean habilitarResaltarProductoProduMaquina) {
		this.activarProductoProduMaquinaTipoMaquinaEmpresa= habilitarResaltarProductoProduMaquina;
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

		this.setMostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esInicial);
		this.setMostrarProductoProduMaquinaTipoMaquinaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setMostrarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setMostrarProductoProduMaquinaTipoMaquinaEmpresa(esAsigna);
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

		this.setActivarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esInicial);
		this.setActivarProductoProduMaquinaTipoMaquinaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setActivarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setActivarProductoProduMaquinaTipoMaquinaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esInicial);
		this.setResaltarProductoProduMaquinaTipoMaquinaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setResaltarProductoOrdenDetaProduMaquinaTipoMaquinaEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setResaltarProductoProduMaquinaTipoMaquinaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableCreditoTipoMaquinaEmpresa=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoTipoMaquinaEmpresa() {
		return this.mostrarFK_IdCuentaContableCreditoTipoMaquinaEmpresa;
	}

	public void setMostrarFK_IdCuentaContableCreditoTipoMaquinaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoTipoMaquinaEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoTipoMaquinaEmpresa=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoTipoMaquinaEmpresa() {
		return this.mostrarFK_IdCuentaContableDebitoTipoMaquinaEmpresa;
	}

	public void setMostrarFK_IdCuentaContableDebitoTipoMaquinaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoTipoMaquinaEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoMaquinaEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoMaquinaEmpresa() {
		return this.mostrarFK_IdEmpresaTipoMaquinaEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoMaquinaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoMaquinaEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTipoMaquinaEmpresa=true;

	public Boolean getMostrarFK_IdSucursalTipoMaquinaEmpresa() {
		return this.mostrarFK_IdSucursalTipoMaquinaEmpresa;
	}

	public void setMostrarFK_IdSucursalTipoMaquinaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTipoMaquinaEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableCreditoTipoMaquinaEmpresa=true;

	public Boolean getActivarFK_IdCuentaContableCreditoTipoMaquinaEmpresa() {
		return this.activarFK_IdCuentaContableCreditoTipoMaquinaEmpresa;
	}

	public void setActivarFK_IdCuentaContableCreditoTipoMaquinaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoTipoMaquinaEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoTipoMaquinaEmpresa=true;

	public Boolean getActivarFK_IdCuentaContableDebitoTipoMaquinaEmpresa() {
		return this.activarFK_IdCuentaContableDebitoTipoMaquinaEmpresa;
	}

	public void setActivarFK_IdCuentaContableDebitoTipoMaquinaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoTipoMaquinaEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoMaquinaEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoMaquinaEmpresa() {
		return this.activarFK_IdEmpresaTipoMaquinaEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoMaquinaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoMaquinaEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTipoMaquinaEmpresa=true;

	public Boolean getActivarFK_IdSucursalTipoMaquinaEmpresa() {
		return this.activarFK_IdSucursalTipoMaquinaEmpresa;
	}

	public void setActivarFK_IdSucursalTipoMaquinaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTipoMaquinaEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa=null;

	public Border getResaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa() {
		return this.resaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa;
	}

	public void setResaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoTipoMaquinaEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa=null;

	public Border getResaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa() {
		return this.resaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa;
	}

	public void setResaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoTipoMaquinaEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoMaquinaEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoMaquinaEmpresa() {
		return this.resaltarFK_IdEmpresaTipoMaquinaEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoMaquinaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoMaquinaEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTipoMaquinaEmpresa=null;

	public Border getResaltarFK_IdSucursalTipoMaquinaEmpresa() {
		return this.resaltarFK_IdSucursalTipoMaquinaEmpresa;
	}

	public void setResaltarFK_IdSucursalTipoMaquinaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdSucursalTipoMaquinaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTipoMaquinaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMaquinaEmpresaBeanSwingJInternalFrame tipomaquinaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTipoMaquinaEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}